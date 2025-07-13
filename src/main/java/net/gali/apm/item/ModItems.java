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
    public static final RegistryObject<Item> DRAGON_FUSED_APMIUM = ITEMS.register("dragon_fused_apmium",() -> new Item(new Item.Properties().rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> RAW_APMIUM = ITEMS.register("raw_apmium",() -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SKOL_LABEL = ITEMS.register("skol_label",() -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> EMPTY_SKOL = ITEMS.register("empty_skol",() -> new ThrowableSkolItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> SKOL = ITEMS.register("skol", () -> ModDrinks.SKOL_ITEM);
    public static final RegistryObject<Item> BROKEN_SKOL = ITEMS.register("broken_skol",
            () -> new CustomSwordItem(Tiers.IRON, 9,0.8F, new Item.Properties().stacksTo(1), 2));
    public static final RegistryObject<Item> APM_DISC_VOL1 = ITEMS.register("apm_disc_vol1",
            () -> new RecordItem(6, ModSounds.LPEP, new Item.Properties().stacksTo(1), 6180));
    public static final RegistryObject<Item> EMPTY_ENERYETI = ITEMS.register("empty_eneryeti",
            () -> new Item(new Item.Properties().stacksTo(16)));

    // *********************************************************** TIER 1 ENERYETI ITEMS ***********************************************************
    public static final RegistryObject<Item> WATERMELON_ENERYETI = ITEMS.register("watermelon_eneryeti", () ->
            new EneryetiItem(
                    new Item.Properties().stacksTo(16).food(
                            new FoodProperties.Builder().nutrition(4).saturationMod(1f).alwaysEat().build()
                    ),
                    List.of(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 1500, 0)), // Speed I (75s)
                    List.of(),
                    0,
                    new ItemStack(EMPTY_ENERYETI.get())
            )
    );

    public static final RegistryObject<Item> STRAWBERRY_ENERYETI = ITEMS.register("strawberry_eneryeti", () ->
            new EneryetiItem(
                    new Item.Properties().stacksTo(16).food(
                            new FoodProperties.Builder().nutrition(4).saturationMod(1f).alwaysEat().build()
                    ),
                    List.of(new MobEffectInstance(MobEffects.REGENERATION, 1200, 0)), // Regeneration I (60s)
                    List.of(),
                    0,
                    new ItemStack(EMPTY_ENERYETI.get())
            )
    );

    public static final RegistryObject<Item> APPLE_ENERYETI = ITEMS.register("apple_eneryeti", () ->
            new EneryetiItem(
                    new Item.Properties().stacksTo(16).food(
                            new FoodProperties.Builder().nutrition(4).saturationMod(1f).alwaysEat().build()
                    ),
                    List.of(new MobEffectInstance(MobEffects.ABSORPTION, 1200, 0)), // Absorption I (60s)
                    List.of(),
                    0,
                    new ItemStack(EMPTY_ENERYETI.get())
            )
    );

    public static final RegistryObject<Item> LEMON_CACTUS_ENERYETI = ITEMS.register("lemon_cactus_eneryeti", () ->
            new EneryetiItem(
                    new Item.Properties().stacksTo(16).food(
                            new FoodProperties.Builder().nutrition(4).saturationMod(1f).alwaysEat().build()
                    ),
                    List.of(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 1200, 0)), // Resistance I (60s)
                    List.of(),
                    0,
                    new ItemStack(EMPTY_ENERYETI.get())
            )
    );

    public static final RegistryObject<Item> MINT_ENERYETI = ITEMS.register("mint_eneryeti", () ->
            new EneryetiItem(
                    new Item.Properties().stacksTo(16).food(
                            new FoodProperties.Builder().nutrition(4).saturationMod(1f).alwaysEat().build()
                    ),
                    List.of(
                            new MobEffectInstance(MobEffects.NIGHT_VISION, 1200, 0),
                            new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 1200, 0)
                    ),
                    List.of(),
                    0,
                    new ItemStack(EMPTY_ENERYETI.get())
            )
    );

    public static final RegistryObject<Item> SWEET_PINEAPPLE_ENERYETI = ITEMS.register("sweet_pineapple_eneryeti", () ->
            new EneryetiItem(
                    new Item.Properties().stacksTo(16).food(
                            new FoodProperties.Builder().nutrition(4).saturationMod(1f).alwaysEat().build()
                    ),
                    List.of(new MobEffectInstance(MobEffects.HEALTH_BOOST, 1500, 0)), // Health Boost I (75s)
                    List.of(),
                    0,
                    new ItemStack(EMPTY_ENERYETI.get())
            )
    );

    public static final RegistryObject<Item> BLUE_GRAPE_ENERYETI = ITEMS.register("blue_grape_eneryeti", () ->
            new EneryetiItem(
                    new Item.Properties().stacksTo(16).food(
                            new FoodProperties.Builder().nutrition(4).saturationMod(1f).alwaysEat().build()
                    ),
                    List.of(new MobEffectInstance(MobEffects.JUMP, 1200, 0)), // Jump Boost I (60s)
                    List.of(),
                    0,
                    new ItemStack(EMPTY_ENERYETI.get())
            )
    );

    public static final RegistryObject<Item> PEACH_ENERYETI = ITEMS.register("peach_eneryeti", () ->
            new EneryetiItem(
                    new Item.Properties().stacksTo(16).food(
                            new FoodProperties.Builder().nutrition(4).saturationMod(1f).alwaysEat().build()
                    ),
                    List.of(new MobEffectInstance(MobEffects.REGENERATION, 1500, 0)), // Regeneration I (75s)
                    List.of(),
                    0,
                    new ItemStack(EMPTY_ENERYETI.get())
            )
    );

    public static final RegistryObject<Item> WILD_CHERRY_ENERYETI = ITEMS.register("wild_cherry_eneryeti", () ->
            new EneryetiItem(
                    new Item.Properties().stacksTo(16).food(
                            new FoodProperties.Builder().nutrition(4).saturationMod(1f).alwaysEat().build()
                    ),
                    List.of(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 1200, 0)), // Strength I (60s)
                    List.of(),
                    0,
                    new ItemStack(EMPTY_ENERYETI.get())
            )
    );

    public static final RegistryObject<Item> GREEN_KIWI_ENERYETI = ITEMS.register("green_kiwi_eneryeti", () ->
            new EneryetiItem(
                    new Item.Properties().stacksTo(16).food(
                            new FoodProperties.Builder().nutrition(4).saturationMod(1f).alwaysEat().build()
                    ),
                    List.of(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 1200, 0)), // Resistance I (60s)
                    List.of(),
                    0,
                    new ItemStack(EMPTY_ENERYETI.get())
            )
    );
    // *********************************************************** END OF TIER 1 ENERYETI ITEMS ***********************************************************

    // *********************************************************** TIER 2 ENERYETI ITEMS ***********************************************************

    public static final RegistryObject<Item> ELECTRIC_ORANGE_ENERYETI = ITEMS.register("electric_orange_eneryeti", () ->
            new EneryetiItem(
                    new Item.Properties().rarity(Rarity.UNCOMMON).stacksTo(16).food(
                            new FoodProperties.Builder().nutrition(4).saturationMod(1f).alwaysEat().build()
                    ),
                    List.of(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 1800, 1)), // Speed II (90s)
                    List.of(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 300, 0)), // Mining Fatigue I (15s)
                    1800,
                    new ItemStack(EMPTY_ENERYETI.get())
            )
    );

    public static final RegistryObject<Item> INFERNAL_LEMON_ENERYETI = ITEMS.register("infernal_lemon_eneryeti", () ->
            new EneryetiItem(
                    new Item.Properties().rarity(Rarity.UNCOMMON).stacksTo(16).food(
                            new FoodProperties.Builder().nutrition(4).saturationMod(1f).alwaysEat().build()
                    ),
                    List.of(
                            new MobEffectInstance(MobEffects.DAMAGE_BOOST, 1200, 1),     // Strength II (60s)
                            new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 1200, 0)   // Fire Resistance (60s)
                    ),
                    List.of(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 300, 0)), // Slowness I (15s)
                    1200,
                    new ItemStack(EMPTY_ENERYETI.get())
            )
    );

    public static final RegistryObject<Item> ICED_TEA_ENERYETI = ITEMS.register("iced_tea_eneryeti", () ->
            new EneryetiItem(
                    new Item.Properties().rarity(Rarity.UNCOMMON).stacksTo(16).food(
                            new FoodProperties.Builder().nutrition(4).saturationMod(1f).alwaysEat().build()
                    ),
                    List.of(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 1500, 1)), // Resistance II (75s)
                    List.of(new MobEffectInstance(MobEffects.WEAKNESS, 200, 0)), // Weakness I (10s)
                    1500,
                    new ItemStack(EMPTY_ENERYETI.get())
            )
    );

    public static final RegistryObject<Item> COCONUT_ENERYETI = ITEMS.register("coconut_eneryeti", () ->
            new EneryetiItem(
                    new Item.Properties().rarity(Rarity.UNCOMMON).stacksTo(16).food(
                            new FoodProperties.Builder().nutrition(4).saturationMod(1f).alwaysEat().build()
                    ),
                    List.of(
                            new MobEffectInstance(MobEffects.DIG_SPEED, 1800, 0),      // Haste I (90s)
                            new MobEffectInstance(MobEffects.JUMP, 1200, 0)            // Jump Boost I (60s)
                    ),
                    List.of(new MobEffectInstance(MobEffects.HUNGER, 300, 0)), // Hunger I (15s)
                    1800,
                    new ItemStack(EMPTY_ENERYETI.get())
            )
    );

    public static final RegistryObject<Item> WILD_CITRUS_ENERYETI = ITEMS.register("wild_citrus_eneryeti", () ->
            new EneryetiItem(
                    new Item.Properties().rarity(Rarity.UNCOMMON).stacksTo(16).food(
                            new FoodProperties.Builder().nutrition(4).saturationMod(1f).alwaysEat().build()
                    ),
                    List.of(
                            new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 1200, 0),  // Speed I (60s)
                            new MobEffectInstance(MobEffects.JUMP, 1200, 1),            // Jump Boost II (60s)
                            new MobEffectInstance(MobEffects.ABSORPTION, 1800, 0)       // Absorption I (90s)
                    ),
                    List.of(new MobEffectInstance(MobEffects.CONFUSION, 200, 0)), // Nausea (10s)
                    1200,
                    new ItemStack(EMPTY_ENERYETI.get())
            )
    );

    public static final RegistryObject<Item> BLUE_RASPBERRY_ENERYETI = ITEMS.register("blue_raspberry_eneryeti", () ->
            new EneryetiItem(
                    new Item.Properties().rarity(Rarity.UNCOMMON).stacksTo(16).food(
                            new FoodProperties.Builder().nutrition(4).saturationMod(1f).alwaysEat().build()
                    ),
                    List.of(
                            new MobEffectInstance(MobEffects.DAMAGE_BOOST, 1800, 0),   // Strength I (90s)
                            new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 1200, 0)  // Speed I (60s)
                    ),
                    List.of(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 400, 0)), // Mining Fatigue I (20s)
                    1800,
                    new ItemStack(EMPTY_ENERYETI.get())
            )
    );

    public static final RegistryObject<Item> PRISMA_RASPBERRY_ENERYETI = ITEMS.register("prisma_raspberry_eneryeti", () ->
            new EneryetiItem(
                    new Item.Properties().rarity(Rarity.UNCOMMON).stacksTo(16).food(
                            new FoodProperties.Builder().nutrition(4).saturationMod(1f).alwaysEat().build()
                    ),
                    List.of(
                            new MobEffectInstance(MobEffects.WATER_BREATHING, 1800, 0),   // Water Breathing (90s)
                            new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 1800, 0)  // Resistance I (90s)
                    ),
                    List.of(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 300, 0)), // Slowness I (15s)
                    1800,
                    new ItemStack(EMPTY_ENERYETI.get())
            )
    );

    public static final RegistryObject<Item> GLITCH_GRANATE_ENERYETI = ITEMS.register("glitch_granate_eneryeti", () ->
            new EneryetiItem(
                    new Item.Properties().rarity(Rarity.UNCOMMON).stacksTo(16).food(
                            new FoodProperties.Builder().nutrition(4).saturationMod(1f).alwaysEat().build()
                    ),
                    List.of(
                            new MobEffectInstance(MobEffects.DAMAGE_BOOST, 1200, 1),     // Strength II (60s)
                            new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 1200, 1) // Resistance II (60s)
                    ),
                    List.of(
                            new MobEffectInstance(MobEffects.CONFUSION, 300, 0),         // Nausea (15s)
                            new MobEffectInstance(MobEffects.WEAKNESS, 300, 0)          // Weakness (15s)
                    ),
                    1200,
                    new ItemStack(EMPTY_ENERYETI.get())
            )
    );

