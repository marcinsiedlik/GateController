plugins {
  id("gatecontroller.android.library")
}

android {
  namespace = "pl.siedlik.gatecontroller.core.car"
}

dependencies {
  implementation(libs.kotlinx.coroutines.android)
  implementation(libs.androidx.core)
  implementation(libs.androidx.car)
  implementation(libs.lifecycle.runtime)
}
