package com.danako.practical_additions.common.tool.aoe_tools;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.protocol.game.ClientboundLevelEventPacket;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;

import java.util.ArrayList;
import java.util.List;

public final class AOEToolHelper {

    private static final ThreadLocal<Boolean> PROCESSING = ThreadLocal.withInitial(() -> false);

    private AOEToolHelper() {
    }

    public static boolean isProcessing() {
        return Boolean.TRUE.equals(PROCESSING.get());
    }

    public static int getRadius(AOEToolType type) {
        return type == AOEToolType.SICKLE_5X5 ? 2 : 1;
    }

    public static List<BlockPos> getAreaPositions(BlockPos center, Direction face, int radius) {
        List<BlockPos> positions = new ArrayList<>();
        Direction.Axis axis = face.getAxis();
        for (int a = -radius; a <= radius; a++) {
            for (int b = -radius; b <= radius; b++) {
                if (a == 0 && b == 0) continue;
                BlockPos pos = switch (axis) {
                    case X -> center.offset(0, a, b);
                    case Y -> center.offset(a, 0, b);
                    case Z -> center.offset(a, b, 0);
                };
                positions.add(pos);
            }
        }
        return positions;
    }

    public static List<BlockPos> getTargetPositions(Level level, AOEToolType type, BlockPos center, Direction face) {
        return getAreaPositions(center, face, getRadius(type));
    }


    public static boolean isAreaEffectAllowed(Player player, AOEToolType type, BlockState primaryState) {
        if (player != null && player.isShiftKeyDown()) return false;
        return isValidTarget(type, primaryState);
    }

    public static boolean isValidTarget(AOEToolType type, BlockState state) {
        if (state.isAir()) return false;
        return switch (type) {
            case HAMMER_3X3 -> state.is(BlockTags.MINEABLE_WITH_PICKAXE);
            case EXCAVATOR_3X3 -> state.is(BlockTags.MINEABLE_WITH_SHOVEL);
            case SICKLE_5X5 -> state.is(BlockTags.LEAVES)
                    || state.is(BlockTags.SAPLINGS)
                    || state.is(BlockTags.CROPS)
                    || state.is(BlockTags.FLOWERS)
                    || state.is(BlockTags.REPLACEABLE_BY_TREES)
                    || state.is(BlockTags.WART_BLOCKS);
        };
    }


    public static void breakArea(ServerPlayer player, Level level, BlockPos primaryPos, BlockState primaryState, AOEToolType type, Direction face) {
        if (isProcessing()) return;
        if (!isAreaEffectAllowed(player, type, primaryState)) return;
        if (face == null) face = Direction.UP;

        List<BlockPos> targets = getTargetPositions(level, type, primaryPos, face);

        PROCESSING.set(true);
        try {
            for (BlockPos pos : targets) {
                BlockState state = level.getBlockState(pos);
                if (!isValidTarget(type, state)) continue;
                if (state.getDestroySpeed(level, pos) < 0) continue;

                boolean broken = player.gameMode.destroyBlock(pos);
                if (broken) {

                    level.destroyBlockProgress(player.getId(), pos, -1);
                    player.connection.send(new ClientboundLevelEventPacket(2001, pos, Block.getId(state), false));
                }
            }
        } finally {
            PROCESSING.set(false);
        }
    }

    public static boolean tryMakePath(ServerPlayer player, Level level, BlockPos center, Direction face) {
        if (face != Direction.UP) return false;
        boolean any = false;
        for (BlockPos pos : withCenter(center, face, 1)) {
            if (isPathable(level, pos)) {
                level.setBlockAndUpdate(pos, Blocks.DIRT_PATH.defaultBlockState());
                any = true;
            }
        }
        if (any) {
            level.playSound(null, center, SoundEvents.SHOVEL_FLATTEN, SoundSource.BLOCKS, 1.0F, 1.0F);
            level.gameEvent(player, GameEvent.BLOCK_CHANGE, center);
        }
        return any;
    }

    public static boolean canMakePath(Level level, BlockPos center, Direction face) {
        if (face != Direction.UP) return false;
        for (BlockPos pos : withCenter(center, face, 1)) {
            if (isPathable(level, pos)) return true;
        }
        return false;
    }

    private static boolean isPathable(Level level, BlockPos pos) {
        BlockState state = level.getBlockState(pos);
        return (state.is(Blocks.GRASS_BLOCK) || state.is(Blocks.DIRT) || state.is(Blocks.COARSE_DIRT) || state.is(Blocks.ROOTED_DIRT))
                && level.getBlockState(pos.above()).isAir();
    }

    public static boolean tryMakeFarmland(ServerPlayer player, Level level, BlockPos center, Direction face) {
        if (face != Direction.UP) return false;
        boolean any = false;
        for (BlockPos pos : withCenter(center, face, 1)) {
            if (isTillable(level, pos)) {
                level.setBlockAndUpdate(pos, Blocks.FARMLAND.defaultBlockState());
                any = true;
            }
        }
        if (any) {
            level.playSound(null, center, SoundEvents.HOE_TILL, SoundSource.BLOCKS, 1.0F, 1.0F);
            level.gameEvent(player, GameEvent.BLOCK_CHANGE, center);
        }
        return any;
    }

    public static boolean canMakeFarmland(Level level, BlockPos center, Direction face) {
        if (face != Direction.UP) return false;
        for (BlockPos pos : withCenter(center, face, 1)) {
            if (isTillable(level, pos)) return true;
        }
        return false;
    }

    private static boolean isTillable(Level level, BlockPos pos) {
        BlockState state = level.getBlockState(pos);
        return (state.is(Blocks.DIRT) || state.is(Blocks.GRASS_BLOCK) || state.is(Blocks.DIRT_PATH) || state.is(Blocks.COARSE_DIRT))
                && level.getBlockState(pos.above()).isAir();
    }

    public static boolean harvestAndReplant(ServerPlayer player, Level level, BlockPos center, Direction face) {
        if (face != Direction.UP) return false;
        boolean any = false;
        ItemStack tool = player.getMainHandItem();
        for (BlockPos pos : withCenter(center, face, getRadius(AOEToolType.SICKLE_5X5))) {
            any |= harvestAndReplantOne(player, level, pos, tool);
        }
        if (any) {
            level.playSound(null, center, SoundEvents.HOE_TILL, SoundSource.BLOCKS, 1.0F, 1.0F);
            level.gameEvent(player, GameEvent.BLOCK_CHANGE, center);
        }
        return any;
    }

    public static boolean canHarvest(Level level, BlockPos center, Direction face) {
        if (face != Direction.UP) return false;
        for (BlockPos pos : withCenter(center, face, getRadius(AOEToolType.SICKLE_5X5))) {
            BlockState state = level.getBlockState(pos);
            if (state.getBlock() instanceof CropBlock crop && crop.isMaxAge(state)) return true;
        }
        return false;
    }

    private static boolean harvestAndReplantOne(ServerPlayer player, Level level, BlockPos pos, ItemStack tool) {
        BlockState state = level.getBlockState(pos);
        if (!(state.getBlock() instanceof CropBlock crop) || !crop.isMaxAge(state)) return false;
        Block.dropResources(state, level, pos, null, player, tool);
        level.setBlockAndUpdate(pos, crop.getStateForAge(0));
        return true;
    }

    private static List<BlockPos> withCenter(BlockPos center, Direction face, int radius) {
        List<BlockPos> all = new ArrayList<>(getAreaPositions(center, face, radius));
        all.add(center);
        return all;
    }
}