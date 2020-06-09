package com.enjaybaze.swooshapp.Controllers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.enjaybaze.swooshapp.Model.Player
import kotlinx.android.synthetic.main.activity_finish.*
import com.enjaybaze.swooshapp.R
import com.enjaybaze.swooshapp.Utilities.EXTRA_PLAYER

class FinishActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish)
        val player = intent.getParcelableExtra<Player>(EXTRA_PLAYER)


        searchLeaguesText.text = "Looking for a ${player.league} ${player.difficulty} league near you....."

    }
}
