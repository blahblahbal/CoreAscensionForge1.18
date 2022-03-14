package net.blahblahbal.coreascent.screen.slot;

import net.blahblahbal.coreascent.block.ModBlocks;
import net.blahblahbal.coreascent.item.ModItems;
import net.minecraft.world.Container;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.items.IItemHandler;

public class CatalyzerReagentSlot extends Slot
{
    private final AbstractContainerMenu container;
    private final Container matrix;

    public CatalyzerReagentSlot(AbstractContainerMenu container, Container matrix, Container inventory, int index, int xPosition, int yPosition) {
        super(inventory, index, xPosition, yPosition);
        this.container = container;
        this.matrix = matrix;
    }

    @Override
    public boolean mayPlace(ItemStack stack)
    {
        return stack.getItem() == Items.LAVA_BUCKET || stack.getItem() == ModBlocks.HARDENED_LAVA.get().asItem() ||
                stack.getItem() == Blocks.STONE.asItem() || stack.getItem() == ModItems.OSBORGNEN_FUEL.get() ||
                stack.getItem() == ModBlocks.FLINT_BLOCK.get().asItem();
    }

    @Override
    public int getMaxStackSize(ItemStack pStack)
    {
        return super.getMaxStackSize(pStack);
    }
}