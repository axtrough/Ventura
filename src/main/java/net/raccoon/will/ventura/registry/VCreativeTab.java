package net.raccoon.will.ventura.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.raccoon.will.ventura.Ventura;

import java.util.function.Supplier;

public class VCreativeTab {
    public static DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Ventura.MODID);

    public static final Supplier<CreativeModeTab> VENTURA_TAB = CREATIVE_MODE_TAB.register("ventura_tab", () -> CreativeModeTab.builder()
            .icon(() -> new ItemStack(ItemStack.EMPTY.getItem()))
            .title(Component.translatable("itemGroup.ventura_tab"))
            .displayItems((parameters, output) -> {
                output.accept(VBlocks.AGING_BARREL);
                output.accept(VItems.AGEABLE_ITEM);

                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}