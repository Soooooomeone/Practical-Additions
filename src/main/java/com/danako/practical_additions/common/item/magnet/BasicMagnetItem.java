package com.danako.practical_additions.common.item.magnet;

import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class BasicMagnetItem extends MagnetItem {

    private static final double RADIUS = 6.0D;
    private static final double PULL_STRENGTH = 0.18D;
    private static final double MIN_FALLOFF = 0.35D;

    public BasicMagnetItem(Properties props) {
        super(props);
    }

    @Override
    protected double getRadius() {
        return RADIUS;
    }

    @Override
    protected void collectItem(Player player, ItemEntity entity, ItemStack magnetStack, Level level) {
        Vec3 targetPoint = player.position().add(0, player.getBbHeight() * 0.5D, 0);
        Vec3 toPlayer = targetPoint.subtract(entity.position());
        double distance = toPlayer.length();
        if (distance < 0.15D) {
            return;
        }

        double falloff = Math.max(MIN_FALLOFF, 1.0D - (distance / RADIUS));
        Vec3 pull = toPlayer.normalize().scale(PULL_STRENGTH * falloff);

        entity.setDeltaMovement(entity.getDeltaMovement().add(pull));
        entity.hurtMarked = true;
    }

    @Override
    protected void collectExperienceOrb(Player player, ExperienceOrb orb, ItemStack magnetStack, Level level) {
        Vec3 targetPoint = player.position().add(0, player.getBbHeight() * 0.5D, 0);
        Vec3 toPlayer = targetPoint.subtract(orb.position());
        double distance = toPlayer.length();
        if (distance < 0.15D) {
            return;
        }

        double falloff = Math.max(MIN_FALLOFF, 1.0D - (distance / RADIUS));
        Vec3 pull = toPlayer.normalize().scale(PULL_STRENGTH * falloff);

        orb.setDeltaMovement(orb.getDeltaMovement().add(pull));
        orb.hurtMarked = true;
    }
}