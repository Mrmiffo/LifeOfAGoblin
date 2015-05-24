/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.model;

/**
 * The node type enum declares all the possible nods that the author of a level 
 * may put in the level through scene composer. The level node identifier will 
 * use the node type to know which kind of node to create.
 * @author Anton
 */
public enum NodeType {    
    PLAYER("PLAYER", true),
    LEVEL("LEVEL", false),
    MINION("MINION", true),
    BOSS("BOSS", true),
    CHECKPOINT("CHECKPOINT", false),
    SPAWNPOINT("SPAWNPOINT", false),
    GAMEOBJECT("GAMEOBJECT", true), 
    FINALCHECKPOINT("FINALCHECKPOINT", false),
    BOX("BOX", true);
    
    private final String type;
    private final boolean spawnable;
    
    NodeType(String type, boolean spawnable) {
    this.type = type;
    this.spawnable = spawnable;
    }
    
    @Override
    public String toString() {
        return this.type;
    }
    
    public boolean getSpawnable() {
        return this.spawnable;
    }
}