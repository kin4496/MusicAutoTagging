package com.example.musicautotagging

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PlayListAdapter(private val dataSet:MutableList<MusicData>):
    RecyclerView.Adapter<PlayListAdapter.ViewHolder>(){


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val titleTextView: TextView
        val artistTextView: TextView
        val tagListTextView: TextView
        val view:View
        init {
            // Define click listener for the ViewHolder's View.
            titleTextView = view.findViewById(R.id.titleTextView)
            artistTextView = view.findViewById(R.id.artistTextView)
            tagListTextView = view.findViewById(R.id.TagListTextView)
            this.view=view
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_list, viewGroup, false)

        return ViewHolder(view)
    }
    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.titleTextView.text = dataSet[position].getTitle()
        viewHolder.artistTextView.text = dataSet[position].getArtist()

        val tagList=dataSet[position].getTagList()
        var tagText=""
        for((idx,tag) in tagList.withIndex())
        {
            if(idx>3) break
            if(idx!=0)
                tagText+=" "
            tagText+= tag
        }
        viewHolder.tagListTextView.text = tagText
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size
}