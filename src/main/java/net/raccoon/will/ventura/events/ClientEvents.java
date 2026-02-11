package net.raccoon.will.ventura.events;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;
import net.raccoon.will.ventura.Ventura;

@EventBusSubscriber(modid = Ventura.MODID, value = Dist.CLIENT)
public class ClientEvents {

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {

    }

    @SubscribeEvent
    public static void registerBE(EntityRenderersEvent.RegisterRenderers event) {

    }

    @SubscribeEvent
    public static void registerParticleFactory(RegisterParticleProvidersEvent event) {

    }

    @SubscribeEvent
    public static void onClientTick(ClientTickEvent.Post event) {

    }
}