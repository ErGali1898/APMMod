package net.gali.apm.item.custom;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;

public class DrinkItem extends Item {
    private final Item emptySkolItem;

    public DrinkItem(Properties properties, Item emptySkolItem) {
        super(properties);
        this.emptySkolItem = emptySkolItem;
    }

    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.DRINK;
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level world, LivingEntity entity) {
        if (entity instanceof Player) {
            Player player = (Player) entity;

            // Play drinking sound
            world.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.GENERIC_DRINK, SoundSource.PLAYERS, 1.0F, 1.0F);

            if (!world.isClientSide) {
                if (!player.getAbilities().instabuild) {
                    stack.shrink(1);
                    if (stack.isEmpty()) {
                        player.addItem(new ItemStack(this.emptySkolItem));
                    } else {
                        player.addItem(new ItemStack(this.emptySkolItem));
                    }
                }

                // Apply food effects
                FoodProperties food = this.getFoodProperties(stack, player);
                if (food != null) {
                    for (var pair : food.getEffects()) {
                        if (world.random.nextFloat() < pair.getSecond()) {
                            player.addEffect(new MobEffectInstance(pair.getFirst()));
                        }
                    }
                }
            }
        }

        return stack.isEmpty() ? new ItemStack(this.emptySkolItem) : stack;
    }
}