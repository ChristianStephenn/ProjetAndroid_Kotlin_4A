package com.example.projetandroid_kotlin_4a.presentation.list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.d
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.projetandroid_kotlin_4a.R
import com.example.projetandroid_kotlin_4a.domain.entity.Champion
import kotlinx.android.synthetic.main.activity_list.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        val url = "https://raw.githubusercontent.com/ChristianStephenn/ProjetAndroid_Kotlin_4A/master/TFT.json"
        
        val retrofit = Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api = retrofit.create(ApiService::class.java)

        api.fetchAllUsers().enqueue(object : Callback<List<Champion>> {
            override fun onFailure(call: Call<List<Champion>>, t: Throwable) {
                d("test", "onF")
            }

            override fun onResponse(
                call: Call<List<Champion>>,
                response: Response<List<Champion>>
            ) {
                d("test", "onR : $")
            }

        })

        val champions = mutableListOf<Champion>()
        for (i in 0..20){
            champions.add(Champion("test","humain"))
        }

        recyclerview.apply {
            layoutManager = LinearLayoutManager(this@ListActivity)
            adapter = ChampionsAdapter(champions)
        }
    }
}