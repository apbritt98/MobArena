package com.garbagemule.MobArena.waves;

import com.garbagemule.MobArena.waves.mob.*;
import org.bukkit.DyeColor;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Skeleton.SkeletonType;

public enum MACreature
{
    // Default creatures
    ZOMBIE(EntityType.ZOMBIE),            ZOMBIES(EntityType.ZOMBIE), 
    SKELETON(EntityType.SKELETON),        SKELETONS(EntityType.SKELETON),
    SPIDER(EntityType.SPIDER),            SPIDERS(EntityType.SPIDER),
    CREEPER(EntityType.CREEPER),          CREEPERS(EntityType.CREEPER),
    WOLF(EntityType.WOLF),                WOLVES(EntityType.WOLF),
    
    // Special creatures
    ZOMBIEPIGMAN(EntityType.PIG_ZOMBIE),  ZOMBIEPIGMEN(EntityType.PIG_ZOMBIE),
    POWEREDCREEPER(EntityType.CREEPER),   POWEREDCREEPERS(EntityType.CREEPER),
    ANGRYWOLF(EntityType.WOLF),           ANGRYWOLVES(EntityType.WOLF),
    GIANT(EntityType.GIANT),              GIANTS(EntityType.GIANT),
    GHAST(EntityType.GHAST),              GHASTS(EntityType.GHAST),
    ENDERMAN(EntityType.ENDERMAN),        ENDERMEN(EntityType.ENDERMAN),
    CAVESPIDER(EntityType.CAVE_SPIDER),   CAVESPIDERS(EntityType.CAVE_SPIDER),
    SILVERFISH(EntityType.SILVERFISH),
    
    // 1.0 creatures
    BLAZE(EntityType.BLAZE),              BLAZES(EntityType.BLAZE),
    ENDERDRAGON(EntityType.ENDER_DRAGON), ENDERDRAGONS(EntityType.ENDER_DRAGON),
    SNOWMAN(EntityType.SNOWMAN),          SNOWMEN(EntityType.SNOWMAN),
    SNOWGOLEM(EntityType.SNOWMAN),        SNOWGOLEMS(EntityType.SNOWMAN),
    MUSHROOMCOW(EntityType.MUSHROOM_COW), MUSHROOMCOWS(EntityType.MUSHROOM_COW),
    VILLAGER(EntityType.VILLAGER),        VILLAGERS(EntityType.VILLAGER),
    
    // 1.2 creatures
    OCELOT(EntityType.OCELOT),            OCELOTS(EntityType.OCELOT),
    IRONGOLEM(EntityType.IRON_GOLEM),     IRONGOLEMS(EntityType.IRON_GOLEM),
    
    // Passive creatures
    CHICKEN(EntityType.CHICKEN),          CHICKENS(EntityType.CHICKEN),
    COW(EntityType.COW),                  COWS(EntityType.COW),
    PIG(EntityType.PIG),                  PIGS(EntityType.PIG),
    SHEEP(EntityType.SHEEP),
    SQUID(EntityType.SQUID),              SQUIDS(EntityType.SQUID),
    
    // Extended creatures
    EXPLODINGSHEEP(EntityType.SHEEP),
    
    // Slimes
    SLIME(EntityType.SLIME),              SLIMES(EntityType.SLIME),
    SLIMETINY(EntityType.SLIME),          SLIMESTINY(EntityType.SLIME),
    SLIMESMALL(EntityType.SLIME),         SLIMESSMALL(EntityType.SLIME),
    SLIMEBIG(EntityType.SLIME),           SLIMESBIG(EntityType.SLIME),
    SLIMEHUGE(EntityType.SLIME),          SLIMESHUGE(EntityType.SLIME),
    
