package net.gali.apm.block.entity;

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

public class EneryetizadorBlockEntity extends BlockEntity implements MenuProvider {
    private final ItemStackHandler ItemHandler = new ItemStackHandler(4);

    public static final int ENERYETI_SLOT = 0;
    public static final int FLAVOUR_SLOT1 = 1;
    public static final int FLAVOUR_SLOT2 = 2;
    public static final int OUTPUT_SLOT = 3;

    private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();

    protected final ContainerData data;
    private int progress = 0;
    private int maxProgress = 200;

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
        if(/*hasRecipe()*/true){
            increaseCraftingProgress();
            setChanged(pLevel, pPos, pState);

            if(hasProgressFinished()){
                //craftItem();
                resetProgress();
            }
        }else{
            resetProgress();
        }
    }

    private void resetProgress() {
        progress = 0;
    }

    /*private void craftItem() {

    }

    private boolean hasRecipe() {

    }*/

    private boolean hasProgressFinished() {
        return progress >= maxProgress;
    }

    private void increaseCraftingProgress() {
        progress++;
    }
}
