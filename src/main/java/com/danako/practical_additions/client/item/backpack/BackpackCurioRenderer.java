package com.danako.practical_additions.client.item.backpack;

import com.danako.practical_additions.common.item.backpack.BackpackItem;
import com.danako.practical_additions.model.backpack.Backpack;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.state.AvatarRenderState;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.ItemStack;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.client.ICurioRenderer;

public class BackpackCurioRenderer implements ICurioRenderer {

    private Backpack model;

    @Override
    public <S extends LivingEntityRenderState, M extends EntityModel<? super S>> void render(ItemStack stack, SlotContext slotContext, PoseStack poseStack, SubmitNodeCollector submitNodeCollector, int light, S renderState, RenderLayerParent<S, M> renderLayerParent, EntityRendererProvider.Context context, float netHeadYaw, float headPitch) {

        if (!(renderState instanceof AvatarRenderState avatarState)) {
            return;
        }

        if (this.model == null) {
            this.model = new Backpack(context.bakeLayer(Backpack.LAYER_LOCATION));
        }

        Backpack.BackpackType type = stack.getItem() instanceof BackpackItem backpackItem ? backpackItem.getBackpackType() : Backpack.BackpackType.BASIC;
        this.model.setType(type);
        this.model.setupAnim(avatarState);

        poseStack.pushPose();
        ICurioRenderer.setupHumanoidAnimations(this.model, renderState);

        Identifier texture = this.model.getTexture();
        RenderType renderType = RenderTypes.entityCutoutNoCull(texture);

        submitNodeCollector.submitModel(this.model, avatarState, poseStack, renderType, light, OverlayTexture.NO_OVERLAY, 0, null);

        poseStack.popPose();
    }
}