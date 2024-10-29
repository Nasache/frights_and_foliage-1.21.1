package net.nathan.frights_and_foliage.item;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class ModFoodComponents {
    public static final FoodComponent WARPED_PUMPKIN_PIE = new FoodComponent.Builder().nutrition(8).saturationModifier(4.8f).build();
    public static final FoodComponent CRIMSON_PUMPKIN_PIE = new FoodComponent.Builder().nutrition(8).saturationModifier(4.8f).build();

    public static final FoodComponent ASERIA_SYRUP_BOTTLE = new FoodComponent.Builder().nutrition(4).saturationModifier(6f)
            .statusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 100, 0), 1.0F).build();
    public static final FoodComponent APPLE_CIDER = new FoodComponent.Builder().nutrition(3).saturationModifier(2f).build();

    public static final FoodComponent RAW_VENISON = new FoodComponent.Builder().nutrition(3).saturationModifier(3f).build();
    public static final FoodComponent COOKED_VENISON = new FoodComponent.Builder().nutrition(6).saturationModifier(8f).build();


    public static final FoodComponent SAFFROOT = new FoodComponent.Builder().nutrition(2).saturationModifier(4f).build();
    public static final FoodComponent SAFFROOT_OMELETTE = new FoodComponent.Builder().nutrition(6).saturationModifier(8f).build();
    public static final FoodComponent STARCH_SKEWER = new FoodComponent.Builder().nutrition(8).saturationModifier(12f).build();
    public static final FoodComponent STUFFED_PUMPKIN = new FoodComponent.Builder().nutrition(10).saturationModifier(14f).build();


    public static final FoodComponent GAIZE = new FoodComponent.Builder().nutrition(3).saturationModifier(3f).build();

    public static final FoodComponent GAIZE_BREAD = new FoodComponent.Builder().nutrition(4).saturationModifier(6f).build();
    public static final FoodComponent GAIZE_FRITTER = new FoodComponent.Builder().nutrition(3).saturationModifier(2f).build();
    public static final FoodComponent PEEPCORN = new FoodComponent.Builder().snack().nutrition(2).saturationModifier(0.5f).build();

    public static final FoodComponent ASERIA_CANDY = new FoodComponent.Builder().nutrition(1).saturationModifier(0.5f).build();
    public static final FoodComponent ASERIA_WAFFLE = new FoodComponent.Builder().nutrition(6).saturationModifier(4f).build();
    public static final FoodComponent ASERIA_SUGAR_COOKIE = new FoodComponent.Builder().nutrition(2).saturationModifier(0.4f).build();

    public static final FoodComponent NOX_BERRIES = new FoodComponent.Builder().nutrition(1).saturationModifier(0.2f)
            .statusEffect(new StatusEffectInstance(StatusEffects.POISON, 100, 0), 1.0F).build();
    public static final FoodComponent DRIED_NOX_BERRIES = new FoodComponent.Builder().nutrition(2).saturationModifier(0.5f).build();
    public static final FoodComponent BERRY_BLEND = new FoodComponent.Builder().nutrition(5).saturationModifier(1f).build();
    public static final FoodComponent NOX_BERRY_TRAIL_MIX = new FoodComponent.Builder().nutrition(3).saturationModifier(1f).build();

    public static final FoodComponent STALK_EYE = new FoodComponent.Builder().nutrition(0).saturationModifier(0f).alwaysEdible().snack()
            .statusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 12000, 1), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 12000, 1), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 12000, 1), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.HASTE, 12000, 1), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST, 12000, 1), 1.0F).build();


}
