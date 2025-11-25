# Hivebit Rebranding Brief

## Objective
Rebrand the "Home Assistant Companion" Android application to "Hivebit".

## Current Status
**COMPLETED**. The application has been fully rebranded, builds successfully, and generates APKs with the new application ID.

## Key Changes Implemented

### 1. Identity & Naming
- **App Name**: "Hivebit" (in `strings.xml`)
- **Package Name**: `io.hivebit.companion.android` (was `io.homeassistant.companion.android`)
- **Application ID**: `io.hivebit.companion.android`
- **Root Project**: `hivebit-android`

### 2. Codebase Structure
- **Package Directory**: Moved all source files from `io/homeassistant` to `io/hivebit`.
- **Namespaces**: Updated `namespace` in all `build.gradle.kts` files.
- **Class Names**: Renamed core classes:
    - `HomeAssistantApplication` -> `HivebitApplication`
    - `HomeAssistantInstance` -> `HivebitInstance`
    - `HomeAssistantTheme` -> `HivebitTheme`

### 3. Build Configuration
- **Version Catalog** (`libs.versions.toml`): Renamed plugin aliases to `hivebit-*`.
- **Plugins**: Updated all plugin references in `build.gradle.kts` files.
- **Google Services**: Added `google-services.json` to `app`, `wear`, and `automotive` modules with new package name.

### 4. Theme & Resources
- **Theme System**: Renamed `HA*` theme classes to `Hivebit*`.
- **Compatibility**: Added type aliases (e.g., `typealias HAColorScheme = HivebitColorScheme`) to maintain backward compatibility with existing UI components.
- **Resource IDs**: **CRITICAL**: Resource IDs (e.g., `R.string.home_assistant_branding`) were **NOT** renamed to avoid breaking thousands of internal references. This is intentional.

## Design & Branding Details

### Color Palette
The new "Hivebit" brand uses a premium smart home color system:
- **Primary (Warm Beige)**: `#C7B19A` (Used for branding, active states, icons)
- **Primary Variant**: `#B79D87`
- **Accent (Modern Dark)**: `#232323`
- **Backgrounds**:
    - Light: `#F9F7F4` (Warm off-white)
    - Dark: `#1A1A1A` (Deep charcoal)

### Text & Strings
- **App Name**: "Hivebit"
- **User-Facing Text**: All instances of "Home Assistant" in UI strings have been replaced with "Hivebit".
    - *Example*: "Connect to Hivebit", "Checking with Hivebit".
- **Privacy Policy**: Currently points to `https://www.hivebit.co/privacy`.
- **Manual Setup**: Example URL still references `hivebit.local`.

### Image & Icon Swaps
- **Launcher Icons**: `ic_launcher` assets have been updated to the new Hivebit logo across all densities (mdpi to xxxhdpi).
- **Branding Assets**:
    - `ic_home_assistant_branding.xml` (in `onboarding` module) has been updated with the Hivebit logo vector path, despite retaining the original file name.
    - New logo files (e.g., `Hivebit Gold Logo transparent.png`) are available in the project root for reference.

## Critical Implementation Details (For AI)

1.  **Room Database**: Schema files were moved to `common/schemas/io.hivebit.companion.android.database.AppDatabase/`. Ensure any new migrations follow this path.
2.  **Manifests**: All `AndroidManifest.xml` files must reference `io.hivebit.companion.android.HivebitApplication`.
3.  **Linting**: Some lint checks might flag "homeassistant" references; these are often false positives due to the intentional resource ID retention.
4.  **Health Connect**: Requires `tools:overrideLibrary` in manifest due to minSdk differences.

## Verification
- Build: `./gradlew assembleDebug` (Success)
- Artifacts: `app-full-debug.apk`, `app-minimal-debug.apk`
