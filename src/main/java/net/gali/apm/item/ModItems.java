package net.gali.apm.item;

import net.gali.apm.APMMod;
import net.gali.apm.item.custom.CustomSwordItem;
import net.gali.apm.item.custom.ModDrinks;
import net.gali.apm.item.custom.ThrowableSkolItem;
import net.gali.apm.sound.ModSounds;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.RecordItem;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, APMMod.MOD_ID);

    public static final RegistryObject<Item> APMIUM = ITEMS.register("apmium",() -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_APMIUM = ITEMS.register("raw_apmium",() -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SKOL_LABEL = ITEMS.register("skol_label",() -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> EMPTY_SKOL = ITEMS.register("empty_skol",() -> new ThrowableSkolItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> SKOL = ITEMS.register("skol", () -> ModDrinks.SKOL_ITEM);
    public static final RegistryObject<Item> BROKEN_SKOL = ITEMS.register("broken_skol",
            () -> new CustomSwordItem(Tiers.IRON, 9,0.8F, new Item.Properties().stacksTo(1), 2));
    public static final RegistryObject<Item> APM_DISC_VOL1 = ITEMS.register("apm_disc_vol1",
            () -> new RecordItem(6, ModSounds.LPEP, new Item.Properties().stacksTo(1), 6180));

    public static void register(IEventBus event) {
        ITEMS.register(event);
    }
}
