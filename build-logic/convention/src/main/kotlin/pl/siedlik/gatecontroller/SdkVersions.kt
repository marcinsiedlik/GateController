package pl.siedlik.gatecontroller

import com.android.build.api.dsl.CommonExtension

fun CommonExtension.configureSdkVersions() {
  compileSdk = 37
  defaultConfig.minSdk = 29
}
