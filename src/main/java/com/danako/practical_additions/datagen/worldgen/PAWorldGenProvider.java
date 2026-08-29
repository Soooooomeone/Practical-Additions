package com.danako.practical_additions.datagen.worldgen;

import com.danako.practical_additions.init.PABlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.tags.BiomeTags;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.minecraft.world.level.material.Fluids;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.common.world.BiomeModifiers;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.List;

public class PAWorldGenProvider {

    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder().add(Registries.CONFIGURED_FEATURE, PAWorldGenProvider::registerConfiguredFeatures).add(Registries.PLACED_FEATURE, PAWorldGenProvider::registerPlacedFeatures).add(NeoForgeRegistries.Keys.BIOME_MODIFIERS, PAWorldGenProvider::registerBiomeModifiers);

    private static void registerConfiguredFeatures(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        context.register(PAConfiguredFeatures.LEAD_ORE, new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(List.of(OreConfiguration.target(new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES), PABlocks.LEAD_ORE.get().defaultBlockState()), OreConfiguration.target(new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES), PABlocks.DEEPSLATE_LEAD_ORE.get().defaultBlockState())), 9)));

        context.register(PAConfiguredFeatures.COBALT_ORE, new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(List.of(OreConfiguration.target(new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES), PABlocks.COBALT_ORE.get().defaultBlockState()), OreConfiguration.target(new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES), PABlocks.DEEPSLATE_COBALT_ORE.get().defaultBlockState())), 10)));
    }


    private static BlockPredicate waterAdjacent() {
        return BlockPredicate.anyOf(BlockPredicate.matchesFluids(new BlockPos(1, 0, 0), Fluids.WATER), BlockPredicate.matchesFluids(new BlockPos(-1, 0, 0), Fluids.WATER), BlockPredicate.matchesFluids(new BlockPos(0, 1, 0), Fluids.WATER), BlockPredicate.matchesFluids(new BlockPos(0, -1, 0), Fluids.WATER), BlockPredicate.matchesFluids(new BlockPos(0, 0, 1), Fluids.WATER), BlockPredicate.matchesFluids(new BlockPos(0, 0, -1), Fluids.WATER));
    }

    private static void registerPlacedFeatures(BootstrapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        List<PlacementModifier> placement = List.of(CountPlacement.of(8), InSquarePlacement.spread(), HeightRangePlacement.triangle(VerticalAnchor.absolute(-24), VerticalAnchor.absolute(56)), BiomeFilter.biome());

        context.register(PAPlacedFeatures.LEAD_ORE_PLACED, new PlacedFeature(configuredFeatures.getOrThrow(PAConfiguredFeatures.LEAD_ORE), placement));

        List<PlacementModifier> cobaltPlacement = List.of(CountPlacement.of(24), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(40)), BlockPredicateFilter.forPredicate(waterAdjacent()), BiomeFilter.biome());

        context.register(PAPlacedFeatures.COBALT_ORE_PLACED, new PlacedFeature(configuredFeatures.getOrThrow(PAConfiguredFeatures.COBALT_ORE), cobaltPlacement));
    }

    private static void registerBiomeModifiers(BootstrapContext<BiomeModifier> context) {
        HolderGetter<Biome> biomes = context.lookup(Registries.BIOME);
        HolderGetter<PlacedFeature> placedFeatures = context.lookup(Registries.PLACED_FEATURE);

        context.register(PABiomeModifiers.ADD_LEAD_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(biomes.getOrThrow(BiomeTags.IS_OVERWORLD), HolderSet.direct(placedFeatures.getOrThrow(PAPlacedFeatures.LEAD_ORE_PLACED)), GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(PABiomeModifiers.ADD_COBALT_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(biomes.getOrThrow(BiomeTags.IS_OVERWORLD), HolderSet.direct(placedFeatures.getOrThrow(PAPlacedFeatures.COBALT_ORE_PLACED)), GenerationStep.Decoration.UNDERGROUND_ORES));
    }
}