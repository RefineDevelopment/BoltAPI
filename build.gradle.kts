plugins {
    id("java-library")
    alias(libs.plugins.lombok)
    id("maven-publish")
}

group = "xyz.refinedev.practice"
version = "1.2.2"

repositories {
    mavenCentral()
    mavenLocal()

    maven("https://maven.refinedev.org/public-repo")
    maven("https://repo.codemc.io/repository/maven-releases/")
    maven("https://repo.codemc.io/repository/maven-public/")
    maven("https://repo.codemc.io/repository/nms/")
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
    compileOnly(libs.paper.api.legacy) {
        exclude("com.google.code.gson", "gson")
    }

    compileOnlyApi(libs.packetevents.spigot) {
        exclude(group = "com.google.code.gson", module = "gson")
        exclude(group = "org.jetbrains", module = "annotations")
        exclude(group = "com.github.retrooper.packetevents", module = "netty-common")
    }

    compileOnly(libs.jetbrains.annotations)
    compileOnlyApi(libs.fastutil)
    compileOnlyApi(libs.xseries)
    compileOnlyApi(libs.knockback.api)
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
             url = uri("https://maven.refinedev.org/public-repo")
             credentials {
                 username = findProperty("mavenUsername") as String? ?: ""
                 password = findProperty("mavenPassword") as String? ?: ""
             }
         }
    }
}
