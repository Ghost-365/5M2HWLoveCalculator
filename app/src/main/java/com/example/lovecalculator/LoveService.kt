package com.example.lovecalculator

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class LoveService {

    private val retrofit = Retrofit.Builder().baseUrl("https://love-calculator.p.rapidapi.com")
        .addConverterFactory(GsonConverterFactory.create()).build()

    val api = retrofit.create(LoveApi::class.java)
}