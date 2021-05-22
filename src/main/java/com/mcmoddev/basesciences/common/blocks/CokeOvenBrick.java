package com.mcmoddev.basesciences.common.blocks;

import com.mcmoddev.basesciences.common.multiblocks.MultiblockDetector;
import com.mcmoddev.basesciences.common.tiles.TileEntityCokeOven;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import javax.annotation.Nonnull;

public class CokeOvenBrick extends Block {

    public CokeOvenBrick() {
        super(Material.ROCK);
        this.setHardness(3.0F);
    }

    public void onNeighborChange(@Nullable IBlockAccess world, @Nullable BlockPos pos, @Nullable BlockPos neighbor) {
        TileEntity tileEntity;
        if (world != null) {
            tileEntity = world.getTileEntity(pos);
        } else {
            tileEntity = null;
        }

        if (tileEntity != null && tileEntity instanceof TileEntityCokeOven) {
            TileEntity tile = world.getTileEntity(((TileEntityCokeOven)tileEntity).getControllerBlockPos());
            if (tile != null && tile instanceof TileEntityCokeOven) {
                MultiblockDetector multiblockDetector = ((TileEntityCokeOven)tile).getDetector();
                Boolean var7 = multiblockDetector != null ? multiblockDetector.isMultiblock() : null;

                if (multiblockDetector != null && multiblockDetector.isMultiblock() && ((TileEntityCokeOven)tile).getHasControllerBlock()) {
                    multiblockDetector = ((TileEntityCokeOven)tile).getDetector();
                    if (multiblockDetector != null) {
                        multiblockDetector.reset();
                    }
                }
            }
        }
        super.onNeighborChange(world, pos, neighbor);
    }

    public TileEntity createTileEntity(@Nonnull World world, @Nullable IBlockState state) {
        return new TileEntityCokeOven();
    }

    public boolean hasTileEntity(@Nullable IBlockState state) {
        return true;
    }
}
