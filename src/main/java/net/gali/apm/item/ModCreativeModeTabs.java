package net.gali.apm.item;

import net.gali.apm.APMMod;
import net.gali.apm.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, APMMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> APM_TAB = CREATIVE_MODE_TABS.register("apm_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.APMIUM.get()))
                    .title(Component.translatable("apm.apm_tab"))
                    .displayItems((itemDisplayParameters, pOutput) -> {

                        pOutput.accept(ModBlocks.APMIUM_ORE.get());
                        pOutput.accept(ModBlocks.DEEPSLATE_APMIUM_ORE.get());
                        pOutput.accept(ModItems.RAW_APMIUM.get());
                        pOutput.accept(ModItems.APMIUM.get());
                        pOutput.accept(ModItems.SKOL_LABEL.get());
                        pOutput.accept(ModItems.SKOL.get());
                        pOutput.accept(ModItems.EMPTY_SKOL.get());
                        pOutput.accept(ModItems.BROKEN_SKOL.get());
                        pOutput.accept(ModItems.APM_DISC_VOL1.get());
                        pOutput.accept(ModItems.ENERYETI_VACIO.get());
                        pOutput.accept(ModItems.ENERYETI_SANDIA.get());

                    })
                    .build());

    public static void register(IEventBus event) {
        CREATIVE_MODE_TABS.register(event);
    }
}
