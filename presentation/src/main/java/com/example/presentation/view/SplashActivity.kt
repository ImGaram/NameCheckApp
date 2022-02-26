package com.example.presentation.view

import androidx.activity.viewModels
import com.example.presentation.R
import com.example.presentation.base.BaseActivity
import com.example.presentation.databinding.ActivitySplashBinding
import com.example.presentation.viewmodel.SplashViewModel
import com.example.presentation.widget.extension.startActivityAndFinish
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashActivity : BaseActivity<ActivitySplashBinding>(R.layout.activity_splash) {
    private val splashViewModel by viewModels<SplashViewModel>()
    private val appVersion = "1.0.0"

    override fun init() {
        splashViewModel.checkAppVersion().addOnSuccessListener {
            if (appVersion == it.value) {
                this.startActivityAndFinish(this, MainActivity::class.java)
            } else longShowToast("앱 버전이 다릅니다")
        }.addOnFailureListener {
            shortShowToast("오류가 발생했습니다, 오류 코드 - ${it.message}")
        }
    }
}