package com.example.footballapi.network.teamDetail

import com.example.footballapi.common.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class TeamDetailRetrofitInstance {

    val teamRetrofitInstance: Retrofit
        get(){
            return Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
}