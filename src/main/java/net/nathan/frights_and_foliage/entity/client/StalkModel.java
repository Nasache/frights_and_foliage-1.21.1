package net.nathan.frights_and_foliage.entity.client;


import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;
import net.nathan.frights_and_foliage.entity.client.animation.StalkAnimations;
import net.nathan.frights_and_foliage.entity.custom.StalkEntity;

public class StalkModel<T extends StalkEntity> extends SinglePartEntityModel<T> {
    private final ModelPart stalk;
    private final ModelPart head;

    public StalkModel(ModelPart root) {
        this.stalk = root.getChild("stalk");
        this.head = stalk.getChild("body").getChild("head");
    }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData stalk = modelPartData.addChild("stalk", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

        ModelPartData body = stalk.addChild("body", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData torso = body.addChild("torso", ModelPartBuilder.create().uv(25, 16).cuboid(-3.0F, -8.5F, -1.0F, 6.0F, 12.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -13.5F, 0.0F));

        ModelPartData head = body.addChild("head", ModelPartBuilder.create().uv(28, 30).cuboid(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(0, 16).cuboid(-3.0F, -8.0F, -3.0F, 6.0F, 6.0F, 6.0F, new Dilation(0.0F))
                .uv(0, 0).cuboid(-4.0F, -9.0F, -4.0F, 8.0F, 8.0F, 8.0F, new Dilation(0.0F))
                .uv(36, 3).cuboid(2.0F, -10.0F, -2.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                .uv(32, 3).cuboid(-3.0F, -10.0F, -2.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                .uv(32, 0).cuboid(-3.0F, -11.0F, -1.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F))
                .uv(36, 0).cuboid(2.0F, -11.0F, -1.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -22.0F, 0.0F));

        ModelPartData larm = body.addChild("larm", ModelPartBuilder.create().uv(0, 28).cuboid(-0.5F, -1.0F, -1.0F, 1.0F, 20.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(3.5F, -20.0F, 0.0F));

        ModelPartData rarm = body.addChild("rarm", ModelPartBuilder.create().uv(6, 28).cuboid(-0.5F, -1.0F, -1.0F, 1.0F, 20.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(-3.5F, -20.0F, 0.0F));

        ModelPartData lleg = body.addChild("lleg", ModelPartBuilder.create().uv(20, 30).cuboid(-1.0F, -0.5F, -1.0F, 2.0F, 10.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(2.0F, -9.5F, 0.0F));

        ModelPartData rleg = body.addChild("rleg", ModelPartBuilder.create().uv(12, 28).cuboid(-1.0F, -0.5F, -1.0F, 2.0F, 10.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(-2.0F, -9.5F, 0.0F));
        return TexturedModelData.of(modelData, 64, 64);
    }

    @Override
    public void setAngles(StalkEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.getPart().traverse().forEach(ModelPart::resetTransform);
        this.setHeadAngles(entity, netHeadYaw, headPitch, ageInTicks);

        float armSway = (MathHelper.cos(ageInTicks * 0.1F) + 1) * 0.05F;

        float maxSwayOutwards = 0.15F;

        this.stalk.getChild("body").getChild("larm").roll = MathHelper.clamp(-armSway, -maxSwayOutwards, 0.0F);

        this.stalk.getChild("body").getChild("rarm").roll = MathHelper.clamp(armSway, 0.0F, maxSwayOutwards);

        this.animateMovement(StalkAnimations.WALK, limbSwing, limbSwingAmount, 2f, 2.5f);
    }

    private void setHeadAngles(StalkEntity entity, float headYaw, float headPitch, float animationProgress) {
            headYaw = MathHelper.clamp(headYaw, -10.0F, 30.0F);
            headPitch = MathHelper.clamp(headPitch, -45.0F, 45.0F);

            this.head.yaw = headYaw * 0.017453292F;
            this.head.pitch = headPitch * 0.017453292F;
        }

        public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
            stalk.render(matrices, vertexConsumer, light, overlay);
        }

        @Override
        public ModelPart getPart() {
            return stalk;
        }
    }