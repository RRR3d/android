# Hivebit Rebranding - Detailed Execution Plan

## Executive Summary

This document outlines the complete step-by-step plan to rebrand the Home Assistant Android application to "Hivebit". The rebranding will transform the application's identity while maintaining all existing functionality.

**Estimated Impact**: ~500-700 files across 8 modules  
**Estimated Time**: 4-6 hours of execution  
**Risk Level**: Medium (comprehensive testing required post-execution)

---

## Current State Analysis

### ✅ Already Completed
- Firebase configuration (`google-services.json`) for all modules with Hivebit package names
- Rebranding documentation (REBRANDING_BRIEF.md & REBRANDING_README.md)

### ❌ Requires Implementation
- Package structure migration (`io.homeassistant` → `io.hivebit`)
- Class name changes (HomeAssistant* → Hivebit*)
- String resources updates
- Build configuration updates
- Import statement updates (~2000+ imports)
- Manifest file updates
- Database schema path migration

---

## Execution Plan - Phase by Phase

### **PHASE 1: Pre-Flight Checks** ⚙️
**Estimated Time**: 15 minutes

#### 1.1 Backup Current State
```bash
# Create backup branch
git checkout -b backup-before-rebranding
git add .
git commit -m "Backup: Pre-rebranding snapshot"

# Create working branch
git checkout -b feature/hivebit-rebranding
```

#### 1.2 Verify Build Environment
- ✅ Confirm JAVA_HOME is set to JDK 17
- ✅ Verify Gradle wrapper is executable
- ✅ Run clean build to establish baseline
  ```bash
  ./gradlew clean
  ```

#### 1.3 Document Current Package Structure
```bash
# Count Kotlin files to be migrated
find . -name "*.kt" -path "*/io/homeassistant/*" | wc -l
# Expected: ~400-500 files
```

---

### **PHASE 2: Build Configuration Updates** 🔧
**Estimated Time**: 30 minutes

#### 2.1 Update Version Catalog
**File**: `gradle/libs.versions.toml`

**Changes**:
```toml
# FROM:
homeassistant-android-application = { id = "io.homeassistant.companion.android.application", version.ref = "project" }
homeassistant-android-common = { id = "io.homeassistant.companion.android.common", version.ref = "project" }
homeassistant-android-compose = { id = "io.homeassistant.companion.android.compose", version.ref = "project" }
homeassistant-android-dependencies = { id = "io.homeassistant.companion.android.dependencies", version.ref = "project" }
homeassistant-android-flavor = { id = "io.homeassistant.companion.android.flavor", version.ref = "project" }

# TO:
hivebit-android-application = { id = "io.hivebit.companion.android.application", version.ref = "project" }
hivebit-android-common = { id = "io.hivebit.companion.android.common", version.ref = "project" }
hivebit-android-compose = { id = "io.hivebit.companion.android.compose", version.ref = "project" }
hivebit-android-dependencies = { id = "io.hivebit.companion.android.dependencies", version.ref = "project" }
hivebit-android-flavor = { id = "io.hivebit.companion.android.flavor", version.ref = "project" }
```

#### 2.2 Update Root Settings
**File**: `settings.gradle.kts`

**Change**:
```kotlin
// FROM:
rootProject.name = "home-assistant-android"

// TO:
rootProject.name = "hivebit-android"
```

#### 2.3 Update Application ID
**File**: `build-logic/convention/src/main/kotlin/AndroidApplicationConventionPlugin.kt`

**Change**:
```kotlin
// FROM:
private const val APPLICATION_ID = "io.homeassistant.companion.android"

// TO:
private const val APPLICATION_ID = "io.hivebit.companion.android"
```

#### 2.4 Update Build Logic Group
**File**: `build-logic/convention/build.gradle.kts`

**Change**:
```kotlin
// FROM:
group = "io.homeassistant.companion.android.buildlogic"

// TO:
group = "io.hivebit.companion.android.buildlogic"
```

