package net.raccoon.will.ventura.common.items;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.raccoon.will.ventura.common.data.AgeableItemData;
import net.raccoon.will.ventura.registry.VComponents;

import java.util.function.Consumer;

@SuppressWarnings("deprecated")
public class AgeableItem extends Item {

    public AgeableItem(Properties properties) {
        super(properties.stacksTo(1));
    }

    @Override
    public void appendHoverText(ItemStack itemStack, TooltipContext context, TooltipDisplay display, Consumer<Component> builder, TooltipFlag tooltipFlag) {
        super.appendHoverText(itemStack, context, display, builder, tooltipFlag);
        int ticks = getAgeTime(itemStack);
        if (ticks > 0) {
            double days = ticks / 24000.0;
            String formatted = String.format("%.2f", days);
            builder.accept(Component.literal("Time Aged: " + formatted + "d").withStyle(ChatFormatting.GRAY));

            if (days >= 1) {
                builder.accept(Component.literal("Young Aged").withStyle(ChatFormatting.WHITE));
            }
        }
    }

    public static int getAgeTime(ItemStack stack) {
        AgeableItemData data = stack.get(VComponents.AGEABLE_ITEM_DATA.get());
        return data != null ? data.ticks_aged() : 0;
    }

    public static void setAgeTime(ItemStack stack, int value) {
        AgeableItemData data = new AgeableItemData(value);
        stack.set(VComponents.AGEABLE_ITEM_DATA.get(), data);
    }
}


