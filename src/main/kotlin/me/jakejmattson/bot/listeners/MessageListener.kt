package me.jakejmattson.bot.listeners

import dev.kord.core.event.message.MessageCreateEvent
import me.jakejmattson.discordkt.api.dsl.listeners

//Create a block of listeners.
fun testListeners() = listeners {

    //You can use `on<Event>` to listen for a Discord event.
    on<MessageCreateEvent> {
        //Ignore the message if it was sent by a bot.
        if (message.author?.isBot == true)
            return@on

        //Every time a message is sent, print the content.
        println(message.content)
    }
}