package com.example.myapplication.activity.main

import android.graphics.Color
import android.graphics.drawable.VectorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import com.example.myapplication.activity.main.home.HomeFragment
import com.example.myapplication.activity.main.person.PersonFragment
import com.example.myapplication.activity.main.project.ProjectFragment
import com.example.myapplication.activity.main.tree.TreeFragment
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var selectedItemIndex = 0
    private val titles=ArrayList<TextView>()
    private val icons = ArrayList<ImageView>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.titleHome.setTextColor(Color.BLUE)
        (binding.iconHome.drawable as VectorDrawable).setTint(Color.BLUE)

        binding.titleHome.setOnClickListener {
            setSelectedItem(0)
        }
        binding.iconHome.setOnClickListener {
            setSelectedItem(0)
        }

        binding.titleProject.setOnClickListener {
            setSelectedItem(1)
        }
        binding.iconProject.setOnClickListener {
            setSelectedItem(1)
        }

        binding.titleTree.setOnClickListener {
            setSelectedItem(2)
        }
        binding.iconTree.setOnClickListener {
            setSelectedItem(2)
        }

        binding.titleTree.setOnClickListener {
            setSelectedItem(3)
        }
        binding.iconPerson.setOnClickListener {
            setSelectedItem(3)
        }

        titles.add(binding.titleHome)
        titles.add(binding.titleProject)
        titles.add(binding.titleTree)
        titles.add(binding.titlePerson)

        icons.add(binding.iconHome)
        icons.add(binding.iconProject)
        icons.add(binding.iconTree)
        icons.add(binding.iconPerson)

        val fragments = ArrayList<Fragment>()
        fragments.add(HomeFragment.newInstance())
        fragments.add(ProjectFragment.newInstance())
        fragments.add(TreeFragment.newInstance())
        fragments.add(PersonFragment.newInstance())

        binding.viewPager.adapter = MainAdapter(supportFragmentManager,fragments)

        binding.viewPager.addOnPageChangeListener(object : OnPageChangeListener{
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {

            }

            override fun onPageSelected(position: Int) {
                setSelectedItem(position)
            }

            override fun onPageScrollStateChanged(state: Int) {

            }

        })

    }

    private fun setSelectedItem(itemIndex: Int) {
        if(itemIndex != selectedItemIndex){
            titles[selectedItemIndex].setTextColor(Color.BLACK)
            (icons[selectedItemIndex].drawable as VectorDrawable).setTint(Color.BLACK)

            selectedItemIndex = itemIndex
            titles[selectedItemIndex].setTextColor(Color.BLUE)
            (icons[selectedItemIndex].drawable as VectorDrawable).setTint(Color.BLUE)

            binding.viewPager.setCurrentItem(itemIndex)
        }
    }
}