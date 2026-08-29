package com.danako.practical_additions.client.inventory.backpack;

import com.danako.practical_additions.PracticalAdditions;
import com.danako.practical_additions.inventory.backpack.BackpackMenu;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.player.Inventory;

public class BackpackScreen extends AbstractContainerScreen<BackpackMenu> {

    private static final Identifier PANEL_TEXTURE_BASIC = Identifier.fromNamespaceAndPath(PracticalAdditions.MODID, "textures/gui/backpack_basic.png");
    private static final Identifier PANEL_TEXTURE_REINFORCED = Identifier.fromNamespaceAndPath(PracticalAdditions.MODID, "textures/gui/backpack_reinforced.png");
    private static final Identifier SLOT_TEXTURE = Identifier.fromNamespaceAndPath(PracticalAdditions.MODID, "textures/gui/backpack_slots.png");

    private static final int GRID_X = 8;
    private static final int GRID_Y = 17;

    private final int backpackRows;
    private final Identifier panelTexture;

    public BackpackScreen(BackpackMenu menu, Inventory playerInventory, Component title) {
        super(menu, playerInventory, title);
        this.backpackRows = menu.getBackpackSlotCount() / 9;
        this.panelTexture = backpackRows > 3 ? PANEL_TEXTURE_REINFORCED : PANEL_TEXTURE_BASIC;
        this.imageWidth = 176;
        this.imageHeight = GRID_Y + backpackRows * 18 + 13 + 3 * 18 + 4 + 18 + 6;
        this.inventoryLabelY = this.imageHeight - 94;
    }

    @Override
    protected void renderBg(GuiGraphics graphics, float partialTick, int mouseX, int mouseY) {
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        graphics.blit(RenderPipelines.GUI_TEXTURED, panelTexture, x, y, 0, 0, imageWidth, imageHeight, imageWidth, imageHeight);

        for (int row = 0; row < backpackRows; row++) {
            for (int col = 0; col < 9; col++) {
                blitSlot(graphics, x + GRID_X + col * 18, y + GRID_Y + row * 18);
            }
        }

        int invY = y + GRID_Y + backpackRows * 18 + 13;
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 9; col++) {
                blitSlot(graphics, x + GRID_X + col * 18, invY + row * 18);
            }
        }
        int hotbarY = invY + 3 * 18 + 4;
        for (int col = 0; col < 9; col++) {
            blitSlot(graphics, x + GRID_X + col * 18, hotbarY);
        }
    }

    private void blitSlot(GuiGraphics graphics, int x, int y) {
        graphics.blit(RenderPipelines.GUI_TEXTURED, SLOT_TEXTURE, x, y, 0, 0, 18, 18, 18, 18);
    }

    @Override
    public void render(GuiGraphics graphics, int mouseX, int mouseY, float partialTick) {
        super.render(graphics, mouseX, mouseY, partialTick);
        renderTooltip(graphics, mouseX, mouseY);
    }
}