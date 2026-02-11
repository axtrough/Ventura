package net.raccoon.will.ventura.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.raccoon.will.ventura.Ventura;
import net.raccoon.will.ventura.common.blocks.AgingBarrelBlock;

import static net.raccoon.will.ventura.util.RegistryUtil.registerBlock;


public class VBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Ventura.MODID);



//    public static final DeferredBlock<Block> TREE_TAPPER = registerBlock("tree_tapper", registryName ->
//            new TreeTapperBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(ResourceKey.create(Registries.BLOCK, registryName))));

    public static final DeferredBlock<Block> AGING_BARREL = registerBlock("aging_barrel", registryName ->
            new AgingBarrelBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(ResourceKey.create(Registries.BLOCK, registryName))));



    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
