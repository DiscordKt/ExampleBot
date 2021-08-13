package me.jakejmattson.bot.commands

import dev.kord.common.kColor
import dev.kord.x.emoji.Emojis
import me.jakejmattson.discordkt.api.commands.commands
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
            //You can also create embeds with multiple pages and custom buttons.
            respondMenu {
                page { title = "Page 1" }
                page { title = "Page 2" }

                //Creates a new button row
                buttons {
                    //Exposes the menu for navigation functions.
                    button("Left", Emojis.arrowLeft) {
                        previousPage()
                    }

                    button("Right", Emojis.arrowRight) {
                        nextPage()
                    }

                    //Exposes the current embed page to be edited.
                    editButton("Rainbow", Emojis.rainbow) {
                        color = genRandomColor()
                    }

                    //Opens the specified link in the browser.
                    linkButton("Source", Emojis.pageFacingUp, "https://github.com/DiscordKt/ExampleBot")
                }
            }
        }
    }
}

private fun genRandomColor() = Color(genRandomRGB(), genRandomRGB(), genRandomRGB()).kColor
private fun genRandomRGB() = (0..255).random()