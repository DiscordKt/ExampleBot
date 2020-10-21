package me.jakejmattson.bot.conversations

import com.gitlab.kordlib.kordx.emoji.*
import me.jakejmattson.discordkt.api.arguments.*
import me.jakejmattson.discordkt.api.dsl.*

fun numberConversation() = conversation("exit") {
    val userName = promptMessage(AnyArg, "What is your name?")
    val userAge = promptMessage(IntegerArg, "How old are you?")

    val response = promptReaction(mapOf(
        Emojis.whiteCheckMark.toReaction() to "Glad you like the lib.",
        Emojis.x.toReaction() to "You should let me know how to fix the lib."
    )) {
        title = ""
        field {
            name = "Do you like DiscordKt?"
            value = "${Emojis.whiteCheckMark.unicode} Yes it's great!\n" +
                "${Emojis.x.unicode} Not a fan."
        }
    }

    respond("Nice to meet you $userName! $userAge is a great age. $response")
}

fun conversationCommands() = commands("Conversation") {
    command("Public") {
        description = "Start a conversation in a public channel."
        execute {
            val result = numberConversation().startPublicly(discord, author, channel)
            println(result)
        }
    }

    command("Private") {
        description = "Starts a conversation in a private channel."
        execute {
            val result = numberConversation().startPrivately(discord, author)
            println(result)
        }
    }
}