package net.blahblahbal.coreascent.block.entity;

import net.blahblahbal.coreascent.CoreAscension;
import net.blahblahbal.coreascent.block.ModBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, CoreAscension.MOD_ID);

    public static final RegistryObject<BlockEntityType<CatalyzerBlockEntity>> CATALYZER =
            BLOCK_ENTITIES.register("catalyzer", () ->
                    BlockEntityType.Builder.of(CatalyzerBlockEntity::new,
                            ModBlocks.CATALYZER.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}