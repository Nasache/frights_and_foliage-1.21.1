package net.nathan.frights_and_foliage.entity.client;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.nathan.frights_and_foliage.FrightsAndFoliage;
import net.nathan.frights_and_foliage.entity.custom.StalkEntity;

public class StalkRenderer extends MobEntityRenderer<StalkEntity, StalkModel<StalkEntity>> {
    private static final Identifier TEXTURE = Identifier.of(FrightsAndFoliage.MOD_ID, "textures/entity/stalk/stalk.png");

    public StalkRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new StalkModel(ctx.getPart(ModEntityModelLayers.STALK)), 0.3f);
        this.addFeature(new StalkEyeFeatureRenderer(this));
    }

    @Override
    public Identifier getTexture(StalkEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(StalkEntity livingEntity, float f, float g, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i) {
        super.render(livingEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
