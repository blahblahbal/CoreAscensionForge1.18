package net.blahblahbal.coreascent.recipe;

import net.blahblahbal.coreascent.CoreAscension;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class ModRecipeSerializers
{
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, CoreAscension.MOD_ID);

    public static final RegistryObject<RecipeSerializer<CatalyzerRecipe>> CATALYZER_SERIALIZER =
            SERIALIZERS.register("cobalt_blasting", () -> CatalyzerRecipe.Serializer.INSTANCE);

    public static void register(IEventBus eventBus)
    {
        SERIALIZERS.register(eventBus);
    }
}