package net.gali.apm.recipe;

import net.gali.apm.APMMod;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, APMMod.MOD_ID);

    public static final RegistryObject<RecipeSerializer<EneryetizadorRecipe>> ENERYETIZADOR_SERIALIZER =
            SERIALIZERS.register("eneryetizador", () -> EneryetizadorRecipe.Serializer.INSTANCE);

    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
    }
}
