package pl.siedlik.gatecontroller

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

fun Project.configureCompose(commonExtension: CommonExtension<*, *, *, *, *, *>) {
  commonExtension.apply {
    buildFeatures {
      compose = true
    }
    composeOptions {
      kotlinCompilerExtensionVersion = libs.findVersion("composeCompiler").getAsString()
    }
  }

  dependencies {
    val bom = libs.findLibrary("compose-bom").get()
    add("implementation", platform(bom))
    add("androidTestImplementation", platform(bom))
  }
}
