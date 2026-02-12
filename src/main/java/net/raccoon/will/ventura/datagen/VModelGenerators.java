package net.raccoon.will.ventura.datagen;

import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.MultiVariant;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.blockstates.PropertyDispatch;
import net.minecraft.client.data.models.model.ModelLocationUtils;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

import static net.minecraft.client.data.models.BlockModelGenerators.*;
import static net.raccoon.will.ventura.common.blocks.AgingBarrelBlock.TAPPED;

public class VModelGenerators {

    public void createBarrel(BlockModelGenerators blockModels, Block block) {
        MultiVariant normal = plainVariant(ModelLocationUtils.getModelLocation(block));
        MultiVariant tapped = plainVariant(ModelLocationUtils.getModelLocation(block, "_tapped"));

        blockModels.blockStateOutput.accept(MultiVariantGenerator.dispatch(block)
                .with(createBooleanModelDispatch(TAPPED, tapped, normal))
                .with(PropertyDispatch.modify(BlockStateProperties.HORIZONTAL_FACING)
                        .select(Direction.NORTH, NOP)
                        .select(Direction.EAST, Y_ROT_90)
                        .select(Direction.SOUTH, Y_ROT_180)
                        .select(Direction.WEST, Y_ROT_270)
                )
        );
    }
}