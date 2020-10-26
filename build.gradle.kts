group = "me.jakejmattson"
version = "0.21.1"

plugins {
    kotlin("jvm") version "1.4.10"
}

repositories {
    mavenCentral()
    jcenter()
}

dependencies {
    implementation("me.jakejmattson:DiscordKt:0.21.1")
}

tasks.compileKotlin {
    kotlinOptions.jvmTarget = "1.8"
}