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
    private var timeElapsed = 0L
    private val KEY_TIME_ELAPSED = "elapsed time"

    // in kotlin, if a data type can be null, you have to specify that with a ?
    // Bundle? is a nullable Bundle; it could have a null value
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // ?. builds an if not null
        // if(savedInstanceState != null)
        // ?: is the elvis operator
        // what comes after is the default value if what comes before is null
        timeElapsed = savedInstanceState?.getLong(KEY_TIME_ELAPSED) ?: 0L

        chronometer_main_timer.base = SystemClock.elapsedRealtime() - timeElapsed
        chronometer_main_timer.start()
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart has been called")

        chronometer_main_timer.start()
        chronometer_main_timer.base = SystemClock.elapsedRealtime()
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

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d(TAG, "onSavedInstanceState has been called")
        // in the Bundle, data is stored in key-value pairs
        // lots of key-value pairs here:
        // JSON = javascript object notation (very commonly used for data storage online)
        // key: TCPIP or like a name tag you associate with the data
        // value: the actual data being stored

        // TODO: 0. get the timer to start and stop
        // TODO: 1. calculate the timeElapsed before saving the value
        // ????? timeElapsed = SystemClock.elapsedRealtime()

        // TODO: 2. get the rotation to work properly regardless of whether the timer is stopped
        outState.putLong(KEY_TIME_ELAPSED, timeElapsed)
    }
}