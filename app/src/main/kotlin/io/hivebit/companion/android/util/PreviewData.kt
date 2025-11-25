package io.hivebit.companion.android.util

import io.hivebit.companion.android.common.data.HivebitVersion
import io.hivebit.companion.android.common.data.integration.Entity
import io.hivebit.companion.android.database.notification.NotificationItem
import io.hivebit.companion.android.database.server.Server
import io.hivebit.companion.android.database.server.ServerConnectionInfo
import io.hivebit.companion.android.database.server.ServerSessionInfo
import io.hivebit.companion.android.database.server.ServerUserInfo
import io.hivebit.companion.android.onboarding.discovery.HivebitInstance
import java.net.URL
import java.time.LocalDateTime

val notificationItem = NotificationItem(1, 1636389288682, "testing", "{\"message\":\"test\"}", "FCM", null)

val wearDeviceName = "Device Name"

val attributes: Map<String, *> = mapOf(
    "friendly_name" to "Testing",
    "icon" to "mdi:cellphone",
)

private val localDateTime: LocalDateTime = LocalDateTime.now()

val previewEntity1 = Entity("light.test", "on", attributes, localDateTime, localDateTime)
val previewEntity2 = Entity("scene.testing", "on", attributes, localDateTime, localDateTime)
val previewEntity3 = Entity("switch.testing", "on", attributes, localDateTime, localDateTime)

val previewEntityList = mapOf(
    previewEntity1.entityId to previewEntity1,
    previewEntity2.entityId to previewEntity2,
    previewEntity3.entityId to previewEntity3,
)

val previewFavoritesList = listOf("light.test")

val homeAssistantInstance1 =
    HivebitInstance(
        name = "Home",
        url = URL("https://google.com"),
        version = HivebitVersion(year = 2024, month = 1, release = 1),
    )
val homeAssistantInstance2 =
    HivebitInstance(
        name = "Vacation Home",
        url = URL("http://localhost"),
        version = HivebitVersion(year = 2024, month = 1, release = 1),
    )

val previewServer1 =
    Server(
        id = 0,
        _name = "Home",
        listOrder = -1,
        connection = ServerConnectionInfo(externalUrl = ""),
        session = ServerSessionInfo(),
        user = ServerUserInfo(),
    )
val previewServer2 =
    Server(
        id = 1,
        _name = "Friends home",
        listOrder = -1,
        connection = ServerConnectionInfo(externalUrl = ""),
        session = ServerSessionInfo(),
        user = ServerUserInfo(),
    )
