package net.raccoon.will.ventura.registry;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.raccoon.will.ventura.Ventura;

import java.util.function.Supplier;

public class VSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(BuiltInRegistries.SOUND_EVENT, Ventura.MODID);

    public static Supplier<SoundEvent> CORK_PULLED = registerSoundEvent("cork_pulled");
    public static Supplier<SoundEvent> TAP_ADDED = registerSoundEvent("tap_added");

    private static Supplier<SoundEvent> registerSoundEvent(String name) {
        Identifier id = Ventura.resLoc(name);
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(id));
    }

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}
