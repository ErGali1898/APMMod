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
                        pOutput.accept(ModBlocks.APMIUM_BLOCK.get());
                        pOutput.accept(ModItems.DRAGON_FUSED_APMIUM.get());
                        pOutput.accept(ModBlocks.DRAGON_FUSED_APMIUM_BLOCK.get());
                        pOutput.accept(ModItems.SKOL_LABEL.get());
                        pOutput.accept(ModItems.SKOL.get());
                        pOutput.accept(ModItems.EMPTY_SKOL.get());
                        pOutput.accept(ModItems.BROKEN_SKOL.get());
                        pOutput.accept(ModItems.APM_DISC_VOL1.get());
                        pOutput.accept(ModBlocks.ENERYETIZADOR.get());
                        pOutput.accept(ModItems.ENERYETI_COMPOUND_TIER1.get());
                        pOutput.accept(ModItems.ENERYETI_COMPOUND_TIER2.get());
                        pOutput.accept(ModItems.ENERYETI_COMPOUND_TIER3.get());
                        pOutput.accept(ModItems.ENERYETI_COMPOUND_TIER4.get());
                        pOutput.accept(ModItems.POOR_ENERYETI_SPICE.get());
                        pOutput.accept(ModItems.PREPARED_ENERYETI_SPICE.get());
                        pOutput.accept(ModItems.SPICY_ENERYETI_SPICE.get());
                        pOutput.accept(ModItems.ENDERED_ENERYETI_SPICE.get());
                        pOutput.accept(ModItems.CRYPTED_NOTE.get());
                        pOutput.accept(ModItems.EMPTY_ENERYETI.get());

                        pOutput.accept(ModItems.WATERMELON_ENERYETI.get());
                        pOutput.accept(ModItems.STRAWBERRY_ENERYETI.get());
                        pOutput.accept(ModItems.APPLE_ENERYETI.get());
                        pOutput.accept(ModItems.LEMON_CACTUS_ENERYETI.get());
                        pOutput.accept(ModItems.MINT_ENERYETI.get());
                        pOutput.accept(ModItems.SWEET_PINEAPPLE_ENERYETI.get());
                        pOutput.accept(ModItems.BLUE_GRAPE_ENERYETI.get());
                        pOutput.accept(ModItems.PEACH_ENERYETI.get());
                        pOutput.accept(ModItems.WILD_CHERRY_ENERYETI.get());
                        pOutput.accept(ModItems.GREEN_KIWI_ENERYETI.get());

                        pOutput.accept(ModItems.ELECTRIC_ORANGE_ENERYETI.get());
                        pOutput.accept(ModItems.INFERNAL_LEMON_ENERYETI.get());
                        pOutput.accept(ModItems.ICED_TEA_ENERYETI.get());
                        pOutput.accept(ModItems.COCONUT_ENERYETI.get());
                        pOutput.accept(ModItems.WILD_CITRUS_ENERYETI.get());
                        pOutput.accept(ModItems.BLUE_RASPBERRY_ENERYETI.get());
                        pOutput.accept(ModItems.PRISMA_RASPBERRY_ENERYETI.get());
                        pOutput.accept(ModItems.GLITCH_GRANATE_ENERYETI.get());

                        pOutput.accept(ModItems.CRIMSON_FIRE_ENERYETI.get());
                        pOutput.accept(ModItems.FRUIT_LAVA_ENERYETI.get());
                        pOutput.accept(ModItems.SAVAGE_POTION_ENERYETI.get());
                        pOutput.accept(ModItems.MAGMA_CREAM_ENERYETI.get());
                        pOutput.accept(ModItems.ABYSSAL_FOG_ENERYETI.get());
                        pOutput.accept(ModItems.WEIRD_BREWERY_ENERYETI.get());
                        pOutput.accept(ModItems.ETERNAL_ECHO_ENERYETI.get());

                        pOutput.accept(ModItems.DEVIL_CONTRACT_ENERYETI.get());
                        pOutput.accept(ModItems.BLINDNESS_FURY_ENERYETI.get());
                        pOutput.accept(ModItems.SATURARION_ENERYETI.get());
                        pOutput.accept(ModItems.APM_COIN.get());

                    })
                    .build());

    public static void register(IEventBus event) {
        CREATIVE_MODE_TABS.register(event);
    }
}
