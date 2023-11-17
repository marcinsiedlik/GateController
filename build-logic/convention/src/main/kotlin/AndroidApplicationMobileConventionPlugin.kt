import com.android.build.api.dsl.ApplicationExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import pl.siedlik.gatecontroller.AppPlatform
import pl.siedlik.gatecontroller.configureAppVersion
import pl.siedlik.gatecontroller.configureApplicationId
import pl.siedlik.gatecontroller.configureKotlin
import pl.siedlik.gatecontroller.configureProductFlavors
import pl.siedlik.gatecontroller.configureSdkVersions
import pl.siedlik.gatecontroller.configureTests

class AndroidApplicationMobileConventionPlugin : Plugin<Project> {

  override fun apply(target: Project) = with(target) {
    with(pluginManager) {
      apply("com.android.application")
      apply("org.jetbrains.kotlin.android")
    }

    extensions.configure<ApplicationExtension> {
      defaultConfig.targetSdk = 34
      configureSdkVersions()
      configureAppVersion(platform = AppPlatform.Mobile)
      configureProductFlavors { flavor ->
        configureApplicationId(flavor)
      }
    }
    configureKotlin()
    configureTests()
  }
}
