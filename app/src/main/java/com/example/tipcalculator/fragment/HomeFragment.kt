package com.example.tipcalculator.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tipcalculator.adapter.CategoryAdapter
import com.example.tipcalculator.adapter.SuggestionAdapter
import com.example.tipcalculator.databinding.ActivityHomeBinding
import com.google.firebase.auth.FirebaseAuth

class HomeFragment : Fragment() {
    private lateinit var auth: FirebaseAuth
    private var _binding: ActivityHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ActivityHomeBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        auth = FirebaseAuth.getInstance()

        val user = auth.currentUser
        binding.textViewHome4.text = user?.email

        val category = binding.recyview1
        val suggestion = binding.recyview2

        category.apply {
            layoutManager = LinearLayoutManager(activity, RecyclerView.HORIZONTAL, false)
            adapter = CategoryAdapter()
        }

        suggestion.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = SuggestionAdapter()
        }

    }

}