package com.example.unittesting

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn3.setOnClickListener {
            Toast
                .makeText(
                    this,
                    "click",
                    Toast.LENGTH_SHORT
                )
                .show()
        }

    }
}