package me.fishbythefin.minecraftinfinite.item;

import me.fishbythefin.minecraftinfinite.MinecraftInfinite;
import me.fishbythefin.minecraftinfinite.item.custom.ChocolateMilkItem;
import me.fishbythefin.minecraftinfinite.item.custom.GeekBarItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MinecraftInfinite.MOD_ID);

    public static final RegistryObject<Item> CHOCOLATE_MILK = ITEMS.register("chocolate_milk", () -> new ChocolateMilkItem(new Item.Properties()));
    public static final RegistryObject<Item> GEEK_BAR = ITEMS.register("geek_bar", () -> new GeekBarItem(new Item.Properties()));

    public static void register(IEventBus bus) {
        ITEMS.register(bus);
    }
}
