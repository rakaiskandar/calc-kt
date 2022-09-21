package com.example.tipcalculator.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.tipcalculator.databinding.ActivityRegisterBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = Firebase.auth
        binding.navigateBack.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }

        binding.btnCreate.setOnClickListener{
            signUp()
        }

    }

    private fun signUp(){

        binding.progressBar.visibility = View.VISIBLE

        val email = binding.emailField.text.toString()
        val password = binding.passwordField.text.toString()
        val confirmPass = binding.confirmPass.text.toString()

        if (email.isBlank() || password.isBlank() || confirmPass.isBlank()){
            Toast.makeText(this, "Email and password can't blank", Toast.LENGTH_SHORT).show()
            binding.progressBar.visibility = View.GONE
            return
        }

        if (password != confirmPass){
            Toast.makeText(this, "Password and Confirm Password do not match", Toast.LENGTH_SHORT).show()
            binding.progressBar.visibility = View.GONE
            return
        }

        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this){
            if (it.isSuccessful){
                Toast.makeText(this, "Successfully Sign Up", Toast.LENGTH_SHORT).show()
                binding.progressBar.visibility = View.GONE
                startActivity(Intent(this, Main::class.java))
            }else{
                Toast.makeText(this, "Failed Sign Up", Toast.LENGTH_SHORT).show()
                binding.progressBar.visibility = View.GONE
            }
        }
    }
}