package com.mcmoddev.basesciences.block

import com.mcmoddev.basesciences.BaseSciences
import net.minecraft.block.Block
import net.minecraft.block.material.Material

class BlockStructural(name: String): Block(Material.IRON) {
    init {
        setCreativeTab(BaseSciences.tabBaseSciencesCreativeTab)
        setHardness(3.0f)
        unlocalizedName = name
        setRegistryName(BaseSciences.MODID, name)
    }
}