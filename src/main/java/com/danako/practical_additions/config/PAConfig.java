package com.danako.practical_additions.config;

import com.danako.practical_additions.PracticalAdditions;
import net.neoforged.neoforge.common.ModConfigSpec;

public class PAConfig {

    private static final ModConfigSpec.Builder COMMON_BUILDER = new ModConfigSpec.Builder();

    public static final ModConfigSpec.BooleanValue ENABLE_DEBUG_TOOLTIPS = COMMON_BUILDER
            .comment("If true, item tooltips will show a hint to press CTRL+SHIFT, and holding " +
                    "CTRL+SHIFT while hovering over an item will display extra debug information " +
                    "(registry name, and optionally tags and/or item properties, per the settings below).")
            .translation("config." + PracticalAdditions.MODID + ".enable_debug_tooltips")
            .define("enableDebugTooltips", true);

    public static final ModConfigSpec.BooleanValue SHOW_TAGS = COMMON_BUILDER
            .comment("If true (and debug tooltips are enabled), the CTRL+SHIFT debug info will include the item's tags.")
            .translation("config." + PracticalAdditions.MODID + ".show_tags")
            .define("showTags", true);

    public static final ModConfigSpec.BooleanValue SHOW_ITEM_PROPERTIES = COMMON_BUILDER
            .comment("If true (and debug tooltips are enabled), the CTRL+SHIFT debug info will include curated " +
                    "item/block properties (durability, enchantability, mining stats, block hardness, light level, " +
                    "etc), filtered by the Item Properties section below.")
            .translation("config." + PracticalAdditions.MODID + ".show_item_properties")
            .define("showItemProperties", true);

    public static final ModConfigSpec.BooleanValue SHOW_PROP_GENERAL;
    public static final ModConfigSpec.BooleanValue SHOW_PROP_ENCHANTABILITY;
    public static final ModConfigSpec.BooleanValue SHOW_PROP_COMBAT;
    public static final ModConfigSpec.BooleanValue SHOW_PROP_TOOL;
    public static final ModConfigSpec.BooleanValue SHOW_PROP_FOOD;
    public static final ModConfigSpec.BooleanValue SHOW_PROP_BLOCK;

    static {
        COMMON_BUILDER.push("itemProperties");
        COMMON_BUILDER.comment("Per-category toggles for the curated item/block properties shown in the CTRL+SHIFT debug tooltip. " +
                "Only used when showItemProperties is true.");

        SHOW_PROP_GENERAL = COMMON_BUILDER
                .comment("Show general properties: max stack size, rarity, durability, repair cost.")
                .translation("config." + PracticalAdditions.MODID + ".show_prop_general")
                .define("showPropGeneral", true);

        SHOW_PROP_ENCHANTABILITY = COMMON_BUILDER
                .comment("Show the item's enchantability value.")
                .translation("config." + PracticalAdditions.MODID + ".show_prop_enchantability")
                .define("showPropEnchantability", true);

        SHOW_PROP_COMBAT = COMMON_BUILDER
                .comment("Show attack damage and attack speed for weapons/tools that have them.")
                .translation("config." + PracticalAdditions.MODID + ".show_prop_combat")
                .define("showPropCombat", true);

        SHOW_PROP_TOOL = COMMON_BUILDER
                .comment("Show tool mining speed for items with tool behavior.")
                .translation("config." + PracticalAdditions.MODID + ".show_prop_tool")
                .define("showPropTool", true);

        SHOW_PROP_FOOD = COMMON_BUILDER
                .comment("Show food properties (nutrition, saturation) for edible items.")
                .translation("config." + PracticalAdditions.MODID + ".show_prop_food")
                .define("showPropFood", true);

        SHOW_PROP_BLOCK = COMMON_BUILDER
                .comment("For block items, show hardness, light emission, note block instrument, and whether it needs the correct tool.")
                .translation("config." + PracticalAdditions.MODID + ".show_prop_block")
                .define("showPropBlock", true);

        COMMON_BUILDER.pop();
    }

    public static final ModConfigSpec COMMON_SPEC = COMMON_BUILDER.build();
}