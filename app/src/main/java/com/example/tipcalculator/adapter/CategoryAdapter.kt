package com.example.tipcalculator.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tipcalculator.R

class CategoryAdapter : RecyclerView.Adapter<CategoryAdapter.MyViewHolder>(){

    private val category = arrayOf(
    "Basic",
    "Tip",
    "BMI",
    "Long",
    "Area"
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.card_view1, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.category.text = category[position]
    }

    override fun getItemCount(): Int {
        return category.size
    }

    inner class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        var category : TextView

        init {
            category = itemView.findViewById(R.id.category)
        }
    }
}