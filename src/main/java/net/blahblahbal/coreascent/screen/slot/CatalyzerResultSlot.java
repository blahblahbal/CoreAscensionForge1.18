package net.blahblahbal.coreascent.screen.slot;

import net.blahblahbal.coreascent.api.crafting.RecipeTypes;
import net.minecraft.core.NonNullList;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.CraftingContainer;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

public class CatalyzerResultSlot extends Slot
{
    private final AbstractContainerMenu container;
    private final Container matrix;

    public CatalyzerResultSlot(AbstractContainerMenu container, Container matrix, Container inventory, int index, int xPosition, int yPosition) {
        super(inventory, index, xPosition, yPosition);
        this.container = container;
        this.matrix = matrix;
    }

    @Override
    public boolean mayPlace(ItemStack stack)
    {
        return false;
    }

    @Override
    public void onTake(Player player, ItemStack stack)
    {

        NonNullList<ItemStack> remaining;
        remaining = player.level.getRecipeManager().getRemainingItemsFor(RecipeTypes.CATALYZER, this.matrix, player.level);

        for (int i = 0; i < remaining.size(); i++) {
            var slotStack = this.matrix.getItem(i);
            var remainingStack = remaining.get(i);

            if (!slotStack.isEmpty()) {
                this.matrix.removeItem(i, 1);
                slotStack = this.matrix.getItem(i);
            }

            if (!remainingStack.isEmpty()) {
                if (slotStack.isEmpty()) {
                    this.matrix.setItem(i, remainingStack);
                } else if (ItemStack.isSame(slotStack, remainingStack) && ItemStack.tagMatches(slotStack, remainingStack)) {
                    remainingStack.grow(slotStack.getCount());
                    this.matrix.setItem(i, remainingStack);
                } else if (!player.getInventory().add(remainingStack)) {
                    player.drop(remainingStack, false);
                }
            }
        }

        this.container.slotsChanged(this.matrix);
    }
}
