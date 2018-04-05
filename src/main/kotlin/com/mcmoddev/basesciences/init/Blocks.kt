package com.mcmoddev.basesciences.init

import com.mcmoddev.basesciences.block.BlockBlastFurnaceBrick
import com.mcmoddev.basesciences.block.BlockCokeOvenBrick
import com.mcmoddev.basesciences.util.RenderHelper
import net.minecraft.block.Block
import net.minecraft.item.Item
import net.minecraftforge.fml.relauncher.Side
import net.minecraftforge.fml.relauncher.SideOnly
import net.minecraftforge.registries.IForgeRegistry

object Blocks {
    val blockBlastFurnaceBrick = BlockBlastFurnaceBrick("blast_furnace_brick")
    val blockCokeOvenBrick = BlockCokeOvenBrick("coke_oven_brick")

    fun init(registry: IForgeRegistry<Block>) {
        registry.register(blockBlastFurnaceBrick)
        registry.register(blockCokeOvenBrick)
    }

    @SideOnly(Side.CLIENT)
    fun initModels() {
        RenderHelper.register(Item.getItemFromBlock(blockBlastFurnaceBrick), blockBlastFurnaceBrick.registryName!!.resourcePath)
        RenderHelper.register(Item.getItemFromBlock(blockCokeOvenBrick), blockCokeOvenBrick.registryName!!.resourcePath)
    }
}