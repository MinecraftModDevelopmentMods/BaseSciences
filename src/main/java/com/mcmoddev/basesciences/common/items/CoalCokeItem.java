package com.mcmoddev.basesciences.common.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import javax.annotation.Nonnull;

public class CoalCokeItem extends Item {

    @Override
    public int getItemBurnTime(@Nonnull ItemStack itemStack) {
        return 1200;
    }
}
