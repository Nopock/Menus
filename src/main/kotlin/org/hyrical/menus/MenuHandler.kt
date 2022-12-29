package org.hyrical.menus

import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin
import java.util.*

object MenuHandler {
    val openedMenusMap = mutableMapOf<UUID, Menu>()

    lateinit var plugin: JavaPlugin

    @JvmStatic
    fun setup(plugin: JavaPlugin) {
        Bukkit.getPluginManager().registerEvents(MenuListeners(), plugin)
    }
}