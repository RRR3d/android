# 📱 Hivebit Android App - Google Play Store Upload Guide

Complete step-by-step guide to upload your Hivebit Android app to Google Play Store.

---

## 🔑 Prerequisites

### 1. Google Play Console Account
- **Cost**: $25 one-time registration fee
- **Sign up**: https://play.google.com/console/signup
- **Requirements**: Google account + payment method

### 2. Release APK/AAB File
Your release build is ready at:
```
app/build/outputs/apk/full/release/app-full-release.apk (29 MB)
```

**⚠️ IMPORTANT**: Google Play requires **Android App Bundle (.aab)** format (not APK) for new apps.

---

## 📦 Step 1: Build Android App Bundle (AAB)

### Build the AAB file:
```bash
./gradlew bundleFullRelease
```

### AAB Location:
```
app/build/outputs/bundle/fullRelease/app-full-release.aab
```

### Why AAB instead of APK?
- **Required** by Google Play for new apps since August 2021
- Smaller download sizes (Google Play generates optimized APKs)
- Better compression and delivery

---

## 🔐 Step 2: Configure App Signing

### Option A: Use Play App Signing (Recommended)

1. **Keep your existing keystore safe** - it's your backup
2. Google Play will generate a new upload key
3. Benefits:
   - Google manages your signing key securely
   - You can reset upload key if lost
   - Automatic optimization

### Option B: Manual Signing (If you prefer)

Your current signing configuration (from `AndroidApplicationConventionPlugin.kt`):
```kotlin
signingConfigs {
    create("release") {
        storeFile = file(System.getenv("KEYSTORE_PATH") ?: "release_keystore.keystore")
        storePassword = System.getenv("KEYSTORE_PASSWORD") ?: ""
        keyAlias = System.getenv("KEYSTORE_ALIAS") ?: ""
        keyPassword = System.getenv("KEYSTORE_ALIAS_PASSWORD") ?: ""
    }
}
```

**⚠️ CRITICAL**: 
- **NEVER lose your keystore file** - make encrypted backups
- Store passwords in a password manager
- If you lose the keystore, you can NEVER update the app

---

## 📝 Step 3: Prepare Store Listing Assets

### Required Assets:

#### **1. App Icons**
✅ Already created:
- Location: `app/src/main/res/mipmap-*/ic_launcher.webp`
- 60+ icons in all densities (mdpi to xxxhdpi)

