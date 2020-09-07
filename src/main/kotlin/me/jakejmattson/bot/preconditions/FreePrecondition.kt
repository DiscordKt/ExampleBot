package me.jakejmattson.bot.preconditions

import me.jakejmattson.discordkt.api.dsl.*

//Preconditions are a way to make sure that a command is allowed to be run.
class FreePrecondition : Precondition() {
    override suspend fun evaluate(event: CommandEvent<*>): PreconditionResult {
        //Preconditions can fail with a message that is sent as a reply to the command invocation.
        //Try uncommenting this line to see how a failure looks to a user.
        //return Fail("Precondition Failed.")

        //In order for a command to run, every precondition must pass.
        return Pass
    }
}