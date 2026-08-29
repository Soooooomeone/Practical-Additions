package com.danako.practical_additions.datagen.misc;

import com.danako.practical_additions.init.PAItems;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

import java.util.concurrent.CompletableFuture;

public class PARecipeProvider extends RecipeProvider {
    private final HolderGetter<Item> items;

    public PARecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
        super(registries, output);
        this.items = registries.lookupOrThrow(Registries.ITEM);
    }

    @Override
    protected void buildRecipes() {
        buildSmelting();
        buildStorageAndNuggets();
        buildTools();
        buildArmor();
        buildAOETools();
        buildMagnets();
        buildKevlar();
        buildBackpacks();
        buildQuivers();
        buildHorseArmors();
        buildNautilusArmors();
        buildMisc();
    }

    private void buildSmelting() {
        var leadSmeltInputs = java.util.List.<net.minecraft.world.level.ItemLike>of(PAItems.RAW_LEAD.get(), PAItems.LEAD_ORE.get(), PAItems.DEEPSLATE_LEAD_ORE.get());

        oreSmelting(leadSmeltInputs, RecipeCategory.MISC, PAItems.LEAD_INGOT.get(), 0.7F, 200, "lead_ingot");
        oreBlasting(leadSmeltInputs, RecipeCategory.MISC, PAItems.LEAD_INGOT.get(), 0.7F, 100, "lead_ingot");

        var cobaltSmeltInputs = java.util.List.<net.minecraft.world.level.ItemLike>of(PAItems.RAW_COBALT.get(), PAItems.COBALT_ORE.get(), PAItems.DEEPSLATE_COBALT_ORE.get());

        oreSmelting(cobaltSmeltInputs, RecipeCategory.MISC, PAItems.COBALT_INGOT.get(), 1.0F, 200, "cobalt_ingot");
        oreBlasting(cobaltSmeltInputs, RecipeCategory.MISC, PAItems.COBALT_INGOT.get(), 1.0F, 100, "cobalt_ingot");
    }

    private void buildStorageAndNuggets() {
        nineBlockStorageRecipes(RecipeCategory.MISC, PAItems.LEAD_NUGGET.get(), RecipeCategory.MISC, PAItems.LEAD_INGOT.get(), "practical_additions:lead_ingot_from_nuggets", null, "practical_additions:lead_nugget_from_lead_ingot", null);
        nineBlockStorageRecipes(RecipeCategory.MISC, PAItems.RAW_LEAD.get(), RecipeCategory.MISC, PAItems.RAW_LEAD_BLOCK.get(), "practical_additions:raw_lead_block", null, "practical_additions:raw_lead_from_raw_lead_block", null);
        nineBlockStorageRecipes(RecipeCategory.MISC, PAItems.LEAD_INGOT.get(), RecipeCategory.MISC, PAItems.LEAD_BLOCK.get(), "practical_additions:lead_block", null, "practical_additions:lead_ingot_from_lead_block", null);

        nineBlockStorageRecipes(RecipeCategory.MISC, PAItems.COBALT_NUGGET.get(), RecipeCategory.MISC, PAItems.COBALT_INGOT.get(), "practical_additions:cobalt_ingot_from_nuggets", null, "practical_additions:cobalt_nugget_from_cobalt_ingot", null);
        nineBlockStorageRecipes(RecipeCategory.MISC, PAItems.RAW_COBALT.get(), RecipeCategory.MISC, PAItems.RAW_COBALT_BLOCK.get(), "practical_additions:raw_cobalt_block", null, "practical_additions:raw_cobalt_from_raw_cobalt_block", null);
        nineBlockStorageRecipes(RecipeCategory.MISC, PAItems.COBALT_INGOT.get(), RecipeCategory.MISC, PAItems.COBALT_BLOCK.get(), "practical_additions:cobalt_block", null, "practical_additions:cobalt_ingot_from_cobalt_block", null);
    }


    private void buildTools() {
        ShapedRecipeBuilder.shaped(items, RecipeCategory.COMBAT, PAItems.LEAD_SWORD.get()).pattern("X").pattern("X").pattern("S").define('X', PAItems.LEAD_INGOT.get()).define('S', Items.STICK).unlockedBy("has_lead_ingot", has(PAItems.LEAD_INGOT.get())).save(output);


        ShapedRecipeBuilder.shaped(items, RecipeCategory.TOOLS, PAItems.LEAD_PICKAXE.get()).pattern("XXX").pattern(" S ").pattern(" S ").define('X', PAItems.LEAD_INGOT.get()).define('S', Items.STICK).unlockedBy("has_lead_ingot", has(PAItems.LEAD_INGOT.get())).save(output);


        ShapedRecipeBuilder.shaped(items, RecipeCategory.TOOLS, PAItems.LEAD_AXE.get()).pattern("XX").pattern("XS").pattern(" S").define('X', PAItems.LEAD_INGOT.get()).define('S', Items.STICK).unlockedBy("has_lead_ingot", has(PAItems.LEAD_INGOT.get())).save(output);


        ShapedRecipeBuilder.shaped(items, RecipeCategory.TOOLS, PAItems.LEAD_SHOVEL.get()).pattern("X").pattern("S").pattern("S").define('X', PAItems.LEAD_INGOT.get()).define('S', Items.STICK).unlockedBy("has_lead_ingot", has(PAItems.LEAD_INGOT.get())).save(output);


        ShapedRecipeBuilder.shaped(items, RecipeCategory.TOOLS, PAItems.LEAD_HOE.get()).pattern("XX").pattern(" S").pattern(" S").define('X', PAItems.LEAD_INGOT.get()).define('S', Items.STICK).unlockedBy("has_lead_ingot", has(PAItems.LEAD_INGOT.get())).save(output);


        ShapedRecipeBuilder.shaped(items, RecipeCategory.COMBAT, PAItems.LEAD_SPEAR.get()).pattern("I").pattern("S").pattern("S").define('I', PAItems.LEAD_INGOT.get()).define('S', Items.STICK).unlockedBy("has_lead_ingot", has(PAItems.LEAD_INGOT.get())).save(output);

        ShapedRecipeBuilder.shaped(items, RecipeCategory.COMBAT, PAItems.COBALT_SWORD.get()).pattern("X").pattern("X").pattern("S").define('X', PAItems.COBALT_INGOT.get()).define('S', Items.STICK).unlockedBy("has_cobalt_ingot", has(PAItems.COBALT_INGOT.get())).save(output);

        ShapedRecipeBuilder.shaped(items, RecipeCategory.TOOLS, PAItems.COBALT_PICKAXE.get()).pattern("XXX").pattern(" S ").pattern(" S ").define('X', PAItems.COBALT_INGOT.get()).define('S', Items.STICK).unlockedBy("has_cobalt_ingot", has(PAItems.COBALT_INGOT.get())).save(output);

        ShapedRecipeBuilder.shaped(items, RecipeCategory.TOOLS, PAItems.COBALT_AXE.get()).pattern("XX").pattern("XS").pattern(" S").define('X', PAItems.COBALT_INGOT.get()).define('S', Items.STICK).unlockedBy("has_cobalt_ingot", has(PAItems.COBALT_INGOT.get())).save(output);

        ShapedRecipeBuilder.shaped(items, RecipeCategory.TOOLS, PAItems.COBALT_SHOVEL.get()).pattern("X").pattern("S").pattern("S").define('X', PAItems.COBALT_INGOT.get()).define('S', Items.STICK).unlockedBy("has_cobalt_ingot", has(PAItems.COBALT_INGOT.get())).save(output);

        ShapedRecipeBuilder.shaped(items, RecipeCategory.TOOLS, PAItems.COBALT_HOE.get()).pattern("XX").pattern(" S").pattern(" S").define('X', PAItems.COBALT_INGOT.get()).define('S', Items.STICK).unlockedBy("has_cobalt_ingot", has(PAItems.COBALT_INGOT.get())).save(output);

        ShapedRecipeBuilder.shaped(items, RecipeCategory.COMBAT, PAItems.COBALT_SPEAR.get()).pattern("I").pattern("S").pattern("S").define('I', PAItems.COBALT_INGOT.get()).define('S', Items.STICK).unlockedBy("has_cobalt_ingot", has(PAItems.COBALT_INGOT.get())).save(output);

        ShapedRecipeBuilder.shaped(items, RecipeCategory.COMBAT, PAItems.COBALT_BOW.get()).pattern(" SX").pattern("S X").pattern(" SX").define('X', PAItems.COBALT_INGOT.get()).define('S', Items.STRING).unlockedBy("has_cobalt_ingot", has(PAItems.COBALT_INGOT.get())).save(output);

        ShapedRecipeBuilder.shaped(items, RecipeCategory.COMBAT, PAItems.EMERALD_SWORD.get()).pattern("X").pattern("X").pattern("S").define('X', Items.EMERALD).define('S', Items.STICK).unlockedBy("has_emerald", has(Items.EMERALD)).save(output);
        ShapedRecipeBuilder.shaped(items, RecipeCategory.TOOLS, PAItems.EMERALD_PICKAXE.get()).pattern("XXX").pattern(" S ").pattern(" S ").define('X', Items.EMERALD).define('S', Items.STICK).unlockedBy("has_emerald", has(Items.EMERALD)).save(output);
        ShapedRecipeBuilder.shaped(items, RecipeCategory.TOOLS, PAItems.EMERALD_AXE.get()).pattern("XX").pattern("XS").pattern(" S").define('X', Items.EMERALD).define('S', Items.STICK).unlockedBy("has_emerald", has(Items.EMERALD)).save(output);
        ShapedRecipeBuilder.shaped(items, RecipeCategory.TOOLS, PAItems.EMERALD_SHOVEL.get()).pattern("X").pattern("S").pattern("S").define('X', Items.EMERALD).define('S', Items.STICK).unlockedBy("has_emerald", has(Items.EMERALD)).save(output);
        ShapedRecipeBuilder.shaped(items, RecipeCategory.TOOLS, PAItems.EMERALD_HOE.get()).pattern("XX").pattern(" S").pattern(" S").define('X', Items.EMERALD).define('S', Items.STICK).unlockedBy("has_emerald", has(Items.EMERALD)).save(output);
        ShapedRecipeBuilder.shaped(items, RecipeCategory.COMBAT, PAItems.EMERALD_SPEAR.get()).pattern("I").pattern("S").pattern("S").define('I', Items.EMERALD).define('S', Items.STICK).unlockedBy("has_emerald", has(Items.EMERALD)).save(output);

        ShapedRecipeBuilder.shaped(items, RecipeCategory.COMBAT, PAItems.LAPIS_SWORD.get()).pattern("X").pattern("X").pattern("S").define('X', Items.LAPIS_LAZULI).define('S', Items.STICK).unlockedBy("has_lapis", has(Items.LAPIS_LAZULI)).save(output);
        ShapedRecipeBuilder.shaped(items, RecipeCategory.TOOLS, PAItems.LAPIS_PICKAXE.get()).pattern("XXX").pattern(" S ").pattern(" S ").define('X', Items.LAPIS_LAZULI).define('S', Items.STICK).unlockedBy("has_lapis", has(Items.LAPIS_LAZULI)).save(output);
        ShapedRecipeBuilder.shaped(items, RecipeCategory.TOOLS, PAItems.LAPIS_AXE.get()).pattern("XX").pattern("XS").pattern(" S").define('X', Items.LAPIS_LAZULI).define('S', Items.STICK).unlockedBy("has_lapis", has(Items.LAPIS_LAZULI)).save(output);
        ShapedRecipeBuilder.shaped(items, RecipeCategory.TOOLS, PAItems.LAPIS_SHOVEL.get()).pattern("X").pattern("S").pattern("S").define('X', Items.LAPIS_LAZULI).define('S', Items.STICK).unlockedBy("has_lapis", has(Items.LAPIS_LAZULI)).save(output);
        ShapedRecipeBuilder.shaped(items, RecipeCategory.TOOLS, PAItems.LAPIS_HOE.get()).pattern("XX").pattern(" S").pattern(" S").define('X', Items.LAPIS_LAZULI).define('S', Items.STICK).unlockedBy("has_lapis", has(Items.LAPIS_LAZULI)).save(output);
        ShapedRecipeBuilder.shaped(items, RecipeCategory.COMBAT, PAItems.LAPIS_SPEAR.get()).pattern("I").pattern("S").pattern("S").define('I', Items.LAPIS_LAZULI).define('S', Items.STICK).unlockedBy("has_lapis", has(Items.LAPIS_LAZULI)).save(output);

        ShapedRecipeBuilder.shaped(items, RecipeCategory.COMBAT, PAItems.REDSTONE_SWORD.get()).pattern("X").pattern("X").pattern("S").define('X', Items.REDSTONE).define('S', Items.STICK).unlockedBy("has_redstone", has(Items.REDSTONE)).save(output);
        ShapedRecipeBuilder.shaped(items, RecipeCategory.TOOLS, PAItems.REDSTONE_PICKAXE.get()).pattern("XXX").pattern(" S ").pattern(" S ").define('X', Items.REDSTONE).define('S', Items.STICK).unlockedBy("has_redstone", has(Items.REDSTONE)).save(output);
        ShapedRecipeBuilder.shaped(items, RecipeCategory.TOOLS, PAItems.REDSTONE_AXE.get()).pattern("XX").pattern("XS").pattern(" S").define('X', Items.REDSTONE).define('S', Items.STICK).unlockedBy("has_redstone", has(Items.REDSTONE)).save(output);
        ShapedRecipeBuilder.shaped(items, RecipeCategory.TOOLS, PAItems.REDSTONE_SHOVEL.get()).pattern("X").pattern("S").pattern("S").define('X', Items.REDSTONE).define('S', Items.STICK).unlockedBy("has_redstone", has(Items.REDSTONE)).save(output);
        ShapedRecipeBuilder.shaped(items, RecipeCategory.TOOLS, PAItems.REDSTONE_HOE.get()).pattern("XX").pattern(" S").pattern(" S").define('X', Items.REDSTONE).define('S', Items.STICK).unlockedBy("has_redstone", has(Items.REDSTONE)).save(output);
        ShapedRecipeBuilder.shaped(items, RecipeCategory.COMBAT, PAItems.REDSTONE_SPEAR.get()).pattern("I").pattern("S").pattern("S").define('I', Items.REDSTONE).define('S', Items.STICK).unlockedBy("has_redstone", has(Items.REDSTONE)).save(output);
    }

    private void buildArmor() {
        ShapedRecipeBuilder.shaped(items, RecipeCategory.COMBAT, PAItems.LEAD_HELMET.get()).pattern("XXX").pattern("X X").define('X', PAItems.LEAD_INGOT.get()).unlockedBy("has_lead_ingot", has(PAItems.LEAD_INGOT.get())).save(output);

        ShapedRecipeBuilder.shaped(items, RecipeCategory.COMBAT, PAItems.LEAD_CHESTPLATE.get()).pattern("X X").pattern("XXX").pattern("XXX").define('X', PAItems.LEAD_INGOT.get()).unlockedBy("has_lead_ingot", has(PAItems.LEAD_INGOT.get())).save(output);

        ShapedRecipeBuilder.shaped(items, RecipeCategory.COMBAT, PAItems.LEAD_LEGGINGS.get()).pattern("XXX").pattern("X X").pattern("X X").define('X', PAItems.LEAD_INGOT.get()).unlockedBy("has_lead_ingot", has(PAItems.LEAD_INGOT.get())).save(output);

        ShapedRecipeBuilder.shaped(items, RecipeCategory.COMBAT, PAItems.LEAD_BOOTS.get()).pattern("X X").pattern("X X").define('X', PAItems.LEAD_INGOT.get()).unlockedBy("has_lead_ingot", has(PAItems.LEAD_INGOT.get())).save(output);

        ShapedRecipeBuilder.shaped(items, RecipeCategory.COMBAT, PAItems.COBALT_HELMET.get()).pattern("XXX").pattern("X X").define('X', PAItems.COBALT_INGOT.get()).unlockedBy("has_cobalt_ingot", has(PAItems.COBALT_INGOT.get())).save(output);

        ShapedRecipeBuilder.shaped(items, RecipeCategory.COMBAT, PAItems.COBALT_CHESTPLATE.get()).pattern("X X").pattern("XXX").pattern("XXX").define('X', PAItems.COBALT_INGOT.get()).unlockedBy("has_cobalt_ingot", has(PAItems.COBALT_INGOT.get())).save(output);

        ShapedRecipeBuilder.shaped(items, RecipeCategory.COMBAT, PAItems.COBALT_LEGGINGS.get()).pattern("XXX").pattern("X X").pattern("X X").define('X', PAItems.COBALT_INGOT.get()).unlockedBy("has_cobalt_ingot", has(PAItems.COBALT_INGOT.get())).save(output);

        ShapedRecipeBuilder.shaped(items, RecipeCategory.COMBAT, PAItems.COBALT_BOOTS.get()).pattern("X X").pattern("X X").define('X', PAItems.COBALT_INGOT.get()).unlockedBy("has_cobalt_ingot", has(PAItems.COBALT_INGOT.get())).save(output);

        ShapedRecipeBuilder.shaped(items, RecipeCategory.COMBAT, PAItems.EMERALD_HELMET.get()).pattern("XXX").pattern("X X").define('X', Items.EMERALD).unlockedBy("has_emerald", has(Items.EMERALD)).save(output);
        ShapedRecipeBuilder.shaped(items, RecipeCategory.COMBAT, PAItems.EMERALD_CHESTPLATE.get()).pattern("X X").pattern("XXX").pattern("XXX").define('X', Items.EMERALD).unlockedBy("has_emerald", has(Items.EMERALD)).save(output);
        ShapedRecipeBuilder.shaped(items, RecipeCategory.COMBAT, PAItems.EMERALD_LEGGINGS.get()).pattern("XXX").pattern("X X").pattern("X X").define('X', Items.EMERALD).unlockedBy("has_emerald", has(Items.EMERALD)).save(output);
        ShapedRecipeBuilder.shaped(items, RecipeCategory.COMBAT, PAItems.EMERALD_BOOTS.get()).pattern("X X").pattern("X X").define('X', Items.EMERALD).unlockedBy("has_emerald", has(Items.EMERALD)).save(output);

        ShapedRecipeBuilder.shaped(items, RecipeCategory.COMBAT, PAItems.LAPIS_HELMET.get()).pattern("XXX").pattern("X X").define('X', Items.LAPIS_LAZULI).unlockedBy("has_lapis", has(Items.LAPIS_LAZULI)).save(output);
        ShapedRecipeBuilder.shaped(items, RecipeCategory.COMBAT, PAItems.LAPIS_CHESTPLATE.get()).pattern("X X").pattern("XXX").pattern("XXX").define('X', Items.LAPIS_LAZULI).unlockedBy("has_lapis", has(Items.LAPIS_LAZULI)).save(output);
        ShapedRecipeBuilder.shaped(items, RecipeCategory.COMBAT, PAItems.LAPIS_LEGGINGS.get()).pattern("XXX").pattern("X X").pattern("X X").define('X', Items.LAPIS_LAZULI).unlockedBy("has_lapis", has(Items.LAPIS_LAZULI)).save(output);
        ShapedRecipeBuilder.shaped(items, RecipeCategory.COMBAT, PAItems.LAPIS_BOOTS.get()).pattern("X X").pattern("X X").define('X', Items.LAPIS_LAZULI).unlockedBy("has_lapis", has(Items.LAPIS_LAZULI)).save(output);

        ShapedRecipeBuilder.shaped(items, RecipeCategory.COMBAT, PAItems.REDSTONE_HELMET.get()).pattern("XXX").pattern("X X").define('X', Items.REDSTONE).unlockedBy("has_redstone", has(Items.REDSTONE)).save(output);
        ShapedRecipeBuilder.shaped(items, RecipeCategory.COMBAT, PAItems.REDSTONE_CHESTPLATE.get()).pattern("X X").pattern("XXX").pattern("XXX").define('X', Items.REDSTONE).unlockedBy("has_redstone", has(Items.REDSTONE)).save(output);
        ShapedRecipeBuilder.shaped(items, RecipeCategory.COMBAT, PAItems.REDSTONE_LEGGINGS.get()).pattern("XXX").pattern("X X").pattern("X X").define('X', Items.REDSTONE).unlockedBy("has_redstone", has(Items.REDSTONE)).save(output);
        ShapedRecipeBuilder.shaped(items, RecipeCategory.COMBAT, PAItems.REDSTONE_BOOTS.get()).pattern("X X").pattern("X X").define('X', Items.REDSTONE).unlockedBy("has_redstone", has(Items.REDSTONE)).save(output);

    }


    private void buildAOETools() {

        ShapedRecipeBuilder.shaped(items, RecipeCategory.TOOLS, PAItems.GOLDEN_HAMMER.get()).pattern("MMM").pattern("MSM").pattern(" S ").define('M', Items.GOLD_INGOT).define('S', Items.STICK).unlockedBy("has_gold_ingot", has(Items.GOLD_INGOT)).save(output);

        ShapedRecipeBuilder.shaped(items, RecipeCategory.TOOLS, PAItems.COPPER_HAMMER.get()).pattern("MMM").pattern("MSM").pattern(" S ").define('M', Items.COPPER_INGOT).define('S', Items.STICK).unlockedBy("has_copper_ingot", has(Items.COPPER_INGOT)).save(output);

        ShapedRecipeBuilder.shaped(items, RecipeCategory.TOOLS, PAItems.LEAD_HAMMER.get()).pattern("MMM").pattern("MSM").pattern(" S ").define('M', PAItems.LEAD_INGOT.get()).define('S', Items.STICK).unlockedBy("has_lead_ingot", has(PAItems.LEAD_INGOT.get())).save(output);

        ShapedRecipeBuilder.shaped(items, RecipeCategory.TOOLS, PAItems.IRON_HAMMER.get()).pattern("MMM").pattern("MSM").pattern(" S ").define('M', Items.IRON_INGOT).define('S', Items.STICK).unlockedBy("has_iron_ingot", has(Items.IRON_INGOT)).save(output);

        ShapedRecipeBuilder.shaped(items, RecipeCategory.TOOLS, PAItems.DIAMOND_HAMMER.get()).pattern("MMM").pattern("MSM").pattern(" S ").define('M', Items.DIAMOND).define('S', Items.STICK).unlockedBy("has_diamond", has(Items.DIAMOND)).save(output);

        netheriteSmithing(PAItems.DIAMOND_HAMMER.get(), RecipeCategory.TOOLS, PAItems.NETHERITE_HAMMER.get());

        ShapedRecipeBuilder.shaped(items, RecipeCategory.TOOLS, PAItems.COBALT_HAMMER.get()).pattern("MMM").pattern("MSM").pattern(" S ").define('M', PAItems.COBALT_INGOT.get()).define('S', Items.STICK).unlockedBy("has_cobalt_ingot", has(PAItems.COBALT_INGOT.get())).save(output);


        ShapedRecipeBuilder.shaped(items, RecipeCategory.TOOLS, PAItems.GOLDEN_EXCAVATOR.get()).pattern(" M ").pattern("MSM").pattern(" S ").define('M', Items.GOLD_INGOT).define('S', Items.STICK).unlockedBy("has_gold_ingot", has(Items.GOLD_INGOT)).save(output);

        ShapedRecipeBuilder.shaped(items, RecipeCategory.TOOLS, PAItems.COPPER_EXCAVATOR.get()).pattern(" M ").pattern("MSM").pattern(" S ").define('M', Items.COPPER_INGOT).define('S', Items.STICK).unlockedBy("has_copper_ingot", has(Items.COPPER_INGOT)).save(output);

        ShapedRecipeBuilder.shaped(items, RecipeCategory.TOOLS, PAItems.LEAD_EXCAVATOR.get()).pattern(" M ").pattern("MSM").pattern(" S ").define('M', PAItems.LEAD_INGOT.get()).define('S', Items.STICK).unlockedBy("has_lead_ingot", has(PAItems.LEAD_INGOT.get())).save(output);

        ShapedRecipeBuilder.shaped(items, RecipeCategory.TOOLS, PAItems.IRON_EXCAVATOR.get()).pattern(" M ").pattern("MSM").pattern(" S ").define('M', Items.IRON_INGOT).define('S', Items.STICK).unlockedBy("has_iron_ingot", has(Items.IRON_INGOT)).save(output);

        ShapedRecipeBuilder.shaped(items, RecipeCategory.TOOLS, PAItems.DIAMOND_EXCAVATOR.get()).pattern(" M ").pattern("MSM").pattern(" S ").define('M', Items.DIAMOND).define('S', Items.STICK).unlockedBy("has_diamond", has(Items.DIAMOND)).save(output);

        netheriteSmithing(PAItems.DIAMOND_EXCAVATOR.get(), RecipeCategory.TOOLS, PAItems.NETHERITE_EXCAVATOR.get());

        ShapedRecipeBuilder.shaped(items, RecipeCategory.TOOLS, PAItems.COBALT_EXCAVATOR.get()).pattern(" M ").pattern("MSM").pattern(" S ").define('M', PAItems.COBALT_INGOT.get()).define('S', Items.STICK).unlockedBy("has_cobalt_ingot", has(PAItems.COBALT_INGOT.get())).save(output);


        ShapedRecipeBuilder.shaped(items, RecipeCategory.TOOLS, PAItems.GOLDEN_SICKLE.get()).pattern(" M ").pattern("  M").pattern("SM ").define('M', Items.GOLD_INGOT).define('S', Items.STICK).unlockedBy("has_gold_ingot", has(Items.GOLD_INGOT)).save(output);

        ShapedRecipeBuilder.shaped(items, RecipeCategory.TOOLS, PAItems.COPPER_SICKLE.get()).pattern(" M ").pattern("  M").pattern("SM ").define('M', Items.COPPER_INGOT).define('S', Items.STICK).unlockedBy("has_copper_ingot", has(Items.COPPER_INGOT)).save(output);

        ShapedRecipeBuilder.shaped(items, RecipeCategory.TOOLS, PAItems.LEAD_SICKLE.get()).pattern(" M ").pattern("  M").pattern("SM ").define('M', PAItems.LEAD_INGOT.get()).define('S', Items.STICK).unlockedBy("has_lead_ingot", has(PAItems.LEAD_INGOT.get())).save(output);

        ShapedRecipeBuilder.shaped(items, RecipeCategory.TOOLS, PAItems.IRON_SICKLE.get()).pattern(" M ").pattern("  M").pattern("SM ").define('M', Items.IRON_INGOT).define('S', Items.STICK).unlockedBy("has_iron_ingot", has(Items.IRON_INGOT)).save(output);

        ShapedRecipeBuilder.shaped(items, RecipeCategory.TOOLS, PAItems.DIAMOND_SICKLE.get()).pattern(" M ").pattern("  M").pattern("SM ").define('M', Items.DIAMOND).define('S', Items.STICK).unlockedBy("has_diamond", has(Items.DIAMOND)).save(output);

        netheriteSmithing(PAItems.DIAMOND_SICKLE.get(), RecipeCategory.TOOLS, PAItems.NETHERITE_SICKLE.get());

        ShapedRecipeBuilder.shaped(items, RecipeCategory.TOOLS, PAItems.COBALT_SICKLE.get()).pattern(" M ").pattern("  M").pattern("SM ").define('M', PAItems.COBALT_INGOT.get()).define('S', Items.STICK).unlockedBy("has_cobalt_ingot", has(PAItems.COBALT_INGOT.get())).save(output);

        ShapedRecipeBuilder.shaped(items, RecipeCategory.TOOLS, PAItems.EMERALD_HAMMER.get()).pattern("MMM").pattern("MSM").pattern(" S ").define('M', Items.EMERALD).define('S', Items.STICK).unlockedBy("has_emerald", has(Items.EMERALD)).save(output);
        ShapedRecipeBuilder.shaped(items, RecipeCategory.TOOLS, PAItems.EMERALD_EXCAVATOR.get()).pattern(" M ").pattern("MSM").pattern(" S ").define('M', Items.EMERALD).define('S', Items.STICK).unlockedBy("has_emerald", has(Items.EMERALD)).save(output);
        ShapedRecipeBuilder.shaped(items, RecipeCategory.TOOLS, PAItems.EMERALD_SICKLE.get()).pattern(" M ").pattern("  M").pattern("SM ").define('M', Items.EMERALD).define('S', Items.STICK).unlockedBy("has_emerald", has(Items.EMERALD)).save(output);

        ShapedRecipeBuilder.shaped(items, RecipeCategory.TOOLS, PAItems.LAPIS_HAMMER.get()).pattern("MMM").pattern("MSM").pattern(" S ").define('M', Items.LAPIS_LAZULI).define('S', Items.STICK).unlockedBy("has_lapis", has(Items.LAPIS_LAZULI)).save(output);
        ShapedRecipeBuilder.shaped(items, RecipeCategory.TOOLS, PAItems.LAPIS_EXCAVATOR.get()).pattern(" M ").pattern("MSM").pattern(" S ").define('M', Items.LAPIS_LAZULI).define('S', Items.STICK).unlockedBy("has_lapis", has(Items.LAPIS_LAZULI)).save(output);
        ShapedRecipeBuilder.shaped(items, RecipeCategory.TOOLS, PAItems.LAPIS_SICKLE.get()).pattern(" M ").pattern("  M").pattern("SM ").define('M', Items.LAPIS_LAZULI).define('S', Items.STICK).unlockedBy("has_lapis", has(Items.LAPIS_LAZULI)).save(output);

        ShapedRecipeBuilder.shaped(items, RecipeCategory.TOOLS, PAItems.REDSTONE_HAMMER.get()).pattern("MMM").pattern("MSM").pattern(" S ").define('M', Items.REDSTONE).define('S', Items.STICK).unlockedBy("has_redstone", has(Items.REDSTONE)).save(output);
        ShapedRecipeBuilder.shaped(items, RecipeCategory.TOOLS, PAItems.REDSTONE_EXCAVATOR.get()).pattern(" M ").pattern("MSM").pattern(" S ").define('M', Items.REDSTONE).define('S', Items.STICK).unlockedBy("has_redstone", has(Items.REDSTONE)).save(output);
        ShapedRecipeBuilder.shaped(items, RecipeCategory.TOOLS, PAItems.REDSTONE_SICKLE.get()).pattern(" M ").pattern("  M").pattern("SM ").define('M', Items.REDSTONE).define('S', Items.STICK).unlockedBy("has_redstone", has(Items.REDSTONE)).save(output);

    }

    private void buildMagnets() {
        ShapedRecipeBuilder.shaped(items, RecipeCategory.TOOLS, PAItems.BASIC_MAGNET.get()).pattern("R L").pattern("I E").pattern("III").define('I', Items.IRON_INGOT).define('L', Items.LAPIS_LAZULI).define('R', Items.REDSTONE).define('E', Items.ENDER_PEARL).unlockedBy("has_ender_pearl", has(Items.ENDER_PEARL)).save(output);

        ShapedRecipeBuilder.shaped(items, RecipeCategory.TOOLS, PAItems.ADVANCED_MAGNET.get()).pattern("D A").pattern("C B").pattern("CCC").define('C', PAItems.COBALT_INGOT.get()).define('D', Items.DIAMOND).define('A', Items.AMETHYST_SHARD).define('B', PAItems.BASIC_MAGNET.get()).unlockedBy("has_basic_magnet", has(PAItems.BASIC_MAGNET.get())).save(output);
    }

    private void buildKevlar() {
        ShapedRecipeBuilder.shaped(items, RecipeCategory.MISC, PAItems.KEVLAR_FIBER.get()).pattern("SSS").pattern("SGS").pattern("SSS").define('S', Items.STRING).define('G', Items.GOLD_NUGGET).unlockedBy("has_string", has(Items.STRING)).save(output);
        ShapedRecipeBuilder.shaped(items, RecipeCategory.MISC, PAItems.KEVLAR_SHEET.get()).pattern("FF").pattern("FF").define('F', PAItems.KEVLAR_FIBER.get()).unlockedBy("has_kevlar_fiber", has(PAItems.KEVLAR_FIBER.get())).save(output);

        ShapedRecipeBuilder.shaped(items, RecipeCategory.COMBAT, PAItems.BALLISTIC_HELMET.get()).pattern("XXX").pattern("X X").define('X', PAItems.KEVLAR_SHEET.get()).unlockedBy("has_kevlar_sheet", has(PAItems.KEVLAR_SHEET.get())).save(output);

        ShapedRecipeBuilder.shaped(items, RecipeCategory.COMBAT, PAItems.KEVLAR_VEST.get()).pattern("X X").pattern("XXX").pattern("XXX").define('X', PAItems.KEVLAR_SHEET.get()).unlockedBy("has_kevlar_sheet", has(PAItems.KEVLAR_SHEET.get())).save(output);

        ShapedRecipeBuilder.shaped(items, RecipeCategory.COMBAT, PAItems.KEVLAR_PANTS.get()).pattern("XXX").pattern("X X").pattern("X X").define('X', PAItems.KEVLAR_SHEET.get()).unlockedBy("has_kevlar_sheet", has(PAItems.KEVLAR_SHEET.get())).save(output);

        ShapedRecipeBuilder.shaped(items, RecipeCategory.COMBAT, PAItems.KEVLAR_BOOTS.get()).pattern("X X").pattern("X X").define('X', PAItems.KEVLAR_SHEET.get()).unlockedBy("has_kevlar_sheet", has(PAItems.KEVLAR_SHEET.get())).save(output);

        ShapedRecipeBuilder.shaped(items, RecipeCategory.COMBAT, PAItems.KEVLAR_SHIELD.get()).pattern("KKK").pattern("KSK").pattern(" K ").define('K', PAItems.KEVLAR_SHEET.get()).define('S', Items.SHIELD).unlockedBy("has_kevlar_sheet", has(PAItems.KEVLAR_SHEET.get())).save(output);
    }

    private void buildBackpacks() {
        ShapedRecipeBuilder.shaped(items, RecipeCategory.TOOLS, PAItems.BASIC_BACKPACK.get()).pattern("LIL").pattern("LCL").pattern("LSL").define('L', Items.LEATHER).define('I', Items.IRON_INGOT).define('C', Items.CHEST).define('S', Items.STRING).unlockedBy("has_chest", has(Items.CHEST)).save(output);

        ShapedRecipeBuilder.shaped(items, RecipeCategory.TOOLS, PAItems.REINFORCED_BACKPACK.get()).pattern("KKK").pattern("KBK").pattern("KKK").define('K', PAItems.KEVLAR_SHEET.get()).define('B', PAItems.BASIC_BACKPACK.get()).unlockedBy("has_basic_backpack", has(PAItems.BASIC_BACKPACK.get())).save(output);
    }

    private void buildQuivers() {
        ShapedRecipeBuilder.shaped(items, RecipeCategory.TOOLS, PAItems.BASIC_QUIVER.get()).pattern(" SL").pattern("S L").pattern(" LL").define('S', Items.STRING).define('L', Items.LEATHER).unlockedBy("has_leather", has(Items.LEATHER)).save(output);

        ShapedRecipeBuilder.shaped(items, RecipeCategory.TOOLS, PAItems.REINFORCED_QUIVER.get()).pattern("KKK").pattern("KQK").pattern("KKK").define('K', PAItems.KEVLAR_SHEET.get()).define('Q', PAItems.BASIC_QUIVER.get()).unlockedBy("has_basic_quiver", has(PAItems.BASIC_QUIVER.get())).save(output);
    }

    private void buildHorseArmors() {
        String[] pattern = {"X X", "XXX", "X X"};

        ShapedRecipeBuilder.shaped(items, RecipeCategory.MISC, Items.COPPER_HORSE_ARMOR).pattern(pattern[0]).pattern(pattern[1]).pattern(pattern[2]).define('X', Items.COPPER_INGOT).unlockedBy("has_copper", has(Items.COPPER_INGOT)).save(output);

        ShapedRecipeBuilder.shaped(items, RecipeCategory.MISC, Items.IRON_HORSE_ARMOR).pattern(pattern[0]).pattern(pattern[1]).pattern(pattern[2]).define('X', Items.IRON_INGOT).unlockedBy("has_iron", has(Items.IRON_INGOT)).save(output);

        ShapedRecipeBuilder.shaped(items, RecipeCategory.MISC, Items.GOLDEN_HORSE_ARMOR).pattern(pattern[0]).pattern(pattern[1]).pattern(pattern[2]).define('X', Items.GOLD_INGOT).unlockedBy("has_gold", has(Items.GOLD_INGOT)).save(output);

        ShapedRecipeBuilder.shaped(items, RecipeCategory.MISC, Items.DIAMOND_HORSE_ARMOR).pattern(pattern[0]).pattern(pattern[1]).pattern(pattern[2]).define('X', Items.DIAMOND).unlockedBy("has_diamond", has(Items.DIAMOND)).save(output);

        ShapedRecipeBuilder.shaped(items, RecipeCategory.MISC, PAItems.LEAD_HORSE_ARMOR.get()).pattern(pattern[0]).pattern(pattern[1]).pattern(pattern[2]).define('X', PAItems.LEAD_INGOT.get()).unlockedBy("has_lead", has(PAItems.LEAD_INGOT.get())).save(output);

        ShapedRecipeBuilder.shaped(items, RecipeCategory.MISC, PAItems.COBALT_HORSE_ARMOR.get()).pattern(pattern[0]).pattern(pattern[1]).pattern(pattern[2]).define('X', PAItems.COBALT_INGOT.get()).unlockedBy("has_cobalt", has(PAItems.COBALT_INGOT.get())).save(output);

        netheriteSmithing(Items.DIAMOND_HORSE_ARMOR, RecipeCategory.MISC, Items.NETHERITE_HORSE_ARMOR);

        ShapedRecipeBuilder.shaped(items, RecipeCategory.MISC, PAItems.EMERALD_HORSE_ARMOR.get()).pattern(pattern[0]).pattern(pattern[1]).pattern(pattern[2]).define('X', Items.EMERALD).unlockedBy("has_emerald", has(Items.EMERALD)).save(output);
    }

    private void buildNautilusArmors() {
        String[] pattern = {"XXX", "XNX", "XXX"};

        ShapedRecipeBuilder.shaped(items, RecipeCategory.COMBAT, Items.COPPER_NAUTILUS_ARMOR).pattern(pattern[0]).pattern(pattern[1]).pattern(pattern[2]).define('X', Items.COPPER_INGOT).define('N', Items.NAUTILUS_SHELL).unlockedBy("has_nautilus", has(Items.NAUTILUS_SHELL)).save(output);

        ShapedRecipeBuilder.shaped(items, RecipeCategory.COMBAT, Items.IRON_NAUTILUS_ARMOR).pattern(pattern[0]).pattern(pattern[1]).pattern(pattern[2]).define('X', Items.IRON_INGOT).define('N', Items.NAUTILUS_SHELL).unlockedBy("has_nautilus", has(Items.NAUTILUS_SHELL)).save(output);

        ShapedRecipeBuilder.shaped(items, RecipeCategory.COMBAT, Items.GOLDEN_NAUTILUS_ARMOR).pattern(pattern[0]).pattern(pattern[1]).pattern(pattern[2]).define('X', Items.GOLD_INGOT).define('N', Items.NAUTILUS_SHELL).unlockedBy("has_nautilus", has(Items.NAUTILUS_SHELL)).save(output);

        ShapedRecipeBuilder.shaped(items, RecipeCategory.COMBAT, Items.DIAMOND_NAUTILUS_ARMOR).pattern(pattern[0]).pattern(pattern[1]).pattern(pattern[2]).define('X', Items.DIAMOND).define('N', Items.NAUTILUS_SHELL).unlockedBy("has_nautilus", has(Items.NAUTILUS_SHELL)).save(output);

        ShapedRecipeBuilder.shaped(items, RecipeCategory.COMBAT, PAItems.LEAD_NAUTILUS_ARMOR.get()).pattern(pattern[0]).pattern(pattern[1]).pattern(pattern[2]).define('X', PAItems.LEAD_INGOT.get()).define('N', Items.NAUTILUS_SHELL).unlockedBy("has_nautilus", has(Items.NAUTILUS_SHELL)).save(output);

        ShapedRecipeBuilder.shaped(items, RecipeCategory.COMBAT, PAItems.COBALT_NAUTILUS_ARMOR.get()).pattern(pattern[0]).pattern(pattern[1]).pattern(pattern[2]).define('X', PAItems.COBALT_INGOT.get()).define('N', Items.NAUTILUS_SHELL).unlockedBy("has_nautilus", has(Items.NAUTILUS_SHELL)).save(output);

        netheriteSmithing(Items.DIAMOND_NAUTILUS_ARMOR, RecipeCategory.COMBAT, Items.NETHERITE_NAUTILUS_ARMOR);

        ShapedRecipeBuilder.shaped(items, RecipeCategory.COMBAT, PAItems.EMERALD_NAUTILUS_ARMOR.get()).pattern(pattern[0]).pattern(pattern[1]).pattern(pattern[2]).define('X', Items.EMERALD).define('N', Items.NAUTILUS_SHELL).unlockedBy("has_nautilus", has(Items.NAUTILUS_SHELL)).save(output);
    }

    private void buildMisc() {
        ShapedRecipeBuilder.shaped(items, RecipeCategory.TOOLS, PAItems.LEAD_DIVING_BELT.get()).pattern("LLL").pattern("LCL").define('L', PAItems.LEAD_INGOT.get()).define('C', PAItems.COBALT_INGOT.get()).unlockedBy("has_lead_ingot", has(PAItems.LEAD_INGOT.get())).save(output);
        ShapedRecipeBuilder.shaped(items, RecipeCategory.REDSTONE, PAItems.DENSE_WEIGHTED_PRESSURE_PLATE.get()).pattern("XX").define('X', PAItems.LEAD_INGOT.get()).unlockedBy("has_lead_ingot", has(PAItems.LEAD_INGOT.get())).save(output);
    }


    public static class Runner extends RecipeProvider.Runner {

        public Runner(PackOutput output, CompletableFuture<HolderLookup.Provider> registriesLookup) {
            super(output, registriesLookup);
        }

        @Override
        protected RecipeProvider createRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
            return new PARecipeProvider(registries, output);
        }

        @Override
        public String getName() {
            return "Practical Additions Recipes";
        }
    }
}