package com.example.homework5
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.homework5.databinding.ActivityMain3Binding
import com.google.firebase.auth.FirebaseAuth


class MainActivity_3 : AppCompatActivity() {

    private lateinit var binding:ActivityMain3Binding
    private lateinit var firebaseAuth:FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding:ActivityMain3Binding = ActivityMain3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()

        binding.backButton.setOnClickListener(){
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        binding.loginButtonNext.setOnClickListener(){
            val email = binding.userEmail.text.toString()
            val password = binding.userPassword.text.toString()
            if(!email.isNullOrBlank() && !password.isNullOrBlank()){
                firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(){
                    if(it.isSuccessful){
                        val intent = Intent(this, MainActivity4::class.java)
                        startActivity(intent)
                    }
                    else {
                        Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
                    }
                }
            }else{
                Toast.makeText(this, "Please fill out all fields", Toast.LENGTH_SHORT).show()
            }
        }
    }
}