package me.jakejmattson.bot.commands

import me.jakejmattson.discordkt.arguments.*
import me.jakejmattson.discordkt.commands.commands
import me.jakejmattson.discordkt.extensions.jumpLink
import me.jakejmattson.discordkt.extensions.pfpUrl

fun slash() = commands("Slash") {
    slash("Slash") {
        description = "A Hello World command."
        execute {
            respond("Hello World!", ephemeral = true)
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

    slash("Link", "Get Message Link") {
        description = "Get a message's jump link"
        execute(MessageArg) {
            respond(args.first.jumpLink() ?: "<Unknown Link>")
        }
    }

    slash("Info", "Show User Info") {
        description = "Get information for the target user"
        execute(UserArg.optional { it.author }) {
            val user = args.first

            respond {
                title = user.username
                description = user.id.toString()

                thumbnail {
                    url = user.pfpUrl
                }
            }
        }
    }
}