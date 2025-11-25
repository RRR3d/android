# Hivebit Android App - Complete Rebranding Release

## 📱 Release Information

**Version:** 0.0.1-SNAPSHOT  
**Build Date:** November 25, 2025  
**Package ID:** `io.hivebit.companion.android`  
**App Name:** Hivebit

## 📦 Release Artifacts

### Main Application
- **File:** `app/build/outputs/apk/full/release/app-full-release.apk`
- **Size:** 29 MB
- **Build Type:** Release (Signed)
- **Flavor:** Full (with Google Play Services)

### Automotive Module
- **File:** `automotive/build/outputs/apk/full/release/automotive-full-release.apk`
- **Size:** 81 MB
- **Build Type:** Release (Signed)
- **Flavor:** Full (with Google Play Services)

## 🎨 Hivebit Visual Branding

### Core Brand Colors
- **Primary (Hivebit Gold):** `#C7B19A` - Warm beige/gold for buttons, highlights, key UI actions
- **Primary Variant (Deep Gold):** `#B79D87` - Secondary buttons and icons
- **On Primary (Charcoal Black):** `#1E1E1E` - Text/icons on gold surfaces
- **Accent (Hivebit Black):** `#232323` - Headers, footers, navigation bars, app bar
- **Accent Variant (Soft Graphite):** `#2E2E2E` - Cards and surfaces in dark mode
- **On Accent (Pure White):** `#FFFFFF` - Text/icons on dark backgrounds

### Light Mode Palette
- **Background:** `#F9F7F4` (Off-White) - Soft luxury mood, reduces glare
- **Surface:** `#FFFFFF` (White) - Cards, settings tiles
- **Divider:** `#D8D3CD` (Warm Grey) - Subtle separation lines
- **Text Primary:** `#1C1C1C` (Charcoal) - High contrast
- **Text Secondary:** `#7A756F` (Warm Grey) - Descriptive text
- **Icon Color:** `#C7B19A` (Gold) - Brand consistency

### Dark Mode Palette
- **Background:** `#1A1A1A` (Ultra-Dark Grey) - Modern smart-home feel
- **Surface:** `#242424` (Graphite) - Panels & cards
- **Surface Variant:** `#2E2E2E` - Secondary cards
- **Text Primary:** `#FFFFFF` (White) - Main text
- **Text Secondary:** `#A19C96` (Muted Warm Grey) - Labels, device info
- **Icon Color:** `#C7B19A` (Gold) - Keeps brand identity in dark UI

### IoT Status Colors
- **Online:** `#4CAF50` - Calm green (not neon)
- **Offline:** `#B0ADA9` - Muted grey
- **Error/Alert:** `#E57373` - Soft red, not aggressive
- **Active Automation:** `#C7B19A` - Gold = active device
- **Standby:** `#6D6A65` - Neutral grey

## ✅ Rebranding Changes Completed

### Phase 1-3: Package Migration
- ✅ Migrated package from `io.homeassistant` to `io.hivebit`
- ✅ Updated all Kotlin files with new package structure
- ✅ Updated XML resources and manifests
- ✅ Updated Gradle build configurations

### Phase 4-6: Core Class Renaming
- ✅ Renamed `HomeAssistantApplication` → `HivebitApplication`
- ✅ Updated all string resources
- ✅ Updated configuration files

### Phase 10: Visual Asset Branding
- ✅ Created 60+ launcher icons in WebP format
- ✅ Updated `ic_launcher_background.xml` with Hivebit colors
- ✅ Updated `app_icon_launch_screen_background.xml`
- ✅ Applied Hivebit color scheme to all themes

### Phase 11: Theme Application Fixes
- ✅ Updated `AndroidManifest.xml` to use `Theme.Hivebit`
- ✅ Applied Hivebit colors to all resource files (light & dark modes)
- ✅ Fixed color implementation across all modules

### Phase 12: Complete Color Palette Application
- ✅ Applied all colors from `HivebitColors.md` specification
- ✅ Updated light mode colors (Background, Surface, Text, Icons)
- ✅ Updated dark mode colors (Background, Surface, Text, Icons)
- ✅ Applied IoT status colors (Online, Offline, Error, Active, Standby)
- ✅ Updated UI component colors (Buttons, Toggles, Device Controls)
- ✅ Updated Compose theme (`Theme.kt`) with complete definitions
- ✅ Updated Material theme (`styles.xml`) ActionBar colors

### Phase 13: Final Text References
- ✅ Updated remaining "Home Assistant" references to "Hivebit"
- ✅ Updated comments in AndroidManifest files
- ✅ Updated changelog text

## 🏗️ Build Configuration

### Signing Configuration
The release build uses the signing configuration defined in `AndroidApplicationConventionPlugin.kt`:
- Keystore path: Via `KEYSTORE_PATH` environment variable or `release_keystore.keystore`
- Store password: Via `KEYSTORE_PASSWORD` environment variable
- Key alias: Via `KEYSTORE_ALIAS` environment variable
- Key password: Via `KEYSTORE_ALIAS_PASSWORD` environment variable
- V1 Signing: Enabled
- V2 Signing: Enabled

### Build Command
```bash
export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk-17.0.2.jdk/Contents/Home
./gradlew assembleFullRelease
```

## 📝 Installation Instructions

### For Release APK
```bash
adb install app/build/outputs/apk/full/release/app-full-release.apk
```

### For Automotive APK
```bash
adb install automotive/build/outputs/apk/full/release/automotive-full-release.apk
```

## 🔑 Key Files Modified

### Theme & Colors
- `app/src/main/res/values/colors.xml` - App-specific colors
- `app/src/main/res/values/styles.xml` - Material theme definitions
- `common/src/main/res/values/colors.xml` - Shared light mode colors
- `common/src/main/res/values-night/colors.xml` - Shared dark mode colors
- `app/src/main/kotlin/io/hivebit/companion/android/util/compose/Theme.kt` - Compose themes
- `wear/src/main/kotlin/io/hivebit/companion/android/theme/Color.kt` - Wear OS colors

### Resources
- `common/src/main/res/values/strings.xml` - App name and strings
- `app/src/main/res/drawable/ic_launcher_background.xml` - Launcher icon background
- `app/src/main/res/drawable-v26/app_icon_launch.xml` - Adaptive icon

### Manifests
- `app/src/main/AndroidManifest.xml` - Main app manifest with Hivebit theme
- `automotive/src/main/AndroidManifest.xml` - Automotive module manifest

## 🎯 Next Steps

1. **Configure Keystore for Production:**
   - Create a production keystore with proper security
   - Set environment variables for signing
   - Rebuild with production keystore

2. **Testing:**
   - Install APK on physical devices
   - Test all color themes (light/dark mode)
   - Verify launcher icons and branding
   - Test automotive module separately

3. **Distribution:**
   - Prepare for Google Play Store submission
   - Update store listing with Hivebit branding
   - Create promotional materials with new color scheme

## 📊 Git History

```
Phase 1-3: Package migration from io.homeassistant to io.hivebit
Phase 4-6: Core class renaming and string updates
Phase 10: Apply Hivebit visual branding
Phase 11: Fix theme application
Phase 12: Apply complete Hivebit color palette
Phase 13: Complete final rebranding references
```

## 🙏 Credits

Original App: Home Assistant for Android  
Rebranded To: Hivebit  
Color Palette: Defined in `HivebitColors.md`  
Build Date: November 25, 2025
