package com.garbagemule.MobArena.waves.types;

import java.util.*;

import com.garbagemule.MobArena.waves.mob.ArenaCreature;
import org.bukkit.inventory.ItemStack;

import com.garbagemule.MobArena.framework.Arena;
import com.garbagemule.MobArena.waves.AbstractWave;
import com.garbagemule.MobArena.waves.MACreature;
import com.garbagemule.MobArena.waves.enums.WaveType;

public class SupplyWave extends AbstractWave
{
    private SortedMap<Integer,ArenaCreature> monsterMap;
    private List<ItemStack> drops;
    
    public SupplyWave(SortedMap<Integer,ArenaCreature> monsterMap) {
        this.monsterMap = monsterMap;
        this.setType(WaveType.SUPPLY);
    }
    
    @Override
    public Map<ArenaCreature,Integer> getMonstersToSpawn(int wave, int playerCount, Arena arena) {
        // Grab the total probability sum.
        int total = monsterMap.lastKey();
        
        // Random number generator.
        Random random = new Random();
        
        // Prepare the monster map.
        Map<ArenaCreature,Integer> monsters = new HashMap<ArenaCreature,Integer>();

        int toSpawn = (int) Math.max(1D, playerCount * super.getAmountMultiplier());
        
        // Spawn a monster for each player.
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
        
        // Return the map.
        return monsters;
    }
    
    public List<ItemStack> getDropList() {
        return drops;
    }
    
    public void setDropList(List<ItemStack> drops) {
        this.drops = drops;
    }
}
