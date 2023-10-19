plugins {
  id("gatecontroller.android.library")
  id("gatecontroller.android.library.networking")
}

android {
  namespace = "pl.siedlik.gatecontroller.core.network"
  defaultConfig.consumerProguardFiles("proguard-rules.pro")
}

dependencies {
  implementation(projects.core.model)

  implementation(libs.koin.android)
  implementation(libs.kotlinx.coroutines.core)
  implementation(libs.bundles.ktor)
}
