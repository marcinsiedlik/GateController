plugins {
  id("gatecontroller.android.library")
  id("gatecontroller.android.library.compose")
}

android {
  namespace = "pl.siedlik.gatecontroller.feature.mobile.remote"
}

dependencies {
  implementation(projects.core.model)
  implementation(projects.domain.remote)
  implementation(projects.ui.common.design)
  implementation(projects.ui.mobile.design)

  implementation(libs.koin.android)
  implementation(libs.koin.android.compose)

  implementation(libs.compose.ui)
  implementation(libs.compose.material)
  debugImplementation(libs.compose.ui.tooling)
  implementation(libs.compose.ui.toolingPreview)

  implementation(libs.androidx.lifecycle)
  implementation(libs.androidx.lifecycleCompose)
}
