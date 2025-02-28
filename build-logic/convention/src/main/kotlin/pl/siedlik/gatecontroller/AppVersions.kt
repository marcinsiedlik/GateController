package pl.siedlik.gatecontroller

import com.android.build.api.dsl.ApplicationExtension

enum class AppPlatform(val versionSuffix: Int) {
  Mobile(1),
  Wear(2),
}

object AppVersion {

  private const val versionMajor = 2
  private const val versionMinor = 6

  const val applicationId = "pl.siedlik.gatecontroller"
  const val versionName = "$versionMajor.$versionMinor"

  fun getVersionCode(platform: AppPlatform): Int =
    (versionMajor * 10000) + (versionMinor * 1000) + platform.versionSuffix
}

fun ApplicationExtension.configureAppVersion(platform: AppPlatform) {
  defaultConfig {
    applicationId = AppVersion.applicationId
    versionName = AppVersion.versionName
    versionCode = AppVersion.getVersionCode(platform)
  }
}
