package me.jakejmattson.bot.conversations

import com.gitlab.kordlib.kordx.emoji.*
import me.jakejmattson.discordkt.api.annotations.Register
import me.jakejmattson.discordkt.api.arguments.*
import me.jakejmattson.discordkt.api.dsl.*
import me.jakejmattson.discordkt.api.services.ConversationService

class NumberConversation : Conversation() {
    @Start
    fun start() = conversation {
        val userName = promptMessage(AnyArg, "What is your name?")
        val userAge = promptMessage(IntegerArg, "How old are you?")

        val response = promptReaction(mapOf(
            Emojis.whiteCheckMark.toReaction() to "Glad you like the lib.",
            Emojis.x.toReaction() to "You should let me know how to fix the lib."
        )) {
            title = ""
            field {
                name = "Do you like DiscordKt?"
                value = "${Emojis.whiteCheckMark.unicode} Yes it's great!\n${Emojis.x.unicode} Not a fan."
            }
        }

        respond("Nice to meet you $userName! $userAge is a great age. $response")
    }
}

@Register
fun conversationCommands(conversationService: ConversationService) = commands("Conversation") {
    command("Public") {
        description = "This starts the above conversation in a public channel."
        execute {
            conversationService.startPublicConversation<NumberConversation>(author, channel.asChannel())
        }
    }

    command("Private") {
        description = "This starts the above conversation in a private channel."
        execute {
            conversationService.startPrivateConversation<NumberConversation>(author)
        }
    }
}