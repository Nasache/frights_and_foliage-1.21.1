package net.nathan.frights_and_foliage.entity.client;


import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;
import net.nathan.frights_and_foliage.entity.client.animation.FumkinAnimations;
import net.nathan.frights_and_foliage.entity.custom.FumkinEntity;

public class FumkinModel<T extends FumkinEntity> extends SinglePartEntityModel<T> {
    private final ModelPart fumkin;
    private final ModelPart head;


    public FumkinModel(ModelPart root) {
        this.fumkin = root.getChild("fumkin");
        this.head = fumkin.getChild("body").getChild("head");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData fumkin = modelPartData.addChild("fumkin", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

        ModelPartData body = fumkin.addChild("body", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData torso = body.addChild("torso", ModelPartBuilder.create().uv(0, 0).cuboid(-3.5F, -16.0F, -8.0F, 7.0F, 8.0F, 18.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData tail = torso.addChild("tail", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData cube_r1 = tail.addChild("cube_r1", ModelPartBuilder.create().uv(16, 38).cuboid(-1.0F, -2.0F, -1.0F, 2.0F, 3.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -13.0F, 10.25F, 0.48F, 0.0F, 0.0F));

        ModelPartData head = body.addChild("head", ModelPartBuilder.create().uv(24, 26).cuboid(-2.0F, -10.25F, -6.5F, 4.0F, 4.0F, 5.0F, new Dilation(0.0F))
                .uv(36, 47).cuboid(-1.5F, -9.25F, -9.5F, 3.0F, 3.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -11.75F, -6.25F));

        ModelPartData pumpkin = head.addChild("pumpkin", ModelPartBuilder.create().uv(0, 26).cuboid(-3.0F, -23.0F, -13.25F, 6.0F, 6.0F, 6.0F, new Dilation(0.0F))
                .uv(42, 26).cuboid(-2.0F, -21.5F, -16.25F, 4.0F, 4.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 11.75F, 6.25F));

        ModelPartData antlers = head.addChild("antlers", ModelPartBuilder.create().uv(50, 2).cuboid(1.0F, -23.0F, -9.75F, 2.0F, 2.0F, 1.0F, new Dilation(-0.001F))
                .uv(42, 33).cuboid(2.0F, -24.0F, -9.75F, 3.0F, 1.0F, 1.0F, new Dilation(0.0F))
                .uv(50, 8).cuboid(4.0F, -25.0F, -9.75F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F))
                .uv(50, 10).cuboid(4.0F, -23.0F, -9.75F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F))
                .uv(48, 47).cuboid(5.0F, -26.0F, -9.75F, 3.0F, 1.0F, 1.0F, new Dilation(0.0F))
                .uv(36, 44).cuboid(6.0F, -28.0F, -9.75F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F))
                .uv(50, 19).cuboid(8.0F, -27.0F, -9.75F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F))
                .uv(50, 16).cuboid(3.0F, -26.0F, -9.75F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F))
                .uv(50, 5).cuboid(-3.0F, -23.0F, -9.75F, 2.0F, 2.0F, 1.0F, new Dilation(-0.001F))
                .uv(50, 0).cuboid(-5.0F, -24.0F, -9.75F, 3.0F, 1.0F, 1.0F, new Dilation(0.0F))
                .uv(50, 14).cuboid(-6.0F, -25.0F, -9.75F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F))
                .uv(48, 49).cuboid(-8.0F, -26.0F, -9.75F, 3.0F, 1.0F, 1.0F, new Dilation(0.0F))
                .uv(52, 33).cuboid(-7.0F, -28.0F, -9.75F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F))
                .uv(48, 51).cuboid(-4.0F, -26.0F, -9.75F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F))
                .uv(50, 12).cuboid(-6.0F, -23.0F, -9.75F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F))
                .uv(50, 22).cuboid(-9.0F, -27.0F, -9.75F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 11.75F, 6.25F));

        ModelPartData neck = head.addChild("neck", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 11.75F, 6.25F));

        ModelPartData cube_r2 = neck.addChild("cube_r2", ModelPartBuilder.create().uv(40, 35).cuboid(-2.0F, -4.0F, -1.0F, 3.0F, 9.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(0.5F, -17.0F, -8.75F, 0.2618F, 0.0F, 0.0F));

        ModelPartData flleg = body.addChild("flleg", ModelPartBuilder.create().uv(0, 47).cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 8.0F, 2.0F, new Dilation(-0.001F)), ModelTransform.pivot(2.5F, -8.0F, -6.0F));

        ModelPartData frleg = body.addChild("frleg", ModelPartBuilder.create().uv(8, 47).cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 8.0F, 2.0F, new Dilation(-0.001F)), ModelTransform.pivot(-2.5F, -8.0F, -6.0F));

        ModelPartData blleg = body.addChild("blleg", ModelPartBuilder.create().uv(16, 44).cuboid(-1.0F, 0.5F, -1.0F, 2.0F, 8.0F, 3.0F, new Dilation(0.0F))
                .uv(24, 35).cuboid(-1.5F, -2.5F, -3.0F, 3.0F, 4.0F, 5.0F, new Dilation(0.001F)), ModelTransform.pivot(2.5F, -8.5F, 7.0F));

        ModelPartData brleg = body.addChild("brleg", ModelPartBuilder.create().uv(0, 38).cuboid(-1.5F, -2.5F, -3.0F, 3.0F, 4.0F, 5.0F, new Dilation(0.001F))
                .uv(26, 44).cuboid(-1.0F, 0.5F, -1.0F, 2.0F, 8.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(-2.5F, -8.5F, 7.0F));
        return TexturedModelData.of(modelData, 64, 64);
    }

    @Override
    public void setAngles(FumkinEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.getPart().traverse().forEach(ModelPart::resetTransform);
        this.setHeadAngles(entity, netHeadYaw, headPitch, ageInTicks);

        this.animateMovement(FumkinAnimations.WALK, limbSwing, limbSwingAmount, 2f, 2.5f);
    }

    private void setHeadAngles(FumkinEntity entity, float headYaw, float headPitch, float animationProgress) {
        headYaw = MathHelper.clamp(headYaw, -10.0F, 30.0F);
        headPitch = MathHelper.clamp(headPitch, -45.0F, 45.0F);

        this.head.yaw = headYaw * 0.017453292F;
        this.head.pitch = headPitch * 0.017453292F;
    }

    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
        fumkin.render(matrices, vertexConsumer, light, overlay);
    }

    @Override
    public ModelPart getPart() {
        return fumkin;
    }
}
