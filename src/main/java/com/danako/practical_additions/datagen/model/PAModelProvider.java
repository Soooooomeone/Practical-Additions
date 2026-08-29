package com.danako.practical_additions.datagen.model;

import com.danako.practical_additions.PracticalAdditions;
import com.google.gson.JsonObject;
import com.google.gson.JsonArray;
import com.danako.practical_additions.client.item.kevlar_shield.KevlarShieldSpecialRenderer;
import com.danako.practical_additions.init.PABlocks;
import com.danako.practical_additions.init.PAItems;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.model.ItemModelUtils;
import net.minecraft.client.data.models.model.ModelLocationUtils;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.renderer.item.ItemModel;
import net.minecraft.client.renderer.item.SpecialModelWrapper;
import net.minecraft.client.renderer.item.properties.numeric.UseDuration;
import net.minecraft.client.renderer.item.properties.select.DisplayContext;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemDisplayContext;


public class PAModelProvider extends ModelProvider {

    public PAModelProvider(PackOutput output) {
        super(output, PracticalAdditions.MODID);
    }

    @Override
    protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {
        registerBlockModels(blockModels);
        registerItemModels(itemModels);
    }

    private void registerBlockModels(BlockModelGenerators blockModels) {

        blockModels.createTrivialCube(PABlocks.LEAD_ORE.get());
        blockModels.createTrivialCube(PABlocks.DEEPSLATE_LEAD_ORE.get());
        blockModels.createTrivialCube(PABlocks.RAW_LEAD_BLOCK.get());
        blockModels.createTrivialCube(PABlocks.LEAD_BLOCK.get());
        blockModels.createWeightedPressurePlate(PABlocks.DENSE_WEIGHTED_PRESSURE_PLATE.get(), PABlocks.LEAD_BLOCK.get());
        blockModels.createTrivialCube(PABlocks.COBALT_ORE.get());
        blockModels.createTrivialCube(PABlocks.DEEPSLATE_COBALT_ORE.get());
        blockModels.createTrivialCube(PABlocks.RAW_COBALT_BLOCK.get());
        blockModels.createTrivialCube(PABlocks.COBALT_BLOCK.get());
    }

