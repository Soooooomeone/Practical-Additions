package com.danako.practical_additions.datagen.misc;

import com.danako.practical_additions.PracticalAdditions;
import com.danako.practical_additions.init.PABlocks;
import com.danako.practical_additions.init.PAItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;

import java.util.Set;

public class PABlockLootSubProvider extends BlockLootSubProvider {

    public PABlockLootSubProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.DEFAULT_FLAGS, registries);
    }

    @Override
    protected void generate() {

        add(PABlocks.LEAD_ORE.get(), block -> createOreDrop(block, PAItems.RAW_LEAD.get()));
        add(PABlocks.DEEPSLATE_LEAD_ORE.get(), block -> createOreDrop(block, PAItems.RAW_LEAD.get()));
        add(PABlocks.COBALT_ORE.get(), block -> createOreDrop(block, PAItems.RAW_COBALT.get()));
        add(PABlocks.DEEPSLATE_COBALT_ORE.get(), block -> createOreDrop(block, PAItems.RAW_COBALT.get()));
        dropSelf(PABlocks.RAW_LEAD_BLOCK.get());
        dropSelf(PABlocks.DENSE_WEIGHTED_PRESSURE_PLATE.get());
        dropSelf(PABlocks.LEAD_BLOCK.get());
        dropSelf(PABlocks.RAW_COBALT_BLOCK.get());
        dropSelf(PABlocks.COBALT_BLOCK.get());
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return PracticalAdditions.BLOCKS.getEntries().stream().map(holder -> (Block) holder.get()) // Explicitly cast to Block to satisfy Iterable<Block>
                .toList();
    }
}