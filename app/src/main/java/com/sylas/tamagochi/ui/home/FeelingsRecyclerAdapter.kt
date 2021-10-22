package com.sylas.tamagochi.ui.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sylas.tamagochi.R
import com.sylas.tamagochi.model.FeelingsItem

class FeelingsRecyclerAdapter(val list:ArrayList<FeelingsItem>,val context:Context): RecyclerView.Adapter<FeelingsRecyclerAdapter.MyViewHolder>() {
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image:ImageView = itemView.findViewById(R.id.feelings_image)
        val feelingsText : TextView = itemView.findViewById(R.id.feelings_text)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val root = LayoutInflater.from(context).inflate(R.layout.feeelings_recycler_item,parent,false)
        return MyViewHolder(root)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        Glide.with(context).load(list[position].image).into(holder.image)
        holder.feelingsText.text = list[position].title
    }

    override fun getItemCount(): Int {
        return list.size
    }
}