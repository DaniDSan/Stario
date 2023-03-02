package com.example.stario.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

//Base Url that we use to do a request to the browser
private const val BASE_URL = "https://swapi.dev/api/"

//Moshi and Retrofit to recive a JSON from the browser and parse it
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()
private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

//The final part the we add to the BASE_URL to acces a specific request
interface StarAPIService {
    @GET("films")
    suspend fun getFilms(): List<StarFilm>
}

//Launch the fun only when we need it
object StarAPI {
    val retrofitService = retrofit.create(StarAPIService::class.java)
}
