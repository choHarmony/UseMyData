package com.hanium.ictapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_recommend.*
import kotlinx.android.synthetic.main.activity_stay.*

class RecommendActivity : AppCompatActivity() {

    private val items = mutableListOf<ContentsModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recommend)

        val btnCheckStay = findViewById<Button>(R.id.btnCheckStay)
        btnCheckStay.setOnClickListener {
            val intentCheckStayActivity = Intent(this, CheckStayActivity::class.java)
            startActivity(intentCheckStayActivity)
        }


        items.add(
            ContentsModel(
                "https://www.travelodgehotels.asia/hotel/travelodge-seoul-dongdaemun/",
                "http://tong.visitkorea.or.kr/cms/resource/59/2725259_image2_1.jpg",
                "트레블로지 동대문 호텔"
            )
        )

        items.add(
            ContentsModel(
                "https://www.marriott.co.kr/hotels/travel/taemc-daegu-marriott-hotel",
                "http://tong.visitkorea.or.kr/cms/resource/53/2721553_image2_1.jpg",
                "대구 메리어트 호텔"
            )
        )

        items.add(
            ContentsModel(
                "https://www.shillastay.com/ulsan/index.do",
                "http://tong.visitkorea.or.kr/cms/resource/08/2723308_image2_1.jpg",
                "신라스테이 울산"
            )
        )

        items.add(
            ContentsModel(
                "https://www.lavalsehotel.co.kr/",
                "http://tong.visitkorea.or.kr/cms/resource/51/2709251_image2_1.jpg",
                "부산 라발스호텔"
            )
        )

        items.add(
            ContentsModel(
                "https://www.lottehotel.com/daejeon-city/ko.html",
                "http://tong.visitkorea.or.kr/cms/resource/28/1933928_image2_1.jpg",
                "롯데시티호텔 대전"
            )
        )

        items.add(
            ContentsModel(
                "https://haklimjae.modoo.at/",
                "http://tong.visitkorea.or.kr/cms/resource/56/2707656_image2_1.jpg",
                "세종 학림재"
            )
        )



        val recyclerview = findViewById<RecyclerView>(R.id.rv_recommend)
        val rvAdapter = RecommendRVAdapter(this, items)
        recyclerview.adapter = rvAdapter

        rvAdapter.itemClick = object: RecommendRVAdapter.ItemClick {
            override fun onClick(view: View, position: Int) {

                val intentStayView = Intent(baseContext, StayViewActivity::class.java)
                intent.putExtra("url", items[position].url)
                intent.putExtra("title", items[position].titleText)
                intent.putExtra("imageUrl", items[position].imageUrl)

                startActivity(intentStayView)

            }
        }

        recyclerview.layoutManager = LinearLayoutManager(this)

    }
}