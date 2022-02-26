package com.example.presentation.view

import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.presentation.R
import com.example.presentation.base.BaseFragment
import com.example.presentation.databinding.FragmentWomanNameBinding
import com.example.presentation.viewmodel.MainViewModel

class WomanNameFragment : BaseFragment<FragmentWomanNameBinding>(R.layout.fragment_woman_name) {
    private val mainViewModel by activityViewModels<MainViewModel>()

    override fun init() {
        binding.fragment = this
    }

    fun nextBtnClick(view: View) {
        mainViewModel.womanNameResult = binding.nameEditTextWomen.text.toString()
        this.findNavController().navigate(R.id.action_womanNameFragment_to_manNameFragment)
    }
}