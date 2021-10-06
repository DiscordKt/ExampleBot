package me.jakejmattson.bot.data

import dev.kord.common.entity.Snowflake
import kotlinx.serialization.Serializable
import me.jakejmattson.discordkt.api.arguments.IntegerArg
import me.jakejmattson.discordkt.api.commands.commands
import me.jakejmattson.discordkt.api.dsl.Data

//A Data class is a serializable set of data stored in a file as JSON.
//These classes can be loaded in the main bot function and saved once modified.
//This is frequently used for configurations, but can be used for any persistent data.
@Serializable
data class Configuration(val botOwner: Snowflake = Snowflake(254786431656919051),
                         val prefix: String = "ex!",
                         var favoriteNumber: Int = 3) : Data()

fun dataCommands(configuration: Configuration) = commands("Data") {
    command("Data") {
        description = "Display the Data from the config file."
        execute {
            val owner = discord.kord.getUser(configuration.botOwner)!!

            respond {
                title = owner.username
                description = "My favorite number is ${configuration.favoriteNumber}"

                thumbnail {
                    url = owner.avatar.url
                }
            }
        }
    }

    command("SetData") {
        description = "Modify the Data from the config file."
        execute(IntegerArg) {
            val input = args.first
            configuration.favoriteNumber = input
            configuration.save()
        }
    }
}