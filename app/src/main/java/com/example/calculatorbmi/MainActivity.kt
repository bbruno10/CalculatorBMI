package com.example.calculatorbmi

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val edtWeight = findViewById<TextInputEditText>(R.id.tie_weight)
        val edtHeight = findViewById<TextInputEditText>(R.id.tie_height)
        val button = findViewById<Button>(R.id.btn_calculator)

        button.setOnClickListener {

            val strWeight = edtWeight.text.toString()
            val strHeight = edtHeight.text.toString()

            if (strWeight == "" || strHeight == "") {
                Snackbar
                    .make(
                        edtWeight, "Please fill all fields", Snackbar.LENGTH_SHORT)
                    .show()
            }
            else {
                val weight = strWeight.toFloat()
                val height = strHeight.toFloat()

                val numero = height * height
                val numero2 = weight / numero
                val result = numero2

                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra("KEY_IMC", result)
                startActivity(intent)
            }
        }
    }
}