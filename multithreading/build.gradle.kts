val coroutines_version: String by project

plugins {
    id("java")
    kotlin("jvm")

}

group = "com.algorithms.multithreading"

repositories {
    mavenCentral()
}

dependencies {
    dependencies {
        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutines_version")
    }
}

tasks.test {
    useJUnitPlatform()
}