package com.mcmoddev.basesciences.init

import com.mcmoddev.basesciences.tile.TileEntityBlastFurnaceBrick
import com.mcmoddev.basesciences.tile.TileEntityCokeOvenBrick
import net.minecraftforge.fml.common.registry.GameRegistry

object TileEntities {
    fun init() {
        GameRegistry.registerTileEntity(TileEntityBlastFurnaceBrick::class.java, "blast_furnace_brick")
        GameRegistry.registerTileEntity(TileEntityCokeOvenBrick::class.java, "coke_oven_brick")
    }
}