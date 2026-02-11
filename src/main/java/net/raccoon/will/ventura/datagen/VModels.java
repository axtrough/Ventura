package net.raccoon.will.ventura.datagen;

import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.data.PackOutput;
import net.raccoon.will.ventura.Ventura;
import net.raccoon.will.ventura.registry.VBlocks;
import net.raccoon.will.ventura.registry.VItems;
import org.jetbrains.annotations.NotNull;

public class VModels extends ModelProvider {
    VModelGenerators venturaModels = new VModelGenerators();

    public VModels(PackOutput output) {
        super(output, Ventura.MODID);
    }

    @Override
    protected void registerModels(@NotNull BlockModelGenerators blockModels, @NotNull ItemModelGenerators itemModels) {
        itemModels.generateFlatItem(VItems.AGEABLE_ITEM.get(), ModelTemplates.FLAT_ITEM);
        venturaModels.createBarrel(blockModels, VBlocks.AGING_BARREL.get());
    }
}