#### 2.5 Update Module Build Files
**Files to modify**:
- `app/build.gradle.kts`
- `automotive/build.gradle.kts`
- `wear/build.gradle.kts`
- `common/build.gradle.kts`
- `onboarding/build.gradle.kts`
- `testing-unit/build.gradle.kts`

**Changes in each**:
```kotlin
plugins {
    // FROM:
    alias(libs.plugins.homeassistant.android.application)
    alias(libs.plugins.homeassistant.android.flavor)
    alias(libs.plugins.homeassistant.android.dependencies)
    
    // TO:
    alias(libs.plugins.hivebit.android.application)
    alias(libs.plugins.hivebit.android.flavor)
    alias(libs.plugins.hivebit.android.dependencies)
}

android {
    // FROM:
    namespace = "io.homeassistant.companion.android"
    
    // TO:
    namespace = "io.hivebit.companion.android"
}
```

**Module-specific namespaces**:
- **common**: `io.hivebit.companion.android.common`
- **onboarding**: `io.hivebit.companion.android.onboarding`
- **testing-unit**: `io.hivebit.companion.android.testing.unit`

---

### **PHASE 3: Package Structure Migration** 📦
**Estimated Time**: 1.5 hours

This is the most critical phase. We'll move all source files from `io/homeassistant` to `io/hivebit`.

#### 3.1 Create Target Directory Structure
```bash
# For each module, create new package structure
for module in app automotive wear common onboarding testing-unit; do
    for srcDir in main full minimal debug release test androidTest screenshotTest; do
        if [ -d "$module/src/$srcDir/kotlin/io/homeassistant" ]; then
            mkdir -p "$module/src/$srcDir/kotlin/io/hivebit/companion/android"
        fi
    done
done
```

#### 3.2 Move Source Files
**Automated approach using Git**:
```bash
# This preserves Git history
git mv app/src/main/kotlin/io/homeassistant/companion/android/* \
       app/src/main/kotlin/io/hivebit/companion/android/

# Repeat for all modules and source sets:
# - app (main, full, minimal, debug, release, test, androidTest, screenshotTest)
# - automotive (main, full, minimal)
# - wear (main, test, screenshotTest)
# - common (main, debug, release, test, screenshotTest)
# - onboarding (main, debug, test, androidTest, screenshotTest)
# - testing-unit (main)
```

#### 3.3 Update Package Declarations
**Automated sed replacement** (execute after directory move):
```bash
# Update package declarations in all .kt files
find . -name "*.kt" -type f -exec sed -i '' \
    's/package io\.homeassistant\.companion\.android/package io.hivebit.companion.android/g' {} +
```

**Impact**: ~400-500 Kotlin files

#### 3.4 Update Import Statements
```bash
# Update import statements
find . -name "*.kt" -type f -exec sed -i '' \
    's/import io\.homeassistant\.companion\.android/import io.hivebit.companion.android/g' {} +
```

**Impact**: ~2000-3000 import statements

#### 3.5 Cleanup Old Directories
```bash
# Remove empty io/homeassistant directories
find . -type d -path "*/io/homeassistant" -empty -delete
```

---

### **PHASE 4: Core Class Renaming** 🏷️
**Estimated Time**: 45 minutes

#### 4.1 Application Classes
**Files to modify**:
1. `app/src/main/kotlin/io/hivebit/companion/android/HomeAssistantApplication.kt`
2. `wear/src/main/kotlin/io/hivebit/companion/android/HomeAssistantApplication.kt`

**Changes**:
```kotlin
// Rename file to: HivebitApplication.kt
// Update class declaration:
@HiltAndroidApp
open class HivebitApplication : Application(), SingletonImageLoader.Factory {
    // ... rest of implementation
}
```

#### 4.2 Data Classes
**Files to modify**:
1. `common/src/main/kotlin/io/hivebit/companion/android/common/data/HomeAssistantApis.kt` → `HivebitApis.kt`
2. `app/src/main/kotlin/io/hivebit/companion/android/onboarding/discovery/HomeAssistantInstance.kt` → `HivebitInstance.kt`
3. `wear/src/main/kotlin/io/hivebit/companion/android/onboarding/HomeAssistantInstance.kt` → `HivebitInstance.kt`
4. `onboarding/src/main/kotlin/io/hivebit/companion/android/onboarding/serverdiscovery/HomeAssistantSearcher.kt` → `HivebitSearcher.kt`

