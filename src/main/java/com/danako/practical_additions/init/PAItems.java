package com.danako.practical_additions.init;

import com.danako.practical_additions.PracticalAdditions;
import com.danako.practical_additions.common.item.cobalt_bow.CobaltBowItem;
import com.danako.practical_additions.common.item.backpack.BackpackItem;
import com.danako.practical_additions.common.item.diving_belt.DivingBeltItem;
import com.danako.practical_additions.common.item.magnet.AdvancedMagnetItem;
import com.danako.practical_additions.common.item.magnet.BasicMagnetItem;
import com.danako.practical_additions.common.item.quiver.QuiverContents;
import com.danako.practical_additions.common.item.quiver.QuiverItem;
import com.danako.practical_additions.common.item.magnet.MagnetFilterData;
import com.danako.practical_additions.common.tool.aoe_tools.ExcavatorItem;
import com.danako.practical_additions.common.tool.aoe_tools.HammerItem;
import com.danako.practical_additions.common.tool.aoe_tools.SickleItem;
import com.danako.practical_additions.common.item.blunt.BluntItem;
import com.danako.practical_additions.init.data_components.PADataComponents;
import com.danako.practical_additions.model.backpack.Backpack;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.network.chat.TextColor;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.util.Util;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShieldItem;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.BlocksAttacks;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.equipment.EquipmentAsset;
import net.minecraft.world.item.equipment.EquipmentAssets;
import net.neoforged.neoforge.registries.DeferredItem;

import java.util.EnumMap;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import static com.danako.practical_additions.PracticalAdditions.ITEMS;

public class PAItems {


    public static final DeferredItem<Item> LEAD_INGOT = ITEMS.registerSimpleItem("lead_ingot");
    public static final DeferredItem<Item> RAW_LEAD = ITEMS.registerSimpleItem("raw_lead");
    public static final DeferredItem<Item> LEAD_NUGGET = ITEMS.registerSimpleItem("lead_nugget");

    public static final DeferredItem<Item> COBALT_INGOT = ITEMS.registerSimpleItem("cobalt_ingot");
    public static final DeferredItem<Item> RAW_COBALT = ITEMS.registerSimpleItem("raw_cobalt");
    public static final DeferredItem<Item> COBALT_NUGGET = ITEMS.registerSimpleItem("cobalt_nugget");

    public static final DeferredItem<BlockItem> LEAD_ORE = ITEMS.registerSimpleBlockItem(PABlocks.LEAD_ORE);
    public static final DeferredItem<BlockItem> DEEPSLATE_LEAD_ORE = ITEMS.registerSimpleBlockItem(PABlocks.DEEPSLATE_LEAD_ORE);
    public static final DeferredItem<BlockItem> RAW_LEAD_BLOCK = ITEMS.registerSimpleBlockItem(PABlocks.RAW_LEAD_BLOCK);
    public static final DeferredItem<BlockItem> LEAD_BLOCK = ITEMS.registerSimpleBlockItem(PABlocks.LEAD_BLOCK);
    public static final DeferredItem<BlockItem> DENSE_WEIGHTED_PRESSURE_PLATE = ITEMS.registerSimpleBlockItem(PABlocks.DENSE_WEIGHTED_PRESSURE_PLATE);

    public static final DeferredItem<BlockItem> COBALT_ORE = ITEMS.registerSimpleBlockItem(PABlocks.COBALT_ORE);
    public static final DeferredItem<BlockItem> DEEPSLATE_COBALT_ORE = ITEMS.registerSimpleBlockItem(PABlocks.DEEPSLATE_COBALT_ORE);
    public static final DeferredItem<BlockItem> RAW_COBALT_BLOCK = ITEMS.registerSimpleBlockItem(PABlocks.RAW_COBALT_BLOCK);
    public static final DeferredItem<BlockItem> COBALT_BLOCK = ITEMS.registerSimpleBlockItem(PABlocks.COBALT_BLOCK);

    public static final ToolMaterial LEAD_TOOL_MATERIAL = new ToolMaterial(PATags.Blocks.INCORRECT_FOR_LEAD_TOOL, 220, 5.5F, 1.5F, 14, PATags.Items.LEAD_TOOL_MATERIALS);

    public static final ToolMaterial COBALT_TOOL_MATERIAL = new ToolMaterial(PATags.Blocks.INCORRECT_FOR_COBALT_TOOL, 900, 7.25F, 4.0F, 12, PATags.Items.COBALT_TOOL_MATERIALS);

    public static final DeferredItem<Item> LEAD_SWORD = ITEMS.registerItem("lead_sword", props -> new Item(props.sword(LEAD_TOOL_MATERIAL, 3, -2.4F)));

