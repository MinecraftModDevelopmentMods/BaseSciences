package com.mcmoddev.basesciences

import com.mcmoddev.basesciences.item.tab.CreativeTab
import com.mcmoddev.basesciences.proxy.CommonProxy
import net.minecraft.creativetab.CreativeTabs
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.SidedProxy
import net.minecraftforge.fml.common.event.FMLInitializationEvent
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent

@Mod(modid = BaseSciences.MODID, name = BaseSciences.MOD_NAME, version = BaseSciences.MOD_VERSION,
        acceptedMinecraftVersions = BaseSciences.ACCEPTED_MC_VERSIONS, dependencies = BaseSciences.DEPENDENCIES,
        modLanguage = "kotlin", modLanguageAdapter = "net.shadowfacts.forgelin.KotlinAdapter",
        certificateFingerprint = "@FINGERPRINT@")
object BaseSciences {
    const val MODID: String = "basesciences"
    const val MOD_NAME: String = "Base Sciences"
    const val MOD_VERSION: String = "@VERSION@"
    const val ACCEPTED_MC_VERSIONS: String = "[1.12,)"
    const val DEPENDENCIES: String = "after:basemetals;after:basegems;after:baseminerals;required-after:forgelin"

    lateinit var tabBaseSciencesCreativeTab: CreativeTabs

    @Mod.Instance
    lateinit var instance: BaseSciences

    @SidedProxy(clientSide = "com.mcmoddev.basesciences.proxy.ClientProxy", serverSide = "com.mcmoddev.basesciences.proxy.CommonProxy")
    lateinit var proxy: CommonProxy

    @Mod.EventHandler
    fun preInit(event: FMLPreInitializationEvent) {
        tabBaseSciencesCreativeTab = CreativeTab()
        proxy.preInit(event)
    }

    @Mod.EventHandler
    fun init(event: FMLInitializationEvent) {
        proxy.init(event)
    }

    @Mod.EventHandler
    fun postInit(event: FMLPostInitializationEvent) {
        proxy.postInit(event)
    }
}