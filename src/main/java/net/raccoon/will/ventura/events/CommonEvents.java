package net.raccoon.will.ventura.events;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.RegisterCommandsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.neoforged.neoforge.registries.NewRegistryEvent;
import net.raccoon.will.ventura.Ventura;

@EventBusSubscriber(modid = Ventura.MODID)
public class CommonEvents {

    @SubscribeEvent
    public static void registerRegistries(NewRegistryEvent event) {

    }

    @SubscribeEvent
    public static void onServerStarting(ServerStartingEvent event) {

    }

    @SubscribeEvent
    public static void onRegisterCommands(RegisterCommandsEvent event) {

    }

}