**Pattern for each**:
```kotlin
// Rename file
// Update class name
// Update all usages within the file
```

#### 4.3 Update References to Renamed Classes
**Automated replacement**:
```bash
# HomeAssistantApplication → HivebitApplication
find . -name "*.kt" -type f -exec sed -i '' \
    's/HomeAssistantApplication/HivebitApplication/g' {} +

# HomeAssistantApis → HivebitApis
find . -name "*.kt" -type f -exec sed -i '' \
    's/HomeAssistantApis/HivebitApis/g' {} +

# HomeAssistantInstance → HivebitInstance
find . -name "*.kt" -type f -exec sed -i '' \
    's/HomeAssistantInstance/HivebitInstance/g' {} +

# HomeAssistantSearcher → HivebitSearcher
find . -name "*.kt" -type f -exec sed -i '' \
    's/HomeAssistantSearcher/HivebitSearcher/g' {} +

# HomeAssistantSearcherImpl → HivebitSearcherImpl
find . -name "*.kt" -type f -exec sed -i '' \
    's/HomeAssistantSearcherImpl/HivebitSearcherImpl/g' {} +

# HomeAssistantVersion → HivebitVersion
find . -name "*.kt" -type f -exec sed -i '' \
    's/HomeAssistantVersion/HivebitVersion/g' {} +
```

---

### **PHASE 5: Theme System Updates** 🎨
**Estimated Time**: 1 hour

#### 5.1 Rename Core Theme Classes
**Directory**: `common/src/main/kotlin/io/hivebit/companion/android/common/compose/theme/`

**Files to modify**:
1. `Theme.kt` - Rename `HomeAssistantTheme` → `HivebitTheme`
2. `Colors.kt` - Rename color scheme classes
3. `HAColors.kt` - Create backward compatibility aliases

**Theme.kt changes**:
```kotlin
// FROM:
@Composable
fun HomeAssistantTheme(
    darkMode: Boolean = isSystemInDarkTheme(),
    dynamicColors: Boolean = false,
    content: @Composable () -> Unit
) { ... }

// TO:
@Composable
fun HivebitTheme(
    darkMode: Boolean = isSystemInDarkTheme(),
    dynamicColors: Boolean = false,
    content: @Composable () -> Unit
) { ... }
```

#### 5.2 Create Compatibility Aliases
**File**: `common/src/main/kotlin/io/hivebit/companion/android/common/compose/theme/HAColors.kt`

**Add**:
```kotlin
// Type aliases for backward compatibility
typealias HAColorScheme = HivebitColorScheme
typealias HABrandColors = HivebitBrandColors
typealias HAButtonColors = HivebitButtonColors
typealias HAIconButtonColors = HivebitIconButtonColors

// CompositionLocal aliases
val LocalHAColorScheme = LocalHivebitColorScheme
val HADarkColorScheme = HivebitDarkColorScheme
val DarkHAColorScheme = DarkHivebitColorScheme
val LightHAColorScheme = LightHivebitColorScheme
```

**File**: `common/src/main/kotlin/io/hivebit/companion/android/common/compose/theme/HATheme.kt`

**Add**:
```kotlin
@Composable
fun HATheme(
    darkMode: Boolean = isSystemInDarkTheme(),
    dynamicColors: Boolean = false,
    content: @Composable () -> Unit
) {
    HivebitTheme(darkMode, dynamicColors, content)
}

@Composable
fun HAThemeForPreview(content: @Composable () -> Unit) {
    CompositionLocalProvider(LocalHivebitColorScheme provides HivebitDarkColorScheme) {
        content()
    }
}
```

#### 5.3 Update Color Values
**File**: `common/src/main/kotlin/io/hivebit/companion/android/common/compose/theme/Colors.kt`

