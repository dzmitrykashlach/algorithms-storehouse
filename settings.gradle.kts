rootProject.name = "algorithms-storehouse"
include("benchmarks")
include("impl")
pluginManagement {
    plugins {
        java
        kotlin("jvm") version "1.8.20"
        kotlin("plugin.allopen") version "1.8.20"
        kotlin("plugin.spring") version "1.8.20"
        id("org.jetbrains.kotlinx.benchmark") version "0.4.7"
    }
}
include("multithreading")
