package net.gali.apm;

import com.mojang.logging.LogUtils;
import net.gali.apm.block.ModBlocks;
import net.gali.apm.block.entity.ModBlockEntities;
import net.gali.apm.entity.ModEntities;
import net.gali.apm.item.ModCreativeModeTabs;
import net.gali.apm.item.ModItems;
import net.gali.apm.loot.ModLootModifiers;
import net.gali.apm.painting.ModPaintings;
import net.gali.apm.recipe.ModRecipes;
import net.gali.apm.screen.ModMenuTypes;
import net.gali.apm.sound.ModSounds;
import net.gali.apm.villager.ModVillagers;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import net.gali.apm.screen.EneryetizadorScreen;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(APMMod.MOD_ID)
public class APMMod
{
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "apm";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public APMMod()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModCreativeModeTabs.register(modEventBus);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        ModSounds.register(modEventBus);


        ModVillagers.register(modEventBus);
        ModEntities.register(modEventBus);

        ModMenuTypes.register(modEventBus);
        ModRecipes.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);

        ModBlockEntities.register(modEventBus);

        modEventBus.addListener(this::addCreative);

        ModLootModifiers.register(modEventBus);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {

    }

    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {

    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {

    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            EntityRenderers.register(ModEntities.SKOL_PROJECTILE.get(), ThrownItemRenderer::new);

            MenuScreens.register(ModMenuTypes.ENERYETIZADOR_MENU.get(), EneryetizadorScreen::new);
        }
    }
}
