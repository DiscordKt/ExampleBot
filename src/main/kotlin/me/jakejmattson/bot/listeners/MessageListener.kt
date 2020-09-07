package me.jakejmattson.bot.listeners

import com.gitlab.kordlib.core.event.message.MessageCreateEvent
import com.gitlab.kordlib.core.event.message.MessageDeleteEvent
import com.gitlab.kordlib.kordx.emoji.Emojis
import com.gitlab.kordlib.kordx.emoji.toReaction
import me.jakejmattson.discordkt.api.annotations.Register
import me.jakejmattson.discordkt.api.dsl.listeners

//Create a block of listeners.
@Register
fun testListeners() = listeners {
    //You can use `on<Event>` to listen for a Discord event.

    on<MessageCreateEvent> {
        //Ignore the message if it was sent by a bot.
        if (message.author?.isBot == true)
            return@on

        //Every time a message is created, react with an emoji.
        message.addReaction(Emojis.whiteCheckMark.toReaction())
    }

    on<MessageDeleteEvent> {
        //Every time a message is deleted, log the content.
        println(message?.content)
    }
}