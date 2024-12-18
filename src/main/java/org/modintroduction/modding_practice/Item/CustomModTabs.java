package org.modintroduction.modding_practice.Item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import org.modintroduction.modding_practice.Modding_practice;
import org.modintroduction.modding_practice.block.ModBlocks;

public class CustomModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Modding_practice.MOD_ID);

    public static final RegistryObject<CreativeModeTab> MODDED_INGREDIENTS_TAB = CREATIVE_MODE_TABS.register("modded_ingredients_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.RUBY.get()))
                    .title(Component.translatable("creativetab.modded_ingredients_tab")).displayItems((itemDisplayParameters, output) -> {
                        // Minderals/ingredients
                        output.accept(ModItems.RUBY.get());
                        output.accept(ModItems.SAPPHIRE.get());
                        output.accept(ModItems.PERIDOT.get());
                        output.accept(ModItems.DEBRIS.get());
                    }).build());
    public static final RegistryObject<CreativeModeTab> MOD_FOOD_TAB = CREATIVE_MODE_TABS.register("mod_food_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.GREEN_APPLE.get()))
                    .title(Component.translatable("creativetab.mod_food_tab")).displayItems((itemDisplayParameters, output) -> {
                        // Food
                        output.accept(ModItems.GREEN_APPLE.get());
                    }).build());

    public static final RegistryObject<CreativeModeTab> MODDED_NATURAL_BLOCKS = CREATIVE_MODE_TABS.register("modded_natural_blocks",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.RUBY_ORE.get()))
                    .title(Component.translatable("creativetab.modded_natural_blocks")).displayItems((itemDisplayParameters, output) -> {
                        // Modded blocks
                        output.accept(ModBlocks.RUBY_ORE.get());
                        output.accept(ModBlocks.SAPPHIRE_ORE.get());
                        output.accept(ModBlocks.PERIDOT_ORE.get());
                        output.accept(ModBlocks.DEEPSLATE_DEBRIS_ORE.get());
                        output.accept(ModBlocks.DEEPSLATE_RUBY_ORE.get());
                        output.accept(ModBlocks.DEEPSLATE_SAPPHIRE_ORE.get());
                        output.accept(ModBlocks.DEEPSLATE_PERIDOT_ORE.get());
                    }).build());

    public static final RegistryObject<CreativeModeTab> MODDED_BUILDING_BLOCKS = CREATIVE_MODE_TABS.register("modded_building_blocks",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.PERIDOT_BLOCK.get()))
                    .title(Component.translatable("creativetab.modded_building_blocks")).displayItems((itemDisplayParameters, output) -> {
                        // Modded blocks
                        output.accept(ModBlocks.DEBRIS_BLOCK.get());
                        output.accept(ModBlocks.RUBY_BLOCK.get());
                        output.accept(ModBlocks.SAPPHIRE_BLOCK.get());
                        output.accept(ModBlocks.PERIDOT_BLOCK.get());
                    }).build());

    public static final RegistryObject<CreativeModeTab> DEBUG_ITEMS = CREATIVE_MODE_TABS.register("debug_items",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.ORE_DETECTOR.get()))
                    .title(Component.translatable("creativetab.debug_items")).displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.ORE_DETECTOR.get());
                        output.accept(ModBlocks.SOUND_BLOCK.get());
    }).build());
    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
