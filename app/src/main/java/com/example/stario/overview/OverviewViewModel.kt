package com.example.stario.overview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.stario.network.StarAPI
import com.example.stario.network.StarFilm
import kotlinx.coroutines.launch

class OverviewViewModel : ViewModel() {
    private val _status = MutableLiveData<String>()
    private val _films = MutableLiveData<List<StarFilm>>()


    val films: LiveData<List<StarFilm>> = _films
    val status: LiveData<String> = _status

    init {
        getStarFilms()
    }

    //Launch the fun, if the fun works normally try will be executed, else the catch exception will be shown
    private fun getStarFilms() {
        viewModelScope.launch {
            try {
                _films.value = StarAPI.retrofitService.getFilms()
                _status.value = "Succes"
            } catch (e: Exception) {
                _status.value = "Fail ${e.message}"
            }
        }
    }
}