package com.danako.practical_additions.init.creative_tab;

import com.danako.practical_additions.PracticalAdditions;
import com.danako.practical_additions.init.PAItems;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.neoforge.registries.DeferredHolder;

import static com.danako.practical_additions.PracticalAdditions.CREATIVE_MODE_TABS;

public class PACreativeModeTabs {

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> PRACTICAL_ADDITIONS_TAB = CREATIVE_MODE_TABS.register("practical_additions_tab", () -> CreativeModeTab.builder().title(Component.translatable("creativetab." + PracticalAdditions.MODID + ".practical_additions_tab")).icon(() -> PAItems.ADVANCED_MAGNET.get().getDefaultInstance()).displayItems((parameters, output) -> {

        // ===== Lead =====
        output.accept(PAItems.LEAD_ORE.get());
        output.accept(PAItems.DEEPSLATE_LEAD_ORE.get());
        output.accept(PAItems.RAW_LEAD.get());
        output.accept(PAItems.LEAD_INGOT.get());
        output.accept(PAItems.LEAD_NUGGET.get());
        output.accept(PAItems.RAW_LEAD_BLOCK.get());
        output.accept(PAItems.LEAD_BLOCK.get());
        output.accept(PAItems.DENSE_WEIGHTED_PRESSURE_PLATE.get());
        output.accept(PAItems.LEAD_SWORD.get());
        output.accept(PAItems.LEAD_SPEAR.get());
        output.accept(PAItems.LEAD_PICKAXE.get());
        output.accept(PAItems.LEAD_AXE.get());
        output.accept(PAItems.LEAD_SHOVEL.get());
        output.accept(PAItems.LEAD_HOE.get());
        output.accept(PAItems.LEAD_HAMMER.get());
        output.accept(PAItems.LEAD_EXCAVATOR.get());
        output.accept(PAItems.LEAD_SICKLE.get());
        output.accept(PAItems.LEAD_HELMET.get());
        output.accept(PAItems.LEAD_CHESTPLATE.get());
        output.accept(PAItems.LEAD_LEGGINGS.get());
        output.accept(PAItems.LEAD_BOOTS.get());
        output.accept(PAItems.LEAD_HORSE_ARMOR.get());
        output.accept(PAItems.LEAD_NAUTILUS_ARMOR.get());
        output.accept(PAItems.LEAD_DIVING_BELT.get());

        // ===== Cobalt =====
        output.accept(PAItems.COBALT_ORE.get());
        output.accept(PAItems.DEEPSLATE_COBALT_ORE.get());
        output.accept(PAItems.RAW_COBALT.get());
        output.accept(PAItems.COBALT_INGOT.get());
        output.accept(PAItems.COBALT_NUGGET.get());
        output.accept(PAItems.RAW_COBALT_BLOCK.get());
        output.accept(PAItems.COBALT_BLOCK.get());
        output.accept(PAItems.COBALT_SWORD.get());
        output.accept(PAItems.COBALT_SPEAR.get());
        output.accept(PAItems.COBALT_BOW.get());
        output.accept(PAItems.COBALT_PICKAXE.get());
        output.accept(PAItems.COBALT_AXE.get());
        output.accept(PAItems.COBALT_SHOVEL.get());
        output.accept(PAItems.COBALT_HOE.get());
        output.accept(PAItems.COBALT_HAMMER.get());
        output.accept(PAItems.COBALT_EXCAVATOR.get());
        output.accept(PAItems.COBALT_SICKLE.get());
        output.accept(PAItems.COBALT_HELMET.get());
        output.accept(PAItems.COBALT_CHESTPLATE.get());
        output.accept(PAItems.COBALT_LEGGINGS.get());
        output.accept(PAItems.COBALT_BOOTS.get());
        output.accept(PAItems.COBALT_HORSE_ARMOR.get());
        output.accept(PAItems.COBALT_NAUTILUS_ARMOR.get());
        output.accept(PAItems.ADVANCED_MAGNET.get());

        // ===== Emerald =====
        output.accept(PAItems.EMERALD_SWORD.get());
        output.accept(PAItems.EMERALD_SPEAR.get());
        output.accept(PAItems.EMERALD_PICKAXE.get());
        output.accept(PAItems.EMERALD_AXE.get());
        output.accept(PAItems.EMERALD_SHOVEL.get());
        output.accept(PAItems.EMERALD_HOE.get());
        output.accept(PAItems.EMERALD_HAMMER.get());
        output.accept(PAItems.EMERALD_EXCAVATOR.get());
        output.accept(PAItems.EMERALD_SICKLE.get());
        output.accept(PAItems.EMERALD_HELMET.get());
        output.accept(PAItems.EMERALD_CHESTPLATE.get());
        output.accept(PAItems.EMERALD_LEGGINGS.get());
        output.accept(PAItems.EMERALD_BOOTS.get());
        output.accept(PAItems.EMERALD_HORSE_ARMOR.get());
        output.accept(PAItems.EMERALD_NAUTILUS_ARMOR.get());

        // ===== Lapis =====
        output.accept(PAItems.LAPIS_SWORD.get());
        output.accept(PAItems.LAPIS_SPEAR.get());
        output.accept(PAItems.LAPIS_PICKAXE.get());
        output.accept(PAItems.LAPIS_AXE.get());
        output.accept(PAItems.LAPIS_SHOVEL.get());
        output.accept(PAItems.LAPIS_HOE.get());
        output.accept(PAItems.LAPIS_HAMMER.get());
        output.accept(PAItems.LAPIS_EXCAVATOR.get());
        output.accept(PAItems.LAPIS_SICKLE.get());
        output.accept(PAItems.LAPIS_HELMET.get());
        output.accept(PAItems.LAPIS_CHESTPLATE.get());
        output.accept(PAItems.LAPIS_LEGGINGS.get());
        output.accept(PAItems.LAPIS_BOOTS.get());

        // ===== Redstone =====
        output.accept(PAItems.REDSTONE_SWORD.get());
        output.accept(PAItems.REDSTONE_SPEAR.get());
        output.accept(PAItems.REDSTONE_PICKAXE.get());
        output.accept(PAItems.REDSTONE_AXE.get());
        output.accept(PAItems.REDSTONE_SHOVEL.get());
        output.accept(PAItems.REDSTONE_HOE.get());
        output.accept(PAItems.REDSTONE_HAMMER.get());
        output.accept(PAItems.REDSTONE_EXCAVATOR.get());
        output.accept(PAItems.REDSTONE_SICKLE.get());
        output.accept(PAItems.REDSTONE_HELMET.get());
        output.accept(PAItems.REDSTONE_CHESTPLATE.get());
        output.accept(PAItems.REDSTONE_LEGGINGS.get());
        output.accept(PAItems.REDSTONE_BOOTS.get());

        // ===== Gold (vanilla-material tool variants) =====
        output.accept(PAItems.GOLDEN_HAMMER.get());
        output.accept(PAItems.GOLDEN_EXCAVATOR.get());
        output.accept(PAItems.GOLDEN_SICKLE.get());

        // ===== Copper =====
        output.accept(PAItems.COPPER_HAMMER.get());
        output.accept(PAItems.COPPER_EXCAVATOR.get());
        output.accept(PAItems.COPPER_SICKLE.get());

        // ===== Iron =====
        output.accept(PAItems.IRON_HAMMER.get());
        output.accept(PAItems.IRON_EXCAVATOR.get());
        output.accept(PAItems.IRON_SICKLE.get());
        output.accept(PAItems.BASIC_MAGNET.get());

        // ===== Diamond =====
        output.accept(PAItems.DIAMOND_HAMMER.get());
        output.accept(PAItems.DIAMOND_EXCAVATOR.get());
        output.accept(PAItems.DIAMOND_SICKLE.get());

        // ===== Netherite =====
        output.accept(PAItems.NETHERITE_HAMMER.get());
        output.accept(PAItems.NETHERITE_EXCAVATOR.get());
        output.accept(PAItems.NETHERITE_SICKLE.get());

        // ===== Leather =====
        output.accept(PAItems.BASIC_BACKPACK.get());
        output.accept(PAItems.BASIC_QUIVER.get());

        // ===== Kevlar =====
        output.accept(PAItems.KEVLAR_FIBER.get());
        output.accept(PAItems.KEVLAR_SHEET.get());
        output.accept(PAItems.BALLISTIC_HELMET.get());
        output.accept(PAItems.KEVLAR_VEST.get());
        output.accept(PAItems.KEVLAR_PANTS.get());
        output.accept(PAItems.KEVLAR_BOOTS.get());
        output.accept(PAItems.KEVLAR_SHIELD.get());
        output.accept(PAItems.REINFORCED_QUIVER.get());
        output.accept(PAItems.REINFORCED_BACKPACK.get());

        // ===== Misc =====
        output.accept(PAItems.BLUNT.get());
        output.accept(PAItems.WEED_CROP.get());
        output.accept(PAItems.RAW_WEED.get());
        output.accept(PAItems.COOKED_WEED.get());

    }).build());

    public static void register() {
    }
}