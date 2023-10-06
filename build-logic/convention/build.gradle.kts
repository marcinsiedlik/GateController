plugins {
  `kotlin-dsl`
}

kotlin {
  jvmToolchain(17)
}

dependencies {
  compileOnly(libs.kotlin.gradlePlugin)
  compileOnly(libs.android.gradlePlugin)
}

gradlePlugin {
  plugins {
    register("androidApplication") {
      id = "gatecontroller.android.application"
      implementationClass = "AndroidApplicationConventionPlugin"
    }
    register("androidLibrary") {
      id = "gatecontroller.android.library"
      implementationClass = "AndroidLibraryConventionPlugin"
    }
    register("jvmLibrary") {
      id = "gatecontroller.jvm.library"
      implementationClass = "JvmLibraryConventionPlugin"
    }
  }
}
