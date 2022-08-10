package me.jakejmattson.bot.commands

import me.jakejmattson.discordkt.commands.commands
import me.jakejmattson.discordkt.extensions.descriptor
import me.jakejmattson.discordkt.extensions.jumpLink

fun context() = commands("Context") {
    /**
     * Creates a right-click message app.
     */
    message(displayText = "Get Message Link", slashName = "Link", description = "Get a message's jump link") {
        respond(arg.jumpLink() ?: "<Unknown Link>")
    }

    /**
     * Creates a right-click user app.
     */
    user(displayText = "Show User Info", slashName = "Info", description = "Get information for the target user") {
        respond(arg.descriptor() + " " + args.first.descriptor())
    }
}