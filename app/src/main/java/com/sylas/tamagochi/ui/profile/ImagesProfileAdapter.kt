package com.sylas.tamagochi.ui.profile

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sylas.tamagochi.CurrentImageActivity
import com.sylas.tamagochi.R

class ImagesProfileAdapter(val list: ArrayList<ImageProfileItem>,val context:Context ): RecyclerView.Adapter<ImagesProfileAdapter.MyViewHolder>() {
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image:ImageView = itemView.findViewById(R.id.image_list)
        val time: TextView = itemView.findViewById(R.id.time_list)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val root = LayoutInflater.from(context).inflate(R.layout.images_recycler_item,parent,false)
        return MyViewHolder(root)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
       if(list.lastIndex<position)
       {
           holder.image.setImageResource(R.drawable.placeholderimage)
           holder.time.text = ""
           holder.image.setOnClickListener {
               AlertDialog.Builder(context)
                   .setTitle("Выберите дейтвие")
                   .setMessage("Откуда вы хотите загрузить фотографию")
                   .setPositiveButton("OK",null)
                   .create()
                   .show()
           }
       }
       else
       {
           holder.image.setImageResource(list[position].image)
           holder.time.text = list[position].time
           holder.image.setOnClickListener {
               val intent = Intent(context,CurrentImageActivity::class.java)
               intent.putExtra("imageId",list[position].image)
               context.startActivity(intent)
           }
       }
    }

    override fun getItemCount(): Int {
       return list.size+1
    }
}