package com.example.homework5
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.homework5.databinding.ActivityMain2Binding


class MainActivity_2:AppCompatActivity() {

    private lateinit var binding:ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding:ActivityMain2Binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.backButton.setOnClickListener(){
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        binding.registerButtonNext.setOnClickListener(){
            binding.signUpPage.visibility = View.VISIBLE
            binding.registerPage.visibility = View.GONE
        }

    }
}