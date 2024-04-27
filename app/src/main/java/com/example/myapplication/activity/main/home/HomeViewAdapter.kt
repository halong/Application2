package com.example.myapplication.activity.main.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.myapplication.R
import com.example.myapplication.entity.home.HomeArticle

class HomeViewAdapter(private val articles:List<HomeArticle>):Adapter<ViewHolder>() {
    private val TYPE_BANNER = 0
    private val TYPE_BODY = 1
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return when(viewType){
            TYPE_BANNER -> {
                val itemView=layoutInflater.inflate(R.layout.item_banner,parent,false)
                BannerViewHolder(itemView)
            }

            else -> {
                val itemView=layoutInflater.inflate(R.layout.item_body,parent,false)
                BodyViewHolder(itemView)
            }
        }
    }

    override fun getItemCount(): Int {
        return articles.size + 1
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == 0){
            TYPE_BANNER
        }else{
            TYPE_BODY
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

    }

    class BannerViewHolder(itemView : View):ViewHolder(itemView){

    }

    class BodyViewHolder(itemView : View):ViewHolder(itemView){

    }
    
}