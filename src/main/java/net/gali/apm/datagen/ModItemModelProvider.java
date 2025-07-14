package net.gali.apm.datagen;

import net.gali.apm.APMMod;
import net.gali.apm.block.ModBlocks;
import net.gali.apm.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, APMMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.APMIUM);
        simpleItem(ModItems.DRAGON_FUSED_APMIUM);
        simpleItem(ModItems.RAW_APMIUM);
        simpleItem(ModItems.SKOL_LABEL);
        simpleItem(ModItems.SKOL);
        simpleItem(ModItems.EMPTY_SKOL);
        simpleItem(ModItems.BROKEN_SKOL);
        simpleItem(ModItems.ENERYETI_COMPOUND_TIER1);
        simpleItem(ModItems.ENERYETI_COMPOUND_TIER2);
        simpleItem(ModItems.ENERYETI_COMPOUND_TIER3);
        simpleItem(ModItems.ENERYETI_COMPOUND_TIER4);
        simpleItem(ModItems.POOR_ENERYETI_SPICE);
        simpleItem(ModItems.PREPARED_ENERYETI_SPICE);
        simpleItem(ModItems.SPICY_ENERYETI_SPICE);
        simpleItem(ModItems.ENDERED_ENERYETI_SPICE);
        simpleItem(ModItems.CRYPTED_NOTE);
        simpleItem(ModItems.EMPTY_ENERYETI);

        simpleItem(ModItems.WATERMELON_ENERYETI);
        simpleItem(ModItems.STRAWBERRY_ENERYETI);
        simpleItem(ModItems.APPLE_ENERYETI);
        simpleItem(ModItems.LEMON_CACTUS_ENERYETI);
        simpleItem(ModItems.MINT_ENERYETI);
        simpleItem(ModItems.SWEET_PINEAPPLE_ENERYETI);
        simpleItem(ModItems.BLUE_GRAPE_ENERYETI);
        simpleItem(ModItems.PEACH_ENERYETI);
        simpleItem(ModItems.WILD_CHERRY_ENERYETI);
        simpleItem(ModItems.GREEN_KIWI_ENERYETI);

        simpleItem(ModItems.ELECTRIC_ORANGE_ENERYETI);
        simpleItem(ModItems.INFERNAL_LEMON_ENERYETI);
        simpleItem(ModItems.ICED_TEA_ENERYETI);
        simpleItem(ModItems.COCONUT_ENERYETI);
        simpleItem(ModItems.WILD_CITRUS_ENERYETI);
        simpleItem(ModItems.BLUE_RASPBERRY_ENERYETI);
        simpleItem(ModItems.PRISMA_RASPBERRY_ENERYETI);
        simpleItem(ModItems.GLITCH_GRANATE_ENERYETI);

        simpleItem(ModItems.CRIMSON_FIRE_ENERYETI);
        simpleItem(ModItems.FRUIT_LAVA_ENERYETI);
        simpleItem(ModItems.SAVAGE_POTION_ENERYETI);
        simpleItem(ModItems.MAGMA_CREAM_ENERYETI);
        simpleItem(ModItems.ABYSSAL_FOG_ENERYETI);
        simpleItem(ModItems.WEIRD_BREWERY_ENERYETI);

        simpleItem(ModItems.ETERNAL_ECHO_ENERYETI);
        simpleItem(ModItems.BLINDNESS_FURY_ENERYETI);
        simpleItem(ModItems.SATURARION_ENERYETI);
        simpleItem(ModItems.DEVIL_CONTRACT_ENERYETI);

        simpleItem(ModItems.APM_COIN);
        simpleItem(ModItems.APM_DISC_VOL1);

        blockItem(ModBlocks.ENERYETIZADOR);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(APMMod.MOD_ID, "item/" + item.getId().getPath()));
    }

    private void blockItem(RegistryObject<Block> block) {
        withExistingParent(
                ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath())
        );
    }
}
