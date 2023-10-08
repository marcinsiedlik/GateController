plugins {
  id("gatecontroller.jvm.library")
}

dependencies {
  implementation(libs.koin.core)
  implementation(libs.kotlinx.coroutines.core)
}
