package com.example.projetandroid_kotlin_4a.presentation.list

import com.example.projetandroid_kotlin_4a.domain.entity.Champion
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("/TFT.json")
    fun fetchAllUsers(): Call<List<Champion>>
}