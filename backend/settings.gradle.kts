pluginManagement {
  val kotlinVersion: String by settings
  val springBootVersion: String by settings
  val springDependencyManagementVersion: String by settings
  val restdocsApiSpecVersion: String by settings
  val swaggerGeneratorVersion: String by settings

  resolutionStrategy {
    eachPlugin {
      when (requested.id.id) {
        "org.springframework.boot" -> useVersion(springBootVersion)
        "io.spring.dependency-management" -> useVersion(springDependencyManagementVersion)
        "com.epages.restdocs-api-spec" -> useVersion(restdocsApiSpecVersion)
        "org.hidetake.swagger.generator" -> useVersion(swaggerGeneratorVersion)
        "org.jetbrains.kotlin.jvm",
        "org.jetbrains.kotlin.plugin.spring",
        "org.jetbrains.kotlin.plugin.jpa",
        "org.jetbrains.kotlin.kapt",
        "org.jetbrains.kotlin.plugin.allopen" -> useVersion(kotlinVersion)
      }
    }
  }
}

rootProject.name = "seoul-awake-be"
