package com.hanium.ictapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.app.ActivityCompat
import com.google.firebase.storage.FirebaseStorage
import kotlinx.android.synthetic.main.activity_stay.*
import java.util.jar.Manifest

class StayActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stay)

        var intentHome = Intent(this, MainActivity::class.java)
        var intentStayRestart = Intent(this, StayRestartActivity::class.java)
        var intentRecommend = Intent(this, RecommendActivity::class.java)

        btnHome.setOnClickListener {
            startActivity(intentHome)
        }

        btnStayRestart.setOnClickListener {
            startActivity(intentStayRestart)
        }

        btnStayStep3.setOnClickListener {
            startActivity(intentRecommend)
        }


        var intentImage = Intent(this, ImageActivity::class.java)

        btnStayStep1.setOnClickListener {
            startActivity(intentImage)
        }


    }


}