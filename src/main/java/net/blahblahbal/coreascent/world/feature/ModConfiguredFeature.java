package net.blahblahbal.coreascent.world.feature;

import net.blahblahbal.coreascent.block.ModBlocks;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.HashMap;
import java.util.List;

public class ModConfiguredFeature
{
    public static final List<OreConfiguration.TargetBlockState> SULPHUR_ORES = List.of(
            OreConfiguration.target(OreFeatures.NETHER_ORE_REPLACEABLES, ModBlocks.SULPHUR_ORE.get().defaultBlockState()));
    public static final List<OreConfiguration.TargetBlockState> RUBY_ORES = List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.RUBY_ORE.get().defaultBlockState()));
    public static final List<OreConfiguration.TargetBlockState> CITRINE_ORES = List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.CITRINE_ORE.get().defaultBlockState()));
    public static final List<OreConfiguration.TargetBlockState> TOPAZ_ORES = List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.TOPAZ_ORE.get().defaultBlockState()));
    public static final List<OreConfiguration.TargetBlockState> SAPPHIRE_ORES = List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.SAPPHIRE_ORE.get().defaultBlockState()));
    public static final List<OreConfiguration.TargetBlockState> TANZANITE_ORES = List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.TANZANITE_ORE.get().defaultBlockState()));

    public static final List<OreConfiguration.TargetBlockState> LIMESTONE_ORES = List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.LIMESTONE_ORE.get().defaultBlockState()));

    public static final List<OreConfiguration.TargetBlockState> IGNEOUS_ROCKS = List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.IGNEOUS_ROCK.get().defaultBlockState()));
    public static final List<OreConfiguration.TargetBlockState> MAGNETITES = List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.MAGNETITE.get().defaultBlockState()));
    public static final List<OreConfiguration.TargetBlockState> SALTROCKS = List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.SALTROCK.get().defaultBlockState()));
    public static final List<OreConfiguration.TargetBlockState> HARDENED_LAVAS = List.of(
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.HARDENED_LAVA.get().defaultBlockState()));

    public static final ConfiguredFeature<?, ?> SULPHUR_ORE = FeatureUtils.register("sulphur_ore",
            Feature.ORE.configured(new OreConfiguration(SULPHUR_ORES, 7)));

    public static final ConfiguredFeature<?, ?> RUBY_ORE = FeatureUtils.register("ruby_ore",
            Feature.ORE.configured(new OreConfiguration(RUBY_ORES, 3)));
    public static final ConfiguredFeature<?, ?> CITRINE_ORE = FeatureUtils.register("citrine_ore",
            Feature.ORE.configured(new OreConfiguration(CITRINE_ORES, 3)));
    public static final ConfiguredFeature<?, ?> TOPAZ_ORE = FeatureUtils.register("topaz_ore",
            Feature.ORE.configured(new OreConfiguration(TOPAZ_ORES, 3)));
    public static final ConfiguredFeature<?, ?> TANZANITE_ORE = FeatureUtils.register("tanzanite_ore",
            Feature.ORE.configured(new OreConfiguration(TANZANITE_ORES, 3)));

    public static final ConfiguredFeature<?, ?> LIMESTONE_ORE = FeatureUtils.register("limestone_ore",
            Feature.ORE.configured(new OreConfiguration(LIMESTONE_ORES, 6)));

    public static final ConfiguredFeature<?, ?> IGNEOUS_ROCK = FeatureUtils.register("igneous_rock",
            Feature.ORE.configured(new OreConfiguration(IGNEOUS_ROCKS, 20)));
    public static final ConfiguredFeature<?, ?> MAGNETITE = FeatureUtils.register("magnetite",
            Feature.ORE.configured(new OreConfiguration(MAGNETITES, 20)));
    public static final ConfiguredFeature<?, ?> SALTROCK = FeatureUtils.register("saltrock",
            Feature.ORE.configured(new OreConfiguration(SALTROCKS, 20)));
    public static final ConfiguredFeature<?, ?> HARDENED_LAVA = FeatureUtils.register("hardened_lava",
            Feature.ORE.configured(new OreConfiguration(HARDENED_LAVAS, 15)));
}