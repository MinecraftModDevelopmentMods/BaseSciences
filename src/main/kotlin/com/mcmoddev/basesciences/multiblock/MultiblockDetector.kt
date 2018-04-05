package com.mcmoddev.basesciences.multiblock

import com.mcmoddev.basesciences.tile.TileEntityMultiblock
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World

class MultiblockDetector(private val pos: BlockPos, private val form: EnumMultiblockForm, private val world: World) {
    // returns true if the specified position is a fully-formed multiblock of the specified form
    fun isMultiblock(): Boolean {
        var counter = 0
        for (x: Int in (pos.x - 1)..(pos.x + 1))
            for (y: Int in pos.y..(pos.y + 3))
                for (z: Int in (pos.z - 1)..(pos.z + 1)) {
                    val currentPos = BlockPos(x, y, z)
                    if (world.getBlockState(currentPos).block == form.block) {
                       counter++
                    }
                }
        return counter == 33 && world.isAirBlock(pos.add(0, 1, 0)) && world.isAirBlock(pos.add(0, 2, 0))
    }

    // informs all blocks in the structure of the structure's construction
    fun inform() {
        for (x: Int in (pos.x - 1)..(pos.x + 1))
            for (y: Int in pos.y..(pos.y + 3))
                for (z: Int in (pos.z - 1)..(pos.z + 1)) {
                    val currentPos = BlockPos(x, y, z)
                    val te = world.getTileEntity(currentPos)
                    if (te != null && te is TileEntityMultiblock) {
                        te.hasMaster = true
                        te.isMaster = currentPos == pos
                        te.masterPos = pos
                    }
                }
    }

    // informs all blocks in the structure of the structure's destruction
    fun reset() {
        for (x: Int in (pos.x - 1)..(pos.x + 1))
            for (y: Int in pos.y..(pos.y + 3))
                for (z: Int in (pos.z - 1)..(pos.z + 1)) {
                    val currentPos = BlockPos(x, y, z)
                    val te = world.getTileEntity(currentPos)
                    if (te != null && te is TileEntityMultiblock) {
                        te.hasMaster = false
                        te.isMaster = false
                        te.masterPos = BlockPos.ORIGIN
                    }
                }
    }
}