package com.example.footballapi.view.footballTeams

import android.util.Log
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.footballapi.R
import com.example.footballapi.common.imagine
import com.example.footballapi.common.inflatee
import com.example.footballapi.model.footballTeams.FootballTeamsModel
import com.example.footballapi.model.footballTeams.Teams
import kotlinx.android.synthetic.main.card_view_football_teams.view.*

class FootballAdapter(private val footballTeamsModel: FootballTeamsModel, private val onClickItemListener: OnClickItemListener): RecyclerView.Adapter<FootballViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FootballViewHolder {

        return FootballViewHolder(parent.inflatee(R.layout.card_view_football_teams))

        /*return FootballViewHolder(LayoutInflater
            .from(parent.context)
            .inflate(R.layout.card_view_football_teams, parent, false))*/

    }

    override fun getItemCount(): Int {
        Log.d("GETCOUNTWORKING  DATA", footballTeamsModel.teams[0].idLeague.toString())
        return footballTeamsModel.teams.size
    }

    override fun onBindViewHolder(holder: FootballViewHolder, position: Int) {
        //Picasso.get().load(footballTeamsModel.teams[position].strTeamLogo).into(holder.iv_logo)
        //Picasso.get().load(footballTeamsModel.teams[position].strTeamFanart1).into(holder.iv_fan_art)
        holder.tv_team_league.text = footballTeamsModel.teams[position].strLeague
        holder.iv_logo.imagine(footballTeamsModel.teams[position].strTeamLogo)
        holder.iv_fan_art.imagine(footballTeamsModel.teams[position].strTeamFanart1)


        holder.bind(footballTeamsModel.teams, onClickItemListener)
    }


}

class FootballViewHolder(view: View): RecyclerView.ViewHolder(view){
    fun bind(results: List<Teams>, onClickItemListener: OnClickItemListener) {

        itemView.setOnClickListener{
            onClickItemListener.onClick(results)


        }
    }

    var iv_logo = view.iv_team_logo
    var iv_fan_art = view.iv_fan_art
    var tv_team_league = view.tv_football_teams_league

}

interface OnClickItemListener{
    fun onClick(result: List<Teams>)
}

