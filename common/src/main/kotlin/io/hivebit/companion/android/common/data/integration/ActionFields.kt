package io.hivebit.companion.android.common.data.integration

import io.hivebit.companion.android.common.util.AnySerializer
import kotlinx.serialization.Serializable

@Serializable
data class ActionFields(
    val name: String? = null,
    val description: String? = null,
    @Serializable(with = AnySerializer::class)
    val example: Any? = null,
    val values: List<String>? = null,
)
