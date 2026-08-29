# Practical Additions

A Minecraft mod for NeoForge that adds practical tools and items to enhance your gameplay experience.

## Features

### Tools
- **Hammer** — Area-of-effect mining tool
- **Excavator** — Area-of-effect digging tool
- **Sickle** — Area-of-effect harvesting tool

### Items
- **Backpack** — Wearable storage (Curios-compatible)
- **Basic Magnet** — Pulls nearby items toward you
- **Advanced Magnet** — Enhanced magnet with item filtering
- **Cobalt Bow** — A new bow variant
- **Kevlar Shield** — A reinforced shield
- **Quiver** — Arrow storage (Curios-compatible)
- **Diving Belt** — Underwater accessory (Curios-compatible)
- **Blunt** — A blunt weapon

## Requirements

| Dependency | Version |
|---|---|
| Minecraft | 1.21.11 |
| NeoForge | 21.11.45+ |
| Curios | 14.0.0+ |

## Building

```bash
./gradlew build
```

The compiled mod JAR will be in `build/libs/`.

## Development

### Data Generation

```bash
./gradlew runClientData
```

### Run the Game

```bash
./gradlew runClient
```

### Run a Server

```bash
./gradlew runServer
```

## Project Structure

```
src/main/java/com/danako/practical_additions/
├── client/          — Client-side rendering, screens, tooltips, key bindings
├── common/
│   ├── item/        — Items (backpack, magnet, quiver, diving belt, cobalt bow, blunt)
│   └── tool/        — AOE tools (hammer, excavator, sickle)
├── config/          — Mod configuration
└── datagen/         — Data generation (recipes, models, tags, loot tables, worldgen)
```

## License

All Rights Reserved
