import org.gradle.api.Plugin
import org.gradle.api.Project
import pl.siedlik.gatecontroller.configureCompose

class AndroidLibraryComposeConventionPlugin : Plugin<Project> {

  override fun apply(target: Project) = with(target) {
    with(pluginManager) {
      apply("com.android.library")
      apply("org.jetbrains.kotlin.plugin.compose")
    }

    configureCompose()
  }
}
