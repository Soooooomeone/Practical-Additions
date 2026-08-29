package com.danako.practical_additions.common.tool.aoe_tools;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class HammerItem extends Item implements IAOEToolType {

    public HammerItem(ToolMaterial material, float attackDamage, float attackSpeed, Properties properties) {

        super(properties.pickaxe(material, attackDamage, attackSpeed).durability(material.durability() * 2));
    }

    @Override
    public AOEToolType getAOEToolType() {
        return AOEToolType.HAMMER_3X3;
    }

    @Override
    public boolean mineBlock(ItemStack stack, Level level, BlockState state, BlockPos pos, LivingEntity entity) {
        if (!level.isClientSide() && entity instanceof ServerPlayer player && !AOEToolHelper.isProcessing()) {
            Direction face = AOEToolEffects.getLastFace(player, pos);
            AOEToolHelper.breakArea(player, level, pos, state, AOEToolType.HAMMER_3X3, face);
        }
        return super.mineBlock(stack, level, state, pos, entity);
    }
}