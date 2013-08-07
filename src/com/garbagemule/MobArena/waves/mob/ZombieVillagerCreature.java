package com.garbagemule.MobArena.waves.mob;

import com.garbagemule.MobArena.framework.Arena;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Zombie;

public class ZombieVillagerCreature implements ArenaCreature {
    @Override
    public LivingEntity spawn(Arena arena, World world, Location location) {
        Zombie zombie = (Zombie) world.spawnEntity(location, EntityType.ZOMBIE);
        zombie.setVillager(true);
        return zombie;
    }
}
