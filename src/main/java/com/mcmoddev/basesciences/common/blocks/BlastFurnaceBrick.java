package com.mcmoddev.basesciences.common.blocks;

import com.mcmoddev.basesciences.common.multiblocks.MultiblockDetector;
import com.mcmoddev.basesciences.common.tiles.TileEntityBlastFurnace;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class BlastFurnaceBrick extends Block {

    public BlastFurnaceBrick() {
        super(Material.IRON);
        this.setHardness(3.0F);
    }

    public void onNeighborChange(@Nullable IBlockAccess world, @Nullable BlockPos pos, @Nullable BlockPos neighbor) {
        TileEntity tileEntity;
        if (world != null) {
            if (pos == null) {
                Intrinsics.throwNpe();
            }

            tileEntity = world.getTileEntity(pos);
        } else {
            tileEntity = null;
        }

        TileEntity tile = tileEntity;
        if (tile != null && tile instanceof TileEntityBlastFurnace) {
            TileEntity controllerBlock = world.getTileEntity(((TileEntityBlastFurnace) tile).getControllerBlockPos());
            if (controllerBlock != null && controllerBlock instanceof TileEntityBlastFurnace) {
                MultiblockDetector multiblockDetector = ((TileEntityBlastFurnace) controllerBlock).getDetector();
                if (multiblockDetector != null && multiblockDetector.isMultiblock() && ((TileEntityBlastFurnace) controllerBlock).getHasControllerBlock()) {
                    multiblockDetector = ((TileEntityBlastFurnace) controllerBlock).getDetector();
                    if (multiblockDetector != null) {
                        multiblockDetector.reset();
                    }
                }
            }
        }

        super.onNeighborChange(world, pos, neighbor);
    }

    @Nullable
    public TileEntity createTileEntity(@Nullable World world, @Nullable IBlockState state) {
        return new TileEntityBlastFurnace();
    }

    public boolean hasTileEntity(@Nullable IBlockState state) {
        return true;
    }
}
