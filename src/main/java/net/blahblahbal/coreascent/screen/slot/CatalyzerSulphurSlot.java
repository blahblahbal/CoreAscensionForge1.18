package net.blahblahbal.coreascent.screen.slot;

import net.blahblahbal.coreascent.block.ModBlocks;
import net.blahblahbal.coreascent.item.ModItems;
import net.minecraft.world.Container;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

public class CatalyzerSulphurSlot extends Slot
{
    private final AbstractContainerMenu container;
    private final Container matrix;
    public CatalyzerSulphurSlot(AbstractContainerMenu container, Container matrix, Container inventory, int index, int xPosition, int yPosition) {
        super(inventory, index, xPosition, yPosition);
        this.container = container;
        this.matrix = matrix;
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