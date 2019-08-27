package com.example.footballapi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.footballapi.view.asyncBubbleSort.AsyncBubbleSortActivity
import com.example.footballapi.view.NullableActivity
import com.example.footballapi.view.footballTeams.FootballTeamsActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onClick(p0: View?) {

        when(p0!!.id){
            R.id.btn_fb_teams ->{
                intent = Intent(this, FootballTeamsActivity::class.java)
            }

            R.id.btn_bs_at ->{
                intent = Intent(this, AsyncBubbleSortActivity::class.java)
            }

            R.id.btn_nullable ->{
                intent = Intent(this, NullableActivity::class.java)
            }

        }

        startActivity(intent)


    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_fb_teams.setOnClickListener(this)
        btn_bs_at.setOnClickListener(this)
        btn_nullable.setOnClickListener(this)
    }
}
