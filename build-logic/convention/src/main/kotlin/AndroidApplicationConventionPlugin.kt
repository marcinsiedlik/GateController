import com.android.build.api.dsl.ApplicationExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import pl.siedlik.gatecontroller.configureKotlin
import pl.siedlik.gatecontroller.configureSdkVersions
import pl.siedlik.gatecontroller.configureSigningConfigs

class AndroidApplicationConventionPlugin : Plugin<Project> {

  override fun apply(target: Project) = with(target) {
    with(pluginManager) {
      apply("com.android.application")
      apply("org.jetbrains.kotlin.android")
    }

    extensions.configure<ApplicationExtension> {
      defaultConfig.targetSdk = 34
      configureSdkVersions()
      configureSigningConfigs(this)
    }
    configureKotlin()
  }
}
