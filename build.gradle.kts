group = "me.jakejmattson"
version = "0.23.0-SNAPSHOT"

plugins {
    kotlin("jvm") version "1.7.10"
    kotlin("plugin.serialization") version "1.7.10"
}

repositories {
    mavenLocal()
    mavenCentral()
    maven("https://oss.sonatype.org/content/repositories/snapshots")
}

dependencies {
    implementation("me.jakejmattson", "DiscordKt", version.toString())
}

tasks.compileKotlin {
    kotlinOptions.jvmTarget = "1.8"
}