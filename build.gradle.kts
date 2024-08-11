import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

subprojects{
	val kotlinVersion = "2.0.0"
	version = "0.0.1-SNAPSHOT"
	apply(plugin = "org.jetbrains.kotlin.jvm")
	dependencies{
		testImplementation(kotlin("test",kotlinVersion))
		implementation(kotlin("stdlib-jdk8",kotlinVersion))
		implementation(kotlin("reflect",kotlinVersion))
	}

	tasks.withType<KotlinCompile> {
		kotlinOptions {
			freeCompilerArgs = listOf("-Xjsr305=strict")
			jvmTarget = "17"
		}
	}
}

plugins {
	val kotlinVersion = "1.8.21"
	kotlin("jvm") version kotlinVersion
	kotlin("plugin.spring") version kotlinVersion
}
repositories {
	mavenCentral()
}

java.sourceSets.getByName("main"){
	java.srcDir("src/main/java")
	java.srcDir("src/main/kotlin")
}
java.sourceSets.getByName("test"){
	java.srcDir("src/test/kotlin")
}

