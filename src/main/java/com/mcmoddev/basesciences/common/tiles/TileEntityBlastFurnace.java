package com.mcmoddev.basesciences.common.tiles;

import com.mcmoddev.basesciences.common.multiblocks.EnumMultiblockForm;
import com.mcmoddev.basesciences.common.multiblocks.MultiblockDetector;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class TileEntityBlastFurnace extends TileEntityMultiblock implements ITickable {

    private MultiblockDetector detector;

    public final MultiblockDetector getDetector() {
        return this.detector;
    }

    public void setDetector(MultiblockDetector multiblockDetector) {
        this.detector = multiblockDetector;
    }

    @Override
    public void update() {
        if (this.detector == null) {
            World world = this.world;
            BlockPos blocksPos = this.pos;
            EnumMultiblockForm multiblockForm = EnumMultiblockForm.BLAST_FURNACE;
            this.detector = new MultiblockDetector(blocksPos, multiblockForm, world);
        }

        MultiblockDetector multiblockDetector = this.detector;
        if (multiblockDetector.isMultiblock() && !this.getHasControllerBlock()) {
            multiblockDetector = this.detector;
            if (multiblockDetector == null) {
                Intrinsics.throwNpe();
            }

            multiblockDetector.inform();
        }
    }
}
