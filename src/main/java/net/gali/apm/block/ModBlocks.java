package net.gali.apm.block;

import net.gali.apm.APMMod;
import net.gali.apm.block.custom.EneryetizadorBlock;
import net.gali.apm.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks{
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, APMMod.MOD_ID);

    public static final RegistryObject<Block> APMIUM_ORE = registerBlock("apmium_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.IRON_ORE).strength(3.5f).requiresCorrectToolForDrops(),
                    UniformInt.of(2,5)));
    public static final RegistryObject<Block> DEEPSLATE_APMIUM_ORE = registerBlock("deepslate_apmium_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_IRON_ORE).strength(7.5f).requiresCorrectToolForDrops(),
                    UniformInt.of(2,5)));
    public static final RegistryObject<Block> APMIUM_BLOCK = registerBlock("apmium_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.LAPIS_BLOCK).sound(SoundType.AMETHYST).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> DRAGON_FUSED_APMIUM_BLOCK = registerBlock("dragon_fused_apmium_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.LAPIS_BLOCK).sound(SoundType.AMETHYST).strength(8.7f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> ENERYETIZADOR = registerBlock("eneryetizador",
            () -> new EneryetizadorBlock(BlockBehaviour.Properties.copy(Blocks.STONE).strength(5.5f).requiresCorrectToolForDrops().sound(SoundType.STONE)));


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus event) {
        BLOCKS.register(event);
    }
}
