package com.sylas.tamagochi.ui.music.fragments

import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.sylas.tamagochi.R

class BestFragment : Fragment(R.layout.best_musicfragment) {

    var playing : Boolean = false
    val currentSong : Int = 0
    val list: ArrayList<MusicItem> = arrayListOf(
        MusicItem("Queen","My Favourite Name",R.drawable.music1,R.raw.songone),
        MusicItem("Scorpions","My Favourite Name",R.drawable.musictwo,R.raw.songtwo,liked = true),
        MusicItem("Linkin Park","My Favourite Name",R.drawable.musicthree,R.raw.songone),
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewPager2: ViewPager2 = view.findViewById(R.id.view_pager2)
        viewPager2.adapter = NewMusicRecyclerAdapter(requireContext(),list)
        val mediaPlayer = MediaPlayer.create(requireContext(),list[currentSong].music)
        val play : ImageView = view.findViewById(R.id.play_music)
        play.setOnClickListener {
            if(playing){
                playing = false
                mediaPlayer.stop()
                play.setImageResource(R.drawable.ic_baseline_play_arrow_24)
            }
            else{
                playing = true
                mediaPlayer.start()
                play.setImageResource(R.drawable.ic_baseline_pause_24)
            }
        }
        val skipNext: ImageView = view.findViewById(R.id.skip_next)
        skipNext.setOnClickListener {
        }
    }
}