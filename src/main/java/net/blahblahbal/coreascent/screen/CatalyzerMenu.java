package net.blahblahbal.coreascent.screen;

import net.blahblahbal.coreascent.block.ModBlocks;
import net.blahblahbal.coreascent.block.entity.CatalyzerBlockEntity;
import net.blahblahbal.coreascent.recipe.CatalyzerRecipe;
import net.blahblahbal.coreascent.screen.slot.CatalyzerReagentSlot;
import net.blahblahbal.coreascent.screen.slot.CatalyzerResultSlot;
import net.blahblahbal.coreascent.screen.slot.CatalyzerSulphurSlot;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.protocol.game.ClientboundContainerSetSlotPacket;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
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
    private static final ResultContainer resultContainer = new ResultContainer();;
    private static final SimpleContainer matrix = new SimpleContainer(4);
    private final Player player;
    private final CatalyzerBlockEntity blockEntity;

    public CatalyzerMenu(int windowId, Inventory inv, FriendlyByteBuf extraData)
    {
        this(windowId, inv, inv.player.level.getBlockEntity(extraData.readBlockPos()));
    }

    public CatalyzerMenu(int id, Inventory inv, BlockEntity entity)
    {
        super(ModMenuTypes.CATALYZER.get(), id);
        checkContainerSize(inv, 4);
        this.blockEntity = (CatalyzerBlockEntity)entity;
        this.level = inv.player.level;
        this.player = inv.player;

        this.blockEntity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY).ifPresent(handler ->
        {
            this.addSlot(new SlotItemHandler(handler, 0, 24, 20));
            this.addSlot(new CatalyzerSulphurSlot(handler, 1, 40, 46));
            this.addSlot(new CatalyzerReagentSlot(handler, 2, 56, 20));
            this.addSlot(new CatalyzerResultSlot(handler, this, matrix, inv, 3, 118, 35));
        });

        int i, j;
        for (i = 0; i < 3; i++)
        {
            for (j = 0; j < 9; j++)
            {
                this.addSlot(new Slot(inv, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }
        for (j = 0; j < 9; j++)
        {
            this.addSlot(new Slot(inv, j, 8 + j * 18, 142));
        }
        slotsChanged(matrix);
    }

    @Override
    public ItemStack quickMoveStack(Player player, int slotNumber)
    {
        var itemstack = ItemStack.EMPTY;
        var slot = this.slots.get(slotNumber);

        if (slot.hasItem())
        {
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

    /*@Override
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
    }*/
    @Override
    public void slotsChanged(Container pInventory)
    {
        var recipe = this.level.getRecipeManager().getRecipeFor(CatalyzerRecipe.Type.INSTANCE, matrix, this.level);
        if (recipe.isPresent())
        {
            var result = recipe.get().assemble(matrix);
            CatalyzerBlockEntity.craftItem(blockEntity);
            this.resultContainer.setItem(0, result);
        }
        else
        {
            this.resultContainer.setItem(0, ItemStack.EMPTY);
        }
        super.slotsChanged(matrix);
    }



    @Override
    public boolean stillValid(Player pPlayer)
    {
        return stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()),
                pPlayer, ModBlocks.CATALYZER.get());
    }

    public static void slotChangedCraftingGrid(Level level)
    {
        var recipe = level.getRecipeManager().getRecipeFor(CatalyzerRecipe.Type.INSTANCE, matrix, level);
        if (recipe.isPresent())
        {
            var result = recipe.get().assemble(matrix);
            //CatalyzerBlockEntity.craftItem(blockEntity);
            resultContainer.setItem(0, result);
        }
        else
        {
            resultContainer.setItem(0, ItemStack.EMPTY);
        }
        /*if (!level.isClientSide)
        {
            ServerPlayer serverplayer = (ServerPlayer)player;
            ItemStack itemstack = ItemStack.EMPTY;
            Optional<CatalyzerRecipe> optional = level.getServer().getRecipeManager().getRecipeFor(RecipeTypes.CATALYZER, craftingContainer, level);
            if (optional.isPresent())
            {
                CatalyzerRecipe recipe = optional.get();
                if (resultContainer.setRecipeUsed(level, serverplayer, recipe))
                {
                    itemstack = recipe.assemble(craftingContainer);
                }
            }

            resultContainer.setItem(3, itemstack);
            menu.setRemoteSlot(3, itemstack);
            serverplayer.connection.send(new ClientboundContainerSetSlotPacket(menu.containerId, menu.incrementStateId(), 3, itemstack));
        }*/
    }
}