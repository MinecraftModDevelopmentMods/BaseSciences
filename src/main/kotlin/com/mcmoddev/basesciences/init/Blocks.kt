package com.mcmoddev.basesciences.init

import com.mcmoddev.basesciences.block.BlockStructural
import com.mcmoddev.basesciences.util.RenderHelper
import net.minecraft.block.Block
import net.minecraft.item.Item
import net.minecraftforge.fml.relauncher.Side
import net.minecraftforge.fml.relauncher.SideOnly
import net.minecraftforge.registries.IForgeRegistry

object Blocks {
    val blockBlastFurnaceBrick = BlockStructural("blast_furnace_brick")

    fun init(registry: IForgeRegistry<Block>) {
        registry.register(blockBlastFurnaceBrick)
    }

    @SideOnly(Side.CLIENT)
    fun initModels() {
        RenderHelper.register(Item.getItemFromBlock(blockBlastFurnaceBrick), blockBlastFurnaceBrick.registryName!!.resourcePath)
    }
}