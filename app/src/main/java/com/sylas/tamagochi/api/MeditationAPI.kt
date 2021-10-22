package com.sylas.tamagochi.api

import com.sylas.tamagochi.model.AuthResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface MeditationAPI {

    @POST("user/login")
    fun getAuth(@Body hashMap: HashMap<String,String>) : Call<AuthResponse>



}