**Apply Hivebit brand colors**:
```kotlin
// Hivebit Brand Palette
private val HivebitPrimary = Color(0xFFC7B19A)        // Warm Beige
private val HivebitPrimaryVariant = Color(0xFFB79D87)
private val HivebitAccent = Color(0xFF232323)         // Modern Dark
private val HivebitBackgroundLight = Color(0xFFF9F7F4) // Warm off-white
private val HivebitBackgroundDark = Color(0xFF1A1A1A)  // Deep charcoal
```

---

### **PHASE 6: String Resources Update** 📝
**Estimated Time**: 30 minutes

#### 6.1 User-Facing Strings
**Files to modify**:
- `common/src/main/res/values/strings.xml`
- `onboarding/src/main/res/values/strings.xml`
- `app/src/main/res/values/strings.xml` (if exists)

**Automated replacement**:
```bash
# Replace "Home Assistant" with "Hivebit" (case-sensitive)
find . -name "strings.xml" -type f -exec sed -i '' \
    's/>Home Assistant</>Hivebit</g' {} +

# Update specific app name string
sed -i '' 's/<string name="app_name">Home Assistant</<string name="app_name">Hivebit</g' \
    common/src/main/res/values/strings.xml
```

**Manual review required for**:
- Technical strings that reference Home Assistant as a server
- Error messages mentioning "Home Assistant"
- Instructional text

**Key strings to update**:
```xml
<string name="app_name">Hivebit</string>
<string name="connect_to_home_assistant">Connect to Hivebit</string>
<string name="connected_to_home_assistant">Connected to Hivebit</string>
<string name="checking_with_home_assistant">Checking with Hivebit</string>
<string name="background_access_disabled">Hivebit does not have access...</string>
<string name="background_access_enabled">Hivebit has access...</string>
<string name="biometric_title">Hivebit is locked</string>
```

#### 6.2 Keep Resource IDs Unchanged
**IMPORTANT**: Do NOT change resource ID names like:
- `home_assistant_branding`
- `welcome_home_assistant_title`
- `ic_home_assistant_branding`

These are internal identifiers and changing them will break references.

#### 6.3 User Agent String
**File**: `common/src/main/kotlin/io/hivebit/companion/android/common/data/HivebitApis.kt`

```kotlin
// FROM:
val USER_AGENT_STRING = "Home Assistant/${BuildConfig.VERSION_NAME} ($ANDROID_DETAILS)"

// TO:
val USER_AGENT_STRING = "Hivebit/${BuildConfig.VERSION_NAME} ($ANDROID_DETAILS)"
```

---

### **PHASE 7: Manifest Files Update** 📄
**Estimated Time**: 20 minutes

#### 7.1 Application Class References
**Files to modify**:
- `app/src/main/AndroidManifest.xml`
- `app/src/full/AndroidManifest.xml`
- `automotive/src/main/AndroidManifest.xml`
- `automotive/src/full/AndroidManifest.xml`
- `wear/src/main/AndroidManifest.xml`

**Changes**:
```xml
<!-- FROM: -->
<application
    android:name="io.homeassistant.companion.android.HomeAssistantApplication"
    ...>

<!-- TO: -->
<application
    android:name="io.hivebit.companion.android.HivebitApplication"
    ...>
```

#### 7.2 Package References
**Update in all manifest files**:
```xml
<!-- FROM: -->
<manifest package="io.homeassistant.companion.android">

<!-- TO: -->
<manifest package="io.hivebit.companion.android">
```

#### 7.3 Automotive Module Specific
**File**: `automotive/src/main/AndroidManifest.xml`

Ensure `tools:overrideLibrary` is present:
```xml
<uses-sdk tools:overrideLibrary="androidx.wear.remote.interactions,androidx.health.connect.client" />
```

---

### **PHASE 8: Database Schema Migration** 🗄️
**Estimated Time**: 15 minutes

#### 8.1 Move Schema Directory
```bash
# Move from old package path to new
mv common/schemas/io.homeassistant.companion.android.database.AppDatabase \
   common/schemas/io.hivebit.companion.android.database.AppDatabase
```

