package com.sylas.tamagochi.ui.music.fragments

data class MusicItem(
    val artistName: String,
    val songName: String,
    val poster: Int,
    val music: Int,
    var liked: Boolean? = false,
    var new: Boolean? = false,

)