    public static final DeferredItem<Item> LEAD_PICKAXE = ITEMS.registerItem("lead_pickaxe", props -> new Item(props.pickaxe(LEAD_TOOL_MATERIAL, 1.0F, -2.8F)));

    public static final DeferredItem<Item> LEAD_AXE = ITEMS.registerItem("lead_axe", props -> new Item(props.axe(LEAD_TOOL_MATERIAL, 6.0F, -3.1F)));

    public static final DeferredItem<Item> LEAD_SHOVEL = ITEMS.registerItem("lead_shovel", props -> new Item(props.shovel(LEAD_TOOL_MATERIAL, 1.5F, -3.0F)));

    public static final DeferredItem<Item> LEAD_HOE = ITEMS.registerItem("lead_hoe", props -> new Item(props.hoe(LEAD_TOOL_MATERIAL, -2.0F, -1.0F)));

    public static final DeferredItem<Item> LEAD_SPEAR = ITEMS.registerItem("lead_spear", props -> new Item(props.spear(LEAD_TOOL_MATERIAL, 0.90F, 0.885F, 0.625F, 3.25F, 8.5F, 7.5F, 5.1F, 11.875F, 4.6F)));

    public static final DeferredItem<Item> COBALT_SWORD = ITEMS.registerItem("cobalt_sword", props -> new Item(props.sword(COBALT_TOOL_MATERIAL, 3, -2.4F)));

    public static final DeferredItem<Item> COBALT_PICKAXE = ITEMS.registerItem("cobalt_pickaxe", props -> new Item(props.pickaxe(COBALT_TOOL_MATERIAL, 1.0F, -2.8F)));

    public static final DeferredItem<Item> COBALT_AXE = ITEMS.registerItem("cobalt_axe", props -> new Item(props.axe(COBALT_TOOL_MATERIAL, 6.0F, -3.1F)));

    public static final DeferredItem<Item> COBALT_SHOVEL = ITEMS.registerItem("cobalt_shovel", props -> new Item(props.shovel(COBALT_TOOL_MATERIAL, 1.5F, -3.0F)));

    public static final DeferredItem<Item> COBALT_HOE = ITEMS.registerItem("cobalt_hoe", props -> new Item(props.hoe(COBALT_TOOL_MATERIAL, -2.0F, -1.0F)));

    public static final DeferredItem<Item> COBALT_SPEAR = ITEMS.registerItem("cobalt_spear", props -> new Item(props.spear(COBALT_TOOL_MATERIAL, 1.00F, 1.0125F, 0.55F, 2.75F, 7.75F, 6.625F, 5.1F, 10.625F, 4.6F)));

    public static final DeferredItem<Item> COBALT_BOW = ITEMS.registerItem("cobalt_bow", props -> new CobaltBowItem(props.durability(900).enchantable(12)));

    public static final ResourceKey<EquipmentAsset> LEAD_ARMOR_ASSET = ResourceKey.create(EquipmentAssets.ROOT_ID, Identifier.fromNamespaceAndPath(PracticalAdditions.MODID, "lead"));

    public static final ArmorMaterial LEAD_ARMOR_MATERIAL = new ArmorMaterial(13, Util.make(new EnumMap<>(ArmorType.class), map -> {
        map.put(ArmorType.BOOTS, 2);
        map.put(ArmorType.LEGGINGS, 4);
        map.put(ArmorType.CHESTPLATE, 5);
        map.put(ArmorType.HELMET, 2);
        map.put(ArmorType.BODY, 5);
    }), 9, SoundEvents.ARMOR_EQUIP_IRON, 0.0F, 0.1F, PATags.Items.REPAIRS_LEAD_ARMOR, LEAD_ARMOR_ASSET);

    public static final ResourceKey<EquipmentAsset> COBALT_ARMOR_ASSET = ResourceKey.create(EquipmentAssets.ROOT_ID, Identifier.fromNamespaceAndPath(PracticalAdditions.MODID, "cobalt"));

    public static final ArmorMaterial COBALT_ARMOR_MATERIAL = new ArmorMaterial(24, Util.make(new EnumMap<>(ArmorType.class), map -> {
        map.put(ArmorType.BOOTS, 3);
        map.put(ArmorType.LEGGINGS, 6);
        map.put(ArmorType.CHESTPLATE, 7);
        map.put(ArmorType.HELMET, 3);
        map.put(ArmorType.BODY, 8);
    }), 10, SoundEvents.ARMOR_EQUIP_IRON, 1.0F, 0.0F, PATags.Items.REPAIRS_COBALT_ARMOR, COBALT_ARMOR_ASSET);

