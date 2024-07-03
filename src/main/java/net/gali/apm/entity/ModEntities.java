package net.gali.apm.entity;

import net.gali.apm.APMMod;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, APMMod.MOD_ID);

    public static final RegistryObject<EntityType<SkolProjectileEntity>> SKOL_PROJECTILE =
            ENTITY_TYPES.register("skol_projectile", () -> EntityType.Builder.<SkolProjectileEntity>of(SkolProjectileEntity::new, MobCategory.MISC)
                    .sized(0.5f, 0.5f).build("skol_projectile"));


    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
