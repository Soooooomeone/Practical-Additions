package com.danako.practical_additions.client.item.quiver;

import com.danako.practical_additions.common.item.quiver.QuiverContents;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.tooltip.ClientTooltipComponent;
import net.minecraft.client.gui.screens.inventory.tooltip.DefaultTooltipPositioner;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Mth;
import net.minecraft.world.item.ItemStack;
import org.apache.commons.lang3.math.Fraction;
import org.jspecify.annotations.Nullable;

import java.util.List;

public class ClientQuiverTooltip implements ClientTooltipComponent {
    private static final Identifier PROGRESSBAR_BORDER_SPRITE = Identifier.withDefaultNamespace("container/bundle/bundle_progressbar_border");
    private static final Identifier PROGRESSBAR_FILL_SPRITE = Identifier.withDefaultNamespace("container/bundle/bundle_progressbar_fill");
    private static final Identifier PROGRESSBAR_FULL_SPRITE = Identifier.withDefaultNamespace("container/bundle/bundle_progressbar_full");
    private static final Identifier SLOT_HIGHLIGHT_BACK_SPRITE = Identifier.withDefaultNamespace("container/bundle/slot_highlight_back");
    private static final Identifier SLOT_HIGHLIGHT_FRONT_SPRITE = Identifier.withDefaultNamespace("container/bundle/slot_highlight_front");
    private static final Identifier SLOT_BACKGROUND_SPRITE = Identifier.withDefaultNamespace("container/bundle/slot_background");
    private static final int SLOT_SIZE = 24;
    private static final int GRID_WIDTH = 96;
    private static final int PROGRESSBAR_HEIGHT = 13;
    private static final Component QUIVER_FULL_TEXT = Component.translatable("item.practical_additions.quiver.full");
    private static final Component QUIVER_EMPTY_TEXT = Component.translatable("item.practical_additions.quiver.empty");
    private static final Component QUIVER_EMPTY_DESCRIPTION = Component.translatable("item.practical_additions.quiver.empty.description");
    private final QuiverContents contents;
    private final Fraction capacity;

    public ClientQuiverTooltip(QuiverContents contents, Fraction capacity) {
        this.contents = contents;
        this.capacity = capacity;
    }

    @Override
    public int getHeight(Font font) {
        return this.contents.isEmpty() ? getEmptyQuiverBackgroundHeight(font) : this.backgroundHeight();
    }

    @Override
    public int getWidth(Font font) {
        return GRID_WIDTH;
    }

    @Override
    public boolean showTooltipWithItemInHand() {
        return true;
    }

    private static int getEmptyQuiverBackgroundHeight(Font font) {
        return getEmptyQuiverDescriptionTextHeight(font) + PROGRESSBAR_HEIGHT + 8;
    }

    private int backgroundHeight() {
        return this.itemGridHeight() + PROGRESSBAR_HEIGHT + 8;
    }

    private int itemGridHeight() {
        return this.gridSizeY() * SLOT_SIZE;
    }

    private int getContentXOffset(int width) {
        return (width - GRID_WIDTH) / 2;
    }

    private int gridSizeY() {
        return Mth.positiveCeilDiv(this.slotCount(), 4);
    }

    private int slotCount() {
        return Math.min(12, this.contents.size());
    }

    @Override
    public void renderImage(Font font, int x, int y, int width, int height, GuiGraphics guiGraphics) {
        if (this.contents.isEmpty()) {
            this.renderEmptyQuiverTooltip(font, x, y, width, height, guiGraphics);
        } else {
            this.renderQuiverWithItemsTooltip(font, x, y, width, height, guiGraphics);
        }
    }

    private void renderEmptyQuiverTooltip(Font font, int x, int y, int width, int height, GuiGraphics guiGraphics) {
        drawEmptyQuiverDescriptionText(x + this.getContentXOffset(width), y, font, guiGraphics);
        this.drawProgressbar(x + this.getContentXOffset(width), y + getEmptyQuiverDescriptionTextHeight(font) + 4, font, guiGraphics);
    }

    private void renderQuiverWithItemsTooltip(Font font, int x, int y, int width, int height, GuiGraphics guiGraphics) {
        boolean overflowing = this.contents.size() > 12;
        List<ItemStack> shown = this.getShownItems(this.contents.getNumberOfItemsToShow());
        int rightEdge = x + this.getContentXOffset(width) + GRID_WIDTH;
        int bottomEdge = y + this.gridSizeY() * SLOT_SIZE;
        int drawnCount = 1;

        for (int row = 1; row <= this.gridSizeY(); row++) {
            for (int col = 1; col <= 4; col++) {
                int slotX = rightEdge - col * SLOT_SIZE;
                int slotY = bottomEdge - row * SLOT_SIZE;
                if (shouldRenderSurplusText(overflowing, col, row)) {
                    renderCount(slotX, slotY, this.getAmountOfHiddenItems(shown), font, guiGraphics);
                } else if (shouldRenderItemSlot(shown, drawnCount)) {
                    this.renderSlot(drawnCount, slotX, slotY, shown, drawnCount, font, guiGraphics);
                    drawnCount++;
                }
            }
        }

        this.drawSelectedItemTooltip(font, guiGraphics, x, y, width);
        this.drawProgressbar(x + this.getContentXOffset(width), y + this.itemGridHeight() + 4, font, guiGraphics);
    }

