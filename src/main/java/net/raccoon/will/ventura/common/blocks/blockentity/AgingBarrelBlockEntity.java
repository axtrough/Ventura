package net.raccoon.will.ventura.common.blocks.blockentity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponentGetter;
import net.minecraft.core.component.DataComponentMap;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.ItemContainerContents;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import net.minecraft.world.ticks.ContainerSingleItem;
import net.raccoon.will.ventura.registry.VComponents;

import java.util.List;

import static net.raccoon.will.ventura.registry.VBlockEntities.AGING_BARREL_BE;

public class AgingBarrelBlockEntity extends BlockEntity implements ContainerSingleItem.BlockContainerSingleItem {
    private ItemStack barrelItem = ItemStack.EMPTY;
    private int agingTicks;

    public AgingBarrelBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(AGING_BARREL_BE.get(), blockPos, blockState);
    }

    public static void tick(Level level, BlockPos pos, BlockState state, AgingBarrelBlockEntity blockEntity) {
        if (level.isClientSide()) return;
        if (blockEntity.barrelItem.isEmpty()) return;

        blockEntity.agingTicks++;
        ItemStack stack = blockEntity.getTheItem();

        //update time_aged every 5 seconds
        if (blockEntity.agingTicks % 100 == 0) {
            stack.set(VComponents.TIME_AGED, blockEntity.agingTicks);
            blockEntity.setChanged();
        }
    }

    @Override
    protected void collectImplicitComponents(DataComponentMap.Builder components) {
        components.set(DataComponents.CONTAINER, ItemContainerContents.fromItems(List.of(this.barrelItem)));
    }

    @Override
    protected void applyImplicitComponents(DataComponentGetter components) {
        this.barrelItem = components.getOrDefault(DataComponents.CONTAINER, ItemContainerContents.EMPTY).copyOne();
    }

    @Override
    public BlockEntity getContainerBlockEntity() {
        return this;
    }

    @Override
    protected void saveAdditional(ValueOutput output) {
        super.saveAdditional(output);
        if (!this.getTheItem().isEmpty()) {
            output.store("item", ItemStack.CODEC, this.barrelItem);
        }
        output.putInt("AgingTicks", this.agingTicks);

    }

    @Override
    protected void loadAdditional(ValueInput input) {
        super.loadAdditional(input);
        this.barrelItem = input.read("item", ItemStack.CODEC).orElse(ItemStack.EMPTY);
        this.agingTicks = input.getIntOr("AgingTicks", 0);

        if (!barrelItem.isEmpty()) {
            this.agingTicks = barrelItem.getOrDefault(VComponents.TIME_AGED.get(), this.agingTicks);
        }
    }

    @Override
    public ItemStack getTheItem() {
        return this.barrelItem;
    }

    @Override
    public void setTheItem(ItemStack itemStack) {
        this.barrelItem = itemStack;
        if (!itemStack.isEmpty()) {
            this.agingTicks = itemStack.getOrDefault(VComponents.TIME_AGED.get(), 0);
        } else {
            this.agingTicks = 0;
        }
        this.setChanged();
    }
}
