package io.hivebit.companion.android.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.wear.compose.material3.ButtonDefaults
import androidx.wear.compose.material3.ColorScheme
import androidx.wear.compose.material3.SliderDefaults
import androidx.wear.compose.material3.SwitchButtonDefaults

// Hivebit Brand Colors - Warm Beige Primary
val md_theme_dark_primary = Color(0xFFC7B19A)  // Hivebit Primary
val md_theme_dark_onPrimary = Color(0xFF1E1E1E)  // Charcoal Black
val md_theme_dark_primaryContainer = Color(0xFFB79D87)  // Hivebit Primary Variant
val md_theme_dark_onPrimaryContainer = Color(0xFF1E1E1E)  // Charcoal on container
val md_theme_dark_secondary = Color(0xFFB79D87)  // Hivebit Secondary
val md_theme_dark_onSecondary = Color(0xFF1E1E1E)  // Charcoal
val md_theme_dark_secondaryContainer = Color(0xFF2E2E2E)  // Dark Surface
val md_theme_dark_onSecondaryContainer = Color(0xFFC7B19A)  // Hivebit Primary
val md_theme_dark_tertiary = Color(0xFFC7B19A)  // Hivebit Primary for accents
val md_theme_dark_onTertiary = Color(0xFF1E1E1E)  // Charcoal
val md_theme_dark_tertiaryContainer = Color(0xFFB79D87)  // Hivebit Variant
val md_theme_dark_onTertiaryContainer = Color(0xFF1E1E1E)  // Charcoal
val md_theme_dark_error = Color(0xFFE57373)  // Hivebit Error - Soft Red
val md_theme_dark_onError = Color(0xFF1E1E1E)  // Charcoal
val md_theme_dark_onBackground = Color(0xFFA19C96)  // Hivebit Dark Text Secondary
val md_theme_dark_onSurfaceVariant = Color(0xFFA19C96)  // Hivebit Dark Text Secondary
val md_theme_dark_outline = Color(0xFF7A756F)  // Muted text
val md_theme_dark_outlineVariant = Color(0xFF2E2E2E)  // Dark surface variant

internal val wearColorScheme: ColorScheme = ColorScheme(
    primary = md_theme_dark_primary,
    onPrimary = md_theme_dark_onPrimary,
    primaryContainer = md_theme_dark_primaryContainer,
    onPrimaryContainer = md_theme_dark_onPrimaryContainer,
    secondary = md_theme_dark_secondary,
    onSecondary = md_theme_dark_onSecondary,
    secondaryContainer = md_theme_dark_secondaryContainer,
    onSecondaryContainer = md_theme_dark_onSecondaryContainer,
    tertiary = md_theme_dark_tertiary,
    onTertiary = md_theme_dark_onTertiary,
    tertiaryContainer = md_theme_dark_tertiaryContainer,
    onTertiaryContainer = md_theme_dark_onTertiaryContainer,
    error = md_theme_dark_error,
    onError = md_theme_dark_onError,
    background = Color.Black,
    onBackground = md_theme_dark_onBackground,
    surfaceContainer = Color.Black,
    onSurfaceVariant = md_theme_dark_onSurfaceVariant,
    outline = md_theme_dark_outline,
    outlineVariant = md_theme_dark_outlineVariant,
)

@Composable
fun getSwitchButtonColors() = SwitchButtonDefaults.switchButtonColors(
    checkedThumbColor = wearColorScheme.tertiary,
    checkedTrackColor = wearColorScheme.onTertiary,
    checkedTrackBorderColor = wearColorScheme.tertiary,
    checkedThumbIconColor = wearColorScheme.tertiary,
    checkedContainerColor = wearColorScheme.surfaceContainerHigh,
    uncheckedContainerColor = wearColorScheme.surfaceContainerLow,
)

@Composable
fun getFilledTonalButtonColors() = ButtonDefaults.filledTonalButtonColors(
    containerColor = wearColorScheme.surfaceContainerLow,
    disabledContainerColor = wearColorScheme.surfaceContainerLow.copy(alpha = 0.38f),
)

@Composable
fun getPrimaryButtonColors() = ButtonDefaults.buttonColors(containerColor = wearColorScheme.primary)

@Composable
fun getInlineSliderDefaultColors() = SliderDefaults.sliderColors(
    containerColor = wearColorScheme.surfaceContainerLow,
)
