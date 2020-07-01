/*
 * Part of the No Tree Punching mod by AlcatrazEscapee.
 * Copyright (c) 2019. See the project LICENSE.md for details.
 */

package com.alcatrazescapee.primalwinter.common;

import java.util.function.Supplier;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.Lazy;

import static com.alcatrazescapee.primalwinter.PrimalWinter.MOD_ID;

/**
 * Simple implementation of {@link ItemGroup} which uses a lazily initialized icon stack.
 */
public class ModItemGroup extends ItemGroup
{
    public static final ItemGroup ITEMS = new ModItemGroup(MOD_ID + ".items", () -> new ItemStack(ModBlocks.SNOWY_DIRT.get()));

    private final Lazy<ItemStack> iconStack;

    public ModItemGroup(String label, Supplier<ItemStack> iconStack)
    {
        super(label);
        this.iconStack = Lazy.of(iconStack);
    }

    @Override
    public ItemStack createIcon()
    {
        return iconStack.get();
    }
}
