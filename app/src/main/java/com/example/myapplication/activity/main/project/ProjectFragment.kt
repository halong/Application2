package com.example.myapplication.activity.main.project

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.databinding.FragmentProjectBinding

class ProjectFragment : Fragment() {

    companion object {
        fun newInstance() = ProjectFragment()
    }

    private val viewModel: ProjectViewModel by viewModels()
    private lateinit var binding: FragmentProjectBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.errorLiveData.observe(this){
            binding.textView.text = it
        }

        viewModel.projectTreesLiveData.observe(this){
            binding.textView.text = it.toString()
        }

        viewModel.getProjectTrees()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProjectBinding.inflate(inflater,container,false)
        return binding.root
    }
}