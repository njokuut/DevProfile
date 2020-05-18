package com.enjaybaze.swooshapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class SkillActivity : AppCompatActivity() {
    var league = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skill)
        league = intent.getStringExtra(EXTRA_LEAGUE)  // Pull from the intent the selected league value passed to be used in this screen
    }


    fun backbuttonClick(view: View) {
        val backIntent = Intent(this, LeagueActivity::class.java)
        startActivity(backIntent)
    }
}
