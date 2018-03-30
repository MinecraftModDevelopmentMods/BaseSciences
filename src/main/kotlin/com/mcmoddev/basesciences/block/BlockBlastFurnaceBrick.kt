package com.mcmoddev.basesciences.block

import com.mcmoddev.basesciences.BaseSciences
import com.mcmoddev.basesciences.tile.TileEntityBlastFurnaceBrick
import net.minecraft.block.Block
import net.minecraft.block.material.Material
import net.minecraft.block.state.IBlockState
import net.minecraft.tileentity.TileEntity
import net.minecraft.util.math.BlockPos
import net.minecraft.world.IBlockAccess
import net.minecraft.world.World

class BlockBlastFurnaceBrick (name: String): Block(Material.IRON) {
    init {
        setCreativeTab(BaseSciences.tabBaseSciencesCreativeTab)
        setHardness(3.0f)
        unlocalizedName = name
        setRegistryName(BaseSciences.MODID, name)
    }

    override fun onNeighborChange(world: IBlockAccess?, pos: BlockPos?, neighbor: BlockPos?) {
        val te = world?.getTileEntity(pos!!)
        if (te != null && te is TileEntityBlastFurnaceBrick) {
            val master = world.getTileEntity(te.masterPos)
            if (master != null && master is TileEntityBlastFurnaceBrick && !master.detector?.isMultiblock()!! && master.hasMaster)
                master.detector?.reset()
        }
        super.onNeighborChange(world!!, pos!!, neighbor!!)
    }

    override fun createTileEntity(world: World?, state: IBlockState?): TileEntity? {
        return TileEntityBlastFurnaceBrick()
    }

    override fun hasTileEntity(state: IBlockState?): Boolean {
        return true
    }
}