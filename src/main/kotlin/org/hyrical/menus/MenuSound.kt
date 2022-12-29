package org.hyrical.menus

import org.bukkit.Sound

enum class MenuSound(val sound: Sound, val volume: Float, val pitch: Float) {
    FAIL(Sound.BLOCK_GRASS_HIT, 20.0F, 0.1F),
    SUCCESS(Sound.BLOCK_NOTE_BLOCK_HARP, 20.0F, 15.0F),
    CLICK(Sound.UI_BUTTON_CLICK, 20.0F, 1.0F),
}