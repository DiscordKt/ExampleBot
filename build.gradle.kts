group = "me.jakejmattson"
version = "0.23.4"
description = "An example bot for DiscordKt"

plugins {
    kotlin("jvm") version "1.7.10"
    kotlin("plugin.serialization") version "1.7.10"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("me.jakejmattson", "DiscordKt", version.toString())
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
        dependsOn("writeProperties")
    }

    register<WriteProperties>("writeProperties") {
        property("name", project.name)
        property("description", project.description.toString())
        property("version", version.toString())
        property("url", "https://github.com/DiscordKt/ExampleBot")
        setOutputFile("src/main/resources/bot.properties")
    }
}