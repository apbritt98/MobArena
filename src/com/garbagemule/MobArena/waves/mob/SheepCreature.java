package com.garbagemule.MobArena.waves.mob;

import com.garbagemule.MobArena.MobArena;
import com.garbagemule.MobArena.framework.Arena;
import org.bukkit.DyeColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Sheep;

import java.util.Arrays;
import java.util.List;

public class SheepCreature implements ArenaCreature {
    private static List<DyeColor> colors = Arrays.asList(DyeColor.values());
    private DyeColor color;
    private boolean explosive;

    public SheepCreature(DyeColor color, boolean explosive) {
        this.color = color;
        this.explosive = explosive;
    }

    public SheepCreature() {
        this(colors.get(MobArena.random.nextInt(colors.size())), false);
    }

    @Override
    public LivingEntity spawn(Arena arena, World world, Location location) {
        Sheep sheep = (Sheep) world.spawnEntity(location, EntityType.SHEEP);
        sheep.setColor(color);
        arena.getMonsterManager().addExplodingSheep(sheep);
        return sheep;
    }
}
