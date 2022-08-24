package com.example.musicautotagging

class MusicData {

    private var title:String=""
    private var artist:String=""
    private var lyric=""
    private var tagList= mutableListOf<String>()

    constructor(title: String, artist: String, lyric: String,tagList: MutableList<String>) {
        this.title=title
        this.artist=artist
        this.lyric=lyric
        this.tagList=tagList
    }

    fun getTitle(): String {
        return title
    }

    fun getArtist(): String {
        return artist
    }

    fun getLyric(): String {
        return lyric
    }

    fun getTagList():MutableList<String>{
        return tagList
    }

    fun setTitle(title:String){
        this.title=title
    }
    fun setArtist(artist: String){
        this.artist=artist
    }
    fun setLyric(lyric:String){
        this.lyric=lyric
    }
    fun setTagList(tagList: MutableList<String>){
        this.tagList=tagList
    }
}