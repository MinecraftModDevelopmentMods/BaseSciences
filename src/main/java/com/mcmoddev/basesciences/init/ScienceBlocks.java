package com.mcmoddev.basesciences.init;

import com.mcmoddev.basesciences.BaseSciences;
import com.mcmoddev.basesciences.common.blocks.BlastFurnaceBrick;
import com.mcmoddev.basesciences.common.blocks.CokeOvenBrick;
import net.minecraft.block.Block;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;

@ObjectHolder(BaseSciences.MOD_ID)
@EventBusSubscriber(modid = BaseSciences.MOD_ID)
public class ScienceBlocks {

    public static final Block BLAST_FURNACE_BRICK = null;
    public static final Block COKE_OVEN_BRICK = null;

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        event.getRegistry().registerAll(
                setupBlock(new BlastFurnaceBrick(), "blast_furnace_brick"),
                setupBlock(new CokeOvenBrick(), "coke_oven_brick")
        );
    }

    /**
     * @param block The block being registered.
     * @param name  The name of the block in string form. e.g. "example_block" (Must be the lower case form of it's object holder entry!)
     * @return e.g. setupBlock(new ExampleBlock(), "example_block")
     */
    private static Block setupBlock(Block block, String name) {
        block
                .setRegistryName(name)
                .setUnlocalizedName(BaseSciences.MOD_ID + "." + name)
                .setCreativeTab(BaseSciences.SCIENCES_TAB);
        return block;

    }
}
