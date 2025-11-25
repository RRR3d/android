# 🔧 Hivebit Android App - Build & Installation Troubleshooting Guide

This guide explains the common build and installation issues you've been experiencing and how to fix them.

---

## 📋 Table of Contents
1. [Version Downgrade Errors](#version-downgrade-errors)
2. [Build Environment Issues](#build-environment-issues)
3. [Installation Best Practices](#installation-best-practices)
4. [Complete Build & Install Workflow](#complete-build--install-workflow)

---

## ❌ Issue #1: Version Downgrade Errors

### **Error Message:**
```
INSTALL_FAILED_VERSION_DOWNGRADE: Downgrade detected: 
Update version code 1 is older than current 4
```

### **Why This Happens:**
- Your emulator/device has an app with `versionCode = 4` (from previous installs)
- Your current build has `versionCode = 1` (default from build.gradle)
- Android blocks installing an older version over a newer one for security

### **Solutions:**

#### **Option 1: Uninstall First (RECOMMENDED)**
```bash
# Remove all versions completely
adb uninstall io.hivebit.companion.android.debug
adb uninstall io.hivebit.companion.android

# For stubborn installations, use force uninstall:
adb shell pm uninstall --user 0 io.hivebit.companion.android.debug
adb shell pm uninstall --user 0 io.hivebit.companion.android

# Then install fresh
adb install app/build/outputs/apk/full/debug/app-full-debug.apk
```

#### **Option 2: Increase Version Code**
```bash
# Build with a higher version code (5 or above)
./gradlew installFullDebug -Pandroid.injected.version.code=5
```

#### **Option 3: Use installDebug Task (Auto-handles versioning)**
```bash
# Gradle's install tasks automatically handle version code
./gradlew installFullDebug
```

---

## ❌ Issue #2: Build Environment Issues

### **Error Message:**
```
Toolchain does not provide the required capabilities: [JAVA_COMPILER]
Cannot find a Java compiler
```

### **Why This Happens:**
- Gradle is using **JRE (Java Runtime Environment)** instead of **JDK (Java Development Kit)**
- JRE only runs Java - it doesn't include the compiler needed for Android builds
- The emulator logs show: `Zulu JRE 17.60.17` (this is a JRE, not JDK)

### **Solution:**

#### **Set JAVA_HOME to a JDK:**
```bash
# Find available JDKs on your Mac:
/usr/libexec/java_home -V

# Set JAVA_HOME (add to ~/.zshrc for permanent fix):
export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk-17.0.2.jdk/Contents/Home

# Verify it's a JDK (should include 'javac'):
$JAVA_HOME/bin/javac -version
```

#### **Install Oracle JDK 17 (if needed):**
```bash
# Download from: https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html
# Or use Homebrew:
brew install openjdk@17

# Then link it:
sudo ln -sfn /opt/homebrew/opt/openjdk@17/libexec/openjdk.jdk \
  /Library/Java/JavaVirtualMachines/openjdk-17.jdk
```

---

## ❌ Issue #3: App Crashes After Install

### **Recent Error Fixed:**
```
IllegalArgumentException: Only VectorDrawables and rasterized asset types are supported
at WelcomeView.kt:37
```

### **Why This Happened:**
- The `WelcomeView.kt` was trying to load `R.drawable.app_icon_launch`
- This is an **adaptive-icon XML** (moved to `drawable-v26/`)
- Compose's `painterResource()` cannot load adaptive-icon XMLs
- **Fixed by**: Changed to `R.drawable.ic_launcher_foreground` (vector drawable)

### **Key Lesson:**
- **Adaptive Icons** (`<adaptive-icon>` XML) are only for launchers, NOT for use in UI code
- Use **vector drawables** (`.xml` with `<vector>`) or **raster images** (`.webp`, `.png`) in Compose UI

---

## ✅ Installation Best Practices

### **For Debug Builds:**
```bash
# BEST: Let Gradle handle everything
./gradlew installFullDebug

# This automatically:
# - Builds the debug APK
# - Uninstalls old version if needed
# - Installs new version
# - Handles version code conflicts
```

### **For Release Builds:**
```bash
# Step 1: Build the release APK
./gradlew assembleFullRelease

# Step 2: Uninstall any existing version
adb uninstall io.hivebit.companion.android

# Step 3: Install the release APK
adb install app/build/outputs/apk/full/release/app-full-release.apk
```

### **Check What's Installed:**
```bash
# List all Hivebit packages
adb shell pm list packages | grep hivebit

# Get version info
adb shell dumpsys package io.hivebit.companion.android | grep versionCode
```

---

## 📱 Complete Build & Install Workflow

### **Full Clean Build & Install:**
```bash
# 1. Clean everything
./gradlew clean

# 2. Set correct Java environment
export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk-17.0.2.jdk/Contents/Home

# 3. Verify JDK (must have javac compiler)
$JAVA_HOME/bin/javac -version

# 4. Build and install debug version
./gradlew installFullDebug

# 5. Launch the app
adb shell am start -n io.hivebit.companion.android.debug/io.hivebit.companion.android.launch.LaunchActivity
```

### **Release Build Workflow:**
```bash
# 1. Set environment variables for signing (if needed)
export KEYSTORE_PATH="/path/to/your/keystore.jks"
export KEYSTORE_PASSWORD="your_keystore_password"
export KEYSTORE_ALIAS="your_key_alias"
export KEYSTORE_ALIAS_PASSWORD="your_key_password"

# 2. Build release
./gradlew assembleFullRelease

# 3. Uninstall any existing version
adb shell pm uninstall --user 0 io.hivebit.companion.android

# 4. Install release APK
adb install app/build/outputs/apk/full/release/app-full-release.apk

# 5. Launch
adb shell monkey -p io.hivebit.companion.android 1
```

---

## 🐛 Debugging Crashes

### **View Live Logs:**
```bash
# Clear old logs and watch for crashes
adb logcat -c
adb shell monkey -p io.hivebit.companion.android 1
adb logcat | grep -E "FATAL|AndroidRuntime"
```

### **View Crash Details:**
```bash
# Get last crash
adb logcat -d | grep -A 100 "FATAL EXCEPTION" | head -120
```

### **Check App Status:**
```bash
# See if app is running
adb shell dumpsys activity activities | grep -A 10 "mResumedActivity"
```

---

## 🔄 Common Gradle Tasks

```bash
# Clean build
./gradlew clean

# Build debug APK (doesn't install)
./gradlew assembleFullDebug

# Build release APK (doesn't install)
./gradlew assembleFullRelease

# Build AND install debug
./gradlew installFullDebug

# Build AND install release
./gradlew installFullRelease

# Run tests
./gradlew testFullDebugUnitTest

# Check for updates
./gradlew dependencyUpdates
```

---

## 💡 Quick Reference

| Problem | Solution |
|---------|----------|
| Version downgrade error | `adb uninstall` before installing |
| JRE vs JDK error | Set `JAVA_HOME` to JDK 17 path |
| App crashes on launch | Check logcat: `adb logcat \| grep FATAL` |
| Signing errors | Set keystore environment variables |
| Build too slow | Enable configuration cache (already enabled) |
| Emulator not detected | Run `adb devices` to check connection |

---

## 📝 Tips for Success

1. **Always use Gradle tasks** (`installFullDebug`) instead of manual `adb install` when possible
2. **Set JAVA_HOME permanently** in your `~/.zshrc` file to avoid JRE/JDK issues
3. **Uninstall before release installs** to avoid version conflicts
4. **Check logcat immediately** after crashes to see error details
5. **Use `./gradlew clean`** if you see strange caching issues

---

## ✅ Current Status

**✓ App Successfully Installed** (as of Nov 25, 2025)
- Version: `0.0.1-SNAPSHOT-full`
- Build: Release APK
- Size: 29 MB
- Package: `io.hivebit.companion.android`
- Target SDK: 36
- Crash Fixed: WelcomeView icon issue resolved

The app is now running correctly with full Hivebit branding! 🎉
