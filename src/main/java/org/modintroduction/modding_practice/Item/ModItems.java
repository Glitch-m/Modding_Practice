package org.modintroduction.modding_practice.Item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.modintroduction.modding_practice.Item.custom.ModFoodProperties;
import org.modintroduction.modding_practice.Item.custom.OreDetectorItem;
import org.modintroduction.modding_practice.Modding_practice;
import org.modintroduction.modding_practice.block.custom.FuelItem;

import static net.minecraft.world.item.Items.registerItem;

public class ModItems {

    // Minerals
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Modding_practice.MOD_ID);

    public static final RegistryObject<Item> RUBY = ITEMS.register("ruby",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> SAPPHIRE = ITEMS.register("sapphire",
            () -> new FuelItem(new Item.Properties(), 200));

    public static final RegistryObject<Item> PERIDOT = ITEMS.register("peridot",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> DEBRIS = ITEMS.register("debris",
            () -> new FuelItem(new Item.Properties(), 12000));

    // Gadgets and tools
    public static final RegistryObject<Item> ORE_DETECTOR = ITEMS.register("ore_detector",
            () -> new OreDetectorItem(new Item.Properties()));
    // Weapons

    // Foods
    public static final RegistryObject<Item> GREEN_APPLE = ITEMS.register("green_apple",
            () -> new OreDetectorItem(new Item.Properties().food(ModFoodProperties.GREEN_APPLE)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
