package com.danako.practical_additions.common.tool.aoe_tools;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class SickleItem extends Item implements IAOEToolType {

    public SickleItem(ToolMaterial material, float attackDamage, float attackSpeed, Properties properties) {

        super(properties.hoe(material, attackDamage, attackSpeed).durability(material.durability() * 2));
    }

    @Override
    public AOEToolType getAOEToolType() {
        return AOEToolType.SICKLE_5X5;
    }

    @Override
    public boolean mineBlock(ItemStack stack, Level level, BlockState state, BlockPos pos, LivingEntity entity) {
        if (!level.isClientSide() && entity instanceof ServerPlayer player && !AOEToolHelper.isProcessing()) {
            Direction face = AOEToolEffects.getLastFace(player, pos);
            AOEToolHelper.breakArea(player, level, pos, state, AOEToolType.SICKLE_5X5, face);
        }
        return super.mineBlock(stack, level, state, pos, entity);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        if (context.getClickedFace() != Direction.UP) return InteractionResult.PASS;

        Player interactingPlayer = context.getPlayer();
        boolean crouching = interactingPlayer != null && interactingPlayer.isCrouching();

        Level level = (Level) context.getLevel();
        BlockPos pos = context.getClickedPos();

        if (crouching) {
            return tillFarmland(context, level, pos);
        }
        return harvestAndReplant(context, level, pos);
    }

    private InteractionResult tillFarmland(UseOnContext context, Level level, BlockPos pos) {
        if (level.isClientSide()) {
            return AOEToolHelper.canMakeFarmland(level, pos, Direction.UP) ? InteractionResult.SUCCESS : InteractionResult.PASS;
        }

        if (!(context.getPlayer() instanceof ServerPlayer player)) return InteractionResult.PASS;
        if (!AOEToolHelper.tryMakeFarmland(player, level, pos, Direction.UP)) return InteractionResult.PASS;

        context.getItemInHand().hurtAndBreak(1, (ServerLevel) level, player, item -> {
        });

        return InteractionResult.SUCCESS;
    }

    private InteractionResult harvestAndReplant(UseOnContext context, Level level, BlockPos pos) {
        if (level.isClientSide()) {
            return AOEToolHelper.canHarvest(level, pos, Direction.UP) ? InteractionResult.SUCCESS : InteractionResult.PASS;
        }

        if (!(context.getPlayer() instanceof ServerPlayer player)) return InteractionResult.PASS;
        if (!AOEToolHelper.harvestAndReplant(player, level, pos, Direction.UP)) return InteractionResult.PASS;

        context.getItemInHand().hurtAndBreak(1, (ServerLevel) level, player, item -> {
        });

        return InteractionResult.SUCCESS;
    }
}