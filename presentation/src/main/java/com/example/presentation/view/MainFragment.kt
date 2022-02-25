package com.example.presentation.view

import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.presentation.R
import com.example.presentation.base.BaseFragment
import com.example.presentation.databinding.FragmentMainBinding

class MainFragment : BaseFragment<FragmentMainBinding>(R.layout.fragment_main) {
    override fun init() {
        binding.fragment = this
    }

    fun startBtnClick(view:View) {
        this.findNavController().navigate(R.id.action_mainFragment_to_womanNameFragment)
    }
}