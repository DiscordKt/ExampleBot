package me.jakejmattson.bot

import dev.kord.common.annotation.KordPreview
import dev.kord.common.kColor
import dev.kord.gateway.Intents
import dev.kord.x.emoji.Emojis
import kotlinx.coroutines.flow.toList
import me.jakejmattson.discordkt.api.dsl.bot
import me.jakejmattson.discordkt.api.extensions.addField
import me.jakejmattson.discordkt.api.extensions.profileLink
import me.jakejmattson.discordkt.api.locale.Language
import java.awt.Color

@KordPreview
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

            //Allow users to search for a command by typing 'search <command name>'.
            enableSearch = true

            //An emoji added when a command is invoked (use 'null' to disable this).
            commandReaction = Emojis.eyes

            //A color constant for your bot - typically used in embeds.
            theme = Color(0x00BFFF)

            //Configure the Discord Gateway intents for your bot.
            intents = Intents.nonPrivileged.values
        }

        //An embed sent whenever someone solely mentions your bot ('@Bot').
        mentionEmbed {
            title = "Hello World"
            color = it.discord.configuration.theme?.kColor

            author {
                with(it.author) {
                    icon = avatar.url
                    name = tag
                    url = profileLink
                }
            }

            thumbnail {
                url = it.discord.kord.getSelf().avatar.url
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

        //This is run once the bot has finished setup and logged in.
        onStart {
            val guilds = kord.guilds.toList().joinToString { it.name }
            println("Guilds: $guilds")
        }

        //Configure the locale for this bot.
        localeOf(Language.EN) {
            helpName = "Help"
            helpCategory = "Utility"
            commandRecommendation = "Recommendation: {0}"
        }
    }
}