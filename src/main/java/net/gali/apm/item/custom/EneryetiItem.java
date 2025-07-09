package net.gali.apm.item.custom;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.*;

public class EneryetiItem extends Item {

    private final List<MobEffectInstance> immediateEffects;
    private final List<MobEffectInstance> delayedEffects;
    private final int delayTicks;
    private final ItemStack returnItem;

    private static final Map<UUID, PendingEffect> PENDING = new HashMap<>();

    public EneryetiItem(Properties properties,
                        List<MobEffectInstance> immediateEffects,
                        List<MobEffectInstance> delayedEffects,
                        int delayTicks,
                        ItemStack returnItem) {
        super(properties);
        this.immediateEffects = immediateEffects;
        this.delayedEffects = delayedEffects;
        this.delayTicks = delayTicks*2;
        this.returnItem = returnItem;
    }

    @Override public int getUseDuration(ItemStack stack) { return 32; }
    @Override public UseAnim getUseAnimation(ItemStack stack) { return UseAnim.DRINK; }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level,
                                                  net.minecraft.world.entity.player.Player player,
                                                  InteractionHand hand) {
        player.startUsingItem(hand);
        return InteractionResultHolder.consume(player.getItemInHand(hand));
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entity) {
        if (!level.isClientSide && entity instanceof ServerPlayer player) {

            for (MobEffectInstance effect : immediateEffects) {
                player.addEffect(new MobEffectInstance(effect));
            }

            if (!delayedEffects.isEmpty() && delayTicks > 0) {
                PENDING.put(player.getUUID(),
                        new PendingEffect(delayedEffects, delayTicks));
            }

            if (!player.getAbilities().instabuild) {
                stack.shrink(1);
                player.addItem(returnItem.copy());
            }
        }
        return stack.isEmpty() ? returnItem.copy() : stack;
    }

    @Mod.EventBusSubscriber
    public static class TickHandler {
        @SubscribeEvent
        public static void onPlayerTick(TickEvent.PlayerTickEvent evt) {
            if (evt.side.isClient()) return;

            UUID id = evt.player.getUUID();
            if (PENDING.containsKey(id)) {
                PendingEffect data = PENDING.get(id);
                data.ticksLeft--;

                if (data.ticksLeft <= 0) {
                    for (MobEffectInstance e : data.effects) {
                        evt.player.addEffect(new MobEffectInstance(e));
                    }
                    PENDING.remove(id);
                }
            }
        }
    }

    private static class PendingEffect {
        final List<MobEffectInstance> effects;
        int ticksLeft;
        PendingEffect(List<MobEffectInstance> effects, int ticks) {
            this.effects = effects;
            this.ticksLeft = ticks;
        }
    }
}