package net.blahblahbal.coreascent.screen;

import net.blahblahbal.coreascent.api.crafting.ICatalyzerRecipe;
import net.blahblahbal.coreascent.api.crafting.RecipeTypes;
import net.blahblahbal.coreascent.block.entity.CatalyzerBlockEntity;
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
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.SlotItemHandler;

import java.util.Optional;

public class CatalyzerMenu extends AbstractContainerMenu
{
    private final Level level;
    private final ResultContainer result;
    private final CraftingContainer matrix = new CraftingContainer(this, 4, 1);
    private final Player player;
    private final CatalyzerBlockEntity blockEntity;
    //private final ContainerData data;

    public CatalyzerMenu(int windowId, Inventory inv, FriendlyByteBuf extraData) {
        this(windowId, inv, inv.player.level.getBlockEntity(extraData.readBlockPos()));
    }

    public CatalyzerMenu(int id, Inventory inv, BlockEntity entity)
    {
        super(ModMenuTypes.CATALYZER.get(), id);
        checkContainerSize(inv, 4);
        this.blockEntity = (CatalyzerBlockEntity)entity;
        this.level = inv.player.level;
        this.result = new ResultContainer();
        this.player = inv.player;

        this.blockEntity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY).ifPresent(handler -> {
            this.addSlot(new SlotItemHandler(handler, 0, 23, 18));
            this.addSlot(new CatalyzerSulphurSlot(handler, 1, 39, 44));
            this.addSlot(new CatalyzerReagentSlot(handler, 2, 55, 18));
            this.addSlot(new CatalyzerResultSlot(handler, this, matrix, inv, 3, 117, 30));
        });

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
}