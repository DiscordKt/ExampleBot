package me.jakejmattson.bot.preconditions

import me.jakejmattson.discordkt.api.dsl.*

//Preconditions are a way to make sure that a command is allowed to be run.
class FreePrecondition : Precondition() {
    override suspend fun evaluate(event: CommandEvent<*>): PreconditionResult {
        val commandNames = event.command?.names ?: return Pass

        //Preconditions can fail with a message that is sent as a reply to the command invocation.
        if ("Precondition" in commandNames)
            return Fail("Precondition Failed.")

        //In order for a command to run, every precondition must pass.
        return Pass
    }
}

fun preconditions() = commands("Preconditions") {
    command("Precondition") {
        description = "Show a command failing a precondition."
        execute {
            //This should not run, since the above precondition fails.
            respond("Precondition passed.")
        }
    }
}