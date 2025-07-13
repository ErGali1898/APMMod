package net.gali.apm.event;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.gali.apm.APMMod;
import net.gali.apm.item.ModItems;
import net.gali.apm.villager.ModVillagers;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Mod.EventBusSubscriber(modid = APMMod.MOD_ID)
public class ModEvents {

    @SubscribeEvent
    public static void addCustomTrades(VillagerTradesEvent event){

        // este if es para asegurarnos de que solo se añadan los trades al Badulaque
        if(event.getType() == ModVillagers.BADULAQUE.get()){

            // ignora esto es pa que pille el trades del aldeano
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();

            // el trades.get(1) es el nivel del aldeano, en este caso nivel 1, tiene hastaa 5 niveles
            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    // el primer ItemStack es el que el aldeano quiere, en este caso 16 monedas APM
                    new ItemStack(ModItems.APM_COIN.get(), 16),
                    // el segundo ItemStack es el que el aldeano te da, en este caso una Eneryeti de Sandía
                    new ItemStack(ModItems.WATERMELON_ENERYETI.get(), 1), 6, 10, 0.02f));
        }

        // cuando termines de añadir los trades acuerdate que el aldeano se tiene que
        // actualizar, y que usa un eneryetizador para el trabajo de badulaque
    }
}
