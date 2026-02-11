package net.raccoon.will.ventura.registry;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.raccoon.will.ventura.Ventura;
import net.raccoon.will.ventura.common.items.AgeableItem;

public class VItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Ventura.MODID);

    public static final DeferredItem<Item> AGEABLE_ITEM = ITEMS.registerItem("ageable_item", AgeableItem::new, Item.Properties::new);

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}