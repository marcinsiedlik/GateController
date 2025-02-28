package pl.siedlik.gatecontroller

import org.gradle.api.Project
import org.jetbrains.kotlin.gradle.dsl.kotlinExtension

fun Project.configureKotlin() {
  kotlinExtension.apply {
    jvmToolchain(21)
  }
}
