package com.example.my_7minworkoutapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.my_7minworkoutapp.databinding.ActivityExerciseBinding

class ExerciseActivity : AppCompatActivity() {

    private var binding:ActivityExerciseBinding? = null
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
    }
}