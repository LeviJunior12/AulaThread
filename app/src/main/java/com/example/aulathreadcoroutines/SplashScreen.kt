package com.example.aulathreadcoroutines

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashScreen : AppCompatActivity() {

    val scope = CoroutineScope(Dispatchers.Default)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        coroutines()

    }

    fun callMain() {
        var intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    fun coroutines() {
        scope.launch {
            delay(2000)
            callMain()
        }
    }

    fun thread() {
        Thread(Runnable {
            Thread.sleep(2000)
            runOnUiThread {
                callMain()
            }
        })
    }

}