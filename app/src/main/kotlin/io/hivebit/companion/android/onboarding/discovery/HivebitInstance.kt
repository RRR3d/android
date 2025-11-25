package io.hivebit.companion.android.onboarding.discovery

import io.hivebit.companion.android.common.data.HivebitVersion
import java.net.URL

data class HivebitInstance(val name: String, val url: URL, val version: HivebitVersion)
