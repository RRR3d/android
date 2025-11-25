package io.hivebit.companion.android.common.data.websocket.impl.entities

import kotlinx.serialization.Serializable

@Serializable
data class DeviceRegistryResponse(val areaId: String? = null, val id: String)
