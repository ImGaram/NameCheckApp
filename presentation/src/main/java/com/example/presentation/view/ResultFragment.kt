package com.example.presentation.view

import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.presentation.R
import com.example.presentation.base.BaseFragment
import com.example.presentation.databinding.FragmentResultBinding
import com.example.presentation.viewmodel.MainViewModel
import java.text.SimpleDateFormat
import java.util.*

class ResultFragment : BaseFragment<FragmentResultBinding>(R.layout.fragment_result) {
    private val mainViewModel by activityViewModels<MainViewModel>()

    override fun init() {
        binding.fragment = this
        initResult()
        saveScore()
    }

    private fun initResult() {
        binding.score.text = mainViewModel.apiCallResult.percentage.toString()
        when(mainViewModel.apiCallResult.percentage) {
            in 0..20 -> setLoveMsgText("조금 힘들어 보여요")
            in 21..40 -> setLoveMsgText("노력해 보세요")
            in 41..70 -> setLoveMsgText("기대해도 좋겠는데요?")
            in 71..90 -> setLoveMsgText("일단 축하드려요")
            in 91..99 -> setLoveMsgText("와우..눈을 의심하고 있어요")
            100 -> {
                saveStatistics()
                setLoveMsgText("완벽하네요! 축하드려요")
            }
            else -> setLoveMsgText("알 수 없는 힘?!")
        }
    }

    private fun saveStatistics() {
        mainViewModel.getStatistics()
            .addOnSuccessListener {
                if (it != null) mainViewModel.setStatistics(it.value.toString().toInt() + 1)
                    .addOnFailureListener {
                        error()
                    }
            }.addOnFailureListener {
                error()
            }
    }

    private fun saveScore() = with(mainViewModel.apiCallResult) {
        mainViewModel.setScore(this.fname, this.sname, this.percentage, nowTime())
    }

    private fun nowTime(): String = SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분", Locale("ko", "KR")).format(
        Date(System.currentTimeMillis())
    )

    private fun error() = shortShowToast("통계를 저장하는데 오류가 발생했습니다.")

    private fun setLoveMsgText(msg: String) = binding.message.setText(msg)

    fun backMainBtnClick(view: View) {
        this.findNavController().navigate(R.id.action_resultFragment_to_mainFragment)
    }
}