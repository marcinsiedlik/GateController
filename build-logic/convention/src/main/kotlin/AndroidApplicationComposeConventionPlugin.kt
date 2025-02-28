import org.gradle.api.Plugin
import org.gradle.api.Project
import pl.siedlik.gatecontroller.configureCompose

class AndroidApplicationComposeConventionPlugin : Plugin<Project> {

  override fun apply(target: Project) = with(target) {
    with(pluginManager) {
      apply("com.android.application")
      apply("org.jetbrains.kotlin.plugin.compose")
    }

    configureCompose()
  }
}
