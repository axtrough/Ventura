package net.raccoon.will.ventura.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.ItemTagsProvider;
import net.raccoon.will.ventura.Ventura;
import net.raccoon.will.ventura.registry.VItems;
import net.raccoon.will.ventura.registry.VTags;
import org.jspecify.annotations.NonNull;

import java.util.concurrent.CompletableFuture;

public class VItemTags extends ItemTagsProvider {
    public VItemTags(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, Ventura.MODID);
    }

    @Override
    protected void addTags(HolderLookup.@NonNull Provider provider) {
        tag(VTags.Items.AGEABLE_ITEMS)
                .add(VItems.AGEABLE_ITEM.get());

    }
}
