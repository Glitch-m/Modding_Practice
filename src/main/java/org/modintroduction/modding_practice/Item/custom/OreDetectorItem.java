package org.modintroduction.modding_practice.Item.custom;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;
import org.modintroduction.modding_practice.util.ModTags;

import java.util.List;


public class OreDetectorItem extends Item {
    public OreDetectorItem(Properties properties) {
        super(properties);
    }
    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        if(!pContext.getLevel().isClientSide()) {
            BlockPos positionClicked = pContext.getClickedPos();
            Player player = pContext.getPlayer();
            boolean foundBlock = false;

            for(int i = -64; i <= positionClicked.getY() + 64; i++) {
                BlockState blockState = pContext.getLevel().getBlockState(positionClicked.below(i));

                 if(isValuableBlock(blockState)) {
                     outputValuableCoordinates(positionClicked.below(i), player, blockState.getBlock());
                     foundBlock = true;

                     break;
                 }
            }
            for(int i = -64; i <= positionClicked.getX() + 64; i++) {
                BlockState blockState = pContext.getLevel().getBlockState(positionClicked.east(i));

                 if(isValuableBlock(blockState)) {
                     outputValuableCoordinates(positionClicked.east(i), player, blockState.getBlock());
                     foundBlock = true;

                     break;
                 }
            }
            for(int i = -64; i <= positionClicked.getZ() + 64; i++) {
                BlockState blockState = pContext.getLevel().getBlockState(positionClicked.east(i));

                if(isValuableBlock(blockState)) {
                    outputValuableCoordinates(positionClicked.east(i), player, blockState.getBlock());
                    foundBlock = true;

                    break;
                }
            }
            if(!foundBlock) {
                outputValuableFound(player);
            }
        }
        return InteractionResult.SUCCESS;
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        if(Screen.hasShiftDown()) {
            pTooltipComponents.add(Component.translatable("tooltip.modintroduction.ore_detector.tooltip.shift"));
        }

        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }

    private void outputValuableFound(Player player) {
        player.sendSystemMessage(Component.translatable("item.modding_practice.ore_detector.no_valuable_ore_found"));
    }

    private void outputValuableCoordinates(BlockPos below, Player player, Block block) {
        player.sendSystemMessage(Component.literal("Valuable Ores Found: " + I18n.get(block.getDescriptionId())
        + " at (" + below.getX() + "," + below.getY() + "," + below.getZ() + ")"));
    }

    private boolean isValuableBlock(BlockState blockState) {
        return blockState.is(ModTags.Blocks.ORE_DETECTOR_VALUE);
    }
}
