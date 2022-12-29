package org.hyrical.menus

import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.inventory.ItemStack

class Button(
    var item: (Player) -> ItemStack,
    var action: (Player, InventoryClickEvent) -> Unit = { _, _ -> } ,
    var updatingInterval: Long = -1L
) {

    private var taskStarted: Boolean = false

    companion object {
        @JvmStatic
        fun of(itemstack: ItemStack): Button {
            return Button(item = { itemstack })
        }

        @JvmStatic
        fun placeholder(material: Material): Button {
            return Button(
                { ItemBuilder {
                    type(material)
                    name("&r")
                }
                }
            )
        }

    }

    fun runUpdatingTask(menu: Menu, slot: Int, player: Player) {
        if (updatingInterval <= 0) return
        if (taskStarted) return

        taskStarted = true

        val task = Bukkit.getScheduler().runTaskTimer(MenuHandler.plugin, Runnable {
            // TODO: Cancel task if player is not viewing the menu
            menu.updateItem(this, slot, player)
        }, updatingInterval, updatingInterval)
    }

    fun onClick(lambda: (Player, InventoryClickEvent) -> Unit): Button {
        action = lambda

        return this
    }
}