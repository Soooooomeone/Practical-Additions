package com.danako.practical_additions.init;

import com.danako.practical_additions.PracticalAdditions;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class PATags {

    public static class Items {

        public static final TagKey<Item> INGOTS_LEAD = TagKey.create(BuiltInRegistries.ITEM.key(), Identifier.fromNamespaceAndPath("c", "ingots/lead"));

        public static final TagKey<Item> REPAIRS_LEAD_ARMOR = TagKey.create(BuiltInRegistries.ITEM.key(), Identifier.fromNamespaceAndPath(PracticalAdditions.MODID, "repairs_lead_armor"));

        public static final TagKey<Item> LEAD_TOOL_MATERIALS = TagKey.create(BuiltInRegistries.ITEM.key(), Identifier.fromNamespaceAndPath(PracticalAdditions.MODID, "lead_tool_materials"));

        public static final TagKey<Item> INGOTS_COBALT = TagKey.create(BuiltInRegistries.ITEM.key(), Identifier.fromNamespaceAndPath("c", "ingots/cobalt"));

        public static final TagKey<Item> REPAIRS_COBALT_ARMOR = TagKey.create(BuiltInRegistries.ITEM.key(), Identifier.fromNamespaceAndPath(PracticalAdditions.MODID, "repairs_cobalt_armor"));

        public static final TagKey<Item> COBALT_TOOL_MATERIALS = TagKey.create(BuiltInRegistries.ITEM.key(), Identifier.fromNamespaceAndPath(PracticalAdditions.MODID, "cobalt_tool_materials"));

        public static final TagKey<Item> REPAIRS_KEVLAR_ARMOR = TagKey.create(BuiltInRegistries.ITEM.key(), Identifier.fromNamespaceAndPath(PracticalAdditions.MODID, "repairs_kevlar_armor"));

        public static final TagKey<Item> REPAIRS_EMERALD_ARMOR = TagKey.create(BuiltInRegistries.ITEM.key(), Identifier.fromNamespaceAndPath(PracticalAdditions.MODID, "repairs_emerald_armor"));
        public static final TagKey<Item> EMERALD_TOOL_MATERIALS = TagKey.create(BuiltInRegistries.ITEM.key(), Identifier.fromNamespaceAndPath(PracticalAdditions.MODID, "emerald_tool_materials"));

        public static final TagKey<Item> REPAIRS_LAPIS_ARMOR = TagKey.create(BuiltInRegistries.ITEM.key(), Identifier.fromNamespaceAndPath(PracticalAdditions.MODID, "repairs_lapis_armor"));
        public static final TagKey<Item> LAPIS_TOOL_MATERIALS = TagKey.create(BuiltInRegistries.ITEM.key(), Identifier.fromNamespaceAndPath(PracticalAdditions.MODID, "lapis_tool_materials"));

        public static final TagKey<Item> REPAIRS_REDSTONE_ARMOR = TagKey.create(BuiltInRegistries.ITEM.key(), Identifier.fromNamespaceAndPath(PracticalAdditions.MODID, "repairs_redstone_armor"));
        public static final TagKey<Item> REDSTONE_TOOL_MATERIALS = TagKey.create(BuiltInRegistries.ITEM.key(), Identifier.fromNamespaceAndPath(PracticalAdditions.MODID, "redstone_tool_materials"));

        private Items() {
        }
    }


    public static class Blocks {
        public static final TagKey<Block> INCORRECT_FOR_LEAD_TOOL = TagKey.create(BuiltInRegistries.BLOCK.key(), Identifier.fromNamespaceAndPath(PracticalAdditions.MODID, "incorrect_for_lead_tool"));

        public static final TagKey<Block> INCORRECT_FOR_COBALT_TOOL = TagKey.create(BuiltInRegistries.BLOCK.key(), Identifier.fromNamespaceAndPath(PracticalAdditions.MODID, "incorrect_for_cobalt_tool"));

        public static final TagKey<Block> INCORRECT_FOR_EMERALD_TOOL = TagKey.create(BuiltInRegistries.BLOCK.key(), Identifier.fromNamespaceAndPath(PracticalAdditions.MODID, "incorrect_for_emerald_tool"));
        private Blocks() {
        }
    }

    private PATags() {
    }
}