#### 8.2 Update Room Database Configuration
**File**: `common/build.gradle.kts`

Verify schema path configuration:
```kotlin
ksp {
    arg("room.schemaLocation", "$projectDir/schemas")
    arg("room.incremental", "true")
}
```

---

### **PHASE 9: XML and Resource Updates** 🎯
**Estimated Time**: 30 minutes

#### 9.1 Layout XML Files
**Update package references in custom view declarations**:
```bash
find . -name "*.xml" -path "*/res/layout/*" -type f -exec sed -i '' \
    's/io\.homeassistant\.companion\.android/io.hivebit.companion.android/g' {} +
```

#### 9.2 Navigation Graph Files
```bash
find . -name "*.xml" -path "*/res/navigation/*" -type f -exec sed -i '' \
    's/io\.homeassistant\.companion\.android/io.hivebit.companion.android/g' {} +
```

#### 9.3 ProGuard Rules
**Files to update**:
- `app/proguard-rules.pro`
- `common/proguard-rules.pro`

```pro
# FROM:
-keep class io.homeassistant.companion.android.** { *; }

# TO:
-keep class io.hivebit.companion.android.** { *; }
```

---

### **PHASE 10: Metadata and Documentation** 📋
**Estimated Time**: 15 minutes

#### 10.1 App Store Metadata
**Files to update**:
- `fastlane/metadata/android/en-US/title.txt`
- `fastlane/metadata/android/en-US/short_description.txt`
- `fastlane/metadata/android/en-US/full_description.txt`

**Changes**:
```
# title.txt
Hivebit

# short_description.txt
The official app for Hivebit. Control your home anywhere in the world.

# full_description.txt
(Update all references from "Home Assistant" to "Hivebit")
```

#### 10.2 Update README Files
**Files to potentially update**:
- `README.md` (root)
- `app/README.md` (if exists)
- Other module-specific READMEs

---

### **PHASE 11: Validation & Testing** ✅
**Estimated Time**: 1 hour

#### 11.1 Clean Build Test
```bash
# Clean project
./gradlew clean

# Build all modules
export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk-17.0.2.jdk/Contents/Home
./gradlew assembleDebug

# Expected result: BUILD SUCCESSFUL
```

#### 11.2 Verify Generated APKs
```bash
# Check APK outputs
ls -lh app/build/outputs/apk/*/debug/*.apk

# Expected files:
# - app-full-debug.apk (package: io.hivebit.companion.android.debug)
# - app-minimal-debug.apk (package: io.hivebit.companion.android.minimal.debug)
```

#### 11.3 Compilation Checks
**Verify no errors in**:
- Package resolution
- Import statements
- Class references
- Resource references (R.*)
- Manifest merging
- Database schema loading

#### 11.4 Static Analysis
```bash
# Run lint checks
./gradlew lintDebug --continue

# Check for remaining "homeassistant" references
grep -r "io\.homeassistant" --include="*.kt" --include="*.xml" . | \
    grep -v "build/" | \
    grep -v ".gradle/" | \
    grep -v "schemas/"
```

---

## Risk Assessment & Mitigation

### High-Risk Areas

1. **Import Statement Errors**
   - **Risk**: Automated replacement might miss edge cases
   - **Mitigation**: Post-execution grep search + manual verification
   - **Rollback**: Git revert capability

2. **Database Schema Path**
   - **Risk**: App crash on first run if schema migration fails
   - **Mitigation**: Thorough testing of database initialization
   - **Rollback**: Restore old schema directory structure

3. **Resource Reference Breakage**
   - **Risk**: R.* references might break if namespace change affects generated code
   - **Mitigation**: Keep resource IDs unchanged, only update display strings
   - **Rollback**: Selective revert of string changes

4. **Theme System Compatibility**
   - **Risk**: UI components might break if theme aliases fail
   - **Mitigation**: Type alias strategy maintains backward compatibility
   - **Rollback**: Revert theme file changes

### Medium-Risk Areas

1. **ProGuard Rules**
   - **Risk**: Release build obfuscation might fail
   - **Mitigation**: Update all -keep rules
   - **Testing**: Build release variant

