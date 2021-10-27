package com.sylas.tamagochi.ui.home

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.FitCenter
import com.sylas.tamagochi.CurrentQuotesActivity
import com.sylas.tamagochi.R
import com.sylas.tamagochi.model.QuotesItem
import org.w3c.dom.Text

class QuotesRecyclerAdapter(val context:Context,val list:ArrayList<QuotesItem>): RecyclerView.Adapter<QuotesRecyclerAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title:TextView = itemView.findViewById(R.id.title_quotes)
        val description:TextView = itemView.findViewById(R.id.description_quotes)
        val image:ImageView = itemView.findViewById(R.id.image_quotes)
        val moreButton: Button = itemView.findViewById(R.id.more)
     }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val root = LayoutInflater.from(context).inflate(R.layout.state_recycler_item,parent,false)
        return ViewHolder(root)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title.text = list[position].title
        holder.description.text = list[position].description
        Glide.with(context).load(list[position].image).transform(FitCenter()).into(holder.image)
        holder.moreButton.setOnClickListener {
            val intent = Intent(context,CurrentQuotesActivity::class.java)
            intent.putExtra("title",list[position].title)
            intent.putExtra("image",list[position].image)
            intent.putExtra("description",list[position].description)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}