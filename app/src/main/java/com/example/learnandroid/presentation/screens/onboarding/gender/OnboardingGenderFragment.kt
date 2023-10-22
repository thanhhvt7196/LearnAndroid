package com.example.learnandroid.presentation.screens.onboarding.gender

import android.util.Log
import android.view.View.OnClickListener
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import com.example.learnandroid.databinding.FragmentOnboardingGenderBinding
import com.example.learnandroid.domain.models.Gender
import com.example.learnandroid.presentation.screens.base.BaseViewBindingFragment
import com.example.learnandroid.presentation.screens.login.LoginFragment
import com.example.learnandroid.presentation.screens.loginBottomSheet.LoginBottomSheetFragment
import com.example.learnandroid.presentation.screens.loginBottomSheet.LoginType
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class OnboardingGenderFragment :
    BaseViewBindingFragment<FragmentOnboardingGenderBinding, OnboardingGenderViewModel>(
        FragmentOnboardingGenderBinding::inflate
    ) {
    var loginAction: OnClickListener?=null
    override val viewModel: OnboardingGenderViewModel by viewModels()

    private val _gender = MutableSharedFlow<Gender?>()
    val gender: SharedFlow<Gender?> = _gender.asSharedFlow()
    private val _loginType = MutableSharedFlow<LoginType>()
    val loginType: SharedFlow<LoginType> = _loginType.asSharedFlow()

    companion object {
        const val tag = "OnboardingGenderFragment"
        fun newInstance(): OnboardingGenderFragment {
            return OnboardingGenderFragment()
        }
    }

    override fun initView() {
        viewBinding.apply {
            maleButton.setOnClickListener {
                viewModel.viewModelScope.launch {
                    viewModel.setGender(Gender.MALE)
                }
            }
            femaleButton.setOnClickListener {
                viewModel.viewModelScope.launch {
                    viewModel.setGender(Gender.FEMALE)
                }
            }

            loginButton.setOnClickListener {
                val loginBottomSheet = LoginBottomSheetFragment.newInstance()
                loginBottomSheet.setOnClick(loginAction)

                loginBottomSheet.show(
                    requireActivity().supportFragmentManager,
                    loginBottomSheet.tag
                )
            }
        }
    }

    override suspend fun subscribeData() {
        viewModel.viewModelScope.launch {
            viewModel.gender.collect { gender ->
                viewBinding.maleButton.isSelected = gender == Gender.MALE
                viewBinding.femaleButton.isSelected = gender == Gender.FEMALE
            }
        }

        viewModel.viewModelScope.launch {
            viewModel.gender.collect {
                _gender.emit(it)
            }
        }
    }

    fun setOnclick(loginFragment: OnClickListener) {
        this.loginAction = loginFragment
    }

    override fun onDestroyView() {
        super.onDestroyView()
        this.loginAction =null
    }
}