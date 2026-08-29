package com.danako.practical_additions.common.item.cobalt_bow;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.List;

public class CobaltBowItem extends BowItem {

    public static final float DRAW_TICKS = 10.0F;

    public CobaltBowItem(Item.Properties properties) {
        super(properties);
    }

    public static float getPowerForTimeFast(int charge) {
        float f = charge / DRAW_TICKS;
        f = (f * f + f * 2.0F) / 3.0F;
        return Math.min(f, 1.0F);
    }

    @Override
    public boolean releaseUsing(ItemStack stack, Level level, LivingEntity livingEntity, int timeLeft) {
        if (!(livingEntity instanceof Player player)) {
            return false;
        }

        ItemStack projectileStack = player.getProjectile(stack);
        if (projectileStack.isEmpty()) {
            return false;
        }

        int chargeTicks = this.getUseDuration(stack, livingEntity) - timeLeft;
        chargeTicks = net.neoforged.neoforge.event.EventHooks.onArrowLoose(stack, level, player, chargeTicks, !projectileStack.isEmpty());
        if (chargeTicks < 0) {
            return false;
        }

        float power = getPowerForTimeFast(chargeTicks);
        if (power < 0.1F) {
            return false;
        }

        List<ItemStack> projectiles = draw(stack, projectileStack, player);
        if (level instanceof ServerLevel serverLevel && !projectiles.isEmpty()) {
            this.shoot(serverLevel, player, player.getUsedItemHand(), stack, projectiles, power * 3.0F, 1.0F, power == 1.0F, null);
        }

        level.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.ARROW_SHOOT, SoundSource.PLAYERS, 1.0F, 1.0F / (level.getRandom().nextFloat() * 0.4F + 1.2F) + power * 0.5F);
        player.awardStat(Stats.ITEM_USED.get(this));
        return true;
    }
}