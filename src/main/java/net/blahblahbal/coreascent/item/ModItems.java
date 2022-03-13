package net.blahblahbal.coreascent.item;

import net.blahblahbal.coreascent.CoreAscension;
import net.blahblahbal.coreascent.item.custom.LumiteSwordItem;
import net.blahblahbal.coreascent.item.custom.OsborgnenFuelItem;
import net.blahblahbal.coreascent.item.custom.TadaniteArmorItem;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems
{
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, CoreAscension.MOD_ID);

    // lumite tools
    public static final RegistryObject<Item> LUMITE_PICKAXE = ITEMS.register("lumite_pickaxe",
            () -> new PickaxeItem(ModTiers.LUMITE, 2, -2.8f,
                    new Item.Properties().tab(ModCreativeModeTab.ITEM_TAB)));
    public static final RegistryObject<Item> LUMITE_AXE = ITEMS.register("lumite_axe",
            () -> new AxeItem(ModTiers.LUMITE, 5, -3f,
                    new Item.Properties().tab(ModCreativeModeTab.ITEM_TAB)));
    public static final RegistryObject<Item> LUMITE_SHOVEL = ITEMS.register("lumite_shovel",
            () -> new ShovelItem(ModTiers.LUMITE, 1.5f, -3f,
                    new Item.Properties().tab(ModCreativeModeTab.ITEM_TAB)));
    public static final RegistryObject<Item> LUMITE_HOE = ITEMS.register("lumite_hoe",
            () -> new HoeItem(ModTiers.LUMITE, -4, 0f,
                    new Item.Properties().tab(ModCreativeModeTab.ITEM_TAB)));
    public static final RegistryObject<Item> LUMITE_SWORD = ITEMS.register("lumite_sword",
            () -> new LumiteSwordItem(ModTiers.LUMITE, 5, -2.4f,
                    new Item.Properties().tab(ModCreativeModeTab.ITEM_TAB)));
    // end lumite tools

    // tadanite
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
    // armor

    public static final RegistryObject<Item> TADANITE_HELMET = ITEMS.register("tadanite_helmet",
            () -> new TadaniteArmorItem(ModArmorMaterials.TADANITE, EquipmentSlot.HEAD,
                    new Item.Properties().tab(ModCreativeModeTab.ITEM_TAB)));
    public static final RegistryObject<Item> TADANITE_CHESTPLATE = ITEMS.register("tadanite_chestplate",
            () -> new TadaniteArmorItem(ModArmorMaterials.TADANITE, EquipmentSlot.CHEST,
                    new Item.Properties().tab(ModCreativeModeTab.ITEM_TAB)));
    public static final RegistryObject<Item> TADANITE_LEGGINGS = ITEMS.register("tadanite_leggings",
            () -> new TadaniteArmorItem(ModArmorMaterials.TADANITE, EquipmentSlot.LEGS,
                    new Item.Properties().tab(ModCreativeModeTab.ITEM_TAB)));
    public static final RegistryObject<Item> TADANITE_BOOTS = ITEMS.register("tadanite_boots",
            () -> new TadaniteArmorItem(ModArmorMaterials.TADANITE, EquipmentSlot.FEET,
                    new Item.Properties().tab(ModCreativeModeTab.ITEM_TAB)));

    // end tadanite

    // gems
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

    // end gems

    public static final RegistryObject<Item> OSBORGNEN_FUEL = ITEMS.register("osborgnen_fuel",
            () -> new OsborgnenFuelItem(new Item.Properties().tab(ModCreativeModeTab.ITEM_TAB)));
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
