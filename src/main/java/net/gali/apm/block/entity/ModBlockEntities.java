package net.gali.apm.block.entity;

import net.gali.apm.APMMod;
import net.gali.apm.block.ModBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, APMMod.MOD_ID);

    public static final RegistryObject<BlockEntityType<EneryetizadorBlockEntity>> ENERYETIZADOR_BE =
            BLOCK_ENTITIES.register("eneryetizador_be", () -> BlockEntityType.Builder.of(
                    EneryetizadorBlockEntity::new, ModBlocks.ENERYETIZADOR.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
