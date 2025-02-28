package pl.siedlik.gatecontroller

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.Project

fun Project.configureSigningConfigs(commonExtension: CommonExtension<*, *, *, *, *, *>) {
  commonExtension.signingConfigs {
    val debugKeystoreFile = rootProject.file("keystore/debug.jks")
    val uploadKeystoreFile = rootProject.file("keystore/upload.jks")
    val uploadPropertiesFile = rootProject.file("keystore/upload.properties")

    named("debug") {
      storeFile = debugKeystoreFile
      storePassword = "android"
      keyAlias = "android"
      keyPassword = "android"
    }

    if (uploadKeystoreFile.exists() && uploadPropertiesFile.exists()) {
      register("upload") {
        val properties = parsePropertiesFile(uploadPropertiesFile)
        storeFile = uploadKeystoreFile
        storePassword = properties["storePassword"]
        keyAlias = properties["keyAlias"]
        keyPassword = properties["keyPassword"]
      }
    }
  }
}