// *********************************************************** END OF TIER 2 ENERYETI ITEMS ***********************************************************

    // *********************************************************** TIER 3 ENERYETI ITEMS ***********************************************************
    public static final RegistryObject<Item> CRIMSON_FIRE_ENERYETI = ITEMS.register("crimson_fire_eneryeti", () ->
            new EneryetiItem(
                    new Item.Properties().rarity(Rarity.RARE).stacksTo(16).food(
                            new FoodProperties.Builder().nutrition(4).saturationMod(1f).alwaysEat().build()
                    ),
                    List.of(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 12000, 1),
                            new MobEffectInstance(MobEffects.DAMAGE_BOOST, 2400, 2)),
                    List.of(
                            new MobEffectInstance(MobEffects.WEAKNESS, 2400, 1)
                    ),
                    2400,
                    new ItemStack(EMPTY_ENERYETI.get())
            )
    );

    public static final RegistryObject<Item> FRUIT_LAVA_ENERYETI = ITEMS.register("fruit_lava_eneryeti", () ->
            new EneryetiItem(
                    new Item.Properties().rarity(Rarity.RARE).stacksTo(16).food(
                            new FoodProperties.Builder().nutrition(4).saturationMod(1f).alwaysEat().build()
                    ),
                    List.of(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 3600, 1),
                            new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 3600, 3),
                            new MobEffectInstance(MobEffects.JUMP, 3600, 2)),
                    List.of(
                            new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 400, 2)
                    ),
                    3600,
                    new ItemStack(EMPTY_ENERYETI.get())
            )
    );

    public static final RegistryObject<Item> SAVAGE_POTION_ENERYETI = ITEMS.register("savage_potion_eneryeti", () ->
                    new EneryetiItem(
                            new Item.Properties().rarity(Rarity.RARE).stacksTo(16).food(
                                    new FoodProperties.Builder().nutrition(4).saturationMod(1f).alwaysEat().build()
                            ),
                            List.of(new MobEffectInstance(MobEffects.DIG_SPEED, 1800, 3),
                                    new MobEffectInstance(MobEffects.REGENERATION, 1500, 2)),
                            List.of(
                                    new MobEffectInstance(MobEffects.CONFUSION, 400,3),
                                    new MobEffectInstance(MobEffects.CONFUSION, 600,2)
                            ),
                            1800,
                            new ItemStack(EMPTY_ENERYETI.get())
                    )
    );

    public static final RegistryObject<Item> MAGMA_CREAM_ENERYETI = ITEMS.register("magma_cream_eneryeti", () ->
            new EneryetiItem(
                    new Item.Properties().rarity(Rarity.RARE).stacksTo(16).food(
                            new FoodProperties.Builder().nutrition(4).saturationMod(1f).alwaysEat().build()
                    ),
                    List.of(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 1200, 4),
                            new MobEffectInstance(MobEffects.GLOWING, 1800, 1)),
                    List.of(
                            new MobEffectInstance(MobEffects.BLINDNESS, 300,1)
                    ),
                    1200,
                    new ItemStack(EMPTY_ENERYETI.get())
            )
    );

    public static final RegistryObject<Item> ABYSSAL_FOG_ENERYETI = ITEMS.register("abyssal_fog_eneryeti", () ->
            new EneryetiItem(
                    new Item.Properties().rarity(Rarity.RARE).stacksTo(16).food(
                            new FoodProperties.Builder().nutrition(4).saturationMod(1f).alwaysEat().build()
                    ),
                    List.of(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 3600, 3),
                            new MobEffectInstance(MobEffects.NIGHT_VISION, 4800, 1)),
                    List.of(
                            new MobEffectInstance(MobEffects.HUNGER, 600,3),
                            new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 400,2)
                    ),
                    4800,
                    new ItemStack(EMPTY_ENERYETI.get())
            )
    );

    public static final RegistryObject<Item> WEIRD_BREWERY_ENERYETI = ITEMS.register("weird_brewery_eneryeti", () ->
            new EneryetiItem(
                    new Item.Properties().rarity(Rarity.RARE).stacksTo(16).food(
                            new FoodProperties.Builder().nutrition(4).saturationMod(1f).alwaysEat().build()
                    ),
                    List.of(new MobEffectInstance(MobEffects.REGENERATION, 1200, 3),
                            new MobEffectInstance(MobEffects.JUMP, 1500, 2)),
                    List.of(
                            new MobEffectInstance(MobEffects.HUNGER, 300,3),
                            new MobEffectInstance(MobEffects.POISON, 200,2)
                    ),
                    800,
                    new ItemStack(EMPTY_ENERYETI.get())
            )
    );
    // *********************************************************** END OF TIER 3 ENERYETI ITEMS ***********************************************************

    // *********************************************************** TIER 4 ENERYETI ITEMS ***********************************************************
    public static final RegistryObject<Item> ETERNAL_ECHO_ENERYETI = ITEMS.register("eternal_echo_eneryeti", () ->
            new EneryetiItem(
                    new Item.Properties().rarity(Rarity.EPIC).stacksTo(16).food(
                            new FoodProperties.Builder().nutrition(4).saturationMod(1f).alwaysEat().build()
                    ),
                    List.of(new MobEffectInstance(MobEffects.HEALTH_BOOST, 1000000000, 4)),
                    List.of(
                            new MobEffectInstance(MobEffects.SATURATION, 50, 10)
                    ),
                    100,
                    new ItemStack(EMPTY_ENERYETI.get())
            )
    );
    public static final RegistryObject<Item> DEVIL_CONTRACT_ENERYETI = ITEMS.register("devil_contract_eneryeti", () ->
            new EneryetiItem(
                    new Item.Properties().rarity(Rarity.EPIC).stacksTo(16).food(
                            new FoodProperties.Builder().nutrition(4).saturationMod(1f).alwaysEat().build()
                    ),
                    List.of(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 3600, 150),
                            new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 3600, 1)),
                    List.of(
                            new MobEffectInstance(MobEffects.HARM, 100, 150)
                    ),
                    3600,
                    new ItemStack(EMPTY_ENERYETI.get())
            )
    );

    public static final RegistryObject<Item> BLINDNESS_FURY_ENERYETI = ITEMS.register("blindness_fury_eneryeti", () ->
            new EneryetiItem(
                    new Item.Properties().rarity(Rarity.EPIC).stacksTo(16).food(
                            new FoodProperties.Builder().nutrition(4).saturationMod(1f).alwaysEat().build()
                    ),
                    List.of(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 6000, 15),
                            new MobEffectInstance(MobEffects.BLINDNESS, 6000, 1)),
                    List.of(
                            new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 300, 5)
                    ),
                    6000,
                    new ItemStack(EMPTY_ENERYETI.get())
            )
    );

    public static final RegistryObject<Item> SATURARION_ENERYETI = ITEMS.register("saturation_eneryeti", () ->
            new EneryetiItem(
                    new Item.Properties().rarity(Rarity.EPIC).stacksTo(16).food(
                            new FoodProperties.Builder().nutrition(4).saturationMod(1f).alwaysEat().build()
                    ),
                    List.of(new MobEffectInstance(MobEffects.SATURATION, 72000, 2)),
                    List.of(
                            new MobEffectInstance(MobEffects.HUNGER, 1200, 3)
                    ),
                    72000,
                    new ItemStack(EMPTY_ENERYETI.get())
            )
    );
    // *********************************************************** END OF TIER 4 ENERYETI ITEMS ***********************************************************

    public static final RegistryObject<Item> APM_COIN = ITEMS.register("apm_coin", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ENERYETI_COMPOUND_TIER1 = ITEMS.register("eneryeti_compound_tier1", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ENERYETI_COMPOUND_TIER2 = ITEMS.register("eneryeti_compound_tier2", () -> new Item(new Item.Properties().rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> ENERYETI_COMPOUND_TIER3 = ITEMS.register("eneryeti_compound_tier3", () -> new Item(new Item.Properties().rarity(Rarity.RARE
    )));
    public static final RegistryObject<Item> ENERYETI_COMPOUND_TIER4 = ITEMS.register("eneryeti_compound_tier4", () -> new ShinningItem(new Item.Properties().rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> POOR_ENERYETI_SPICE = ITEMS.register("poor_eneryeti_spice", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PREPARED_ENERYETI_SPICE = ITEMS.register("prepared_eneryeti_spice", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SPICY_ENERYETI_SPICE = ITEMS.register("spicy_eneryeti_spice", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ENDERED_ENERYETI_SPICE = ITEMS.register("endered_eneryeti_spice", () -> new ShinningItem(new Item.Properties().rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> CRYPTED_NOTE = ITEMS.register("crypted_note",
            () -> new ShinningItem(new Item.Properties().rarity(Rarity.EPIC).stacksTo(1),
                    "No se entiende nada de lo que pone aqui",
                    "Tal vez con un desencriptador se pueda hacer algo"
            ));

    public static void register(IEventBus event) {
        ITEMS.register(event);
    }
}