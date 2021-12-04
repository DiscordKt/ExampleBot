package me.jakejmattson.bot.services

import me.jakejmattson.discordkt.commands.commands
import me.jakejmattson.discordkt.dsl.PermissionContext
import me.jakejmattson.discordkt.dsl.PermissionSet
import me.jakejmattson.discordkt.extensions.toSnowflake

//This enum defines a hierarchy of permissions - commands are marked as requiring a certain permission level
//If a user meets or exceeds that permission level, they can execute the command
//This enum must be registered in the configure block along with a default command permission
enum class Permissions : PermissionSet {
    BOT_OWNER {
        override suspend fun hasPermission(context: PermissionContext) = context.user.id == 298168112824582154.toSnowflake()
    },
    GUILD_OWNER {
        override suspend fun hasPermission(context: PermissionContext) = context.getMember()?.isOwner() ?: false
    },
    EVERYONE {
        override suspend fun hasPermission(context: PermissionContext) = true
    }
}

//The commands builder can accept a required permission that will be applied to all commands in this category
fun permissionCommands() = commands("Permissions", Permissions.BOT_OWNER) {
    command("BotOwner") {
        description = "Command requiring BOT_OWNER permissions"
        execute {
            respond("Hello bot owner!")
        }
    }

    //Commands within a category can override the permission level of that category
    command("GuildOwner") {
        description = "Command requiring GUILD_OWNER permissions"
        requiredPermission = Permissions.GUILD_OWNER
        execute {
            respond("Hello guild owner (or above)")
        }
    }
}