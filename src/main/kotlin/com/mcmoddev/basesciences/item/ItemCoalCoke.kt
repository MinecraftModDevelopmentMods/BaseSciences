package com.mcmoddev.basesciences.item

import com.mcmoddev.basesciences.BaseSciences
import net.minecraft.item.Item
import net.minecraft.item.ItemStack

class ItemCoalCoke: Item() {
    init {
        creativeTab = BaseSciences.tabBaseSciencesCreativeTab
        unlocalizedName = "coal_coke"
        setRegistryName(BaseSciences.MOD_NAME, "coal_coke")
    }

    override fun getItemBurnTime(itemStack: ItemStack?): Int {
        return 60 * 20
    }
}