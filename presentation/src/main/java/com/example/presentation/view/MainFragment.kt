package com.example.presentation.view

import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.presentation.R
import com.example.presentation.adapter.ScoreRecyclerViewAdapter
import com.example.presentation.base.BaseFragment
import com.example.presentation.databinding.FragmentMainBinding
import com.example.presentation.viewmodel.MainViewModel
import com.example.presentation.widget.extension.showVertical

class MainFragment : BaseFragment<FragmentMainBinding>(R.layout.fragment_main) {
    private val mainViewModel by activityViewModels<MainViewModel>()

    override fun init() {
        binding.fragment = this
        observeViewModel()
        mainViewModel.getStatisticsDisplay()
        mainViewModel.getScore()
    }

    fun startBtnClick(view:View) {
        this.findNavController().navigate(R.id.action_mainFragment_to_womanNameFragment)
    }

    private fun observeViewModel() {
        mainViewModel.getStatisticsEvent.observe(this) {
            binding.statistics.text = it.toString()
        }

        mainViewModel.getScoreEvent.observe(this) {
            initRecyclerView()
        }
    }

    private fun initRecyclerView() {
        binding.scoreRecyclerView.adapter = ScoreRecyclerViewAdapter(mainViewModel)
        binding.scoreRecyclerView.showVertical(requireContext())
    }
}