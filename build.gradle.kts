plugins {
  with(libs.plugins) {
    alias(android.app) apply false
    alias(android.lib) apply false
    alias(kotlin.jvm) apply false
    alias(kotlin.android) apply false
    alias(kotlin.compose) apply false
  }
}
