package com.example.my_7minworkoutapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import com.example.my_7minworkoutapp.databinding.ActivityExerciseBinding

class ExerciseActivity : AppCompatActivity() {
    private var binding:ActivityExerciseBinding? = null

    private var restTimer: CountDownTimer? = null
    private var restProgress: Int = 0
    private var restTime: Int = 5 //must match value android:max="" in xml

    private var exerciseTimer: CountDownTimer? = null
    private var exerciseProgress: Int = 0
    private var exerciseTime: Int = 5 //must match value android:max="" in xml

    private var exerciseList: ArrayList<ExerciseModel>? = null
    private var exercisePosition = -1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExerciseBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        //initialize exercise list
        exerciseList = Constants.defaultExerciseList()
        //initialize exercise list

        //Enabling toolbar on top, and a back arrow-button
        setSupportActionBar(binding?.toolbarExercise)
        binding?.toolbarExercise?.setNavigationOnClickListener {
            onBackPressed()
        }
        if(supportActionBar != null){
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        }
        //Enabling toolbar on top, and a back arrow-button
        setRestView()
    }

    private fun setRestView(){
        binding?.flRestView?.visibility = View.VISIBLE
        binding?.flExerciseView?.visibility = View.GONE
        binding?.ivExercise?.visibility = View.GONE
        if(restTimer != null){
            restTimer!!.cancel()
            restProgress = 0
        }
        var nextExercise = exerciseList!![exercisePosition+1].getName()
        binding?.tvLabel?.text = "Rest"
        setRestProgressBar()
        exercisePosition++
    }

    private fun setExerciseView(){
        binding?.flRestView?.visibility = View.GONE
        binding?.flExerciseView?.visibility = View.VISIBLE
        binding?.ivExercise?.visibility = View.VISIBLE
        if(exerciseTimer != null){
            exerciseTimer!!.cancel()
            exerciseProgress = 0
        }
        binding?.ivExercise?.setImageResource(exerciseList!![exercisePosition].getImage())
        binding?.tvLabel?.text = exerciseList!![exercisePosition].getName()
        setExerciseProgressBar()
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
                setExerciseView()
            }
        }.start()
    }

    private fun setExerciseProgressBar(){
        binding?.progressBarExercise?.progress = exerciseProgress

        exerciseTimer = object : CountDownTimer(exerciseTime.toLong()*1000,1000){
            override fun onTick(millisUntilFinished: Long) {
                exerciseProgress++
                binding?.progressBarExercise?.progress = exerciseTime - exerciseProgress
                binding?.tvTimerExercise?.text = (exerciseTime - exerciseProgress).toString()
            }
            override fun onFinish() {
                setRestView()
            }
        }.start()
    }

    override fun onDestroy() {
        super.onDestroy()
        if(restTimer != null){
            restTimer!!.cancel()
            restProgress = 0
        }
        if(exerciseTimer != null){
            exerciseTimer!!.cancel()
            exerciseProgress = 0
        }
        binding = null
    }
}