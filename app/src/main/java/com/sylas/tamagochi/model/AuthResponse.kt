package com.sylas.tamagochi.model

data class AuthResponse(
    val id: String,
    val email: String,
    val avatar: String,
    val token: String,
    val nickName:String
)
