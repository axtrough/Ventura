package net.raccoon.will.ventura;


import com.mojang.logging.LogUtils;
import net.minecraft.resources.Identifier;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.raccoon.will.ventura.registry.*;
import org.slf4j.Logger;

@Mod(Ventura.MODID)
public class Ventura {
    public static final String MODID = "ventura";
    private static final Logger LOGGER = LogUtils.getLogger();

    public static Identifier resLoc(String name) {
        return Identifier.fromNamespaceAndPath(Ventura.MODID, name);
    }

    public Ventura(IEventBus modEventBus, ModContainer modContainer) {
        VBlockEntities.register(modEventBus);
        VCreativeTab.register(modEventBus);
        VComponents.register(modEventBus);
        VBlocks.register(modEventBus);
        VSounds.register(modEventBus);
        VItems.register(modEventBus);

    }
}
