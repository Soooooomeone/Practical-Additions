package com.danako.practical_additions.common.item.quiver;

import net.minecraft.world.inventory.tooltip.TooltipComponent;
import org.apache.commons.lang3.math.Fraction;

public record QuiverTooltip(QuiverContents contents, Fraction capacity) implements TooltipComponent {
}