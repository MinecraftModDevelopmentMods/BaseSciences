package com.mcmoddev.basesciences.common.multiblocks;

import com.mcmoddev.basesciences.common.tiles.TileEntityMultiblock;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

public class MultiblockDetector {

    private BlockPos pos;
    private EnumMultiblockForm form;
    private World world;

    public MultiblockDetector(@NotNull BlockPos pos, @NotNull EnumMultiblockForm form, @NotNull World world) {
        super();
        this.pos = pos;
        this.form = form;
        this.world = world;
    }

    public boolean isMultiblock() {
        int counter = 0;
        int x = this.pos.getX();
        int xAcrossOne = this.pos.getX() + 1;
        if (x <= xAcrossOne) {
            while (true) {
                int y = this.pos.getY();
                int yUpthree = this.pos.getY() + 3;
                if (y <= yUpthree) {
                    while (true) {
                        int z = this.pos.getZ();
                        int zAcrossOne = this.pos.getZ() + 1;
                        if (z <= zAcrossOne) {
                            while (true) {
                                BlockPos currentPos = new BlockPos(x, y, z);
                                IBlockState currentState = this.world.getBlockState(currentPos);
                                if (currentState.getBlock() == this.form.getBlock()) {
                                    ++counter;
                                }

                                if (z == zAcrossOne) {
                                    break;
                                }

                                ++z;
                            }
                        }

                        if (y == yUpthree) {
                            break;
                        }

                        ++y;
                    }
                }

                if (x == xAcrossOne) {
                    break;
                }

                ++x;
            }
        }

        return counter == 33 && this.world.isAirBlock(this.pos.add(0, 1, 0)) && this.world.isAirBlock(this.pos.add(0, 2, 0));
    }

    public final void inform() {
        int x = this.pos.getX() - 1;
        int xAcrossOne = this.pos.getX() + 1;
        if (x <= xAcrossOne) {
            while (true) {
                int y = this.pos.getY();
                int yUpThree = this.pos.getY() + 3;
                if (y <= yUpThree) {
                    while (true) {
                        int z = this.pos.getZ() - 1;
                        int zAcrossOne = this.pos.getZ() + 1;
                        if (z <= zAcrossOne) {
                            while (true) {
                                BlockPos currentPos = new BlockPos(x, y, z);
                                TileEntity tileEntity = this.world.getTileEntity(currentPos);
                                if (tileEntity != null && tileEntity instanceof TileEntityMultiblock) {
                                    ((TileEntityMultiblock) tileEntity).setHasControllerBlock(true);
                                    ((TileEntityMultiblock) tileEntity).setControllerBlock(true);
                                    ((TileEntityMultiblock) tileEntity).setControllerBlockPos(this.pos);
                                }

                                if (z == zAcrossOne) {
                                    break;
                                }

                                ++z;
                            }
                        }

                        if (y == yUpThree) {
                            break;
                        }

                        ++y;
                    }
                }

                if (x == xAcrossOne) {
                    break;
                }

                ++x;
            }
        }
    }

    public final void reset() {
        int x = this.pos.getX() - 1;
        int xAcrossOne = this.pos.getX() + 1;
        if (x <= xAcrossOne) {
            while (true) {
                int y = this.pos.getY();
                int yUpThree = this.pos.getY() + 3;
                if (y <= yUpThree) {
                    while (true) {
                        int z = this.pos.getZ() - 1;
                        int zAcrossOne = this.pos.getZ() + 1;
                        if (z <= zAcrossOne) {
                            while (true) {
                                BlockPos currentPos = new BlockPos(x, y, z);
                                TileEntity tileEntity = this.world.getTileEntity(currentPos);
                                if (tileEntity != null && tileEntity instanceof TileEntityMultiblock) {
                                    ((TileEntityMultiblock) tileEntity).setHasControllerBlock(false);
                                    ((TileEntityMultiblock) tileEntity).setControllerBlock(false);
                                    TileEntityMultiblock tileEntityMultiblock = (TileEntityMultiblock) tileEntity;
                                    BlockPos blockPos = BlockPos.ORIGIN;
                                    tileEntityMultiblock.setControllerBlockPos(blockPos);
                                }

                                if (z == zAcrossOne) {
                                    break;
                                }

                                ++z;
                            }
                        }

                        if (y == yUpThree) {
                            break;
                        }

                        ++y;
                    }
                }

                if (x == xAcrossOne) {
                    break;
                }

                ++x;
            }
        }
    }
}
