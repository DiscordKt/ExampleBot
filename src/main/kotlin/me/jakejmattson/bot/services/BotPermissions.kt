package me.jakejmattson.bot.services

import dev.kord.common.entity.Permission
import dev.kord.common.entity.Permissions
import me.jakejmattson.discordkt.commands.commands

//This enum defines a hierarchy of permissions - commands are marked as requiring a certain permission level
//If a user meets or exceeds that permission level, they can execute the command
//This enum must be registered in the configure block along with a default command permission
object BotPermissions {
    val GUILD_OWNER = Permissions(Permission.ManageGuild)
    val STAFF = Permissions(Permission.ManageMessages)
    val EVERYONE = Permissions(Permission.UseApplicationCommands)
}

//The commands builder can accept a required permission that will be applied to all commands in this category
fun permissionCommands() = commands("Permissions", BotPermissions.GUILD_OWNER) {
    slash("GuildOwner") {
        description = "Command requiring GUILD_OWNER permissions"
        execute {
            respond("Hello guild owner!")
        }
    }

    //Commands within a category can override the permission level of that category
    slash("Staff") {
        description = "Command requiring STAFF permissions"
        requiredPermissions = BotPermissions.STAFF
        execute {
            respond("Hello staff member!")
        }
    }
}