package net.gali.apm.villager;

import com.google.common.collect.ImmutableSet;
import net.gali.apm.APMMod;
import net.gali.apm.block.ModBlocks;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModVillagers {
    public static final DeferredRegister<PoiType> POI_TYPES =
            DeferredRegister.create(ForgeRegistries.POI_TYPES, APMMod.MOD_ID);
    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS =
            DeferredRegister.create(ForgeRegistries.VILLAGER_PROFESSIONS, APMMod.MOD_ID);

    public static final RegistryObject<PoiType> ENERYETIZADOR_POI = POI_TYPES.register("eneryetizador_poi",
            () -> new PoiType(ImmutableSet.copyOf(ModBlocks.ENERYETIZADOR.get().getStateDefinition().getPossibleStates()),
                    1, 1));

    public static final RegistryObject<VillagerProfession> BADULAQUE =
            VILLAGER_PROFESSIONS.register("badulaque",
                    () -> new VillagerProfession("badulaque", holder -> holder.get() == ENERYETIZADOR_POI.get(),
                            holder -> holder.get() == ENERYETIZADOR_POI.get(),
                            ImmutableSet.of(), ImmutableSet.of(), SoundEvents.VILLAGER_WORK_FISHERMAN));

    public static void register(IEventBus eventBus){
        POI_TYPES.register(eventBus);
        VILLAGER_PROFESSIONS.register(eventBus);
    }
}
