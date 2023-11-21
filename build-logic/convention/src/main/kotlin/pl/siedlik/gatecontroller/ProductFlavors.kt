package pl.siedlik.gatecontroller

import com.android.build.api.dsl.ApplicationProductFlavor
import com.android.build.api.dsl.CommonExtension
import com.android.build.api.dsl.ProductFlavor
import com.android.build.api.dsl.VariantDimension
import org.gradle.api.Project

@Suppress("EnumEntryName")
enum class FlavorDimension {
  type,
}

@Suppress("EnumEntryName")
enum class AppFlavor(val dimension: FlavorDimension) {
  dev(FlavorDimension.type),
  prod(FlavorDimension.type),
}

fun CommonExtension<*, *, *, *, *>.configureProductFlavors(
  configurationBlock: ProductFlavor.(flavor: AppFlavor) -> Unit = {},
) {
  flavorDimensions += FlavorDimension.type.name
  productFlavors {
    AppFlavor.values().forEach { flavor ->
      create(flavor.name) {
        dimension = flavor.dimension.name
        configurationBlock(flavor)
      }
    }
  }
}

fun CommonExtension<*, *, *, *, *>.getProductFlavors(
  configurationBlock: ProductFlavor.(flavor: AppFlavor) -> Unit = {},
) {
  productFlavors {
    AppFlavor.values().forEach { flavor ->
      getByName(flavor.name) {
        configurationBlock(flavor)
      }
    }
  }
}

fun ProductFlavor.configureApplicationId(flavor: AppFlavor) {
  if (this !is ApplicationProductFlavor) {
    return
  }
  if (flavor == AppFlavor.dev) {
    applicationIdSuffix = ".dev"
  }
}

fun ProductFlavor.configureNetwork(project: Project, flavor: AppFlavor) {
  val propertiesFile = project.rootProject.file("keys.properties")
  val properties = parsePropertiesFile(propertiesFile)
  val baseUrl = when (flavor) {
    AppFlavor.dev -> properties["dev_url"]
    AppFlavor.prod -> properties["prod_url"]
  }
  buildConfigString("BASE_URL", baseUrl)
  buildConfigString("AUTH_TOKEN", properties["auth_token"])
}

fun VariantDimension.buildConfigString(name: String, value: String?) {
  buildConfigField("String", name, value.orEmpty())
}
