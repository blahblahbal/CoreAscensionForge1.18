package net.blahblahbal.coreascent.world.feature;

import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.*;

public class ModPlacedFeatures
{
    public static final PlacedFeature SULPHUR_ORE_PLACED = PlacementUtils.register("sulphur_ore_placed",
            ModConfiguredFeature.SULPHUR_ORE.placed(ModOrePlacement.commonOrePlacement(3, // VeinsPerChunk
                    HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80)))));
}