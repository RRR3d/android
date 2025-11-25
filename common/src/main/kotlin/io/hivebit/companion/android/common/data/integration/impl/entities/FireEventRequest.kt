package io.hivebit.companion.android.common.data.integration.impl.entities

import io.hivebit.companion.android.common.util.MapAnySerializer
import kotlinx.serialization.Polymorphic
import kotlinx.serialization.Serializable

@Serializable
data class FireEventRequest(
    val eventType: String,
    @Serializable(with = MapAnySerializer::class)
    val eventData: Map<String, @Polymorphic Any?>,
)
