package org.modintroduction.modding_practice.block.custom;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.modintroduction.modding_practice.Modding_practice;

public class FuelItem extends BlockItem {

    private final int burnTime;

    public FuelItem(Properties properties, int burnTime) {
        super(ModBlocks.FUEL_LOCK.get(), properties);
        this.burnTime = burnTime;
    }

    @Override
    public int getBurnTime(ItemStack itemStack, RecipeType<?> recipeType) {
        return burnTime;
    }
}

public class ModItems {

    public static final DeferredRegister<Item> deferredRegister =
            DeferredRegister.create(ForgeRegistries.ITEMS, Modding_practice.MOD_ID);

    public static final RegistryObject<Item> FUEL_ITEM = deferredRegister.register("fuel_item",
            () -> new FuelItem(new Item.Properties(),200));
}

public class ModBlocks {

    public static final DeferredRegister<Block> deferredRegister =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Modding_practice.MOD_ID);

    public static final RegistryObject<Block> FUEL_LOCK = deferredRegister.register("fuel_lock",
            () -> new FuelBlock(BlockBehaviour.Properties.of().strength(0.5F)));

    // To make it a Fuel-Item

    private void commonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            AbstractFurnaceBlockEntity.isFuel(new ItemStack(ModItems.FUEL_ITEM.get()));
        });
    }
}