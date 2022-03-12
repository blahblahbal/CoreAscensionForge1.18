package net.blahblahbal.coreascent.block;

import net.blahblahbal.coreascent.CoreAscension;
import net.blahblahbal.coreascent.item.ModCreativeModeTab;
import net.blahblahbal.coreascent.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.OreBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks
{
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, CoreAscension.MOD_ID);

    public static final RegistryObject<Block> SULPHUR_BLOCK = registerBlock("sulphur_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(5f).requiresCorrectToolForDrops()), ModCreativeModeTab.BLOCK_TAB);

    public static final RegistryObject<Block> SULPHUR_ORE = registerBlock("sulphur_ore",
            () -> new OreBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(4f).requiresCorrectToolForDrops(), UniformInt.of(15, 20)),
                    ModCreativeModeTab.BLOCK_TAB);
    //gem ore blocks
    public static final RegistryObject<Block> RUBY_ORE = registerBlock("ruby_ore",
            () -> new OreBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(4f).requiresCorrectToolForDrops(), UniformInt.of(2, 6)),
            ModCreativeModeTab.BLOCK_TAB);
    public static final RegistryObject<Block> CITRINE_ORE = registerBlock("citrine_ore",
            () -> new OreBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(4f).requiresCorrectToolForDrops(), UniformInt.of(2, 6)),
            ModCreativeModeTab.BLOCK_TAB);
    public static final RegistryObject<Block> TOPAZ_ORE = registerBlock("topaz_ore",
            () -> new OreBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(4f).requiresCorrectToolForDrops(), UniformInt.of(2, 6)),
            ModCreativeModeTab.BLOCK_TAB);
    public static final RegistryObject<Block> SAPPHIRE_ORE = registerBlock("sapphire_ore",
            () -> new OreBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(4f).requiresCorrectToolForDrops(), UniformInt.of(2, 6)),
            ModCreativeModeTab.BLOCK_TAB);
    public static final RegistryObject<Block> TANZANITE_ORE = registerBlock("tanzanite_ore",
            () -> new OreBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(4f).requiresCorrectToolForDrops(), UniformInt.of(2, 6)),
            ModCreativeModeTab.BLOCK_TAB);
    //end gem ores
    //gem blocks
    public static final RegistryObject<Block> RUBY_BLOCK = registerBlock("ruby_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_RED)
                    .strength(4f).requiresCorrectToolForDrops()), ModCreativeModeTab.BLOCK_TAB);
    public static final RegistryObject<Block> CITRINE_BLOCK = registerBlock("citrine_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_ORANGE)
                    .strength(4f).requiresCorrectToolForDrops()), ModCreativeModeTab.BLOCK_TAB);
    public static final RegistryObject<Block> TOPAZ_BLOCK = registerBlock("topaz_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_YELLOW)
                    .strength(4f).requiresCorrectToolForDrops()), ModCreativeModeTab.BLOCK_TAB);
    public static final RegistryObject<Block> SAPPHIRE_BLOCK = registerBlock("sapphire_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_BLUE)
                    .strength(4f).requiresCorrectToolForDrops()), ModCreativeModeTab.BLOCK_TAB);
    public static final RegistryObject<Block> TANZANITE_BLOCK = registerBlock("tanzanite_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_PURPLE)
                    .strength(4f).requiresCorrectToolForDrops()), ModCreativeModeTab.BLOCK_TAB);
    //end gem blocks
    public static final RegistryObject<Block> TADANITE_CRYSTAL_BLOCK = registerBlock("tadanite_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(5f).requiresCorrectToolForDrops()), ModCreativeModeTab.BLOCK_TAB);

    public static final RegistryObject<Block> MASHED_POTATO_BLOCK = registerBlock("mashed_potato_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.CLOTH_DECORATION, MaterialColor.SAND)
                    .strength(0.75f)), ModCreativeModeTab.BLOCK_TAB);
    public static final RegistryObject<Block> CARROT_BLOCK = registerBlock("carrot_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.CLOTH_DECORATION, MaterialColor.COLOR_ORANGE)
                    .strength(0.75f)), ModCreativeModeTab.BLOCK_TAB);



    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab)
    {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab)
    {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
