package me.jakejmattson.bot.commands

import dev.kord.common.entity.TextInputStyle
import dev.kord.core.behavior.interaction.response.respond
import dev.kord.x.emoji.Emojis
import me.jakejmattson.discordkt.commands.subcommand
import me.jakejmattson.discordkt.prompts.promptModal
import me.jakejmattson.discordkt.prompts.promptSelect
import me.jakejmattson.discordkt.util.toPartialEmoji

fun promptCommands() = subcommand("Prompt") {
    sub("Modal", "Create a prompt with a modal") {
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

    sub("Select", "Create a prompt with a selection menu") {
        execute {
            val (response, inputs) = promptSelect(interaction!!) {
                this.selectionCount = 1..4

                content {
                    title = "Selection"
                    description = "Pick some good animals"
                }

                option("Cat", description = "Meow", emoji = Emojis.cat.toPartialEmoji())
                option("Dog", description = "Bark", emoji = Emojis.dog.toPartialEmoji())
                option("Fish", description = "Glub", emoji = Emojis.fish.toPartialEmoji())
                option("Bird", description = "Squawk", emoji = Emojis.bird.toPartialEmoji())
            }

            response.respond {
                content = "Chosen: $inputs"
            }
        }
    }
}