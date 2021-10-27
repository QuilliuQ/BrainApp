package com.sylas.tamagochi.ui.music.fragments

import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.sylas.tamagochi.R
import com.sylas.tamagochi.Utils

class NewFragment : Fragment(R.layout.new_musicfragment) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val list = arrayListOf<MusicItem>()
            Utils.list.map {
            if(it.new!!)
                {list.add(it)
            }
        }
        val viewPager2: ViewPager2 = view.findViewById(R.id.view_pager2)
        viewPager2.adapter = NewMusicRecyclerAdapter(requireContext(),list)
        val play : ImageView = view.findViewById(R.id.play_music)
        val skipNext: ImageView = view.findViewById(R.id.skip_next)
        val skipPrevious : ImageView = view.findViewById(R.id.skip_previous)
        val mediaPlayer = MediaPlayer.create(requireContext(),list[0].music)


        viewPager2.registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                skipPrevious.isClickable = position != 0
                skipNext.isClickable= position != list.size-1



            }
        })
        play.setOnClickListener {
            if(mediaPlayer.isPlaying){
                mediaPlayer.stop()
                play.setImageResource(R.drawable.ic_baseline_play_arrow_24)
            }
            else{
                mediaPlayer.start()
                play.setImageResource(R.drawable.ic_baseline_pause_24)
            }
        }

        skipNext.setOnClickListener {
            viewPager2.currentItem++
        }
        skipPrevious.setOnClickListener {
            viewPager2.currentItem--
        }

    }
}