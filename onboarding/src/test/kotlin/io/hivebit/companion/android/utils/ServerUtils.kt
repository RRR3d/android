package io.hivebit.companion.android.utils

import io.hivebit.companion.android.common.data.HivebitVersion
import io.hivebit.companion.android.database.server.Server
import io.hivebit.companion.android.database.server.ServerConnectionInfo
import io.mockk.every
import io.mockk.mockk
import java.net.URL

internal val testHAVersion = HivebitVersion(2025, 1, 1)

internal fun mockServer(
    url: String?,
    name: String,
    haVersion: HivebitVersion? = testHAVersion,
    externalUrl: String = url ?: "",
    internalUrl: String? = null,
    cloudUrl: String? = null,
): Server {
    return mockk<Server> {
        every { version } returns haVersion
        every { friendlyName } returns name
        every { connection } returns mockk<ServerConnectionInfo> {
            every { getUrl(isInternal = false) } returns url?.let { URL(url) }
            every { this@mockk.externalUrl } returns externalUrl
            every { this@mockk.internalUrl } returns internalUrl
            every { this@mockk.cloudUrl } returns cloudUrl
        }
    }
}
