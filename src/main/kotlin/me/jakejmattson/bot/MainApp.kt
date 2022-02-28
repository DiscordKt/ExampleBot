package me.jakejmattson.bot

import dev.kord.common.annotation.KordPreview
import dev.kord.common.entity.Snowflake
import dev.kord.gateway.Intents
import dev.kord.x.emoji.Emojis
import kotlinx.coroutines.flow.toList
import me.jakejmattson.bot.data.Configuration
import me.jakejmattson.bot.services.Permissions
import me.jakejmattson.discordkt.dsl.CommandException
import me.jakejmattson.discordkt.dsl.ListenerException
import me.jakejmattson.discordkt.dsl.bot
import me.jakejmattson.discordkt.extensions.*
import me.jakejmattson.discordkt.locale.Language
import java.awt.Color

@KordPreview
suspend fun main(args: Array<String>) {
    //Get the bot token from the command line (or your preferred way).
    //Start the bot and set configuration options.
    bot(args.firstOrNull()) {
        //See the Data example
        val configuration = data("config/config.json") { Configuration() }

        //Dynamically determine the prefix used for commands.
        prefix {
            configuration.prefix
        }

        //Simple configuration options
        configure {
            //Allow a mention to be used in front of commands ('@Bot help`).
            allowMentionPrefix = true

            //Whether to generate documentation for registered commands.
            generateCommandDocs = true

            //Whether to show registered entity information on startup.
            showStartupLog = true

            //Whether to recommend commands when an invalid one is invoked.
            recommendCommands = true

            //Allow users to search for a command by typing 'search <command name>'.
            enableSearch = true

            //An emoji added when a command is invoked (use 'null' to disable this).
            commandReaction = Emojis.eyes

            //A color constant for your bot - typically used in embeds.
            theme = Color(0x00BFFF)

            //Configure the Discord Gateway intents for your bot.
            intents = Intents.nonPrivileged

            //PermissionSet implementation to control command permissions.
            permissions = Permissions
        }

        //An embed sent whenever someone solely mentions your bot ('@Bot').
        mentionEmbed {
            title = "Hello World"
            color = it.discord.configuration.theme

            author(it.author)
            thumbnail(it.discord.kord.getSelf().pfpUrl)
            addField("Prefix", it.prefix())
            footer(it.discord.versions.toString())
        }

        onException {
            if (exception is IllegalArgumentException)
                return@onException

            when (this) {
                is CommandException -> println("Exception '${exception::class.simpleName}' in command ${event.command?.name}")
                is ListenerException -> println("Exception '${exception::class.simpleName}' in listener ${event::class.simpleName}")
            }
        }

        //The Discord presence shown on your bot.
        presence {
            playing("DiscordKt Example")
        }

        //This is run once the bot has finished setup and logged in.
        onStart {
            val guilds = kord.guilds.toList()
            println("Guilds: ${guilds.joinToString { it.name }}")
        }

        //Configure the locale for this bot.
        localeOf(Language.EN) {
            helpName = "Help"
            helpCategory = "Utility"
            commandRecommendation = "Recommendation: {0}"
        }
    }
}