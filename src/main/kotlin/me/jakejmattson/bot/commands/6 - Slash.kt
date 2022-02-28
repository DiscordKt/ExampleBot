package me.jakejmattson.bot.commands

import dev.kord.core.entity.channel.TextChannel
import me.jakejmattson.discordkt.arguments.*
import me.jakejmattson.discordkt.commands.commands
import me.jakejmattson.discordkt.extensions.descriptor
import me.jakejmattson.discordkt.extensions.jumpLink

fun slash() = commands("Slash") {
    slash("Slash") {
        description = "A Hello World command"
        execute {
            respond("Hello World!")
        }
    }

    slash("SlashAdd") {
        description = "A simple addition command"
        execute(IntegerArg("First"), IntegerArg("Second")) {
            val (first, second) = args
            respond("$first + $second = ${first + second}")
        }
    }

    slash("SlashChoice") {
        description = "Provides a choice UI"
        execute(ChoiceArg("Names", "Names of cool people", "Jake", "David", "Elliott", "Moe")) {
            respond("You chose ${args.first}")
        }
    }

    slash("SlashJunk") {
        description = "Accepts a variety of slash types"
        execute(IntegerArg, BooleanArg, UserArg, RoleArg, ChannelArg) {
            val (a, b, c, d, e) = args
            respond("`$a, $b, @${c.tag}, @${d.name}, #${e.name}`")
        }
    }

    //Message Command
    slash("Link", appName = "Get Message Link") {
        description = "Get a message's jump link"
        execute(MessageArg) {
            respond(args.first.jumpLink() ?: "<Unknown Link>")
        }
    }

    //User Command
    slash("Info", appName = "Show User Info") {
        description = "Get information for the target user"
        execute(UserArg.optional { it.author }) {
            respond(args.first.descriptor())
        }
    }
}