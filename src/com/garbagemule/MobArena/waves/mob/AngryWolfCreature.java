package com.garbagemule.MobArena.waves.mob;

import com.garbagemule.MobArena.framework.Arena;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Wolf;

public class AngryWolfCreature implements ArenaCreature {
    @Override
    public LivingEntity spawn(Arena arena, World world, Location location) {
        Wolf wolf = (Wolf) world.spawnEntity(location, EntityType.WOLF);
        wolf.setAngry(true);
        return wolf;
    }
}
