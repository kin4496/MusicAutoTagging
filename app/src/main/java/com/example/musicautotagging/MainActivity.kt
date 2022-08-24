package com.example.musicautotagging

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SearchView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val searchView=findViewById<SearchView>(R.id.searchView)

        val textViews= mutableListOf<TextView>()
        var textView=findViewById<TextView>(R.id.loveTag)
        textViews.add(textView)
        textView=findViewById<TextView>(R.id.commuteTag)
        textViews.add(textView)
        textView=findViewById<TextView>(R.id.windlessTag)
        textViews.add(textView)
        textView=findViewById<TextView>(R.id.travelTag)
        textViews.add(textView)
        textView=findViewById<TextView>(R.id.summerTag)
        textViews.add(textView)
        textView=findViewById<TextView>(R.id.nightTag)
        textViews.add(textView)

        for(textView in textViews)
        {
            textView.setOnClickListener {
                getPlayListActivity("")
            }
        }

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                // 검색 버튼 누를 때 호출

                getPlayListActivity(query!!)
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                // 검색창에서 글자가 변경이 일어날 때마다 호출
                return true
            }
        })
    }

    private fun getPlayListActivity(search:String)
    {
        val intent= Intent(this,PlaylistActivity::class.java)
        intent.putExtra("tagName",search)
        startActivity(intent)
    }
}