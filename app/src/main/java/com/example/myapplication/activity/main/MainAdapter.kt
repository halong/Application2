package com.example.myapplication.activity.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class MainAdapter(fragmentManger:FragmentManager,private val fragments:List<Fragment>):FragmentPagerAdapter(fragmentManger) {
    override fun getCount(): Int {
        return fragments.size
    }
    override fun getItem(position: Int): Fragment {
        return fragments[position]
    }
}