    public static final DeferredItem<Item> LEAD_HELMET = ITEMS.registerItem("lead_helmet", props -> newLeadArmorItem(ArmorType.HELMET, props));

    public static final DeferredItem<Item> LEAD_CHESTPLATE = ITEMS.registerItem("lead_chestplate", props -> newLeadArmorItem(ArmorType.CHESTPLATE, props));

    public static final DeferredItem<Item> LEAD_LEGGINGS = ITEMS.registerItem("lead_leggings", props -> newLeadArmorItem(ArmorType.LEGGINGS, props));

    public static final DeferredItem<Item> LEAD_BOOTS = ITEMS.registerItem("lead_boots", props -> newLeadArmorItem(ArmorType.BOOTS, props));

    private static Item newLeadArmorItem(ArmorType armorType, Item.Properties props) {
        return new Item(props.humanoidArmor(LEAD_ARMOR_MATERIAL, armorType)) {
            @Override
            public void appendHoverText(ItemStack stack, TooltipContext context, TooltipDisplay tooltipDisplay, Consumer<Component> tooltipAdder, TooltipFlag tooltipFlag) {
                super.appendHoverText(stack, context, tooltipDisplay, tooltipAdder, tooltipFlag);
                tooltipAdder.accept(Component.translatable("tooltip.practical_additions.lead.weighted").withStyle(Style.EMPTY.withColor(TextColor.fromRgb(0x8A5CF6))));
            }
        };
    }

    public static final DeferredItem<Item> LEAD_DIVING_BELT = ITEMS.registerItem("lead_diving_belt", props -> new DivingBeltItem(props.stacksTo(1).component(PADataComponents.DIVING_BELT_ACTIVE.get(), false)));

    public static final DeferredItem<Item> COBALT_HELMET = ITEMS.registerItem("cobalt_helmet", props -> newCobaltArmorItem(ArmorType.HELMET, props));

    public static final DeferredItem<Item> COBALT_CHESTPLATE = ITEMS.registerItem("cobalt_chestplate", props -> newCobaltArmorItem(ArmorType.CHESTPLATE, props));

    public static final DeferredItem<Item> COBALT_LEGGINGS = ITEMS.registerItem("cobalt_leggings", props -> newCobaltArmorItem(ArmorType.LEGGINGS, props));

    public static final DeferredItem<Item> COBALT_BOOTS = ITEMS.registerItem("cobalt_boots", props -> newCobaltArmorItem(ArmorType.BOOTS, props));

    private static Item newCobaltArmorItem(ArmorType armorType, Item.Properties props) {
        return new Item(props.humanoidArmor(COBALT_ARMOR_MATERIAL, armorType)) {
            @Override
            public void appendHoverText(ItemStack stack, TooltipContext context, TooltipDisplay tooltipDisplay, Consumer<Component> tooltipAdder, TooltipFlag tooltipFlag) {
                super.appendHoverText(stack, context, tooltipDisplay, tooltipAdder, tooltipFlag);
                tooltipAdder.accept(Component.translatable("tooltip.practical_additions.cobalt.swim_speed").withStyle(Style.EMPTY.withColor(TextColor.fromRgb(0x00FFFF))));
            }
        };
    }

    public static final DeferredItem<Item> LEAD_HORSE_ARMOR = ITEMS.registerItem("lead_horse_armor", props -> new Item(props.horseArmor(LEAD_ARMOR_MATERIAL)));

    public static final DeferredItem<Item> LEAD_NAUTILUS_ARMOR = ITEMS.registerItem("lead_nautilus_armor", props -> new Item(props.nautilusArmor(LEAD_ARMOR_MATERIAL)));

    public static final DeferredItem<Item> COBALT_HORSE_ARMOR = ITEMS.registerItem("cobalt_horse_armor", props -> new Item(props.horseArmor(COBALT_ARMOR_MATERIAL)));

    public static final DeferredItem<Item> COBALT_NAUTILUS_ARMOR = ITEMS.registerItem("cobalt_nautilus_armor", props -> new Item(props.nautilusArmor(COBALT_ARMOR_MATERIAL)));