    private void registerItemModels(ItemModelGenerators itemModels) {
        itemModels.generateFlatItem(PAItems.LEAD_INGOT.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(PAItems.RAW_LEAD.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(PAItems.LEAD_NUGGET.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(PAItems.COBALT_INGOT.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(PAItems.RAW_COBALT.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(PAItems.COBALT_NUGGET.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(PAItems.LEAD_SWORD.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(PAItems.LEAD_PICKAXE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(PAItems.LEAD_AXE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(PAItems.LEAD_SHOVEL.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(PAItems.LEAD_HOE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(PAItems.COBALT_SWORD.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(PAItems.COBALT_PICKAXE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(PAItems.COBALT_AXE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(PAItems.COBALT_SHOVEL.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(PAItems.COBALT_HOE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        registerSpearModel(itemModels, PAItems.LEAD_SPEAR.get());
        registerSpearModel(itemModels, PAItems.COBALT_SPEAR.get());
        itemModels.generateFlatItem(PAItems.LEAD_HELMET.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(PAItems.LEAD_CHESTPLATE.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(PAItems.LEAD_LEGGINGS.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(PAItems.LEAD_BOOTS.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(PAItems.LEAD_DIVING_BELT.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(PAItems.COBALT_HELMET.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(PAItems.COBALT_CHESTPLATE.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(PAItems.COBALT_LEGGINGS.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(PAItems.COBALT_BOOTS.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(PAItems.LEAD_HORSE_ARMOR.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(PAItems.LEAD_NAUTILUS_ARMOR.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(PAItems.COBALT_HORSE_ARMOR.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(PAItems.COBALT_NAUTILUS_ARMOR.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(PAItems.GOLDEN_HAMMER.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(PAItems.COPPER_HAMMER.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(PAItems.LEAD_HAMMER.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(PAItems.IRON_HAMMER.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(PAItems.COBALT_HAMMER.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(PAItems.DIAMOND_HAMMER.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(PAItems.NETHERITE_HAMMER.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(PAItems.GOLDEN_EXCAVATOR.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(PAItems.COPPER_EXCAVATOR.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(PAItems.LEAD_EXCAVATOR.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(PAItems.IRON_EXCAVATOR.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(PAItems.COBALT_EXCAVATOR.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(PAItems.DIAMOND_EXCAVATOR.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(PAItems.NETHERITE_EXCAVATOR.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(PAItems.GOLDEN_SICKLE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(PAItems.COPPER_SICKLE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(PAItems.LEAD_SICKLE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(PAItems.IRON_SICKLE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(PAItems.COBALT_SICKLE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(PAItems.DIAMOND_SICKLE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(PAItems.NETHERITE_SICKLE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(PAItems.EMERALD_SWORD.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(PAItems.EMERALD_PICKAXE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(PAItems.EMERALD_AXE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(PAItems.EMERALD_SHOVEL.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(PAItems.EMERALD_HOE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        registerSpearModel(itemModels, PAItems.EMERALD_SPEAR.get());
        itemModels.generateFlatItem(PAItems.EMERALD_HELMET.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(PAItems.EMERALD_CHESTPLATE.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(PAItems.EMERALD_LEGGINGS.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(PAItems.EMERALD_BOOTS.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(PAItems.EMERALD_HORSE_ARMOR.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(PAItems.EMERALD_NAUTILUS_ARMOR.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(PAItems.EMERALD_HAMMER.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(PAItems.EMERALD_EXCAVATOR.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(PAItems.EMERALD_SICKLE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(PAItems.LAPIS_SWORD.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(PAItems.LAPIS_PICKAXE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(PAItems.LAPIS_AXE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(PAItems.LAPIS_SHOVEL.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(PAItems.LAPIS_HOE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        registerSpearModel(itemModels, PAItems.LAPIS_SPEAR.get());
        itemModels.generateFlatItem(PAItems.LAPIS_HELMET.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(PAItems.LAPIS_CHESTPLATE.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(PAItems.LAPIS_LEGGINGS.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(PAItems.LAPIS_BOOTS.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(PAItems.LAPIS_HAMMER.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(PAItems.LAPIS_EXCAVATOR.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(PAItems.LAPIS_SICKLE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(PAItems.REDSTONE_SWORD.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(PAItems.REDSTONE_PICKAXE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(PAItems.REDSTONE_AXE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(PAItems.REDSTONE_SHOVEL.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(PAItems.REDSTONE_HOE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        registerSpearModel(itemModels, PAItems.REDSTONE_SPEAR.get());
        itemModels.generateFlatItem(PAItems.REDSTONE_HELMET.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(PAItems.REDSTONE_CHESTPLATE.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(PAItems.REDSTONE_LEGGINGS.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(PAItems.REDSTONE_BOOTS.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(PAItems.REDSTONE_HAMMER.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(PAItems.REDSTONE_EXCAVATOR.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(PAItems.REDSTONE_SICKLE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(PAItems.BASIC_MAGNET.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(PAItems.ADVANCED_MAGNET.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(PAItems.KEVLAR_FIBER.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(PAItems.KEVLAR_SHEET.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(PAItems.BALLISTIC_HELMET.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(PAItems.KEVLAR_VEST.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(PAItems.KEVLAR_PANTS.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(PAItems.KEVLAR_BOOTS.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(PAItems.BASIC_BACKPACK.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(PAItems.REINFORCED_BACKPACK.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(PAItems.BASIC_QUIVER.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(PAItems.REINFORCED_QUIVER.get(), ModelTemplates.FLAT_ITEM);
        registerShieldModel(itemModels, PAItems.KEVLAR_SHIELD.get());

        registerCobaltBowModel(itemModels);
    }

    private void registerCobaltBowModel(ItemModelGenerators itemModels) {
        Item bowItem = PAItems.COBALT_BOW.get();
        Identifier idleModelId = ModelLocationUtils.getModelLocation(bowItem);
        Identifier texture = TextureMapping.getItemTexture(bowItem);

        itemModels.modelOutput.accept(idleModelId, () -> {
            JsonObject json = new JsonObject();
            json.addProperty("parent", "item/generated");

            JsonObject textures = new JsonObject();
            textures.addProperty("layer0", texture.toString());
            json.add("textures", textures);

            JsonObject display = new JsonObject();
            display.add("thirdperson_righthand", displayEntry(new float[]{-80, 260, -40}, new float[]{-1, -2, 2.5f}, new float[]{0.9f, 0.9f, 0.9f}));
            display.add("thirdperson_lefthand", displayEntry(new float[]{-80, -280, 40}, new float[]{-1, -2, 2.5f}, new float[]{0.9f, 0.9f, 0.9f}));
            display.add("firstperson_righthand", displayEntry(new float[]{0, -90, 25}, new float[]{1.13f, 3.2f, 1.13f}, new float[]{0.68f, 0.68f, 0.68f}));
            display.add("firstperson_lefthand", displayEntry(new float[]{0, 90, -25}, new float[]{1.13f, 3.2f, 1.13f}, new float[]{0.68f, 0.68f, 0.68f}));
            json.add("display", display);

            return json;
        });

        ItemModel.Unbaked idleModel = ItemModelUtils.plainModel(idleModelId);
        ItemModel.Unbaked pulling0 = ItemModelUtils.plainModel(itemModels.createFlatItemModel(bowItem, "_pulling_0", ModelTemplates.BOW));
        ItemModel.Unbaked pulling1 = ItemModelUtils.plainModel(itemModels.createFlatItemModel(bowItem, "_pulling_1", ModelTemplates.BOW));
        ItemModel.Unbaked pulling2 = ItemModelUtils.plainModel(itemModels.createFlatItemModel(bowItem, "_pulling_2", ModelTemplates.BOW));

        itemModels.itemModelOutput.accept(bowItem, ItemModelUtils.conditional(ItemModelUtils.isUsingItem(), ItemModelUtils.rangeSelect(new UseDuration(false), 0.1F, pulling0, ItemModelUtils.override(pulling1, 0.65F), ItemModelUtils.override(pulling2, 0.9F)), idleModel));
    }

    private JsonObject displayEntry(float[] rotation, float[] translation, float[] scale) {
        JsonObject obj = new JsonObject();
        obj.add("rotation", toArray(rotation));
        obj.add("translation", toArray(translation));
        obj.add("scale", toArray(scale));
        return obj;
    }

    private JsonArray toArray(float[] values) {
        JsonArray arr = new JsonArray();
        for (float v : values) arr.add(v);
        return arr;
    }

    private void registerShieldModel(ItemModelGenerators itemModels, Item shieldItem) {
        Identifier particle = Identifier.fromNamespaceAndPath("minecraft", "block/dark_oak_planks");

        Identifier idleModelId = Identifier.fromNamespaceAndPath(PracticalAdditions.MODID, "item/kevlar_shield");
        Identifier blockingModelId = Identifier.fromNamespaceAndPath(PracticalAdditions.MODID, "item/kevlar_shield_blocking");

        ShieldDisplayModel idleModel = ShieldDisplayModel.builder(particle).add("thirdperson_righthand", new float[]{0, 90, 0}, new float[]{10, 6, -4}, new float[]{1, 1, 1}).add("thirdperson_lefthand", new float[]{0, 90, 0}, new float[]{10, 6, 12}, new float[]{1, 1, 1}).add("firstperson_righthand", new float[]{0, 180, 5}, new float[]{-10, 2, -10}, new float[]{1.25f, 1.25f, 1.25f}).add("firstperson_lefthand", new float[]{0, 180, 5}, new float[]{10, 0, -10}, new float[]{1.25f, 1.25f, 1.25f}).add("gui", new float[]{15, -25, -5}, new float[]{2, 3, 0}, new float[]{0.65f, 0.65f, 0.65f}).add("fixed", new float[]{0, 180, 0}, new float[]{-4.5f, 4.5f, -5}, new float[]{0.55f, 0.55f, 0.55f}).add("ground", new float[]{0, 0, 0}, new float[]{2, 4, 2}, new float[]{0.25f, 0.25f, 0.25f}).build();

        ShieldDisplayModel blockingModel = ShieldDisplayModel.builder(particle).add("thirdperson_righthand", new float[]{45, 155, 0}, new float[]{-3.49f, 11, -2}, new float[]{1, 1, 1}).add("thirdperson_lefthand", new float[]{45, 155, 0}, new float[]{11.51f, 7, 2.5f}, new float[]{1, 1, 1}).add("firstperson_righthand", new float[]{0, 180, -5}, new float[]{-15, 5, -11}, new float[]{1.25f, 1.25f, 1.25f}).add("firstperson_lefthand", new float[]{0, 180, -5}, new float[]{5, 5, -11}, new float[]{1.25f, 1.25f, 1.25f}).add("gui", new float[]{15, -25, -5}, new float[]{2, 3, 0}, new float[]{0.65f, 0.65f, 0.65f}).build();

        itemModels.modelOutput.accept(idleModelId, idleModel);
        itemModels.modelOutput.accept(blockingModelId, blockingModel);

        ItemModel.Unbaked idleWrapped = new SpecialModelWrapper.Unbaked(idleModelId, new KevlarShieldSpecialRenderer.Unbaked());
        ItemModel.Unbaked blockingWrapped = new SpecialModelWrapper.Unbaked(blockingModelId, new KevlarShieldSpecialRenderer.Unbaked());

        itemModels.itemModelOutput.accept(shieldItem, ItemModelUtils.conditional(ItemModelUtils.isUsingItem(), blockingWrapped, idleWrapped));
    }

    private void registerSpearModel(ItemModelGenerators itemModels, Item spearItem) {
        ItemModel.Unbaked guiModel = ItemModelUtils.plainModel(itemModels.createFlatItemModel(spearItem, ModelTemplates.FLAT_HANDHELD_ITEM));

        ItemModel.Unbaked inHandModel = ItemModelUtils.plainModel(itemModels.createFlatItemModel(spearItem, "_in_hand", ModelTemplates.SPEAR_IN_HAND));

        itemModels.itemModelOutput.accept(spearItem, ItemModelUtils.select(new DisplayContext(), ItemModelUtils.when(ItemDisplayContext.FIRST_PERSON_RIGHT_HAND, inHandModel), ItemModelUtils.when(ItemDisplayContext.FIRST_PERSON_LEFT_HAND, inHandModel), ItemModelUtils.when(ItemDisplayContext.THIRD_PERSON_RIGHT_HAND, inHandModel), ItemModelUtils.when(ItemDisplayContext.THIRD_PERSON_LEFT_HAND, inHandModel), ItemModelUtils.when(ItemDisplayContext.GUI, guiModel), ItemModelUtils.when(ItemDisplayContext.GROUND, guiModel), ItemModelUtils.when(ItemDisplayContext.FIXED, guiModel), ItemModelUtils.when(ItemDisplayContext.HEAD, guiModel), ItemModelUtils.when(ItemDisplayContext.NONE, guiModel)));
    }
}