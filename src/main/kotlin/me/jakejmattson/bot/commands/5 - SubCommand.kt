package me.jakejmattson.bot.commands

import me.jakejmattson.discordkt.arguments.IntegerArg
import me.jakejmattson.discordkt.commands.subcommand

fun mathSubcommand() = subcommand("Math") {
    sub("Add") {
        description = "Add two numbers together"
        execute(IntegerArg("First"), IntegerArg("Second")) {
            respond(args.first + args.second)
        }
    }

    sub("Sub") {
        description = "Subtract two numbers"
        execute(IntegerArg("First"), IntegerArg("Second")) {
            respond(args.first - args.second)
        }
    }

    sub("Mult") {
        description = "Multiply two numbers together"
        execute(IntegerArg("First"), IntegerArg("Second")) {
            respond(args.first * args.second)
        }
    }
}