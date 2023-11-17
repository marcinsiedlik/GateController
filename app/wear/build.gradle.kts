plugins {
  id("gatecontroller.android.application.wear")
  id("gatecontroller.android.application.signing")
  id("gatecontroller.android.application.compose")
}

android {
  namespace = "pl.siedlik.gatecontroller"

  defaultConfig {
    proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
  }

  buildTypes {
    debug {
      signingConfig = signingConfigs.getByName("debug")
    }
    release {
      isMinifyEnabled = true
      isShrinkResources = true
      signingConfig = signingConfigs.findByName("upload")
    }
  }
}

dependencies {
  implementation(projects.feature.wear.remote)
  implementation(projects.ui.common.design)
  implementation(projects.ui.wear.design)

  implementation(libs.koin.android)
  implementation(libs.kotlinx.coroutines.android)
  implementation(libs.androidx.core)
  implementation(libs.androidx.splashscreen)
  implementation(libs.androidx.activityCompose)
  implementation(libs.compose.ui)
  implementation(libs.compose.wear.material)
  debugImplementation(libs.compose.ui.tooling)
  implementation(libs.compose.ui.toolingPreview)
  implementation(libs.compose.wear.ui.toolingPreview)
}
