package net.blahblahbal.coreascent.block;

import net.blahblahbal.coreascent.CoreAscension;
import net.blahblahbal.coreascent.block.custom.CatalyzerBlock;
import net.blahblahbal.coreascent.item.ModCreativeModeTab;
import net.blahblahbal.coreascent.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
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

    public static final RegistryObject<Block> CATALYZER = registerBlock("catalyzer",
            () -> new CatalyzerBlock(BlockBehaviour.Properties.of(Material.STONE).strength(3f, 6f)
                    .requiresCorrectToolForDrops().noOcclusion()),
            ModCreativeModeTab.BLOCK_TAB);

    public static final RegistryObject<Block> SULPHUR_BLOCK = registerBlock("sulphur_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(5f, 6f).requiresCorrectToolForDrops().sound(SoundType.METAL)), ModCreativeModeTab.BLOCK_TAB);
    public static final RegistryObject<Block> LIMESTONE_BLOCK = registerBlock("limestone_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(5f, 6f).requiresCorrectToolForDrops().sound(SoundType.STONE)), ModCreativeModeTab.BLOCK_TAB);
    public static final RegistryObject<Block> CEMENT = registerBlock("cement",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1f, 10f).requiresCorrectToolForDrops().sound(SoundType.STONE)), ModCreativeModeTab.BLOCK_TAB);
    public static final RegistryObject<Block> BLAZE_BRICK = registerBlock("blaze_brick",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(10f, 50f).requiresCorrectToolForDrops()), ModCreativeModeTab.BLOCK_TAB);
    public static final RegistryObject<Block> ENDER_PEARL_BRICKS = registerBlock("ender_pearl_bricks",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(2f, 3f).requiresCorrectToolForDrops().sound(SoundType.GLASS)), ModCreativeModeTab.BLOCK_TAB);
    // doors/trapdoors
    public static final RegistryObject<Block> COBBLESTONE_DOOR = registerBlock("cobblestone_door",
            () -> new DoorBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(4, 4).noOcclusion()), ModCreativeModeTab.BLOCK_TAB);
    public static final RegistryObject<Block> COBBLESTONE_TRAPDOOR = registerBlock("cobblestone_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(2, 3).noOcclusion()), ModCreativeModeTab.BLOCK_TAB);
    public static final RegistryObject<Block> DIAMOND_DOOR = registerBlock("diamond_door",
            () -> new DoorBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(5, 5).noOcclusion().sound(SoundType.METAL)), ModCreativeModeTab.BLOCK_TAB);
    public static final RegistryObject<Block> DIAMOND_TRAPDOOR = registerBlock("diamond_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(2, 3).noOcclusion().sound(SoundType.METAL)), ModCreativeModeTab.BLOCK_TAB);
    public static final RegistryObject<Block> GOLD_DOOR = registerBlock("gold_door",
            () -> new DoorBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(5, 5).noOcclusion().sound(SoundType.METAL)), ModCreativeModeTab.BLOCK_TAB);
    public static final RegistryObject<Block> GOLD_TRAPDOOR = registerBlock("gold_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(2, 3).noOcclusion().sound(SoundType.METAL)), ModCreativeModeTab.BLOCK_TAB);
    public static final RegistryObject<Block> GLASS_DOOR = registerBlock("glass_door",
            () -> new DoorBlock(BlockBehaviour.Properties.of(Material.GLASS)
                    .strength(4, 4).noOcclusion().sound(SoundType.GLASS)), ModCreativeModeTab.BLOCK_TAB);
    public static final RegistryObject<Block> GLASS_TRAPDOOR = registerBlock("glass_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.of(Material.GLASS)
                    .strength(2, 3).noOcclusion().sound(SoundType.GLASS)), ModCreativeModeTab.BLOCK_TAB);
    //end doors/trapdoors

    // stone variant stuff
    public static final RegistryObject<Block> IGNEOUS_ROCK = registerBlock("igneous_rock",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1.5f, 6f).requiresCorrectToolForDrops()),
            ModCreativeModeTab.BLOCK_TAB);
    public static final RegistryObject<Block> MAGNETITE = registerBlock("magnetite",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1.5f, 6f).requiresCorrectToolForDrops()),
            ModCreativeModeTab.BLOCK_TAB);
    public static final RegistryObject<Block> SALTROCK = registerBlock("saltrock",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1.5f, 6f).requiresCorrectToolForDrops()),
            ModCreativeModeTab.BLOCK_TAB);
    public static final RegistryObject<Block> HARDENED_LAVA = registerBlock("hardened_lava",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1f, 10f).requiresCorrectToolForDrops()),
            ModCreativeModeTab.BLOCK_TAB);

    public static final RegistryObject<Block> POLISHED_IGNEOUS_ROCK = registerBlock("polished_igneous_rock",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1.5f, 6f).requiresCorrectToolForDrops()),
            ModCreativeModeTab.BLOCK_TAB);
    public static final RegistryObject<Block> POLISHED_MAGNETITE = registerBlock("polished_magnetite",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1.5f, 6f).requiresCorrectToolForDrops()),
            ModCreativeModeTab.BLOCK_TAB);
    public static final RegistryObject<Block> POLISHED_SALTROCK = registerBlock("polished_saltrock",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1.5f, 6f).requiresCorrectToolForDrops()),
            ModCreativeModeTab.BLOCK_TAB);

    public static final RegistryObject<Block> IGNEOUS_ROCK_TILE = registerBlock("igneous_rock_tile",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1.5f, 6f).requiresCorrectToolForDrops()),
            ModCreativeModeTab.BLOCK_TAB);
    public static final RegistryObject<Block> MAGNETITE_TILE = registerBlock("magnetite_tile",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1.5f, 6f).requiresCorrectToolForDrops()),
            ModCreativeModeTab.BLOCK_TAB);
    public static final RegistryObject<Block> SALTROCK_TILE = registerBlock("saltrock_tile",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1.5f, 6f).requiresCorrectToolForDrops()),
            ModCreativeModeTab.BLOCK_TAB);

    public static final RegistryObject<Block> ANDESITE_TILE = registerBlock("andesite_tile",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1.5f, 6f).requiresCorrectToolForDrops()),
            ModCreativeModeTab.BLOCK_TAB);
    public static final RegistryObject<Block> DIORITE_TILE = registerBlock("diorite_tile",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1.5f, 6f).requiresCorrectToolForDrops()),
            ModCreativeModeTab.BLOCK_TAB);
    public static final RegistryObject<Block> GRANITE_TILE = registerBlock("granite_tile",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1.5f, 6f).requiresCorrectToolForDrops()),
            ModCreativeModeTab.BLOCK_TAB);
    // end stone variant stuff

    //cactus stuff
    public static final RegistryObject<Block> CACTUS_DOOR = registerBlock("cactus_door",
            () -> new DoorBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(3, 3).noOcclusion().sound(SoundType.WOOD)), ModCreativeModeTab.BLOCK_TAB);

    public static final RegistryObject<Block> CACTUS_TRAPDOOR = registerBlock("cactus_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(3, 3).noOcclusion().sound(SoundType.WOOD)), ModCreativeModeTab.BLOCK_TAB);

    public static final RegistryObject<Block> CACTUS_PLANKS = registerBlock("cactus_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))
            {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face)
                {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face)
                {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face)
                {
                    return 5;
                }
            }, ModCreativeModeTab.BLOCK_TAB);
    //end cactus stuff

    // tropics stuff



    public static final RegistryObject<Block> FLINT_BLOCK = registerBlock("flint_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(5, 6).requiresCorrectToolForDrops().sound(SoundType.METAL)), ModCreativeModeTab.BLOCK_TAB);
    public static final RegistryObject<Block> COMPACT_STONE = registerBlock("compact_stone",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1, 5).requiresCorrectToolForDrops()), ModCreativeModeTab.BLOCK_TAB);
    public static final RegistryObject<Block> COMPRESSED_OBSIDIAN = registerBlock("compressed_obsidian",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(5, 1000).requiresCorrectToolForDrops()), ModCreativeModeTab.BLOCK_TAB);

    public static final RegistryObject<Block> SULPHUR_ORE = registerBlock("sulphur_ore",
            () -> new OreBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1.25f, 10).requiresCorrectToolForDrops().sound(SoundType.NETHER_ORE), UniformInt.of(15, 20)),
                    ModCreativeModeTab.BLOCK_TAB);
    public static final RegistryObject<Block> LIMESTONE_ORE = registerBlock("limestone_ore",
            () -> new OreBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(2, 6).requiresCorrectToolForDrops(), UniformInt.of(2, 4)),
            ModCreativeModeTab.BLOCK_TAB);
    //gem ore blocks
    public static final RegistryObject<Block> RUBY_ORE = registerBlock("ruby_ore",
            () -> new OreBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(3, 3).requiresCorrectToolForDrops(), UniformInt.of(2, 6)),
            ModCreativeModeTab.BLOCK_TAB);
    public static final RegistryObject<Block> CITRINE_ORE = registerBlock("citrine_ore",
            () -> new OreBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(3, 3).requiresCorrectToolForDrops(), UniformInt.of(2, 6)),
            ModCreativeModeTab.BLOCK_TAB);
    public static final RegistryObject<Block> TOPAZ_ORE = registerBlock("topaz_ore",
            () -> new OreBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(3, 3).requiresCorrectToolForDrops(), UniformInt.of(2, 6)),
            ModCreativeModeTab.BLOCK_TAB);
    public static final RegistryObject<Block> SAPPHIRE_ORE = registerBlock("sapphire_ore",
            () -> new OreBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(3, 3).requiresCorrectToolForDrops(), UniformInt.of(2, 6)),
            ModCreativeModeTab.BLOCK_TAB);
    public static final RegistryObject<Block> TANZANITE_ORE = registerBlock("tanzanite_ore",
            () -> new OreBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(3, 3).requiresCorrectToolForDrops(), UniformInt.of(2, 6)),
            ModCreativeModeTab.BLOCK_TAB);
    //end gem ores
    //gem blocks
    public static final RegistryObject<Block> RUBY_BLOCK = registerBlock("ruby_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_RED)
                    .strength(5, 6).requiresCorrectToolForDrops().sound(SoundType.METAL)), ModCreativeModeTab.BLOCK_TAB);
    public static final RegistryObject<Block> CITRINE_BLOCK = registerBlock("citrine_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_ORANGE)
                    .strength(5, 6).requiresCorrectToolForDrops().sound(SoundType.METAL)), ModCreativeModeTab.BLOCK_TAB);
    public static final RegistryObject<Block> TOPAZ_BLOCK = registerBlock("topaz_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_YELLOW)
                    .strength(5, 6).requiresCorrectToolForDrops().sound(SoundType.METAL)), ModCreativeModeTab.BLOCK_TAB);
    public static final RegistryObject<Block> SAPPHIRE_BLOCK = registerBlock("sapphire_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_BLUE)
                    .strength(5, 6).requiresCorrectToolForDrops().sound(SoundType.METAL)), ModCreativeModeTab.BLOCK_TAB);
    public static final RegistryObject<Block> TANZANITE_BLOCK = registerBlock("tanzanite_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_PURPLE)
                    .strength(5, 6).requiresCorrectToolForDrops().sound(SoundType.METAL)), ModCreativeModeTab.BLOCK_TAB);
    //end gem blocks
    public static final RegistryObject<Block> TADANITE_CRYSTAL_BLOCK = registerBlock("tadanite_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(10, 2000).requiresCorrectToolForDrops()), ModCreativeModeTab.BLOCK_TAB);

    public static final RegistryObject<Block> MASHED_POTATO_BLOCK = registerBlock("mashed_potato_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.CLOTH_DECORATION, MaterialColor.SAND)
                    .strength(0.8f, 0.8f).sound(SoundType.WOOL)), ModCreativeModeTab.BLOCK_TAB);
    public static final RegistryObject<Block> CARROT_BLOCK = registerBlock("carrot_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.CLOTH_DECORATION, MaterialColor.COLOR_ORANGE)
                    .strength(0.8f, 0.9f).sound(SoundType.WOOL)), ModCreativeModeTab.BLOCK_TAB);



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
