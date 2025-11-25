package io.hivebit.companion.android.onboarding

import androidx.annotation.StringRes

interface OnboardingView {
    fun startIntegration(serverId: Int)

    fun onInstanceFound(instance: HivebitInstance)
    fun onInstanceLost(instance: HivebitInstance)

    fun showLoading()

    fun showContinueOnPhone()

    fun showError(@StringRes message: Int? = null)
}