    public static final DeferredItem<Item> GOLDEN_HAMMER = ITEMS.registerItem("golden_hammer", props -> new HammerItem(ToolMaterial.GOLD, 5.0F, -3.7F, props));
    public static final DeferredItem<Item> COPPER_HAMMER = ITEMS.registerItem("copper_hammer", props -> new HammerItem(ToolMaterial.COPPER, 5.0F, -3.7F, props));
    public static final DeferredItem<Item> LEAD_HAMMER = ITEMS.registerItem("lead_hammer", props -> new HammerItem(LEAD_TOOL_MATERIAL, 6.25F, -3.65F, props));
    public static final DeferredItem<Item> IRON_HAMMER = ITEMS.registerItem("iron_hammer", props -> new HammerItem(ToolMaterial.IRON, 6.75F, -3.6F, props));
    public static final DeferredItem<Item> COBALT_HAMMER = ITEMS.registerItem("cobalt_hammer", props -> new HammerItem(COBALT_TOOL_MATERIAL, 8.0F, -3.55F, props));
    public static final DeferredItem<Item> DIAMOND_HAMMER = ITEMS.registerItem("diamond_hammer", props -> new HammerItem(ToolMaterial.DIAMOND, 9.25F, -3.5F, props));
    public static final DeferredItem<Item> NETHERITE_HAMMER = ITEMS.registerItem("netherite_hammer", props -> new HammerItem(ToolMaterial.NETHERITE, 11.0F, -3.4F, props.fireResistant()));

    public static final DeferredItem<Item> GOLDEN_EXCAVATOR = ITEMS.registerItem("golden_excavator", props -> new ExcavatorItem(ToolMaterial.GOLD, 4.75F, -3.6F, props));
    public static final DeferredItem<Item> COPPER_EXCAVATOR = ITEMS.registerItem("copper_excavator", props -> new ExcavatorItem(ToolMaterial.COPPER, 4.75F, -3.6F, props));
    public static final DeferredItem<Item> LEAD_EXCAVATOR = ITEMS.registerItem("lead_excavator", props -> new ExcavatorItem(LEAD_TOOL_MATERIAL, 6.0F, -3.55F, props));
    public static final DeferredItem<Item> IRON_EXCAVATOR = ITEMS.registerItem("iron_excavator", props -> new ExcavatorItem(ToolMaterial.IRON, 6.5F, -3.5F, props));
    public static final DeferredItem<Item> COBALT_EXCAVATOR = ITEMS.registerItem("cobalt_excavator", props -> new ExcavatorItem(COBALT_TOOL_MATERIAL, 7.75F, -3.45F, props));
    public static final DeferredItem<Item> DIAMOND_EXCAVATOR = ITEMS.registerItem("diamond_excavator", props -> new ExcavatorItem(ToolMaterial.DIAMOND, 9.0F, -3.4F, props));
    public static final DeferredItem<Item> NETHERITE_EXCAVATOR = ITEMS.registerItem("netherite_excavator", props -> new ExcavatorItem(ToolMaterial.NETHERITE, 10.75F, -3.3F, props.fireResistant()));

    public static final DeferredItem<Item> GOLDEN_SICKLE = ITEMS.registerItem("golden_sickle", props -> new SickleItem(ToolMaterial.GOLD, 3.0F, -2.8F, props));
    public static final DeferredItem<Item> COPPER_SICKLE = ITEMS.registerItem("copper_sickle", props -> new SickleItem(ToolMaterial.COPPER, 3.0F, -2.8F, props));
    public static final DeferredItem<Item> LEAD_SICKLE = ITEMS.registerItem("lead_sickle", props -> new SickleItem(LEAD_TOOL_MATERIAL, 3.0F, -2.8F, props));
    public static final DeferredItem<Item> IRON_SICKLE = ITEMS.registerItem("iron_sickle", props -> new SickleItem(ToolMaterial.IRON, 3.0F, -2.8F, props));
    public static final DeferredItem<Item> COBALT_SICKLE = ITEMS.registerItem("cobalt_sickle", props -> new SickleItem(COBALT_TOOL_MATERIAL, 3.0F, -2.8F, props));
    public static final DeferredItem<Item> DIAMOND_SICKLE = ITEMS.registerItem("diamond_sickle", props -> new SickleItem(ToolMaterial.DIAMOND, 3.0F, -2.8F, props));
    public static final DeferredItem<Item> NETHERITE_SICKLE = ITEMS.registerItem("netherite_sickle", props -> new SickleItem(ToolMaterial.NETHERITE, 3.0F, -2.8F, props.fireResistant()));

    public static final ToolMaterial EMERALD_TOOL_MATERIAL = new ToolMaterial(PATags.Blocks.INCORRECT_FOR_EMERALD_TOOL, 1124, 8.5F, 3.5F, 12, PATags.Items.EMERALD_TOOL_MATERIALS);

