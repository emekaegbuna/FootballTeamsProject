package com.example.footballapi.view.teamDetail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.footballapi.R
import com.example.footballapi.common.imagine
import com.example.footballapi.model.teamDetail.TeamDetailModel
import com.example.footballapi.presenter.teamDetail.TeamPresenter
import com.example.footballapi.presenter.teamDetail.TeamView
import kotlinx.android.synthetic.main.activity_team_detail.*

class TeamDetailActivity : AppCompatActivity(), TeamView {

    override fun getInfo(): String {
        return getIntent().getStringExtra("teamid")
    }

    override fun showLoading() {

    }

    override fun showTeamDetailView(teamDetailModel: TeamDetailModel) {
        var idTeam = teamDetailModel.teams


        //Log.d("teamdetaile", idTeam.toString())
        tv_team_detail_name.text = idTeam[0].strLeague
        iv_teamdetail_logo.imagine(idTeam[0].strTeamLogo)
        iv_teamdetail_fanart.imagine(idTeam[0].strTeamFanart1)

    }



    var presenter = TeamPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_team_detail)

        presenter.onViewAttached(this)


    }
}
