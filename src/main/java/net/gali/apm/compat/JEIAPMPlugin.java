package net.gali.apm.compat;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.IGuiHandlerRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.gali.apm.APMMod;
import net.gali.apm.recipe.EneryetizadorRecipe;
import net.gali.apm.screen.EneryetizadorScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeManager;

import java.util.List;

@JeiPlugin
public class JEIAPMPlugin implements IModPlugin {
    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(APMMod.MOD_ID, "jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new EneryetizadorCategory(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager recipeManager = Minecraft.getInstance().level.getRecipeManager();

        List<EneryetizadorRecipe> eneryetizadorRecipes = recipeManager.getAllRecipesFor(EneryetizadorRecipe.Type.INSTANCE);
        registration.addRecipes(EneryetizadorCategory.ENERYETIZADOR_TYPE, eneryetizadorRecipes);
    }

    @Override
    public void registerGuiHandlers(IGuiHandlerRegistration registration) {
        registration.addRecipeClickArea(EneryetizadorScreen.class, 38, 8, 79, 44,
                EneryetizadorCategory.ENERYETIZADOR_TYPE);
    }
}
