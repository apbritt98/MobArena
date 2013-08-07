package com.garbagemule.MobArena.waves.mob;

import com.garbagemule.MobArena.MobArena;
import com.garbagemule.MobArena.framework.Arena;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Slime;

public class SlimeCreature implements ArenaCreature {
    private EntityType type;
    private int size;

    public SlimeCreature(EntityType type, int size) {
        this.type = type;
        this.size = size;
    }

    public SlimeCreature(EntityType type) {
        this(type, 1 + MobArena.random.nextInt(3));
    }

    @Override
    public LivingEntity spawn(Arena arena, World world, Location location) {
        Slime slime = (Slime) world.spawnEntity(location, type);
        slime.setSize(size);
        return slime;
    }
}
