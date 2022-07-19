package me.jakejmattson.bot.commands

import dev.kord.common.entity.TextInputStyle
import dev.kord.core.behavior.interaction.respondEphemeral
import dev.kord.core.entity.channel.TextChannel
import me.jakejmattson.discordkt.arguments.*
import me.jakejmattson.discordkt.commands.commands
import me.jakejmattson.discordkt.dsl.promptModal
import me.jakejmattson.discordkt.extensions.descriptor
import me.jakejmattson.discordkt.extensions.jumpLink

fun slash() = commands("Slash") {
    slash("SlashEcho") {
        description = "A Hello World command"
        execute(EveryArg.optional("Hello World")) {
            respond(args.first)
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

    slash("SlashAll") {
        description = "Accepts a variety of slash types"
        execute(
            IntegerArg.optional(5),
            BooleanArg.optional(true),
            UserArg.optional { it.author },
            RoleArg.optional { it.guild!!.getEveryoneRole() },
            ChannelArg<TextChannel>().optional { it.channel.asChannel() as TextChannel }
        ) {
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