package com.example.tipcalculator.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.tipcalculator.databinding.ActivityProfileBinding
import com.example.tipcalculator.view.LoginActivity
import com.google.firebase.auth.FirebaseAuth

class ProfileFragment : Fragment() {
    private lateinit var auth: FirebaseAuth
    private var _binding: ActivityProfileBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ActivityProfileBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        auth = FirebaseAuth.getInstance()

        val user = auth.currentUser
        val email = user?.email
        binding.currentEmail.text = email

        binding.btnResetPass.setOnClickListener {
            if (user != null){
                auth.sendPasswordResetEmail(email!!).addOnCompleteListener { task ->
                    if(task.isSuccessful){
                       Toast.makeText(activity, "Berhasil reset password", Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(activity, "Gagal reset password", Toast.LENGTH_SHORT).show()
                    }
                }
            }else{
                Toast.makeText(activity, "Error", Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnLogout.setOnClickListener {
            if (user != null){
                auth.signOut().also {
                    startActivity(Intent(activity, LoginActivity::class.java))
                    Toast.makeText(activity, "Berhasil Logout", Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(activity, "Gagal Logout", Toast.LENGTH_SHORT).show()
            }
        }
    }

}
