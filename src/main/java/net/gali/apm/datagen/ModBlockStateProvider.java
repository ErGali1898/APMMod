package net.gali.apm.datagen;

import net.gali.apm.APMMod;
import net.gali.apm.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, APMMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.APMIUM_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_APMIUM_ORE);
        blockWithItem(ModBlocks.APMIUM_BLOCK);

        horizontalBlock(
                ModBlocks.ENERYETIZADOR.get(),
                modLoc("block/eneryetizador_side"),
                modLoc("block/eneryetizador_front"),
                modLoc("block/eneryetizador_top"),
                modLoc("block/eneryetizador_top")
        );
    }

    public void horizontalBlock(Block block, ResourceLocation side, ResourceLocation front, ResourceLocation top, ResourceLocation bottom) {
        String blockName = ForgeRegistries.BLOCKS.getKey(block).getPath();

        ModelFile model = models().withExistingParent(blockName, mcLoc("block/orientable"))
                .texture("side", side)
                .texture("front", front)
                .texture("top", top)
                .texture("bottom", bottom);

        getVariantBuilder(block).forAllStates(state -> ConfiguredModel.builder()
                .modelFile(model)
                .rotationY(((int) state.getValue(BlockStateProperties.HORIZONTAL_FACING).toYRot() + 180) % 360)
                .build());
    }


    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
