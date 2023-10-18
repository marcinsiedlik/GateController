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
    register("androidApplicationCompose") {
      id = "gatecontroller.android.application.compose"
      implementationClass = "AndroidApplicationComposeConventionPlugin"
    }
    register("androidApplicationSigning") {
      id = "gatecontroller.android.application.signing"
      implementationClass = "AndroidApplicationSigningConventionPlugin"
    }
    register("androidLibrary") {
      id = "gatecontroller.android.library"
      implementationClass = "AndroidLibraryConventionPlugin"
    }
    register("androidLibraryCompose") {
      id = "gatecontroller.android.library.compose"
      implementationClass = "AndroidLibraryComposeConventionPlugin"
    }
    register("androidLibraryNetworking") {
      id = "gatecontroller.android.library.networking"
      implementationClass = "AndroidLibraryNetworkingConventionPlugin"
    }
    register("jvmLibrary") {
      id = "gatecontroller.jvm.library"
      implementationClass = "JvmLibraryConventionPlugin"
    }
  }
}
