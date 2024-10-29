package net.nathan.frights_and_foliage.entity.client;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;
import net.nathan.frights_and_foliage.entity.client.animation.VireAnimations;
import net.nathan.frights_and_foliage.entity.custom.VireEntity;

public class VireModel <T extends VireEntity> extends SinglePartEntityModel<T> {
    private final ModelPart vire;
    private final ModelPart head;


    public VireModel(ModelPart root) {
        this.vire = root.getChild("vire");
        this.head = vire.getChild("body").getChild("head");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData vire = modelPartData.addChild("vire", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

        ModelPartData body = vire.addChild("body", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData torso = body.addChild("torso", ModelPartBuilder.create().uv(0, 0).cuboid(-1.5F, 0.0F, -1.0F, 3.0F, 6.0F, 2.0F, new Dilation(-0.001F)), ModelTransform.of(0.0F, -7.5F, -3.0F, 0.4363F, 0.0F, 0.0F));

        ModelPartData lwing = torso.addChild("lwing", ModelPartBuilder.create().uv(10, 0).cuboid(-0.5F, 0.0F, -1.5F, 1.0F, 5.0F, 3.0F, new Dilation(0.002F)), ModelTransform.of(1.5F, 0.4F, 0.2F, -0.1745F, 3.1416F, 0.0F));

        ModelPartData rwing = torso.addChild("rwing", ModelPartBuilder.create().uv(12, 8).cuboid(-0.5F, 0.0F, -1.5F, 1.0F, 5.0F, 3.0F, new Dilation(0.002F)), ModelTransform.of(-1.5F, 0.4F, 0.2F, -0.1745F, 3.1416F, 0.0F));

        ModelPartData head = body.addChild("head", ModelPartBuilder.create().uv(0, 8).cuboid(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, new Dilation(0.001F))
                .uv(8, 16).cuboid(-1.0F, 0.2F, -2.4F, 2.0F, 1.0F, 2.0F, new Dilation(-0.001F)), ModelTransform.pivot(0.0F, -8.3F, -2.8F));

        ModelPartData head_r1 = head.addChild("head_r1", ModelPartBuilder.create().uv(0, 19).cuboid(-1.5F, -1.5F, -0.5F, 3.0F, 3.0F, 1.0F, new Dilation(0.001F)), ModelTransform.of(0.0F, -2.5F, -0.25F, -0.5672F, 0.0F, 0.0F));

        ModelPartData tail = body.addChild("tail", ModelPartBuilder.create().uv(0, 14).cuboid(-1.5F, -2.0F, -1.0F, 3.0F, 4.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -2.9F, 1.2F, 0.8727F, 0.0F, 0.0F));

        ModelPartData lleg = body.addChild("lleg", ModelPartBuilder.create().uv(16, 16).cuboid(-1.0F, -0.5F, -1.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(1.5F, -1.5F, -0.5F));

        ModelPartData rleg = body.addChild("rleg", ModelPartBuilder.create().uv(18, 0).cuboid(-1.0F, -0.5F, -1.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(-0.5F, -1.5F, -0.5F));
        return TexturedModelData.of(modelData, 32, 32);
    }

    @Override
    public void setAngles(VireEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.getPart().traverse().forEach(ModelPart::resetTransform);
        this.setHeadAngles(entity, netHeadYaw, headPitch, ageInTicks);

        this.animateMovement(VireAnimations.FLY, limbSwing, limbSwingAmount, 2f, 2.5f);
    }

    private void setHeadAngles(VireEntity entity, float headYaw, float headPitch, float animationProgress) {
        headYaw = MathHelper.clamp(headYaw, -10.0F, 30.0F);
        headPitch = MathHelper.clamp(headPitch, -45.0F, 45.0F);

        this.head.yaw = headYaw * 0.017453292F;
        this.head.pitch = headPitch * 0.017453292F;
    }

    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
        vire.render(matrices, vertexConsumer, light, overlay);
    }

    @Override
    public ModelPart getPart() {
        return vire;
    }
}