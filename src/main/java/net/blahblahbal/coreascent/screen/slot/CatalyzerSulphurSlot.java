package net.blahblahbal.coreascent.screen.slot;

import net.blahblahbal.coreascent.block.ModBlocks;
import net.blahblahbal.coreascent.item.ModItems;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class CatalyzerSulphurSlot extends SlotItemHandler
{
    public CatalyzerSulphurSlot(IItemHandler itemHandler, int index, int x, int y)
    {
        super(itemHandler, index, x, y);
    }

    @Override
    public boolean mayPlace(ItemStack stack)
    {
        return stack.getItem() == ModItems.SULPHUR.get() || stack.getItem() == ModBlocks.SULPHUR_BLOCK.get().asItem();
    }

    @Override
    public int getMaxStackSize(ItemStack pStack)
    {
        return super.getMaxStackSize(pStack);
    }
}