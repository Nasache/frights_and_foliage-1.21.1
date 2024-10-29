package net.nathan.frights_and_foliage.entity.client;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.nathan.frights_and_foliage.FrightsAndFoliage;
import net.nathan.frights_and_foliage.entity.custom.VireEntity;

public class VireRenderer extends MobEntityRenderer<VireEntity, VireModel<VireEntity>> {
    private static final Identifier TEXTURE = Identifier.of(FrightsAndFoliage.MOD_ID, "textures/entity/vire/vire.png");

    public VireRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new VireModel<>(ctx.getPart(ModEntityModelLayers.VIRE)), 0.3f);
    }

    @Override
    public Identifier getTexture(VireEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(VireEntity livingEntity, float f, float g, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i) {
        if(livingEntity.isBaby()) {
            matrixStack.scale(0.5f,0.5f,0.5f);
        } else {
            matrixStack.scale(1f,1f,1f);
        }

        super.render(livingEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}