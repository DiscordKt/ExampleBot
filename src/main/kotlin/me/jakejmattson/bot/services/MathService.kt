package me.jakejmattson.bot.services

import me.jakejmattson.discordkt.api.annotations.Service
import me.jakejmattson.discordkt.api.arguments.IntegerArg
import me.jakejmattson.discordkt.api.commands.commands

//A service defines logic that can be used somewhere else.
//This prevents duplicating code and cluttering commands.
@Service
class MathService {
    fun add(a: Int, b: Int) = a + b
    fun sub(a: Int, b: Int) = a - b
    fun mult(a: Int, b: Int) = a * b
}

//To use Services somewhere, just request them as parameters.
fun mathCommands(mathService: MathService) = commands("Math") {
    command("Add") {
        description = "Add two numbers together."
        execute(IntegerArg, IntegerArg) {
            val (first, second) = args
            val result = mathService.add(first, second)
            respond(result)
        }
    }

    command("Sub") {
        description = "Subtract two numbers."
        execute(IntegerArg, IntegerArg) {
            val (first, second) = args
            val result = mathService.sub(first, second)
            respond(result)
        }
    }

    command("Mult") {
        description = "Multiply two numbers together."
        execute(IntegerArg, IntegerArg) {
            val (first, second) = args
            val result = mathService.mult(first, second)
            respond(result)
        }
    }
}