#### **2. Feature Graphic** (Required)
- **Size**: 1024 x 500 px
- **Format**: PNG or JPG
- **Content**: Showcase "Hivebit" branding with your gold logo
- **Tip**: Use dark background (#1A1A1A) with Hivebit Gold logo

#### **3. Screenshots** (Minimum 2, Maximum 8)
- **Phone**: 
  - Minimum: 320px
  - Maximum: 3840px
  - Recommended: 1080 x 1920 px or 1080 x 2340 px
- **Tablet** (Optional but recommended):
  - 7-inch: 1200 x 1920 px
  - 10-inch: 1600 x 2560 px

**📸 How to take screenshots:**
```bash
# Open app on emulator/device
adb shell monkey -p io.hivebit.companion.android 1

# Take screenshot
adb exec-out screencap -p > screenshot1.png

# Or use Android Studio: Tools → Device Manager → Camera icon
```

#### **4. App Video** (Optional)
- YouTube video showcasing Hivebit features
- 30 seconds to 2 minutes recommended

---

## 🚀 Step 4: Create App in Play Console

### 1. Go to Play Console
https://play.google.com/console

### 2. Click "Create app"

### 3. Fill in Basic Information:
```
App name: HiveBit
Default language: English (United States)
App or game: App
Free or paid: Free (or Paid - your choice)
```

### 4. Declarations:
- Developer Program Policies: ✓ Accept
- US export laws: ✓ Confirm

---

## 📋 Step 5: Complete Store Listing

### App Details:

**App name**: `HiveBit`

**Short description** (80 characters max):
```
Smart home automation - Connect, control, and secure your home
```

**Full description** (4000 characters max):
```
Welcome to HiveBit - Smart Living Starts Here

Transform your house into a smart home with HiveBit, the ultimate companion app for home automation. Make your home more connected, more secure, and more comfortable.

🏠 KEY FEATURES:

• Smart Device Control
  Control lights, thermostats, locks, cameras, and more from one beautiful app

• Home Automation
  Create intelligent automations that make your home respond to your needs

• Voice Control
  Integrate with voice assistants for hands-free control

• Real-time Monitoring
  Track energy usage, security status, and device health

• Secure & Private
  Your data stays on your server - complete privacy control

• Beautiful Dark Theme
  Elegant Hivebit Gold design optimized for comfortable viewing

🌟 WHY HIVEBIT?

✓ Easy Setup - Get started in minutes
✓ Unlimited Devices - No restrictions on connected devices
✓ Local Control - Works even without internet
✓ Open Source - Transparent and community-driven
✓ Regular Updates - Continuous improvements

🔒 PRIVACY FIRST

Unlike other smart home apps, HiveBit keeps your data private. All automation runs locally on your own server - we never see your data.

📱 REQUIREMENTS

• HiveBit server (self-hosted or cloud)
• Android 7.0 or higher
• Wi-Fi or mobile data connection

Transform your living space into a smart home with HiveBit today!
```

**App icon**: Upload your launcher icon (512 x 512 px)

**Feature graphic**: Upload 1024 x 500 px image

**Screenshots**: Upload 2-8 phone screenshots

### Categorization:

**App category**: `House & Home`

**Tags** (up to 5):
```
- Smart Home
- Home Automation  
- IoT
- Home Security
- Home Control
```

### Contact Details:

**Email**: your-support-email@hivebit.io

**Phone** (optional): Your support phone number

**Website** (optional): https://your-hivebit-website.com

### Privacy Policy:

**⚠️ REQUIRED** - You MUST provide a privacy policy URL

Example content:
```
Privacy Policy for HiveBit

Your privacy is important to us. HiveBit connects to your self-hosted 
home automation server. We do not collect, store, or transmit any 
personal data to third parties.

Data Collection:
- App does not collect analytics
- All data stays on your local server
- No tracking or advertising

Permissions:
- Location: For location-based automations
- Camera: For QR code scanning during setup
- Notifications: For alerts and updates

Contact: privacy@hivebit.io
```

---

## 🎯 Step 6: Content Rating

### Fill out questionnaire:
1. Select "Utility, Productivity, Communication or Other"
2. Answer questions about:
   - Violence: No
   - Sexual content: No
   - Language: No
   - Controlled substances: No
   - Gambling: No
   - User interaction: Yes (users can interact with devices)

### Result: Usually **"Everyone"** or **"Everyone 10+"**

---

## 🌍 Step 7: Target Audience & Content

### Target age group:
- **Recommended**: 18+ (smart home users are typically adults)

### Data safety:
You must declare what data you collect:

**Data collected**:
- Location (for automations)
- Device information (for device control)

**Data usage**:
- Functional (required for app features)
- Not shared with third parties
- Encrypted in transit

**User control**:
- Users can delete data
- Data stays on user's server

---

## 📲 Step 8: Upload AAB

### 1. Create Release:
- Go to: **Production** → **Create new release**

### 2. Upload AAB:
```bash
# Make sure AAB is built
./gradlew bundleFullRelease

# Upload this file:
app/build/outputs/bundle/fullRelease/app-full-release.aab
```

### 3. Release name:
```
Version 0.0.1 - Initial Release
```

### 4. Release notes:
```
🎉 Welcome to HiveBit!

This is the initial release of HiveBit - your smart home companion.

✨ Features:
• Beautiful dark theme with Hivebit Gold accents
• Complete smart home device control
• Local automation that respects your privacy
• Real-time device monitoring
• Secure local control

🔒 Privacy-focused: All data stays on your server

📱 Requirements: HiveBit server required
```

---

## ✅ Step 9: Review & Publish

### Pre-launch Report:
- Google will test on 20+ real devices
- Review for crashes and compatibility issues
- Takes 1-2 hours

### Final Review Checklist:
- ✓ All store listing info complete
- ✓ Screenshots uploaded (min 2)
- ✓ Feature graphic uploaded
- ✓ Content rating completed
- ✓ Privacy policy URL provided
- ✓ AAB uploaded and signed
- ✓ Release notes written

### Click "Send for Review"

### Review Time:
- Usually **1-3 days**
- Can take up to 7 days
- You'll get email notification

---

## 📊 Step 10: After Publishing

### App is Live! 🎉

**Play Store URL format**:
```
https://play.google.com/store/apps/details?id=io.hivebit.companion.android
```

### Monitor:
- **Crashes**: Play Console → Quality → Crashes
- **ANRs**: Play Console → Quality → ANRs
- **Reviews**: Respond to user feedback
- **Statistics**: Track installs and engagement

### Updates:
When you want to update:
```bash
# 1. Increment version in build.gradle.kts:
versionCode = 2
versionName = "0.0.2"

# 2. Build new AAB
./gradlew bundleFullRelease

# 3. Upload to Play Console → Production → Create new release
```

---

## 🔒 Security Best Practices

### Keystore Management:
```bash
# Backup your keystore (CRITICAL!)
cp release_keystore.keystore ~/Backups/hivebit_keystore_backup_$(date +%Y%m%d).keystore

# Encrypt backup
zip -e hivebit_keystore_backup.zip release_keystore.keystore

# Store passwords securely (use a password manager)
```

### Environment Variables:
```bash
# Never commit these to git!
export KEYSTORE_PATH="/path/to/release_keystore.keystore"
export KEYSTORE_PASSWORD="your_secure_password"
export KEYSTORE_ALIAS="your_key_alias"
export KEYSTORE_ALIAS_PASSWORD="your_alias_password"
```

---

## 📱 Quick Command Reference

```bash
# Build release AAB
./gradlew bundleFullRelease

# Build release APK (for testing)
./gradlew assembleFullRelease

# Install on device for testing
adb install app/build/outputs/apk/full/release/app-full-release.apk

# Check APK size
ls -lh app/build/outputs/apk/full/release/app-full-release.apk

# Check AAB size
ls -lh app/build/outputs/bundle/fullRelease/app-full-release.aab

# Take screenshot
adb exec-out screencap -p > screenshot.png
```

---

## 🆘 Troubleshooting

### "App not compatible with any devices"
- Check `minSdk` in build.gradle (currently 26 - Android 8.0)
- Review supported screen sizes
- Check required permissions aren't too restrictive

### "Upload failed - signature mismatch"
- Ensure you're using the same keystore
- Check keystore alias matches
- Verify passwords are correct

### "Pre-launch report shows crashes"
- Review crash logs in Play Console
- Test on physical devices
- Check for null pointer exceptions

### "Review taking too long"
- Be patient (can take up to 7 days)
- Respond quickly if Google requests info
- Check for policy violations

---

## 📧 Support

If you need help:
- **Play Console Help**: https://support.google.com/googleplay/android-developer
- **Community**: https://www.reddit.com/r/androiddev
- **Developer Docs**: https://developer.android.com/distribute

---

## ✅ Final Checklist

Before submitting to Google Play:

- [ ] Google Play Developer account created ($25)
- [ ] AAB file built (`./gradlew bundleFullRelease`)
- [ ] Keystore securely backed up
- [ ] App icon prepared (512x512px)
- [ ] Feature graphic created (1024x500px)
- [ ] Screenshots taken (minimum 2)
- [ ] Privacy policy URL ready
- [ ] Store listing description written
- [ ] Content rating completed
- [ ] Data safety form filled
- [ ] Release notes written
- [ ] Pre-launch report reviewed
- [ ] All policies accepted

**Good luck with your Google Play submission! 🚀**

---

**Current Build Info:**
- Package: `io.hivebit.companion.android`
- Version: `0.0.1-SNAPSHOT`
- Min SDK: 26 (Android 8.0)
- Target SDK: 36 (Android 15)
- Release APK: 29 MB
