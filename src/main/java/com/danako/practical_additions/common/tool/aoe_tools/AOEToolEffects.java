package com.danako.practical_additions.common.tool.aoe_tools;

import com.danako.practical_additions.PracticalAdditions;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.neoforge.event.level.BlockEvent;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@EventBusSubscriber(modid = PracticalAdditions.MODID)
public class AOEToolEffects {

    private static final Map<UUID, Direction> LAST_FACE = new HashMap<>();
    private static final Map<UUID, BlockPos> LAST_POS = new HashMap<>();
    private static final Map<UUID, Integer> DIG_TICKS = new HashMap<>();

    public static Direction getLastFace(Player player, BlockPos pos) {
        Direction face = LAST_FACE.get(player.getUUID());
        BlockPos lastPos = LAST_POS.get(player.getUUID());
        if (face == null || lastPos == null || !lastPos.equals(pos)) return Direction.UP;
        return face;
    }

    @SubscribeEvent
    public static void onLeftClick(PlayerInteractEvent.LeftClickBlock event) {
        Player player = event.getEntity();
        if (!(player.getMainHandItem().getItem() instanceof IAOEToolType areaTool)) return;

        UUID id = player.getUUID();
        BlockPos pos = event.getPos();
        Direction face = event.getFace();

        boolean samePos = pos.equals(LAST_POS.get(id));
        LAST_FACE.put(id, face);
        LAST_POS.put(id, pos);
        DIG_TICKS.merge(id, 1, (oldV, one) -> samePos ? oldV + 1 : 1);
        if (!samePos) DIG_TICKS.put(id, 1);

        if (event.getLevel().isClientSide()) return;
        Level level = (Level) event.getLevel();

        BlockState primaryState = level.getBlockState(pos);
        float perTick = primaryState.getDestroyProgress(player, level, pos);
        if (perTick <= 0) return;

        if (!AOEToolHelper.isAreaEffectAllowed(player, areaTool.getAOEToolType(), primaryState)) return;

        int ticks = DIG_TICKS.getOrDefault(id, 1);
        float progress = Math.min(1.0F, ticks * perTick);
        int stage = (int) (progress * 10.0F);

        for (BlockPos secondary : AOEToolHelper.getTargetPositions(level, areaTool.getAOEToolType(), pos, face)) {
            BlockState secondaryState = level.getBlockState(secondary);
            if (!AOEToolHelper.isValidTarget(areaTool.getAOEToolType(), secondaryState)) continue;
            level.destroyBlockProgress(player.getId(), secondary, stage);
        }
    }

    @SubscribeEvent
    public static void onCreativeBreak(BlockEvent.BreakEvent event) {
        Player player = event.getPlayer();
        if (player == null || !player.isCreative()) return;
        if (!(player.getMainHandItem().getItem() instanceof IAOEToolType areaTool)) return;
        if (!(player instanceof ServerPlayer serverPlayer)) return;

        if (AOEToolHelper.isProcessing()) return;

        Level level = (Level) event.getLevel();
        BlockPos pos = event.getPos();
        BlockState primaryState = event.getState();
        Direction face = getLastFace(player, pos);

        AOEToolHelper.breakArea(serverPlayer, level, pos, primaryState, areaTool.getAOEToolType(), face);
    }
}