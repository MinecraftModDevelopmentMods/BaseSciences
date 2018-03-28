package com.mcmoddev.basesciences.init

import net.minecraft.item.Item
import net.minecraft.item.ItemBlock
import net.minecraftforge.fml.relauncher.Side
import net.minecraftforge.fml.relauncher.SideOnly
import net.minecraftforge.registries.IForgeRegistry

object Items {
    fun init(registry: IForgeRegistry<Item>) {
        registry.register(ItemBlock(Blocks.blockBlastFurnaceBrick).setRegistryName(Blocks.blockBlastFurnaceBrick.registryName))
    }

    @SideOnly(Side.CLIENT)
    fun initModels() {

    }
}