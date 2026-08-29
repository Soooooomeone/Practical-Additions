package com.danako.practical_additions.init.creative_tab;

import com.danako.practical_additions.init.PAItems;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;

public class PACreativeTabAdditions {

    public static void register(IEventBus modEventBus) {
        modEventBus.addListener(PACreativeTabAdditions::onBuildTabContents);
    }

    private static ItemStack stack(Item item) {
        return new ItemStack(item);
    }

    private static void onBuildTabContents(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            addToolsAndUtilities(event);
        } else if (event.getTabKey() == CreativeModeTabs.COMBAT) {
            addCombat(event);
        } else if (event.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS) {
            addNaturalBlocks(event);
        } else if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
            addBuildingBlocks(event);
        } else if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            addIngredients(event);
        }
    }

    private static void addToolsAndUtilities(BuildCreativeModeTabContentsEvent event) {
        CreativeModeTab.TabVisibility vis = CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS;
        event.insertAfter(stack(Items.COPPER_HOE), stack(PAItems.COPPER_HAMMER.get()), vis);
        event.insertAfter(stack(PAItems.COPPER_HAMMER.get()), stack(PAItems.COPPER_EXCAVATOR.get()), vis);
        event.insertAfter(stack(PAItems.COPPER_EXCAVATOR.get()), stack(PAItems.COPPER_SICKLE.get()), vis);
        event.insertAfter(stack(PAItems.COPPER_SICKLE.get()), stack(PAItems.LEAD_SHOVEL.get()), vis);
        event.insertAfter(stack(PAItems.LEAD_SHOVEL.get()), stack(PAItems.LEAD_PICKAXE.get()), vis);
        event.insertAfter(stack(PAItems.LEAD_PICKAXE.get()), stack(PAItems.LEAD_AXE.get()), vis);
        event.insertAfter(stack(PAItems.LEAD_AXE.get()), stack(PAItems.LEAD_HOE.get()), vis);
        event.insertAfter(stack(PAItems.LEAD_HOE.get()), stack(PAItems.LEAD_HAMMER.get()), vis);
        event.insertAfter(stack(PAItems.LEAD_HAMMER.get()), stack(PAItems.LEAD_EXCAVATOR.get()), vis);
        event.insertAfter(stack(PAItems.LEAD_EXCAVATOR.get()), stack(PAItems.LEAD_SICKLE.get()), vis);
        event.insertAfter(stack(Items.IRON_HOE), stack(PAItems.IRON_HAMMER.get()), vis);
        event.insertAfter(stack(PAItems.IRON_HAMMER.get()), stack(PAItems.IRON_EXCAVATOR.get()), vis);
        event.insertAfter(stack(PAItems.IRON_EXCAVATOR.get()), stack(PAItems.IRON_SICKLE.get()), vis);
        event.insertAfter(stack(Items.GOLDEN_HOE), stack(PAItems.GOLDEN_HAMMER.get()), vis);
        event.insertAfter(stack(PAItems.GOLDEN_HAMMER.get()), stack(PAItems.GOLDEN_EXCAVATOR.get()), vis);
        event.insertAfter(stack(PAItems.GOLDEN_EXCAVATOR.get()), stack(PAItems.GOLDEN_SICKLE.get()), vis);
        event.insertAfter(stack(PAItems.GOLDEN_SICKLE.get()), stack(PAItems.LAPIS_SHOVEL.get()), vis);
        event.insertAfter(stack(PAItems.LAPIS_SHOVEL.get()), stack(PAItems.LAPIS_PICKAXE.get()), vis);
        event.insertAfter(stack(PAItems.LAPIS_PICKAXE.get()), stack(PAItems.LAPIS_AXE.get()), vis);
        event.insertAfter(stack(PAItems.LAPIS_AXE.get()), stack(PAItems.LAPIS_HOE.get()), vis);
        event.insertAfter(stack(PAItems.LAPIS_HOE.get()), stack(PAItems.LAPIS_HAMMER.get()), vis);
        event.insertAfter(stack(PAItems.LAPIS_HAMMER.get()), stack(PAItems.LAPIS_EXCAVATOR.get()), vis);
        event.insertAfter(stack(PAItems.LAPIS_EXCAVATOR.get()), stack(PAItems.LAPIS_SICKLE.get()), vis);
        event.insertAfter(stack(PAItems.LAPIS_SICKLE.get()), stack(PAItems.REDSTONE_SHOVEL.get()), vis);
        event.insertAfter(stack(PAItems.REDSTONE_SHOVEL.get()), stack(PAItems.REDSTONE_PICKAXE.get()), vis);
        event.insertAfter(stack(PAItems.REDSTONE_PICKAXE.get()), stack(PAItems.REDSTONE_AXE.get()), vis);
        event.insertAfter(stack(PAItems.REDSTONE_AXE.get()), stack(PAItems.REDSTONE_HOE.get()), vis);
        event.insertAfter(stack(PAItems.REDSTONE_HOE.get()), stack(PAItems.REDSTONE_HAMMER.get()), vis);
        event.insertAfter(stack(PAItems.REDSTONE_HAMMER.get()), stack(PAItems.REDSTONE_EXCAVATOR.get()), vis);
        event.insertAfter(stack(PAItems.REDSTONE_EXCAVATOR.get()), stack(PAItems.REDSTONE_SICKLE.get()), vis);
        event.insertAfter(stack(PAItems.REDSTONE_SICKLE.get()), stack(PAItems.COBALT_SHOVEL.get()), vis);
        event.insertAfter(stack(PAItems.COBALT_SHOVEL.get()), stack(PAItems.COBALT_PICKAXE.get()), vis);
        event.insertAfter(stack(PAItems.COBALT_PICKAXE.get()), stack(PAItems.COBALT_AXE.get()), vis);
        event.insertAfter(stack(PAItems.COBALT_AXE.get()), stack(PAItems.COBALT_HOE.get()), vis);
        event.insertAfter(stack(PAItems.COBALT_HOE.get()), stack(PAItems.COBALT_HAMMER.get()), vis);
        event.insertAfter(stack(PAItems.COBALT_HAMMER.get()), stack(PAItems.COBALT_EXCAVATOR.get()), vis);
        event.insertAfter(stack(PAItems.COBALT_EXCAVATOR.get()), stack(PAItems.COBALT_SICKLE.get()), vis);
        event.insertAfter(stack(PAItems.COBALT_SICKLE.get()), stack(PAItems.EMERALD_SHOVEL.get()), vis);
        event.insertAfter(stack(PAItems.EMERALD_SHOVEL.get()), stack(PAItems.EMERALD_PICKAXE.get()), vis);
        event.insertAfter(stack(PAItems.EMERALD_PICKAXE.get()), stack(PAItems.EMERALD_AXE.get()), vis);
        event.insertAfter(stack(PAItems.EMERALD_AXE.get()), stack(PAItems.EMERALD_HOE.get()), vis);
        event.insertAfter(stack(PAItems.EMERALD_HOE.get()), stack(PAItems.EMERALD_HAMMER.get()), vis);
        event.insertAfter(stack(PAItems.EMERALD_HAMMER.get()), stack(PAItems.EMERALD_EXCAVATOR.get()), vis);
        event.insertAfter(stack(PAItems.EMERALD_EXCAVATOR.get()), stack(PAItems.EMERALD_SICKLE.get()), vis);
        event.insertAfter(stack(Items.DIAMOND_HOE), stack(PAItems.DIAMOND_HAMMER.get()), vis);
        event.insertAfter(stack(PAItems.DIAMOND_HAMMER.get()), stack(PAItems.DIAMOND_EXCAVATOR.get()), vis);
        event.insertAfter(stack(PAItems.DIAMOND_EXCAVATOR.get()), stack(PAItems.DIAMOND_SICKLE.get()), vis);
        event.insertAfter(stack(Items.NETHERITE_HOE), stack(PAItems.NETHERITE_HAMMER.get()), vis);
        event.insertAfter(stack(PAItems.NETHERITE_HAMMER.get()), stack(PAItems.NETHERITE_EXCAVATOR.get()), vis);
        event.insertAfter(stack(PAItems.NETHERITE_EXCAVATOR.get()), stack(PAItems.NETHERITE_SICKLE.get()), vis);
        event.insertAfter(stack(Items.SPYGLASS), stack(PAItems.BASIC_MAGNET.get()), vis);
        event.insertAfter(stack(PAItems.BASIC_MAGNET.get()), stack(PAItems.ADVANCED_MAGNET.get()), vis);
        event.insertAfter(stack(Items.PINK_BUNDLE), stack(PAItems.BASIC_BACKPACK.get()), vis);
        event.insertAfter(stack(PAItems.BASIC_BACKPACK.get()), stack(PAItems.REINFORCED_BACKPACK.get()), vis);
        event.insertAfter(stack(PAItems.REINFORCED_BACKPACK.get()), stack(PAItems.BASIC_QUIVER.get()), vis);
        event.insertAfter(stack(PAItems.BASIC_QUIVER.get()), stack(PAItems.REINFORCED_QUIVER.get()), vis);
    }

    private static void addCombat(BuildCreativeModeTabContentsEvent event) {
        CreativeModeTab.TabVisibility vis = CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS;
        event.insertAfter(stack(Items.COPPER_SWORD), stack(PAItems.LEAD_SWORD.get()), vis);
        event.insertAfter(stack(Items.GOLDEN_SWORD), stack(PAItems.LAPIS_SWORD.get()), vis);
        event.insertAfter(stack(PAItems.LAPIS_SWORD.get()), stack(PAItems.REDSTONE_SWORD.get()), vis);
        event.insertAfter(stack(PAItems.REDSTONE_SWORD.get()), stack(PAItems.COBALT_SWORD.get()), vis);
        event.insertAfter(stack(PAItems.COBALT_SWORD.get()), stack(PAItems.EMERALD_SWORD.get()), vis);
        event.insertAfter(stack(Items.COPPER_SPEAR), stack(PAItems.LEAD_SPEAR.get()), vis);
        event.insertAfter(stack(Items.GOLDEN_SPEAR), stack(PAItems.LAPIS_SPEAR.get()), vis);
        event.insertAfter(stack(PAItems.LAPIS_SPEAR.get()), stack(PAItems.REDSTONE_SPEAR.get()), vis);
        event.insertAfter(stack(PAItems.REDSTONE_SPEAR.get()), stack(PAItems.COBALT_SPEAR.get()), vis);
        event.insertAfter(stack(PAItems.COBALT_SPEAR.get()), stack(PAItems.EMERALD_SPEAR.get()), vis);
        event.insertAfter(stack(Items.COPPER_AXE), stack(PAItems.LEAD_AXE.get()), vis);
        event.insertAfter(stack(Items.GOLDEN_AXE), stack(PAItems.LAPIS_AXE.get()), vis);
        event.insertAfter(stack(PAItems.LAPIS_AXE.get()), stack(PAItems.REDSTONE_AXE.get()), vis);
        event.insertAfter(stack(PAItems.REDSTONE_AXE.get()), stack(PAItems.COBALT_AXE.get()), vis);
        event.insertAfter(stack(PAItems.COBALT_AXE.get()), stack(PAItems.EMERALD_AXE.get()), vis);
        event.insertAfter(stack(Items.SHIELD), stack(PAItems.KEVLAR_SHIELD.get()), vis);
        event.insertAfter(stack(Items.CROSSBOW), stack(PAItems.COBALT_BOW.get()), vis);
        event.insertAfter(stack(Items.COPPER_BOOTS), stack(PAItems.LEAD_HELMET.get()), vis);
        event.insertAfter(stack(PAItems.LEAD_HELMET.get()), stack(PAItems.LEAD_CHESTPLATE.get()), vis);
        event.insertAfter(stack(PAItems.LEAD_CHESTPLATE.get()), stack(PAItems.LEAD_LEGGINGS.get()), vis);
        event.insertAfter(stack(PAItems.LEAD_LEGGINGS.get()), stack(PAItems.LEAD_BOOTS.get()), vis);
        event.insertAfter(stack(Items.CHAINMAIL_BOOTS), stack(PAItems.BALLISTIC_HELMET.get()), vis);
        event.insertAfter(stack(PAItems.BALLISTIC_HELMET.get()), stack(PAItems.KEVLAR_VEST.get()), vis);
        event.insertAfter(stack(PAItems.KEVLAR_VEST.get()), stack(PAItems.KEVLAR_PANTS.get()), vis);
        event.insertAfter(stack(PAItems.KEVLAR_PANTS.get()), stack(PAItems.KEVLAR_BOOTS.get()), vis);
        event.insertAfter(stack(Items.GOLDEN_BOOTS), stack(PAItems.LAPIS_HELMET.get()), vis);
        event.insertAfter(stack(PAItems.LAPIS_HELMET.get()), stack(PAItems.LAPIS_CHESTPLATE.get()), vis);
        event.insertAfter(stack(PAItems.LAPIS_CHESTPLATE.get()), stack(PAItems.LAPIS_LEGGINGS.get()), vis);
        event.insertAfter(stack(PAItems.LAPIS_LEGGINGS.get()), stack(PAItems.LAPIS_BOOTS.get()), vis);
        event.insertAfter(stack(PAItems.LAPIS_BOOTS.get()), stack(PAItems.REDSTONE_HELMET.get()), vis);
        event.insertAfter(stack(PAItems.REDSTONE_HELMET.get()), stack(PAItems.REDSTONE_CHESTPLATE.get()), vis);
        event.insertAfter(stack(PAItems.REDSTONE_CHESTPLATE.get()), stack(PAItems.REDSTONE_LEGGINGS.get()), vis);
        event.insertAfter(stack(PAItems.REDSTONE_LEGGINGS.get()), stack(PAItems.REDSTONE_BOOTS.get()), vis);
        event.insertAfter(stack(PAItems.REDSTONE_BOOTS.get()), stack(PAItems.COBALT_HELMET.get()), vis);
        event.insertAfter(stack(PAItems.COBALT_HELMET.get()), stack(PAItems.COBALT_CHESTPLATE.get()), vis);
        event.insertAfter(stack(PAItems.COBALT_CHESTPLATE.get()), stack(PAItems.COBALT_LEGGINGS.get()), vis);
        event.insertAfter(stack(PAItems.COBALT_LEGGINGS.get()), stack(PAItems.COBALT_BOOTS.get()), vis);
        event.insertAfter(stack(PAItems.COBALT_BOOTS.get()), stack(PAItems.EMERALD_HELMET.get()), vis);
        event.insertAfter(stack(PAItems.EMERALD_HELMET.get()), stack(PAItems.EMERALD_CHESTPLATE.get()), vis);
        event.insertAfter(stack(PAItems.EMERALD_CHESTPLATE.get()), stack(PAItems.EMERALD_LEGGINGS.get()), vis);
        event.insertAfter(stack(PAItems.EMERALD_LEGGINGS.get()), stack(PAItems.EMERALD_BOOTS.get()), vis);
        event.insertAfter(stack(Items.COPPER_HORSE_ARMOR), stack(PAItems.LEAD_HORSE_ARMOR.get()), vis);
        event.insertAfter(stack(Items.GOLDEN_HORSE_ARMOR), stack(PAItems.COBALT_HORSE_ARMOR.get()), vis);
        event.insertAfter(stack(PAItems.COBALT_HORSE_ARMOR.get()), stack(PAItems.EMERALD_HORSE_ARMOR.get()), vis);
        event.insertAfter(stack(Items.COPPER_NAUTILUS_ARMOR), stack(PAItems.LEAD_NAUTILUS_ARMOR.get()), vis);
        event.insertAfter(stack(Items.GOLDEN_NAUTILUS_ARMOR), stack(PAItems.COBALT_NAUTILUS_ARMOR.get()), vis);
        event.insertAfter(stack(PAItems.COBALT_NAUTILUS_ARMOR.get()), stack(PAItems.EMERALD_NAUTILUS_ARMOR.get()), vis);
    }

    private static void addNaturalBlocks(BuildCreativeModeTabContentsEvent event) {
        CreativeModeTab.TabVisibility vis = CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS;
        event.insertAfter(stack(Items.DEEPSLATE_COPPER_ORE), stack(PAItems.LEAD_ORE.get()), vis);
        event.insertAfter(stack(PAItems.LEAD_ORE.get()), stack(PAItems.DEEPSLATE_LEAD_ORE.get()), vis);
        event.insertAfter(stack(Items.DEEPSLATE_GOLD_ORE), stack(PAItems.COBALT_ORE.get()), vis);
        event.insertAfter(stack(PAItems.COBALT_ORE.get()), stack(PAItems.DEEPSLATE_COBALT_ORE.get()), vis);
        event.insertAfter(stack(Items.RAW_COPPER_BLOCK), stack(PAItems.RAW_LEAD_BLOCK.get()), vis);
        event.insertAfter(stack(Items.RAW_GOLD_BLOCK), stack(PAItems.RAW_COBALT_BLOCK.get()), vis);
    }

    private static void addBuildingBlocks(BuildCreativeModeTabContentsEvent event) {
        CreativeModeTab.TabVisibility vis = CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS;
        event.insertAfter(stack(Items.LIGHT_WEIGHTED_PRESSURE_PLATE), stack(PAItems.LEAD_BLOCK.get()), vis);
        event.insertAfter(stack(PAItems.LEAD_BLOCK.get()), stack(PAItems.DENSE_WEIGHTED_PRESSURE_PLATE.get()), vis);
        event.insertAfter(stack(Items.GOLD_BLOCK), stack(PAItems.COBALT_BLOCK.get()), vis);
    }

    private static void addIngredients(BuildCreativeModeTabContentsEvent event) {
        CreativeModeTab.TabVisibility vis = CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS;
        event.insertAfter(stack(Items.RAW_COPPER), stack(PAItems.RAW_LEAD.get()), vis);
        event.insertAfter(stack(Items.RAW_GOLD), stack(PAItems.RAW_COBALT.get()), vis);
        event.insertAfter(stack(Items.COPPER_NUGGET), stack(PAItems.LEAD_NUGGET.get()), vis);
        event.insertAfter(stack(Items.GOLD_NUGGET), stack(PAItems.COBALT_NUGGET.get()), vis);
        event.insertAfter(stack(Items.COPPER_INGOT), stack(PAItems.LEAD_INGOT.get()), vis);
        event.insertAfter(stack(Items.GOLD_INGOT), stack(PAItems.COBALT_INGOT.get()), vis);
        event.insertAfter(stack(Items.STRING), stack(PAItems.KEVLAR_FIBER.get()), vis);
        event.insertAfter(stack(Items.LEATHER), stack(PAItems.KEVLAR_SHEET.get()), vis);
    }
}