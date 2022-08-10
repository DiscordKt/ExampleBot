package me.jakejmattson.bot.commands

import dev.kord.common.kColor
import dev.kord.x.emoji.Emojis
import me.jakejmattson.discordkt.commands.commands
import java.awt.Color

//There are different builders for different types of commands.
//This allows more type-safe access to data, such as channels.
fun contexts() = commands("Context") {
    text("Guild") {
        description = "This command can only be used in a guild"
        execute {
            //This event has a TextChannel with a non-nullable Guild.
            val channel = channel
            respond("Hello ${channel.name} (${guild.name})")
        }
    }

    globalText("Global") {
        description = "This command can be used in a guild or DM"
        execute {
            //This event has a generic MessageChannel and a nullable Guild.
            val guildName = guild?.name ?: "DM to ${author.tag}"
            respond("Hello $guildName")
        }
    }

    dmText("Dm") {
        description = "This command can only be used in a DM"
        execute {
            //This event has a DmChannel and no Guild data.
            val channel = channel
            respond("DM to ${author.tag}")
        }
    }

    text("Menu") {
        description = "Create a menu message"
        execute {
            //You can also create embeds with multiple pages and custom buttons.
            respondMenu {
                page { title = "Page 1" }
                page { title = "Page 2" }

                //Creates a new button row
                buttons {
                    //Exposes the menu for navigation functions.
                    button("Left", Emojis.arrowLeft) { previousPage() }
                    button("Right", Emojis.arrowRight) { nextPage() }

                    //Exposes the current embed page to be edited.
                    editButton("Rainbow", Emojis.rainbow) { color = genRandomColor() }

                    //Opens the specified link in the browser.
                    linkButton("Source", Emojis.pageFacingUp, "https://github.com/DiscordKt/ExampleBot")
                }
            }
        }
    }
}

private fun genRandomColor() = Color(genRandomRGB(), genRandomRGB(), genRandomRGB()).kColor
private fun genRandomRGB() = (0..255).random()