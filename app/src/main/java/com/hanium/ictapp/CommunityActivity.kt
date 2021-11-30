package com.hanium.ictapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_community.*
import kotlinx.android.synthetic.main.activity_stay.*
import kotlinx.android.synthetic.main.activity_stay.btnHome

class CommunityActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_community)


        var intentHome = Intent(this, MainActivity::class.java)

        btnHome.setOnClickListener {
            startActivity(intentHome)
        }

        val postList = ArrayList<CommunityListViewItem>()
        postList.add(CommunityListViewItem(null, "안녕하세요", "반갑습니다"))
        postList.add(CommunityListViewItem(getDrawable(R.drawable.community)!!, "hello", "안녕"))

        val adapter = CommunityListViewAdapter(postList)
        community_post_list.adapter = adapter

        val dividerItemDecoration = DividerItemDecoration(community_post_list.context, LinearLayoutManager(this).orientation)
        community_post_list.addItemDecoration(dividerItemDecoration)

    }
}