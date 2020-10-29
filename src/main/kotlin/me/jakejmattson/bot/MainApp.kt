package me.jakejmattson.bot

import com.gitlab.kordlib.gateway.Intent
import com.gitlab.kordlib.kordx.emoji.Emojis
import kotlinx.coroutines.flow.toList
import me.jakejmattson.discordkt.api.dsl.bot
import me.jakejmattson.discordkt.api.extensions.*
import java.awt.Color

suspend fun main(args: Array<String>) {
    //Get the bot token from the command line (or your preferred way).
    val token = args.firstOrNull()
    require(token != null) { "Expected the bot token as a command line argument!" }

    //Start the bot and set configuration options.
    bot(token) {
        //Dynamically determine the prefix used for commands.
        prefix {
            "+"
        }

        //Simple configuration options
        configure {
            //Allow a mention to be used in front of commands ('@Bot help`).
            allowMentionPrefix = true

            //Whether or not to generate documentation for registered commands.
            generateCommandDocs = true

            //Whether or not to show registered entity information on startup.
            showStartupLog = true

            //Whether or not to recommend commands when an invalid one is invoked.
            recommendCommands = true

            //An emoji added when a command is invoked (use 'null' to disable this).
            commandReaction = Emojis.eyes

            //A color constant for your bot - typically used in embeds.
            theme = Color(0x00BFFF)
        }

        //An embed sent whenever someone solely mentions your bot ('@Bot').
        mentionEmbed {
            title = "Hello World"
            color = it.discord.configuration.theme

            author {
                with(it.author) {
                    icon = avatar.url
                    name = tag
                    url = profileLink
                }
            }

            thumbnail {
                url = it.discord.api.getSelf().avatar.url
            }

            footer {
                val versions = it.discord.versions
                text = "${versions.library} - ${versions.kord} - ${versions.kotlin}"
            }

            addField("Prefix", it.prefix())
        }

        //Determine if the given command can be run with these conditions.
        permissions {
            true
        }

        //The Discord presence shown on your bot.
        presence {
            playing("DiscordKt Example")
        }

        //Configure the Discord Gateway intents for your bot.
        intents {
            +Intent.GuildMessages
        }

        //This is run once the bot has finished setup and logged in.
        onStart {
            val guilds = api.guilds.toList().joinToString { it.name }
            println("Guilds: $guilds")
        }
    }
}