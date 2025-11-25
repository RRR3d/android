package io.hivebit.companion.android.developer

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import com.android.tools.screenshot.PreviewTest
import io.hivebit.companion.android.common.compose.composable.ButtonVariant
import io.hivebit.companion.android.common.compose.theme.HAThemeForPreview
import io.hivebit.companion.android.developer.catalog.catalogButtonsAndIndicatorsSection
import io.hivebit.companion.android.developer.catalog.catalogTextAndBannersSection
import io.hivebit.companion.android.developer.catalog.catalogUserInputSection

class HAComposeCatalogScreenshotTest {

    @CatalogScreenPreview
    @PreviewTest
    @Composable
    fun HAButtonsAndIndicatorsScreen() {
        HAThemeForPreview {
            LazyColumn {
                catalogButtonsAndIndicatorsSection(ButtonVariant.PRIMARY)
            }
        }
    }

    @CatalogScreenPreview
    @PreviewTest
    @Composable
    fun HAUserInputScreen() {
        HAThemeForPreview {
            LazyColumn {
                catalogUserInputSection()
            }
        }
    }

    @CatalogScreenPreview
    @PreviewTest
    @Composable
    fun HATextAndBannersScreen() {
        HAThemeForPreview {
            LazyColumn {
                catalogTextAndBannersSection()
            }
        }
    }
}
