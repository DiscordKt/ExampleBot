package me.jakejmattson.bot.services

import me.jakejmattson.bot.data.Configuration
import me.jakejmattson.discordkt.commands.commands
import me.jakejmattson.discordkt.dsl.Permission
import me.jakejmattson.discordkt.dsl.PermissionSet
import me.jakejmattson.discordkt.dsl.permission

//This enum defines a hierarchy of permissions - commands are marked as requiring a certain permission level
//If a user meets or exceeds that permission level, they can execute the command
//This enum must be registered in the configure block along with a default command permission
object Permissions : PermissionSet {
    val BOT_OWNER = permission("Bot Owner") { users(discord.getInjectionObjects<Configuration>().botOwner) }
    val GUILD_OWNER = guildOwner()
    val EVERYONE = everyone()

    override val hierarchy: List<Permission> = listOf(EVERYONE, GUILD_OWNER, BOT_OWNER)
    override val commandDefault: Permission = EVERYONE
}

//The commands builder can accept a required permission that will be applied to all commands in this category
fun permissionCommands() = commands("Permissions", Permissions.BOT_OWNER) {
    slash("BotOwner") {
        description = "Command requiring BOT_OWNER permissions"
        execute {
            respond("Hello bot owner!")
        }
    }

    //Commands within a category can override the permission level of that category
    slash("GuildOwner") {
        description = "Command requiring GUILD_OWNER permissions"
        requiredPermission = Permissions.GUILD_OWNER
        execute {
            respond("Hello guild owner (or above)")
        }
    }
}