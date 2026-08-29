package com.danako.practical_additions.model.backpack;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.state.AvatarRenderState;
import net.minecraft.resources.Identifier;

public class Backpack extends EntityModel<AvatarRenderState> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(Identifier.fromNamespaceAndPath("modid", "backpack"), "main");

    private BackpackType type = BackpackType.BASIC;

    private final ModelPart Backpack;

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        partdefinition.addOrReplaceChild("Backpack", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, 0.0F, 2.5F, 8.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 14).addBox(-3.0F, 5.0F, 6.5F, 6.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(16, 17).addBox(-5.0F, 7.0F, 2.5F, 1.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 21).addBox(4.0F, 7.0F, 2.5F, 1.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(16, 14).addBox(-3.0F, -1.0F, 3.5F, 6.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(26, 17).addBox(2.0F, 0.0F, 6.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(26, 17).addBox(-3.0F, 0.0F, 6.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(24, 0).addBox(-2.0F, 6.0F, 8.5F, 4.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    public Backpack(ModelPart root) {
        super(root);
        this.Backpack = root.getChild("Backpack");
    }

    public BackpackType getType() {
        return type;
    }

    public void setType(BackpackType type) {
        this.type = type != null ? type : BackpackType.BASIC;
    }

    public Identifier getTexture() {
        return type.getTexture();
    }

    public enum BackpackType {
        BASIC("basic_backpack"), REINFORCED("reinforced_backpack");

        private final Identifier texture;

        BackpackType(String fileName) {
            this.texture = Identifier.fromNamespaceAndPath("practical_additions", "textures/entity/backpack/" + fileName + ".png");
        }

        public static BackpackType fromId(String id) {
            if (id != null && id.toLowerCase().contains("reinforced")) {
                return REINFORCED;
            }
            return BASIC;
        }

        public Identifier getTexture() {
            return texture;
        }
    }

    @Override
    public void setupAnim(AvatarRenderState renderState) {
        super.setupAnim(renderState);
        // no custom animation don't touch this
    }
}