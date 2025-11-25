package io.hivebit.companion.android.common.compose.theme

import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import io.hivebit.companion.android.common.compose.composable.ButtonVariant
import io.hivebit.companion.android.common.compose.theme.HivebitColors.Transparent

private object HivebitColors {
    val Black = Color(0xFF000000)
    val White = Color(0xFFFFFFFF)
    val Transparent = Color(0x00FFFFFF)

    // HiveBit Brand Colors - Premium Smart Home Color System
    // Primary Brand Color - Warm Beige
    val HivebitPrimary = Color(0xFFC7B19A)           // #C7B19A
    val HivebitPrimaryVariant = Color(0xFFB79D87)    // #B79D87
    val HivebitOnPrimary = Color(0xFF1E1E1E)         // #1E1E1E
    
    // Accent Brand Color - Modern Dark
    val HivebitAccent = Color(0xFF232323)            // #B79D87
    val HivebitAccentVariant = Color(0xFF2E2E2E)     // #B79D87
    val HivebitOnAccent = Color(0xFFFFFFFF)          // #FFFFFF
    
    // Light Mode Colors
    val LightBackground = Color(0xFFF9F7F4)          // #F9F7F4
    val LightSurface = Color(0xFFFFFFFF)             // #FFFFFF
    val LightSurfaceVariant = Color(0xFFF2EFEA)      // #F2EFEA
    val LightDivider = Color(0xFFD8D3CD)             // #D8D3CD
    val LightTextPrimary = Color(0xFF1C1C1C)         // #1C1C1C
    val LightTextSecondary = Color(0xFF7A756F)       // #7A756F
    val LightIcon = Color(0xFFC7B19A)                // #C7B19A
    
    // Dark Mode Colors
    val DarkBackground = Color(0xFF1A1A1A)           // #1A1A1A
    val DarkSurface = Color(0xFF242424)              // #242424
    val DarkSurfaceVariant = Color(0xFF2E2E2E)       // #2E2E2E
    val DarkTextPrimary = Color(0xFFFFFFFF)          // #FFFFFF
    val DarkTextSecondary = Color(0xFFA19C96)        // #A19C96
    val DarkIcon = Color(0xFFC7B19A)                 // #C7B19A
    
    // Status Colors
    val StatusOnline = Color(0xFF4CAF50)             // #4CAF50
    val StatusOffline = Color(0xFFB0ADA9)            // #B0ADA9
    val StatusError = Color(0xFFE57373)              // #E57373
    val StatusActiveAutomation = Color(0xFFC7B19A)   // #C7B19A
    val StatusStandby = Color(0xFF6D6A65)            // #6D6A65
    
    // Component Colors
    val ToggleActive = Color(0xFFC7B19A)             // #C7B19A
    val ToggleInactive = Color(0xFF6A6A6A)           // #6A6A6A

    // Primary
    val Primary05 = Color(0xFF001721)
    val Primary10 = Color(0xFF002E3E)
    val Primary20 = Color(0xFF004156)
    val Primary30 = Color(0xFF006787)
    val Primary40 = Color(0xFF009AC7)
    val Primary50 = Color(0xFF18BCF2)
    val Primary60 = Color(0xFF37C8FD)
    val Primary70 = Color(0xFF7BD4FB)
    val Primary80 = Color(0xFFB9E6FC)
    val Primary90 = Color(0xFFDFF3FC)
    val Primary95 = Color(0xFFEFF9FE)

    // Blue
    val Blue05 = Color(0xFF000F35)
    val Blue10 = Color(0xFF001A4E)
    val Blue20 = Color(0xFF002D77)
    val Blue30 = Color(0xFF003F9C)
    val Blue40 = Color(0xFF0053C0)
    val Blue50 = Color(0xFF0071EC)
    val Blue60 = Color(0xFF3E96FF)
    val Blue70 = Color(0xFF6EB3FF)
    val Blue80 = Color(0xFF9FCEFF)
    val Blue90 = Color(0xFFD1E8FF)
    val Blue95 = Color(0xFFE8F3FF)

    // Brand
    val Brand05 = Color(0xFF00222F)
    val Brand10 = Color(0xFF003D51)
    val Brand20 = Color(0xFF004E67)
    val Brand30 = Color(0xFF007093)
    val Brand40 = Color(0xFF00A4D4)
    val Brand50 = Color(0xFF1FBCF1)
    val Brand60 = Color(0xFF37C8FD)
    val Brand70 = Color(0xFF7BD4FB)
    val Brand80 = Color(0xFFB9E6FC)
    val Brand90 = Color(0xFFDFF3FC)
    val Brand95 = Color(0xFFEFF9FE)

