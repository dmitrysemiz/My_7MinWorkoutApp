package com.example.my_7minworkoutapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import android.widget.Toast
import com.example.my_7minworkoutapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var binding:ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        
        var flStart: FrameLayout? = binding?.flStart
        
        flStart?.setOnClickListener {
            //Toast.makeText(this, "Clicked", Toast.LENGTH_SHORT).show()
            val intent = Intent(this,ExerciseActivity::class.java)
            startActivity(intent)
        }
    }
}