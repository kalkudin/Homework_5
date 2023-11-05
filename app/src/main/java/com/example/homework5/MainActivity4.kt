package com.example.homework5
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import com.example.homework5.databinding.ActivityMain4Binding
import android.os.Bundle
import com.example.homework5.databinding.ActivityMain3Binding

class MainActivity4 : AppCompatActivity() {

    private lateinit var binding: ActivityMain4Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        var binding: ActivityMain4Binding = ActivityMain4Binding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.signOutButton.setOnClickListener(){

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

        }
    }
}