    // Cyan
    val Cyan05 = Color(0xFF00151B)
    val Cyan10 = Color(0xFF002129)
    val Cyan20 = Color(0xFF003844)
    val Cyan30 = Color(0xFF014C5B)
    val Cyan40 = Color(0xFF026274)
    val Cyan50 = Color(0xFF078098)
    val Cyan60 = Color(0xFF00A3C0)
    val Cyan70 = Color(0xFF2FBEDC)
    val Cyan80 = Color(0xFF7FD6EC)
    val Cyan90 = Color(0xFFC5ECF7)
    val Cyan95 = Color(0xFFE3F6FB)

    // Green
    val Green05 = Color(0xFF031608)
    val Green10 = Color(0xFF052310)
    val Green20 = Color(0xFF0A3A1D)
    val Green30 = Color(0xFF0A5027)
    val Green40 = Color(0xFF036730)
    val Green50 = Color(0xFF00883C)
    val Green60 = Color(0xFF00AC49)
    val Green70 = Color(0xFF5DC36F)
    val Green80 = Color(0xFF93DA98)
    val Green90 = Color(0xFFC2F2C1)
    val Green95 = Color(0xFFE3F9E3)

    // Indigo
    val Indigo05 = Color(0xFF0D0A3A)
    val Indigo10 = Color(0xFF181255)
    val Indigo20 = Color(0xFF292381)
    val Indigo30 = Color(0xFF3933A7)
    val Indigo40 = Color(0xFF4945CB)
    val Indigo50 = Color(0xFF6163F2)
    val Indigo60 = Color(0xFF808AFF)
    val Indigo70 = Color(0xFF9DA9FF)
    val Indigo80 = Color(0xFFBCC7FF)
    val Indigo90 = Color(0xFFDFe5FF)
    val Indigo95 = Color(0xFFF0F2FF)

    // Neutral
    val Neutral05 = Color(0xFF141414)
    val Neutral10 = Color(0xFF202020)
    val Neutral20 = Color(0xFF363636)
    val Neutral30 = Color(0xFF4A4A4A)
    val Neutral40 = Color(0xFF5E5E5E)
    val Neutral50 = Color(0xFF7A7A7A)
    val Neutral60 = Color(0xFF989898)
    val Neutral70 = Color(0xFFB1B1B1)
    val Neutral80 = Color(0xFFCCCCCC)
    val Neutral90 = Color(0xFFE6E6E6)
    val Neutral95 = Color(0xFFF3F3F3)

    // Orange
    val Orange05 = Color(0xFF280700)
    val Orange10 = Color(0xFF3B0F00)
    val Orange20 = Color(0xFF5E1C00)
    val Orange30 = Color(0xFF7E2900)
    val Orange40 = Color(0xFF9D3800)
    val Orange50 = Color(0xFFC94E00)
    val Orange60 = Color(0xFFF36D00)
    val Orange70 = Color(0xFFFF9342)
    val Orange80 = Color(0xFFFFBB89)
    val Orange90 = Color(0xFFFFE0C8)
    val Orange95 = Color(0xFFFFF0E4)

    // Pink
    val Pink05 = Color(0xFF28041A)
    val Pink10 = Color(0xFF3C0828)
    val Pink20 = Color(0xFF5E1342)
    val Pink30 = Color(0xFF7D1E58)
    val Pink40 = Color(0xFF9E2A6C)
    val Pink50 = Color(0xFFC84382)
    val Pink60 = Color(0xFFE66BA3)
    val Pink70 = Color(0xFFF78DBF)
    val Pink80 = Color(0xFFFCB5D8)
    val Pink90 = Color(0xFFFEDDF0)
    val Pink95 = Color(0xFFFEFFF9)

    // Purple
    val Purple05 = Color(0xFF1E0532)
    val Purple10 = Color(0xFF2D0B48)
    val Purple20 = Color(0xFF491870)
    val Purple30 = Color(0xFF612692)
    val Purple40 = Color(0xFF7936B3)
    val Purple50 = Color(0xFF9951DB)
    val Purple60 = Color(0xFFB678F5)
    val Purple70 = Color(0xFFCA99FF)
    val Purple80 = Color(0xFFDDBDFF)
    val Purple90 = Color(0xFFEEDFFF)
    val Purple95 = Color(0xFFF7F0FF)

    // Red
    val Red05 = Color(0xFF2A040B)
    val Red10 = Color(0xFF3E0913)
    val Red20 = Color(0xFF631323)
    val Red30 = Color(0xFF8A132C)
    val Red40 = Color(0xFFB30532)
    val Red50 = Color(0xFFDC3146)
    val Red60 = Color(0xFFF3676C)
    val Red70 = Color(0xFFFD8F90)
    val Red80 = Color(0xFFFFB8B6)
    val Red90 = Color(0xFFFFDEDC)
    val Red95 = Color(0xFFFFF0EF)

