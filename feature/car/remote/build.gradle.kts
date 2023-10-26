plugins {
  id("gatecontroller.android.library")
}

android {
  namespace = "pl.siedlik.gatecontroller.feature.car.remote"
}

dependencies {
  implementation(projects.core.car)
  implementation(projects.core.model)
  implementation(projects.domain.remote)
  implementation(projects.ui.common.design)

  implementation(libs.koin.android)
  implementation(libs.kotlinx.coroutines.android)
  implementation(libs.androidx.car)
  implementation(libs.lifecycle.runtime)
  testImplementation(libs.bundles.test)
}
