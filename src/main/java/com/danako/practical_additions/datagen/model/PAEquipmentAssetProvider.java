package com.danako.practical_additions.datagen.model;

import com.danako.practical_additions.PracticalAdditions;
import com.danako.practical_additions.init.PAItems;
import net.minecraft.client.data.models.EquipmentAssetProvider;
import net.minecraft.client.resources.model.EquipmentClientInfo;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.equipment.EquipmentAsset;

import java.util.Optional;
import java.util.function.BiConsumer;


public class PAEquipmentAssetProvider extends EquipmentAssetProvider {

    public PAEquipmentAssetProvider(PackOutput output) {
        super(output);
    }

    @Override
    protected void registerModels(BiConsumer<ResourceKey<EquipmentAsset>, EquipmentClientInfo> output) {
        Identifier leadTexture = Identifier.fromNamespaceAndPath(PracticalAdditions.MODID, "lead");

        output.accept(PAItems.LEAD_ARMOR_ASSET, EquipmentClientInfo.builder()

                .addLayers(EquipmentClientInfo.LayerType.HUMANOID, new EquipmentClientInfo.Layer(leadTexture, Optional.empty(), false))

                .addLayers(EquipmentClientInfo.LayerType.HUMANOID_LEGGINGS, new EquipmentClientInfo.Layer(leadTexture, Optional.empty(), false))

                .addLayers(EquipmentClientInfo.LayerType.HORSE_BODY, new EquipmentClientInfo.Layer(leadTexture, Optional.empty(), false))

                .addLayers(EquipmentClientInfo.LayerType.NAUTILUS_BODY, new EquipmentClientInfo.Layer(leadTexture, Optional.empty(), false)).build());

        Identifier cobaltTexture = Identifier.fromNamespaceAndPath(PracticalAdditions.MODID, "cobalt");

        output.accept(PAItems.COBALT_ARMOR_ASSET, EquipmentClientInfo.builder().addLayers(EquipmentClientInfo.LayerType.HUMANOID, new EquipmentClientInfo.Layer(cobaltTexture, Optional.empty(), false)).addLayers(EquipmentClientInfo.LayerType.HUMANOID_LEGGINGS, new EquipmentClientInfo.Layer(cobaltTexture, Optional.empty(), false)).addLayers(EquipmentClientInfo.LayerType.HORSE_BODY, new EquipmentClientInfo.Layer(cobaltTexture, Optional.empty(), false)).addLayers(EquipmentClientInfo.LayerType.NAUTILUS_BODY, new EquipmentClientInfo.Layer(cobaltTexture, Optional.empty(), false)).build());

        Identifier kevlarTexture = Identifier.fromNamespaceAndPath(PracticalAdditions.MODID, "kevlar");

        output.accept(PAItems.KEVLAR_ARMOR_ASSET, EquipmentClientInfo.builder()

                .addLayers(EquipmentClientInfo.LayerType.HUMANOID, new EquipmentClientInfo.Layer(kevlarTexture, Optional.empty(), false))

                .addLayers(EquipmentClientInfo.LayerType.HUMANOID_LEGGINGS, new EquipmentClientInfo.Layer(kevlarTexture, Optional.empty(), false)).build());

        Identifier emeraldTexture = Identifier.fromNamespaceAndPath(PracticalAdditions.MODID, "emerald");

        output.accept(PAItems.EMERALD_ARMOR_ASSET, EquipmentClientInfo.builder().addLayers(EquipmentClientInfo.LayerType.HUMANOID, new EquipmentClientInfo.Layer(emeraldTexture, Optional.empty(), false)).addLayers(EquipmentClientInfo.LayerType.HUMANOID_LEGGINGS, new EquipmentClientInfo.Layer(emeraldTexture, Optional.empty(), false)).addLayers(EquipmentClientInfo.LayerType.HORSE_BODY, new EquipmentClientInfo.Layer(emeraldTexture, Optional.empty(), false)).addLayers(EquipmentClientInfo.LayerType.NAUTILUS_BODY, new EquipmentClientInfo.Layer(emeraldTexture, Optional.empty(), false)).build());

        Identifier lapisTexture = Identifier.fromNamespaceAndPath(PracticalAdditions.MODID, "lapis");

        output.accept(PAItems.LAPIS_ARMOR_ASSET, EquipmentClientInfo.builder().addLayers(EquipmentClientInfo.LayerType.HUMANOID, new EquipmentClientInfo.Layer(lapisTexture, Optional.empty(), false)).addLayers(EquipmentClientInfo.LayerType.HUMANOID_LEGGINGS, new EquipmentClientInfo.Layer(lapisTexture, Optional.empty(), false)).build());

        Identifier redstoneTexture = Identifier.fromNamespaceAndPath(PracticalAdditions.MODID, "redstone");

        output.accept(PAItems.REDSTONE_ARMOR_ASSET, EquipmentClientInfo.builder().addLayers(EquipmentClientInfo.LayerType.HUMANOID, new EquipmentClientInfo.Layer(redstoneTexture, Optional.empty(), false)).addLayers(EquipmentClientInfo.LayerType.HUMANOID_LEGGINGS, new EquipmentClientInfo.Layer(redstoneTexture, Optional.empty(), false)).build());
    }
}