    // Yellow
    val Yellow05 = Color(0xFF220C00)
    val Yellow10 = Color(0xFF331600)
    val Yellow20 = Color(0xFF532600)
    val Yellow30 = Color(0xFF6F3601)
    val Yellow40 = Color(0xFF8C4602)
    val Yellow50 = Color(0xFFB45F04)
    val Yellow60 = Color(0xFFDA7E00)
    val Yellow70 = Color(0xFFEF9D00)
    val Yellow80 = Color(0xFFFAC22B)
    val Yellow90 = Color(0xFFFFE495)
    val Yellow95 = Color(0xFFFEF3CD)
}



@Immutable
class HivebitButtonColors(val buttonColors: ButtonColors, val rippleColor: Color)

@Immutable
class HivebitIconButtonColors(val buttonColors: IconButtonColors, val rippleColor: Color)

@Immutable
class HivebitColorScheme(
    val colorFillPrimaryLoudResting: Color,
    val colorFillPrimaryNormalResting: Color,
    val colorFillPrimaryQuietResting: Color,
    val colorFillPrimaryLoudHover: Color,
    val colorFillPrimaryNormalHover: Color,
    val colorFillPrimaryQuietHover: Color,
    val colorFillPrimaryNormalActive: Color,
    val colorOnPrimaryLoud: Color,
    val colorOnPrimaryNormal: Color,
    val colorOnPrimaryQuiet: Color,

    val colorFillNeutralLoudResting: Color,
    val colorFillNeutralNormalResting: Color,
    val colorFillNeutralQuietResting: Color,
    val colorFillNeutralLoudHover: Color,
    val colorFillNeutralNormalHover: Color,
    val colorFillNeutralQuietHover: Color,
    val colorOnNeutralLoud: Color,
    val colorOnNeutralNormal: Color,
    val colorOnNeutralQuiet: Color,

    val colorFillDangerLoudResting: Color,
    val colorFillDangerNormalResting: Color,
    val colorFillDangerQuietResting: Color,
    val colorFillDangerLoudHover: Color,
    val colorFillDangerNormalHover: Color,
    val colorFillDangerQuietHover: Color,
    val colorOnDangerLoud: Color,
    val colorOnDangerNormal: Color,
    val colorOnDangerQuiet: Color,

    val colorFillWarningLoudResting: Color,
    val colorFillWarningNormalResting: Color,
    val colorFillWarningQuietResting: Color,
    val colorFillWarningLoudHover: Color,
    val colorFillWarningNormalHover: Color,
    val colorFillWarningQuietHover: Color,
    val colorOnWarningLoud: Color,
    val colorOnWarningNormal: Color,
    val colorOnWarningQuiet: Color,

    val colorFillSuccessLoudResting: Color,
    val colorFillSuccessNormalResting: Color,
    val colorFillSuccessQuietResting: Color,
    val colorFillSuccessLoudHover: Color,
    val colorFillSuccessNormalHover: Color,
    val colorFillSuccessQuietHover: Color,
    val colorOnSuccessLoud: Color,
    val colorOnSuccessNormal: Color,
    val colorOnSuccessQuiet: Color,

    val colorFillDisabledLoudResting: Color,
    val colorFillDisabledNormalResting: Color,
    val colorFillDisabledQuietResting: Color,

    val colorOnDisabledLoud: Color,
    val colorOnDisabledNormal: Color,
    val colorOnDisabledQuiet: Color,

    val colorSurfaceDefault: Color,

    val colorTextPrimary: Color,
    val colorTextSecondary: Color,
    val colorTextDisabled: Color,

    val colorTextLink: Color,

    val colorBorderPrimaryNormal: Color,
    val colorBorderPrimaryLoud: Color,

    val colorBorderNeutralQuiet: Color,
    val colorBorderNeutralNormal: Color,

    val colorBorderDangerNormal: Color,

    val colorOverlayModal: Color,
) {

    fun textField(): TextFieldColors {
        return TextFieldColors(
            focusedTextColor = colorTextPrimary,
            unfocusedTextColor = colorTextPrimary,
            disabledTextColor = colorTextDisabled,
            errorTextColor = colorOnDangerQuiet,

            focusedContainerColor = colorSurfaceDefault,
            unfocusedContainerColor = colorSurfaceDefault,
            disabledContainerColor = colorFillDisabledNormalResting,
            errorContainerColor = colorSurfaceDefault,

            cursorColor = colorBorderPrimaryNormal,
            errorCursorColor = colorBorderDangerNormal,

            textSelectionColors = TextSelectionColors(
                handleColor = colorFillPrimaryLoudHover,
                backgroundColor = colorFillPrimaryLoudResting,
            ),

            focusedIndicatorColor = colorBorderPrimaryNormal,
            unfocusedIndicatorColor = colorBorderNeutralQuiet,
            disabledIndicatorColor = colorFillDisabledLoudResting,
            errorIndicatorColor = colorBorderDangerNormal,

            focusedLeadingIconColor = colorOnNeutralQuiet,
            unfocusedLeadingIconColor = colorOnNeutralQuiet,
            disabledLeadingIconColor = colorOnNeutralQuiet,
            errorLeadingIconColor = colorOnNeutralQuiet,

            focusedTrailingIconColor = colorOnNeutralQuiet,
            unfocusedTrailingIconColor = colorOnNeutralQuiet,
            disabledTrailingIconColor = colorOnNeutralQuiet,
            errorTrailingIconColor = colorOnNeutralQuiet,

            focusedLabelColor = colorTextSecondary,
            unfocusedLabelColor = colorTextSecondary,
            disabledLabelColor = colorTextDisabled,
            errorLabelColor = colorTextSecondary,

            focusedPlaceholderColor = colorTextPrimary,
            unfocusedPlaceholderColor = colorTextPrimary,
            disabledPlaceholderColor = colorTextPrimary,
            errorPlaceholderColor = colorTextPrimary,

            focusedSupportingTextColor = colorTextPrimary,
            unfocusedSupportingTextColor = colorTextPrimary,
            disabledSupportingTextColor = colorTextDisabled,
            errorSupportingTextColor = colorOnDangerQuiet,

            focusedPrefixColor = colorOnNeutralQuiet,
            unfocusedPrefixColor = colorOnNeutralQuiet,
            disabledPrefixColor = colorOnNeutralQuiet,
            errorPrefixColor = colorOnNeutralQuiet,

            focusedSuffixColor = colorOnNeutralQuiet,
            unfocusedSuffixColor = colorOnNeutralQuiet,
            disabledSuffixColor = colorOnNeutralQuiet,
            errorSuffixColor = colorOnNeutralQuiet,
        )
    }

    fun accentButtonColorsFromVariant(variant: ButtonVariant): HivebitButtonColors {
        return when (variant) {
            ButtonVariant.PRIMARY -> {
                HivebitButtonColors(
                    ButtonColors(
                        containerColor = colorFillPrimaryLoudResting,
                        contentColor = colorOnPrimaryLoud,
                        disabledContainerColor = colorFillDisabledLoudResting,
                        disabledContentColor = colorOnDisabledLoud,
                    ),
                    colorFillPrimaryLoudHover,
                )
            }

            ButtonVariant.NEUTRAL -> {
                HivebitButtonColors(
                    ButtonColors(
                        containerColor = colorFillNeutralLoudResting,
                        contentColor = colorOnNeutralLoud,
                        disabledContainerColor = colorFillDisabledLoudResting,
                        disabledContentColor = colorOnDisabledLoud,
                    ),
                    colorFillNeutralLoudHover,
                )
            }

            ButtonVariant.DANGER -> {
                HivebitButtonColors(
                    ButtonColors(
                        containerColor = colorFillDangerLoudResting,
                        contentColor = colorOnDangerLoud,
                        disabledContainerColor = colorFillDisabledLoudResting,
                        disabledContentColor = colorOnDisabledLoud,
                    ),
                    colorFillDangerLoudHover,
                )
            }

            ButtonVariant.WARNING -> {
                HivebitButtonColors(
                    ButtonColors(
                        containerColor = colorFillWarningLoudResting,
                        contentColor = colorOnWarningLoud,
                        disabledContainerColor = colorFillDisabledLoudResting,
                        disabledContentColor = colorOnDisabledLoud,
                    ),
                    colorFillWarningLoudHover,
                )
            }

            ButtonVariant.SUCCESS -> {
                HivebitButtonColors(
                    ButtonColors(
                        containerColor = colorFillSuccessLoudResting,
                        contentColor = colorOnSuccessLoud,
                        disabledContainerColor = colorFillDisabledLoudResting,
                        disabledContentColor = colorOnDisabledLoud,
                    ),
                    colorFillSuccessLoudHover,
                )
            }
        }
    }

    fun filledButtonColorsFromVariant(variant: ButtonVariant): HivebitButtonColors {
        return when (variant) {
            ButtonVariant.PRIMARY -> {
                HivebitButtonColors(
                    ButtonColors(
                        containerColor = colorFillPrimaryNormalResting,
                        contentColor = colorOnPrimaryNormal,
                        disabledContainerColor = colorFillDisabledNormalResting,
                        disabledContentColor = colorOnDisabledNormal,
                    ),
                    colorFillPrimaryNormalHover,
                )
            }

            ButtonVariant.NEUTRAL -> {
                HivebitButtonColors(
                    ButtonColors(
                        containerColor = colorFillNeutralNormalResting,
                        contentColor = colorOnNeutralNormal,
                        disabledContainerColor = colorFillDisabledNormalResting,
                        disabledContentColor = colorOnDisabledNormal,
                    ),
                    colorFillNeutralNormalHover,
                )
            }

            ButtonVariant.DANGER -> {
                HivebitButtonColors(
                    ButtonColors(
                        containerColor = colorFillDangerNormalResting,
                        contentColor = colorOnDangerNormal,
                        disabledContainerColor = colorFillDisabledNormalResting,
                        disabledContentColor = colorOnDisabledNormal,
                    ),
                    colorFillDangerNormalHover,
                )
            }

            ButtonVariant.WARNING -> {
                HivebitButtonColors(
                    ButtonColors(
                        containerColor = colorFillWarningNormalResting,
                        contentColor = colorOnWarningNormal,
                        disabledContainerColor = colorFillDisabledNormalResting,
                        disabledContentColor = colorOnDisabledNormal,
                    ),
                    colorFillWarningNormalHover,
                )
            }

            ButtonVariant.SUCCESS -> {
                HivebitButtonColors(
                    ButtonColors(
                        containerColor = colorFillSuccessNormalResting,
                        contentColor = colorOnSuccessNormal,
                        disabledContainerColor = colorFillDisabledNormalResting,
                        disabledContentColor = colorOnDisabledNormal,
                    ),
                    colorFillSuccessNormalHover,
                )
            }
        }
    }

    fun plainButtonColorsFromVariant(variant: ButtonVariant): HivebitButtonColors {
        return when (variant) {
            ButtonVariant.PRIMARY -> {
                HivebitButtonColors(
                    ButtonColors(
                        containerColor = Transparent,
                        contentColor = colorOnPrimaryNormal,
                        disabledContainerColor = colorFillDisabledQuietResting,
                        disabledContentColor = colorOnDisabledQuiet,
                    ),
                    colorFillPrimaryQuietHover,
                )
            }

            ButtonVariant.NEUTRAL -> {
                HivebitButtonColors(
                    ButtonColors(
                        containerColor = Transparent,
                        contentColor = colorOnNeutralNormal,
                        disabledContainerColor = colorFillDisabledQuietResting,
                        disabledContentColor = colorOnDisabledQuiet,
                    ),
                    colorFillNeutralQuietHover,
                )
            }

            ButtonVariant.DANGER -> {
                HivebitButtonColors(
                    ButtonColors(
                        containerColor = Transparent,
                        contentColor = colorOnDangerNormal,
                        disabledContainerColor = colorFillDisabledQuietResting,
                        disabledContentColor = colorOnDisabledQuiet,
                    ),
                    colorFillDangerQuietHover,
                )
            }

            ButtonVariant.WARNING -> {
                HivebitButtonColors(
                    ButtonColors(
                        containerColor = Transparent,
                        contentColor = colorOnWarningNormal,
                        disabledContainerColor = colorFillDisabledQuietResting,
                        disabledContentColor = colorOnDisabledQuiet,
                    ),
                    colorFillWarningQuietHover,
                )
            }

            ButtonVariant.SUCCESS -> {
                HivebitButtonColors(
                    ButtonColors(
                        containerColor = Transparent,
                        contentColor = colorOnSuccessNormal,
                        disabledContainerColor = colorFillDisabledQuietResting,
                        disabledContentColor = colorOnDisabledQuiet,
                    ),
                    colorFillSuccessQuietHover,
                )
            }
        }
    }

    fun iconButtonColorsFromVariant(variant: ButtonVariant): HivebitIconButtonColors {
        return when (variant) {
            ButtonVariant.PRIMARY -> HivebitIconButtonColors(
                IconButtonColors(
                    containerColor = Color.Transparent,
                    contentColor = colorOnPrimaryNormal,
                    disabledContainerColor = Color.Transparent,
                    disabledContentColor = colorOnDisabledNormal,
                ),
                colorFillPrimaryQuietHover,
            )
            ButtonVariant.NEUTRAL -> HivebitIconButtonColors(
                IconButtonColors(
                    containerColor = Color.Transparent,
                    contentColor = colorOnNeutralQuiet,
                    disabledContainerColor = Color.Transparent,
                    disabledContentColor = colorOnDisabledNormal,
                ),
                colorFillNeutralQuietHover,
            )
            ButtonVariant.DANGER -> HivebitIconButtonColors(
                IconButtonColors(
                    containerColor = Color.Transparent,
                    contentColor = colorOnDangerQuiet,
                    disabledContainerColor = Color.Transparent,
                    disabledContentColor = colorOnDisabledNormal,
                ),
                colorFillDangerNormalHover,
            )
            ButtonVariant.WARNING -> HivebitIconButtonColors(
                IconButtonColors(
                    containerColor = Color.Transparent,
                    contentColor = colorOnWarningQuiet,
                    disabledContainerColor = Color.Transparent,
                    disabledContentColor = colorOnDisabledNormal,
                ),
                colorFillWarningNormalHover,
            )
            ButtonVariant.SUCCESS -> HivebitIconButtonColors(
                IconButtonColors(
                    containerColor = Color.Transparent,
                    contentColor = colorOnSuccessQuiet,
                    disabledContainerColor = Color.Transparent,
                    disabledContentColor = colorOnDisabledNormal,
                ),
                colorFillSuccessNormalHover,
            )
        }
    }
}

