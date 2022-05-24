package com.example.unittesting

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.unittesting.databinding.ActivityMainBinding
import com.example.unittesting.storage.Repository
import kotlinx.coroutines.runBlocking

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.inflate(
            LayoutInflater.from(this),
            R.layout.activity_main,
            null,
            false
        )

        setContentView(binding.root)

        binding.btn3.setOnClickListener {
            Toast.makeText(this, "click", Toast.LENGTH_LONG).show()
        }

        val repo = Repository(this@MainActivity)

        runBlocking {
            for (r in repo.getData())
                Log.d("data", "${r.name}, ${r.email}, ${r.id}")
        }
    }
}