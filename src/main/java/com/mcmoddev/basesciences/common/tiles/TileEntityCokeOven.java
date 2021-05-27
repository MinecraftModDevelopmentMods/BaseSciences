package com.mcmoddev.basesciences.common.tiles;

import com.mcmoddev.basesciences.common.multiblocks.MultiblockDetector;
import com.mcmoddev.basesciences.common.multiblocks.EnumMultiblockForm;
import com.mcmoddev.basesciences.init.ScienceItems;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Iterator;
import java.util.List;

public class TileEntityCokeOven extends TileEntityMultiblock implements ITickable {

    private MultiblockDetector detector;

    public MultiblockDetector getDetector() {
        return this.detector;
    }

    public void setDetector(MultiblockDetector detector) {
        this.detector = detector;
    }

    @Override
    public void update() {
        if (this.detector == null) {
            BlockPos blockPos = this.pos;
            EnumMultiblockForm form = EnumMultiblockForm.COKE_OVEN;
            World world = this.world;
            this.detector = new MultiblockDetector(blockPos, form, world);
        }

        MultiblockDetector multiblockDetector = this.detector;
        if (multiblockDetector.isMultiblock() && !this.getHasControllerBlock()) {
            multiblockDetector = this.detector;
            multiblockDetector.inform();
        } else {
            if (this.getHasControllerBlock() && this.isControllerBlock()) {
                AxisAlignedBB box = new AxisAlignedBB(this.pos.up());
                List items = this.world.getEntitiesWithinAABB(EntityItem.class, box);
                Iterator itemIterator = items.iterator();

                while(itemIterator.hasNext()) {
                    EntityItem entity = (EntityItem)itemIterator.next();
                    ItemStack itemStack = entity.getItem();
                    if (itemStack.getItem() == Items.COAL) {
                        Item coalCoke = ScienceItems.COAL_COKE;
                        ItemStack item = entity.getItem();
                        entity.setItem(new ItemStack(coalCoke, item.getCount()));
                    }
                }
            }
        }
    }
}
