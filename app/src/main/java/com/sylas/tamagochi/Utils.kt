package com.sylas.tamagochi

import com.sylas.tamagochi.ui.music.fragments.MusicItem

object Utils {
    val list: ArrayList<MusicItem> = arrayListOf(
        MusicItem("Queen","My Favourite Name",R.drawable.music1,R.raw.songone,new = true),
        MusicItem("Scorpions","My Favourite Name",R.drawable.musictwo,R.raw.songtwo, liked = true),
        MusicItem("Linkin Park","My Favourite Name",R.drawable.musicthree,R.raw.songone),
        MusicItem("Чайф","My Favourite Name",R.drawable.music1,R.raw.songone),
        MusicItem("Земляне","My Favourite Name",R.drawable.musictwo,R.raw.songtwo, liked = true),
        MusicItem("Ария","My Favourite Name",R.drawable.musicthree,R.raw.songone,new = true),
        MusicItem("System of a Down","My Favourite Name",R.drawable.music1,R.raw.songone),
        MusicItem("Skrillex","My Favourite Name",R.drawable.musictwo,R.raw.songtwo, liked = true),
        MusicItem("South Park","My Favourite Name",R.drawable.musicthree,R.raw.songone),
        MusicItem("Aquamen","My Favourite Name",R.drawable.music1,R.raw.songone,new = true),
        MusicItem("Spider-Man","My Favourite Name",R.drawable.musictwo,R.raw.songtwo,new = true, liked = true),
        MusicItem("SOAD","My Favourite Name",R.drawable.musicthree,R.raw.songone),
        MusicItem("Nensi","My Favourite Name",R.drawable.music1,R.raw.songone),
        MusicItem("Mamba","My Favourite Name",R.drawable.musictwo,R.raw.songtwo, liked = true),
    )

}