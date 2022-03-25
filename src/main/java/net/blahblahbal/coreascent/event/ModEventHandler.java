package net.blahblahbal.coreascent.event;

import net.blahblahbal.coreascent.CoreAscension;
import net.blahblahbal.coreascent.item.ModItems;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = CoreAscension.MOD_ID)
public class ModEventHandler
{
    @SubscribeEvent
    public static void onBlockBreak(BlockEvent.BreakEvent event)
    {
        if (event.getPlayer().getInventory().getSelected() != null)
        {
            if (event.getState().getBlock() == Blocks.BEDROCK && event.getPlayer().getInventory().getSelected().getItem() != ModItems.BEDROCK_PICKAXE.get())
            {
                event.setCanceled(true);
            }
        }
    }
}
