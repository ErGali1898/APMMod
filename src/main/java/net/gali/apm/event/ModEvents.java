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
        if(event.getType() == ModVillagers.BADULAQUE.get()){
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();

            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.APM_COIN.get(), 16),
                    new ItemStack(ModItems.WATERMELON_ENERYETI.get(), 1), 6, 10, 0.02f));
        }
    }
}
