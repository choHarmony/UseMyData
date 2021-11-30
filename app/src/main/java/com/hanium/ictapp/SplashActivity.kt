package com.hanium.ictapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class SplashActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
// ...
// Initialize Firebase Auth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        auth = Firebase.auth

        if (auth.currentUser?.uid == null) {
            //회원가입이 안되어있으므로, loginActivity
            Handler().postDelayed({
                startActivity((Intent(this, LoginActivity::class.java)))
                finish()
            }, 2000)
        } else {
            //회원가입이 되어있으므로, MainActivity
            Toast.makeText(this, "자동로그인", Toast.LENGTH_LONG).show()
            Handler().postDelayed({
                startActivity((Intent(this, MainActivity::class.java)))
                finish()
            }, 2000)
        }



    }
}