2. **Manifest Merge Conflicts**
   - **Risk**: Module manifests might have inconsistent package declarations
   - **Mitigation**: Update all manifests in single pass
   - **Testing**: Check merged manifest output

3. **Test Code**
   - **Risk**: Test fixtures and mocks might reference old class names
   - **Mitigation**: Include test directories in sed replacements
   - **Testing**: Run test suite post-migration

---

## Post-Execution Checklist

### Build Verification
- [ ] `./gradlew clean` completes successfully
- [ ] `./gradlew assembleDebug` completes without errors
- [ ] `./gradlew assembleRelease` completes without errors
- [ ] Both Full and Minimal flavors build successfully
- [ ] APK package names are correct (io.hivebit.companion.android.*)

### Code Quality
- [ ] No unresolved imports in any .kt file
- [ ] No unresolved class references
- [ ] Lint checks pass (or only expected warnings)
- [ ] KtLint formatting passes

### Functional Testing
- [ ] App installs on test device
- [ ] App launches without crash
- [ ] Onboarding flow displays "Hivebit" branding
- [ ] Settings screens show "Hivebit" name
- [ ] Database initializes correctly
- [ ] Firebase integration works (full flavor)
- [ ] Notifications display correctly

### Resource Verification
- [ ] App name shows as "Hivebit" in launcher
- [ ] All UI strings display "Hivebit" (not "Home Assistant")
- [ ] Theme colors match Hivebit brand palette
- [ ] Icons and assets are correct

### Git Cleanup
- [ ] Remove backup branch after successful validation
- [ ] Squash commits if needed
- [ ] Update commit message to be descriptive

---

## Rollback Plan

If critical issues arise during execution:

### Immediate Rollback (Before Commit)
```bash
# Discard all changes
git reset --hard HEAD

# Or selective file restore
git checkout HEAD -- path/to/problematic/file
```

### Post-Commit Rollback
```bash
# Revert to backup branch
git checkout backup-before-rebranding

# Or cherry-pick specific working commits
git cherry-pick <commit-hash>
```

### Partial Rollback Strategy
If only certain phases fail:
1. Identify failing phase from error logs
2. Revert changes from that phase only
3. Continue with subsequent phases
4. Return to failed phase after root cause analysis

---

## Timeline Estimate

| Phase | Description | Time | Dependencies |
|-------|-------------|------|--------------|
| 1 | Pre-flight checks | 15 min | - |
| 2 | Build config | 30 min | Phase 1 |
| 3 | Package migration | 1.5 hr | Phase 2 |
| 4 | Class renaming | 45 min | Phase 3 |
| 5 | Theme updates | 1 hr | Phase 3 |
| 6 | String resources | 30 min | - |
| 7 | Manifest updates | 20 min | Phase 4 |
| 8 | Database schemas | 15 min | Phase 3 |
| 9 | XML resources | 30 min | Phase 3 |
| 10 | Documentation | 15 min | - |
| 11 | Validation | 1 hr | All phases |
| **TOTAL** | | **6 hours 10 min** | |

---

## Success Criteria

The rebranding is considered successful when:

1. ✅ All modules compile without errors
2. ✅ Debug and release builds complete successfully
3. ✅ APKs are generated with correct package names
4. ✅ App launches and runs without crashes
5. ✅ All user-facing text displays "Hivebit"
6. ✅ Theme colors match Hivebit brand
7. ✅ No references to "Home Assistant" in user-visible areas
8. ✅ Firebase integration works (if configured)
9. ✅ Database migrations work correctly
10. ✅ All automated tests pass

---

## Approval Required

Before proceeding with execution, please confirm:

- [ ] You understand the scope and impact of changes
- [ ] You have reviewed the risk assessment
- [ ] You have a backup/rollback strategy
- [ ] You have adequate time for execution and testing
- [ ] You approve the phased approach outlined above

**Once approved, I will begin execution starting with Phase 1.**

---

**Document Version**: 1.0  
**Created**: November 25, 2025  
**Status**: ⏸️ Awaiting Approval
