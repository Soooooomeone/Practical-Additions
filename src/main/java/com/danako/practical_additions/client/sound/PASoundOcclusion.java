package com.danako.practical_additions.client.sound;

import it.unimi.dsi.fastutil.objects.Object2FloatMap;
import it.unimi.dsi.fastutil.objects.Object2FloatOpenHashMap;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

public class PASoundOcclusion {

    public static final float DEFAULT_FACTOR = 0.1F;

    private static final Object2FloatMap<Block> FACTORS = new Object2FloatOpenHashMap<>();

    static {
        FACTORS.defaultReturnValue(DEFAULT_FACTOR);
    }

    private PASoundOcclusion() {
    }

    public static void register(Block block, float factor) {
        FACTORS.put(block, Mth.clamp(factor, 0.0F, 1.0F));
    }

    public static float getOcclusionFactor(BlockState state) {
        if (state.isAir()) {
            return 0.0F;
        }
        return FACTORS.getFloat(state.getBlock());
    }

    public static float computeVolumeMultiplier(Level level, Vec3 from, Vec3 to) {
        double dx = to.x - from.x;
        double dy = to.y - from.y;
        double dz = to.z - from.z;
        double dist = Math.sqrt(dx * dx + dy * dy + dz * dz);
        if (dist < 1.0e-4) {
            return 1.0F;
        }

        int steps = Math.max(1, Mth.ceil(dist));
        float multiplier = 1.0F;
        BlockPos.MutableBlockPos cursor = new BlockPos.MutableBlockPos();
        BlockPos lastPos = null;

        for (int i = 0; i <= steps; i++) {
            double t = (double) i / steps;
            cursor.set(Mth.floor(from.x + dx * t), Mth.floor(from.y + dy * t), Mth.floor(from.z + dz * t));
            if (!cursor.equals(lastPos)) {
                BlockState state = level.getBlockState(cursor);
                float factor = getOcclusionFactor(state);
                if (factor > 0.0F) {
                    multiplier *= (1.0F - factor);
                    if (multiplier <= 0.0F) {
                        return 0.0F;
                    }
                }
                lastPos = cursor.immutable();
            }
        }
        return multiplier;
    }
}