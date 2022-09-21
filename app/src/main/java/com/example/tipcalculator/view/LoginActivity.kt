package com.example.tipcalculator.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.tipcalculator.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()

        binding.btnLogin.setOnClickListener {
            login()
        }

        binding.textViewRegister.setOnClickListener{
            startActivity(Intent(this, RegisterActivity::class.java))
            finish()
        }
    }

    private fun login(){
        binding.progressBarLogin.visibility = View.VISIBLE

        val email = binding.email.text.toString()
        val password = binding.password.text.toString()

        if (email.isBlank() || password.isBlank()){
            Toast.makeText(this, "Email and password can't blank", Toast.LENGTH_SHORT).show()
            binding.progressBarLogin.visibility = View.GONE
            return
        }

        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this) {
            if (it.isSuccessful){
                Toast.makeText(this,"Login successful!!", Toast.LENGTH_SHORT).show()
                binding.progressBarLogin.visibility = View.GONE
                startActivity(Intent(this, Main::class.java))
            }else{
                Toast.makeText(this,"Login failed!!", Toast.LENGTH_SHORT).show()
                binding.progressBarLogin.visibility = View.GONE
            }
        }
    }

    override fun onStart() {
        super.onStart()
        val currentUser = auth.currentUser
        if (currentUser != null){
            startActivity(Intent(this, Main::class.java))
        }
    }

}