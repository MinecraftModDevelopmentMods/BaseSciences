package com.mcmoddev.basesciences.common.multiblocks;

import com.mcmoddev.basesciences.init.ScienceBlocks;
import net.minecraft.block.Block;

import javax.annotation.Nonnull;

public enum EnumMultiblockForm {

    BLAST_FURNACE(ScienceBlocks.BLAST_FURNACE_BRICK),
    COKE_OVEN(ScienceBlocks.BLAST_FURNACE_BRICK);

    @Nonnull
    Block block;

    EnumMultiblockForm(Block block) {
        this.block = block;
    }

    @Nonnull
    public Block getBlock() {
        return this.block;
    }
}
