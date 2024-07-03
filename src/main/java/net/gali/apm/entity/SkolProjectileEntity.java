package net.gali.apm.entity;

import net.gali.apm.item.ModItems;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.damagesource.DamageSource;

public class SkolProjectileEntity extends ThrowableItemProjectile {
    private static final Item DROP_ITEM = ModItems.BROKEN_SKOL.get();
    private static final float DAMAGE_AMOUNT = 15.0F;

    public SkolProjectileEntity(EntityType<? extends ThrowableItemProjectile> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }
    public SkolProjectileEntity(Level pLevel) {
        super(ModEntities.SKOL_PROJECTILE.get(), pLevel);
    }
    public SkolProjectileEntity(Level pLevel, LivingEntity livingEntity) {
        super(ModEntities.SKOL_PROJECTILE.get(), livingEntity, pLevel);
    }

    @Override
    protected Item getDefaultItem() {
        return ModItems.EMPTY_SKOL.get();
    }

    @Override
    protected void onHitBlock(BlockHitResult pResult) {
        if (!this.level().isClientSide) {
            Vec3 hitVec = pResult.getLocation();
            ItemStack dropStack = new ItemStack(DROP_ITEM);
            ItemEntity dropEntity = new ItemEntity(this.level(), hitVec.x, hitVec.y, hitVec.z, dropStack);
            this.level().addFreshEntity(dropEntity);

            // Reproducir sonido de cristal rompiéndose
            this.level().playSound(null, hitVec.x, hitVec.y, hitVec.z, SoundEvents.GLASS_BREAK, SoundSource.NEUTRAL, 1.0F, 1.0F);
        }

        this.discard();
        super.onHitBlock(pResult);
    }

    @Override
    protected void onHitEntity(EntityHitResult pResult) {
        if (!this.level().isClientSide) {
            Entity entity = pResult.getEntity();
            if (pResult.getEntity() instanceof LivingEntity) {
                LivingEntity target = (LivingEntity) pResult.getEntity();
                Holder<DamageType> damageType = this.level().registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.THROWN);
                DamageSource damageSource = new DamageSource(damageType, this, this.getOwner());
                target.hurt(damageSource, DAMAGE_AMOUNT);
            }

            Vec3 hitVec = pResult.getLocation();
            ItemStack dropStack = new ItemStack(DROP_ITEM);
            ItemEntity dropEntity = new ItemEntity(this.level(), hitVec.x, hitVec.y, hitVec.z, dropStack);
            this.level().addFreshEntity(dropEntity);

            // Reproducir sonido de cristal rompiéndose
            this.level().playSound(null, hitVec.x, hitVec.y, hitVec.z, SoundEvents.GLASS_BREAK, SoundSource.NEUTRAL, 1.0F, 1.0F);
        }


        this.discard();
        super.onHitEntity(pResult);
    }
}
