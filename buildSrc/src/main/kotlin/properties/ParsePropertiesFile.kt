package properties

import java.io.File
import java.util.Properties

internal fun parsePropertiesFile(file: File): Map<String, String> {
  val keystoreProperties = Properties().apply {
    load(file.inputStream())
  }
  return keystoreProperties.mapNotNull { entry ->
    if (entry.key == null || entry.value == null) return@mapNotNull null
    else entry.key.toString() to entry.value.toString()
  }.toMap()
}

internal fun Map<String, String>.requireProperty(key: String) =
  get(key) ?: throw IllegalStateException("Cannot find key: $key")
