package net.raccoon.will.ventura.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.raccoon.will.ventura.Ventura;

import java.util.concurrent.CompletableFuture;

public class VBlockTags extends BlockTagsProvider {
    public VBlockTags(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, Ventura.MODID);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {

    }
}
