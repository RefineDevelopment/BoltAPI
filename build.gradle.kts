plugins {
    id("java-library")
    id("io.freefair.lombok") version "8.12.1"
    id("maven-publish")
}

group = "xyz.refinedev.practice"
version = "1.0.1"

repositories {
    mavenCentral()
    mavenLocal()

    maven("https://maven.refinedev.xyz/public-repo")
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(8))

    withSourcesJar()
    withJavadocJar()
}

val outputDir = layout.projectDirectory.dir("jars")

tasks.jar {
    destinationDirectory.set(outputDir)
}

tasks.named<Jar>("sourcesJar") {
    destinationDirectory.set(outputDir)
}

tasks.named<Jar>("javadocJar") {
    destinationDirectory.set(outputDir)
}

dependencies {
    compileOnly("io.papermc.paper:paper-api:1.8.8-R0.1-SNAPSHOT")
    compileOnly("org.jetbrains:annotations:24.0.1")
    compileOnlyApi("com.github.cryptomorin:XSeries:12.1.0")
    compileOnlyApi("xyz.refinedev.api:SkinAPI:1.1")
    compileOnlyApi("xyz.refinedev.api:KnockbackAPI:1.0.0")
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            from(components["java"])

            groupId = group.toString()
            artifactId = artifactId.toString()
            version = version.toString()
        }
    }

    repositories {
        mavenLocal()

         maven {
             name = "refine-public"
             url = uri("https://maven.refinedev.xyz/public-repo")
             credentials {
                 username = findProperty("mavenUsername") as String? ?: ""
                 password = findProperty("mavenPassword") as String? ?: ""
             }
         }
    }
}