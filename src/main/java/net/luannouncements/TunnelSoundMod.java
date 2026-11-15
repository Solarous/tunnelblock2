package net.luannouncements;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class TunnelSoundMod implements ModInitializer {
    public static final String MOD_ID = "luannouncements";

    // ---- Train Tunnel Sound (14.65 s = 293 ticks) ----
    public static final Identifier TUNNEL_ID = new Identifier(MOD_ID, "train_tunnel_sound");
    public static final SoundEvent TUNNEL_SOUND = SoundEvent.of(TUNNEL_ID);
    public static final Block TUNNEL_BLOCK = new TunnelSoundBlock(
            AbstractBlock.Settings.create().strength(1.0f), () -> TUNNEL_SOUND, 293, 1.0f);

    // ---- Spooky Tunnel Sound (14.76 s = 295 ticks) ----
    public static final Identifier SPOOKY_ID = new Identifier(MOD_ID, "train_tunnel_sound_spooky");
    public static final SoundEvent SPOOKY_SOUND = SoundEvent.of(SPOOKY_ID);
    public static final Block SPOOKY_BLOCK = new TunnelSoundBlock(
            AbstractBlock.Settings.create().strength(1.0f), () -> SPOOKY_SOUND, 295, 1.0f);

    @Override
    public void onInitialize() {
        Registry.register(Registries.SOUND_EVENT, TUNNEL_ID, TUNNEL_SOUND);
        Registry.register(Registries.SOUND_EVENT, SPOOKY_ID, SPOOKY_SOUND);

        Registry.register(Registries.BLOCK, TUNNEL_ID, TUNNEL_BLOCK);
        Registry.register(Registries.BLOCK, SPOOKY_ID, SPOOKY_BLOCK);

        Item tunnelItem = Registry.register(Registries.ITEM, TUNNEL_ID,
                new BlockItem(TUNNEL_BLOCK, new Item.Settings()));
        Item spookyItem = Registry.register(Registries.ITEM, SPOOKY_ID,
                new BlockItem(SPOOKY_BLOCK, new Item.Settings()));

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(entries -> {
            entries.add(tunnelItem);
            entries.add(spookyItem);
        });
    }
}
