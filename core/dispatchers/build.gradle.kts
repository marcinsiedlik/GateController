plugins {
  id("gatecontroller.jvm.library")
}

dependencies {
  implementation(platform(libs.koin.bom))
  implementation(libs.koin.core)
  implementation(libs.kotlinx.coroutines.core)
}
