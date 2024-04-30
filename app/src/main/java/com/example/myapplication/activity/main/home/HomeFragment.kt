package com.example.myapplication.activity.main.home

import android.annotation.SuppressLint
import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.OnScrollListener
import com.example.myapplication.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    companion object {
        fun newInstance() = HomeFragment()
    }

    private val viewModel: HomeViewModel by viewModels()
    private lateinit var binding: FragmentHomeBinding
    private val adapter by lazy {
        HomeAdapter(this.requireContext())
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.errorLiveData.observe(this) {

        }

        viewModel.bannersLiveData.observe(this){
            adapter.setBanners(it)
        }

        viewModel.homeArticlesLiveData.observe(this) {
            if (binding.swipeRefresh.isRefreshing){
                binding.swipeRefresh.isRefreshing=false
            }
            adapter.setHomeArticles(it)
            adapter.notifyDataSetChanged()
        }


    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)

        val layoutManager = LinearLayoutManager(context)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.adapter = adapter

        binding.recyclerView.addOnScrollListener(object : OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

                // 获取布局管理器
                val layoutManager = recyclerView.layoutManager
                if (layoutManager is LinearLayoutManager) {
                    val totalItemCount = layoutManager.getItemCount()
                    val lastVisibleItemPosition = layoutManager.findLastVisibleItemPosition()

                    // 滑动到了最后一项
                    if (totalItemCount > 0 && lastVisibleItemPosition >= totalItemCount - 1) {
                        viewModel.getMoreHomeArticles()
                    }
                }
            }
        })

        binding.swipeRefresh.setOnRefreshListener {
            viewModel.getHomeArticles()
        }

        return binding.root
    }

    override fun onStart() {
        super.onStart()
        viewModel.getBanners()
        viewModel.getHomeArticles()
    }
}