package io.hivebit.companion.android.common.data.integration

import io.hivebit.companion.android.common.util.AppVersion
import io.hivebit.companion.android.common.util.MessagingToken
import javax.inject.Qualifier

data class DeviceRegistration(
    val appVersion: AppVersion? = null,
    val deviceName: String? = null,
    var pushToken: MessagingToken? = null,
    var pushWebsocket: Boolean = true,
)

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class PushWebsocketSupport