/**
 * Represents the core brand colors for the HiveBit premium smart home system.
 *
 * This object contains the fundamental color values that define the HiveBit visual identity:
 * - Primary: Warm beige (#C7B19A) representing luxury and modern automation
 * - Accent: Modern dark (#232323) for contrast and premium feel
 * - Status colors: Online green, error red, automation beige, etc.
 */
@Immutable
object HivebitBrandColors {
    // Primary Brand Colors
    val primaryColor = HivebitColors.HivebitPrimary
    val primaryVariantColor = HivebitColors.HivebitPrimaryVariant
    val onPrimaryColor = HivebitColors.HivebitOnPrimary

    // Accent Brand Colors
    val accentColor = HivebitColors.HivebitAccent
    val accentVariantColor = HivebitColors.HivebitAccentVariant
    val onAccentColor = HivebitColors.HivebitOnAccent

    // Status Colors
    val onlineColor = HivebitColors.StatusOnline
    val offlineColor = HivebitColors.StatusOffline
    val errorColor = HivebitColors.StatusError
    val activeAutomationColor = HivebitColors.StatusActiveAutomation
    val standbyColor = HivebitColors.StatusStandby
}

val HivebitDarkColorScheme = HivebitColorScheme(
    // Primary (HiveBit Beige) - #C7B19A
    colorFillPrimaryLoudResting = HivebitColors.HivebitPrimary,
    colorFillPrimaryNormalResting = HivebitColors.HivebitPrimary.copy(alpha = 0.2f),
    colorFillPrimaryQuietResting = HivebitColors.HivebitPrimary.copy(alpha = 0.1f),
    colorFillPrimaryLoudHover = HivebitColors.HivebitPrimaryVariant,
    colorFillPrimaryNormalHover = HivebitColors.HivebitPrimary.copy(alpha = 0.3f),
    colorFillPrimaryQuietHover = HivebitColors.HivebitPrimary.copy(alpha = 0.2f),
    colorFillPrimaryNormalActive = HivebitColors.HivebitPrimary.copy(alpha = 0.2f),
    colorOnPrimaryLoud = HivebitColors.HivebitOnPrimary,
    colorOnPrimaryNormal = HivebitColors.HivebitPrimary,
    colorOnPrimaryQuiet = HivebitColors.HivebitPrimary,

    // Neutral - Dark Grays
    colorFillNeutralLoudResting = HivebitColors.DarkSurfaceVariant,
    colorFillNeutralNormalResting = HivebitColors.DarkSurface,
    colorFillNeutralQuietResting = HivebitColors.DarkBackground.copy(alpha = 0.5f),
    colorFillNeutralLoudHover = HivebitColors.DarkSurfaceVariant.copy(alpha = 0.8f),
    colorFillNeutralNormalHover = HivebitColors.DarkSurface.copy(alpha = 0.8f),
    colorFillNeutralQuietHover = HivebitColors.DarkBackground.copy(alpha = 0.6f),
    colorOnNeutralLoud = HivebitColors.DarkTextPrimary,
    colorOnNeutralNormal = HivebitColors.DarkTextPrimary,
    colorOnNeutralQuiet = HivebitColors.DarkTextSecondary,

    // Danger - Error Red
    colorFillDangerLoudResting = HivebitColors.StatusError,
    colorFillDangerNormalResting = HivebitColors.StatusError.copy(alpha = 0.2f),
    colorFillDangerQuietResting = HivebitColors.StatusError.copy(alpha = 0.1f),
    colorFillDangerLoudHover = HivebitColors.StatusError.copy(alpha = 0.8f),
    colorFillDangerNormalHover = HivebitColors.StatusError.copy(alpha = 0.3f),
    colorFillDangerQuietHover = HivebitColors.StatusError.copy(alpha = 0.2f),
    colorOnDangerLoud = HivebitColors.White,
    colorOnDangerNormal = HivebitColors.StatusError,
    colorOnDangerQuiet = HivebitColors.StatusError,

    // Warning - Standby (using beige variant for warnings)
    colorFillWarningLoudResting = HivebitColors.HivebitPrimaryVariant,
    colorFillWarningNormalResting = HivebitColors.HivebitPrimaryVariant.copy(alpha = 0.2f),
    colorFillWarningQuietResting = HivebitColors.HivebitPrimaryVariant.copy(alpha = 0.1f),
    colorFillWarningLoudHover = HivebitColors.HivebitPrimaryVariant.copy(alpha = 0.8f),
    colorFillWarningNormalHover = HivebitColors.HivebitPrimaryVariant.copy(alpha = 0.3f),
    colorFillWarningQuietHover = HivebitColors.HivebitPrimaryVariant.copy(alpha = 0.2f),
    colorOnWarningLoud = HivebitColors.HivebitOnPrimary,
    colorOnWarningNormal = HivebitColors.HivebitPrimaryVariant,
    colorOnWarningQuiet = HivebitColors.HivebitPrimaryVariant,

    // Success - Online Green
    colorFillSuccessLoudResting = HivebitColors.StatusOnline,
    colorFillSuccessNormalResting = HivebitColors.StatusOnline.copy(alpha = 0.2f),
    colorFillSuccessQuietResting = HivebitColors.StatusOnline.copy(alpha = 0.1f),
    colorFillSuccessLoudHover = HivebitColors.StatusOnline.copy(alpha = 0.8f),
    colorFillSuccessNormalHover = HivebitColors.StatusOnline.copy(alpha = 0.3f),
    colorFillSuccessQuietHover = HivebitColors.StatusOnline.copy(alpha = 0.2f),
    colorOnSuccessLoud = HivebitColors.White,
    colorOnSuccessNormal = HivebitColors.StatusOnline,
    colorOnSuccessQuiet = HivebitColors.StatusOnline,

    // Disabled
    colorFillDisabledLoudResting = HivebitColors.StatusStandby,
    colorFillDisabledNormalResting = HivebitColors.StatusOffline,
    colorFillDisabledQuietResting = HivebitColors.StatusOffline.copy(alpha = 0.5f),
    colorOnDisabledLoud = HivebitColors.DarkTextSecondary,
    colorOnDisabledNormal = HivebitColors.DarkTextSecondary,
    colorOnDisabledQuiet = HivebitColors.StatusOffline,

    // Surface
    colorSurfaceDefault = HivebitColors.DarkBackground,

    // Text
    colorTextPrimary = HivebitColors.DarkTextPrimary,
    colorTextSecondary = HivebitColors.DarkTextSecondary,
    colorTextDisabled = HivebitColors.StatusOffline,
    colorTextLink = HivebitColors.HivebitPrimary,

    // Borders
    colorBorderPrimaryNormal = HivebitColors.HivebitPrimary,
    colorBorderPrimaryLoud = HivebitColors.HivebitPrimary,
    colorBorderNeutralQuiet = HivebitColors.DarkSurface,
    colorBorderNeutralNormal = HivebitColors.DarkSurfaceVariant,
    colorBorderDangerNormal = HivebitColors.StatusError,

    // Overlay
    colorOverlayModal = HivebitColors.Black.copy(alpha = 0.75f),
)


