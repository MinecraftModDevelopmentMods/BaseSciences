package com.mcmoddev.basesciences.init

import com.mcmoddev.basesciences.tile.TileEntityBlastFurnaceBrick
import net.minecraftforge.fml.common.registry.GameRegistry

object TileEntities {
    fun init() {
        GameRegistry.registerTileEntity(TileEntityBlastFurnaceBrick::class.java, "blast_furnace_brick")
    }
}