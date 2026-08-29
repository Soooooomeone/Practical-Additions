package com.danako.practical_additions.mixin.client;

import com.danako.practical_additions.common.tool.aoe_tools.AOEToolHelper;
import com.danako.practical_additions.common.tool.aoe_tools.IAOEToolType;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.ArrayList;
import java.util.List;

@Mixin(ClientLevel.class)
public class ClientLevelMixin {
    @Unique
    private static final List<BlockPos> practical_additions$lastExtraBlocks = new ArrayList<>();

    @Inject(method = "destroyBlockProgress", at = @At("HEAD"))
    private void syncAOEToolCrackAnimations(int breakerId, BlockPos pos, int progress, CallbackInfo ci) {
        Minecraft mc = Minecraft.getInstance();
        if (mc.player == null || breakerId != mc.player.getId()) return;
        ClientLevel level = (ClientLevel) (Object) this;
        if (progress == -1) {
            int offset = 1;
            for (BlockPos extraPos : practical_additions$lastExtraBlocks) {
                level.destroyBlockProgress(breakerId + (offset * 10000), extraPos, -1);
                offset++;
            }
            practical_additions$lastExtraBlocks.clear();
            return;
        }
        ItemStack held = mc.player.getMainHandItem();
        if (!(held.getItem() instanceof IAOEToolType areaTool)) return;
        if (mc.hitResult instanceof BlockHitResult hit && hit.getType() != HitResult.Type.MISS && hit.getBlockPos().equals(pos)) {
            BlockState primaryState = level.getBlockState(pos);
            if (!AOEToolHelper.isAreaEffectAllowed(mc.player, areaTool.getAOEToolType(), primaryState)) return;
            if (practical_additions$lastExtraBlocks.isEmpty()) {
                Direction face = hit.getDirection();
                int radius = AOEToolHelper.getRadius(areaTool.getAOEToolType());

                for (BlockPos p : AOEToolHelper.getAreaPositions(pos, face, radius)) {
                    if (!p.equals(pos)) {
                        BlockState state = level.getBlockState(p);
                        if (AOEToolHelper.isValidTarget(areaTool.getAOEToolType(), state)) {
                            practical_additions$lastExtraBlocks.add(p.immutable());
                        }
                    }
                }
            }
            int offset = 1;
            for (BlockPos extraPos : practical_additions$lastExtraBlocks) {
                int fakeId = breakerId + (offset * 10000);
                level.destroyBlockProgress(fakeId, extraPos, progress);
                offset++;
            }
        }
    }
}