    // Magma cubes
    MAGMACUBE(EntityType.MAGMA_CUBE),     MAGMACUBES(EntityType.MAGMA_CUBE),
    MAGMACUBETINY(EntityType.MAGMA_CUBE), MAGMACUBESTINY(EntityType.MAGMA_CUBE),
    MAGMACUBESMALL(EntityType.MAGMA_CUBE),MAGMACUBESSMALL(EntityType.MAGMA_CUBE),
    MAGMACUBEBIG(EntityType.MAGMA_CUBE),  MAGMACUBESBIG(EntityType.MAGMA_CUBE),
    MAGMACUBEHUGE(EntityType.MAGMA_CUBE), MAGMACUBESHUGE(EntityType.MAGMA_CUBE),
        
    // 1.4 creatures
    BAT(EntityType.BAT),                  BATS(EntityType.BAT),
    WITCH(EntityType.WITCH),              WITCHES(EntityType.WITCH),
    WITHER(EntityType.WITHER),            WITHERS(EntityType.WITHER),
    WITHERSKELETON(EntityType.SKELETON),  WITHERSKELETONS(EntityType.SKELETON),
    BABYZOMBIE(EntityType.ZOMBIE),        BABYZOMBIES(EntityType.ZOMBIE),
    BABYPIGMAN(EntityType.PIG_ZOMBIE),    BABYPIGMEN(EntityType.PIG_ZOMBIE),
    ZOMBIEVILLAGER(EntityType.ZOMBIE),    ZOMBIEVILLAGERS(EntityType.ZOMBIE);

    private EntityType type;
    
    private MACreature(EntityType type) {
        this.type = type;
    }
    
    public EntityType getType() {
        return type;
    }

    public static ArenaCreature creatureFromString(String string) {
        MACreature mac = WaveUtils.getEnumFromString(MACreature.class, string.replaceAll("[-_\\.]", ""));
        if (mac == null) {
            EntityType type = EntityType.fromName(string);
            if (type == null && string.matches("[1-9][0-9]*")) {
                type = EntityType.fromId(Integer.parseInt(string));
            }
            return type != null ? new BasicCreature(type) : null;
        }

        switch (mac) {
            case SHEEP:
                return new SheepCreature();
            case EXPLODINGSHEEP:
                return new SheepCreature(DyeColor.RED, true);
            case ANGRYWOLF:
            case ANGRYWOLVES:
                return new AngryWolfCreature();
            case SKELETON:
            case SKELETONS:
                return new SkeletonCreature();
            case WITHERSKELETON:
            case WITHERSKELETONS:
                return new SkeletonCreature(SkeletonType.WITHER);
            case BABYZOMBIE:
            case BABYZOMBIES:
            case BABYPIGMAN:
            case BABYPIGMEN:
                return new BabyZombieCreature(mac.getType());
            case ZOMBIEPIGMAN:
            case ZOMBIEPIGMEN:
                return new PigZombieCreature();
            case ZOMBIEVILLAGER:
            case ZOMBIEVILLAGERS:
                return new ZombieVillagerCreature();
            case POWEREDCREEPER:
            case POWEREDCREEPERS:
                return new PoweredCreeperCreature();
            case SLIME:
            case SLIMES:
            case MAGMACUBE:
            case MAGMACUBES:
                return new SlimeCreature(mac.getType());
            case SLIMETINY:
            case SLIMESTINY:
            case MAGMACUBETINY:
            case MAGMACUBESTINY:
                return new SlimeCreature(mac.getType(), 1);
            case SLIMESMALL:
            case SLIMESSMALL:
            case MAGMACUBESMALL:
            case MAGMACUBESSMALL:
                return new SlimeCreature(mac.getType(), 2);
            case SLIMEBIG:
            case SLIMESBIG:
            case MAGMACUBEBIG:
            case MAGMACUBESBIG:
                return new SlimeCreature(mac.getType(), 3);
            case SLIMEHUGE:
            case SLIMESHUGE:
            case MAGMACUBEHUGE:
            case MAGMACUBESHUGE:
                return new SlimeCreature(mac.getType(), 4);
            default: return new BasicCreature(mac.getType());
        }
    }
}
