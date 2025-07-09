package net.gali.apm.datagen;

import net.gali.apm.APMMod;
import net.gali.apm.block.ModBlocks;
import net.minecraft.core.Direction;
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

        multiBlockWithLitFront(
                ModBlocks.ENERYETIZADOR.get(),
                modLoc("block/eneryetizador_side"),
                modLoc("block/eneryetizador_front"),
                modLoc("block/eneryetizador_front_on"),
                modLoc("block/eneryetizador_top"),
                modLoc("block/eneryetizador_bottom")
        );
    }

    public void multiBlockWithLitFront(Block block, ResourceLocation side, ResourceLocation frontOff, ResourceLocation frontOn, ResourceLocation top, ResourceLocation bottom) {
        String name = ForgeRegistries.BLOCKS.getKey(block).getPath();

        ModelFile offModel = models().withExistingParent(name, mcLoc("block/orientable"))
                .texture("side", side)
                .texture("front", frontOff)
                .texture("top", top)
                .texture("bottom", bottom);

        ModelFile onModel = models().withExistingParent(name + "_on", mcLoc("block/orientable"))
                .texture("side", side)
                .texture("front", frontOn)
                .texture("top", top)
                .texture("bottom", bottom);

        getVariantBuilder(block)
                .partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).with(BlockStateProperties.LIT, false)
                .modelForState().modelFile(offModel).addModel()
                .partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).with(BlockStateProperties.LIT, true)
                .modelForState().modelFile(onModel).addModel()
                // ... repite para EAST, SOUTH, WEST con rotaciones
                .partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).with(BlockStateProperties.LIT, false)
                .modelForState().modelFile(offModel).rotationY(180).addModel()
                .partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).with(BlockStateProperties.LIT, true)
                .modelForState().modelFile(onModel).rotationY(180).addModel()
                .partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).with(BlockStateProperties.LIT, false)
                .modelForState().modelFile(offModel).rotationY(270).addModel()
                .partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).with(BlockStateProperties.LIT, true)
                .modelForState().modelFile(onModel).rotationY(270).addModel()
                .partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).with(BlockStateProperties.LIT, false)
                .modelForState().modelFile(offModel).rotationY(90).addModel()
                .partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).with(BlockStateProperties.LIT, true)
                .modelForState().modelFile(onModel).rotationY(90).addModel();
    }


    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
