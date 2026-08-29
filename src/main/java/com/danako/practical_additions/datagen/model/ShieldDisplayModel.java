package com.danako.practical_additions.datagen.model;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.minecraft.client.data.models.model.ModelInstance;
import net.minecraft.resources.Identifier;

import java.util.LinkedHashMap;
import java.util.Map;

public record ShieldDisplayModel(Identifier particleTexture, Map<String, Transform> display) implements ModelInstance {

    public record Transform(float[] rotation, float[] translation, float[] scale) {
    }

    public static Builder builder(Identifier particleTexture) {
        return new Builder(particleTexture);
    }

    public static final class Builder {
        private final Identifier particleTexture;
        private final Map<String, Transform> display = new LinkedHashMap<>();

        private Builder(Identifier particleTexture) {
            this.particleTexture = particleTexture;
        }

        public Builder add(String slot, float[] rotation, float[] translation, float[] scale) {
            this.display.put(slot, new Transform(rotation, translation, scale));
            return this;
        }

        public ShieldDisplayModel build() {
            return new ShieldDisplayModel(this.particleTexture, this.display);
        }
    }

    @Override
    public JsonObject get() {
        JsonObject root = new JsonObject();
        root.addProperty("gui_light", "front");

        JsonObject textures = new JsonObject();
        textures.addProperty("particle", this.particleTexture.toString());
        root.add("textures", textures);

        JsonObject displayObj = new JsonObject();
        this.display.forEach((slot, t) -> {
            JsonObject entry = new JsonObject();
            entry.add("rotation", toArray(t.rotation()));
            entry.add("translation", toArray(t.translation()));
            entry.add("scale", toArray(t.scale()));
            displayObj.add(slot, entry);
        });
        root.add("display", displayObj);

        return root;
    }

    private static JsonArray toArray(float[] values) {
        JsonArray array = new JsonArray();
        for (float v : values) {
            array.add(v);
        }
        return array;
    }
}