package net.blahblahbal.coreascent.recipe;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.blahblahbal.coreascent.CoreAscension;
import net.minecraft.core.NonNullList;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;

public class CatalyzerRecipe implements Recipe<SimpleContainer>
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
    public boolean matches(SimpleContainer inv, Level pLevel)
    {
        var input = inv.getItem(0);
        var sulphur = inv.getItem(1);
        var reagent = inv.getItem(2);

        return this.ingredients.get(0).test(input) && this.ingredients.get(1).test(sulphur) &&
                this.ingredients.get(2).test(reagent);
    }

    @Override
    public ItemStack assemble(SimpleContainer pContainer)
    {
        return output;
    }

    @Override
    public boolean canCraftInDimensions(int width, int height)
    {
        return true;
    }

    @Override
    public boolean isSpecial()
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
        return Serializer.INSTANCE;
    }

    @Override
    public RecipeType<?> getType()
    {
        return Type.INSTANCE;
    }

    /*@Override
    public ItemStack assemble(Container inv)
    {
        return this.output.copy();
    }*/
    public static class Type implements RecipeType<CatalyzerRecipe>
    {
        private Type() { }
        public static final Type INSTANCE = new Type();
        public static final String ID = "catalyzer";
    }
    public static class Serializer implements RecipeSerializer<CatalyzerRecipe>
    {
        public static final Serializer INSTANCE = new Serializer();
        public static final ResourceLocation ID = new ResourceLocation(CoreAscension.MOD_ID,"catalyzer");

        @Override
        public CatalyzerRecipe fromJson(ResourceLocation id, JsonObject json) {
            ItemStack output = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(json, "output"));

            JsonArray ingredients = GsonHelper.getAsJsonArray(json, "ingredients");
            NonNullList<Ingredient> inputs = NonNullList.withSize(3, Ingredient.EMPTY);

            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.fromJson(ingredients.get(i)));
            }

            return new CatalyzerRecipe(id, inputs, output);
        }

        @Override
        public CatalyzerRecipe fromNetwork(ResourceLocation id, FriendlyByteBuf buf)
        {
            NonNullList<Ingredient> inputs = NonNullList.withSize(buf.readInt(), Ingredient.EMPTY);

            for (int i = 0; i < inputs.size(); i++)
            {
                inputs.set(i, Ingredient.fromNetwork(buf));
            }

            ItemStack output = buf.readItem();
            return new CatalyzerRecipe(id, inputs, output);
        }

        @Override
        public void toNetwork(FriendlyByteBuf buf, CatalyzerRecipe recipe)
        {
            buf.writeInt(recipe.getIngredients().size());
            for (Ingredient ing : recipe.getIngredients())
            {
                ing.toNetwork(buf);
            }
            buf.writeItemStack(recipe.getResultItem(), false);
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