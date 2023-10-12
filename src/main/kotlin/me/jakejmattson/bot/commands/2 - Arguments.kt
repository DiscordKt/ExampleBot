package me.jakejmattson.bot.commands

import me.jakejmattson.discordkt.arguments.*
import me.jakejmattson.discordkt.commands.commands

//Most of the time, you will want your commands to accept input.
//This can be accomplished with the different ArgumentTypes.
fun arguments() = commands("Arguments") {
    slash("Echo", "Echo the input back") {
        execute(EveryArg) {
            //All user input will be contained in 'args' with the correct type information.
            //If the execute block is run, you can guarantee that the data is there.
            val input = args.first
            respond(input)
        }
    }

    slash("Plus", "A simple addition command") {
        execute(IntegerArg("First"), IntegerArg("Second")) {
            val (first, second) = args
            respond("$first + $second = ${first + second}")
        }
    }

    slash("Choice", "Provides a choice UI") {
        execute(ChoiceArg("Names", "Names of cool people", "Jake", "David", "Elliott", "Moe")) {
            respond("You chose ${args.first}")
        }
    }

    slash("Junk", "Accept a bunch of arguments") {
        //You can accept as many arguments as you want.
        execute(IntegerArg, AnyArg, UserArg, ChannelArg, DoubleArg) {
            val (int, word, user, channel, double) = args
            respond(
                """
                ```
                Integer:  $int
                One Word: $word
                User Tag: ${user.tag}
                Channel:  ${channel.name}
                Decimal:  $double
                ```
            """.trimIndent()
            )
        }
    }
}