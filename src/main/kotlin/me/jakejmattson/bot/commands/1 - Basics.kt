package me.jakejmattson.bot.commands

import com.gitlab.kordlib.kordx.emoji.Emojis
import me.jakejmattson.discordkt.api.annotations.Register
import me.jakejmattson.discordkt.api.dsl.commands
import java.awt.Color

//To register commands, use the 'Register' annotation along with the 'commands' builder function.
//This create some new commands in a category called 'Basic'.
@Register
fun basics() = commands("Basics") {
    //The block creates a new command called 'Hello'.
    command("Hello") {
        description = "A 'Hello World' command." //Descriptions are used for docs and help menus.
        execute { //The 'execute' block is where all the command logic
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

private fun genRandomColor() = Color(genRandomRGB(), genRandomRGB(), genRandomRGB())
private fun genRandomRGB() = (0..255).random()