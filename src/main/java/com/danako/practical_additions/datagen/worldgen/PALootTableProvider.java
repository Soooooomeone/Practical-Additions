package com.danako.practical_additions.datagen.worldgen;

import com.danako.practical_additions.datagen.misc.PABlockLootSubProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;


public class PALootTableProvider extends LootTableProvider {

    public PALootTableProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output,

                Set.of(), List.of(new LootTableProvider.SubProviderEntry(PABlockLootSubProvider::new, LootContextParamSets.BLOCK)), lookupProvider);
    }
}
