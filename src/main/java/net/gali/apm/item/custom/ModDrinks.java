package net.gali.apm.item.custom;

import net.gali.apm.item.ModItems;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;

public class ModDrinks {
    public static final FoodProperties SKOL = new FoodProperties.Builder().nutrition(2)
            .saturationMod(0.2f).alwaysEat()
            .effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 400, 1), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 1200, 4), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 500, 1), 1.0F)
            .build();

    public static final Item SKOL_ITEM = new DrinkItem(new Item.Properties().stacksTo(1).food(SKOL), ModItems.EMPTY_SKOL.get());
}
