group = "me.jakejmattson"
version = "0.22.0"

plugins {
    kotlin("jvm") version "1.5.21"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("me.jakejmattson", "DiscordKt", version.toString())
}

tasks.compileKotlin {
    kotlinOptions.jvmTarget = "1.8"
}