package com.example.aulathreadcoroutines

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import java.io.IOException

class MainViewModel(val repository: Repository): ViewModel() {

    val res = MutableLiveData<String>()

    fun getFilmesRepo() {
        viewModelScope.launch {
            try {
                res.value = repository.getFilmes()
            } catch (ioException: IOException) {
                Log.i("MainViewModel", "Erro ao acessar o repository")
            }
        }
    }

}