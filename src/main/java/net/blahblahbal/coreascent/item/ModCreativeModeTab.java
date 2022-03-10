package net.blahblahbal.coreascent.item;

import net.blahblahbal.coreascent.block.ModBlocks;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab
{
    public static final CreativeModeTab ITEM_TAB = new CreativeModeTab("itemtab")
    {
        @Override
        public ItemStack makeIcon()
        {
            return new ItemStack(ModItems.SULPHUR.get());
        }
    };
    public static final CreativeModeTab BLOCK_TAB = new CreativeModeTab("blocktab")
    {
        @Override
        public ItemStack makeIcon()
        {
            return new ItemStack(ModBlocks.SULPHUR_BLOCK.get());
        }
    };
}