package com.danako.practical_additions.client.render;

import com.danako.practical_additions.PracticalAdditions;
import com.danako.practical_additions.common.tool.aoe_tools.AOEToolHelper;
import com.danako.practical_additions.common.tool.aoe_tools.IAOEToolType;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ShapeRenderer;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.ExtractBlockOutlineRenderStateEvent;

import java.util.ArrayList;
import java.util.List;

@EventBusSubscriber(modid = PracticalAdditions.MODID, value = Dist.CLIENT)
public class AOEToolOutlineRenderer {

    private static final int OUTLINE_COLOR = 0x66000000;
    private static final float LINE_WIDTH = 1.0F;

    private record ExtraShape(BlockPos pos, VoxelShape shape) {
    }

    @SubscribeEvent
    public static void onExtractBlockOutline(ExtractBlockOutlineRenderStateEvent event) {
        Minecraft mc = Minecraft.getInstance();
        if (mc.player == null || mc.level == null) return;

        ItemStack held = mc.player.getMainHandItem();
        if (!(held.getItem() instanceof IAOEToolType areaTool)) return;

        BlockHitResult hit = event.getHitResult();
        BlockPos primary = event.getBlockPos();
        Direction face = hit.getDirection();

        BlockState primaryState = mc.level.getBlockState(primary);
        if (!AOEToolHelper.isAreaEffectAllowed(mc.player, areaTool.getAOEToolType(), primaryState)) return;

        List<ExtraShape> shapes = new ArrayList<>();
        for (BlockPos pos : AOEToolHelper.getTargetPositions(mc.level, areaTool.getAOEToolType(), primary, face)) {
            BlockState state = mc.level.getBlockState(pos);
            if (!AOEToolHelper.isValidTarget(areaTool.getAOEToolType(), state)) continue;

            VoxelShape shape = state.getShape(mc.level, pos, event.getCollisionContext());
            if (shape.isEmpty()) continue;

            shapes.add(new ExtraShape(pos.immutable(), shape));
        }

        if (shapes.isEmpty()) return;

        event.addCustomRenderer((renderState, buffer, poseStack, translucentPass, levelRenderState) -> {

            if (translucentPass) return false;

            Vec3 camera = levelRenderState.cameraRenderState.pos;
            var lineBuffer = buffer.getBuffer(RenderTypes.lines());

            for (ExtraShape extra : shapes) {
                ShapeRenderer.renderShape(poseStack, lineBuffer, extra.shape(), extra.pos().getX() - camera.x, extra.pos().getY() - camera.y, extra.pos().getZ() - camera.z, OUTLINE_COLOR, LINE_WIDTH);
            }

            return false;
        });
    }
}