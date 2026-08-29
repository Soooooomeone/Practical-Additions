package com.danako.practical_additions.client.item.kevlar_shield;

import com.danako.practical_additions.PracticalAdditions;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.serialization.MapCodec;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.object.equipment.ShieldModel;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.blockentity.BannerRenderer;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.client.renderer.special.SpecialModelRenderer;
import net.minecraft.client.resources.model.Material;
import net.minecraft.client.resources.model.MaterialSet;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.core.component.DataComponentMap;
import net.minecraft.core.component.DataComponents;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Unit;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BannerPatternLayers;
import org.joml.Vector3fc;
import org.jspecify.annotations.Nullable;

import java.util.Objects;
import java.util.function.Consumer;


public class KevlarShieldSpecialRenderer implements SpecialModelRenderer<DataComponentMap> {

    private static final Identifier KEVLAR_SHIELD_BASE_TEXTURE = Identifier.fromNamespaceAndPath(PracticalAdditions.MODID, "textures/entity/shield/kevlar_shield_base.png");
    private static final Identifier KEVLAR_SHIELD_BASE_NOPATTERN_TEXTURE = Identifier.fromNamespaceAndPath(PracticalAdditions.MODID, "textures/entity/shield/kevlar_shield_base_nopattern.png");

    private final MaterialSet materials;
    private final ShieldModel model;

    public KevlarShieldSpecialRenderer(MaterialSet materials, ShieldModel model) {
        this.materials = materials;
        this.model = model;
    }

    @Override
    public @Nullable DataComponentMap extractArgument(ItemStack stack) {
        return stack.immutableComponents();
    }

    @Override
    public void submit(@Nullable DataComponentMap components, ItemDisplayContext displayContext, PoseStack poseStack, SubmitNodeCollector collector, int light, int overlay, boolean hasFoil, int outlineColor) {
        BannerPatternLayers patterns = components != null ? components.getOrDefault(DataComponents.BANNER_PATTERNS, BannerPatternLayers.EMPTY) : BannerPatternLayers.EMPTY;
        DyeColor baseColor = components != null ? components.get(DataComponents.BASE_COLOR) : null;
        boolean hasBanner = !patterns.layers().isEmpty() || baseColor != null;

        poseStack.pushPose();
        poseStack.scale(1.0F, -1.0F, -1.0F);

        Identifier baseTexture = hasBanner ? KEVLAR_SHIELD_BASE_TEXTURE : KEVLAR_SHIELD_BASE_NOPATTERN_TEXTURE;
        collector.submitModel(this.model, Unit.INSTANCE, poseStack, RenderTypes.entitySolid(baseTexture), light, overlay, outlineColor, null);

        if (hasBanner) {
            Material material = ModelBakery.SHIELD_BASE;
            BannerRenderer.submitPatterns(this.materials, poseStack, collector, light, overlay, this.model, Unit.INSTANCE, material, false, Objects.requireNonNullElse(baseColor, DyeColor.WHITE), patterns, hasFoil, null, outlineColor);
        } else if (hasFoil) {
            collector.submitModel(this.model, Unit.INSTANCE, poseStack, RenderTypes.entityGlint(), light, overlay, outlineColor, null);
        }

        poseStack.popPose();
    }

    @Override
    public void getExtents(Consumer<Vector3fc> consumer) {
        PoseStack poseStack = new PoseStack();
        poseStack.scale(1.0F, -1.0F, -1.0F);
        this.model.root().getExtentsForGui(poseStack, consumer);
    }

    public record Unbaked() implements SpecialModelRenderer.Unbaked {
        public static final MapCodec<Unbaked> MAP_CODEC = MapCodec.unit(new Unbaked());

        @Override
        public MapCodec<Unbaked> type() {
            return MAP_CODEC;
        }

        @Override
        public SpecialModelRenderer<?> bake(SpecialModelRenderer.BakingContext context) {
            EntityModelSet entityModelSet = context.entityModelSet();
            return new KevlarShieldSpecialRenderer(context.materials(), new ShieldModel(entityModelSet.bakeLayer(ModelLayers.SHIELD)));
        }
    }
}