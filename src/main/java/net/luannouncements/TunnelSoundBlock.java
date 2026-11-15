package net.luannouncements;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

import java.util.function.Supplier;

/**
 * Plays a sound on a loop, forever, from the moment it is placed.
 * Same idea as the "See it Say it Sorted" block in the MTR London Underground Addon.
 */
public class TunnelSoundBlock extends Block {
    private final Supplier<SoundEvent> sound;
    private final int loopTicks;
    private final float volume;

    /**
     * @param sound     the sound to play
     * @param loopTicks length of the sound in game ticks (seconds x 20), so it repeats seamlessly
     * @param volume    1.0 = audible up to about 16 blocks, 2.0 = about 32, 4.0 = about 64
     */
    public TunnelSoundBlock(Settings settings, Supplier<SoundEvent> sound, int loopTicks, float volume) {
        super(settings);
        this.sound = sound;
        this.loopTicks = loopTicks;
        this.volume = volume;
    }

    @Override
    public void onBlockAdded(BlockState state, World world, BlockPos pos, BlockState oldState, boolean notify) {
        if (!world.isClient && !oldState.isOf(state.getBlock())) {
            world.scheduleBlockTick(pos, this, 1);
        }
    }

    @Override
    public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        world.playSound(null, pos, sound.get(), SoundCategory.AMBIENT, volume, 1.0f);
        world.scheduleBlockTick(pos, this, loopTicks);
    }
}
