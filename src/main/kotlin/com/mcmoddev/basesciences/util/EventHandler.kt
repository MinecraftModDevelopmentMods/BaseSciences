package com.mcmoddev.basesciences.util

import net.minecraft.client.resources.I18n
import net.minecraft.init.Items
import net.minecraftforge.event.entity.player.ItemTooltipEvent
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent

class EventHandler {
    @SubscribeEvent
    fun addTooltips(event: ItemTooltipEvent) {
        when (event.itemStack.item) {
            Items.IRON_INGOT -> {
                event.toolTip.add(I18n.format("tooltip.iron_ingot.rock_type"))
            }
        }
    }
}