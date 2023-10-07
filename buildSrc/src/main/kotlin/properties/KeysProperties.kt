package properties

import org.gradle.api.Project

/**
 * @param project The project on which the directory properties file is located
 */
class KeysProperties(project: Project) {

  private val properties = parsePropertiesFile(project.file("keys.properties"))

  val devUrl: String
    get() = properties.requireProperty("keys.dev_url")

  val prodUrl: String
    get() = properties.requireProperty("keys.prod_url")

  val basicAuth: String
    get() = properties.requireProperty("keys.basic_auth")
}
