package com.example.footballapi.network.teamDetail

import com.example.footballapi.model.teamDetail.TeamDetailModel
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface TeamDetailInterface{
    @GET("lookupteam.php")
    fun getIdTeamModel(@Query("id") id: Int): Observable<TeamDetailModel>
}