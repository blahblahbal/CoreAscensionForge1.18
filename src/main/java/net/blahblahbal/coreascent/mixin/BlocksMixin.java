package net.blahblahbal.coreascent.mixin;

import net.minecraft.core.Registry;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Blocks.class)
public class BlocksMixin
{
    @Inject(method = "register", at = @At("HEAD"), cancellable = true)
    private static void registerCB(CallbackInfoReturnable<Block> cir)
    {
        /*Block blockIn = cir.getReturnValue();
        if(blockIn == Blocks.BEDROCK)
        {*/
            Block newBedrock = new Block(BlockBehaviour.Properties.of(Material.STONE).strength(5F, 200.0F));
            Registry.register(Registry.BLOCK, "bedrock", newBedrock);
            cir.setReturnValue(newBedrock);
        //}
    }
}