    public static final DeferredItem<Item> EMERALD_SWORD = ITEMS.registerItem("emerald_sword", props -> new Item(props.sword(EMERALD_TOOL_MATERIAL, 3, -2.4F)));
    public static final DeferredItem<Item> EMERALD_PICKAXE = ITEMS.registerItem("emerald_pickaxe", props -> new Item(props.pickaxe(EMERALD_TOOL_MATERIAL, 1.0F, -2.8F)));
    public static final DeferredItem<Item> EMERALD_AXE = ITEMS.registerItem("emerald_axe", props -> new Item(props.axe(EMERALD_TOOL_MATERIAL, 6.0F, -3.1F)));
    public static final DeferredItem<Item> EMERALD_SHOVEL = ITEMS.registerItem("emerald_shovel", props -> new Item(props.shovel(EMERALD_TOOL_MATERIAL, 1.5F, -3.0F)));
    public static final DeferredItem<Item> EMERALD_HOE = ITEMS.registerItem("emerald_hoe", props -> new Item(props.hoe(EMERALD_TOOL_MATERIAL, -2.0F, -1.0F)));
    public static final DeferredItem<Item> EMERALD_SPEAR = ITEMS.registerItem("emerald_spear", props -> new Item(props.spear(EMERALD_TOOL_MATERIAL, 1.05F, 1.05F, 0.5F, 2.6F, 7.4F, 6.3F, 5.1F, 10.2F, 4.6F)));

    public static final ResourceKey<EquipmentAsset> EMERALD_ARMOR_ASSET = ResourceKey.create(EquipmentAssets.ROOT_ID, Identifier.fromNamespaceAndPath(PracticalAdditions.MODID, "emerald"));

    public static final ArmorMaterial EMERALD_ARMOR_MATERIAL = new ArmorMaterial(33, Util.make(new EnumMap<>(ArmorType.class), map -> {
        map.put(ArmorType.BOOTS, 3);
        map.put(ArmorType.LEGGINGS, 6);
        map.put(ArmorType.CHESTPLATE, 8);
        map.put(ArmorType.HELMET, 3);
        map.put(ArmorType.BODY, 11);
    }), 10, SoundEvents.ARMOR_EQUIP_DIAMOND, 1.0F, 0.0F, PATags.Items.REPAIRS_EMERALD_ARMOR, EMERALD_ARMOR_ASSET);

    public static final DeferredItem<Item> EMERALD_HELMET = ITEMS.registerItem("emerald_helmet", props -> new Item(props.humanoidArmor(EMERALD_ARMOR_MATERIAL, ArmorType.HELMET)));
    public static final DeferredItem<Item> EMERALD_CHESTPLATE = ITEMS.registerItem("emerald_chestplate", props -> new Item(props.humanoidArmor(EMERALD_ARMOR_MATERIAL, ArmorType.CHESTPLATE)));
    public static final DeferredItem<Item> EMERALD_LEGGINGS = ITEMS.registerItem("emerald_leggings", props -> new Item(props.humanoidArmor(EMERALD_ARMOR_MATERIAL, ArmorType.LEGGINGS)));
    public static final DeferredItem<Item> EMERALD_BOOTS = ITEMS.registerItem("emerald_boots", props -> new Item(props.humanoidArmor(EMERALD_ARMOR_MATERIAL, ArmorType.BOOTS)));
    public static final DeferredItem<Item> EMERALD_HORSE_ARMOR = ITEMS.registerItem("emerald_horse_armor", props -> new Item(props.horseArmor(EMERALD_ARMOR_MATERIAL)));
    public static final DeferredItem<Item> EMERALD_NAUTILUS_ARMOR = ITEMS.registerItem("emerald_nautilus_armor", props -> new Item(props.nautilusArmor(EMERALD_ARMOR_MATERIAL)));

    public static final DeferredItem<Item> EMERALD_HAMMER = ITEMS.registerItem("emerald_hammer", props -> new HammerItem(EMERALD_TOOL_MATERIAL, 9.75F, -3.45F, props));
    public static final DeferredItem<Item> EMERALD_EXCAVATOR = ITEMS.registerItem("emerald_excavator", props -> new ExcavatorItem(EMERALD_TOOL_MATERIAL, 9.5F, -3.35F, props));
    public static final DeferredItem<Item> EMERALD_SICKLE = ITEMS.registerItem("emerald_sickle", props -> new SickleItem(EMERALD_TOOL_MATERIAL, 3.0F, -2.8F, props));

    public static final ToolMaterial LAPIS_TOOL_MATERIAL = new ToolMaterial(BlockTags.INCORRECT_FOR_IRON_TOOL, 175, 6.0F, 1.5F, 30, PATags.Items.LAPIS_TOOL_MATERIALS);

