package com.mcmoddev.basesciences.client;

import com.mcmoddev.basesciences.BaseSciences;
import com.mcmoddev.basesciences.init.ScienceBlocks;
import com.mcmoddev.basesciences.init.ScienceItems;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.resources.I18n;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import org.jetbrains.annotations.NotNull;

@EventBusSubscriber(modid = BaseSciences.MOD_ID, value = Side.CLIENT)
public class ScienceRendering {

    @SubscribeEvent
    public static void registerRenders(ModelRegistryEvent event) {
        registerItemModel(Item.getItemFromBlock(ScienceBlocks.BLAST_FURNACE_BRICK), 0);
        registerItemModel(Item.getItemFromBlock(ScienceBlocks.COKE_OVEN_BRICK), 0);
        registerItemModel(ScienceItems.COAL_COKE, 0);
    }

    @SubscribeEvent
    public final void addTooltips(@NotNull ItemTooltipEvent event) {
        ItemStack stack = event.getItemStack();
        Item item = stack.getItem();
        if (item == Items.IRON_INGOT) {
            event.getToolTip().add(I18n.format("tooltip.magnetite.name"));
            event.getToolTip().add(I18n.format("tooltip.magnetite.formula"));
        } else if (item == Items.COAL) {
            stack = event.getItemStack();
            if (stack.getMetadata() == 0) {
                event.getToolTip().add(I18n.format("tooltip.bituminous_coal.name"));
            }
        }

    }

    /**
     * @param item The item being rendered.
     * @param meta The metadata of the item. (In case others wish to use metadata but I do not)
     *             e.g. registerItemModel(Item.getItemFromBlock(BlockObjectHolderExamples.EXAMPLE_BLOCK), 0);
     */
    public static void registerItemModel(Item item, int meta) {
        ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(item.getRegistryName(), "inventory"));
    }
}
