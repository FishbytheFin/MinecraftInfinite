package me.fishbythefin.minecraftinfinite.item;

import me.fishbythefin.minecraftinfinite.MinecraftInfinite;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.rmi.registry.Registry;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MinecraftInfinite.MOD_ID);

    public static final RegistryObject<CreativeModeTab> MINECRAFT_INFINITE_TAB = CREATIVE_MODE_TABS.register("minecraft_infinite_tab",
            () -> CreativeModeTab.builder()
                    .icon( () -> new ItemStack(ModItems.CHOCOLATE_MILK.get()))
                    .title(Component.translatable("creativetab.minecraftinfinite.minecraft_infinite_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.CHOCOLATE_MILK.get());
                        output.accept(ModItems.GEEK_BAR.get());
                    })
                    .build());

    public static void register(IEventBus bus) {
        CREATIVE_MODE_TABS.register(bus);
    }
}