    public static final DeferredItem<Item> LAPIS_SWORD = ITEMS.registerItem("lapis_sword", props -> new Item(props.sword(LAPIS_TOOL_MATERIAL, 3, -2.4F)));
    public static final DeferredItem<Item> LAPIS_PICKAXE = ITEMS.registerItem("lapis_pickaxe", props -> new Item(props.pickaxe(LAPIS_TOOL_MATERIAL, 1.0F, -2.8F)));
    public static final DeferredItem<Item> LAPIS_AXE = ITEMS.registerItem("lapis_axe", props -> new Item(props.axe(LAPIS_TOOL_MATERIAL, 6.0F, -3.1F)));
    public static final DeferredItem<Item> LAPIS_SHOVEL = ITEMS.registerItem("lapis_shovel", props -> new Item(props.shovel(LAPIS_TOOL_MATERIAL, 1.5F, -3.0F)));
    public static final DeferredItem<Item> LAPIS_HOE = ITEMS.registerItem("lapis_hoe", props -> new Item(props.hoe(LAPIS_TOOL_MATERIAL, -2.0F, -1.0F)));
    public static final DeferredItem<Item> LAPIS_SPEAR = ITEMS.registerItem("lapis_spear", props -> new Item(props.spear(LAPIS_TOOL_MATERIAL, 0.90F, 0.885F, 0.625F, 3.25F, 8.5F, 7.5F, 5.1F, 11.875F, 4.6F)));

    public static final ResourceKey<EquipmentAsset> LAPIS_ARMOR_ASSET = ResourceKey.create(EquipmentAssets.ROOT_ID, Identifier.fromNamespaceAndPath(PracticalAdditions.MODID, "lapis"));

    public static final ArmorMaterial LAPIS_ARMOR_MATERIAL = new ArmorMaterial(12, Util.make(new EnumMap<>(ArmorType.class), map -> {
        map.put(ArmorType.BOOTS, 1);
        map.put(ArmorType.LEGGINGS, 4);
        map.put(ArmorType.CHESTPLATE, 5);
        map.put(ArmorType.HELMET, 1);
        map.put(ArmorType.BODY, 8);
    }), 30, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, 0.0F, PATags.Items.REPAIRS_LAPIS_ARMOR, LAPIS_ARMOR_ASSET);

    public static final DeferredItem<Item> LAPIS_HELMET = ITEMS.registerItem("lapis_helmet", props -> new Item(props.humanoidArmor(LAPIS_ARMOR_MATERIAL, ArmorType.HELMET)));
    public static final DeferredItem<Item> LAPIS_CHESTPLATE = ITEMS.registerItem("lapis_chestplate", props -> new Item(props.humanoidArmor(LAPIS_ARMOR_MATERIAL, ArmorType.CHESTPLATE)));
    public static final DeferredItem<Item> LAPIS_LEGGINGS = ITEMS.registerItem("lapis_leggings", props -> new Item(props.humanoidArmor(LAPIS_ARMOR_MATERIAL, ArmorType.LEGGINGS)));
    public static final DeferredItem<Item> LAPIS_BOOTS = ITEMS.registerItem("lapis_boots", props -> new Item(props.humanoidArmor(LAPIS_ARMOR_MATERIAL, ArmorType.BOOTS)));

    public static final DeferredItem<Item> LAPIS_HAMMER = ITEMS.registerItem("lapis_hammer", props -> new HammerItem(LAPIS_TOOL_MATERIAL, 6.75F, -3.6F, props));
    public static final DeferredItem<Item> LAPIS_EXCAVATOR = ITEMS.registerItem("lapis_excavator", props -> new ExcavatorItem(LAPIS_TOOL_MATERIAL, 6.5F, -3.5F, props));
    public static final DeferredItem<Item> LAPIS_SICKLE = ITEMS.registerItem("lapis_sickle", props -> new SickleItem(LAPIS_TOOL_MATERIAL, 3.0F, -2.8F, props));

    public static final ToolMaterial REDSTONE_TOOL_MATERIAL = new ToolMaterial(BlockTags.INCORRECT_FOR_IRON_TOOL, 64, 10.0F, 3.0F, 22, PATags.Items.REDSTONE_TOOL_MATERIALS);

