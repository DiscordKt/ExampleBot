package me.jakejmattson.bot.commands

import dev.kord.common.entity.TextInputStyle
import dev.kord.core.behavior.interaction.response.respond
import me.jakejmattson.discordkt.commands.subcommand
import me.jakejmattson.discordkt.prompts.promptModal

fun promptCommands() = subcommand("Prompt") {
    sub("Modal") {
        execute {
            val (responseInteraction, inputs) = promptModal(interaction!!, "Enter Information") {
                input("Name", TextInputStyle.Short)
                input("Age", TextInputStyle.Short)
            }

            val (name, age) = inputs

            responseInteraction.respond {
                content = "Hello $name! $age is a great age"
            }
        }
    }
}