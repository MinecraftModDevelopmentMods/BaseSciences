package com.mcmoddev.basesciences.common.tiles;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;

import javax.annotation.Nonnull;

public class TileEntityMultiblock extends TileEntity {

    private boolean hasControllerBlock = false;
    private boolean isControllerBlock = false;
    private BlockPos controllerBlockPos = BlockPos.ORIGIN;

    public TileEntityMultiblock() {
        controllerBlockPos = BlockPos.ORIGIN;
    }

    public boolean getHasControllerBlock() {
        return hasControllerBlock;
    }

    public void setHasControllerBlock(boolean hasControllerBlock) {
        this.hasControllerBlock = hasControllerBlock;
    }

    public boolean isControllerBlock() {
        return this.isControllerBlock;
    }

    public void setControllerBlock(boolean isControllerBlock) {
        this.isControllerBlock = isControllerBlock;
    }

    public BlockPos getControllerBlockPos() {
        return this.controllerBlockPos;
    }

    public void setControllerBlockPos(BlockPos controllerBlockPos) {
        this.controllerBlockPos = controllerBlockPos;
    }


    @Nonnull
    @Override
    public NBTTagCompound writeToNBT(@Nonnull NBTTagCompound compound) {
        super.writeToNBT(compound);
        compound.setBoolean("hasControllerBlock", hasControllerBlock);
        compound.setBoolean("isControllerBlock", isControllerBlock);
        compound.setInteger("controllerBlockXPos", controllerBlockPos.getX());
        compound.setInteger("controllerBlockYPos", controllerBlockPos.getY());
        compound.setInteger("controllerBlockZPos", controllerBlockPos.getZ());
        return compound;
    }

    @Override
    public void readFromNBT(@Nonnull NBTTagCompound compound) {
        super.readFromNBT(compound);
        hasControllerBlock = compound.getBoolean("hasControllerBlock");
        isControllerBlock = compound.getBoolean("isControllerBlock");
        controllerBlockPos = new BlockPos(compound.getInteger("controllerBlockXPos"),
                compound.getInteger("controllerBlockYPos"), compound.getInteger("controllerBlockZPos"));
    }
}
