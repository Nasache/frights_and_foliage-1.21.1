package net.nathan.frights_and_foliage.entity.client;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.nathan.frights_and_foliage.FrightsAndFoliage;
import net.nathan.frights_and_foliage.entity.custom.LephidEntity;

public class LephidRenderer extends MobEntityRenderer<LephidEntity, LephidModel<LephidEntity>> {
    private static final Identifier TEXTURE = Identifier.of(FrightsAndFoliage.MOD_ID, "textures/entity/lephid/lephid.png");

    public LephidRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new LephidModel<>(ctx.getPart(ModEntityModelLayers.LEPHID)), 0.3f);
    }

    @Override
    public Identifier getTexture(LephidEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(LephidEntity livingEntity, float f, float g, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i) {
        super.render(livingEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
