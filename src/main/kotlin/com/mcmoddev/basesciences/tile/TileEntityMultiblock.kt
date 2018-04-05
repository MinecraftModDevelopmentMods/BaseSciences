package com.mcmoddev.basesciences.tile

import net.minecraft.nbt.NBTTagCompound
import net.minecraft.tileentity.TileEntity
import net.minecraft.util.math.BlockPos

open class TileEntityMultiblock: TileEntity() {
    var hasMaster = false
    var isMaster = false
    var masterPos: BlockPos = BlockPos.ORIGIN

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