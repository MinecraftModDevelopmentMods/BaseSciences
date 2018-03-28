package com.mcmoddev.basesciences.util

import com.mcmoddev.basesciences.BaseSciences
import net.minecraft.client.renderer.block.model.ModelResourceLocation
import net.minecraft.item.Item
import net.minecraft.util.ResourceLocation
import net.minecraftforge.client.model.ModelLoader

object RenderHelper {
    fun register(item: Item, name: String) {
        val resource = ResourceLocation(BaseSciences.MODID, name)
        val location = ModelResourceLocation(resource, "inventory")
        ModelLoader.setCustomModelResourceLocation(item, 0, location)
    }
}