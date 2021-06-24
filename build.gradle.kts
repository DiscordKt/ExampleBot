group = "me.jakejmattson"
version = "0.22.0-SNAPSHOT"

plugins {
    kotlin("jvm") version "1.5.10"
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