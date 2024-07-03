package net.gali.apm.datagen;

import net.gali.apm.APMMod;
import net.gali.apm.block.ModBlocks;
import net.gali.apm.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public static final List<ItemLike> RAW_APMIUM_SMELTABLES = List.of(ModItems.RAW_APMIUM.get(),
            ModBlocks.APMIUM_ORE.get(), ModBlocks.DEEPSLATE_APMIUM_ORE.get());

    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        oreSmelting(pWriter, RAW_APMIUM_SMELTABLES, RecipeCategory.MISC, ModItems.APMIUM.get(), 0.25f, 200, "apmium");
        oreBlasting(pWriter, RAW_APMIUM_SMELTABLES, RecipeCategory.MISC, ModItems.APMIUM.get(), 0.35f, 100, "apmium");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.SKOL_LABEL.get())
            .requires(Ingredient.of(Items.PAPER))
            .requires(Ingredient.of(Items.GREEN_DYE))
            .requires(ModItems.APMIUM.get())
            .unlockedBy(getHasName(ModItems.APMIUM.get()), has(ModItems.APMIUM.get())).save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.SKOL.get(), 1)
            .requires(Ingredient.of(ModItems.SKOL_LABEL.get()))
            .requires(Ingredient.of(Items.GLASS_BOTTLE))
            .requires(ModItems.APMIUM.get())
            .unlockedBy(getHasName(ModItems.APMIUM.get()), has(ModItems.APMIUM.get())).save(pWriter);

    }

    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        Iterator var9 = pIngredients.iterator();

        while(var9.hasNext()) {
            ItemLike itemlike = (ItemLike)var9.next();
            SimpleCookingRecipeBuilder.generic(Ingredient.of(new ItemLike[]{itemlike}), pCategory, pResult,
                    pExperience, pCookingTime, pCookingSerializer).
                    group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike)).
                    save(pFinishedRecipeConsumer, APMMod.MOD_ID+":" +getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }

    }
}