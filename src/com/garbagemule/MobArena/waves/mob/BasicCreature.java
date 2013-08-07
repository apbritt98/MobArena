package com.garbagemule.MobArena.waves.mob;

import com.garbagemule.MobArena.framework.Arena;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;

public class BasicCreature implements ArenaCreature {
    private EntityType type;

    public BasicCreature(EntityType type) {
        this.type = type;
    }

    @Override
    public LivingEntity spawn(Arena arena, World world, Location location) {
        return (LivingEntity) world.spawnEntity(location, type);
    }
}
