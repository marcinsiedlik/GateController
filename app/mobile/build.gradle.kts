plugins {
  id("gatecontroller.android.application")
  id("gatecontroller.android.application.signing")
  id("gatecontroller.android.application.compose")
}

android {
  namespace = "pl.siedlik.gatecontroller"

  defaultConfig {
    applicationId = "pl.siedlik.gatecontroller"
    versionCode = 1
    versionName = "1.0"
    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
  }

  buildFeatures {
    buildConfig = true
  }

  buildTypes {
    debug {
      signingConfig = signingConfigs.getByName("debug")
    }
    release {
      isMinifyEnabled = true
      isShrinkResources = true
      signingConfig = signingConfigs.getByName("upload")
    }
  }
}

dependencies {
  implementation(projects.core.car)
  implementation(projects.feature.car.remote)
  implementation(projects.feature.mobile.remote)
  implementation(projects.ui.mobile.design)
  implementation(projects.ui.common.design)

  implementation(libs.koin.android)
  implementation(libs.kotlinx.coroutines.android)
  implementation(libs.androidx.core)
  implementation(libs.androidx.splashscreen)
  implementation(libs.androidx.activityCompose)
  implementation(libs.compose.ui)
  implementation(libs.compose.material)
  implementation(libs.androidx.car)
  debugImplementation(libs.compose.ui.tooling)
  implementation(libs.compose.ui.toolingPreview)
}
