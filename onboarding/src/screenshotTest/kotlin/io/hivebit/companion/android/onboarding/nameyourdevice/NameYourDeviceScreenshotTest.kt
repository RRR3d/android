package io.hivebit.companion.android.onboarding.nameyourdevice

import androidx.compose.runtime.Composable
import com.android.tools.screenshot.PreviewTest
import io.hivebit.companion.android.common.compose.theme.HAThemeForPreview
import io.hivebit.companion.android.compose.HAPreviews

class NameYourDeviceScreenshotTest {
    @PreviewTest
    @HAPreviews
    @Composable
    fun `NameYourDevice empty`() {
        HAThemeForPreview {
            NameYourDeviceScreen(
                onBackClick = {},
                deviceName = "",
                onDeviceNameChange = {},
                saveClickable = false,
                deviceNameEditable = true,
                onSaveClick = {},
                onHelpClick = {},
            )
        }
    }

    @PreviewTest
    @HAPreviews
    @Composable
    fun `NameYourDevice with a name`() {
        HAThemeForPreview {
            NameYourDeviceScreen(
                onBackClick = {},
                deviceName = "Superman",
                onDeviceNameChange = {},
                saveClickable = true,
                deviceNameEditable = true,
                onSaveClick = {},
                onHelpClick = {},
            )
        }
    }
}
