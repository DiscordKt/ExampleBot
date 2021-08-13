package me.jakejmattson.bot.commands

import me.jakejmattson.discordkt.api.commands.commands

//There are different builders for different types of commands.
//This allows more type-safe access to data, such as channels.
fun contexts() = commands("Context") {
    command("Global") {
        description = "This command can be used in a guild or DM."
        execute {
            //This event has a generic MessageChannel and a nullable Guild.
            val guildName = guild?.name ?: "DM to ${author.tag}"
            respond("Hello $guildName")
        }
    }

    guildCommand("Guild") {
        description = "This command can only be used in a guild."
        execute {
            //This event has a TextChannel with a non-nullable Guild.
            val channel = channel
            respond("Hello ${channel.name} (${guild.name})")
        }
    }

    dmCommand("Dm") {
        description = "This command can only be used in a DM."
        execute {
            //This event has a DmChannel and no Guild data.
            val channel = channel
            respond("DM to ${author.tag}")
        }
    }
}