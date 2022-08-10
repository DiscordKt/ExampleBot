package me.jakejmattson.bot.commands

import me.jakejmattson.discordkt.commands.commands

//To register commands, use the 'commands' builder function.
//This creates some new commands in a category called 'Basic'.
fun basics() = commands("Basics") {
    //This block creates a new command called 'Hello'.
    slash("Hello") {
        description = "A 'Hello World' command" //Descriptions are used for docs and help menus.
        execute { //The 'execute' block is what code will be run when your command is invoked.
            //The respond command can be used to send a message back to the user who ran the command.
            respond("Hello World!")
        }
    }

    slash("Embed") {
        description = "Create an embed message"
        execute {
            //You can also respond with a Discord embed.
            respond {
                title = "This is an embed"
            }
        }
    }
}