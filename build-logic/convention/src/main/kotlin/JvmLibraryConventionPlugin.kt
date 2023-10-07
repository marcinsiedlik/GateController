import org.gradle.api.Plugin
import org.gradle.api.Project
import pl.siedlik.gatecontroller.configureKotlin

class JvmLibraryConventionPlugin : Plugin<Project> {

  override fun apply(target: Project) = with(target) {
    with(pluginManager) {
      apply("org.jetbrains.kotlin.jvm")
    }
    configureKotlin()
  }
}
