package com.garbagemule.MobArena.waves.mob;

import com.garbagemule.MobArena.framework.Arena;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;

public class PoweredCreeperCreature implements ArenaCreature {
    @Override
    public LivingEntity spawn(Arena arena, World world, Location location) {
        Creeper creeper = (Creeper) world.spawnEntity(location, EntityType.CREEPER);
        creeper.setPowered(true);
        return creeper;
    }
}
