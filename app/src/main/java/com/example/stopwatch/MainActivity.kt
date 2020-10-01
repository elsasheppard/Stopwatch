package com.example.stopwatch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.SystemClock
import android.util.Log
import android.widget.Chronometer
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    // TODO: override all necessary lifecycle methods in order

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart has been called")

        chronometer_main_timer.start()
        chronometer_main_timer.base = SystemClock.elapsedRealtime()
        button_main_start.setText(SystemClock.elapsedRealtime().toString())
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart has been called")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume has been called")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause has been called")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop has been called")

        chronometer_main_timer.stop()
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy has been called")
    }


}