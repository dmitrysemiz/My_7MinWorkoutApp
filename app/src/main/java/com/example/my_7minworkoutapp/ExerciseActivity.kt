package com.example.my_7minworkoutapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Toast
import com.example.my_7minworkoutapp.databinding.ActivityExerciseBinding

class ExerciseActivity : AppCompatActivity() {
    private var binding:ActivityExerciseBinding? = null

    private var restTimer: CountDownTimer? = null
    private var restProgress: Int = 0
    private var restTime: Int = 10 //must match value android:max="" in xml

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExerciseBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        //Enabling toolbar on top, and a back arrow-button
        setSupportActionBar(binding?.toolbarExercise)
        binding?.toolbarExercise?.setNavigationOnClickListener {
            onBackPressed()
        }
        if(supportActionBar != null){
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        }
        //Enabling toolbar on top, and a back arrow-button

        setRestProgressBar()
    }

    private fun setRestProgressBar(){
        binding?.progressBar?.progress = restProgress

        restTimer = object : CountDownTimer(restTime.toLong()*1000,1000){
            override fun onTick(millisUntilFinished: Long) {
                restProgress++
                binding?.progressBar?.progress = restTime - restProgress
                binding?.tvTimer?.text = (restTime - restProgress).toString()
            }

            override fun onFinish() {
                Toast.makeText(applicationContext, "Start Exercise", Toast.LENGTH_SHORT).show()
            }
        }.start()
    }

    override fun onDestroy() {
        super.onDestroy()
        if(restTimer != null){
            restTimer!!.cancel()
            restProgress = 0
        }
        binding = null
    }
}