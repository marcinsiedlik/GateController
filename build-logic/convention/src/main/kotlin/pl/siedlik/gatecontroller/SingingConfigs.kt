package pl.siedlik.gatecontroller

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.Project

fun Project.configureSigningConfigs(commonExtension: CommonExtension<*, *, *, *, *>) {
  commonExtension.signingConfigs {
    named("debug") {
      storeFile = rootProject.file("keystore/debug.jks")
      storePassword = "android"
      keyAlias = "android"
      keyPassword = "android"
    }

    register("upload") {
      val propertiesFile = rootProject.file("keystore/upload.properties")
      val properties = parsePropertiesFile(propertiesFile)

      storeFile = rootProject.file("keystore/upload.jks")
      storePassword = properties["storePassword"]
      keyAlias = properties["keyAlias"]
      keyPassword = properties["keyPassword"]
    }
  }
}
