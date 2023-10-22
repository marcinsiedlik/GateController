plugins {
  id("gatecontroller.android.library")
}

android {
  namespace = "pl.siedlik.gatecontroller.data.remote"
}

dependencies {
  implementation(projects.core.dispatchers)
  implementation(projects.core.network)
  implementation(projects.core.model)

  implementation(libs.koin.core)
  implementation(libs.kotlinx.coroutines.core)
  implementation(libs.ktor.core)
  testImplementation(libs.bundles.test)
}