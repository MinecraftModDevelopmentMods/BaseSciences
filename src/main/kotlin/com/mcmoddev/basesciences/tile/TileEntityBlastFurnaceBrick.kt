package com.mcmoddev.basesciences.tile

import com.mcmoddev.basesciences.multiblock.EnumMultiblockForm
import com.mcmoddev.basesciences.multiblock.MultiblockDetector
import net.minecraft.nbt.NBTTagCompound
import net.minecraft.tileentity.TileEntity
import net.minecraft.util.ITickable
import net.minecraft.util.math.BlockPos

class TileEntityBlastFurnaceBrick: TileEntity(), ITickable {
    var hasMaster = false
    var isMaster = false
    var masterPos: BlockPos = BlockPos.ORIGIN

    override fun update() {
        val detector = MultiblockDetector(pos, EnumMultiblockForm.BLAST_FURNACE, world)
        if (detector.isMultiblock() && !hasMaster)
            detector.inform()
        else if (!detector.isMultiblock() && hasMaster)
            detector.reset()
    }

    override fun writeToNBT(compound: NBTTagCompound?): NBTTagCompound {
        super.writeToNBT(compound!!)
        compound.setBoolean("hasMaster", hasMaster)
        compound.setBoolean("isMaster", isMaster)
        compound.setInteger("masterX", masterPos.x)
        compound.setInteger("masterY", masterPos.y)
        compound.setInteger("masterZ", masterPos.z)
        return compound
    }

    override fun readFromNBT(compound: NBTTagCompound?) {
        super.readFromNBT(compound!!)
        hasMaster = compound.getBoolean("hasMaster")
        isMaster = compound.getBoolean("isMaster")
        masterPos = BlockPos(compound.getInteger("masterX"), compound.getInteger("masterY"), compound.getInteger("masterZ"))
    }
}