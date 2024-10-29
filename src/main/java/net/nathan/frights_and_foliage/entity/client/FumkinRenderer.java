package net.nathan.frights_and_foliage.entity.client;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.nathan.frights_and_foliage.FrightsAndFoliage;
import net.nathan.frights_and_foliage.entity.custom.FumkinEntity;

public class FumkinRenderer extends MobEntityRenderer<FumkinEntity, FumkinModel<FumkinEntity>> {
    private static final Identifier TEXTURE_FULL = Identifier.of(FrightsAndFoliage.MOD_ID, "textures/entity/fumkin/fumkin.png");
    private static final Identifier TEXTURE_HALF = Identifier.of(FrightsAndFoliage.MOD_ID, "textures/entity/fumkin/fumkin_half.png");
    private static final Identifier TEXTURE_BALD = Identifier.of(FrightsAndFoliage.MOD_ID, "textures/entity/fumkin/fumkin_bald.png");

    public FumkinRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new FumkinModel<>(ctx.getPart(ModEntityModelLayers.FUMKIN)), 0.5f);
    }

    @Override
    public Identifier getTexture(FumkinEntity entity) {
        switch (entity.getAntlerStage()) {
            case 0:
                return TEXTURE_BALD;
            case 1:
                return TEXTURE_HALF;
            case 2:
            default:
                return TEXTURE_FULL;
        }
    }

    @Override
    public void render(FumkinEntity livingEntity, float f, float g, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i) {
        if(livingEntity.isBaby()) {
            matrixStack.scale(0.6f,0.6f,0.6f);
        } else {
            matrixStack.scale(1f,1f,1f);
        }

        super.render(livingEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
