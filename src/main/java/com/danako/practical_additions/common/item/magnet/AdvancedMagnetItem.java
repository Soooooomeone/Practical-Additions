package com.danako.practical_additions.common.item.magnet;

import com.danako.practical_additions.init.data_components.PADataComponents;
import com.danako.practical_additions.inventory.magnet.AdvancedMagnetMenu;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class AdvancedMagnetItem extends MagnetItem {

    private static final double RADIUS = 12.0D;

    public AdvancedMagnetItem(Properties props) {
        super(props);
    }

    @Override
    protected double getRadius() {
        return RADIUS;
    }

    @Override
    protected boolean passesFilter(ItemStack magnetStack, ItemStack targetStack) {
        MagnetFilterData filter = magnetStack.getOrDefault(PADataComponents.MAGNET_FILTER.get(), MagnetFilterData.EMPTY);
        return filter.allows(targetStack);
    }

    @Override
    protected void collectItem(Player player, ItemEntity entity, ItemStack magnetStack, Level level) {
        ItemStack held = entity.getItem();
        ItemStack toInsert = held.copy();

        player.getInventory().add(toInsert);

        int inserted = held.getCount() - toInsert.getCount();
        if (inserted <= 0) {
            return;
        }

        held.shrink(inserted);
        if (held.isEmpty()) {
            entity.discard();
        }

        level.playSound(null, player.blockPosition(), SoundEvents.ITEM_PICKUP, SoundSource.PLAYERS, 0.2F, ((player.getRandom().nextFloat() - player.getRandom().nextFloat()) * 0.7F + 1.0F) * 2.0F);
        player.inventoryMenu.broadcastChanges();
    }

    @Override
    protected boolean attractsExperience(ItemStack magnetStack) {
        MagnetFilterData filter = magnetStack.getOrDefault(PADataComponents.MAGNET_FILTER.get(), MagnetFilterData.EMPTY);
        return filter.attractExperience();
    }

    @Override
    protected void collectExperienceOrb(Player player, ExperienceOrb orb, ItemStack magnetStack, Level level) {
        player.giveExperiencePoints(orb.getValue());
        orb.discard();
    }

    @Override
    protected InteractionResult onPlainRightClick(Level level, Player player, InteractionHand hand, ItemStack stack) {
        if (!level.isClientSide()) {
            player.openMenu(new SimpleMenuProvider((containerId, playerInv, p) -> new AdvancedMagnetMenu(containerId, playerInv, p.getItemInHand(hand)), stack.getHoverName()));
        }
        return level.isClientSide() ? InteractionResult.CONSUME : InteractionResult.SUCCESS_SERVER;
    }
}