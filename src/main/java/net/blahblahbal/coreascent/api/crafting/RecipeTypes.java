package net.blahblahbal.coreascent.api.crafting;

import net.minecraft.world.Container;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;

import java.util.Optional;

public class RecipeTypes {
    public static final RecipeType<ICatalyzerRecipe> CATALYZER = new RecipeType<ICatalyzerRecipe>() {
        @Override
        public <C extends Container> Optional<ICatalyzerRecipe> tryMatch(Recipe<C> recipe, Level world, C inv) {
            return recipe.matches(inv, world) ? Optional.of((ICatalyzerRecipe) recipe) : Optional.empty();
        }
    };
}