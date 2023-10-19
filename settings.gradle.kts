@file:Suppress("UnstableApiUsage")

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
  includeBuild("build-logic")
  repositories {
    google()
    mavenCentral()
    gradlePluginPortal()
  }
}

dependencyResolutionManagement {
  repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
  repositories {
    google()
    mavenCentral()
  }
}

rootProject.name = "GateController"

include(":app:mobile")
include(":app:wear")

include(":core:dispatchers")
include(":core:model")
include(":core:network")
include(":data:remote")
include(":domain:remote")

include(":ui:common:design")
include(":ui:mobile:design")
include(":ui:wear:design")

include(":feature:mobile:remote")
include(":feature:wear:remote")
