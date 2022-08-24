package com.example.musicautotagging

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.*
import okhttp3.OkHttpClient
import okhttp3.Request
import kotlin.coroutines.CoroutineContext

class PlaylistActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_playlist)
        var dataSet= mutableListOf<MusicData>()
        if(intent.hasExtra("tagName"))
        {
            val tag=intent.getStringExtra("tagName")
            dataSet=getDataFromServer(tag!!)
        }
        val playlistRecyclerView=findViewById<RecyclerView>(R.id.musicList)
        val playlistAdapter=PlayListAdapter(dataSet)

        playlistRecyclerView.adapter=playlistAdapter
        playlistRecyclerView.layoutManager=LinearLayoutManager(this)

        test()
    }
    private fun getDataFromServer(search:String):MutableList<MusicData>
    {
        var dataSet=mutableListOf<MusicData>()
        val ele=MusicData("밤편지","IU","노래가사", mutableListOf<String>("#잔잔한","#밤","#그리움","#사랑"))
        dataSet.add(ele)
        return dataSet
    }
    fun test()
    {
        CoroutineScope(Dispatchers.Main).launch{
            val response=CoroutineScope(Dispatchers.Default).async{
                //network
                getData()
            }.await()
            var dataSet=mutableListOf<MusicData>()
            //main thread
        }
    }
    fun getData():String{
        val url="https://www.google.com/"
        //1.클라이언트 만들기
        val client=OkHttpClient.Builder().build()
        //2.요청
        val req= Request.Builder().url(url).build()
        //3.응답
        client.newCall(req).execute().use {
            response->return if(response.body!=null){
                response.body!!.string()
            }
            else{
                "body null"
            }
        }
    }
}