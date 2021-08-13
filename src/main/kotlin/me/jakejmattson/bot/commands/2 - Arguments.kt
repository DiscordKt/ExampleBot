package me.jakejmattson.bot.commands

import me.jakejmattson.discordkt.api.arguments.*
import me.jakejmattson.discordkt.api.commands.commands

//Most of the time, you will want your commands to accept input.
//This can be accomplished with the different ArgumentTypes.
fun arguments() = commands("Arguments") {
    command("Echo") {
        description = "Echo the input back."
        execute(EveryArg) {
            //All user input will be contained in 'args' with the correct type information.
            //If the execute block is run, you can guarantee that the data is there.
            val input = args.first
            respond(input)
        }
    }

    command("Junk") {
        description = "Accept a bunch of arguments."
        //You can accept as many arguments as you want.
        execute(IntegerArg, AnyArg, UserArg, ChannelArg, DoubleArg) {
            val (int, word, user, channel, double) = args
            respond("""
                ```
                Integer:  $int
                One Word: $word
                User Tag: ${user.tag}
                Channel:  ${channel.name}
                Decimal:  $double
                ```
            """.trimIndent())
        }
    }

    command("Sum") {
        description = "Sum a list of integers."
        //You can also accept multiple of any type.
        execute(IntegerArg.multiple()) {
            val numbers = args.first
            respond(numbers.sum())
        }
    }
}