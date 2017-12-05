package com.kotlin.newfeedaggregator.aquidigital.kotlinnewsfeedaggregator


import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.Query
import com.mobymagic.easyfirebaselist.EmptyStyle
import com.mobymagic.easyfirebaselist.ErrorStyle
import com.mobymagic.easyfirebaselist.ProgressStyle
import com.mobymagic.easyfirebaselist.database.FirebaseDbListFragment
import com.thefinestartist.finestwebview.FinestWebView


class NewsListFragment : FirebaseDbListFragment<News, NewsViewHolder>() {

    override fun getDataClass(): Class<News> = News::class.java

    override fun getEmptyStyle(): EmptyStyle =
            EmptyStyle(R.drawable.ic_cloud_off_black, "No news available yet in database")

    override fun getErrorStyle(error: DatabaseError): ErrorStyle =
            ErrorStyle(R.drawable.ic_cloud_queue_black, "An error occurred while fetching news")

    override fun getProgressStyle(): ProgressStyle = ProgressStyle("Loading...")

    override fun getQuery(): Query =
            FirebaseDatabase.getInstance().reference.child("news").limitToLast(100)

    override fun onBindViewHolder(viewHolder: NewsViewHolder, key: String, model: News) {
        viewHolder.bind(model)
    }

    override fun onCreateViewHolder(inflater: LayoutInflater, viewGroup: ViewGroup): NewsViewHolder {
        val view = inflater.inflate(R.layout.news_feed_item, viewGroup, false)
        return NewsViewHolder(view)
    }

    override fun onItemClicked(viewHolder: NewsViewHolder, key: String, model: News) {
        FinestWebView.Builder(activity).show(model.link)
    }

    override fun setupRecyclerView(recyclerView: RecyclerView) {
        recyclerView.addItemDecoration(DividerItemDecoration(activity, DividerItemDecoration.VERTICAL))
        recyclerView.layoutManager = LinearLayoutManager(activity)
    }

}
