plugins {
    id("java")
    id("io.freefair.lombok") version "8.12.1"
}

group = "xyz.refinedev.practice"
version = "1.0"

repositories {
    mavenCentral()
    mavenLocal()

    maven("https://maven.refinedev.xyz/public-repo")
}

dependencies {
    compileOnly("org.github.paperspigot:paperspigot:1.8.8-R0.1-SNAPSHOT") {
        exclude("com.google.code.gson", "gson")
    }
    compileOnly("com.github.cryptomorin:XSeries:12.1.0")
    compileOnly("org.jetbrains:annotations:24.0.1")
}
