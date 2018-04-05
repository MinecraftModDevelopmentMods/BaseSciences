package com.mcmoddev.basesciences.tile

import com.mcmoddev.basesciences.init.Items
import com.mcmoddev.basesciences.multiblock.EnumMultiblockForm
import com.mcmoddev.basesciences.multiblock.MultiblockDetector
import net.minecraft.entity.item.EntityItem
import net.minecraft.item.ItemStack
import net.minecraft.util.ITickable
import net.minecraft.util.math.AxisAlignedBB

class TileEntityCokeOvenBrick: TileEntityMultiblock(), ITickable {
    var detector: MultiblockDetector? = null

    override fun update() {
        if (detector == null)
            detector = MultiblockDetector(pos, EnumMultiblockForm.COKE_OVEN, world)
        if (detector!!.isMultiblock() && !hasMaster)
            detector!!.inform()
        else if (hasMaster && isMaster) {
            val box = AxisAlignedBB(pos.up())
            val items = world.getEntitiesWithinAABB(EntityItem::class.java, box)
            for (entity in items) {
                if (entity.item.item == net.minecraft.init.Items.COAL) {
                    entity.item = ItemStack(Items.itemCoalCoke, entity.item.count)
                }
            }
        }
    }
}