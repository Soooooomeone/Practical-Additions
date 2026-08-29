package com.danako.practical_additions.datagen.misc;

import com.danako.practical_additions.PracticalAdditions;
import com.danako.practical_additions.init.PABlocks;
import com.danako.practical_additions.init.PAItems;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class PALanguageProvider extends LanguageProvider {

    public PALanguageProvider(PackOutput output) {
        super(output, PracticalAdditions.MODID, "en_us");
    }

    @Override
    protected void addTranslations() {
        add("itemGroup." + PracticalAdditions.MODID, "Practical Additions");

        addBlock(PABlocks.LEAD_ORE, "Lead Ore");
        addBlock(PABlocks.DEEPSLATE_LEAD_ORE, "Deepslate Lead Ore");
        addBlock(PABlocks.RAW_LEAD_BLOCK, "Block of Raw Lead");
        addBlock(PABlocks.LEAD_BLOCK, "Block of Lead");
        addBlock(PABlocks.DENSE_WEIGHTED_PRESSURE_PLATE, "Dense Weighted Pressure Plate");

        addBlock(PABlocks.COBALT_ORE, "Cobalt Ore");
        addBlock(PABlocks.DEEPSLATE_COBALT_ORE, "Deepslate Cobalt Ore");
        addBlock(PABlocks.RAW_COBALT_BLOCK, "Block of Raw Cobalt");
        addBlock(PABlocks.COBALT_BLOCK, "Block of Cobalt");

        addItem(PAItems.LEAD_INGOT, "Lead Ingot");
        addItem(PAItems.RAW_LEAD, "Raw Lead");
        addItem(PAItems.LEAD_NUGGET, "Lead Nugget");

        addItem(PAItems.COBALT_INGOT, "Cobalt Ingot");
        addItem(PAItems.RAW_COBALT, "Raw Cobalt");
        addItem(PAItems.COBALT_NUGGET, "Cobalt Nugget");

        addItem(PAItems.LEAD_SWORD, "Lead Sword");
        addItem(PAItems.LEAD_SPEAR, "Lead Spear");
        addItem(PAItems.LEAD_PICKAXE, "Lead Pickaxe");
        addItem(PAItems.LEAD_AXE, "Lead Axe");
        addItem(PAItems.LEAD_SHOVEL, "Lead Shovel");
        addItem(PAItems.LEAD_HOE, "Lead Hoe");

        addItem(PAItems.COBALT_SWORD, "Cobalt Sword");
        addItem(PAItems.COBALT_SPEAR, "Cobalt Spear");
        addItem(PAItems.COBALT_BOW, "Cobalt Bow");
        addItem(PAItems.COBALT_PICKAXE, "Cobalt Pickaxe");
        addItem(PAItems.COBALT_AXE, "Cobalt Axe");
        addItem(PAItems.COBALT_SHOVEL, "Cobalt Shovel");
        addItem(PAItems.COBALT_HOE, "Cobalt Hoe");

        addItem(PAItems.LEAD_HELMET, "Lead Helmet");
        addItem(PAItems.LEAD_CHESTPLATE, "Lead Chestplate");
        addItem(PAItems.LEAD_LEGGINGS, "Lead Leggings");
        addItem(PAItems.LEAD_BOOTS, "Lead Boots");

        addItem(PAItems.COBALT_HELMET, "Cobalt Helmet");
        addItem(PAItems.COBALT_CHESTPLATE, "Cobalt Chestplate");
        addItem(PAItems.COBALT_LEGGINGS, "Cobalt Leggings");
        addItem(PAItems.COBALT_BOOTS, "Cobalt Boots");

        addItem(PAItems.LEAD_HORSE_ARMOR, "Lead Horse Armor");
        addItem(PAItems.LEAD_NAUTILUS_ARMOR, "Lead Nautilus Armor");

        addItem(PAItems.COBALT_HORSE_ARMOR, "Cobalt Horse Armor");
        addItem(PAItems.COBALT_NAUTILUS_ARMOR, "Cobalt Nautilus Armor");

        addItem(PAItems.GOLDEN_HAMMER, "Golden Hammer");
        addItem(PAItems.COPPER_HAMMER, "Copper Hammer");
        addItem(PAItems.LEAD_HAMMER, "Lead Hammer");
        addItem(PAItems.IRON_HAMMER, "Iron Hammer");
        addItem(PAItems.COBALT_HAMMER, "Cobalt Hammer");
        addItem(PAItems.DIAMOND_HAMMER, "Diamond Hammer");
        addItem(PAItems.NETHERITE_HAMMER, "Netherite Hammer");

        addItem(PAItems.GOLDEN_EXCAVATOR, "Golden Excavator");
        addItem(PAItems.COPPER_EXCAVATOR, "Copper Excavator");
        addItem(PAItems.LEAD_EXCAVATOR, "Lead Excavator");
        addItem(PAItems.IRON_EXCAVATOR, "Iron Excavator");
        addItem(PAItems.COBALT_EXCAVATOR, "Cobalt Excavator");
        addItem(PAItems.DIAMOND_EXCAVATOR, "Diamond Excavator");
        addItem(PAItems.NETHERITE_EXCAVATOR, "Netherite Excavator");

        addItem(PAItems.GOLDEN_SICKLE, "Golden Sickle");
        addItem(PAItems.COPPER_SICKLE, "Copper Sickle");
        addItem(PAItems.LEAD_SICKLE, "Lead Sickle");
        addItem(PAItems.IRON_SICKLE, "Iron Sickle");
        addItem(PAItems.COBALT_SICKLE, "Cobalt Sickle");
        addItem(PAItems.DIAMOND_SICKLE, "Diamond Sickle");
        addItem(PAItems.NETHERITE_SICKLE, "Netherite Sickle");

        addItem(PAItems.EMERALD_SWORD, "Emerald Sword");
        addItem(PAItems.EMERALD_SPEAR, "Emerald Spear");
        addItem(PAItems.EMERALD_PICKAXE, "Emerald Pickaxe");
        addItem(PAItems.EMERALD_AXE, "Emerald Axe");
        addItem(PAItems.EMERALD_SHOVEL, "Emerald Shovel");
        addItem(PAItems.EMERALD_HOE, "Emerald Hoe");
        addItem(PAItems.EMERALD_HELMET, "Emerald Helmet");
        addItem(PAItems.EMERALD_CHESTPLATE, "Emerald Chestplate");
        addItem(PAItems.EMERALD_LEGGINGS, "Emerald Leggings");
        addItem(PAItems.EMERALD_BOOTS, "Emerald Boots");
        addItem(PAItems.EMERALD_HORSE_ARMOR, "Emerald Horse Armor");
        addItem(PAItems.EMERALD_NAUTILUS_ARMOR, "Emerald Nautilus Armor");
        addItem(PAItems.EMERALD_HAMMER, "Emerald Hammer");
        addItem(PAItems.EMERALD_EXCAVATOR, "Emerald Excavator");
        addItem(PAItems.EMERALD_SICKLE, "Emerald Sickle");

        addItem(PAItems.LAPIS_SWORD, "Lapis Sword");
        addItem(PAItems.LAPIS_SPEAR, "Lapis Spear");
        addItem(PAItems.LAPIS_PICKAXE, "Lapis Pickaxe");
        addItem(PAItems.LAPIS_AXE, "Lapis Axe");
        addItem(PAItems.LAPIS_SHOVEL, "Lapis Shovel");
        addItem(PAItems.LAPIS_HOE, "Lapis Hoe");
        addItem(PAItems.LAPIS_HELMET, "Lapis Helmet");
        addItem(PAItems.LAPIS_CHESTPLATE, "Lapis Chestplate");
        addItem(PAItems.LAPIS_LEGGINGS, "Lapis Leggings");
        addItem(PAItems.LAPIS_BOOTS, "Lapis Boots");
        addItem(PAItems.LAPIS_HAMMER, "Lapis Hammer");
        addItem(PAItems.LAPIS_EXCAVATOR, "Lapis Excavator");
        addItem(PAItems.LAPIS_SICKLE, "Lapis Sickle");

        addItem(PAItems.REDSTONE_SWORD, "Redstone Sword");
        addItem(PAItems.REDSTONE_SPEAR, "Redstone Spear");
        addItem(PAItems.REDSTONE_PICKAXE, "Redstone Pickaxe");
        addItem(PAItems.REDSTONE_AXE, "Redstone Axe");
        addItem(PAItems.REDSTONE_SHOVEL, "Redstone Shovel");
        addItem(PAItems.REDSTONE_HOE, "Redstone Hoe");
        addItem(PAItems.REDSTONE_HELMET, "Redstone Helmet");
        addItem(PAItems.REDSTONE_CHESTPLATE, "Redstone Chestplate");
        addItem(PAItems.REDSTONE_LEGGINGS, "Redstone Leggings");
        addItem(PAItems.REDSTONE_BOOTS, "Redstone Boots");
        addItem(PAItems.REDSTONE_HAMMER, "Redstone Hammer");
        addItem(PAItems.REDSTONE_EXCAVATOR, "Redstone Excavator");
        addItem(PAItems.REDSTONE_SICKLE, "Redstone Sickle");

        addItem(PAItems.BASIC_MAGNET, "Basic Magnet");
        addItem(PAItems.ADVANCED_MAGNET, "Advanced Magnet");

        addItem(PAItems.KEVLAR_FIBER, "Kevlar Fiber");
        addItem(PAItems.KEVLAR_SHEET, "Kevlar Sheet");

        addItem(PAItems.BALLISTIC_HELMET, "Ballistic Helmet");
        addItem(PAItems.KEVLAR_VEST, "Kevlar Vest");
        addItem(PAItems.KEVLAR_PANTS, "Kevlar Pants");
        addItem(PAItems.KEVLAR_BOOTS, "Kevlar Boots");

        addItem(PAItems.BASIC_BACKPACK, "Basic Backpack");
        addItem(PAItems.REINFORCED_BACKPACK, "Reinforced Backpack");

        addItem(PAItems.BASIC_QUIVER, "Basic Quiver");
        addItem(PAItems.REINFORCED_QUIVER, "Reinforced Quiver");

        add("item.practical_additions.quiver.empty", "Empty");
        add("item.practical_additions.quiver.empty.description", "Can Hold Mixed Stacks Of Arrows");
        add("item.practical_additions.quiver.full", "Full");

        addItem(PAItems.KEVLAR_SHIELD, "Kevlar Shield");

        add("tooltip."  + PracticalAdditions.MODID + ".kevlar.projectile_protection", "Reduces damage from projectiles");

        add("tooltip."  + PracticalAdditions.MODID +  ".lead.weighted", "Lead Weighted");
        add("tooltip." + PracticalAdditions.MODID + ".cobalt.swim_speed", "Increases Swimming Speed");

        add("creativetab." + PracticalAdditions.MODID + ".practical_additions_tab", "Practical Additions");

        add("config." + PracticalAdditions.MODID + ".enable_debug_tooltips", "Enable Debug Tooltips");
        add("config." + PracticalAdditions.MODID + ".enable_debug_tooltips.tooltip", "When enabled, item tooltips show a hint to press CTRL+SHIFT. Holding CTRL+SHIFT while " + "hovering over an item displays extra debug info, per the settings below.");

        add("config." + PracticalAdditions.MODID + ".show_tags", "Show Tags");
        add("config." + PracticalAdditions.MODID + ".show_tags.tooltip", "Whether the CTRL+SHIFT debug info includes the item's tags.");

        add("config." + PracticalAdditions.MODID + ".show_item_stats", "Show Item Stats");
        add("config." + PracticalAdditions.MODID + ".show_item_stats.tooltip", "Whether the SHIFT+CTRL info includes key item stats (max stack size, enchantability, tool efficiency, etc).");

        add("tooltip.practical_additions.press_ctrl_shift", "Shift + Ctrl To Display Additional Information");
        add("key.category.practical_additions.main", "Practical Additions ");

        add(PracticalAdditions.MODID + ".configuration.itemProperties", "Item Properties");

        add("config." + PracticalAdditions.MODID + ".show_item_properties", "Show Item Properties");
        add("config." + PracticalAdditions.MODID + ".show_item_properties.tooltip", "Whether the CTRL+SHIFT debug info includes curated item/block properties.");

        add("config." + PracticalAdditions.MODID + ".show_prop_general", "General Properties");
        add("config." + PracticalAdditions.MODID + ".show_prop_general.tooltip", "Max stack size, rarity, durability, and repair cost.");

        add("config." + PracticalAdditions.MODID + ".show_prop_enchantability", "Enchantability");
        add("config." + PracticalAdditions.MODID + ".show_prop_enchantability.tooltip", "The item's enchantability value.");

        add("config." + PracticalAdditions.MODID + ".show_prop_combat", "Combat Stats");
        add("config." + PracticalAdditions.MODID + ".show_prop_combat.tooltip", "Attack damage and attack speed.");

        add("config." + PracticalAdditions.MODID + ".show_prop_tool", "Tool Stats");
        add("config." + PracticalAdditions.MODID + ".show_prop_tool.tooltip", "Mining speed for tools.");

        add("config." + PracticalAdditions.MODID + ".show_prop_food", "Food Properties");
        add("config." + PracticalAdditions.MODID + ".show_prop_food.tooltip", "Nutrition and saturation for edible items.");

        add("config." + PracticalAdditions.MODID + ".show_prop_block", "Block Properties");
        add("config." + PracticalAdditions.MODID + ".show_prop_block.tooltip", "Hardness, light level, note block instrument, and correct-tool requirement.");

        add("tooltip.practical_additions.properties", "Properties");
        add("tooltip.practical_additions.property.max_stack_size", "Max Stack Size");
        add("tooltip.practical_additions.property.durability", "Durability");
        add("tooltip.practical_additions.property.rarity", "Rarity");
        add("tooltip.practical_additions.property.repair_cost", "Repair Cost");
        add("tooltip.practical_additions.property.enchantability", "Enchantability");
        add("tooltip.practical_additions.property.attack_damage", "Attack Damage");
        add("tooltip.practical_additions.property.attack_speed", "Attack Speed");
        add("tooltip.practical_additions.property.mining_speed", "Mining Speed");
        add("tooltip.practical_additions.property.nutrition", "Nutrition");
        add("tooltip.practical_additions.property.saturation", "Saturation");
        add("tooltip.practical_additions.property.hardness", "Hardness");
        add("tooltip.practical_additions.property.light_level", "Light Level");
        add("tooltip.practical_additions.property.instrument", "Note Block Instrument");
        add("tooltip.practical_additions.property.requires_tool", "Requires Correct Tool");

        add("tooltip.practical_additions.magnet.state", "State: ");
        add("tooltip.practical_additions.magnet.on", "ON");
        add("tooltip.practical_additions.magnet.off", "OFF");
        add("tooltip.practical_additions.magnet.toggle_hint", "Shift Right Click While Holding Magnet to Toggle");
        add("message.practical_additions.magnet_toggled", "%s is now %s");
        add("gui.practical_additions.whitelist", "Whitelist");
        add("gui.practical_additions.blacklist", "Blacklist");
        add("gui.practical_additions.xp_on", "Collect XP: ON");
        add("gui.practical_additions.xp_off", "Collect XP: OFF");
        add("gui.practical_additions.clear_entries", "Clear Entries");

        add("key.categories.practical_additions.main", "Practical Additions");
        add("key.practical_additions.open_backpack", "Open Backpack");

        addItem(PAItems.LEAD_DIVING_BELT, "Lead Diving Belt");

        add("tooltip.practical_additions.diving_belt.state", "State: ");
        add("tooltip.practical_additions.diving_belt.on", "ON");
        add("tooltip.practical_additions.diving_belt.off", "OFF");
        add("tooltip.practical_additions.diving_belt.toggle_hint", "Shift Right Click While Holding Diving Belt to Toggle");
        add("message.practical_additions.diving_belt_toggled", "%s is now %s");
    }
}