package net.gali.apm.datagen;

import net.gali.apm.APMMod;
import net.gali.apm.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, APMMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.APMIUM);
        simpleItem(ModItems.RAW_APMIUM);
        simpleItem(ModItems.SKOL_LABEL);
        simpleItem(ModItems.SKOL);
        simpleItem(ModItems.EMPTY_SKOL);
        simpleItem(ModItems.BROKEN_SKOL);
        simpleItem(ModItems.ENERYETI_VACIO);
        simpleItem(ModItems.ENERYETI_SANDIA);

        simpleItem(ModItems.APM_DISC_VOL1);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(APMMod.MOD_ID,"item/" + item.getId().getPath()));
    }
}
