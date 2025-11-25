package io.hivebit.companion.android.onboarding.welcome

import androidx.compose.runtime.Composable
import com.android.tools.screenshot.PreviewTest
import io.hivebit.companion.android.common.compose.theme.HAThemeForPreview
import io.hivebit.companion.android.compose.HAPreviews

class WelcomeScreenshotTest {

    @PreviewTest
    @HAPreviews
    @Composable
    fun `WelcomeScreen`() {
        HAThemeForPreview {
            WelcomeScreen(onConnectClick = {}, onLearnMoreClick = {})
        }
    }
}
