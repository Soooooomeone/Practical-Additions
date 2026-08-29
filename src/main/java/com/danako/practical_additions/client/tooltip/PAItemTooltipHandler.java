package com.danako.practical_additions.client.tooltip;

import com.danako.practical_additions.PracticalAdditions;
import com.danako.practical_additions.config.PAConfig;
import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.component.Tool;
import net.minecraft.world.item.enchantment.Enchantable;
import net.minecraft.world.level.EmptyBlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.ItemTooltipEvent;
import org.lwjgl.glfw.GLFW;

import java.util.List;

@EventBusSubscriber(modid = PracticalAdditions.MODID, value = Dist.CLIENT)
public class PAItemTooltipHandler {

    private static final String HINT_KEY = "tooltip." + PracticalAdditions.MODID + ".press_ctrl_shift";
    private static final String REGISTRY_NAME_KEY = "tooltip." + PracticalAdditions.MODID + ".registry_name";
    private static final String TAGS_KEY = "tooltip." + PracticalAdditions.MODID + ".tags";
    private static final String NO_TAGS_KEY = "tooltip." + PracticalAdditions.MODID + ".no_tags";
    private static final String PROPERTIES_KEY = "tooltip." + PracticalAdditions.MODID + ".properties";
    private static final String PROP_MAX_STACK_SIZE_KEY = "tooltip." + PracticalAdditions.MODID + ".property.max_stack_size";
    private static final String PROP_DURABILITY_KEY = "tooltip." + PracticalAdditions.MODID + ".property.durability";
    private static final String PROP_RARITY_KEY = "tooltip." + PracticalAdditions.MODID + ".property.rarity";
    private static final String PROP_REPAIR_COST_KEY = "tooltip." + PracticalAdditions.MODID + ".property.repair_cost";
    private static final String PROP_ENCHANTABILITY_KEY = "tooltip." + PracticalAdditions.MODID + ".property.enchantability";
    private static final String PROP_ATTACK_DAMAGE_KEY = "tooltip." + PracticalAdditions.MODID + ".property.attack_damage";
    private static final String PROP_ATTACK_SPEED_KEY = "tooltip." + PracticalAdditions.MODID + ".property.attack_speed";
    private static final String PROP_MINING_SPEED_KEY = "tooltip." + PracticalAdditions.MODID + ".property.mining_speed";
    private static final String PROP_NUTRITION_KEY = "tooltip." + PracticalAdditions.MODID + ".property.nutrition";
    private static final String PROP_SATURATION_KEY = "tooltip." + PracticalAdditions.MODID + ".property.saturation";
    private static final String PROP_HARDNESS_KEY = "tooltip." + PracticalAdditions.MODID + ".property.hardness";
    private static final String PROP_LIGHT_LEVEL_KEY = "tooltip." + PracticalAdditions.MODID + ".property.light_level";
    private static final String PROP_INSTRUMENT_KEY = "tooltip." + PracticalAdditions.MODID + ".property.instrument";
    private static final String PROP_REQUIRES_TOOL_KEY = "tooltip." + PracticalAdditions.MODID + ".property.requires_tool";

    private static boolean isKeyDown(int glfwKey) {
        var window = Minecraft.getInstance().getWindow();
        return InputConstants.isKeyDown(window, glfwKey);
    }

    private static boolean isCtrlShiftDown() {
        boolean ctrl = isKeyDown(GLFW.GLFW_KEY_LEFT_CONTROL) || isKeyDown(GLFW.GLFW_KEY_RIGHT_CONTROL);
        boolean shift = isKeyDown(GLFW.GLFW_KEY_LEFT_SHIFT) || isKeyDown(GLFW.GLFW_KEY_RIGHT_SHIFT);
        return ctrl && shift;
    }

