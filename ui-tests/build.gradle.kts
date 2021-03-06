/*
 * This file was generated by the Gradle 'init' task.
 *
 * This generated file contains a sample Kotlin application project to get you started.
 * For more details take a look at the 'Building Java & JVM projects' chapter in the Gradle
 * User Manual available at https://docs.gradle.org/6.7/userguide/building_java_projects.html
 */

plugins {
    // Apply the org.jetbrains.kotlin.jvm Plugin to add support for Kotlin.
    id("org.jetbrains.kotlin.jvm") version "1.4.10"
}

repositories {
    // Use JCenter for resolving dependencies.
    mavenLocal()
    mavenCentral()
    jcenter()
    maven("https://jitpack.io")
}

dependencies {
    implementation(platform("org.jetbrains.kotlin:kotlin-bom"))
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    testImplementation(group = "org.seleniumhq.selenium", name = "selenium-java", version = "3.141.59")
    testImplementation(group = "com.github.detro", name = "ghostdriver", version = "2.1.0")
    testImplementation(group = "org.junit.jupiter", name = "junit-jupiter-api", version = "5.2.0")
    testImplementation(group = "org.junit.jupiter", name = "junit-jupiter-engine", version = "5.2.0")
    testImplementation(group = "org.assertj", name = "assertj-core", version = "3.11.1")
}

tasks.withType<Test> {
    useJUnitPlatform()
}
