package com.example.footballapi.view.footballTeams

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.footballapi.R
import com.example.footballapi.model.footballTeams.FootballTeamsModel
import com.example.footballapi.model.footballTeams.Teams
import com.example.footballapi.presenter.footballTeams.FootballPresenter
import com.example.footballapi.presenter.footballTeams.FootballView
import com.example.footballapi.view.teamDetail.TeamDetailActivity
import kotlinx.android.synthetic.main.activity_football_teams.*

class FootballTeamsActivity : AppCompatActivity(), FootballView {
    override fun showLoading() {

    }

    override fun showFootballView(footballTeamsModel: FootballTeamsModel) {

        var dash = footballTeamsModel.teams[0].strTeam

        Log.d("SUCCESS2>>>>>>>>", dash)

        var adapter: FootballAdapter =
            FootballAdapter(
                footballTeamsModel,
                object : OnClickItemListener {
                    override fun onClick(result: List<Teams>) {
                        var teamID = result[0].idTeam.toString()

                        //Log.d("oioioioioioioioioioioo", teamID)

                        doIntentStart(teamID)
                    }

                })

        rv_football_teams.layoutManager = LinearLayoutManager(this@FootballTeamsActivity)
        rv_football_teams.adapter = adapter



    }


    var presenter = FootballPresenter()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_football_teams)

        Log.d("FIRST>>>>>>>>>>>>>>", "00000000000000000000000")


        presenter.onViewAttached(this)

    }

    private fun doIntentStart(id: String){
        var intent = Intent(this, TeamDetailActivity:: class.java)
        intent.putExtra("teamid", id)
        startActivity(intent)
    }


}
