package net.blahblahbal.coreascent.item;

import net.blahblahbal.coreascent.CoreAscension;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems
{
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, CoreAscension.MOD_ID);

    // tadanite tools
    public static final RegistryObject<Item> TADANITE_PICKAXE = ITEMS.register("tadanite_pickaxe",
            () -> new PickaxeItem(ModTiers.TADANITE, 2, -2.8f,
                    new Item.Properties().tab(ModCreativeModeTab.ITEM_TAB)));
    public static final RegistryObject<Item> TADANITE_AXE = ITEMS.register("tadanite_axe",
            () -> new AxeItem(ModTiers.TADANITE, 5, -3f,
                    new Item.Properties().tab(ModCreativeModeTab.ITEM_TAB)));
    public static final RegistryObject<Item> TADANITE_SHOVEL = ITEMS.register("tadanite_shovel",
            () -> new ShovelItem(ModTiers.TADANITE, 1.5f, -3f,
                    new Item.Properties().tab(ModCreativeModeTab.ITEM_TAB)));
    public static final RegistryObject<Item> TADANITE_HOE = ITEMS.register("tadanite_hoe",
            () -> new HoeItem(ModTiers.TADANITE, -4, 0f,
                    new Item.Properties().tab(ModCreativeModeTab.ITEM_TAB)));
    public static final RegistryObject<Item> TADANITE_SWORD = ITEMS.register("tadanite_sword",
            () -> new SwordItem(ModTiers.TADANITE, 5, -2.4f,
                    new Item.Properties().tab(ModCreativeModeTab.ITEM_TAB)));
    // end tadanite tools

    public static final RegistryObject<Item> RUBY = ITEMS.register("ruby",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.ITEM_TAB)));
    public static final RegistryObject<Item> CITRINE = ITEMS.register("citrine",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.ITEM_TAB)));
    public static final RegistryObject<Item> TOPAZ = ITEMS.register("topaz",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.ITEM_TAB)));
    public static final RegistryObject<Item> SAPPHIRE = ITEMS.register("sapphire",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.ITEM_TAB)));
    public static final RegistryObject<Item> TANZANITE = ITEMS.register("tanzanite",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.ITEM_TAB)));
    public static final RegistryObject<Item> SULPHUR = ITEMS.register("sulphur",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.ITEM_TAB)));
    public static final RegistryObject<Item> TADANITE_CRYSTAL = ITEMS.register("tadanite_crystal",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.ITEM_TAB)));
    public static final RegistryObject<Item> TADANITE_DIAMOND = ITEMS.register("tadanite_diamond",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.ITEM_TAB)));
    public static final RegistryObject<Item> LUMITE_INGOT = ITEMS.register("lumite_ingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.ITEM_TAB)));

    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }
}
