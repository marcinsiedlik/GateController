plugins {
  id("gatecontroller.android.library")
  id("gatecontroller.android.library.compose")
}

android {
  namespace = "pl.siedlik.gatecontroller.ui.wear.design"
}

dependencies {
  implementation(projects.ui.common.design)

  implementation(libs.compose.ui)
  implementation(libs.compose.wear.material)
  debugImplementation(libs.compose.ui.tooling)
  implementation(libs.compose.ui.toolingPreview)
  implementation(libs.compose.wear.ui.toolingPreview)
}
