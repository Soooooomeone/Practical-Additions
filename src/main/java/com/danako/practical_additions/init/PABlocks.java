package com.danako.practical_additions.init;

import com.danako.practical_additions.PracticalAdditions;
import com.danako.practical_additions.common.block.WeedCropBlock;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.WeightedPressurePlateBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.neoforge.registries.DeferredBlock;

import static com.danako.practical_additions.PracticalAdditions.BLOCKS;

public class PABlocks {


    public static final DeferredBlock<Block> LEAD_ORE = BLOCKS.registerSimpleBlock("lead_ore", () -> BlockBehaviour.Properties.of().mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(3.0F, 3.0F));


    public static final DeferredBlock<Block> DEEPSLATE_LEAD_ORE = BLOCKS.registerSimpleBlock("deepslate_lead_ore", () -> BlockBehaviour.Properties.of().mapColor(MapColor.DEEPSLATE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(4.5F, 3.0F).sound(SoundType.DEEPSLATE));


    public static final DeferredBlock<Block> COBALT_ORE = BLOCKS.registerSimpleBlock("cobalt_ore", () -> BlockBehaviour.Properties.of().mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(3.0F, 3.0F));


    public static final DeferredBlock<Block> DEEPSLATE_COBALT_ORE = BLOCKS.registerSimpleBlock("deepslate_cobalt_ore", () -> BlockBehaviour.Properties.of().mapColor(MapColor.DEEPSLATE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(4.5F, 3.0F).sound(SoundType.DEEPSLATE));


    public static final DeferredBlock<Block> RAW_LEAD_BLOCK = BLOCKS.registerSimpleBlock("raw_lead_block", () -> BlockBehaviour.Properties.of().mapColor(MapColor.RAW_IRON).instrument(NoteBlockInstrument.IRON_XYLOPHONE).requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.STONE));


    public static final DeferredBlock<Block> LEAD_BLOCK = BLOCKS.registerSimpleBlock("lead_block", () -> BlockBehaviour.Properties.of().mapColor(MapColor.METAL).instrument(NoteBlockInstrument.IRON_XYLOPHONE).requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.METAL));


    public static final DeferredBlock<Block> RAW_COBALT_BLOCK = BLOCKS.registerSimpleBlock("raw_cobalt_block", () -> BlockBehaviour.Properties.of().mapColor(MapColor.RAW_IRON).instrument(NoteBlockInstrument.IRON_XYLOPHONE).requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.STONE));


    public static final DeferredBlock<Block> COBALT_BLOCK = BLOCKS.registerSimpleBlock("cobalt_block", () -> BlockBehaviour.Properties.of().mapColor(MapColor.DIAMOND).instrument(NoteBlockInstrument.IRON_XYLOPHONE).requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.METAL));

    public static final DeferredBlock<Block> DENSE_WEIGHTED_PRESSURE_PLATE = BLOCKS.register("dense_weighted_pressure_plate", () -> new WeightedPressurePlateBlock(300, BlockSetType.IRON, BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(PracticalAdditions.MODID, "dense_weighted_pressure_plate"))).mapColor(MapColor.METAL).forceSolidOn().instrument(NoteBlockInstrument.IRON_XYLOPHONE).noCollision().requiresCorrectToolForDrops().strength(0.5F).sound(SoundType.METAL).pushReaction(PushReaction.DESTROY)));

    public static final DeferredBlock<Block> WEED_CROP = BLOCKS.register("weed_crop", () -> new WeedCropBlock(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(PracticalAdditions.MODID, "weed_crop"))).mapColor(MapColor.PLANT).noCollision().randomTicks().instabreak().sound(SoundType.CROP).pushReaction(PushReaction.DESTROY).ignitedByLava()));

    public static void register() {
    }
}