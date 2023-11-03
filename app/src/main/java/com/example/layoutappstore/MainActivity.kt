package com.example.layoutappstore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val app1 = Pair("Ứng dụng thời tiết", mutableListOf("AccuWeather", "Weather Underground", "The Weather Channel", "Weather & Radar", "Yahoo Weather"))
        val app2 = Pair("Ứng dụng mạng xã hội", mutableListOf("Facebook", "Twitter", "Instagram", "LinkedIn", "Snapchat"))
        val app3 = Pair("Ứng dụng trình duyệt", mutableListOf("Google Chrome", "Mozilla Firefox", "Safari", "Microsoft Edge", "Opera"))
        val app4 = Pair("Trò chơi phiêu lưu", mutableListOf("Assassin's Creed Valhalla", "The Legend of Zelda: Breath of the Wild", "Dark Souls III", "God of War", "Final Fantasy VII Remake"))
        val dataApp = mutableListOf(app1,app2,app3,app4)
        val adapterApp = Adapter_App(dataApp)
        val linearLayoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        val rec_v = findViewById<RecyclerView>(R.id.rec_verti)
        rec_v.layoutManager = linearLayoutManager
        rec_v.adapter = adapterApp
    }
}