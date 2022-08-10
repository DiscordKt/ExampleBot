import java.util.Properties

group = "me.jakejmattson"
version = "0.23.3"
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

tasks.compileKotlin {
    kotlinOptions.jvmTarget = "1.8"

    Properties().apply {
        setProperty("name", project.name)
        setProperty("description", project.description)
        setProperty("version", version.toString())
        setProperty("url", "https://github.com/DiscordKt/ExampleBot")

        store(file("src/main/resources/bot.properties").outputStream(), null)
    }
}