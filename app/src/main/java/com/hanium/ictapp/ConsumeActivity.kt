package com.hanium.ictapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_consume.*
import kotlinx.android.synthetic.main.activity_estate.*
import kotlinx.android.synthetic.main.activity_stay.*
import kotlinx.android.synthetic.main.activity_stay.btnHome

class ConsumeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_consume)

        var intentHome = Intent(this, MainActivity::class.java)
        var intentConsumeStep1 = Intent(this, ConsumeStep1Activity::class.java)
//        var intentConsumeStep2 = Intent(this, ConsumeStep2Activity::class.java)
        var intentConsumeStep3 = Intent(this, ConsumeStep3Activity::class.java)
        var intentConsumeWish = Intent(this, ConsumeWishActivity::class.java)


        btnHome.setOnClickListener {
            startActivity(intentHome)
        }

        btnConsumeStep1.setOnClickListener {
            startActivity(intentConsumeStep1)
        }

//        btnConsumeStep2.setOnClickListener {
//            startActivity(intentConsumeStep2)
//        }
//
        btnConsumeStep3.setOnClickListener {
            startActivity(intentConsumeStep3)
        }

        btnConsumeWish.setOnClickListener {
            startActivity(intentConsumeWish)
        }

    }
}