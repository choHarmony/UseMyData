package com.hanium.ictapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_consume.*
import kotlinx.android.synthetic.main.activity_estate.*
import kotlinx.android.synthetic.main.activity_stay.*
import kotlinx.android.synthetic.main.activity_stay.btnHome

class EstateActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_estate)

        var intentHome = Intent(this, MainActivity::class.java)
        var intentEstateStep1 = Intent(this, EstateStep1Activity::class.java)
        // var intentEstateStep2 = Intent(this, EstateStep2Activity::class.java)
        var intentEstateStep3 = Intent(this, EstateStep3Activity::class.java)

        btnHome.setOnClickListener {
            startActivity(intentHome)
        }

        btnEstateStep1.setOnClickListener {
            startActivity(intentEstateStep1)
        }

//        btnEstateStep2.setOnClickListener {
//            startActivity(intentEstateStep2)
//        }

        btnEstateStep3.setOnClickListener {
            startActivity(intentEstateStep3)
        }
    }
}