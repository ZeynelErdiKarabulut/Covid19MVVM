package com.zeynelerdi.covid19status.ui.onboarding

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.zeynelerdi.covid19status.MainApplication
import com.zeynelerdi.covid19status.R
import com.zeynelerdi.covid19status.databinding.ActivityOnboardingBinding
import com.zeynelerdi.covid19status.ui.main.MainActivity
import com.zeynelerdi.covid19status.utils.viewModelProvider
import javax.inject.Inject


class OnboardingActivity : AppCompatActivity() {

    private val appComponents by lazy { MainApplication.appComponents }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private fun getViewModel(): OnboardingViewModel {
        return viewModelProvider(viewModelFactory)
    }

    private lateinit var binding: ActivityOnboardingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        appComponents.inject(this)
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_onboarding)

        initViews()
    }

    private fun initViews() {
        Handler().postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }, 2000)
    }
}