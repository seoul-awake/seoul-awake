import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
  java
  application
  id("org.springframework.boot")
  id("io.spring.dependency-management")
  kotlin("jvm")
  kotlin("kapt")
  kotlin("plugin.spring")
  kotlin("plugin.jpa")
  kotlin("plugin.allopen")
  id("com.epages.restdocs-api-spec")
  id("org.hidetake.swagger.generator")
}

val jar: Jar by tasks
val projectGroup: String by project
val applicationVersion: String by project

group = projectGroup
version = applicationVersion

jar.enabled = false
java.sourceCompatibility = JavaVersion.VERSION_17

apply(from = "gradle/test-support.gradle")
apply(from = "gradle/rest-docs.gradle")

allOpen {
  annotation("jakarta.persistence.Entity")
  annotation("jakarta.persistence.Embeddable")
  annotation("jakarta.persistence.MappedSuperclass")
}

dependencies {
  // spring
  implementation("org.springframework.boot:spring-boot-starter-web")
  implementation("org.springframework.boot:spring-boot-starter-validation")

  // db
  implementation("org.springframework.boot:spring-boot-starter-data-jpa")
  runtimeOnly("com.mysql:mysql-connector-j")
  runtimeOnly("com.h2database:h2")

  // jasypt
  implementation("com.github.ulisesbocchio:jasypt-spring-boot-starter:3.0.4")

  implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
  implementation("org.jetbrains.kotlin:kotlin-reflect")
}

repositories {
  mavenCentral()
}

tasks.withType<KotlinCompile> {
  kotlinOptions {
    freeCompilerArgs = listOf("-Xjsr305=strict", "-Xjvm-default=all")
    jvmTarget = "17"
  }
}
