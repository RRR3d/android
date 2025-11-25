package io.hivebit.companion.android.loading

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.android.tools.screenshot.PreviewTest
import io.hivebit.companion.android.common.compose.theme.HAThemeForPreview
import io.hivebit.companion.android.compose.HAPreviews

class LoadingScreenshotTest {

    @PreviewTest
    @HAPreviews
    @Composable
    fun `LoadingScreen`() {
        HAThemeForPreview {
            LoadingScreen(modifier = Modifier)
        }
    }
}
