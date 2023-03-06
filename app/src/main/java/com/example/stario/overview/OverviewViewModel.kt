package com.example.stario.overview

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.stario.IMainActivity
import com.example.stario.network.Planet
import com.example.stario.network.PlanetAPI
import kotlinx.coroutines.launch

class OverviewViewModel (
    private val activity: IMainActivity
        ) : ViewModel() {

    fun getPlanets() {
        viewModelScope.launch {
            try {
                activity.updateList(
                    PlanetAPI.retrofitService.getPlanets().subList(0, 8)
                )
            } catch (e: Exception) {
                e.message
                println(e.message)
            }
        }
    }
}