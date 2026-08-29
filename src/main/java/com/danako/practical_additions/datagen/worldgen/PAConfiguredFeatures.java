package com.danako.practical_additions.datagen.worldgen;

import com.danako.practical_additions.PracticalAdditions;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;


public class PAConfiguredFeatures {

    public static final ResourceKey<ConfiguredFeature<?, ?>> LEAD_ORE = registerKey("lead_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> COBALT_ORE = registerKey("cobalt_ore");

    private static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, Identifier.fromNamespaceAndPath(PracticalAdditions.MODID, name));
    }
}