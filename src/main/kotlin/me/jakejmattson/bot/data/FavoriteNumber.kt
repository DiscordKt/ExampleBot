package me.jakejmattson.bot.data

import me.jakejmattson.discordkt.api.dsl.Data

data class FavoriteNumber(val number: Int = 1) : Data("config/config.json", killIfGenerated = false)