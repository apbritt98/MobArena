package com.garbagemule.MobArena.waves.types;

import java.util.*;

import com.garbagemule.MobArena.framework.Arena;
import com.garbagemule.MobArena.waves.AbstractWave;
import com.garbagemule.MobArena.waves.MACreature;
import com.garbagemule.MobArena.waves.enums.WaveType;
import com.garbagemule.MobArena.waves.mob.ArenaCreature;

public class SpecialWave extends AbstractWave
{
    private SortedMap<Integer,ArenaCreature> monsterMap;

    public SpecialWave(SortedMap<Integer,ArenaCreature> monsterMap) {
        this.monsterMap = monsterMap;
        this.setType(WaveType.SPECIAL);
    }
    
    @Override
    public Map<ArenaCreature,Integer> getMonstersToSpawn(int wave, int playerCount, Arena arena) {
        // Random number.
        Random random = new Random();
        int value = random.nextInt(monsterMap.lastKey()); 

        // Prepare the monster map.
        Map<ArenaCreature,Integer> result = new HashMap<ArenaCreature,Integer>();

        for (Map.Entry<Integer,ArenaCreature> entry : monsterMap.entrySet()) {
            if (value > entry.getKey()) {
                continue;
            }

            int amount = (int) Math.max(1D, (playerCount + 1) * super.getAmountMultiplier());
            result.put(entry.getValue(), amount);
            break;
        }
        
        return result;
    }
}
