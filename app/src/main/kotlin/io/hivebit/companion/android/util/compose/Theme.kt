package io.hivebit.companion.android.util.compose

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.LocalContentColor
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.glance.GlanceTheme
import androidx.glance.color.ColorProviders
import androidx.glance.material.ColorProviders
import androidx.glance.text.FontWeight
import androidx.glance.text.TextStyle
import io.hivebit.companion.android.common.compose.theme.DarkHAColorScheme
import io.hivebit.companion.android.common.compose.theme.LightHAColorScheme
import io.hivebit.companion.android.common.compose.theme.LocalHAColorScheme

// Hivebit Brand Colors
val colorPrimary = Color(0xFFC7B19A)  // Hivebit Primary - Warm Beige
val colorPrimaryDark = Color(0xFF232323)  // Hivebit Accent - Dark
val darkColorBackground = Color(0xFF1A1A1A)  // Hivebit Dark Background

const val STEP_SCREEN_MAX_WIDTH_DP = 600.0f

private val hivebitLightColors = lightColors(
    primary = colorPrimary,  // #C7B19A - Hivebit Gold
    primaryVariant = Color(0xFFB79D87),  // Deep Gold
    secondary = colorPrimary,
    secondaryVariant = colorPrimary,
    background = Color(0xFFF9F7F4),  // Off-White background
    surface = Color(0xFFFFFFFF),  // White surface
    error = Color(0xFFE57373),  // Soft red error
    onPrimary = Color(0xFF1E1E1E),  // Charcoal on primary
    onSecondary = Color(0xFF1E1E1E),  // Charcoal on secondary
    onBackground = Color(0xFF1C1C1C),  // Text primary
    onSurface = Color(0xFF1C1C1C),  // Text primary
    onError = Color(0xFFFFFFFF),  // White on error
)
private val hivebitDarkColors = darkColors(
    primary = colorPrimary,  // #C7B19A - Hivebit Gold
    primaryVariant = Color(0xFFB79D87),  // Deep Gold
    secondary = colorPrimary,
    secondaryVariant = colorPrimary,
    background = darkColorBackground,  // #1A1A1A - Ultra-dark grey
    surface = Color(0xFF242424),  // Graphite surface
    error = Color(0xFFE57373),  // Soft red error
    onPrimary = Color(0xFF1E1E1E),  // Charcoal on primary
    onSecondary = Color(0xFF1E1E1E),  // Charcoal on secondary
    onBackground = Color(0xFFFFFFFF),  // White text
    onSurface = Color(0xFFFFFFFF),  // White text
    onError = Color(0xFFFFFFFF),  // White on error
)

/**
 * A Compose [MaterialTheme] version of the Hivebit app theme.
 * Uses Hivebit brand colors (Warm Beige primary, Dark accent).
 */
@Composable
fun HivebitAppTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colors = if (isSystemInDarkTheme()) hivebitDarkColors else hivebitLightColors,
    ) {
        // Copied from MdcTheme:
        CompositionLocalProvider(
            LocalContentColor provides MaterialTheme.colors.onBackground,
            // To be able to use HA composable in old theme
            LocalHAColorScheme provides if (isSystemInDarkTheme()) DarkHAColorScheme else LightHAColorScheme,
            content = content,
        )
    }
}

/**
 * Backwards compatibility alias for HomeAssistant theme.
 * @deprecated Use HivebitAppTheme instead.
 */
@Deprecated("Use HivebitAppTheme", ReplaceWith("HivebitAppTheme(content)"))
@Composable
fun HomeAssistantAppTheme(content: @Composable () -> Unit) = HivebitAppTheme(content)

@Composable
fun HivebitGlanceTheme(
    colors: ColorProviders = HivebitGlanceTheme.colors,
    content: @Composable () -> Unit,
) {
    CompositionLocalProvider(
        LocalGlanceColors provides colors,
    ) {
        GlanceTheme(colors = LocalGlanceColors.current, content = content)
    }
}

object HivebitGlanceTypography {
    val titleLarge: TextStyle
        @Composable
        get() = TextStyle(
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = HivebitGlanceTheme.colors.onSurface,
        )
    val titleMedium: TextStyle
        @Composable
        get() = TextStyle(
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium,
            color = HivebitGlanceTheme.colors.onSurface,
        )
    val titleSmall: TextStyle
        @Composable
        get() = TextStyle(
            fontSize = 18.sp,
            fontWeight = FontWeight.Normal,
            color = HivebitGlanceTheme.colors.onSurface,
        )
    val bodyLarge: TextStyle
        @Composable
        get() = TextStyle(
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            color = HivebitGlanceTheme.colors.onSurface,
        )
    val bodyMedium: TextStyle
        @Composable
        get() = TextStyle(
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium,
            color = HivebitGlanceTheme.colors.onSurface,
        )
    val bodySmall: TextStyle
        @Composable
        get() = TextStyle(
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal,
            color = HivebitGlanceTheme.colors.onSurface,
        )
}

object HivebitGlanceDimensions {
    val iconSize: Dp
        @Composable
        get() = 48.dp
}

val glanceHaLightColors = lightColors(
    primary = colorPrimary,  // #C7B19A - Hivebit Gold
    primaryVariant = colorPrimaryDark,  // #232323 - Hivebit Black
    secondary = colorPrimary,
    secondaryVariant = colorPrimary,
    background = Color(0xFFF9F7F4),  // Off-White
    surface = Color(0xFFFFFFFF),  // White
    onPrimary = Color(0xFF1E1E1E),  // Charcoal
    onSecondary = Color(0xFF1E1E1E),  // Charcoal
    onBackground = Color(0xFF1C1C1C),  // Text primary
    onSurface = Color(0xFF1C1C1C),  // Text primary
)

val glanceHaDarkColors = darkColors(
    primary = colorPrimary,  // #C7B19A - Hivebit Gold
    primaryVariant = colorPrimaryDark,  // #232323 - Hivebit Black
    secondary = colorPrimary,
    secondaryVariant = colorPrimary,
    background = darkColorBackground,  // #1A1A1A
    surface = Color(0xFF242424),  // Graphite
    onPrimary = Color(0xFF1E1E1E),  // Charcoal
    onSecondary = Color(0xFF1E1E1E),  // Charcoal
    onBackground = Color.White,
    onSurface = Color.White,
)

internal val LocalGlanceColors: ProvidableCompositionLocal<ColorProviders> = staticCompositionLocalOf {
    ColorProviders(glanceHaLightColors, glanceHaDarkColors)
}

object HivebitGlanceTheme {
    val colors: ColorProviders
        @Composable
        get() = LocalGlanceColors.current
    val typography: HivebitGlanceTypography
        @Composable
        get() = HivebitGlanceTypography
    val dimensions: HivebitGlanceDimensions
        @Composable
        get() = HivebitGlanceDimensions
}
