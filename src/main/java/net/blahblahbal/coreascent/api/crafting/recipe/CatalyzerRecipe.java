package net.blahblahbal.coreascent.api.crafting.recipe;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import net.blahblahbal.coreascent.CoreAscension;
import net.blahblahbal.coreascent.api.crafting.ICatalyzerRecipe;
import net.blahblahbal.coreascent.api.crafting.ModRecipeSerializers;
import net.blahblahbal.coreascent.api.crafting.RecipeTypes;
import net.minecraft.core.NonNullList;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.wrapper.InvWrapper;
import net.minecraftforge.registries.ForgeRegistryEntry;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class CatalyzerRecipe implements ICatalyzerRecipe
{
    private final ResourceLocation recipeId;
    private final ItemStack output;
    private final NonNullList<Ingredient> ingredients;

    public CatalyzerRecipe(ResourceLocation recipeId, NonNullList<Ingredient> ingredients, ItemStack output)
    {
        this.recipeId = recipeId;
        this.ingredients = ingredients;
        this.output = output;
    }

    @Override
    public boolean canCraftInDimensions(int width, int height)
    {
        return true;
    }

    @Override
    public ItemStack getResultItem()
    {
        return this.output;
    }

    @Override
    public NonNullList<Ingredient> getIngredients()
    {
        return this.ingredients;
    }

    @Override
    public ResourceLocation getId()
    {
        return this.recipeId;
    }

    @Override
    public RecipeSerializer<?> getSerializer()
    {
        return ModRecipeSerializers.CATALYZER;
    }

    @Override
    public RecipeType<?> getType()
    {
        return RecipeTypes.CATALYZER;
    }

    @Override
    public ItemStack assemble(Container inv)
    {
        return this.output.copy();
    }

    @Override
    public boolean matches(Container inv, Level level)
    {
        var input = inv.getItem(0);
        var sulphur = inv.getItem(1);
        var reagent = inv.getItem(2);

        return this.ingredients.get(0).test(input) && this.ingredients.get(1).test(sulphur) &&
                this.ingredients.get(2).test(reagent);
    }
    public static class Type implements RecipeType<CatalyzerRecipe> {
        private Type() { }
        public static final Type INSTANCE = new Type();
        public static final String ID = "catalyzer";
    }
    public static class Serializer implements RecipeSerializer<CatalyzerRecipe>
    {
        public static final Serializer INSTANCE = new Serializer();
        public static final ResourceLocation ID = new ResourceLocation(CoreAscension.MOD_ID,"catalyzer");
        @Override
        public CatalyzerRecipe fromJson(ResourceLocation recipeId, JsonObject json)
        {
            /*NonNullList<Ingredient> inputs = NonNullList.create();
            var input = Ingredient.fromJson(GsonHelper.getAsJsonObject(json, "input"));

            inputs.add(input);

            var ingredients = GsonHelper.getAsJsonArray(json, "ingredients");
            for (int i = 0; i < ingredients.size(); i++)
            {
                var ingredient = Ingredient.fromJson(ingredients.get(i));
                inputs.add(ingredient);
            }


            */
            String s = GsonHelper.getAsString(json, "group", "");
            NonNullList<Ingredient> inputs = itemsFromJson(GsonHelper.getAsJsonArray(json, "ingredients"));
            if (inputs.isEmpty())
            {
                throw new JsonParseException("No ingredients for shapeless recipe");
            }
            else if (inputs.size() > 3)
            {
                throw new JsonParseException("Too many ingredients for shapeless recipe. The maximum is 3");
            }
            else
            {
                var output = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(json, "result"));
                return new CatalyzerRecipe(recipeId, inputs, output);
            }
        }

        private static NonNullList<Ingredient> itemsFromJson(JsonArray pIngredientArray)
        {
            NonNullList<Ingredient> nonnulllist = NonNullList.create();
            for(int i = 0; i < pIngredientArray.size(); ++i)
            {
                Ingredient ingredient = Ingredient.fromJson(pIngredientArray.get(i));
                if (!ingredient.isEmpty())
                {
                    nonnulllist.add(ingredient);
                }
            }
            return nonnulllist;
        }

        @Override
        public CatalyzerRecipe fromNetwork(ResourceLocation recipeId, FriendlyByteBuf buffer)
        {
            int size = buffer.readVarInt();
            var inputs = NonNullList.withSize(size, Ingredient.EMPTY);
            for (int i = 0; i < size; i++)
            {
                inputs.set(i, Ingredient.fromNetwork(buffer));
            }
            var output = buffer.readItem();
            return new CatalyzerRecipe(recipeId, inputs, output);
        }

        @Override
        public void toNetwork(FriendlyByteBuf buffer, CatalyzerRecipe recipe)
        {
            buffer.writeVarInt(recipe.ingredients.size());

            for (var ingredient : recipe.ingredients)
            {
                ingredient.toNetwork(buffer);
            }
            buffer.writeItem(recipe.output);
        }
        @Override
        public RecipeSerializer<?> setRegistryName(ResourceLocation name)
        {
            return INSTANCE;
        }

        @Nullable
        @Override
        public ResourceLocation getRegistryName()
        {
            return ID;
        }

        @Override
        public Class<RecipeSerializer<?>> getRegistryType()
        {
            return Serializer.castClass(RecipeSerializer.class);
        }

        @SuppressWarnings("unchecked") // Need this wrapper, because generics
        private static <G> Class<G> castClass(Class<?> cls)
        {
            return (Class<G>)cls;
        }
    }

}