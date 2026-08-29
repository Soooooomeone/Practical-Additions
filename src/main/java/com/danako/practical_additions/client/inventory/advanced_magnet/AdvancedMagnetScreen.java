package com.danako.practical_additions.client.inventory.advanced_magnet;
import com.danako.practical_additions.PracticalAdditions;
import com.danako.practical_additions.inventory.magnet.AdvancedMagnetMenu;
import com.danako.practical_additions.network.magnet.MagnetClearFilterPayload;
import com.danako.practical_additions.network.magnet.MagnetFilterModePayload;
import com.danako.practical_additions.network.magnet.MagnetPageChangePayload;
import com.danako.practical_additions.network.magnet.MagnetToggleXpPayload;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.player.Inventory;
import net.neoforged.neoforge.client.network.ClientPacketDistributor;

public class AdvancedMagnetScreen extends AbstractContainerScreen<AdvancedMagnetMenu> {
    private static final Identifier TEXTURE = Identifier.fromNamespaceAndPath(PracticalAdditions.MODID, "textures/gui/advanced_magnet.png");
    private static final int SIDE_BUTTON_WIDTH = 90;
    private static final int SIDE_BUTTON_HEIGHT = 14;
    private static final int SIDE_BUTTON_GAP = 2;
    private static final int GRID_X = 107;
    private static final int GRID_Y = 13;
    private Button modeButton;
    private Button xpButton;
    private Button clearButton;
    private Button previousPageButton;
    private Button nextPageButton;
    public AdvancedMagnetScreen(AdvancedMagnetMenu menu, Inventory playerInventory, Component title) {
        super(menu, playerInventory, title);
        this.imageWidth = 176;
        this.imageHeight = 166;
    }
    @Override
    protected void init() {
        super.init();
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;
        int rowStep = SIDE_BUTTON_HEIGHT + SIDE_BUTTON_GAP;
        int firstRowY = y + 18;
        this.modeButton = Button.builder(modeLabel(), btn -> onToggleMode()).bounds(x + 8, firstRowY, SIDE_BUTTON_WIDTH, SIDE_BUTTON_HEIGHT).build();
        addRenderableWidget(modeButton);
        this.xpButton = Button.builder(xpLabel(), btn -> onToggleXp()).bounds(x + 8, firstRowY + rowStep, SIDE_BUTTON_WIDTH, SIDE_BUTTON_HEIGHT).build();
        addRenderableWidget(xpButton);
        this.clearButton = Button.builder(clearLabel(), btn -> onClearEntries()).bounds(x + 8, firstRowY + rowStep * 2, SIDE_BUTTON_WIDTH, SIDE_BUTTON_HEIGHT).build();
        addRenderableWidget(clearButton);
        this.previousPageButton = Button.builder(Component.literal("<"), btn -> onPreviousPage()).bounds(x + GRID_X, y + GRID_Y + 54, 16, 10).build();
        addRenderableWidget(previousPageButton);
        this.nextPageButton = Button.builder(Component.literal(">"), btn -> onNextPage()).bounds(x + GRID_X + 38, y + GRID_Y + 54, 16, 10).build();
        addRenderableWidget(nextPageButton);
    }
    private Component modeLabel() {
        String key = menu.isWhitelist() ? "gui." + PracticalAdditions.MODID + ".whitelist" : "gui." + PracticalAdditions.MODID + ".blacklist";
        return Component.translatable(key);
    }
    private void onToggleMode() {
        ClientPacketDistributor.sendToServer(new MagnetFilterModePayload(menu.containerId));
    }
    private Component xpLabel() {
        String key = menu.isAttractExperience() ? "gui." + PracticalAdditions.MODID + ".xp_on" : "gui." + PracticalAdditions.MODID + ".xp_off";
        return Component.translatable(key);
    }
    private void onToggleXp() {
        ClientPacketDistributor.sendToServer(new MagnetToggleXpPayload(menu.containerId));
    }
    private Component clearLabel() {
        return Component.translatable("gui." + PracticalAdditions.MODID + ".clear_entries");
    }
    private void onClearEntries() {
        ClientPacketDistributor.sendToServer(new MagnetClearFilterPayload(menu.containerId));
    }
    private void onPreviousPage() {
        ClientPacketDistributor.sendToServer(new MagnetPageChangePayload(menu.containerId, false));
    }
    private void onNextPage() {
        ClientPacketDistributor.sendToServer(new MagnetPageChangePayload(menu.containerId, true));
    }
    @Override
    protected void containerTick() {
        super.containerTick();
        if (modeButton != null) {
            modeButton.setMessage(modeLabel());
        }
        if (xpButton != null) {
            xpButton.setMessage(xpLabel());
        }
        if (previousPageButton != null) {
            previousPageButton.active = menu.canGoToPreviousPage();
        }
        if (nextPageButton != null) {
            nextPageButton.active = menu.canGoToNextPage();
        }
    }
    @Override
    protected void renderBg(GuiGraphics graphics, float partialTick, int mouseX, int mouseY) {
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;
        graphics.blit(RenderPipelines.GUI_TEXTURED, TEXTURE, x, y, 0, 0, imageWidth, imageHeight, 176, 166);
        renderFilterSlotTint(graphics, x, y);
    }
    private void renderFilterSlotTint(GuiGraphics graphics, int x, int y) {
        int color = menu.isWhitelist() ? 0x6000FF00 : 0x60FF0000;
        int gridX = x + GRID_X;
        int gridY = y + GRID_Y;
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                int slotX = gridX + col * 18 + 1;
                int slotY = gridY + row * 18 + 1;
                graphics.fill(slotX, slotY, slotX + 16, slotY + 16, color);
            }
        }
    }
    @Override
    public void render(GuiGraphics graphics, int mouseX, int mouseY, float partialTick) {
        super.render(graphics, mouseX, mouseY, partialTick);
        renderTooltip(graphics, mouseX, mouseY);
    }
}