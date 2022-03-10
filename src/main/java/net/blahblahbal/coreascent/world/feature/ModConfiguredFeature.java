package net.blahblahbal.coreascent.world.feature;

import net.blahblahbal.coreascent.block.ModBlocks;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;

import java.util.List;

public class ModConfiguredFeature
{
    public static final List<OreConfiguration.TargetBlockState> NETHER_ORES = List.of(
            OreConfiguration.target(OreFeatures.NETHER_ORE_REPLACEABLES, ModBlocks.SULPHUR_ORE.get().defaultBlockState()));

    public static final ConfiguredFeature<?, ?> SULPHUR_ORE = FeatureUtils.register("sulphur_ore",
            Feature.ORE.configured(new OreConfiguration(NETHER_ORES, 9)));
}