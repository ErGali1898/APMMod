package net.gali.apm.compat;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.drawable.IDrawableAnimated;
import mezz.jei.api.gui.drawable.IDrawableStatic;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.gali.apm.APMMod;
import net.gali.apm.block.ModBlocks;
import net.gali.apm.recipe.EneryetizadorRecipe;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

public class EneryetizadorCategory implements IRecipeCategory<EneryetizadorRecipe> {
    public static final ResourceLocation UID = new ResourceLocation(APMMod.MOD_ID, "eneryetizador");
    public static final ResourceLocation TEXTURE = new ResourceLocation(APMMod.MOD_ID,
            "textures/gui/eneryetizador_gui_jei.png");

    public static final RecipeType<EneryetizadorRecipe> ENERYETIZADOR_TYPE =
            new RecipeType<>(UID, EneryetizadorRecipe.class);

    public final IDrawable background;
    private final IDrawable icon;
    private final IDrawableStatic progressDrawable;
    private final IDrawableAnimated animatedProgress;

    public EneryetizadorCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 78);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.ENERYETIZADOR.get()));

        this.progressDrawable = helper.createDrawable(TEXTURE, 176, 0, 79, 42); // u=176, v=14, w=24, h=17
        this.animatedProgress = helper.createAnimatedDrawable(progressDrawable, 340, IDrawableAnimated.StartDirection.LEFT, false);
    }


    @Override
    public RecipeType<EneryetizadorRecipe> getRecipeType() {
        return ENERYETIZADOR_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.translatable("block.apm.eneryetizador");
    }

    @Override
    public IDrawable getBackground() {
        return this.background;
    }

    @Override
    public @Nullable IDrawable getIcon() {
        return this.icon;
    }

    @Override
    public void draw(EneryetizadorRecipe recipe, IRecipeSlotsView recipeSlotsView, GuiGraphics guiGraphics, double mouseX, double mouseY) {
        animatedProgress.draw(guiGraphics, 39, 11); // 39, 11 - 39, 52 - 117, 52 - 117, 11
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, EneryetizadorRecipe recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 17, 16).addIngredients(recipe.getIngredients().get(0));
        builder.addSlot(RecipeIngredientRole.INPUT, 48, 53).addIngredients(recipe.getIngredients().get(1));
        builder.addSlot(RecipeIngredientRole.INPUT, 69, 53).addIngredients(recipe.getIngredients().get(2));

        builder.addSlot(RecipeIngredientRole.OUTPUT, 130, 35).addItemStack(recipe.getResultItem(null));
    }
}
