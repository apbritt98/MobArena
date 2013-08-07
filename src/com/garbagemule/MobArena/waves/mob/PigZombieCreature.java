package com.garbagemule.MobArena.waves.mob;

import com.garbagemule.MobArena.framework.Arena;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.PigZombie;
import org.bukkit.inventory.ItemStack;

public class PigZombieCreature implements ArenaCreature {
    @Override
    public LivingEntity spawn(Arena arena, World world, Location location) {
        PigZombie pigzombie = (PigZombie) world.spawnEntity(location, EntityType.PIG_ZOMBIE);
        pigzombie.getEquipment().setItemInHand(new ItemStack(Material.GOLD_SWORD, 1));
        return pigzombie;
    }
}
