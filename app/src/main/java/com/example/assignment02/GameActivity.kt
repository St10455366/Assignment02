package com.example.assignment02

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class GameActivity : AppCompatActivity() {
    private lateinit var pet: Pet
    private lateinit var hunger: TextView
    private lateinit var happy: TextView
    private lateinit var cleanliness: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_game)

        try {
            pet = Pet()
            //initialize pet

            hunger = findViewById(R.id.hunger)
            happy = findViewById(R.id.happy)
            cleanliness = findViewById(R.id.cleanliness)

            updateStatus()

            //finding button
            findViewById<Button>(R.id.feed).setOnClickListener { pet.feed(); updateStatus() }
            findViewById<Button>(R.id.clean).setOnClickListener { pet.clean(); updateStatus() }
            findViewById<Button>(R.id.play).setOnClickListener { pet.play(); updateStatus() }

            startTimer()

            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
                val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                insets
            }
        } catch (e: Exception) {
            Log.e("GameActivity", "Error in onCreate: ${e.message}")
            e.printStackTrace()
        }
    }

    private fun updateStatus() {
            hunger.text = "Hunger: ${pet.hunger}"
            cleanliness.text = "Cleanliness: ${pet.cleanliness}"
            happy.text = "Play: ${pet.happy}"
        }
    }
private fun startTimer() {
    GlobalScope.launch {
        while (true){
            with(pet) {
                decreaseHunger()
                decreaseCleanliness()
                decreaseHappy()
                updateStatus()
            }
            delay(1000)
        }
    }
}