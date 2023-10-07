import com.android.build.api.dsl.LibraryExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import pl.siedlik.gatecontroller.configureNetwork
import pl.siedlik.gatecontroller.getProductFlavors

class AndroidLibraryNetworkingConventionPlugin : Plugin<Project> {

  override fun apply(target: Project) = with(target) {
    with(pluginManager) {
      apply("com.android.library")
    }

    extensions.configure<LibraryExtension> {
      buildFeatures {
        buildConfig = true
      }
      getProductFlavors { flavor ->
        configureNetwork(this@with, flavor)
      }
    }
  }
}
