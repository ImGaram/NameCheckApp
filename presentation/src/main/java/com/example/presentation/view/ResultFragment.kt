package com.example.presentation.view

import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.presentation.R
import com.example.presentation.base.BaseFragment
import com.example.presentation.databinding.FragmentResultBinding

class ResultFragment : BaseFragment<FragmentResultBinding>(R.layout.fragment_result) {
    override fun init() {
        binding.fragment = this
    }

    fun backMainBtnClick(view: View) {
        this.findNavController().navigate(R.id.action_resultFragment_to_mainFragment)
    }
}