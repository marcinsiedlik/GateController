plugins {
  id("gatecontroller.android.library")
}

android {
  namespace = "pl.siedlik.gatecontroller.domain.remote"
}

dependencies {
  implementation(projects.data.remote)

  implementation(platform(libs.koin.bom))
  implementation(libs.koin.core)
  testImplementation(libs.bundles.test)
}
