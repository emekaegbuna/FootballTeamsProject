package com.example.footballapi.presenter.footballTeams

import android.util.Log
import com.example.footballapi.common.Constants
import com.example.footballapi.common.enqueue
import com.example.footballapi.model.footballTeams.FootballTeamsModel
import com.example.footballapi.network.footballTeams.FootballTeamsInterface
import com.example.footballapi.network.footballTeams.FootballTeamsRetrofitInstance
import com.example.footballapi.presenter.BasePresenter

class FootballPresenter: BasePresenter<FootballView>() {

    override fun onViewAttached(view: FootballView) {
        super.onViewAttached(view)

        var retro = FootballTeamsRetrofitInstance().footballRetrofitInstance.create(FootballTeamsInterface::class.java)
        var call = retro.getFootballModel(Constants.LEAGUE)

        Log.d("0000000001102020", "this is working")

        call.enqueue {
            onFailure = {
                it -> Log.d("THE ERROR IS >>>>>>>", it.toString())
            }

            onResponse = {
                it -> var resp: FootballTeamsModel? = it.body()

                Log.d("89878868686868", "this is working again......")

                view.showFootballView(resp!!)
            }
        }

/*        call.enqueue(object : Callback<FootballTeamsModel>{
            override fun onFailure(call: Call<FootballTeamsModel>, t: Throwable) {
                Log.d("THE ERROR IS >>>>>>>", t.message)
            }

            override fun onResponse(call: Call<FootballTeamsModel>, response: Response<FootballTeamsModel>) {
                var resp: FootballTeamsModel? = response.body()

                Log.d("89878868686868", "this is working again......")

                view.showFootballView(resp!!)
            }

        })*/

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

interface FootballView: BasePresenter.View{

    fun showLoading()
    fun showFootballView(footballTeamsModel: FootballTeamsModel)
}