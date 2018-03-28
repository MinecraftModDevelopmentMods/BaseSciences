package com.mcmoddev.basesciences.item.tab

import com.mcmoddev.basesciences.init.Blocks
import net.minecraft.creativetab.CreativeTabs
import net.minecraft.item.ItemStack

class CreativeTab: CreativeTabs("base_sciences") {
    override fun getTabIconItem(): ItemStack {
        return ItemStack(Blocks.blockBlastFurnaceBrick)
    }
}