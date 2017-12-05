package com.kotlin.newfeedaggregator.aquidigital.kotlinnewsfeedaggregator

import android.support.v7.widget.RecyclerView
import android.view.View
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.news_feed_item.view.*

/**
 * Created by aquidigitalltd on 05/12/2017.
 */

class NewsViewHolder (view: View): RecyclerView.ViewHolder(view){

    fun bind(model: News){
        itemView.newsTitleTextView.text = model.title
        Picasso.with(itemView.context).load(model.thumbnail).into(itemView.newsThumbnailImageView)
    }

}