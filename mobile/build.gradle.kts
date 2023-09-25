import config.AppConfig
import config.ConfigFields
import properties.KeysProperties
import properties.KeystoreProperties

plugins {
  alias(libs.plugins.android.app)
  alias(libs.plugins.kotlin.android)
}

android {
  val keys = KeysProperties(rootProject)

  namespace = AppConfig.applicationId

  defaultConfig {
    applicationId = AppConfig.applicationId
    targetSdk = 34
    versionCode = 1
    versionName = "1.0"
    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
    buildConfigField(ConfigFields.TypeString, ConfigFields.BasicAuth, keys.basicAuth)
  }

  signingConfigs {
    named("debug") {
      storeFile = rootProject.file("keystore/debug.jks")
      storePassword = "android"
      keyAlias = "android"
      keyPassword = "android"
    }
    register("upload") {
      val keystore = KeystoreProperties(rootProject)
      storeFile = rootProject.file("keystore/upload.jks")
      storePassword = keystore.storePassword
      keyAlias = keystore.keyAlias
      keyPassword = keystore.keyPassword
    }
  }

  buildTypes {
    debug {
      applicationIdSuffix = ".debug"
      versionNameSuffix = "-debug"
      signingConfig = signingConfigs.getByName("debug")
      buildConfigField(ConfigFields.TypeString, ConfigFields.BaseUrl, keys.devUrl)
    }
    register("qa") {
      isMinifyEnabled = true
      isShrinkResources = true
      applicationIdSuffix = ".qa"
      versionNameSuffix = "-qa"
      signingConfig = signingConfigs.getByName("debug")
      buildConfigField(ConfigFields.TypeString, ConfigFields.BaseUrl, keys.devUrl)
    }
    release {
      isMinifyEnabled = true
      isShrinkResources = true
      signingConfig = signingConfigs.getByName("upload")
      buildConfigField(ConfigFields.TypeString, ConfigFields.BaseUrl, keys.prodUrl)
    }
  }
  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
  }
  kotlinOptions {
    jvmTarget = "1.8"
  }
  buildFeatures {
    compose = true
    buildConfig = true
  }
  composeOptions {
    kotlinCompilerExtensionVersion = "1.5.3"
  }
  packaging {
    resources {
      excludes += "/META-INF/{AL2.0,LGPL2.1}"
    }
  }
}

dependencies {

  implementation("androidx.core:core-ktx:1.9.0")
  implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
  implementation("androidx.activity:activity-compose:1.7.2")
  implementation(platform("androidx.compose:compose-bom:2023.03.00"))
  implementation("androidx.compose.ui:ui")
  implementation("androidx.compose.ui:ui-graphics")
  implementation("androidx.compose.ui:ui-tooling-preview")
  implementation("androidx.compose.material3:material3")
  testImplementation("junit:junit:4.13.2")
  androidTestImplementation("androidx.test.ext:junit:1.1.5")
  androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
  androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
  androidTestImplementation("androidx.compose.ui:ui-test-junit4")
  debugImplementation("androidx.compose.ui:ui-tooling")
  debugImplementation("androidx.compose.ui:ui-test-manifest")
}