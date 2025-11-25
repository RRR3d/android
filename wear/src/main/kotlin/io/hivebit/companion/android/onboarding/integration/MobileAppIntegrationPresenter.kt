package io.hivebit.companion.android.onboarding.integration

interface MobileAppIntegrationPresenter {
    fun onRegistrationAttempt(serverId: Int, deviceName: String)
    fun onFinish()
}
