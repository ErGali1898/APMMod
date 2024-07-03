package net.gali.apm.sound;

import net.gali.apm.APMMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, APMMod.MOD_ID);

    public static final RegistryObject<SoundEvent> LPEP = registerSoundEvents("apm_disc_vol1");


    public static RegistryObject<SoundEvent> registerSoundEvents(String name){
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(APMMod.MOD_ID, name)));
    }

    public static void register(IEventBus event){
        SOUND_EVENTS.register(event);
    }
}