    public static final DeferredItem<Item> REDSTONE_SWORD = ITEMS.registerItem("redstone_sword", props -> new Item(props.sword(REDSTONE_TOOL_MATERIAL, 3, -2.4F)));
    public static final DeferredItem<Item> REDSTONE_PICKAXE = ITEMS.registerItem("redstone_pickaxe", props -> new Item(props.pickaxe(REDSTONE_TOOL_MATERIAL, 1.0F, -2.8F)));
    public static final DeferredItem<Item> REDSTONE_AXE = ITEMS.registerItem("redstone_axe", props -> new Item(props.axe(REDSTONE_TOOL_MATERIAL, 6.0F, -3.1F)));
    public static final DeferredItem<Item> REDSTONE_SHOVEL = ITEMS.registerItem("redstone_shovel", props -> new Item(props.shovel(REDSTONE_TOOL_MATERIAL, 1.5F, -3.0F)));
    public static final DeferredItem<Item> REDSTONE_HOE = ITEMS.registerItem("redstone_hoe", props -> new Item(props.hoe(REDSTONE_TOOL_MATERIAL, -2.0F, -1.0F)));
    public static final DeferredItem<Item> REDSTONE_SPEAR = ITEMS.registerItem("redstone_spear", props -> new Item(props.spear(REDSTONE_TOOL_MATERIAL, 1.00F, 1.0125F, 0.55F, 2.75F, 7.75F, 6.625F, 5.1F, 10.625F, 4.6F)));

    public static final ResourceKey<EquipmentAsset> REDSTONE_ARMOR_ASSET = ResourceKey.create(EquipmentAssets.ROOT_ID, Identifier.fromNamespaceAndPath(PracticalAdditions.MODID, "redstone"));

    public static final ArmorMaterial REDSTONE_ARMOR_MATERIAL = new ArmorMaterial(5, Util.make(new EnumMap<>(ArmorType.class), map -> {
        map.put(ArmorType.BOOTS, 1);
        map.put(ArmorType.LEGGINGS, 1);
        map.put(ArmorType.CHESTPLATE, 1);
        map.put(ArmorType.HELMET, 1);
        map.put(ArmorType.BODY, 2);
    }), 22, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, 0.0F, PATags.Items.REPAIRS_REDSTONE_ARMOR, REDSTONE_ARMOR_ASSET);

    public static final DeferredItem<Item> REDSTONE_HELMET = ITEMS.registerItem("redstone_helmet", props -> new Item(props.humanoidArmor(REDSTONE_ARMOR_MATERIAL, ArmorType.HELMET)));
    public static final DeferredItem<Item> REDSTONE_CHESTPLATE = ITEMS.registerItem("redstone_chestplate", props -> new Item(props.humanoidArmor(REDSTONE_ARMOR_MATERIAL, ArmorType.CHESTPLATE)));
    public static final DeferredItem<Item> REDSTONE_LEGGINGS = ITEMS.registerItem("redstone_leggings", props -> new Item(props.humanoidArmor(REDSTONE_ARMOR_MATERIAL, ArmorType.LEGGINGS)));
    public static final DeferredItem<Item> REDSTONE_BOOTS = ITEMS.registerItem("redstone_boots", props -> new Item(props.humanoidArmor(REDSTONE_ARMOR_MATERIAL, ArmorType.BOOTS)));

    public static final DeferredItem<Item> REDSTONE_HAMMER = ITEMS.registerItem("redstone_hammer", props -> new HammerItem(REDSTONE_TOOL_MATERIAL, 9.25F, -3.5F, props));
    public static final DeferredItem<Item> REDSTONE_EXCAVATOR = ITEMS.registerItem("redstone_excavator", props -> new ExcavatorItem(REDSTONE_TOOL_MATERIAL, 9.0F, -3.4F, props));
    public static final DeferredItem<Item> REDSTONE_SICKLE = ITEMS.registerItem("redstone_sickle", props -> new SickleItem(REDSTONE_TOOL_MATERIAL, 3.0F, -2.8F, props));

    public static final DeferredItem<Item> BASIC_MAGNET = ITEMS.registerItem("basic_magnet", props -> new BasicMagnetItem(props.stacksTo(1).component(PADataComponents.MAGNET_ACTIVE.get(), false)));

    public static final DeferredItem<Item> ADVANCED_MAGNET = ITEMS.registerItem("advanced_magnet", props -> new AdvancedMagnetItem(props.stacksTo(1).component(PADataComponents.MAGNET_ACTIVE.get(), false).component(PADataComponents.MAGNET_FILTER.get(), MagnetFilterData.EMPTY)));

    public static final DeferredItem<Item> KEVLAR_FIBER = ITEMS.registerSimpleItem("kevlar_fiber");
    public static final DeferredItem<Item> KEVLAR_SHEET = ITEMS.registerSimpleItem("kevlar_sheet");

    public static final ResourceKey<EquipmentAsset> KEVLAR_ARMOR_ASSET = ResourceKey.create(EquipmentAssets.ROOT_ID, Identifier.fromNamespaceAndPath(PracticalAdditions.MODID, "kevlar"));

