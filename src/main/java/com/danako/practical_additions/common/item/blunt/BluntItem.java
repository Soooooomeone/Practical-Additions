package com.danako.practical_additions.common.item.blunt;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;

import java.util.function.Supplier;

public class BluntItem extends Item {

    public static final FoodProperties BLUNT_FOOD = new FoodProperties.Builder()
            .nutrition(2)
            .saturationModifier(0.3F)
            .alwaysEdible()
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 200, 1), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 600, 0), 1.0F)
            .build();

    public BluntItem(Item.Properties properties) {
        super(properties.food(BLUNT_FOOD));
    }
}
