package com.sylas.tamagochi.ui.music.fragments

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.sylas.tamagochi.R

class NewMusicRecyclerAdapter(val context: Context,val list: List<MusicItem>): RecyclerView.Adapter<NewMusicRecyclerAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val artistName:TextView = itemView.findViewById(R.id.artist)
        val songName: TextView = itemView.findViewById(R.id.song)
        val poster : ImageView = itemView.findViewById(R.id.poster)
        val like: ImageView = itemView.findViewById(R.id.like)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val root = LayoutInflater.from(context).inflate(R.layout.music_recylcer_item,parent,false)
        return ViewHolder(root)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.artistName.text = list[position].artistName
        holder.songName.text = list[position].songName
        Glide.with(context).load(list[position].poster).transform(CenterCrop(),RoundedCorners(15)).into(holder.poster)
        if(list[position].liked!!){
            holder.like.setImageResource(R.drawable.ic_baseline_favorite_24)
        }
        else{
            holder.like.setImageResource(R.drawable.ic_baseline_favorite_border_24)
        }
        holder.like.setOnClickListener {
            if(list[position].liked!!){
                list[position].liked = false
                holder.like.setImageResource(R.drawable.ic_baseline_favorite_border_24)
            }
            else{
                list[position].liked = true
                holder.like.setImageResource(R.drawable.ic_baseline_favorite_24)
            }
        }

    }

    override fun getItemCount(): Int {
        return list.size
    }
}