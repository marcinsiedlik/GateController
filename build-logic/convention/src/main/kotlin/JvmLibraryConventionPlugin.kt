import org.gradle.api.Plugin
import org.gradle.api.Project
import pl.siedlik.gatecontroller.configureKotlin
import pl.siedlik.gatecontroller.configureTests

class JvmLibraryConventionPlugin : Plugin<Project> {

  override fun apply(target: Project) = with(target) {
    with(pluginManager) {
      apply("org.jetbrains.kotlin.jvm")
    }
    configureKotlin()
    configureTests()
  }
}
