package com.danako.practical_additions.datagen.worldgen;

import com.danako.practical_additions.PracticalAdditions;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;


public class PAPlacedFeatures {

    public static final ResourceKey<PlacedFeature> LEAD_ORE_PLACED = registerKey("lead_ore_placed");
    public static final ResourceKey<PlacedFeature> COBALT_ORE_PLACED = registerKey("cobalt_ore_placed");
    public static final ResourceKey<PlacedFeature> WEED_CROP_PLACED = registerKey("weed_crop_placed");

    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, Identifier.fromNamespaceAndPath(PracticalAdditions.MODID, name));
    }
}