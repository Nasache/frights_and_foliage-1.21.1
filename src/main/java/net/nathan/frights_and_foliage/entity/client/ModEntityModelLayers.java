package net.nathan.frights_and_foliage.entity.client;

import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;
import net.nathan.frights_and_foliage.FrightsAndFoliage;

public class ModEntityModelLayers {
    public static final EntityModelLayer STALK =
            new EntityModelLayer(Identifier.of(FrightsAndFoliage.MOD_ID, "stalk"), "main");

    public static final EntityModelLayer LEPHID =
            new EntityModelLayer(Identifier.of(FrightsAndFoliage.MOD_ID, "lephid"), "main");

    public static final EntityModelLayer FUMKIN =
            new EntityModelLayer(Identifier.of(FrightsAndFoliage.MOD_ID, "fumkin"), "main");

    public static final EntityModelLayer VIRE =
            new EntityModelLayer(Identifier.of(FrightsAndFoliage.MOD_ID, "vire"), "main");

    public static final EntityModelLayer VIRE_FEATHER_ARROW =
            new EntityModelLayer(Identifier.of(FrightsAndFoliage.MOD_ID, "vire_feather_arrow"), "main");
}
