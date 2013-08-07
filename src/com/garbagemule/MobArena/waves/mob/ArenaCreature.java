package com.garbagemule.MobArena.waves.mob;

import com.garbagemule.MobArena.framework.Arena;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.LivingEntity;

public interface ArenaCreature {
    /**
     * Spawn the arena creature in the given arena and location.
     *
     * @param arena the arena to spawn in
     * @param world the world of the arena
     * @param location the location to spawn at
     * @return the spawned entity
     */
    public LivingEntity spawn(Arena arena, World world, Location location);
}
