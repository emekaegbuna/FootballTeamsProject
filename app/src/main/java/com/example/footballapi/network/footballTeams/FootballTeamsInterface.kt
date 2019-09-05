package com.example.footballapi.network.footballTeams

import com.example.footballapi.model.footballTeams.FootballTeamsModel
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface FootballTeamsInterface {


    //https://www.thesportsdb.com/api/v1/json/1/search_all_teams.php?l=English%20Premier%20League
    @GET("search_all_teams.php")
    fun getFootballModel(@Query("l") league: String): Observable<FootballTeamsModel>
}