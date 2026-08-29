package com.danako.practical_additions.common.item.diving_belt;

import com.danako.practical_additions.PracticalAdditions;
import com.danako.practical_additions.init.data_components.PADataComponents;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.level.Level;

import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

import java.util.function.Consumer;

public class DivingBeltItem extends Item implements ICurioItem {

    public DivingBeltItem(Properties props) {
        super(props);
    }

    public boolean isActive(ItemStack stack) {
        return Boolean.TRUE.equals(stack.get(PADataComponents.DIVING_BELT_ACTIVE.get()));
    }

    public void setActive(ItemStack stack, boolean active) {
        stack.set(PADataComponents.DIVING_BELT_ACTIVE.get(), active);
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
        return InteractionResult.PASS;
    }

    @Override
    public boolean isFoil(ItemStack stack) {
        return isActive(stack);
    }

    public Component toggleMessage(ItemStack stack, boolean nowActive) {
        Component state = nowActive
                ? Component.translatable("tooltip." + PracticalAdditions.MODID + ".diving_belt.on").withStyle(ChatFormatting.GREEN)
                : Component.translatable("tooltip." + PracticalAdditions.MODID + ".diving_belt.off").withStyle(ChatFormatting.RED);
        return Component.translatable("message." + PracticalAdditions.MODID + ".diving_belt_toggled", stack.getHoverName(), state);
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, TooltipDisplay tooltipDisplay, Consumer<Component> tooltipAdder, TooltipFlag flag) {
        boolean active = isActive(stack);
        Component state = active
                ? Component.translatable("tooltip." + PracticalAdditions.MODID + ".diving_belt.on").withStyle(ChatFormatting.GREEN, ChatFormatting.BOLD)
                : Component.translatable("tooltip." + PracticalAdditions.MODID + ".diving_belt.off").withStyle(ChatFormatting.RED, ChatFormatting.BOLD);

        tooltipAdder.accept(Component.translatable("tooltip." + PracticalAdditions.MODID + ".diving_belt.state").append(state));
        tooltipAdder.accept(Component.translatable("tooltip." + PracticalAdditions.MODID + ".diving_belt.toggle_hint").withStyle(ChatFormatting.GRAY));
    }

    @Override
    public boolean canEquip(SlotContext slotContext, ItemStack stack) {
        return true;
    }

}