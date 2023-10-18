plugins {
  id("gatecontroller.android.library")
  id("gatecontroller.android.library.compose")
}

android {
  namespace = "pl.siedlik.gatecontroller.ui.common.design"
}

dependencies {
  implementation(libs.compose.ui)
}
