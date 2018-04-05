package com.mcmoddev.basesciences.tile

import com.mcmoddev.basesciences.multiblock.EnumMultiblockForm
import com.mcmoddev.basesciences.multiblock.MultiblockDetector
import net.minecraft.util.ITickable

class TileEntityBlastFurnaceBrick: TileEntityMultiblock(), ITickable {
    var detector: MultiblockDetector? = null

    override fun update() {
        if (detector == null)
            detector = MultiblockDetector(pos, EnumMultiblockForm.BLAST_FURNACE, world)
        if (detector!!.isMultiblock() && !hasMaster)
            detector!!.inform()
    }
}