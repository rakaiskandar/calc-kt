package com.example.tipcalculator.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tipcalculator.R

class SuggestionAdapter : RecyclerView.Adapter<SuggestionAdapter.MyViewHolder>() {

    private val image = arrayOf(
        R.drawable.calc_suggestion1,
        R.drawable.calc_suggestion2,
        R.drawable.calc_suggestion3,
        R.drawable.calc_suggestion4,
        R.drawable.calc_suggestion5
    )

    private val titleImage = arrayOf(
        "Basic Calculator",
        "Tip Calculator",
        "BMI Calculator",
        "Long Calculator",
        "Area Calculator"
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.card_view2, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.image.setImageResource(image[position])
        holder.title.text = titleImage[position]
    }

    override fun getItemCount(): Int {
        return image.size
    }

    inner class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        var image : ImageView
        var title : TextView

        init {
            image = itemView.findViewById(R.id.imageSuggestion)
            title = itemView.findViewById(R.id.textSuggestion)
        }
    }

}
