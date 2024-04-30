package com.example.myapplication.activity.main.home

import android.annotation.SuppressLint
import android.content.Context
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.myapplication.R
import com.example.myapplication.entity.home.HomeArticle
import com.youth.banner.Banner
import com.youth.banner.adapter.BannerImageAdapter
import com.youth.banner.holder.BannerImageHolder
import com.youth.banner.indicator.CircleIndicator

class HomeAdapter(private val context: Context) : Adapter<ViewHolder>() {
    private var homeArticles: List<HomeArticle>? = null
    private var banners: List<com.example.myapplication.entity.home.Banner>? = null
    private val typeBanner = 0
    private val typeBody = 1
    private val typeFooter = 2

    @SuppressLint("NotifyDataSetChanged")
    fun setHomeArticles(homeArticles: List<HomeArticle>) {
        this.homeArticles = homeArticles
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setBanners(banners:List<com.example.myapplication.entity.home.Banner>){
        this.banners = banners
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            typeBanner -> BannerViewHolder(
                layoutInflater.inflate(
                    R.layout.item_banner,
                    parent,
                    false
                )
            )

            typeFooter -> FooterViewHolder(
                layoutInflater.inflate(
                    R.layout.item_footer,
                    parent,
                    false
                )
            )

            else -> BodyViewHolder(layoutInflater.inflate(R.layout.item_body, parent, false))
        }
    }

    override fun getItemCount(): Int {
        return homeArticles?.size?.plus(2) ?: 2
    }

    override fun getItemViewType(position: Int): Int {
        return when (position) {
            0 -> typeBanner
            (homeArticles?.size ?: 0) + 1 -> typeFooter
            else -> typeBody
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        when (position) {
            0 -> {
                if (banners != null) {
                    holder as BannerViewHolder
                    holder.banner.setIndicator(CircleIndicator(this.context))
                        .setAdapter(object :
                            BannerImageAdapter<com.example.myapplication.entity.home.Banner>(banners) {
                            override fun onBindView(
                                holder: BannerImageHolder,
                                data: com.example.myapplication.entity.home.Banner,
                                position: Int,
                                size: Int
                            ) {
                                Glide.with(holder.itemView)
                                    .load(data.imagePath)
                                    .into(holder.imageView)
                            }
                        })
                }
            }

            (homeArticles?.size ?: 0) + 1 -> {
                holder as FooterViewHolder
            }

            else -> {
                holder as BodyViewHolder
                holder.text.text = Html.fromHtml(homeArticles?.get(position - 1)?.title ?: "")
            }
        }
    }

    class BannerViewHolder(itemView: View) : ViewHolder(itemView) {
        val banner: Banner<*, *> = itemView.findViewById(R.id.banner)
    }

    class BodyViewHolder(itemView: View) : ViewHolder(itemView) {
        val text: TextView = itemView.findViewById(R.id.text_view)
    }

    class FooterViewHolder(itemView: View) : ViewHolder(itemView) {

    }


}