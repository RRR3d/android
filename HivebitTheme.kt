package io.hivebit.companion.android.common.compose.theme

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier

/**
 * A custom theme built on top of [androidx.compose.material3.MaterialTheme] with Hivebit colors.
 *
 * @param darkTheme Whether to use the dark theme. Defaults to the system setting.
 * @param content The content of the theme.
 */
@Composable
fun HivebitTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    CompositionLocalProvider(
        LocalHivebitColorScheme provides if (darkTheme) DarkHivebitColorScheme else LightHivebitColorScheme,
    ) {
        MaterialTheme(
            content = content,
            colorScheme = MaterialTheme.colorScheme.copy(
                // Override the surface so that Composable like Scaffold use the right background color without
                // manually injecting the color.
                surface = LocalHivebitColorScheme.current.colorSurfaceDefault,
                background = LocalHivebitColorScheme.current.colorSurfaceDefault,
                // Used by ModalBottomSheetDefaults.containerColor
                surfaceContainerLow = LocalHivebitColorScheme.current.colorSurfaceDefault,
                // Used for text selection
                primary = LocalHivebitColorScheme.current.colorOnPrimaryNormal,
            ),
        )
    }
}

/**
 * Small wrapper around [HivebitTheme] for previews/screenshot tests which:
 * - applies the theme
 * - adds a container with a background color around the content
 */
@SuppressLint("ComposeModifierMissing")
@Composable
fun HivebitThemeForPreview(content: @Composable BoxScope.() -> Unit) {
    HivebitTheme {
        Box(modifier = Modifier.background(LocalHivebitColorScheme.current.colorSurfaceDefault), content = content)
    }
}
