package com.example.aulathreadcoroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    val scope = CoroutineScope(Dispatchers.Main)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Simple Thread
        btnThread.setOnClickListener {
//            Thread.sleep(2000)
            Thread(Runnable {
                Thread.sleep(9000)
                runOnUiThread {
                    tvRes.text = "Clique Thread"
                }
            }).start()

        }

        btnHandle.setOnClickListener {
            Handler(Looper.getMainLooper()).postDelayed({
                tvRes.text = "Clique Handle"
            }, 8000)
        }

        btnCoroutines.setOnClickListener {
            scope.launch {
                delay(9000)
                tvRes.text = "Clique Coroutines"
            }
        }

    }
}