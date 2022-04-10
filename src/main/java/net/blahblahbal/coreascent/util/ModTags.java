package net.blahblahbal.coreascent.util;

import net.blahblahbal.coreascent.CoreAscension;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;

    public class ModTags {
        public static class Blocks {
            public static final TagKey<Block> NEEDS_BEDROCK_TOOL =
                    tag("mineable/needs_bedrock_tool");

            private static TagKey<Block> tag(String name) {
                return BlockTags.create(new ResourceLocation(CoreAscension.MOD_ID, name));
            }
        }
    }