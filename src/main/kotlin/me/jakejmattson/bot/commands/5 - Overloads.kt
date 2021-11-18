package me.jakejmattson.bot.commands

import me.jakejmattson.discordkt.arguments.AnyArg
import me.jakejmattson.discordkt.arguments.IntegerArg
import me.jakejmattson.discordkt.commands.commands

fun overload() = commands("Overload") {
    //Commands can be overloaded - have multiple execute blocks.
    //This allows you to process different args differently.
    command("Overload") {
        description = "This command has multiple execute blocks."
        execute {
            respond("I took no args")
        }

        execute(IntegerArg) {
            respond("I took an int: ${args.first}")
        }

        execute(AnyArg) {
            respond("I took a word: ${args.first}")
        }
    }
}