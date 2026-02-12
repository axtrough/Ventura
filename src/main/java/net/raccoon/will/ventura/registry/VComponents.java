package net.raccoon.will.ventura.registry;

import com.mojang.serialization.Codec;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.raccoon.will.ventura.Ventura;
import net.raccoon.will.ventura.common.data.AgeableItemData;

import java.util.function.Supplier;

public class VComponents {
    public static final DeferredRegister.DataComponents COMPONENTS = DeferredRegister.createDataComponents(Registries.DATA_COMPONENT_TYPE, Ventura.MODID);

    public static final Supplier<DataComponentType<AgeableItemData>> AGEABLE_ITEM_DATA = register("ageable_item_data"
            , AgeableItemData.CODEC, AgeableItemData.STREAM_CODEC);


    private static <T> Supplier<DataComponentType<T>> register(
            String name,
            Codec<T> codec,
            StreamCodec<? super RegistryFriendlyByteBuf, T> streamCodec
    ) {
        return COMPONENTS.register(name, () ->
                DataComponentType.<T>builder()
                        .persistent(codec)
                        .networkSynchronized(streamCodec)
                        .build()
        );
    }

    public static void register(IEventBus bus) {
        COMPONENTS.register(bus);
    }
}