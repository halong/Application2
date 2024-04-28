package com.example.myapplication.activity.main.home

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.myapplication.R
import com.example.myapplication.entity.home.HomeArticle

class HomeAdapter(private val articles: ArrayList<HomeArticle>) : Adapter<ViewHolder>() {
    private val typeBanner = 0
    private val typeBody = 1

    @SuppressLint("NotifyDataSetChanged")
    fun addHomeArticles(homeArticles: List<HomeArticle>) {
        homeArticles.forEach {
            articles.add(it)
        }
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemView = layoutInflater.inflate(R.layout.item_body, parent, false)
        return BodyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return articles.size
    }

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder as BodyViewHolder
        holder.text.text = articles[position].title
    }

    class BannerViewHolder(itemView: View) : ViewHolder(itemView) {

    }

    class BodyViewHolder(itemView: View) : ViewHolder(itemView) {
        val text: TextView = itemView.findViewById(R.id.text_view)
    }

}