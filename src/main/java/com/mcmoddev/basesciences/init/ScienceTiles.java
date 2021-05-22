package com.mcmoddev.basesciences.init;

import com.mcmoddev.basesciences.BaseSciences;
import com.mcmoddev.basesciences.common.tiles.TileEntityBlastFurnace;
import com.mcmoddev.basesciences.common.tiles.TileEntityCokeOven;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ScienceTiles {

    public static void initTileEntities() {
        GameRegistry.registerTileEntity(TileEntityBlastFurnace.class, new ResourceLocation(BaseSciences.MOD_ID, "blast_furnace_brick"));
        GameRegistry.registerTileEntity(TileEntityCokeOven.class, new ResourceLocation(BaseSciences.MOD_ID, "coke_oven_brick"));
    }

}
