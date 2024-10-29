package net.nathan.frights_and_foliage.entity.client;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.feature.EyesFeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.util.Identifier;
import net.nathan.frights_and_foliage.FrightsAndFoliage;
import net.nathan.frights_and_foliage.entity.custom.StalkEntity;

@Environment(EnvType.CLIENT)
public class StalkEyeFeatureRenderer extends EyesFeatureRenderer<StalkEntity, StalkModel<StalkEntity>> {
    private static final RenderLayer SKIN = RenderLayer.getEyes(Identifier.of(FrightsAndFoliage.MOD_ID, "textures/entity/stalk/stalk_eye.png"));

    public StalkEyeFeatureRenderer(FeatureRendererContext<StalkEntity, StalkModel<StalkEntity>> context) {
        super(context);
    }

    @Override
    public RenderLayer getEyesTexture() {
        return SKIN;
    }
}
