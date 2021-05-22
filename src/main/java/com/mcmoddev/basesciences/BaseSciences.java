package com.mcmoddev.basesciences;

import com.mcmoddev.basesciences.init.ScienceBlocks;
import com.mcmoddev.basesciences.init.ScienceTiles;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = BaseSciences.MOD_ID, name = BaseSciences.MOD_NAME, version = BaseSciences.MOD_VERSION,
certificateFingerprint = BaseSciences.FINGERPRINT, acceptedMinecraftVersions = BaseSciences.ACCEPTED_MC_VERSIONS,
        dependencies = BaseSciences.DEPENDENCIES)
public class BaseSciences {

    public static final String MOD_ID = "basesciences";
    public static final String MOD_NAME = "Base Sciences";
    public static final String MOD_VERSION = "@VERSION@";
    public static final String ACCEPTED_MC_VERSIONS = "[1.12,)";
    public static final String FINGERPRINT = "@FINGERPRINT@";
    public static final String DEPENDENCIES = "after:basemetals;after:basegems;after:baseminerals";

    public static CreativeTabs SCIENCES_TAB = new CreativeTabs(MOD_ID) {
        @Override
        public ItemStack getTabIconItem() {
            return new ItemStack(ScienceBlocks.BLAST_FURNACE_BRICK);
        }
    };

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        ScienceTiles.initTileEntities();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
    }
}
