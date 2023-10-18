plugins {
  id("gatecontroller.android.library")
  id("gatecontroller.android.library.compose")
}

android {
  namespace = "pl.siedlik.gatecontroller.ui.mobile.design"
}

dependencies {
  implementation(projects.ui.common.design)

  implementation(libs.compose.ui)
  implementation(libs.compose.material)
  debugImplementation(libs.compose.ui.tooling)
  implementation(libs.compose.ui.toolingPreview)
}
