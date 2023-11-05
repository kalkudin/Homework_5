package com.example.homework5
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.homework5.databinding.ActivityMain3Binding


class MainActivity_3 : AppCompatActivity() {

    private lateinit var binding:ActivityMain3Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding:ActivityMain3Binding = ActivityMain3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.backButton.setOnClickListener(){
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}