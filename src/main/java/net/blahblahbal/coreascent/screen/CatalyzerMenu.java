package net.blahblahbal.coreascent.screen;

import net.blahblahbal.coreascent.api.crafting.ICatalyzerRecipe;
import net.blahblahbal.coreascent.api.crafting.RecipeTypes;
import net.blahblahbal.coreascent.api.crafting.recipe.CatalyzerRecipe;
import net.blahblahbal.coreascent.block.ModBlocks;
import net.blahblahbal.coreascent.block.entity.CatalyzerBlockEntity;
import net.blahblahbal.coreascent.block.entity.ModBlockEntities;
import net.blahblahbal.coreascent.screen.slot.CatalyzerReagentSlot;
import net.blahblahbal.coreascent.screen.slot.CatalyzerResultSlot;
import net.blahblahbal.coreascent.screen.slot.CatalyzerSulphurSlot;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.protocol.game.ClientboundContainerSetSlotPacket;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.CraftingRecipe;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.SlotItemHandler;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;
import java.util.function.Function;

public class CatalyzerMenu extends AbstractContainerMenu
{
    private final Level level;
    private final ResultContainer result;
    private final CraftingContainer matrix = new CraftingContainer(this, 4, 1);
    private final Player player;

    public CatalyzerMenu(int id, Inventory inv)
    {
        super(ModMenuTypes.CATALYZER.get(), id);
        checkContainerSize(inv, 4);
        this.level = inv.player.level;
        this.result = new ResultContainer();
        this.player = inv.player;

        this.addSlot(new Slot(matrix, 0, 23, 18)); // input
        this.addSlot(new CatalyzerSulphurSlot(this, matrix, inv, 1, 23, 44));
        this.addSlot(new CatalyzerReagentSlot(this, matrix, inv, 2, 55, 18));
        this.addSlot(new CatalyzerResultSlot(this, matrix, inv, 3, 117, 30));

        int i, j;
        for (i = 0; i < 3; i++)
        {
            for (j = 0; j < 9; j++)
            {
                this.addSlot(new Slot(inv, j + i * 9 + 9, 7 + j * 18, 83 + i * 18)); // 88
            }
        }

        for (j = 0; j < 9; j++)
        {
            this.addSlot(new Slot(inv, j, 7 + j * 18, 141)); // 146
        }

        //slotsChanged(matrix);
    }

    // CREDIT GOES TO: diesieben07 | https://github.com/diesieben07/SevenCommons
    // must assign a slot number to each of the slots used by the GUI.
    // For this container, we can see both the tile inventory's slots as well as the player inventory slots and the hotbar.
    // Each time we add a Slot to the container, it automatically increases the slotIndex, which means
    //  0 - 8 = hotbar slots (which will map to the InventoryPlayer slot numbers 0 - 8)
    //  9 - 35 = player inventory slots (which map to the InventoryPlayer slot numbers 9 - 35)
    //  36 - 44 = TileInventory slots, which map to our TileEntity slot numbers 0 - 8)
    private static final int HOTBAR_SLOT_COUNT = 9;
    private static final int PLAYER_INVENTORY_ROW_COUNT = 3;
    private static final int PLAYER_INVENTORY_COLUMN_COUNT = 9;
    private static final int PLAYER_INVENTORY_SLOT_COUNT = PLAYER_INVENTORY_COLUMN_COUNT * PLAYER_INVENTORY_ROW_COUNT;
    private static final int VANILLA_SLOT_COUNT = HOTBAR_SLOT_COUNT + PLAYER_INVENTORY_SLOT_COUNT;
    private static final int VANILLA_FIRST_SLOT_INDEX = 4;
    private static final int TE_INVENTORY_FIRST_SLOT_INDEX = VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT;

    // THIS YOU HAVE TO DEFINE!
    private static final int TE_INVENTORY_SLOT_COUNT = 4;  // must be the number of slots you have!

