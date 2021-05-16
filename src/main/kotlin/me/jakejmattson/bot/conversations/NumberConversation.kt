package me.jakejmattson.bot.conversations

import dev.kord.common.Color
import dev.kord.x.emoji.Emojis
import me.jakejmattson.discordkt.api.arguments.AnyArg
import me.jakejmattson.discordkt.api.arguments.IntegerArg
import me.jakejmattson.discordkt.api.dsl.PromptedReaction
import me.jakejmattson.discordkt.api.dsl.commands
import me.jakejmattson.discordkt.api.dsl.conversation

fun numberConversation() = conversation("exit") {
    val name = promptMessage(AnyArg, "What is your name?")
    val age = promptMessage(IntegerArg, "How old are you?")

    val response = promptReaction(
        PromptedReaction(Emojis.whiteCheckMark, "Yes it's great!", "Glad you like the lib."),
        PromptedReaction(Emojis.x, "Not a fan.", "You should let me know how to fix the lib.")
    ) {
        title = "Do you like DiscordKt?"
        color = Color(0x00bfff)
    }

    respond("Nice to meet you $name! $age is a great age. $response")
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