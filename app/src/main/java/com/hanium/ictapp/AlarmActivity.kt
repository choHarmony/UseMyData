package com.hanium.ictapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CompoundButton
import android.widget.Switch
import kotlinx.android.synthetic.main.activity_alarm.*

class AlarmActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alarm)

        val switchAllAlarm = findViewById<Switch>(R.id.SwitchAllAlarm)
        val switchMannerMode = findViewById<Switch>(R.id.SwitchMannerMode)

        SwitchAllAlarm.setOnCheckedChangeListener(object : CompoundButton.OnCheckedChangeListener {
            override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
                if(isChecked) {
                    "전체 알람 켜기"
                }
                else {
                    "전체 알람 끄기"
                }
            }
        })

        switchMannerMode.setOnCheckedChangeListener(object : CompoundButton.OnCheckedChangeListener {
            override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
                if(isChecked) {
                    "방해 금지 모드"
                }
                else {
                    "방해 금지 모드"
                }
            }
        })

        val switchValue1 = switchAllAlarm.isSelected
        val switchValue2 = switchMannerMode.isSelected
    }
}