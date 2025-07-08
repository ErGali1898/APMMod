package net.gali.apm.datagen.loot;

import net.gali.apm.block.ModBlocks;
import net.gali.apm.item.ModItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {

    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.add(ModBlocks.APMIUM_ORE.get(), block -> createAPMiumOreDrops(ModBlocks.APMIUM_ORE.get(), ModItems.RAW_APMIUM.get()));
        this.add(ModBlocks.DEEPSLATE_APMIUM_ORE.get(), block -> createAPMiumOreDrops(ModBlocks.DEEPSLATE_APMIUM_ORE.get(), ModItems.RAW_APMIUM.get()));
        this.dropSelf(ModBlocks.APMIUM_BLOCK.get());
        this.dropSelf(ModBlocks.ENERYETIZADOR.get());
    }

    protected LootTable.Builder createAPMiumOreDrops(Block pBlock, Item item) {
        return createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock,
                        LootItem.lootTableItem(item).
                                apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
