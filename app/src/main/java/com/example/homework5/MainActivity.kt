package com.example.homework5
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.homework5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding: ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.registerButton.setOnClickListener(){
            val intent = Intent(this, MainActivity_2::class.java)
            startActivity(intent)
        }

        binding.loginButton.setOnClickListener(){
            val intent = Intent(this, MainActivity_3::class.java)
            startActivity(intent)
        }


    }
}