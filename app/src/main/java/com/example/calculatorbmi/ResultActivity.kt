package com.example.calculatorbmi

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

const val KEY_IMC = "KEY_IMC"

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)

        val result = intent.getFloatExtra(KEY_IMC,0f)

        val tvResult = findViewById<TextView>(R.id.tv_result)
        val tvClassification = findViewById<TextView>(R.id.tv_classification)

        tvResult.text = result.toString()

        val classification: String = if (result <= 18.5f) {
            "Thinness"
        }
        else if (result > 18.5f && result <= 24.9f) {
            "Normal"
        }
        else if (result > 25 && result <= 29.9f) {
            "Overweight"
        }
        else if (result > 30 && result <= 39.9f) {
            "Obese"
        }
        else {
            "Extremely Obese"
        }

        tvClassification.text = classification

        val btnAgain = findViewById<Button>(R.id.btn_again)

        btnAgain.setOnClickListener {
            finish()
        }

    }
}