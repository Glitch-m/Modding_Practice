package org.modintroduction.modding_practice.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.Nullable;
import org.modintroduction.modding_practice.Modding_practice;

import java.util.List;

public class SoundBlock extends Block {
    public SoundBlock(Properties p_49795_) {
        super(p_49795_);
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos,
                                 Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        if (pLevel.isClientSide() && pHand == InteractionHand.MAIN_HAND) {
            if (pPlayer.isCrouching()) {
                pLevel.playSound(pPlayer, pPos, SoundEvents.MUSIC_MENU.get(), SoundSource.BLOCKS, 2f, 2f);
                return InteractionResult.SUCCESS;
            } else {
                pLevel.playSound(pPlayer, pPos, SoundEvents.MUSIC_GAME.get(), SoundSource.BLOCKS, 2f, 2f);
                return InteractionResult.SUCCESS;
            }

            // Server-side logic goes here
            // For example, play a sound effect or perform a server-side action.
        }

        return super.use(pState, pLevel, pPos, pPlayer, pHand, pHit);
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable BlockGetter pLevel, List<Component> pTooltip, TooltipFlag pFlag) {
        pTooltip.add(Component.translatable("tooltip.modding_practice.sound_block"));

        super.appendHoverText(pStack, pLevel, pTooltip, pFlag);
    }
}
