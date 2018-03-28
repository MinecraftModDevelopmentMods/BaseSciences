package com.mcmoddev.basesciences.util

import com.mcmoddev.basesciences.init.Blocks
import com.mcmoddev.basesciences.init.Items
import net.minecraft.block.Block
import net.minecraft.client.resources.I18n
import net.minecraft.item.Item
import net.minecraftforge.client.event.ModelRegistryEvent
import net.minecraftforge.event.RegistryEvent
import net.minecraftforge.event.entity.player.ItemTooltipEvent
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent

class EventHandler {
    @SubscribeEvent
    fun addTooltips(event: ItemTooltipEvent) {
        when (event.itemStack.item) {
            net.minecraft.init.Items.IRON_INGOT -> {
                event.toolTip.add(I18n.format("tooltip.magnetite.name"))
                event.toolTip.add(I18n.format("tooltip.magnetite.formula"))
            }
            net.minecraft.init.Items.COAL -> {
                if (event.itemStack.metadata == 0)
                    event.toolTip.add((I18n.format("tooltip.bituminous_coal.name")))
            }
        }
    }

    @SubscribeEvent
    fun registerBlocks(event: RegistryEvent.Register<Block>) {
        Blocks.init(event.registry)
    }

    @SubscribeEvent
    fun registerItems(event: RegistryEvent.Register<Item>) {
        Items.init(event.registry)
    }

    @SubscribeEvent
    fun registerModels(event: ModelRegistryEvent) {
        Blocks.initModels()
        Items.initModels()
    }
}