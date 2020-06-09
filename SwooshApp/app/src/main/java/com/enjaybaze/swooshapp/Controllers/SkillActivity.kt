package com.enjaybaze.swooshapp.Controllers

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.enjaybaze.swooshapp.Model.Player
import com.enjaybaze.swooshapp.Utilities.EXTRA_LEAGUE
import com.enjaybaze.swooshapp.R
import com.enjaybaze.swooshapp.Utilities.EXTRA_LEVEL
import com.enjaybaze.swooshapp.Utilities.EXTRA_PLAYER
import kotlinx.android.synthetic.main.activity_skill.*

class SkillActivity : AppCompatActivity() {
    var league = ""
    var difficulty = ""

    lateinit var player : Player
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skill)
        player = intent.getParcelableExtra<Player>(EXTRA_PLAYER) // Pull from the intent the selected league value passed to be used in this screen
    }


    fun backbuttonClick(view: View) {
        val backIntent = Intent(this, LeagueActivity::class.java)
        if (player.league != "") {
            backIntent.putExtra(EXTRA_PLAYER, player)
        }
        startActivity(backIntent)
    }

    fun onBeginnerClick(view: View){
        ballerToggleBtn.isChecked = false
        player.difficulty = "beginner"
    }

    fun onBallerClick(view: View) {
        beginnerToggleBtn.isChecked = false
        player.difficulty = "baller"
    }


    fun onFinishClick(view: View) {

        if (player.difficulty != ""){
            val finishIntent = Intent(this, FinishActivity::class.java)

            finishIntent.putExtra(EXTRA_PLAYER, player)
            startActivity(finishIntent)
        } else {
            Toast.makeText(this, "Select a Difficulty Level", Toast.LENGTH_SHORT ).show()
        }


    }
}
