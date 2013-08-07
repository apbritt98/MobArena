package com.garbagemule.MobArena.waves.types;

import java.util.*;

import com.garbagemule.MobArena.framework.Arena;
import com.garbagemule.MobArena.waves.AbstractWave;
import com.garbagemule.MobArena.waves.MACreature;
import com.garbagemule.MobArena.waves.enums.*;
import com.garbagemule.MobArena.waves.mob.ArenaCreature;

public class DefaultWave extends AbstractWave
{
    private SortedMap<Integer,ArenaCreature> monsterMap;
    private WaveGrowth growth;
    private boolean fixed;
    
    public DefaultWave(SortedMap<Integer,ArenaCreature> monsterMap) {
        this.monsterMap = monsterMap;
        this.growth = WaveGrowth.OLD;
        this.setType(WaveType.DEFAULT);
    }
    
    @Override
    public Map<ArenaCreature,Integer> getMonstersToSpawn(int wave, int playerCount, Arena arena) {
        if (fixed) return getFixed();

        // Get the amount of monsters to spawn.
        int toSpawn = (int) Math.max(1D, growth.getAmount(wave, playerCount) * super.getAmountMultiplier());
        
        // Grab the total probability sum.
        int total = monsterMap.lastKey();
        
        // Random number generator.
        Random random = new Random();
        
        // Prepare the monster map.
        Map<ArenaCreature,Integer> monsters = new HashMap<ArenaCreature,Integer>();

        // Generate some random amounts.
        for (int i = 0; i < toSpawn; i++) {
            int value = random.nextInt(total) + 1;
            
            for (Map.Entry<Integer,ArenaCreature> entry : monsterMap.entrySet()) {
                if (value > entry.getKey()) {
                    continue;
                }
                
                Integer current = monsters.get(entry.getValue());
                monsters.put(entry.getValue(), (current == null ? 1 : current + 1));
                break;
            }
        }
        //TODO: Remember amount-multiplier.
        // Return the map.
        return monsters;
    }

    private Map<ArenaCreature,Integer> getFixed() {
        Map<ArenaCreature,Integer> result = new HashMap<ArenaCreature,Integer>();

        // For fixed waves, we just convert the accumulated map
        int last = 0;
        for (Map.Entry<Integer,ArenaCreature> entry : monsterMap.entrySet()) {
            int prob = entry.getKey();
            result.put(entry.getValue(), prob - last);
            last = prob;
        }

        return result;
    }
    
    public WaveGrowth getGrowth() {
        return growth;
    }
    
    public void setGrowth(WaveGrowth growth) {
        this.growth = growth;
        this.fixed = false;
    }

    public boolean isFixed() {
        return fixed;
    }

    public void setFixed(boolean fixed) {
        this.fixed = fixed;
    }
}