    /*@Override
    public ItemStack quickMoveStack(Player playerIn, int index) {
        Slot sourceSlot = slots.get(index);
        if (sourceSlot == null || !sourceSlot.hasItem()) return ItemStack.EMPTY;  //EMPTY_ITEM
        ItemStack sourceStack = sourceSlot.getItem();
        ItemStack copyOfSourceStack = sourceStack.copy();

        // Check if the slot clicked is one of the vanilla container slots
        if (index < VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT) {
            // This is a vanilla container slot so merge the stack into the tile inventory
            if (!moveItemStackTo(sourceStack, TE_INVENTORY_FIRST_SLOT_INDEX, TE_INVENTORY_FIRST_SLOT_INDEX
                    + TE_INVENTORY_SLOT_COUNT, false)) {
                return ItemStack.EMPTY;  // EMPTY_ITEM
            }
        } else if (index < TE_INVENTORY_FIRST_SLOT_INDEX + TE_INVENTORY_SLOT_COUNT) {
            // This is a TE slot so merge the stack into the players inventory
            if (!moveItemStackTo(sourceStack, VANILLA_FIRST_SLOT_INDEX, VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT, false)) {
                return ItemStack.EMPTY;
            }
        } else {
            System.out.println("Invalid slotIndex:" + index);
            return ItemStack.EMPTY;
        }
        // If stack size == 0 (the entire stack was moved) set slot contents to null
        if (sourceStack.getCount() == 0) {
            sourceSlot.set(ItemStack.EMPTY);
        } else {
            sourceSlot.setChanged();
        }
        sourceSlot.onTake(playerIn, sourceStack);
        return copyOfSourceStack;
    }*/

    @Override
    public ItemStack quickMoveStack(Player player, int slotNumber)
    {
        var itemstack = ItemStack.EMPTY;
        var slot = this.slots.get(slotNumber);

        if (slot.hasItem()) {
            var itemstack1 = slot.getItem();
            itemstack = itemstack1.copy();

            if (slotNumber < 4)
            {
                if (!this.moveItemStackTo(itemstack1, 4, 40, true))
                {
                    return ItemStack.EMPTY;
                }
                slot.onQuickCraft(itemstack1, itemstack);
            }
            else
            {
                if (!this.moveItemStackTo(itemstack1, 0, 4, false))
                {
                    return ItemStack.EMPTY;
                }
            }

            if (itemstack1.isEmpty())
            {
                slot.set(ItemStack.EMPTY);
            }
            else
            {
                slot.setChanged();
            }
            if (itemstack1.getCount() == itemstack.getCount())
            {
                return ItemStack.EMPTY;
            }
            slot.onTake(player, itemstack1);
        }
        return itemstack;
    }

    @Override
    public void slotsChanged(Container matrix)
    {
        var recipe = this.level.getRecipeManager().getRecipeFor(RecipeTypes.CATALYZER, matrix, this.level);

        if (recipe.isPresent())
        {
            var result = recipe.get().assemble(matrix);

            this.result.setItem(0, result);
        }
        else
        {
            this.result.setItem(0, ItemStack.EMPTY);
        }
        slotChangedCraftingGrid(this, this.level, this.player, this.matrix, this.result);
        //super.slotsChanged(matrix);
    }

    @Override
    public boolean stillValid(Player pPlayer)
    {
        return true;
    }

    private void addPlayerInventory(Inventory playerInventory)
    {
        for (int i = 0; i < 3; ++i)
        {
            for (int l = 0; l < 9; ++l)
            {
                this.addSlot(new Slot(playerInventory, l + i * 9 + 9, 8 + l * 18, 86 + i * 18));
            }
        }
    }

    public static void slotChangedCraftingGrid(AbstractContainerMenu menu, Level level, Player player, CraftingContainer craftingContainer, ResultContainer resultContainer)
    {
        if (!level.isClientSide)
        {
            ServerPlayer serverplayer = (ServerPlayer)player;
            ItemStack itemstack = ItemStack.EMPTY;
            Optional<ICatalyzerRecipe> optional = level.getServer().getRecipeManager().getRecipeFor(RecipeTypes.CATALYZER, craftingContainer, level);
            if (optional.isPresent())
            {
                ICatalyzerRecipe recipe = optional.get();
                if (resultContainer.setRecipeUsed(level, serverplayer, recipe))
                {
                    itemstack = recipe.assemble(craftingContainer);
                }
            }

            resultContainer.setItem(3, itemstack);
            menu.setRemoteSlot(3, itemstack);
            serverplayer.connection.send(new ClientboundContainerSetSlotPacket(menu.containerId, menu.incrementStateId(), 3, itemstack));
        }
    }
    private void addPlayerHotbar(Inventory playerInventory)
    {
        for (int i = 0; i < 9; ++i)
        {
            this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 144));
        }
    }
    public static CatalyzerMenu create(int windowId, Inventory playerInventory, FriendlyByteBuf friendlyByteBuf) {
        return new CatalyzerMenu(windowId, playerInventory);
    }
}