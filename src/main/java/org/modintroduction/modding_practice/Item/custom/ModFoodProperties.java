package org.modintroduction.modding_practice.Item.custom;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {
    public static final FoodProperties GREEN_APPLE = new FoodProperties.Builder().nutrition(3).saturationMod(0.25f)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 3000), 1.0f)
            .effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 9600), 1.0f)
            .build();
}