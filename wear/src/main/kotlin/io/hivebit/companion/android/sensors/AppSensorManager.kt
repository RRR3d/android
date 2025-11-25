package io.hivebit.companion.android.sensors

import io.hivebit.companion.android.BuildConfig
import io.hivebit.companion.android.common.sensors.AppSensorManagerBase

class AppSensorManager : AppSensorManagerBase() {

    override fun getCurrentVersion(): String = BuildConfig.VERSION_NAME
}
