package net.nathan.frights_and_foliage.entity.client;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;
import net.nathan.frights_and_foliage.entity.client.animation.LephidAnimations;
import net.nathan.frights_and_foliage.entity.custom.LephidEntity;

public class LephidModel<T extends LephidEntity> extends SinglePartEntityModel<T> {
    private final ModelPart lephid;
    private final ModelPart head;

    public LephidModel(ModelPart root) {
        this.lephid = root.getChild("lephid");
        this.head = lephid.getChild("body").getChild("head");
    }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData lephid = modelPartData.addChild("lephid", ModelPartBuilder.create(), ModelTransform.of(0.0F, 24.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

        ModelPartData body = lephid.addChild("body", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData head = body.addChild("head", ModelPartBuilder.create().uv(18, 16).cuboid(1.0F, 0.0F, -0.5F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F))
                .uv(18, 16).cuboid(3.0F, 1.0F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                .uv(0, 18).cuboid(-1.0F, -1.0F, -2.5F, 2.0F, 2.0F, 5.0F, new Dilation(0.0F))
                .uv(0, 25).cuboid(-1.0F, -2.0F, -1.5F, 2.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(2.0F, -4.0F, 0.0F));

        ModelPartData flleg = body.addChild("flleg", ModelPartBuilder.create(), ModelTransform.pivot(1.25F, -2.5F, 2.5F));

        ModelPartData cube_r1 = flleg.addChild("cube_r1", ModelPartBuilder.create().uv(21, 1).cuboid(-0.5F, -0.5F, 0.0F, 1.0F, 1.0F, 3.0F, new Dilation(-0.001F)), ModelTransform.of(0.0F, -0.5F, 0.0F, -1.5708F, 0.0F, 0.0F));

        ModelPartData mlleg = body.addChild("mlleg", ModelPartBuilder.create(), ModelTransform.pivot(-0.5F, -2.5F, 2.5F));

        ModelPartData cube_r2 = mlleg.addChild("cube_r2", ModelPartBuilder.create().uv(15, 24).cuboid(-0.5F, -0.5F, -1.5F, 1.0F, 1.0F, 3.0F, new Dilation(-0.001F)), ModelTransform.of(0.0F, 1.0F, 0.0F, -1.5708F, 0.0F, 0.0F));

        ModelPartData blleg = body.addChild("blleg", ModelPartBuilder.create(), ModelTransform.pivot(-2.25F, -2.5F, 2.5F));

        ModelPartData cube_r3 = blleg.addChild("cube_r3", ModelPartBuilder.create().uv(25, 17).cuboid(-0.3971F, -0.658F, -1.1483F, 1.0F, 1.0F, 3.0F, new Dilation(-0.001F)), ModelTransform.of(-0.1F, 0.65F, -0.15F, -1.5708F, 0.0F, 0.0F));

        ModelPartData frleg = body.addChild("frleg", ModelPartBuilder.create(), ModelTransform.pivot(1.5F, -2.5F, -2.5F));

        ModelPartData cube_r4 = frleg.addChild("cube_r4", ModelPartBuilder.create().uv(19, 7).cuboid(-0.5F, -0.5F, -1.5F, 1.0F, 1.0F, 3.0F, new Dilation(-0.001F)), ModelTransform.of(-0.25F, 1.0F, 0.0F, 1.5708F, 0.0F, 0.0F));

        ModelPartData mrleg = body.addChild("mrleg", ModelPartBuilder.create(), ModelTransform.pivot(-0.5F, -2.5F, -2.5F));

        ModelPartData cube_r5 = mrleg.addChild("cube_r5", ModelPartBuilder.create().uv(19, 12).cuboid(-0.5F, -0.5F, -1.5F, 1.0F, 1.0F, 3.0F, new Dilation(-0.001F)), ModelTransform.of(0.0F, 1.0F, 0.0F, 1.5708F, 0.0F, 0.0F));

        ModelPartData brleg = body.addChild("brleg", ModelPartBuilder.create(), ModelTransform.pivot(-2.5F, -2.5F, -2.5F));

        ModelPartData cube_r6 = brleg.addChild("cube_r6", ModelPartBuilder.create().uv(15, 19).cuboid(-0.5F, -0.5F, -2.0F, 1.0F, 1.0F, 3.0F, new Dilation(-0.001F)), ModelTransform.of(0.25F, 0.5F, 0.0F, 1.5708F, 0.0F, 0.0F));

        ModelPartData torso = body.addChild("torso", ModelPartBuilder.create().uv(0, 6).cuboid(-7.0F, -4.0F, -2.5F, 4.0F, 1.0F, 5.0F, new Dilation(0.0F))
                .uv(24, 24).cuboid(-3.0F, -4.0F, -4.5F, 4.0F, 1.0F, 2.0F, new Dilation(0.0F))
                .uv(24, 21).cuboid(-3.0F, -4.0F, 2.5F, 4.0F, 1.0F, 2.0F, new Dilation(0.0F))
                .uv(0, 12).cuboid(-3.0F, -4.0F, -2.5F, 5.0F, 1.0F, 5.0F, new Dilation(-0.001F))
                .uv(0, 0).cuboid(-3.0F, -3.0F, -2.5F, 5.0F, 1.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));
        return TexturedModelData.of(modelData, 64, 64);
    }

    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
        lephid.render(matrices, vertexConsumer, light, overlay);
    }

    @Override
    public ModelPart getPart() {
        return lephid;
    }

    @Override
    public void setAngles(LephidEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.getPart().traverse().forEach(ModelPart::resetTransform);
        this.setHeadAngles(entity, netHeadYaw, headPitch, ageInTicks);

        this.animateMovement(LephidAnimations.WALK, limbSwing, limbSwingAmount, 2f, 2.5f);
    }

    private void setHeadAngles(LephidEntity entity, float headYaw, float headRoll, float animationProgress) {
        headYaw = MathHelper.clamp(headYaw, -5.0F, 30.0F);
        headRoll = MathHelper.clamp(headRoll, -45.0F, 45.0F);

        this.head.yaw = headYaw * 0.017453292F;
        this.head.roll = headRoll * 0.017453292F;
    }
}
