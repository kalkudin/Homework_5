package com.example.homework5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.homework5.databinding.ActivityMain2Binding
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.UserProfileChangeRequest


class MainActivity_2 : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var binding: ActivityMain2Binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()



        binding.backButton.setOnClickListener() {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        binding.registerButtonNext.setOnClickListener() {
            val email = binding.emailTv.text.toString()
            val password = binding.passwordTv.text.toString()
            if (!email.isNullOrBlank() && !password.isNullOrBlank()) {
                firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
                    if (it.isSuccessful) {
                        binding.signUpPage.visibility = View.VISIBLE
                        binding.registerPage.visibility = View.GONE
                        Toast.makeText(this, "Account created :3", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
                    }
                }
            } else {
                Toast.makeText(this, "Please fill out all the fields", Toast.LENGTH_SHORT).show()
            }
        }

        binding.signUpButton.setOnClickListener(){
            val username = binding.signUpUsername.text.toString()

            if (!username.isNullOrBlank()) {
                val user = firebaseAuth.currentUser
                val profileUpdates = UserProfileChangeRequest.Builder().setDisplayName(username).build()
                user?.updateProfile(profileUpdates)?.addOnCompleteListener {
                    if (it.isSuccessful) {
                        val intent = Intent(this, MainActivity4::class.java)
                        startActivity(intent)
                    } else {
                        Toast.makeText(this, "Failed to set username", Toast.LENGTH_SHORT).show()
                    }
                }
            } else {
                Toast.makeText(this, "Please enter a username", Toast.LENGTH_SHORT).show()
            }
        }
    }
}