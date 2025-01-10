package org.modintroduction.modding_practice.block;

import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.modintroduction.modding_practice.Item.ModItems;
import org.modintroduction.modding_practice.Modding_practice;
import org.modintroduction.modding_practice.block.custom.FuelBlock;
import org.modintroduction.modding_practice.block.custom.SoundBlock;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Modding_practice.MOD_ID);

    public static final RegistryObject<Block> DEBRIS_BLOCK = registerBlock("debris_block",
            () -> {
                return new FuelBlock(Block.Properties.of().mapColor(MapColor.COLOR_BROWN).instrument(NoteBlockInstrument.BASEDRUM)
                        .requiresCorrectToolForDrops().strength(9.0F, 10.0F).sound(SoundType.STONE), 24000);
            });

    public static final RegistryObject<Block> RUBY_BLOCK = registerBlock("ruby_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.EMERALD_BLOCK)));

    public static final RegistryObject<Block> SAPPHIRE_BLOCK = registerBlock("sapphire_block",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.GOLD).instrument(NoteBlockInstrument.BELL)
                    .requiresCorrectToolForDrops().strength(2.0F, 3.0F).sound(SoundType.METAL)));

    public static final RegistryObject<Block> PERIDOT_BLOCK = registerBlock("peridot_block",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.GOLD).instrument(NoteBlockInstrument.FLUTE)
                    .requiresCorrectToolForDrops().strength(3.0F, 3.5F).sound(SoundType.AMETHYST)));

    public static final RegistryObject<Block> RUBY_ORE = registerBlock("ruby_ore",
            () -> new DropExperienceBlock(UniformInt.of(3,5), BlockBehaviour.Properties.of().mapColor(MapColor.STONE)
                    .requiresCorrectToolForDrops().strength(4.5F, 6.0F).sound(SoundType.STONE)));

    public static final RegistryObject<Block> SAPPHIRE_ORE = registerBlock("sapphire_ore",
            () -> new DropExperienceBlock(UniformInt.of(1,2),BlockBehaviour.Properties.of().mapColor(MapColor.STONE)
                    .requiresCorrectToolForDrops().strength(2.0F, 2.5F).sound(SoundType.STONE)));

    public static final RegistryObject<Block> PERIDOT_ORE = registerBlock("peridot_ore",
            () -> new DropExperienceBlock(UniformInt.of(2,4), BlockBehaviour.Properties.of().mapColor(MapColor.DIAMOND)
                    .requiresCorrectToolForDrops().strength(2.0F, 4.5F).sound(SoundType.STONE)));

    public static final RegistryObject<Block> DEEPSLATE_DEBRIS_ORE = registerBlock("deepslate_debris_ore",
            () -> new DropExperienceBlock(UniformInt.of(7,10), BlockBehaviour.Properties.of().mapColor(MapColor.DIAMOND)
                    .requiresCorrectToolForDrops().strength(6.0F, 7.8F).sound(SoundType.STONE)));

    public static final RegistryObject<Block> DEEPSLATE_RUBY_ORE = registerBlock("deepslate_ruby_ore",
            () -> new DropExperienceBlock(UniformInt.of(5,10), BlockBehaviour.Properties.of().requiresCorrectToolForDrops().mapColor(MapColor.DIAMOND)
                    .requiresCorrectToolForDrops().strength(5.5F, 7.0F).sound(SoundType.STONE)));

    public static final RegistryObject<Block> DEEPSLATE_SAPPHIRE_ORE = registerBlock("deepslate_sapphire_ore",
            () -> new DropExperienceBlock(UniformInt.of(4,8),BlockBehaviour.Properties.of().mapColor(MapColor.GOLD)
                    .requiresCorrectToolForDrops().strength(3.5F, 5.5F).sound(SoundType.STONE)));

    public static final RegistryObject<Block> DEEPSLATE_PERIDOT_ORE = registerBlock("deepslate_peridot_ore",
            () -> new DropExperienceBlock(UniformInt.of(3,6), BlockBehaviour.Properties.of().requiresCorrectToolForDrops().mapColor(MapColor.DIAMOND)
                    .requiresCorrectToolForDrops().strength(2.5F, 3.5F).sound(SoundType.STONE)));

    public static final RegistryObject<Block> SOUND_BLOCK = registerBlock("sound_block",
            () -> new SoundBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GOLD_BLOCK)));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
