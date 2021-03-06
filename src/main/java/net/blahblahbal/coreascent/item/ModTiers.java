package net.blahblahbal.coreascent.item;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.Tag;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.Tags;
import net.minecraftforge.fml.common.Mod;

import static net.blahblahbal.coreascent.util.ModTags.Blocks.NEEDS_BEDROCK_TOOL;

@Mod.EventBusSubscriber(bus= Mod.EventBusSubscriber.Bus.MOD)
public class ModTiers
{
    public static final ForgeTier TADANITE = new ForgeTier(5, 4000, 14f,
            6f, 20, Tags.Blocks.NEEDS_NETHERITE_TOOL,
            () -> Ingredient.of(ModItems.TADANITE_CRYSTAL.get()));
    public static final ForgeTier LUMITE = new ForgeTier(6, 4500, 15f,
            9f, 25, NEEDS_BEDROCK_TOOL,
            () -> Ingredient.of(ModItems.LUMITE_INGOT.get()));
    public static final ForgeTier BEDROCK = new ForgeTier(7, 5500, 16f,
            8f, 22, NEEDS_BEDROCK_TOOL,
            () -> Ingredient.of(Items.BEDROCK));
}
