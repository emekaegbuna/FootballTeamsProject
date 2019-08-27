package com.example.footballapi.presenter.teamDetail

import android.util.Log
import com.example.footballapi.common.enqueue
import com.example.footballapi.model.teamDetail.TeamDetailModel
import com.example.footballapi.network.teamDetail.TeamDetailInterface
import com.example.footballapi.network.teamDetail.TeamDetailRetrofitInstance
import com.example.footballapi.presenter.BasePresenter

class TeamPresenter: BasePresenter<TeamView>() {

    override fun onViewAttached(view: TeamView) {
        super.onViewAttached(view)

        var teamId = view.getInfo().toInt()
        Log.d("hhhhhhhhhhhhhhhhhhh", teamId.toString())

        var retro = TeamDetailRetrofitInstance().teamRetrofitInstance.create(TeamDetailInterface::class.java)
        var call = retro.getIdTeamModel(teamId)

        //Log.d("0000000001102020", "this is working")

        call.enqueue {
            onFailure = {

            }

            onResponse = {
                response -> var resp:TeamDetailModel? = response.body()

                Log.d("this is onResponse mess", " this is onResponse message")

                view.showTeamDetailView(resp!!)
            }
        }


//        call.enqueue(object : Callback<FootballTeamsModel>{
//            override fun onFailure(call: Call<FootballTeamsModel>, t: Throwable) {
//                Log.d("FAILURE1>>>>>>", t.message)
//            }
//
//            override fun onResponse(call: Call<FootballTeamsModel>, response: Response<FootballTeamsModel>) {
//
//                var respo: FootballTeamsModel? = response.body()
//
//                Log.d("SUCCESS1>>>>>>", respo!!.teams[0].strTeam)
//
//                view.showFootballView(respo)
//
//
//            }
//
//        })



    }



}

interface TeamView: BasePresenter.View{

    fun showLoading()
    fun showTeamDetailView(teamDetailModel: TeamDetailModel)
    fun getInfo(): String
}