    @SubscribeEvent
    public static void onItemTooltip(ItemTooltipEvent event) {
        if (!PAConfig.ENABLE_DEBUG_TOOLTIPS.get()) {
            return;
        }

        ItemStack stack = event.getItemStack();
        List<Component> tooltip = event.getToolTip();
        boolean showExtra = isCtrlShiftDown();

        if (!showExtra) {
            tooltip.add(Component.translatable(HINT_KEY).withStyle(ChatFormatting.DARK_GRAY, ChatFormatting.ITALIC));
            return;
        }

        tooltip.add(Component.empty());

        Identifier id = BuiltInRegistries.ITEM.getKey(stack.getItem());
        tooltip.add(Component.translatable(REGISTRY_NAME_KEY, id.toString()).withStyle(ChatFormatting.GRAY));

        if (PAConfig.SHOW_TAGS.get()) {
            List<TagKey<Item>> tags = stack.getTags().toList();
            tooltip.add(Component.translatable(TAGS_KEY).withStyle(ChatFormatting.GRAY));
            if (tags.isEmpty()) {
                tooltip.add(Component.literal(" - ").append(Component.translatable(NO_TAGS_KEY)).withStyle(ChatFormatting.DARK_GRAY));
            } else {
                for (TagKey<Item> tag : tags) {
                    tooltip.add(Component.literal(" #" + tag.location()).withStyle(ChatFormatting.DARK_GRAY));
                }
            }
        }

        if (PAConfig.SHOW_ITEM_PROPERTIES.get()) {
            tooltip.add(Component.translatable(PROPERTIES_KEY).withStyle(ChatFormatting.GRAY));
            appendItemProperties(stack, tooltip);
        }
    }

    private static void addProp(List<Component> tooltip, String key, Object value) {
        tooltip.add(Component.literal(" - ").append(Component.translatable(key)).append(Component.literal(": " + value)).withStyle(ChatFormatting.DARK_GRAY));
    }

    private static void appendItemProperties(ItemStack stack, List<Component> tooltip) {
        Item item = stack.getItem();

        if (PAConfig.SHOW_PROP_GENERAL.get()) {
            addProp(tooltip, PROP_MAX_STACK_SIZE_KEY, stack.getMaxStackSize());

            if (stack.isDamageableItem()) {
                addProp(tooltip, PROP_DURABILITY_KEY, stack.getMaxDamage());
            }

            addProp(tooltip, PROP_RARITY_KEY, stack.getRarity().name());

            Integer repairCost = stack.get(DataComponents.REPAIR_COST);
            if (repairCost != null && repairCost > 0) {
                addProp(tooltip, PROP_REPAIR_COST_KEY, repairCost);
            }
        }

        if (PAConfig.SHOW_PROP_ENCHANTABILITY.get()) {
            Enchantable enchantable = stack.get(DataComponents.ENCHANTABLE);
            if (enchantable != null) {
                addProp(tooltip, PROP_ENCHANTABILITY_KEY, enchantable.value());
            }
        }

        if (PAConfig.SHOW_PROP_COMBAT.get()) {
            ItemAttributeModifiers modifiers = stack.get(DataComponents.ATTRIBUTE_MODIFIERS);
            if (modifiers != null) {
                for (ItemAttributeModifiers.Entry entry : modifiers.modifiers()) {
                    if (entry.attribute().is(Attributes.ATTACK_DAMAGE)) {
                        addProp(tooltip, PROP_ATTACK_DAMAGE_KEY, entry.modifier().amount());
                    } else if (entry.attribute().is(Attributes.ATTACK_SPEED)) {
                        addProp(tooltip, PROP_ATTACK_SPEED_KEY, entry.modifier().amount());
                    }
                }
            }
        }

        if (PAConfig.SHOW_PROP_TOOL.get()) {
            Tool tool = stack.get(DataComponents.TOOL);
            if (tool != null) {
                addProp(tooltip, PROP_MINING_SPEED_KEY, tool.defaultMiningSpeed());
            }
        }

        if (PAConfig.SHOW_PROP_FOOD.get()) {
            FoodProperties food = stack.get(DataComponents.FOOD);
            if (food != null) {
                addProp(tooltip, PROP_NUTRITION_KEY, food.nutrition());
                addProp(tooltip, PROP_SATURATION_KEY, food.saturation());
            }
        }

        if (PAConfig.SHOW_PROP_BLOCK.get() && item instanceof BlockItem blockItem) {
            Block block = blockItem.getBlock();
            BlockState state = block.defaultBlockState();

            addProp(tooltip, PROP_HARDNESS_KEY, state.getDestroySpeed(EmptyBlockGetter.INSTANCE, BlockPos.ZERO));
            addProp(tooltip, PROP_LIGHT_LEVEL_KEY, state.getLightEmission());
            addProp(tooltip, PROP_INSTRUMENT_KEY, state.instrument().toString());
            addProp(tooltip, PROP_REQUIRES_TOOL_KEY, state.requiresCorrectToolForDrops());
        }
    }
}