package com.example.tipcalculator.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tipcalculator.R
import com.example.tipcalculator.databinding.ActivityCalc1Binding
import java.text.NumberFormat

class TipCalculator : AppCompatActivity() {
    private lateinit var binding: ActivityCalc1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCalc1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        if(supportActionBar != null){
            supportActionBar!!.title = "Tip Calculator"
        }

        binding.button.setOnClickListener{
            calculateTip()
        }
    }

    private fun calculateTip(){
        val stringInTextField = binding.textEdit.text.toString()
        val cost = stringInTextField.toDouble()
        val tipPercent = when(binding.tipOption.checkedRadioButtonId){
            R.id.tip_option_20 -> 0.20
            R.id.tip_option_18 -> 0.18
            else -> 0.15
        }

        var tip = cost * tipPercent
        val roundUp = binding.roundUpSwitch.isChecked
        if (roundUp){
            tip = kotlin.math.ceil(tip)
        }

        val formattedTip = NumberFormat.getCurrencyInstance().format(tip)
        binding.tipResult.text = getString(R.string.tip_amount, formattedTip)
    }
}