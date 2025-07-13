package net.gali.apm.block.entity;

import net.gali.apm.block.custom.EneryetizadorBlock;
import net.gali.apm.recipe.EneryetizadorRecipe;
import net.gali.apm.screen.EneryetizadorMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class EneryetizadorBlockEntity extends BlockEntity implements MenuProvider {
    private final ItemStackHandler ItemHandler = new ItemStackHandler(6);

    public static final int ENERYETI_SLOT = 0;
    public static final int COMPOUND_SLOT = 1;
    public static final int FLAVOUR_SLOT1 = 2;
    public static final int FLAVOUR_SLOT2 = 3;
    public static final int FLAVOUR_SLOT3 = 4;
    public static final int OUTPUT_SLOT = 5;

    private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();

    protected final ContainerData data;
    private int progress = 0;
    private int maxProgress = 340;

    public EneryetizadorBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(ModBlockEntities.ENERYETIZADOR_BE.get(), pPos, pBlockState);
        this.data = new ContainerData() {
            @Override
            public int get(int pIndex) {
                return switch (pIndex) {
                    case 0 -> EneryetizadorBlockEntity.this.progress;
                    case 1 -> EneryetizadorBlockEntity.this.maxProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int pIndex, int pValue) {
                switch (pIndex) {
                    case 0 -> EneryetizadorBlockEntity.this.progress = pValue;
                    case 1 -> EneryetizadorBlockEntity.this.maxProgress = pValue;
                }
            }

            @Override
            public int getCount() {
                return 2;
            }
        };
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if(cap == ForgeCapabilities.ITEM_HANDLER){
            return lazyItemHandler.cast();
        }

        return super.getCapability(cap, side);
    }

    @Override
    public void onLoad() {
        super.onLoad();
        lazyItemHandler = LazyOptional.of(() -> ItemHandler);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        lazyItemHandler.invalidate();
    }

    public void drops(){
        SimpleContainer inventory = new SimpleContainer(ItemHandler.getSlots());
        for(int i = 0; i < ItemHandler.getSlots(); i++) {
            inventory.setItem(i, ItemHandler.getStackInSlot(i));
        }

        Containers.dropContents(this.level, this.worldPosition, inventory);
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable("block.apm.eneryetizador");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int pContainerId, Inventory pPlayerInventory, Player pPlayer) {
        return new EneryetizadorMenu(pContainerId, pPlayerInventory, this, this.data);
    }

    @Override
    protected void saveAdditional(CompoundTag pTag) {
        pTag.put("inventory", ItemHandler.serializeNBT());
        pTag.putInt("eneryetizador.progress", progress);

        super.saveAdditional(pTag);
    }

    @Override
    public void load(CompoundTag pTag) {
        super.load(pTag);
        ItemHandler.deserializeNBT(pTag.getCompound("inventory"));
        progress = pTag.getInt("eneryetizador.progress");
    }

    public void tick(Level pLevel, BlockPos pPos, BlockState pState) {
        if(hasRecipe()){
            increaseCraftingProgress();
            setLit(true);
            setChanged(pLevel, pPos, pState);

            if(hasProgressFinished()){
                craftItem();
                resetProgress();

                if (!hasRecipe()) {
                    setLit(false); // solo se apaga si no hay más recetas
                }
            }
        }else{
            resetProgress();
            setLit(false);
        }
    }

    public void setLit(boolean lit) {
        BlockState state = level.getBlockState(worldPosition);
        if (state.getValue(EneryetizadorBlock.LIT) != lit) {
            level.setBlock(worldPosition, state.setValue(EneryetizadorBlock.LIT, lit), 3);
        }
    }

    private void resetProgress() {
        progress = 0;
    }

    private void craftItem() {
        Optional<EneryetizadorRecipe> recipe = getCurrentRecipe();
        ItemStack result = recipe.get().getResultItem(null);

        this.ItemHandler.extractItem(ENERYETI_SLOT, 1, false);
        this.ItemHandler.extractItem(COMPOUND_SLOT, 1, false);
        this.ItemHandler.extractItem(FLAVOUR_SLOT1, 1, false);
        this.ItemHandler.extractItem(FLAVOUR_SLOT2, 1, false);
        this.ItemHandler.extractItem(FLAVOUR_SLOT3, 1, false);

        this.ItemHandler.setStackInSlot(OUTPUT_SLOT, new ItemStack(result.getItem(),
                this.ItemHandler.getStackInSlot(OUTPUT_SLOT).getCount() + result.getCount()));

    }

    private boolean hasRecipe() {
        Optional<EneryetizadorRecipe> recipe = getCurrentRecipe();

        if(recipe.isEmpty()) {
            return false;
        }

        ItemStack result = recipe.get().getResultItem(getLevel().registryAccess());

        return canInsertAmountIntoOutputSlot(result.getCount()) &&
                canInsertItemIntoOutputSlot(result.getItem());
    }

    private boolean canInsertItemIntoOutputSlot(Item item) {
        return this.ItemHandler.getStackInSlot(OUTPUT_SLOT).isEmpty() ||
                this.ItemHandler.getStackInSlot(OUTPUT_SLOT).is(item);
    }

    private boolean canInsertAmountIntoOutputSlot(int count) {
        return this.ItemHandler.getStackInSlot(OUTPUT_SLOT).getCount() + count <= this.ItemHandler.getStackInSlot(OUTPUT_SLOT).getMaxStackSize();
    }

    private Optional<EneryetizadorRecipe> getCurrentRecipe() {
        SimpleContainer inventory = new SimpleContainer(this.ItemHandler.getSlots());
        for (int i = 0; i < ItemHandler.getSlots(); i++) {
            inventory.setItem(i, this.ItemHandler.getStackInSlot(i));
        }

        return this.level.getRecipeManager().getRecipeFor(EneryetizadorRecipe.Type.INSTANCE, inventory, level);
    }

    private boolean hasProgressFinished() {
        return progress >= maxProgress;
    }

    private void increaseCraftingProgress() {
        progress++;
    }
}
