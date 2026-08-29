package com.danako.practical_additions.datagen.tags;

import com.danako.practical_additions.PracticalAdditions;
import com.danako.practical_additions.init.PABlocks;
import com.danako.practical_additions.init.PATags;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;

import java.util.concurrent.CompletableFuture;

public class PABlockTagsProvider extends BlockTagsProvider {

    public PABlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, PracticalAdditions.MODID);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        addHarvestLevelTags();
        addVanillaTags();
        addNeoForgeConventionTags();
        addToolTierTags();
    }

    private void addHarvestLevelTags() {
        tag(BlockTags.MINEABLE_WITH_PICKAXE).add(PABlocks.LEAD_ORE.get()).add(PABlocks.DEEPSLATE_LEAD_ORE.get()).add(PABlocks.RAW_LEAD_BLOCK.get()).add(PABlocks.DENSE_WEIGHTED_PRESSURE_PLATE.get()).add(PABlocks.LEAD_BLOCK.get()).add(PABlocks.COBALT_ORE.get()).add(PABlocks.DEEPSLATE_COBALT_ORE.get()).add(PABlocks.RAW_COBALT_BLOCK.get()).add(PABlocks.COBALT_BLOCK.get());

        tag(BlockTags.NEEDS_STONE_TOOL).add(PABlocks.LEAD_ORE.get()).add(PABlocks.DEEPSLATE_LEAD_ORE.get()).add(PABlocks.RAW_LEAD_BLOCK.get()).add(PABlocks.LEAD_BLOCK.get());
        tag(BlockTags.NEEDS_IRON_TOOL).add(PABlocks.COBALT_ORE.get()).add(PABlocks.DEEPSLATE_COBALT_ORE.get()).add(PABlocks.RAW_COBALT_BLOCK.get()).add(PABlocks.COBALT_BLOCK.get());
    }

    private void addVanillaTags() {
        tag(BlockTags.BEACON_BASE_BLOCKS).add(PABlocks.LEAD_BLOCK.get());
        tag(BlockTags.WALL_POST_OVERRIDE).add(PABlocks.DENSE_WEIGHTED_PRESSURE_PLATE.get());
    }

    private void addNeoForgeConventionTags() {
        tag(commonTag("ores/lead")).add(PABlocks.LEAD_ORE.get()).add(PABlocks.DEEPSLATE_LEAD_ORE.get());
        tag(commonTag("storage_blocks/lead")).add(PABlocks.LEAD_BLOCK.get());
        tag(commonTag("storage_blocks/raw_lead")).add(PABlocks.RAW_LEAD_BLOCK.get());

        tag(commonTag("ores/cobalt")).add(PABlocks.COBALT_ORE.get()).add(PABlocks.DEEPSLATE_COBALT_ORE.get());
        tag(commonTag("storage_blocks/cobalt")).add(PABlocks.COBALT_BLOCK.get());
        tag(commonTag("storage_blocks/raw_cobalt")).add(PABlocks.RAW_COBALT_BLOCK.get());

        tag(Tags.Blocks.ORES).addTag(commonTag("ores/lead")).addTag(commonTag("ores/cobalt"));
        tag(Tags.Blocks.ORES_IN_GROUND_STONE).add(PABlocks.LEAD_ORE.get()).add(PABlocks.COBALT_ORE.get());
        tag(Tags.Blocks.ORES_IN_GROUND_DEEPSLATE).add(PABlocks.DEEPSLATE_LEAD_ORE.get()).add(PABlocks.DEEPSLATE_COBALT_ORE.get());
        tag(Tags.Blocks.STORAGE_BLOCKS).addTag(commonTag("storage_blocks/lead")).addTag(commonTag("storage_blocks/raw_lead")).addTag(commonTag("storage_blocks/cobalt")).addTag(commonTag("storage_blocks/raw_cobalt"));

        tag(Tags.Blocks.ORE_RATES_SINGULAR).add(PABlocks.LEAD_ORE.get()).add(PABlocks.DEEPSLATE_LEAD_ORE.get()).add(PABlocks.COBALT_ORE.get()).add(PABlocks.DEEPSLATE_COBALT_ORE.get());
    }

    private void addToolTierTags() {

        tag(PATags.Blocks.INCORRECT_FOR_LEAD_TOOL).addTag(BlockTags.NEEDS_IRON_TOOL).addTag(BlockTags.NEEDS_DIAMOND_TOOL);


        tag(PATags.Blocks.INCORRECT_FOR_COBALT_TOOL).addTag(BlockTags.NEEDS_DIAMOND_TOOL);

        tag(PATags.Blocks.INCORRECT_FOR_EMERALD_TOOL).addTag(BlockTags.INCORRECT_FOR_DIAMOND_TOOL);
    }

    private static TagKey<Block> commonTag(String path) {
        return TagKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath("c", path));
    }
}