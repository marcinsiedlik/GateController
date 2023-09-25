package properties

import org.gradle.api.Project

/**
 * @param project The project on which the directory properties file is located
 */
class KeystoreProperties(project: Project) {

  private val properties = parsePropertiesFile(project.file("keystore/keystore.properties"))

  val storePassword: String
    get() = properties.requireProperty("signing.storePassword")

  val keyAlias: String
    get() = properties.requireProperty("signing.keyAlias")

  val keyPassword: String
    get() = properties.requireProperty("signing.keyPassword")
}
