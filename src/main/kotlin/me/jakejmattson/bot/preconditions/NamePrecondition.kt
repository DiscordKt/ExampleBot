package me.jakejmattson.bot.preconditions

import me.jakejmattson.discordkt.api.dsl.*

//Preconditions are a way to make sure that a command is allowed to be run.
fun namePrecondition() = precondition {
    val commandNames = command?.names ?: return@precondition

    //Preconditions can fail with a message that is sent as a response.
    //In order for a command to run, every precondition must pass.
    if ("Precondition" in commandNames)
        fail("Precondition Failed.")
}

fun preconditions() = commands("Preconditions") {
    command("Precondition") {
        description = "Show a command failing a precondition."
        execute {
            //This does not run, since the above precondition fails.
            respond("Precondition passed.")
        }
    }
}