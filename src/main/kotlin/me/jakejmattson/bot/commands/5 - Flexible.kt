package me.jakejmattson.bot.commands

import me.jakejmattson.discordkt.api.arguments.*
import me.jakejmattson.discordkt.api.dsl.commands

//Flexible commands will allow expected arguments in any order.
fun flexible() = commands("Flexible") {
    //This is a standard command for reference.
    command("NonFlex") {
        execute(IntegerArg, AnyArg) {
            val (num, any) = args

            respond("""
                ```
                Num: $num
                Any: $any
                ```
            """.trimIndent())
        }
    }

    //The same command as above, with flexibility enabled.
    command("Flex") {
        description = "Flexible command that accepts 2 arguments"
        isFlexible = true
        execute(IntegerArg, AnyArg) {
            val (num, any) = args

            respond("""
                ```
                Num: $num
                Any: $any
                ```
            """.trimIndent())
        }
    }

    //This shows the potential of flexible commands - it accepts all of these arguments in any order.
    command("BigFlex") {
        description = "Flexible command that accepts several arguments."
        isFlexible = true
        execute(CharArg, UserArg, RoleArg, ChannelArg) {
            val (char, user, role, channel) = args

            respond("""
                ```
                Char: '$char'
                User: @${user.tag}
                Role: @${role.name}
                Text: #${channel.name}
                ```
            """.trimIndent())
        }
    }
}