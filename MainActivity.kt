package com.example.imad_practicum

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnEnter = findViewById<Button>(R.id.btnEnter)
        val btnExit = findViewById<Button>(R.id.btnExit)

        btnEnter.setOnClickListener {

        }
    }
}