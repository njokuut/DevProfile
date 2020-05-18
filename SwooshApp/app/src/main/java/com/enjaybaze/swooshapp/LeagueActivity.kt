package com.enjaybaze.swooshapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_league.*

class LeagueActivity : BaseActivity() {
    var selectedLeague = "" // default value for selected . Nothing has been selected yet

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_league)
    }

    fun onMensClick(view: View){
        womenLeagueBtn.isChecked = false // uncheck other selections
        coedLeagueBtn.isChecked = false
        selectedLeague = "mens" // select men's league and set the variable to men's
    }

    fun onWomenClick(view: View){
        menLeagueBtn.isChecked = false
        coedLeagueBtn.isChecked = false
        selectedLeague = "womens"
    }

    fun onCoEdClick(view: View){
        womenLeagueBtn.isChecked = false
        menLeagueBtn.isChecked = false
        selectedLeague = "coed"
    }

    fun nextBtnClicked(view: View) {
        if (selectedLeague !=  ""){ // if a specific league is selected
            val skillIntent = Intent(this, SkillActivity::class.java) // use intent to move to the next screen
            skillIntent.putExtra(EXTRA_LEAGUE, selectedLeague) // pass the value of the league selected to be sent with the intent to the next screen
            startActivity(skillIntent)
        } else {
            Toast.makeText(this, "Please select a league.", Toast.LENGTH_SHORT).show() // Toast is to show a tip on what must be done for it to work
        }

    }

}
