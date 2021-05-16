package me.jakejmattson.bot.commands

import me.jakejmattson.discordkt.api.arguments.*
import me.jakejmattson.discordkt.api.dsl.commands

fun slash() = commands("Slash") {
    slash("Slash") {
        description = "A Hello World command."
        execute {
            respond("Hello World!")
        }
    }

    slash("SlashAdd") {
        description = "A simple addition command."
        execute(IntegerArg("First"), IntegerArg("Second")) {
            val (first, second) = args
            respond("$first + $second = ${first + second}")
        }
    }

    slash("SlashAll") {
        description = "Accepts all types"
        execute(IntegerArg, BooleanArg, UserArg, RoleArg, ChannelArg) {
            val (a, b, c, d, e) = args
            respond("`$a, $b, @${c.tag}, @${d.name}, #${e.name}`")
        }
    }
}