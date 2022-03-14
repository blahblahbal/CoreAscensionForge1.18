package net.blahblahbal.coreascent.world.feature;

import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.*;

public class ModPlacedFeatures
{
    public static final PlacedFeature SULPHUR_ORE_PLACED = PlacementUtils.register("sulphur_ore_placed",
            ModConfiguredFeature.SULPHUR_ORE.placed(ModOrePlacement.commonOrePlacement(6, // VeinsPerChunk
                    HeightRangePlacement.uniform(VerticalAnchor.absolute(10), VerticalAnchor.absolute(55)))));
    public static final PlacedFeature RUBY_ORE_PLACED = PlacementUtils.register("ruby_ore_placed",
            ModConfiguredFeature.RUBY_ORE.placed(ModOrePlacement.commonOrePlacement(7, // VeinsPerChunk
                    HeightRangePlacement.uniform(VerticalAnchor.absolute(10), VerticalAnchor.absolute(55)))));
    public static final PlacedFeature CITRINE_ORE_PLACED = PlacementUtils.register("citrine_ore_placed",
            ModConfiguredFeature.CITRINE_ORE.placed(ModOrePlacement.commonOrePlacement(7, // VeinsPerChunk
                    HeightRangePlacement.uniform(VerticalAnchor.absolute(10), VerticalAnchor.absolute(55)))));
    public static final PlacedFeature TOPAZ_ORE_PLACED = PlacementUtils.register("topaz_ore_placed",
            ModConfiguredFeature.TOPAZ_ORE.placed(ModOrePlacement.commonOrePlacement(7, // VeinsPerChunk
                    HeightRangePlacement.uniform(VerticalAnchor.absolute(10), VerticalAnchor.absolute(55)))));
    public static final PlacedFeature TANZANITE_ORE_PLACED = PlacementUtils.register("tanzanite_ore_placed",
            ModConfiguredFeature.TANZANITE_ORE.placed(ModOrePlacement.commonOrePlacement(7, // VeinsPerChunk
                    HeightRangePlacement.uniform(VerticalAnchor.absolute(10), VerticalAnchor.absolute(55)))));

    public static final PlacedFeature IGNEOUS_ROCK_PLACED = PlacementUtils.register("igneous_rock_placed",
            ModConfiguredFeature.IGNEOUS_ROCK.placed(ModOrePlacement.commonOrePlacement(1, // VeinsPerChunk
                    HeightRangePlacement.uniform(VerticalAnchor.absolute(10), VerticalAnchor.absolute(60)))));
    public static final PlacedFeature MAGNETITE_PLACED = PlacementUtils.register("magnetite_placed",
            ModConfiguredFeature.MAGNETITE.placed(ModOrePlacement.commonOrePlacement(1, // VeinsPerChunk
                    HeightRangePlacement.uniform(VerticalAnchor.absolute(10), VerticalAnchor.absolute(60)))));
    public static final PlacedFeature SALTROCK_PLACED = PlacementUtils.register("saltrock_placed",
            ModConfiguredFeature.SALTROCK.placed(ModOrePlacement.commonOrePlacement(1, // VeinsPerChunk
                    HeightRangePlacement.uniform(VerticalAnchor.absolute(10), VerticalAnchor.absolute(60)))));
    public static final PlacedFeature HARDENED_LAVA_PLACED = PlacementUtils.register("hardened_lava_placed",
            ModConfiguredFeature.HARDENED_LAVA.placed(ModOrePlacement.commonOrePlacement(1, // VeinsPerChunk
                    HeightRangePlacement.uniform(VerticalAnchor.absolute(10), VerticalAnchor.absolute(30)))));
}