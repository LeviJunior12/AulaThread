package com.example.aulathreadcoroutines

import kotlinx.coroutines.delay

class Repository {

    suspend fun getFilmes(): String {
        delay(2000)
        return "Resultados"
    }
}