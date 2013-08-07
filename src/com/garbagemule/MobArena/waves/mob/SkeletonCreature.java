package com.garbagemule.MobArena.waves.mob;

import com.garbagemule.MobArena.framework.Arena;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Skeleton.SkeletonType;
import org.bukkit.inventory.ItemStack;

public class SkeletonCreature implements ArenaCreature {
    private SkeletonType type;

    public SkeletonCreature(SkeletonType type) {
        this.type = type;
    }

    public SkeletonCreature() {
        this(Skeleton.SkeletonType.NORMAL);
    }

    @Override
    public LivingEntity spawn(Arena arena, World world, Location location) {
        Skeleton skeleton = (Skeleton) world.spawnEntity(location, EntityType.SKELETON);
        skeleton.setSkeletonType(type);
        switch (type) {
            case NORMAL:
                skeleton.getEquipment().setItemInHand(new ItemStack(Material.BOW, 1));
                break;
            case WITHER:
                skeleton.getEquipment().setItemInHand(new ItemStack(Material.STONE_SWORD, 1));
                break;
        }
        return skeleton;
    }
}
