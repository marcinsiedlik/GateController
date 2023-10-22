plugins {
  id("gatecontroller.android.library")
}

android {
  namespace = "pl.siedlik.gatecontroller.domain.remote"
}

dependencies {
  implementation(projects.data.remote)
  implementation(libs.koin.core)
  testImplementation(libs.bundles.test)
}
