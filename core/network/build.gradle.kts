plugins {
  id("gatecontroller.android.library")
  id("gatecontroller.android.library.networking")
}

android {
  namespace = "pl.siedlik.gatecontroller.core.network"
}

dependencies {
  implementation(projects.core.model)

  implementation(libs.koin.android)
  implementation(libs.kotlinx.coroutines.core)

  implementation(libs.ktor.core)
  implementation(libs.ktor.auth)
  implementation(libs.ktor.logging)
  implementation(libs.ktor.android)
}
