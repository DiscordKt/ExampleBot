package me.jakejmattson.bot.commands

import me.jakejmattson.discordkt.arguments.IntegerArg
import me.jakejmattson.discordkt.arguments.UserArg
import me.jakejmattson.discordkt.commands.commands

//Arguments can also be given optionally, and fall back to a default value if not provided by the user.
fun optionals() = commands("Optional") {
    command("Number") {
        description = "Enter any number to see the next one"
        //This command accepts either 0 or 1 arguments, and defaults to '0' if none are provided.
        execute(IntegerArg.optional(0)) {
            respond("Next: ${args.first + 1}")
        }
    }

    command("User") {
        description = "Provides the tag of a given user"
        //This optional block exposes the command event for access to discord entities.
        execute(UserArg.optional { it.author }) {
            respond(args.first.tag)
        }
    }

    command("OptionalAdd") {
        description = "Add one or two numbers together"
        //Optional and non-optional arguments can be mixed any way you like.
        execute(IntegerArg, IntegerArg.optional(0)) {
            val (first, second) = args
            respond("$first + $second = ${first + second}")
        }
    }
}