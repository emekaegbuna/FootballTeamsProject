package com.example.footballapi.network.teamDetail

import com.example.footballapi.common.Constants
import com.example.footballapi.common.crunch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class TeamDetailRetrofitInstance {

    var reture = Retrofit.Builder()

    var dlkd = reture.crunch(Constants.BASE_URL)
    val teamRetrofitInstance: Retrofit
        get(){
            return dlkd
        }
}