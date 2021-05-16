package me.jakejmattson.bot.commands

import dev.kord.common.kColor
import dev.kord.x.emoji.Emojis
import me.jakejmattson.discordkt.api.dsl.commands
import java.awt.Color

//To register commands, use the 'commands' builder function.
//This creates some new commands in a category called 'Basic'.
fun basics() = commands("Basics") {
    //This block creates a new command called 'Hello'.
    command("Hello") {
        description = "A 'Hello World' command." //Descriptions are used for docs and help menus.
        execute { //The 'execute' block is what code will be run when your command is invoked.
            //The respond command can be used to send a message back to the user who ran the command.
            respond("Hello World!")
        }
    }

    command("Embed") {
        description = "Create an embed message."
        execute {
            //You can also respond with a Discord embed.
            respond {
                title = "Hello World"
            }
        }
    }

    command("Menu") {
        description = "Create a menu message."
        execute {
            //You can also create embeds with multiple pages and custom reactions.
            respondMenu {
                page {
                    title = "Page 1"
                }

                page {
                    title = "Page 2"
                }

                reaction(Emojis.rainbow) {
                    color = genRandomColor()
                }
            }
        }
    }
}

private fun genRandomColor() = Color(genRandomRGB(), genRandomRGB(), genRandomRGB()).kColor
private fun genRandomRGB() = (0..255).random()