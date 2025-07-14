package net.gali.apm.event;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.gali.apm.APMMod;
import net.gali.apm.item.ModItems;
import net.gali.apm.villager.ModVillagers;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
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
                    new ItemStack(ModItems.APM_COIN.get(), Mth.nextInt(pRandom, 8, 18)),
                    new ItemStack(ModItems.WATERMELON_ENERYETI.get(), 1), 6, 2, 0.02f));
            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.APM_COIN.get(), Mth.nextInt(pRandom, 8, 18)),
                    new ItemStack(ModItems.STRAWBERRY_ENERYETI.get(), 1), 6, 2, 0.02f));
            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.APM_COIN.get(), Mth.nextInt(pRandom, 8, 18)),
                    new ItemStack(ModItems.APPLE_ENERYETI.get(), 1), 6, 2, 0.02f));
            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.APM_COIN.get(), Mth.nextInt(pRandom, 8, 18)),
                    new ItemStack(ModItems.LEMON_CACTUS_ENERYETI.get(), 1), 6, 2, 0.02f));
            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.APM_COIN.get(), Mth.nextInt(pRandom, 8, 18)),
                    new ItemStack(ModItems.MINT_ENERYETI.get(), 1), 6, 2, 0.02f));

            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.APM_COIN.get(), Mth.nextInt(pRandom, 8, 18)),
                    new ItemStack(ModItems.SWEET_PINEAPPLE_ENERYETI.get(), 1), 6, 10, 0.02f));
            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.APM_COIN.get(), Mth.nextInt(pRandom, 8, 18)),
                    new ItemStack(ModItems.BLUE_GRAPE_ENERYETI.get(), 1), 6, 10, 0.02f));
            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.APM_COIN.get(), Mth.nextInt(pRandom, 8, 18)),
                    new ItemStack(ModItems.PEACH_ENERYETI.get(), 1), 6, 10, 0.02f));
            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.APM_COIN.get(), Mth.nextInt(pRandom, 8, 18)),
                    new ItemStack(ModItems.WILD_CHERRY_ENERYETI.get(), 1), 6, 10, 0.02f));
            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.APM_COIN.get(), Mth.nextInt(pRandom, 8, 22)),
                    new ItemStack(ModItems.GREEN_KIWI_ENERYETI.get(), 1), 6, 10, 0.02f));

            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.APM_COIN.get(), Mth.nextInt(pRandom, 20, 40)),
                    new ItemStack(Items.GOLD_INGOT, Mth.nextInt(pRandom, 3, 9)),
                    new ItemStack(ModItems.ELECTRIC_ORANGE_ENERYETI.get(), 1), 3, 16, 0.02f));
            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.APM_COIN.get(), Mth.nextInt(pRandom, 20, 20)),
                    new ItemStack(Items.GOLD_INGOT, Mth.nextInt(pRandom, 3, 9)),
                    new ItemStack(ModItems.INFERNAL_LEMON_ENERYETI.get(), 1), 3, 16, 0.02f));
            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.APM_COIN.get(), Mth.nextInt(pRandom, 20, 40)),
                    new ItemStack(Items.GOLD_INGOT, Mth.nextInt(pRandom, 3, 9)),
                    new ItemStack(ModItems.INFERNAL_LEMON_ENERYETI.get(), 1), 3, 16, 0.02f));
            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.APM_COIN.get(), Mth.nextInt(pRandom, 20, 16)),
                    new ItemStack(Items.GOLD_INGOT, Mth.nextInt(pRandom, 3, 9)),
                    new ItemStack(ModItems.WILD_CITRUS_ENERYETI.get(), 1), 3, 16, 0.02f));

            trades.get(4).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.APM_COIN.get(), Mth.nextInt(pRandom, 20, 40)),
                    new ItemStack(Items.GOLD_INGOT, Mth.nextInt(pRandom, 3, 9)),
                    new ItemStack(ModItems.COCONUT_ENERYETI.get(), 1), 3, 20, 0.02f));
            trades.get(4).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.APM_COIN.get(), Mth.nextInt(pRandom, 20, 40)),
                    new ItemStack(Items.GOLD_INGOT, Mth.nextInt(pRandom, 3, 9)),
                    new ItemStack(ModItems.BLUE_RASPBERRY_ENERYETI.get(), 1), 3, 20, 0.02f));
            trades.get(4).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.APM_COIN.get(), Mth.nextInt(pRandom, 20, 40)),
                    new ItemStack(Items.GOLD_INGOT, Mth.nextInt(pRandom, 3, 9)),
                    new ItemStack(ModItems.PRISMA_RASPBERRY_ENERYETI.get(), 1), 3, 20, 0.02f));
            trades.get(4).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.APM_COIN.get(), Mth.nextInt(pRandom, 20, 40)),
                    new ItemStack(Items.GOLD_INGOT, Mth.nextInt(pRandom, 3, 9)),
                    new ItemStack(ModItems.GLITCH_GRANATE_ENERYETI.get(), 1), 3, 20, 0.02f));

            trades.get(5).add((pTrader, pRandom) -> {
                List<Item> level5Items = List.of(
                        ModItems.CRIMSON_FIRE_ENERYETI.get(),
                        ModItems.FRUIT_LAVA_ENERYETI.get(),
                        ModItems.SAVAGE_POTION_ENERYETI.get(),
                        ModItems.MAGMA_CREAM_ENERYETI.get(),
                        ModItems.ABYSSAL_FOG_ENERYETI.get(),
                        ModItems.WEIRD_BREWERY_ENERYETI.get()
                );
                Item randomItem = level5Items.get(Mth.nextInt(pRandom, 0, level5Items.size() - 1));
                return new MerchantOffer(
                        new ItemStack(ModItems.APM_COIN.get(), Mth.nextInt(pRandom, 52, 64)),
                        new ItemStack(Items.GOLD_INGOT, Mth.nextInt(pRandom, 24, 32)),
                        new ItemStack(randomItem, 1), 2, 50, 0.02f);
            });
            trades.get(5).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.APM_COIN.get(), Mth.nextInt(pRandom, 52, 64)),
                    new ItemStack(Items.GOLD_BLOCK, Mth.nextInt(pRandom, 3, 6)),
                    new ItemStack(ModItems.APM_DISC_VOL1.get(), 1), 1, 100, 0.02f));
        }
    }
}
