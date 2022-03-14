package net.blahblahbal.coreascent.screen;

import net.blahblahbal.coreascent.CoreAscension;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.network.IContainerFactory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModMenuTypes {
    public static final DeferredRegister<MenuType<?>> MENUS =
            DeferredRegister.create(ForgeRegistries.CONTAINERS, CoreAscension.MOD_ID);


    public static final RegistryObject<MenuType<CatalyzerMenu>> CATALYZER =
            register("catalyzer", () -> new MenuType<>((IContainerFactory<CatalyzerMenu>)
                    CatalyzerMenu::create));

    @OnlyIn(Dist.CLIENT)
    public static void onClientSetup() {
        CATALYZER.ifPresent(container -> MenuScreens.register(container, CatalyzerScreen::new));
    }

    public static void register(IEventBus eventBus) {
        MENUS.register(eventBus);
    }

    private static <T extends AbstractContainerMenu> RegistryObject<MenuType<T>> register(String name, Supplier<? extends MenuType<T>> container) {
        return MENUS.register(name, container);
    }
}