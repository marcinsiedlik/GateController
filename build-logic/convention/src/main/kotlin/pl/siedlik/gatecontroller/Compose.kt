package pl.siedlik.gatecontroller

import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

fun Project.configureCompose() {
  dependencies {
    val bom = libs.findLibrary("compose-bom").get()
    add("implementation", platform(bom))
    add("androidTestImplementation", platform(bom))
  }
}
