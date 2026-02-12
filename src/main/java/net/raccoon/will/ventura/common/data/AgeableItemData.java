package net.raccoon.will.ventura.common.data;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;

public record AgeableItemData(int ticks_aged) {

    public static final Codec<AgeableItemData> CODEC = RecordCodecBuilder.create(instance ->
            instance.group(
                    Codec.INT.fieldOf("ticks_aged").forGetter(AgeableItemData::ticks_aged)
            ).apply(instance, AgeableItemData::new));

    public static final StreamCodec<ByteBuf, AgeableItemData> STREAM_CODEC = ByteBufCodecs.fromCodec(CODEC);
}