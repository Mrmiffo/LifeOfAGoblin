package edu.chl.LifeOfAGoblin.model.interfaces;

import edu.chl.LifeOfAGoblin.jME3.factory.NodeType;

/**
 * An interface for SpawnControls, exists mainly to keep model clean. 
 * Objects implementing this interface can spawn spawnables
 * @author fredrik
 */
public interface ISpawnControl {
    /**
     * Spawns a number of a specified type of spawnables at a spawnpoint
     * @param amount The number of spawnables to spawn
     * @param type The type of spawnables to spawn
     */
    public void spawn(int amount, NodeType type);
}
