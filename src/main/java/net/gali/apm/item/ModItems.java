package net.gali.apm.item;

import net.gali.apm.APMMod;
import net.gali.apm.item.custom.*;
import net.gali.apm.sound.ModSounds;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;


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
    public static final RegistryObject<Item> ENERYETI_VACIO = ITEMS.register("eneryeti_vacio",
            () -> new Item(new Item.Properties().stacksTo(16)));
    public static final RegistryObject<Item> ENERYETI_SANDIA = ITEMS.register("eneryeti_sandia", () ->
            new EneryetiItem(
                    new Item.Properties().stacksTo(16).food(
                            new FoodProperties.Builder().nutrition(4).saturationMod(1f).alwaysEat().build()
                    ),
                    List.of(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 600, 0)),
                    List.of(
                            new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 600, 0),
                            new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 400, 0)
                    ),
                    600,
                    new ItemStack(ENERYETI_VACIO.get())
            )
    );
    public static final RegistryObject<Item> ENERYETI_COCO = ITEMS.register("eneryeti_coco", () ->
            new EneryetiItem(
                    new Item.Properties().stacksTo(16).food(
                            new FoodProperties.Builder().nutrition(4).saturationMod(1f).alwaysEat().build()
                    ),
                    List.of(new MobEffectInstance(MobEffects.DIG_SPEED, 1200, 2)),
                    List.of(
                            new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 600, 1)
                    ),
                    1500,
                    new ItemStack(ENERYETI_VACIO.get())
            )
    );

    public static final RegistryObject<Item> APM_COIN = ITEMS.register("apm_coin", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ENERYETI_COMPOUND_TIER1 = ITEMS.register("eneryeti_compound_tier1", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ENERYETI_COMPOUND_TIER2 = ITEMS.register("eneryeti_compound_tier2", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ENERYETI_COMPOUND_TIER3 = ITEMS.register("eneryeti_compound_tier3", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ENERYETI_COMPOUND_TIER4 = ITEMS.register("eneryeti_compound_tier4", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CRYPTED_NOTE = ITEMS.register("crypted_note",
            () -> new ShinningItem(new Item.Properties().rarity(Rarity.EPIC).stacksTo(1),
                    "No se entiende nada de lo que pone aqui",
                    "Tal vez con un desencriptador se pueda hacer algo"
            ));

    public static void register(IEventBus event) {
        ITEMS.register(event);
    }
}