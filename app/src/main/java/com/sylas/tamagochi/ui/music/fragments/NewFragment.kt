package com.sylas.tamagochi.ui.music.fragments

import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.sylas.tamagochi.R

class NewFragment : Fragment(R.layout.new_musicfragment) {

    var playing : Boolean = false
    val currentSong : Int = 0
    val list: ArrayList<MusicItem> = arrayListOf(
        MusicItem("Queen","My Favourite Name",R.drawable.music1,R.raw.songone),
        MusicItem("Scorpions","My Favourite Name",R.drawable.musictwo,R.raw.songtwo, liked = true),
        MusicItem("Linkin Park","My Favourite Name",R.drawable.musicthree,R.raw.songone)
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recylcer: RecyclerView = view.findViewById(R.id.music_recycler)
        recylcer.adapter = NewMusicRecyclerAdapter(requireContext(), list)
    }
}