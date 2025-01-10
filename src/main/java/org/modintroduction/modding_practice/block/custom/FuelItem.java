package org.modintroduction.modding_practice.block.custom;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import org.jetbrains.annotations.Nullable;
import org.modintroduction.modding_practice.block.ModBlocks;

public class FuelItem extends Item {
    private int burnTime = 0;

    public FuelItem(Properties pProperties, int burnTime) {
        super(pProperties);
        this.burnTime = burnTime;
    }
    @Override
    public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
        return this.burnTime;
    }
}