package com.mcmoddev.basesciences.init;

import com.mcmoddev.basesciences.BaseSciences;
import com.mcmoddev.basesciences.common.items.CoalCokeItem;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;

@ObjectHolder(BaseSciences.MOD_ID)
@EventBusSubscriber(modid = BaseSciences.MOD_ID)
public class ScienceItems {

    public static final Item COAL_COKE = null;

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(
                nameBlockItem(ScienceBlocks.BLAST_FURNACE_BRICK),
                nameBlockItem(ScienceBlocks.COKE_OVEN_BRICK),
                nameItem(new CoalCokeItem(), "coal_coke")
        );
    }

    /**
     * @param block The block being registered usually called from it's object holder class
     * @return e.g. nameBlockItem(BlockObjectHolderExample.BIRCH_PLANKS)
     */
    public static ItemBlock nameBlockItem(Block block) {
        ItemBlock item = new ItemBlock(block);
        ResourceLocation name = block.getRegistryName();
        item.setRegistryName(name);
        return item;
    }

    /**
     * @param item The item being registered.
     * @param name The name of the item in string form. e.g. "example_block" (Must be the lower case form of it's object holder entry!)
     * @return e.g. nameItem(new ItemExample(), "example_item")
     */
    public static Item nameItem(Item item, String name) {
        item
                .setRegistryName(name)
                .setUnlocalizedName(BaseSciences.MOD_ID + "." + name)
                .setCreativeTab(BaseSciences.SCIENCES_TAB);
        return item;
    }
}
