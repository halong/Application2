package com.example.myapplication.activity.main.tree

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentTreeBinding

class TreeFragment : Fragment() {

    companion object {
        fun newInstance() = TreeFragment()
    }

    private val viewModel: TreeViewModel by viewModels()
    private lateinit var binding: FragmentTreeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.errorLiveData.observe(this){
            binding.textView.text = it
        }
        viewModel.treesLiveData.observe(this){
            binding.textView.text = it.toString()
        }
        viewModel.getTrees()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding=FragmentTreeBinding.inflate(inflater,container,false)
        return binding.root
    }
}