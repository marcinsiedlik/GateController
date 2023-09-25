@file:Suppress("UnstableApiUsage")

import com.android.build.api.dsl.SettingsExtension

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
  repositories {
    google()
    mavenCentral()
    gradlePluginPortal()
  }
}

plugins {
  id("com.android.settings") version "8.1.1"
}

dependencyResolutionManagement {
  repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
  repositories {
    google()
    mavenCentral()
  }

  versionCatalogs {
    create("libs") {
      from(files("gradle/dependencies.toml"))
    }
  }
}

configure<SettingsExtension> {
  minSdk = 29
  compileSdk = 34
}

rootProject.name = "GateController"

include(":app")
