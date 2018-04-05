package com.mcmoddev.basesciences.init

import com.mcmoddev.basesciences.item.ItemCoalCoke
import com.mcmoddev.basesciences.util.RenderHelper
import net.minecraft.item.Item
import net.minecraft.item.ItemBlock
import net.minecraftforge.fml.relauncher.Side
import net.minecraftforge.fml.relauncher.SideOnly
import net.minecraftforge.registries.IForgeRegistry

object Items {
    val itemCoalCoke = ItemCoalCoke()

    fun init(registry: IForgeRegistry<Item>) {
        registry.register(ItemBlock(Blocks.blockBlastFurnaceBrick).setRegistryName(Blocks.blockBlastFurnaceBrick.registryName))
        registry.register(ItemBlock(Blocks.blockCokeOvenBrick).setRegistryName(Blocks.blockCokeOvenBrick.registryName))

        registry.register(itemCoalCoke)
    }

    @SideOnly(Side.CLIENT)
    fun initModels() {
        RenderHelper.register(itemCoalCoke, itemCoalCoke.registryName!!.resourcePath)
    }
}