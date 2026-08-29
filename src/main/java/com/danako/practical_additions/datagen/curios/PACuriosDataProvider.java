package com.danako.practical_additions.datagen.curios;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import top.theillusivec4.curios.api.CuriosDataProvider;

import java.util.concurrent.CompletableFuture;

public class PACuriosDataProvider extends CuriosDataProvider {

    public PACuriosDataProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super("practical_additions", output, registries);
    }

    @Override
    public void generate(HolderLookup.Provider registries) {
        createEntities("player_curio_slot").addPlayer().addSlots("curio", "back", "belt");
    }
}