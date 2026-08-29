package com.danako.practical_additions.datagen.tags;

import com.danako.practical_additions.PracticalAdditions;
import com.danako.practical_additions.init.PAItems;
import com.danako.practical_additions.init.PATags;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ItemTagsProvider;

import java.util.concurrent.CompletableFuture;

public class PAItemTagsProvider extends ItemTagsProvider {

    public PAItemTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> blockTags) {
        super(output, lookupProvider, PracticalAdditions.MODID);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        addEnchantableTags();
        addVanillaTags();
        addNeoForgeConventionTags();
        addCustomTags();
    }

    private void addEnchantableTags() {

        tag(ItemTags.FIRE_ASPECT_ENCHANTABLE).add(PAItems.LEAD_SWORD.get()).add(PAItems.LEAD_SPEAR.get()).add(PAItems.COBALT_SWORD.get()).add(PAItems.COBALT_SPEAR.get());

        tag(ItemTags.MINING_ENCHANTABLE).add(PAItems.LEAD_PICKAXE.get()).add(PAItems.LEAD_AXE.get()).add(PAItems.LEAD_SHOVEL.get()).add(PAItems.LEAD_HOE.get()).add(PAItems.COBALT_PICKAXE.get()).add(PAItems.COBALT_AXE.get()).add(PAItems.COBALT_SHOVEL.get()).add(PAItems.COBALT_HOE.get()).add(PAItems.GOLDEN_HAMMER.get()).add(PAItems.COPPER_HAMMER.get()).add(PAItems.LEAD_HAMMER.get()).add(PAItems.IRON_HAMMER.get()).add(PAItems.COBALT_HAMMER.get()).add(PAItems.DIAMOND_HAMMER.get()).add(PAItems.NETHERITE_HAMMER.get()).add(PAItems.GOLDEN_EXCAVATOR.get()).add(PAItems.COPPER_EXCAVATOR.get()).add(PAItems.LEAD_EXCAVATOR.get()).add(PAItems.IRON_EXCAVATOR.get()).add(PAItems.COBALT_EXCAVATOR.get()).add(PAItems.DIAMOND_EXCAVATOR.get()).add(PAItems.NETHERITE_EXCAVATOR.get()).add(PAItems.GOLDEN_SICKLE.get()).add(PAItems.COPPER_SICKLE.get()).add(PAItems.LEAD_SICKLE.get()).add(PAItems.IRON_SICKLE.get()).add(PAItems.COBALT_SICKLE.get()).add(PAItems.DIAMOND_SICKLE.get()).add(PAItems.NETHERITE_SICKLE.get());

        tag(ItemTags.MINING_LOOT_ENCHANTABLE).add(PAItems.LEAD_PICKAXE.get()).add(PAItems.LEAD_AXE.get()).add(PAItems.LEAD_SHOVEL.get()).add(PAItems.LEAD_HOE.get()).add(PAItems.COBALT_PICKAXE.get()).add(PAItems.COBALT_AXE.get()).add(PAItems.COBALT_SHOVEL.get()).add(PAItems.COBALT_HOE.get()).add(PAItems.GOLDEN_HAMMER.get()).add(PAItems.COPPER_HAMMER.get()).add(PAItems.LEAD_HAMMER.get()).add(PAItems.IRON_HAMMER.get()).add(PAItems.COBALT_HAMMER.get()).add(PAItems.DIAMOND_HAMMER.get()).add(PAItems.NETHERITE_HAMMER.get()).add(PAItems.GOLDEN_EXCAVATOR.get()).add(PAItems.COPPER_EXCAVATOR.get()).add(PAItems.LEAD_EXCAVATOR.get()).add(PAItems.IRON_EXCAVATOR.get()).add(PAItems.COBALT_EXCAVATOR.get()).add(PAItems.DIAMOND_EXCAVATOR.get()).add(PAItems.NETHERITE_EXCAVATOR.get()).add(PAItems.GOLDEN_SICKLE.get()).add(PAItems.COPPER_SICKLE.get()).add(PAItems.LEAD_SICKLE.get()).add(PAItems.IRON_SICKLE.get()).add(PAItems.COBALT_SICKLE.get()).add(PAItems.DIAMOND_SICKLE.get()).add(PAItems.NETHERITE_SICKLE.get());

        tag(ItemTags.SWEEPING_ENCHANTABLE).add(PAItems.LEAD_SWORD.get()).add(PAItems.COBALT_SWORD.get());
        tag(ItemTags.LUNGE_ENCHANTABLE).add(PAItems.LEAD_SPEAR.get()).add(PAItems.COBALT_SPEAR.get());

        tag(ItemTags.MELEE_WEAPON_ENCHANTABLE).add(PAItems.LEAD_SWORD.get()).add(PAItems.LEAD_SPEAR.get()).add(PAItems.COBALT_SWORD.get()).add(PAItems.COBALT_SPEAR.get());

        tag(ItemTags.SHARP_WEAPON_ENCHANTABLE).add(PAItems.LEAD_AXE.get()).add(PAItems.COBALT_AXE.get());

        tag(ItemTags.ARMOR_ENCHANTABLE).add(PAItems.LEAD_HELMET.get()).add(PAItems.LEAD_CHESTPLATE.get()).add(PAItems.LEAD_LEGGINGS.get()).add(PAItems.LEAD_BOOTS.get()).add(PAItems.LEAD_HORSE_ARMOR.get()).add(PAItems.LEAD_NAUTILUS_ARMOR.get()).add(PAItems.COBALT_HELMET.get()).add(PAItems.COBALT_CHESTPLATE.get()).add(PAItems.COBALT_LEGGINGS.get()).add(PAItems.COBALT_BOOTS.get()).add(PAItems.COBALT_HORSE_ARMOR.get()).add(PAItems.COBALT_NAUTILUS_ARMOR.get()).add(PAItems.BALLISTIC_HELMET.get()).add(PAItems.KEVLAR_VEST.get()).add(PAItems.KEVLAR_PANTS.get()).add(PAItems.KEVLAR_BOOTS.get());

        tag(ItemTags.DURABILITY_ENCHANTABLE).add(PAItems.LEAD_SWORD.get()).add(PAItems.LEAD_SPEAR.get()).add(PAItems.LEAD_PICKAXE.get()).add(PAItems.LEAD_AXE.get()).add(PAItems.LEAD_SHOVEL.get()).add(PAItems.LEAD_HOE.get()).add(PAItems.LEAD_HELMET.get()).add(PAItems.LEAD_CHESTPLATE.get()).add(PAItems.LEAD_LEGGINGS.get()).add(PAItems.LEAD_BOOTS.get()).add(PAItems.LEAD_HORSE_ARMOR.get()).add(PAItems.LEAD_NAUTILUS_ARMOR.get()).add(PAItems.COBALT_SWORD.get()).add(PAItems.COBALT_SPEAR.get()).add(PAItems.COBALT_PICKAXE.get()).add(PAItems.COBALT_AXE.get()).add(PAItems.COBALT_SHOVEL.get()).add(PAItems.COBALT_HOE.get()).add(PAItems.COBALT_HELMET.get()).add(PAItems.COBALT_CHESTPLATE.get()).add(PAItems.COBALT_LEGGINGS.get()).add(PAItems.COBALT_BOOTS.get()).add(PAItems.COBALT_HORSE_ARMOR.get()).add(PAItems.COBALT_NAUTILUS_ARMOR.get()).add(PAItems.GOLDEN_HAMMER.get()).add(PAItems.COPPER_HAMMER.get()).add(PAItems.LEAD_HAMMER.get()).add(PAItems.IRON_HAMMER.get()).add(PAItems.COBALT_HAMMER.get()).add(PAItems.DIAMOND_HAMMER.get()).add(PAItems.NETHERITE_HAMMER.get()).add(PAItems.GOLDEN_EXCAVATOR.get()).add(PAItems.COPPER_EXCAVATOR.get()).add(PAItems.LEAD_EXCAVATOR.get()).add(PAItems.IRON_EXCAVATOR.get()).add(PAItems.COBALT_EXCAVATOR.get()).add(PAItems.DIAMOND_EXCAVATOR.get()).add(PAItems.NETHERITE_EXCAVATOR.get()).add(PAItems.GOLDEN_SICKLE.get()).add(PAItems.COPPER_SICKLE.get()).add(PAItems.LEAD_SICKLE.get()).add(PAItems.IRON_SICKLE.get()).add(PAItems.COBALT_SICKLE.get()).add(PAItems.DIAMOND_SICKLE.get()).add(PAItems.NETHERITE_SICKLE.get()).add(PAItems.BALLISTIC_HELMET.get()).add(PAItems.KEVLAR_VEST.get()).add(PAItems.KEVLAR_PANTS.get()).add(PAItems.KEVLAR_BOOTS.get());

        tag(ItemTags.VANISHING_ENCHANTABLE).add(PAItems.LEAD_SWORD.get()).add(PAItems.LEAD_SPEAR.get()).add(PAItems.LEAD_PICKAXE.get()).add(PAItems.LEAD_AXE.get()).add(PAItems.LEAD_SHOVEL.get()).add(PAItems.LEAD_HOE.get()).add(PAItems.LEAD_HELMET.get()).add(PAItems.LEAD_CHESTPLATE.get()).add(PAItems.LEAD_LEGGINGS.get()).add(PAItems.LEAD_BOOTS.get()).add(PAItems.LEAD_HORSE_ARMOR.get()).add(PAItems.LEAD_NAUTILUS_ARMOR.get()).add(PAItems.COBALT_SWORD.get()).add(PAItems.COBALT_SPEAR.get()).add(PAItems.COBALT_PICKAXE.get()).add(PAItems.COBALT_AXE.get()).add(PAItems.COBALT_SHOVEL.get()).add(PAItems.COBALT_HOE.get()).add(PAItems.COBALT_HELMET.get()).add(PAItems.COBALT_CHESTPLATE.get()).add(PAItems.COBALT_LEGGINGS.get()).add(PAItems.COBALT_BOOTS.get()).add(PAItems.COBALT_HORSE_ARMOR.get()).add(PAItems.COBALT_NAUTILUS_ARMOR.get()).add(PAItems.GOLDEN_HAMMER.get()).add(PAItems.COPPER_HAMMER.get()).add(PAItems.LEAD_HAMMER.get()).add(PAItems.IRON_HAMMER.get()).add(PAItems.COBALT_HAMMER.get()).add(PAItems.DIAMOND_HAMMER.get()).add(PAItems.NETHERITE_HAMMER.get()).add(PAItems.GOLDEN_EXCAVATOR.get()).add(PAItems.COPPER_EXCAVATOR.get()).add(PAItems.LEAD_EXCAVATOR.get()).add(PAItems.IRON_EXCAVATOR.get()).add(PAItems.COBALT_EXCAVATOR.get()).add(PAItems.DIAMOND_EXCAVATOR.get()).add(PAItems.NETHERITE_EXCAVATOR.get()).add(PAItems.GOLDEN_SICKLE.get()).add(PAItems.COPPER_SICKLE.get()).add(PAItems.LEAD_SICKLE.get()).add(PAItems.IRON_SICKLE.get()).add(PAItems.COBALT_SICKLE.get()).add(PAItems.DIAMOND_SICKLE.get()).add(PAItems.NETHERITE_SICKLE.get()).add(PAItems.BALLISTIC_HELMET.get()).add(PAItems.KEVLAR_VEST.get()).add(PAItems.KEVLAR_PANTS.get()).add(PAItems.KEVLAR_BOOTS.get());

        tag(ItemTags.HEAD_ARMOR_ENCHANTABLE).add(PAItems.LEAD_HELMET.get()).add(PAItems.COBALT_HELMET.get()).add(PAItems.BALLISTIC_HELMET.get());

        tag(ItemTags.CHEST_ARMOR_ENCHANTABLE).add(PAItems.LEAD_CHESTPLATE.get()).add(PAItems.COBALT_CHESTPLATE.get()).add(PAItems.KEVLAR_VEST.get());

        tag(ItemTags.LEG_ARMOR_ENCHANTABLE).add(PAItems.LEAD_LEGGINGS.get()).add(PAItems.COBALT_LEGGINGS.get()).add(PAItems.KEVLAR_PANTS.get());

        tag(ItemTags.FOOT_ARMOR_ENCHANTABLE).add(PAItems.LEAD_BOOTS.get()).add(PAItems.COBALT_BOOTS.get()).add(PAItems.KEVLAR_BOOTS.get());

        tag(ItemTags.EQUIPPABLE_ENCHANTABLE).add(PAItems.LEAD_HELMET.get()).add(PAItems.LEAD_CHESTPLATE.get()).add(PAItems.LEAD_LEGGINGS.get()).add(PAItems.LEAD_BOOTS.get()).add(PAItems.LEAD_HORSE_ARMOR.get()).add(PAItems.LEAD_NAUTILUS_ARMOR.get()).add(PAItems.COBALT_HELMET.get()).add(PAItems.COBALT_CHESTPLATE.get()).add(PAItems.COBALT_LEGGINGS.get()).add(PAItems.COBALT_BOOTS.get()).add(PAItems.COBALT_HORSE_ARMOR.get()).add(PAItems.COBALT_NAUTILUS_ARMOR.get()).add(PAItems.BALLISTIC_HELMET.get()).add(PAItems.KEVLAR_VEST.get()).add(PAItems.KEVLAR_PANTS.get()).add(PAItems.KEVLAR_BOOTS.get());

        tag(ItemTags.DURABILITY_ENCHANTABLE).add(PAItems.KEVLAR_SHIELD.get());

        tag(ItemTags.BOW_ENCHANTABLE).add(PAItems.COBALT_BOW.get());
        tag(ItemTags.DURABILITY_ENCHANTABLE).add(PAItems.COBALT_BOW.get());
        tag(ItemTags.VANISHING_ENCHANTABLE).add(PAItems.COBALT_BOW.get());
        tag(ItemTags.VANISHING_ENCHANTABLE).add(PAItems.KEVLAR_SHIELD.get());

        tag(ItemTags.FIRE_ASPECT_ENCHANTABLE).add(PAItems.EMERALD_SWORD.get()).add(PAItems.EMERALD_SPEAR.get()).add(PAItems.LAPIS_SWORD.get()).add(PAItems.LAPIS_SPEAR.get()).add(PAItems.REDSTONE_SWORD.get()).add(PAItems.REDSTONE_SPEAR.get());

        tag(ItemTags.MINING_ENCHANTABLE).add(PAItems.EMERALD_PICKAXE.get()).add(PAItems.EMERALD_AXE.get()).add(PAItems.EMERALD_SHOVEL.get()).add(PAItems.EMERALD_HOE.get()).add(PAItems.EMERALD_HAMMER.get()).add(PAItems.EMERALD_EXCAVATOR.get()).add(PAItems.EMERALD_SICKLE.get()).add(PAItems.LAPIS_PICKAXE.get()).add(PAItems.LAPIS_AXE.get()).add(PAItems.LAPIS_SHOVEL.get()).add(PAItems.LAPIS_HOE.get()).add(PAItems.LAPIS_HAMMER.get()).add(PAItems.LAPIS_EXCAVATOR.get()).add(PAItems.LAPIS_SICKLE.get()).add(PAItems.REDSTONE_PICKAXE.get()).add(PAItems.REDSTONE_AXE.get()).add(PAItems.REDSTONE_SHOVEL.get()).add(PAItems.REDSTONE_HOE.get()).add(PAItems.REDSTONE_HAMMER.get()).add(PAItems.REDSTONE_EXCAVATOR.get()).add(PAItems.REDSTONE_SICKLE.get());

        tag(ItemTags.MINING_LOOT_ENCHANTABLE).add(PAItems.EMERALD_PICKAXE.get()).add(PAItems.EMERALD_AXE.get()).add(PAItems.EMERALD_SHOVEL.get()).add(PAItems.EMERALD_HOE.get()).add(PAItems.EMERALD_HAMMER.get()).add(PAItems.EMERALD_EXCAVATOR.get()).add(PAItems.EMERALD_SICKLE.get()).add(PAItems.LAPIS_PICKAXE.get()).add(PAItems.LAPIS_AXE.get()).add(PAItems.LAPIS_SHOVEL.get()).add(PAItems.LAPIS_HOE.get()).add(PAItems.LAPIS_HAMMER.get()).add(PAItems.LAPIS_EXCAVATOR.get()).add(PAItems.LAPIS_SICKLE.get()).add(PAItems.REDSTONE_PICKAXE.get()).add(PAItems.REDSTONE_AXE.get()).add(PAItems.REDSTONE_SHOVEL.get()).add(PAItems.REDSTONE_HOE.get()).add(PAItems.REDSTONE_HAMMER.get()).add(PAItems.REDSTONE_EXCAVATOR.get()).add(PAItems.REDSTONE_SICKLE.get());

        tag(ItemTags.SWEEPING_ENCHANTABLE).add(PAItems.EMERALD_SWORD.get()).add(PAItems.LAPIS_SWORD.get()).add(PAItems.REDSTONE_SWORD.get());
        tag(ItemTags.LUNGE_ENCHANTABLE).add(PAItems.EMERALD_SPEAR.get()).add(PAItems.LAPIS_SPEAR.get()).add(PAItems.REDSTONE_SPEAR.get());

        tag(ItemTags.MELEE_WEAPON_ENCHANTABLE).add(PAItems.EMERALD_SWORD.get()).add(PAItems.EMERALD_SPEAR.get()).add(PAItems.LAPIS_SWORD.get()).add(PAItems.LAPIS_SPEAR.get()).add(PAItems.REDSTONE_SWORD.get()).add(PAItems.REDSTONE_SPEAR.get());

        tag(ItemTags.SHARP_WEAPON_ENCHANTABLE).add(PAItems.EMERALD_AXE.get()).add(PAItems.LAPIS_AXE.get()).add(PAItems.REDSTONE_AXE.get());

        tag(ItemTags.ARMOR_ENCHANTABLE).add(PAItems.EMERALD_HELMET.get()).add(PAItems.EMERALD_CHESTPLATE.get()).add(PAItems.EMERALD_LEGGINGS.get()).add(PAItems.EMERALD_BOOTS.get()).add(PAItems.EMERALD_HORSE_ARMOR.get()).add(PAItems.EMERALD_NAUTILUS_ARMOR.get()).add(PAItems.LAPIS_HELMET.get()).add(PAItems.LAPIS_CHESTPLATE.get()).add(PAItems.LAPIS_LEGGINGS.get()).add(PAItems.LAPIS_BOOTS.get()).add(PAItems.REDSTONE_HELMET.get()).add(PAItems.REDSTONE_CHESTPLATE.get()).add(PAItems.REDSTONE_LEGGINGS.get()).add(PAItems.REDSTONE_BOOTS.get());

        tag(ItemTags.DURABILITY_ENCHANTABLE).add(PAItems.EMERALD_SWORD.get()).add(PAItems.EMERALD_SPEAR.get()).add(PAItems.EMERALD_PICKAXE.get()).add(PAItems.EMERALD_AXE.get()).add(PAItems.EMERALD_SHOVEL.get()).add(PAItems.EMERALD_HOE.get()).add(PAItems.EMERALD_HELMET.get()).add(PAItems.EMERALD_CHESTPLATE.get()).add(PAItems.EMERALD_LEGGINGS.get()).add(PAItems.EMERALD_BOOTS.get()).add(PAItems.EMERALD_HORSE_ARMOR.get()).add(PAItems.EMERALD_NAUTILUS_ARMOR.get()).add(PAItems.EMERALD_HAMMER.get()).add(PAItems.EMERALD_EXCAVATOR.get()).add(PAItems.EMERALD_SICKLE.get()).add(PAItems.LAPIS_SWORD.get()).add(PAItems.LAPIS_SPEAR.get()).add(PAItems.LAPIS_PICKAXE.get()).add(PAItems.LAPIS_AXE.get()).add(PAItems.LAPIS_SHOVEL.get()).add(PAItems.LAPIS_HOE.get()).add(PAItems.LAPIS_HELMET.get()).add(PAItems.LAPIS_CHESTPLATE.get()).add(PAItems.LAPIS_LEGGINGS.get()).add(PAItems.LAPIS_BOOTS.get()).add(PAItems.LAPIS_HAMMER.get()).add(PAItems.LAPIS_EXCAVATOR.get()).add(PAItems.LAPIS_SICKLE.get()).add(PAItems.REDSTONE_SWORD.get()).add(PAItems.REDSTONE_SPEAR.get()).add(PAItems.REDSTONE_PICKAXE.get()).add(PAItems.REDSTONE_AXE.get()).add(PAItems.REDSTONE_SHOVEL.get()).add(PAItems.REDSTONE_HOE.get()).add(PAItems.REDSTONE_HELMET.get()).add(PAItems.REDSTONE_CHESTPLATE.get()).add(PAItems.REDSTONE_LEGGINGS.get()).add(PAItems.REDSTONE_BOOTS.get()).add(PAItems.REDSTONE_HAMMER.get()).add(PAItems.REDSTONE_EXCAVATOR.get()).add(PAItems.REDSTONE_SICKLE.get());

        tag(ItemTags.VANISHING_ENCHANTABLE).add(PAItems.EMERALD_SWORD.get()).add(PAItems.EMERALD_SPEAR.get()).add(PAItems.EMERALD_PICKAXE.get()).add(PAItems.EMERALD_AXE.get()).add(PAItems.EMERALD_SHOVEL.get()).add(PAItems.EMERALD_HOE.get()).add(PAItems.EMERALD_HELMET.get()).add(PAItems.EMERALD_CHESTPLATE.get()).add(PAItems.EMERALD_LEGGINGS.get()).add(PAItems.EMERALD_BOOTS.get()).add(PAItems.EMERALD_HORSE_ARMOR.get()).add(PAItems.EMERALD_NAUTILUS_ARMOR.get()).add(PAItems.EMERALD_HAMMER.get()).add(PAItems.EMERALD_EXCAVATOR.get()).add(PAItems.EMERALD_SICKLE.get()).add(PAItems.LAPIS_SWORD.get()).add(PAItems.LAPIS_SPEAR.get()).add(PAItems.LAPIS_PICKAXE.get()).add(PAItems.LAPIS_AXE.get()).add(PAItems.LAPIS_SHOVEL.get()).add(PAItems.LAPIS_HOE.get()).add(PAItems.LAPIS_HELMET.get()).add(PAItems.LAPIS_CHESTPLATE.get()).add(PAItems.LAPIS_LEGGINGS.get()).add(PAItems.LAPIS_BOOTS.get()).add(PAItems.LAPIS_HAMMER.get()).add(PAItems.LAPIS_EXCAVATOR.get()).add(PAItems.LAPIS_SICKLE.get()).add(PAItems.REDSTONE_SWORD.get()).add(PAItems.REDSTONE_SPEAR.get()).add(PAItems.REDSTONE_PICKAXE.get()).add(PAItems.REDSTONE_AXE.get()).add(PAItems.REDSTONE_SHOVEL.get()).add(PAItems.REDSTONE_HOE.get()).add(PAItems.REDSTONE_HELMET.get()).add(PAItems.REDSTONE_CHESTPLATE.get()).add(PAItems.REDSTONE_LEGGINGS.get()).add(PAItems.REDSTONE_BOOTS.get()).add(PAItems.REDSTONE_HAMMER.get()).add(PAItems.REDSTONE_EXCAVATOR.get()).add(PAItems.REDSTONE_SICKLE.get());

        tag(ItemTags.HEAD_ARMOR_ENCHANTABLE).add(PAItems.EMERALD_HELMET.get()).add(PAItems.LAPIS_HELMET.get()).add(PAItems.REDSTONE_HELMET.get());
        tag(ItemTags.CHEST_ARMOR_ENCHANTABLE).add(PAItems.EMERALD_CHESTPLATE.get()).add(PAItems.LAPIS_CHESTPLATE.get()).add(PAItems.REDSTONE_CHESTPLATE.get());
        tag(ItemTags.LEG_ARMOR_ENCHANTABLE).add(PAItems.EMERALD_LEGGINGS.get()).add(PAItems.LAPIS_LEGGINGS.get()).add(PAItems.REDSTONE_LEGGINGS.get());
        tag(ItemTags.FOOT_ARMOR_ENCHANTABLE).add(PAItems.EMERALD_BOOTS.get()).add(PAItems.LAPIS_BOOTS.get()).add(PAItems.REDSTONE_BOOTS.get());

        tag(ItemTags.EQUIPPABLE_ENCHANTABLE).add(PAItems.EMERALD_HELMET.get()).add(PAItems.EMERALD_CHESTPLATE.get()).add(PAItems.EMERALD_LEGGINGS.get()).add(PAItems.EMERALD_BOOTS.get()).add(PAItems.EMERALD_HORSE_ARMOR.get()).add(PAItems.EMERALD_NAUTILUS_ARMOR.get()).add(PAItems.LAPIS_HELMET.get()).add(PAItems.LAPIS_CHESTPLATE.get()).add(PAItems.LAPIS_LEGGINGS.get()).add(PAItems.LAPIS_BOOTS.get()).add(PAItems.REDSTONE_HELMET.get()).add(PAItems.REDSTONE_CHESTPLATE.get()).add(PAItems.REDSTONE_LEGGINGS.get()).add(PAItems.REDSTONE_BOOTS.get());
    }

    private void addVanillaTags() {
        tag(ItemTags.HEAD_ARMOR).add(PAItems.LEAD_HELMET.get()).add(PAItems.COBALT_HELMET.get()).add(PAItems.BALLISTIC_HELMET.get());
        tag(ItemTags.CHEST_ARMOR).add(PAItems.LEAD_CHESTPLATE.get()).add(PAItems.COBALT_CHESTPLATE.get()).add(PAItems.KEVLAR_VEST.get());
        tag(ItemTags.LEG_ARMOR).add(PAItems.LEAD_LEGGINGS.get()).add(PAItems.COBALT_LEGGINGS.get()).add(PAItems.KEVLAR_PANTS.get());
        tag(ItemTags.FOOT_ARMOR).add(PAItems.LEAD_BOOTS.get()).add(PAItems.COBALT_BOOTS.get()).add(PAItems.KEVLAR_BOOTS.get());
        tag(ItemTags.TRIMMABLE_ARMOR).add(PAItems.LEAD_HELMET.get()).add(PAItems.LEAD_CHESTPLATE.get()).add(PAItems.LEAD_LEGGINGS.get()).add(PAItems.LEAD_BOOTS.get()).add(PAItems.COBALT_HELMET.get()).add(PAItems.COBALT_CHESTPLATE.get()).add(PAItems.COBALT_LEGGINGS.get()).add(PAItems.COBALT_BOOTS.get()).add(PAItems.BALLISTIC_HELMET.get()).add(PAItems.KEVLAR_VEST.get()).add(PAItems.KEVLAR_PANTS.get()).add(PAItems.KEVLAR_BOOTS.get());

        tag(ItemTags.SPEARS).add(PAItems.LEAD_SPEAR.get()).add(PAItems.COBALT_SPEAR.get());

        tag(ItemTags.BEACON_PAYMENT_ITEMS).add(PAItems.LEAD_INGOT.get()).add(PAItems.COBALT_INGOT.get());

        tag(ItemTags.CLUSTER_MAX_HARVESTABLES).add(PAItems.LEAD_PICKAXE.get()).add(PAItems.COBALT_PICKAXE.get());

        tag(ItemTags.PICKAXES).add(PAItems.LEAD_PICKAXE.get()).add(PAItems.COBALT_PICKAXE.get());
        tag(ItemTags.AXES).add(PAItems.LEAD_AXE.get()).add(PAItems.COBALT_AXE.get());
        tag(ItemTags.SHOVELS).add(PAItems.LEAD_SHOVEL.get()).add(PAItems.COBALT_SHOVEL.get());
        tag(ItemTags.HOES).add(PAItems.LEAD_HOE.get()).add(PAItems.COBALT_HOE.get());
        tag(ItemTags.SWORDS).add(PAItems.LEAD_SWORD.get()).add(PAItems.COBALT_SWORD.get());

        tag(ItemTags.HEAD_ARMOR).add(PAItems.EMERALD_HELMET.get()).add(PAItems.LAPIS_HELMET.get()).add(PAItems.REDSTONE_HELMET.get());
        tag(ItemTags.CHEST_ARMOR).add(PAItems.EMERALD_CHESTPLATE.get()).add(PAItems.LAPIS_CHESTPLATE.get()).add(PAItems.REDSTONE_CHESTPLATE.get());
        tag(ItemTags.LEG_ARMOR).add(PAItems.EMERALD_LEGGINGS.get()).add(PAItems.LAPIS_LEGGINGS.get()).add(PAItems.REDSTONE_LEGGINGS.get());
        tag(ItemTags.FOOT_ARMOR).add(PAItems.EMERALD_BOOTS.get()).add(PAItems.LAPIS_BOOTS.get()).add(PAItems.REDSTONE_BOOTS.get());
        tag(ItemTags.TRIMMABLE_ARMOR).add(PAItems.EMERALD_HELMET.get()).add(PAItems.EMERALD_CHESTPLATE.get()).add(PAItems.EMERALD_LEGGINGS.get()).add(PAItems.EMERALD_BOOTS.get()).add(PAItems.LAPIS_HELMET.get()).add(PAItems.LAPIS_CHESTPLATE.get()).add(PAItems.LAPIS_LEGGINGS.get()).add(PAItems.LAPIS_BOOTS.get()).add(PAItems.REDSTONE_HELMET.get()).add(PAItems.REDSTONE_CHESTPLATE.get()).add(PAItems.REDSTONE_LEGGINGS.get()).add(PAItems.REDSTONE_BOOTS.get());

        tag(ItemTags.SPEARS).add(PAItems.EMERALD_SPEAR.get()).add(PAItems.LAPIS_SPEAR.get()).add(PAItems.REDSTONE_SPEAR.get());

        tag(ItemTags.PICKAXES).add(PAItems.EMERALD_PICKAXE.get()).add(PAItems.LAPIS_PICKAXE.get()).add(PAItems.REDSTONE_PICKAXE.get());
        tag(ItemTags.AXES).add(PAItems.EMERALD_AXE.get()).add(PAItems.LAPIS_AXE.get()).add(PAItems.REDSTONE_AXE.get());
        tag(ItemTags.SHOVELS).add(PAItems.EMERALD_SHOVEL.get()).add(PAItems.LAPIS_SHOVEL.get()).add(PAItems.REDSTONE_SHOVEL.get());
        tag(ItemTags.HOES).add(PAItems.EMERALD_HOE.get()).add(PAItems.LAPIS_HOE.get()).add(PAItems.REDSTONE_HOE.get());
        tag(ItemTags.SWORDS).add(PAItems.EMERALD_SWORD.get()).add(PAItems.LAPIS_SWORD.get()).add(PAItems.REDSTONE_SWORD.get());
    }

    private void addNeoForgeConventionTags() {
        tag(PATags.Items.INGOTS_LEAD).add(PAItems.LEAD_INGOT.get());
        tag(commonTag("nuggets/lead")).add(PAItems.LEAD_NUGGET.get());
        tag(commonTag("raw_materials/lead")).add(PAItems.RAW_LEAD.get());
        tag(commonTag("ores/lead")).add(PAItems.LEAD_ORE.get()).add(PAItems.DEEPSLATE_LEAD_ORE.get());
        tag(commonTag("storage_blocks/lead")).add(PAItems.LEAD_BLOCK.get());
        tag(commonTag("storage_blocks/raw_lead")).add(PAItems.RAW_LEAD_BLOCK.get());

        tag(PATags.Items.INGOTS_COBALT).add(PAItems.COBALT_INGOT.get());
        tag(commonTag("nuggets/cobalt")).add(PAItems.COBALT_NUGGET.get());
        tag(commonTag("raw_materials/cobalt")).add(PAItems.RAW_COBALT.get());
        tag(commonTag("ores/cobalt")).add(PAItems.COBALT_ORE.get()).add(PAItems.DEEPSLATE_COBALT_ORE.get());
        tag(commonTag("storage_blocks/cobalt")).add(PAItems.COBALT_BLOCK.get());
        tag(commonTag("storage_blocks/raw_cobalt")).add(PAItems.RAW_COBALT_BLOCK.get());

        tag(Tags.Items.INGOTS).addTag(PATags.Items.INGOTS_LEAD).addTag(PATags.Items.INGOTS_COBALT);
        tag(Tags.Items.NUGGETS).addTag(commonTag("nuggets/lead")).addTag(commonTag("nuggets/cobalt"));
        tag(Tags.Items.RAW_MATERIALS).addTag(commonTag("raw_materials/lead")).addTag(commonTag("raw_materials/cobalt"));
        tag(Tags.Items.ORES).addTag(commonTag("ores/lead")).addTag(commonTag("ores/cobalt"));
        tag(Tags.Items.STORAGE_BLOCKS).addTag(commonTag("storage_blocks/lead")).addTag(commonTag("storage_blocks/raw_lead")).addTag(commonTag("storage_blocks/cobalt")).addTag(commonTag("storage_blocks/raw_cobalt"));

        tag(Tags.Items.ORES_IN_GROUND_STONE).add(PAItems.LEAD_ORE.get()).add(PAItems.COBALT_ORE.get());
        tag(Tags.Items.ORES_IN_GROUND_DEEPSLATE).add(PAItems.DEEPSLATE_LEAD_ORE.get()).add(PAItems.DEEPSLATE_COBALT_ORE.get());
        tag(Tags.Items.ORE_RATES_SINGULAR).add(PAItems.LEAD_ORE.get()).add(PAItems.DEEPSLATE_LEAD_ORE.get()).add(PAItems.COBALT_ORE.get()).add(PAItems.DEEPSLATE_COBALT_ORE.get());

        tag(Tags.Items.TOOLS).add(PAItems.LEAD_SWORD.get()).add(PAItems.LEAD_PICKAXE.get()).add(PAItems.LEAD_AXE.get()).add(PAItems.LEAD_SHOVEL.get()).add(PAItems.LEAD_HOE.get()).add(PAItems.COBALT_SWORD.get()).add(PAItems.COBALT_PICKAXE.get()).add(PAItems.COBALT_AXE.get()).add(PAItems.COBALT_SHOVEL.get()).add(PAItems.COBALT_HOE.get()).add(PAItems.GOLDEN_HAMMER.get()).add(PAItems.COPPER_HAMMER.get()).add(PAItems.LEAD_HAMMER.get()).add(PAItems.IRON_HAMMER.get()).add(PAItems.COBALT_HAMMER.get()).add(PAItems.DIAMOND_HAMMER.get()).add(PAItems.NETHERITE_HAMMER.get()).add(PAItems.GOLDEN_EXCAVATOR.get()).add(PAItems.COPPER_EXCAVATOR.get()).add(PAItems.LEAD_EXCAVATOR.get()).add(PAItems.IRON_EXCAVATOR.get()).add(PAItems.COBALT_EXCAVATOR.get()).add(PAItems.DIAMOND_EXCAVATOR.get()).add(PAItems.NETHERITE_EXCAVATOR.get()).add(PAItems.GOLDEN_SICKLE.get()).add(PAItems.COPPER_SICKLE.get()).add(PAItems.LEAD_SICKLE.get()).add(PAItems.IRON_SICKLE.get()).add(PAItems.COBALT_SICKLE.get()).add(PAItems.DIAMOND_SICKLE.get()).add(PAItems.NETHERITE_SICKLE.get());

        tag(Tags.Items.ARMORS).add(PAItems.LEAD_HELMET.get()).add(PAItems.LEAD_CHESTPLATE.get()).add(PAItems.LEAD_LEGGINGS.get()).add(PAItems.LEAD_BOOTS.get()).add(PAItems.COBALT_HELMET.get()).add(PAItems.COBALT_CHESTPLATE.get()).add(PAItems.COBALT_LEGGINGS.get()).add(PAItems.COBALT_BOOTS.get()).add(PAItems.BALLISTIC_HELMET.get()).add(PAItems.KEVLAR_VEST.get()).add(PAItems.KEVLAR_PANTS.get()).add(PAItems.KEVLAR_BOOTS.get());

        tag(commonTag("tools/mining_tool")).add(PAItems.LEAD_PICKAXE.get()).add(PAItems.COBALT_PICKAXE.get()).add(PAItems.GOLDEN_HAMMER.get()).add(PAItems.COPPER_HAMMER.get()).add(PAItems.LEAD_HAMMER.get()).add(PAItems.IRON_HAMMER.get()).add(PAItems.COBALT_HAMMER.get()).add(PAItems.DIAMOND_HAMMER.get()).add(PAItems.NETHERITE_HAMMER.get()).add(PAItems.GOLDEN_EXCAVATOR.get()).add(PAItems.COPPER_EXCAVATOR.get()).add(PAItems.LEAD_EXCAVATOR.get()).add(PAItems.IRON_EXCAVATOR.get()).add(PAItems.COBALT_EXCAVATOR.get()).add(PAItems.DIAMOND_EXCAVATOR.get()).add(PAItems.NETHERITE_EXCAVATOR.get());

        tag(commonTag("tools/melee_weapon")).add(PAItems.LEAD_SWORD.get()).add(PAItems.LEAD_AXE.get()).add(PAItems.COBALT_SWORD.get()).add(PAItems.COBALT_AXE.get());

        tag(commonTag("tools/ranged_weapon")).add(PAItems.COBALT_BOW.get());
        tag(Tags.Items.TOOLS).add(PAItems.COBALT_BOW.get());

        tag(modTag("tools/hammers")).add(PAItems.GOLDEN_HAMMER.get()).add(PAItems.COPPER_HAMMER.get()).add(PAItems.LEAD_HAMMER.get()).add(PAItems.IRON_HAMMER.get()).add(PAItems.COBALT_HAMMER.get()).add(PAItems.DIAMOND_HAMMER.get()).add(PAItems.NETHERITE_HAMMER.get());

        tag(modTag("tools/excavators")).add(PAItems.GOLDEN_EXCAVATOR.get()).add(PAItems.COPPER_EXCAVATOR.get()).add(PAItems.LEAD_EXCAVATOR.get()).add(PAItems.IRON_EXCAVATOR.get()).add(PAItems.COBALT_EXCAVATOR.get()).add(PAItems.DIAMOND_EXCAVATOR.get()).add(PAItems.NETHERITE_EXCAVATOR.get());

        tag(modTag("tools/sickles")).add(PAItems.GOLDEN_SICKLE.get()).add(PAItems.COPPER_SICKLE.get()).add(PAItems.LEAD_SICKLE.get()).add(PAItems.IRON_SICKLE.get()).add(PAItems.COBALT_SICKLE.get()).add(PAItems.DIAMOND_SICKLE.get()).add(PAItems.NETHERITE_SICKLE.get());

        tag(commonTag("shields")).add(PAItems.KEVLAR_SHIELD.get());

        tag(Tags.Items.TOOLS).add(PAItems.EMERALD_SWORD.get()).add(PAItems.EMERALD_PICKAXE.get()).add(PAItems.EMERALD_AXE.get()).add(PAItems.EMERALD_SHOVEL.get()).add(PAItems.EMERALD_HOE.get()).add(PAItems.EMERALD_HAMMER.get()).add(PAItems.EMERALD_EXCAVATOR.get()).add(PAItems.EMERALD_SICKLE.get()).add(PAItems.LAPIS_SWORD.get()).add(PAItems.LAPIS_PICKAXE.get()).add(PAItems.LAPIS_AXE.get()).add(PAItems.LAPIS_SHOVEL.get()).add(PAItems.LAPIS_HOE.get()).add(PAItems.LAPIS_HAMMER.get()).add(PAItems.LAPIS_EXCAVATOR.get()).add(PAItems.LAPIS_SICKLE.get()).add(PAItems.REDSTONE_SWORD.get()).add(PAItems.REDSTONE_PICKAXE.get()).add(PAItems.REDSTONE_AXE.get()).add(PAItems.REDSTONE_SHOVEL.get()).add(PAItems.REDSTONE_HOE.get()).add(PAItems.REDSTONE_HAMMER.get()).add(PAItems.REDSTONE_EXCAVATOR.get()).add(PAItems.REDSTONE_SICKLE.get());

        tag(Tags.Items.ARMORS).add(PAItems.EMERALD_HELMET.get()).add(PAItems.EMERALD_CHESTPLATE.get()).add(PAItems.EMERALD_LEGGINGS.get()).add(PAItems.EMERALD_BOOTS.get()).add(PAItems.LAPIS_HELMET.get()).add(PAItems.LAPIS_CHESTPLATE.get()).add(PAItems.LAPIS_LEGGINGS.get()).add(PAItems.LAPIS_BOOTS.get()).add(PAItems.REDSTONE_HELMET.get()).add(PAItems.REDSTONE_CHESTPLATE.get()).add(PAItems.REDSTONE_LEGGINGS.get()).add(PAItems.REDSTONE_BOOTS.get());

        tag(commonTag("tools/mining_tool")).add(PAItems.EMERALD_PICKAXE.get()).add(PAItems.EMERALD_HAMMER.get()).add(PAItems.EMERALD_EXCAVATOR.get()).add(PAItems.LAPIS_PICKAXE.get()).add(PAItems.LAPIS_HAMMER.get()).add(PAItems.LAPIS_EXCAVATOR.get()).add(PAItems.REDSTONE_PICKAXE.get()).add(PAItems.REDSTONE_HAMMER.get()).add(PAItems.REDSTONE_EXCAVATOR.get());

        tag(commonTag("tools/melee_weapon")).add(PAItems.EMERALD_SWORD.get()).add(PAItems.EMERALD_AXE.get()).add(PAItems.LAPIS_SWORD.get()).add(PAItems.LAPIS_AXE.get()).add(PAItems.REDSTONE_SWORD.get()).add(PAItems.REDSTONE_AXE.get());

        tag(modTag("tools/hammers")).add(PAItems.EMERALD_HAMMER.get()).add(PAItems.LAPIS_HAMMER.get()).add(PAItems.REDSTONE_HAMMER.get());
        tag(modTag("tools/excavators")).add(PAItems.EMERALD_EXCAVATOR.get()).add(PAItems.LAPIS_EXCAVATOR.get()).add(PAItems.REDSTONE_EXCAVATOR.get());
        tag(modTag("tools/sickles")).add(PAItems.EMERALD_SICKLE.get()).add(PAItems.LAPIS_SICKLE.get()).add(PAItems.REDSTONE_SICKLE.get());
    }

    private void addCustomTags() {
        tag(PATags.Items.REPAIRS_LEAD_ARMOR).add(PAItems.LEAD_INGOT.get());
        tag(PATags.Items.LEAD_TOOL_MATERIALS).add(PAItems.LEAD_INGOT.get());
        tag(PATags.Items.REPAIRS_COBALT_ARMOR).add(PAItems.COBALT_INGOT.get());
        tag(PATags.Items.COBALT_TOOL_MATERIALS).add(PAItems.COBALT_INGOT.get());
        tag(PATags.Items.REPAIRS_KEVLAR_ARMOR).add(PAItems.KEVLAR_SHEET.get());
        TagKey<Item> curioTag = TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath("curios", "curio"));
        this.tag(curioTag).add(PAItems.BASIC_MAGNET.get()).add(PAItems.ADVANCED_MAGNET.get());

        TagKey<Item> curioBackTag = TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath("curios", "back"));
        this.tag(curioBackTag).add(PAItems.BASIC_BACKPACK.get()).add(PAItems.REINFORCED_BACKPACK.get());

        TagKey<Item> curioBeltTag = TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath("curios", "belt"));
        this.tag(curioBeltTag).add(PAItems.BASIC_QUIVER.get()).add(PAItems.REINFORCED_QUIVER.get()).add(PAItems.LEAD_DIVING_BELT.get());

        tag(PATags.Items.REPAIRS_EMERALD_ARMOR).add(Items.EMERALD);
        tag(PATags.Items.EMERALD_TOOL_MATERIALS).add(Items.EMERALD);

        tag(PATags.Items.REPAIRS_LAPIS_ARMOR).add(Items.LAPIS_LAZULI);
        tag(PATags.Items.LAPIS_TOOL_MATERIALS).add(Items.LAPIS_LAZULI);

        tag(PATags.Items.REPAIRS_REDSTONE_ARMOR).add(Items.REDSTONE);
        tag(PATags.Items.REDSTONE_TOOL_MATERIALS).add(Items.REDSTONE);
    }


    private static TagKey<Item> commonTag(String path) {
        return TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath("c", path));
    }

    private static TagKey<Item> modTag(String path) {
        return TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(PracticalAdditions.MODID, path));
    }
}