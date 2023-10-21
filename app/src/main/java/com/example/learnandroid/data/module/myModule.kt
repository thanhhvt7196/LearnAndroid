package com.example.learnandroid.data.module

import com.example.learnandroid.presentation.screens.login.LoginViewModel
import com.example.learnandroid.presentation.screens.loginBottomSheet.LoginBottomSheetViewModel
import com.example.learnandroid.presentation.screens.main.MainViewModel
import com.example.learnandroid.presentation.screens.profile.ProfileViewModel
import com.example.learnandroid.presentation.screens.plan.PlansViewModel
import com.example.learnandroid.presentation.screens.nutrition.NutritionViewModel
import com.example.learnandroid.presentation.screens.onboarding.gender.OnboardingGenderViewModel
import com.example.learnandroid.presentation.screens.onboarding.goal.OnboardingGoalViewModel
import com.example.learnandroid.presentation.screens.onboarding.name.OnboardingNameViewModel
import com.example.learnandroid.presentation.screens.workouts.WorkoutsViewModel
import org.koin.dsl.module

val viewModelModule = module {
    single { MainViewModel() }
    single { LoginViewModel() }
    single { LoginBottomSheetViewModel() }
    single { OnboardingGenderViewModel() }
    single { OnboardingGoalViewModel() }
    single { OnboardingNameViewModel() }
    single { PlansViewModel() }
    single { ProfileViewModel() }
    single { NutritionViewModel() }
    single { WorkoutsViewModel() }
}