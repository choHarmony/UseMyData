package com.hanium.ictapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_info.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_stay.*

class InfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)

        var intentAccount = Intent(this, AccountActivity::class.java)
        var intentSetting = Intent(this, SettingActivity::class.java)
        var intentAlarm = Intent(this, AlarmActivity::class.java)
        var intentCheckStay = Intent(this, CheckStayActivity::class.java)
        var intentHelp = Intent(this, HelpActivity::class.java)
        var intentInquiry = Intent(this, InquiryActivity::class.java)


        btnManageAccount.setOnClickListener {
            startActivity(intentAccount)
        }

        btnSetting.setOnClickListener {
            startActivity(intentSetting)
        }

        btnSetAlarm.setOnClickListener {
            startActivity(intentAlarm)
        }

        btnCheckStay.setOnClickListener {
            startActivity(intentCheckStay)
        }

        btnHelp.setOnClickListener {
            startActivity(intentHelp)
        }

        btnInquiry.setOnClickListener {
            startActivity(intentInquiry)
        }
    }


}