package com.mcmoddev.basesciences.block

import com.mcmoddev.basesciences.BaseSciences
import com.mcmoddev.basesciences.tile.TileEntityBlastFurnaceBrick
import com.mcmoddev.basesciences.tile.TileEntityCokeOvenBrick
import net.minecraft.block.Block
import net.minecraft.block.material.Material
import net.minecraft.block.state.IBlockState
import net.minecraft.tileentity.TileEntity
import net.minecraft.util.math.BlockPos
import net.minecraft.world.IBlockAccess
import net.minecraft.world.World

class BlockCokeOvenBrick(name: String): Block(Material.ROCK) {
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
        return TileEntityCokeOvenBrick()
    }

    override fun hasTileEntity(state: IBlockState?): Boolean {
        return true
    }
}