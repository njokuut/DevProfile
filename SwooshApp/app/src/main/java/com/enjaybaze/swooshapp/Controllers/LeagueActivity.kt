package com.enjaybaze.swooshapp.Controllers

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.enjaybaze.swooshapp.Model.Player
import com.enjaybaze.swooshapp.R
import com.enjaybaze.swooshapp.Utilities.EXTRA_PLAYER
import kotlinx.android.synthetic.main.activity_league.*

class LeagueActivity : BaseActivity() {
    var selectedLeague = "" // default value for selected . Nothing has been selected yet
    var player = Player("", "")

    lateinit var njay : Player

  override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState?.putParcelable(EXTRA_PLAYER, player)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_league)
        if (intent.getParcelableExtra<Player>(EXTRA_PLAYER) != null) {
            njay = intent.getParcelableExtra<Player>(EXTRA_PLAYER)
            var previous = njay.league.toString()
            println("League is $previous")
            ifBackBtn(previous)
            println("League is $previous")
        }

    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        if (savedInstanceState != null) {
            player = savedInstanceState.getParcelable<Player>(EXTRA_PLAYER)!!
        }
    }

    fun onMensClick(view: View){
        womenLeagueBtn.isChecked = false // uncheck other selections
        coedLeagueBtn.isChecked = false
        player.league = "Men's" // select men's league and set the variable to men's
    }

    fun onWomenClick(view: View){
        menLeagueBtn.isChecked = false
        coedLeagueBtn.isChecked = false
        player.league = "Women's"
    }

    fun onCoEdClick(view: View){
        womenLeagueBtn.isChecked = false
        menLeagueBtn.isChecked = false
        player.league = "Co-Ed"
    }

    fun nextBtnClicked(view: View) {
        if (player.league !=  ""){ // if a specific league is selected
            val skillIntent = Intent(this, SkillActivity::class.java) // use intent to move to the next screen
            skillIntent.putExtra(EXTRA_PLAYER, player)// pass the value of the league selected to be sent with the intent to the next screen
            startActivity(skillIntent)
        } else {
            Toast.makeText(this, "Please select a league.", Toast.LENGTH_SHORT).show() // Toast is to show a tip on what must be done for it to work
        }

    }

    fun ifBackBtn(league: String) {

        if (league == "Men's") {
            menLeagueBtn.performClick()
        } else if (league == "Women's") {
            womenLeagueBtn.performClick()
        } else if (league == "Co-Ed") {
            coedLeagueBtn.performClick()
        }
    }

}
