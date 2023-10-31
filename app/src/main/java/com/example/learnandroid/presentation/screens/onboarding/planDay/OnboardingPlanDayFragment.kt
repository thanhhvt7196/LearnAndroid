package com.example.learnandroid.presentation.screens.onboarding.planDay

import androidx.fragment.app.viewModels
import com.example.learnandroid.databinding.FragmentOnboardingPlanDayBinding
import com.example.learnandroid.domain.models.WeekDay
import com.example.learnandroid.presentation.screens.base.BaseViewBindingFragment

class OnboardingPlanDayFragment : BaseViewBindingFragment<FragmentOnboardingPlanDayBinding, OnboardingPlanDayViewModel>(FragmentOnboardingPlanDayBinding::inflate) {
    override val viewModel: OnboardingPlanDayViewModel by viewModels()

    interface OnboardingPlanDayDelegate {
        fun didSelectPlanDays(planDays: List<WeekDay>)
    }

    private var delegate: OnboardingPlanDayDelegate? = null

    companion object {
        const val tag = "OnboardingPlanDayFragment"
        fun newInstance(): OnboardingPlanDayFragment {
            return OnboardingPlanDayFragment()
        }
    }

    fun setAction(delegate: OnboardingPlanDayDelegate) {
        this.delegate = delegate
    }

    override fun setup() {
        super.setup()
        setupUI()
        setupBinding()
    }

    private fun setupUI() {

    }

    private fun setupBinding() {

    }

    fun resetData() {
        viewModel.resetData()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        delegate = null
    }

    override fun onDestroy() {
        super.onDestroy()
        delegate = null
    }
}