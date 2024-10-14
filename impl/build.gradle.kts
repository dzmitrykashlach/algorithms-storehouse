group = "com.algorithms.storehouse"
java.sourceCompatibility = JavaVersion.VERSION_17
repositories {
    mavenCentral()
}

dependencies {
    val lombokVersion = "1.18.30"
    implementation("org.projectlombok:lombok:$lombokVersion")
    implementation("org.apache.commons:commons-collections4:4.4")
    annotationProcessor("org.projectlombok:lombok:$lombokVersion")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.0.1")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.9.8")
}

java.sourceSets.getByName("main"){
    java.srcDir("src/main/kotlin")
}
java.sourceSets.getByName("test"){
    java.srcDir("src/test/kotlin")
}