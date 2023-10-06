package pl.siedlik.gatecontroller

import java.io.File
import java.util.Properties

fun parsePropertiesFile(file: File): Map<String, String> {
  val keystoreProperties = Properties().apply {
    load(file.inputStream())
  }
  return keystoreProperties.mapNotNull { entry ->
    if (entry.key == null || entry.value == null) return@mapNotNull null
    else entry.key.toString() to entry.value.toString()
  }.toMap()
}
