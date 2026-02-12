package net.raccoon.will.ventura.datagen;

import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.raccoon.will.ventura.Ventura;

import java.util.List;
import java.util.Set;

@EventBusSubscriber(modid = Ventura.MODID)
public class Datagen {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent.Client event) {
        event.createProvider(VModels::new);
        event.createProvider(VItemTags::new);

        event.createProvider(VBlockTags::new);
        event.createProvider((VRecipes.Runner::new));

        event.createProvider((output, lookupProvider) -> new LootTableProvider(output, Set.of(), List.of(
                new LootTableProvider.SubProviderEntry(
                        VBlockLoot.VBlockSub::new,
                        LootContextParamSets.BLOCK
/*                 ),
               new LootTableProvider.SubProviderEntry(
                        BEntityLoot.VEntitySub::new,
                        LootContextParamSets.ENTITY

 */
                )), lookupProvider
        ));
    }
}