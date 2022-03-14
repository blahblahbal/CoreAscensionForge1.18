package net.blahblahbal.coreascent.api.crafting;

import net.blahblahbal.coreascent.CoreAscension;
import net.blahblahbal.coreascent.api.crafting.RecipeTypes;
import net.blahblahbal.coreascent.api.crafting.recipe.CatalyzerRecipe;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

public final class ModRecipeSerializers
{
    public static final RecipeSerializer<CatalyzerRecipe> CATALYZER = new CatalyzerRecipe.Serializer();

    @SubscribeEvent
    public void onRegisterSerializers(RegistryEvent.Register<RecipeSerializer<?>> event)
    {
        var registry = event.getRegistry();

        registry.register(CATALYZER.setRegistryName(new ResourceLocation(CoreAscension.MOD_ID, "catalyzer")));
        Registry.register(Registry.RECIPE_TYPE, new ResourceLocation(CoreAscension.MOD_ID, "catalyzer"), RecipeTypes.CATALYZER);
    }
}