    private List<ItemStack> getShownItems(int itemsToShow) {
        int count = Math.min(this.contents.size(), itemsToShow);
        return this.contents.itemCopyStream().toList().subList(0, count);
    }

    private static boolean shouldRenderSurplusText(boolean hasEnoughItems, int cellX, int cellY) {
        return hasEnoughItems && cellX * cellY == 1;
    }

    private static boolean shouldRenderItemSlot(List<ItemStack> shownItems, int slotIndex) {
        return shownItems.size() >= slotIndex;
    }

    private int getAmountOfHiddenItems(List<ItemStack> shownItems) {
        return this.contents.itemCopyStream().skip(shownItems.size()).mapToInt(ItemStack::getCount).sum();
    }

    private void renderSlot(int slotIndex, int x, int y, List<ItemStack> shownItems, int seed, Font font, GuiGraphics guiGraphics) {
        int index = shownItems.size() - slotIndex;
        boolean selected = index == this.contents.getSelectedItem();
        ItemStack stack = shownItems.get(index);
        if (selected) {
            guiGraphics.blitSprite(RenderPipelines.GUI_TEXTURED, SLOT_HIGHLIGHT_BACK_SPRITE, x, y, SLOT_SIZE, SLOT_SIZE);
        } else {
            guiGraphics.blitSprite(RenderPipelines.GUI_TEXTURED, SLOT_BACKGROUND_SPRITE, x, y, SLOT_SIZE, SLOT_SIZE);
        }

        guiGraphics.renderItem(stack, x + 4, y + 4, seed);
        guiGraphics.renderItemDecorations(font, stack, x + 4, y + 4);
        if (selected) {
            guiGraphics.blitSprite(RenderPipelines.GUI_TEXTURED, SLOT_HIGHLIGHT_FRONT_SPRITE, x, y, SLOT_SIZE, SLOT_SIZE);
        }
    }

    private static void renderCount(int slotX, int slotY, int count, Font font, GuiGraphics guiGraphics) {
        guiGraphics.drawCenteredString(font, "+" + count, slotX + 12, slotY + 10, -1);
    }

    private void drawSelectedItemTooltip(Font font, GuiGraphics guiGraphics, int x, int y, int width) {
        if (this.contents.hasSelectedItem()) {
            ItemStack stack = this.contents.getItemUnsafe(this.contents.getSelectedItem());
            Component name = stack.getStyledHoverName();
            int textWidth = font.width(name.getVisualOrderText());
            int centerX = x + width / 2 - 12;
            ClientTooltipComponent nameTooltip = ClientTooltipComponent.create(name.getVisualOrderText());
            guiGraphics.renderTooltip(
                    font,
                    List.of(nameTooltip),
                    centerX - textWidth / 2,
                    y - 15,
                    DefaultTooltipPositioner.INSTANCE,
                    stack.get(DataComponents.TOOLTIP_STYLE)
            );
        }
    }

    private void drawProgressbar(int x, int y, Font font, GuiGraphics guiGraphics) {
        guiGraphics.blitSprite(RenderPipelines.GUI_TEXTURED, this.getProgressBarTexture(), x + 1, y, this.getProgressBarFill(), PROGRESSBAR_HEIGHT);
        guiGraphics.blitSprite(RenderPipelines.GUI_TEXTURED, PROGRESSBAR_BORDER_SPRITE, x, y, GRID_WIDTH, PROGRESSBAR_HEIGHT);
        Component fillText = this.getProgressBarFillText();
        if (fillText != null) {
            guiGraphics.drawCenteredString(font, fillText, x + 48, y + 3, -1);
        }
    }

    private static void drawEmptyQuiverDescriptionText(int x, int y, Font font, GuiGraphics guiGraphics) {
        guiGraphics.drawWordWrap(font, QUIVER_EMPTY_DESCRIPTION, x, y, GRID_WIDTH, -5592406);
    }

    private static int getEmptyQuiverDescriptionTextHeight(Font font) {
        return font.split(QUIVER_EMPTY_DESCRIPTION, GRID_WIDTH).size() * 9;
    }

    private Fraction fillRatio() {
        return this.contents.weight().divideBy(this.capacity);
    }

    private int getProgressBarFill() {
        return Mth.clamp(Mth.mulAndTruncate(this.fillRatio(), 94), 0, 94);
    }

    private Identifier getProgressBarTexture() {
        return this.fillRatio().compareTo(Fraction.ONE) >= 0 ? PROGRESSBAR_FULL_SPRITE : PROGRESSBAR_FILL_SPRITE;
    }

    private @Nullable Component getProgressBarFillText() {
        if (this.contents.isEmpty()) {
            return QUIVER_EMPTY_TEXT;
        }
        return this.fillRatio().compareTo(Fraction.ONE) >= 0 ? QUIVER_FULL_TEXT : null;
    }
}