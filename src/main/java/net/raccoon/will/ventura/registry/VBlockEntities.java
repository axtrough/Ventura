package net.raccoon.will.ventura.registry;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.raccoon.will.ventura.Ventura;
import net.raccoon.will.ventura.common.blocks.blockentity.AgingBarrelBlockEntity;

import java.util.function.Supplier;

public class VBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES = DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, Ventura.MODID);

//    public static final Supplier<BlockEntityType<TreeTapperBlockEntity>> TREE_TAPPER = BLOCK_ENTITY_TYPES.register("tree_tapper",
//            () -> new BlockEntityType<>(TreeTapperBlockEntity::new, VBlocks.TREE_TAPPER.get()));

    public static final Supplier<BlockEntityType<AgingBarrelBlockEntity>> AGING_BARREL_BE = BLOCK_ENTITY_TYPES.register("aging_barrel",
            () -> new BlockEntityType<>(AgingBarrelBlockEntity::new, VBlocks.AGING_BARREL.get()));


    public static void register(IEventBus eventBus) {
        BLOCK_ENTITY_TYPES.register(eventBus);
    }
}