    public static final ArmorMaterial KEVLAR_ARMOR_MATERIAL = new ArmorMaterial(24, Util.make(new EnumMap<>(ArmorType.class), map -> {
        map.put(ArmorType.BOOTS, 2);
        map.put(ArmorType.LEGGINGS, 6);
        map.put(ArmorType.CHESTPLATE, 7);
        map.put(ArmorType.HELMET, 3);
        map.put(ArmorType.BODY, 8);
    }), 12, SoundEvents.ARMOR_EQUIP_CHAIN, 1.75F, 0.05F, PATags.Items.REPAIRS_KEVLAR_ARMOR, KEVLAR_ARMOR_ASSET);
    public static final DeferredItem<Item> BALLISTIC_HELMET = ITEMS.registerItem("ballistic_helmet", props -> newKevlarArmorItem(ArmorType.HELMET, props));

    public static final DeferredItem<Item> KEVLAR_VEST = ITEMS.registerItem("kevlar_vest", props -> newKevlarArmorItem(ArmorType.CHESTPLATE, props));

    public static final DeferredItem<Item> KEVLAR_PANTS = ITEMS.registerItem("kevlar_pants", props -> newKevlarArmorItem(ArmorType.LEGGINGS, props));

    public static final DeferredItem<Item> KEVLAR_BOOTS = ITEMS.registerItem("kevlar_boots", props -> newKevlarArmorItem(ArmorType.BOOTS, props));

    private static Item newKevlarArmorItem(ArmorType armorType, Item.Properties props) {
        return new Item(props.humanoidArmor(KEVLAR_ARMOR_MATERIAL, armorType)) {
            @Override
            public void appendHoverText(ItemStack stack, TooltipContext context, TooltipDisplay tooltipDisplay, Consumer<Component> tooltipAdder, TooltipFlag tooltipFlag) {
                super.appendHoverText(stack, context, tooltipDisplay, tooltipAdder, tooltipFlag);
                tooltipAdder.accept(Component.translatable("tooltip.practical_additions.kevlar.projectile_protection").withStyle(Style.EMPTY.withColor(TextColor.fromRgb(0xFFD700))));
            }
        };
    }

    public static final DeferredItem<Item> BASIC_BACKPACK = ITEMS.registerItem("basic_backpack", props -> new BackpackItem(Backpack.BackpackType.BASIC, props.stacksTo(1)));
    public static final DeferredItem<Item> REINFORCED_BACKPACK = ITEMS.registerItem("reinforced_backpack", props -> new BackpackItem(Backpack.BackpackType.REINFORCED, props.stacksTo(1)));

    public static final DeferredItem<Item> BASIC_QUIVER = ITEMS.registerItem("basic_quiver", props -> new QuiverItem(QuiverItem.QuiverType.BASIC, props.stacksTo(1).component(PADataComponents.QUIVER_CONTENTS.get(), QuiverContents.EMPTY)));
    public static final DeferredItem<Item> REINFORCED_QUIVER = ITEMS.registerItem("reinforced_quiver", props -> new QuiverItem(QuiverItem.QuiverType.REINFORCED, props.stacksTo(1).component(PADataComponents.QUIVER_CONTENTS.get(), QuiverContents.EMPTY)));

    public static final DeferredItem<Item> KEVLAR_SHIELD = ITEMS.registerItem("kevlar_shield",
            props -> new ShieldItem(props.stacksTo(1).durability(1500).enchantable(9)
                    .component(DataComponents.BLOCKS_ATTACKS, new BlocksAttacks(
                            0.0F, 1.0F,
                            List.of(new BlocksAttacks.DamageReduction(90.0F, Optional.empty(), 0.0F, 1.0F)),
                            new BlocksAttacks.ItemDamageFunction(3.0F, 1.0F, 1.0F),
                            Optional.of(DamageTypeTags.BYPASSES_SHIELD),
                            Optional.of(SoundEvents.SHIELD_BLOCK),
                            Optional.of(SoundEvents.SHIELD_BREAK)))));

    public static final DeferredItem<Item> BLUNT = ITEMS.registerItem("blunt", BluntItem::new);

    public static final DeferredItem<BlockItem> WEED_CROP = ITEMS.registerSimpleBlockItem(PABlocks.WEED_CROP);
    public static final DeferredItem<Item> RAW_WEED = ITEMS.registerSimpleItem("raw_weed");
    public static final DeferredItem<Item> COOKED_WEED = ITEMS.registerSimpleItem("cooked_weed");

    public static void register() {
    }
}