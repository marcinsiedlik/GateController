import com.android.build.api.dsl.LibraryExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import pl.siedlik.gatecontroller.configureKotlin
import pl.siedlik.gatecontroller.configureProductFlavors
import pl.siedlik.gatecontroller.configureSdkVersions
import pl.siedlik.gatecontroller.configureTests

class AndroidLibraryConventionPlugin : Plugin<Project> {

  override fun apply(target: Project) = with(target) {
    with(pluginManager) {
      apply("com.android.library")
      apply("org.jetbrains.kotlin.android")
    }

    extensions.configure<LibraryExtension> {
      configureSdkVersions()
      configureProductFlavors()
    }
    configureKotlin()
    configureTests()
  }
}
