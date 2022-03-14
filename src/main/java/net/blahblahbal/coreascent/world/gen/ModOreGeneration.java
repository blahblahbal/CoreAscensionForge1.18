package net.blahblahbal.coreascent.world.gen;

import net.blahblahbal.coreascent.world.feature.ModPlacedFeatures;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.event.world.BiomeLoadingEvent;

import java.util.List;
import java.util.Set;
import java.util.function.Supplier;

public class ModOreGeneration
{
    public static void generateOres(final BiomeLoadingEvent event)
    {
        ResourceKey<Biome> key = ResourceKey.create(Registry.BIOME_REGISTRY, event.getName());
        Set<BiomeDictionary.Type> types = BiomeDictionary.getTypes(key);

        if(types.contains(BiomeDictionary.Type.CONIFEROUS) || types.contains(BiomeDictionary.Type.SPOOKY) ||
                types.contains(BiomeDictionary.Type.SWAMP) || types.contains(BiomeDictionary.Type.MUSHROOM))
        {
            List<Supplier<PlacedFeature>> base =
                    event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES);

            base.add(() -> ModPlacedFeatures.RUBY_ORE_PLACED);
        }

        if(types.contains(BiomeDictionary.Type.SANDY) || types.contains(BiomeDictionary.Type.MESA) ||
                types.contains(BiomeDictionary.Type.BEACH))
        {
            List<Supplier<PlacedFeature>> base =
                    event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES);

            base.add(() -> ModPlacedFeatures.CITRINE_ORE_PLACED);
        }
        if(types.contains(BiomeDictionary.Type.JUNGLE) || types.contains(BiomeDictionary.Type.SAVANNA))
        {
            List<Supplier<PlacedFeature>> base =
                    event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES);

            base.add(() -> ModPlacedFeatures.TANZANITE_ORE_PLACED);
        }

        List<Supplier<PlacedFeature>> base =
                event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES);
        base.add(() -> ModPlacedFeatures.SULPHUR_ORE_PLACED);
        base.add(() -> ModPlacedFeatures.TOPAZ_ORE_PLACED);
        base.add(() -> ModPlacedFeatures.IGNEOUS_ROCK_PLACED);
        base.add(() -> ModPlacedFeatures.MAGNETITE_PLACED);
        base.add(() -> ModPlacedFeatures.SALTROCK_PLACED);
        base.add(() -> ModPlacedFeatures.HARDENED_LAVA_PLACED);

        /*List<Supplier<PlacedFeature>> topaz =
                event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES);
        topaz.add(() -> ModPlacedFeatures.TOPAZ_ORE_PLACED);

        List<Supplier<PlacedFeature>> igneousRock =
                event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES);
        igneousRock.add(() -> ModPlacedFeatures.IGNEOUS_ROCK_PLACED);*/
    }
}