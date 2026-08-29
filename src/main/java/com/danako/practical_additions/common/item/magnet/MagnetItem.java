package com.danako.practical_additions.common.item.magnet;

import com.danako.practical_additions.PracticalAdditions;
import com.danako.practical_additions.init.data_components.PADataComponents;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;

import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

import java.util.List;
import java.util.function.Consumer;

public abstract class MagnetItem extends Item implements ICurioItem {

    protected MagnetItem(Properties props) {
        super(props);
    }

    protected abstract double getRadius();

    protected abstract void collectItem(Player player, ItemEntity entity, ItemStack magnetStack, Level level);

    protected boolean passesFilter(ItemStack magnetStack, ItemStack targetStack) {
        return true;
    }

    protected InteractionResult onPlainRightClick(Level level, Player player, InteractionHand hand, ItemStack stack) {
        return InteractionResult.PASS;
    }

    public boolean isActive(ItemStack stack) {
        return Boolean.TRUE.equals(stack.get(PADataComponents.MAGNET_ACTIVE.get()));
    }

    public void setActive(ItemStack stack, boolean active) {
        stack.set(PADataComponents.MAGNET_ACTIVE.get(), active);
    }

    @Override
    public InteractionResult use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        if (player.isShiftKeyDown()) {
            if (!level.isClientSide()) {
                boolean newState = !isActive(stack);
                setActive(stack, newState);
                player.displayClientMessage(toggleMessage(stack, newState), true);
            }
            return level.isClientSide() ? InteractionResult.SUCCESS : InteractionResult.SUCCESS_SERVER;
        }
        return onPlainRightClick(level, player, hand, stack);
    }

    @Override
    public boolean isFoil(ItemStack stack) {
        return isActive(stack);
    }

    public Component toggleMessage(ItemStack stack, boolean nowActive) {
        Component state = nowActive ? Component.translatable("tooltip." + PracticalAdditions.MODID + ".magnet.on").withStyle(ChatFormatting.GREEN) : Component.translatable("tooltip." + PracticalAdditions.MODID + ".magnet.off").withStyle(ChatFormatting.RED);
        return Component.translatable("message." + PracticalAdditions.MODID + ".magnet_toggled", stack.getHoverName(), state);
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, TooltipDisplay tooltipDisplay, Consumer<Component> tooltipAdder, TooltipFlag flag) {
        boolean active = isActive(stack);
        Component state = active ? Component.translatable("tooltip." + PracticalAdditions.MODID + ".magnet.on").withStyle(ChatFormatting.GREEN, ChatFormatting.BOLD) : Component.translatable("tooltip." + PracticalAdditions.MODID + ".magnet.off").withStyle(ChatFormatting.RED, ChatFormatting.BOLD);

        tooltipAdder.accept(Component.translatable("tooltip." + PracticalAdditions.MODID + ".magnet.state").append(state));
        tooltipAdder.accept(Component.translatable("tooltip." + PracticalAdditions.MODID + ".magnet.toggle_hint").withStyle(ChatFormatting.GRAY));
    }

    @Override
    public void inventoryTick(ItemStack stack, ServerLevel level, Entity entity, EquipmentSlot slot) {

        if (entity instanceof Player player && isActive(stack)) {
            performMagnetPull(player, stack, level);
        }
    }

    @Override
    public void curioTick(SlotContext slotContext, ItemStack stack) {
        if (slotContext.entity() instanceof Player player && !player.level().isClientSide() && isActive(stack)) {
            performMagnetPull(player, stack, player.level());
        }
    }

    @Override
    public boolean canEquip(SlotContext slotContext, ItemStack stack) {
        return true;
    }

    protected void performMagnetPull(Player player, ItemStack magnetStack, Level level) {
        double radius = getRadius();
        AABB area = player.getBoundingBox().inflate(radius);

        List<ItemEntity> nearby = level.getEntitiesOfClass(ItemEntity.class, area, item -> item.isAlive() && !item.getItem().isEmpty());

        for (ItemEntity itemEntity : nearby) {
            if (!passesFilter(magnetStack, itemEntity.getItem())) {
                continue;
            }
            collectItem(player, itemEntity, magnetStack, level);
        }

        if (attractsExperience(magnetStack)) {
            List<ExperienceOrb> nearbyOrbs = level.getEntitiesOfClass(ExperienceOrb.class, area, ExperienceOrb::isAlive);
            for (ExperienceOrb orb : nearbyOrbs) {
                collectExperienceOrb(player, orb, magnetStack, level);
            }
        }
    }

    protected boolean attractsExperience(ItemStack magnetStack) {
        return true;
    }

    protected abstract void collectExperienceOrb(Player player, ExperienceOrb orb, ItemStack magnetStack, Level level);
}