group = "me.jakejmattson"
version = "0.24.0"
description = "An example bot for DiscordKt"

plugins {
    kotlin("jvm") version "1.9.10"
    kotlin("plugin.serialization") version "1.9.10"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("me.jakejmattson", "DiscordKt", version.toString())
}

tasks {
    kotlin {
        jvmToolchain(11)
    }

    compileKotlin {
        doLast("writeProperties") {}
    }

    register<WriteProperties>("writeProperties") {
        property("name", project.name)
        property("description", project.description.toString())
        property("version", version.toString())
        property("url", "https://github.com/DiscordKt/ExampleBot")
        setOutputFile("src/main/resources/bot.properties")
    }
}