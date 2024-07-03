package net.gali.apm.item.custom;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class CustomSwordItem extends SwordItem {
    private final int customDurability;

    public CustomSwordItem(Tiers tier, int attackDamageModifier, float attackSpeedModifier, Item.Properties properties, int customDurability) {
        super(tier, attackDamageModifier, attackSpeedModifier, properties);
        this.customDurability = customDurability;
    }

    @Override
    public int getMaxDamage(ItemStack stack) {
        return this.customDurability;
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, net.minecraft.world.entity.LivingEntity target, net.minecraft.world.entity.LivingEntity attacker) {
        if (stack.getDamageValue() + 1 >= this.customDurability) {
            Level world = attacker.level();
            if (!world.isClientSide && attacker instanceof Player) {
                world.playSound(null, attacker.getX(), attacker.getY(), attacker.getZ(), SoundEvents.GLASS_BREAK, SoundSource.PLAYERS, 1.0F, 1.0F);
            }
        }
        return super.hurtEnemy(stack, target, attacker);
    }
}