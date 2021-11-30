package com.hanium.ictapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_info.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_stay.*

class MainActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {

        auth = Firebase.auth

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var intentStay = Intent(this, StayActivity::class.java)
        var intentConsume = Intent(this, ConsumeActivity::class.java)
        var intentEstate = Intent(this, EstateActivity::class.java)
        var intentCommunity = Intent(this, CommunityActivity::class.java)
        var intentLogin = Intent(this, LoginActivity::class.java)
        var intentInfo = Intent(this, InfoActivity::class.java)


        btnStay.setOnClickListener {
            startActivity(intentStay)
        }

        btnConsume.setOnClickListener {
            startActivity(intentConsume)
        }

        btnEstate.setOnClickListener {
            startActivity(intentEstate)
        }

        btnCommunity.setOnClickListener {
            startActivity(intentCommunity)
        }

        btnLogin.setOnClickListener {
            startActivity(intentLogin)
        }

        btnInfo.setOnClickListener {
            startActivity(intentInfo)
        }

        findViewById<Button>(R.id.btnLogout).setOnClickListener {

            auth.signOut()

            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intentLogin)

        }

    }


}