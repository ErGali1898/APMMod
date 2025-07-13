package net.gali.apm.datagen;

import net.gali.apm.APMMod;
import net.gali.apm.item.ModItems;
import net.gali.apm.loot.AddItemModifier;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;

public class ModGlobalLootModifiersProvider extends GlobalLootModifierProvider {

    protected static final String[] structureChestLootTables = {
            "minecraft:chests/abandoned_mineshaft",
            "minecraft:chests/ancient_city",
            "minecraft:chests/ancient_city_ice_box",
            "minecraft:chests/bastion_bridge",
            "minecraft:chests/bastion_hoglin_stable",
            "minecraft:chests/bastion_other",
            "minecraft:chests/bastion_treasure",
            "minecraft:chests/buried_treasure",
            "minecraft:chests/desert_pyramid",
            "minecraft:chests/end_city_treasure",
            "minecraft:chests/igloo_chest",
            "minecraft:chests/jungle_temple",
            "minecraft:chests/nether_bridge",
            "minecraft:chests/pillager_outpost",
            "minecraft:chests/ruined_portal",
            "minecraft:chests/shipwreck_map",
            "minecraft:chests/shipwreck_supply",
            "minecraft:chests/shipwreck_treasure",
            "minecraft:chests/simple_dungeon",
            "minecraft:chests/stronghold_corridor",
            "minecraft:chests/stronghold_crossing",
            "minecraft:chests/stronghold_library",
            "minecraft:chests/underwater_ruin_big",
            "minecraft:chests/underwater_ruin_small",
            "minecraft:chests/village/village_armorer_house",
            "minecraft:chests/village/village_butcher_house",
            "minecraft:chests/village/village_cartographer_house",
            "minecraft:chests/village/village_desert_house",
            "minecraft:chests/village/village_fisher_house",
            "minecraft:chests/village/village_fletcher_house",
            "minecraft:chests/village/village_mason_house",
            "minecraft:chests/village/village_plains_house",
            "minecraft:chests/village/village_savanna_house",
            "minecraft:chests/village/village_shepherd_house",
            "minecraft:chests/village/village_snowy_house",
            "minecraft:chests/village/village_taiga_house",
            "minecraft:chests/village/village_tannery",
            "minecraft:chests/village/village_temple",
            "minecraft:chests/village/village_toolsmith_house",
            "minecraft:chests/village/village_weaponsmith_house",
            "minecraft:chests/woodland_mansion"
    };


    public ModGlobalLootModifiersProvider(PackOutput output) {
        super(output, APMMod.MOD_ID);
    }

    @Override
    protected void start(){
        addInAllStructuresChests(0.1f,ModItems.CRYPTED_NOTE.get());
    }

    protected void addInAllStructuresChests(float prob , Item item) {

        String itemName = item.getDescriptionId().replace("item.", "").replace(APMMod.MOD_ID + ":", "");


        for (String chest : structureChestLootTables) {
            String tableId = chest.replace("minecraft:chests/", "").replace("/", "_");
            String modifierId = itemName + "_in_" + tableId;

            add(modifierId, new AddItemModifier(new LootItemCondition[]{
                    new LootTableIdCondition.Builder(new ResourceLocation(chest)).build(),
                    LootItemRandomChanceCondition.randomChance(prob).build()
            }, item));
        }


    }
}