val HivebitLightColorScheme = HivebitColorScheme(
    // Primary (HiveBit Beige) - #C7B19A
    colorFillPrimaryLoudResting = HivebitColors.HivebitPrimary,
    colorFillPrimaryNormalResting = HivebitColors.HivebitPrimary.copy(alpha = 0.2f),
    colorFillPrimaryQuietResting = HivebitColors.HivebitPrimary.copy(alpha = 0.1f),
    colorFillPrimaryLoudHover = HivebitColors.HivebitPrimaryVariant,
    colorFillPrimaryNormalHover = HivebitColors.HivebitPrimary.copy(alpha = 0.3f),
    colorFillPrimaryQuietHover = HivebitColors.HivebitPrimary.copy(alpha = 0.2f),
    colorFillPrimaryNormalActive = HivebitColors.HivebitPrimary.copy(alpha = 0.2f),
    colorOnPrimaryLoud = HivebitColors.HivebitOnPrimary,
    colorOnPrimaryNormal = HivebitColors.HivebitPrimary,
    colorOnPrimaryQuiet = HivebitColors.HivebitPrimary,

    // Neutral - Light Surfaces
    colorFillNeutralLoudResting = HivebitColors.LightSurfaceVariant,
    colorFillNeutralNormalResting = HivebitColors.LightSurface,
    colorFillNeutralQuietResting = HivebitColors.LightBackground.copy(alpha = 0.5f),
    colorFillNeutralLoudHover = HivebitColors.LightSurfaceVariant.copy(alpha = 0.8f),
    colorFillNeutralNormalHover = HivebitColors.LightSurface.copy(alpha = 0.8f),
    colorFillNeutralQuietHover = HivebitColors.LightBackground.copy(alpha = 0.6f),
    colorOnNeutralLoud = HivebitColors.LightTextPrimary,
    colorOnNeutralNormal = HivebitColors.LightTextPrimary,
    colorOnNeutralQuiet = HivebitColors.LightTextSecondary,

    // Danger - Error Red
    colorFillDangerLoudResting = HivebitColors.StatusError,
    colorFillDangerNormalResting = HivebitColors.StatusError.copy(alpha = 0.2f),
    colorFillDangerQuietResting = HivebitColors.StatusError.copy(alpha = 0.1f),
    colorFillDangerLoudHover = HivebitColors.StatusError.copy(alpha = 0.8f),
    colorFillDangerNormalHover = HivebitColors.StatusError.copy(alpha = 0.3f),
    colorFillDangerQuietHover = HivebitColors.StatusError.copy(alpha = 0.2f),
    colorOnDangerLoud = HivebitColors.White,
    colorOnDangerNormal = HivebitColors.StatusError,
    colorOnDangerQuiet = HivebitColors.StatusError,

    // Warning - Primary Variant
    colorFillWarningLoudResting = HivebitColors.HivebitPrimaryVariant,
    colorFillWarningNormalResting = HivebitColors.HivebitPrimaryVariant.copy(alpha = 0.2f),
    colorFillWarningQuietResting = HivebitColors.HivebitPrimaryVariant.copy(alpha = 0.1f),
    colorFillWarningLoudHover = HivebitColors.HivebitPrimaryVariant.copy(alpha = 0.8f),
    colorFillWarningNormalHover = HivebitColors.HivebitPrimaryVariant.copy(alpha = 0.3f),
    colorFillWarningQuietHover = HivebitColors.HivebitPrimaryVariant.copy(alpha = 0.2f),
    colorOnWarningLoud = HivebitColors.HivebitOnPrimary,
    colorOnWarningNormal = HivebitColors.HivebitPrimaryVariant,
    colorOnWarningQuiet = HivebitColors.HivebitPrimaryVariant,

    // Success - Online Green
    colorFillSuccessLoudResting = HivebitColors.StatusOnline,
    colorFillSuccessNormalResting = HivebitColors.StatusOnline.copy(alpha = 0.2f),
    colorFillSuccessQuietResting = HivebitColors.StatusOnline.copy(alpha = 0.1f),
    colorFillSuccessLoudHover = HivebitColors.StatusOnline.copy(alpha = 0.8f),
    colorFillSuccessNormalHover = HivebitColors.StatusOnline.copy(alpha = 0.3f),
    colorFillSuccessQuietHover = HivebitColors.StatusOnline.copy(alpha = 0.2f),
    colorOnSuccessLoud = HivebitColors.White,
    colorOnSuccessNormal = HivebitColors.StatusOnline,
    colorOnSuccessQuiet = HivebitColors.StatusOnline,

    // Disabled
    colorFillDisabledLoudResting = HivebitColors.StatusStandby,
    colorFillDisabledNormalResting = HivebitColors.StatusOffline,
    colorFillDisabledQuietResting = HivebitColors.StatusOffline.copy(alpha = 0.5f),
    colorOnDisabledLoud = HivebitColors.LightTextSecondary,
    colorOnDisabledNormal = HivebitColors.LightTextSecondary,
    colorOnDisabledQuiet = HivebitColors.StatusOffline,

    // Surface
    colorSurfaceDefault = HivebitColors.LightBackground,

    // Text
    colorTextPrimary = HivebitColors.LightTextPrimary,
    colorTextSecondary = HivebitColors.LightTextSecondary,
    colorTextDisabled = HivebitColors.StatusOffline,
    colorTextLink = HivebitColors.HivebitPrimary,

    // Borders
    colorBorderPrimaryNormal = HivebitColors.HivebitPrimary,
    colorBorderPrimaryLoud = HivebitColors.HivebitPrimary,
    colorBorderNeutralQuiet = HivebitColors.LightDivider,
    colorBorderNeutralNormal = HivebitColors.LightSurfaceVariant,
    colorBorderDangerNormal = HivebitColors.StatusError,

    // Overlay
    colorOverlayModal = HivebitColors.Black.copy(alpha = 0.75f),
)

val DarkHivebitColorScheme = HivebitDarkColorScheme
val LightHivebitColorScheme = HivebitLightColorScheme

val LocalHivebitColorScheme = staticCompositionLocalOf { LightHivebitColorScheme }

