package com.danako.practical_additions.common.item.blunt;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.component.Consumables;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;

import java.util.List;

public class BluntItem extends Item {

    public static final FoodProperties BLUNT_FOOD = new FoodProperties.Builder()
            .nutrition(2)
            .saturationModifier(0.3F)
            .alwaysEdible()
            .build();

    public static final Consumable BLUNT_CONSUMABLE = Consumables.defaultFood()
            .onConsume(new ApplyStatusEffectsConsumeEffect(
                    List.of(
                            new MobEffectInstance(MobEffects.REGENERATION, 200, 1),
                            new MobEffectInstance(MobEffects.NAUSEA, 600, 0)
                    )
            ))
            .build();

    public BluntItem(Item.Properties properties) {
        super(properties.food(BLUNT_FOOD, BLUNT_CONSUMABLE));
    }
}
