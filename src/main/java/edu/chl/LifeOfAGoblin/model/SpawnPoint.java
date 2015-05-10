/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.model;

import edu.chl.LifeOfAGoblin.jME3.factory.NodeType;
import edu.chl.LifeOfAGoblin.model.abstractClass.AbstractCharacter;
import edu.chl.LifeOfAGoblin.model.abstractClass.AbstractGameObject;
import edu.chl.LifeOfAGoblin.model.abstractClass.AbstractNPC;
import edu.chl.LifeOfAGoblin.model.interfaces.ICollidable;
import edu.chl.LifeOfAGoblin.model.interfaces.INode;

/**
 * 
 * @author fredrik
 */
public class SpawnPoint implements INode, ICollidable {
    int amount;
    AbstractNPC type;
    private boolean activated;
    private AbstractGameObject parent;
    private float height;
    private float width;
    private Level level;

    public SpawnPoint(int amount, AbstractNPC type, AbstractGameObject 
            parent, Level level){
        this.activated = false;
        this.parent = parent;
        this.amount = amount;
        this.type = type;
        this.height = parent.getModelShapeHeight;
        this.width = parent.getModelShapeWidth;
        this.level = level;
        
    }
   
        public SpawnPoint(int amount, AbstractNPC type, AbstractGameObject 
            parent, float height, float width, Level level){
        this.activated = false;
        this.parent = parent;
        this.amount = amount;
        this.type = type;
        this.activated = false;
        this.parent = parent;
        this.height = height;
        this.width = width;
        this.level = level;
        
    }
    
    
    /**
     * sets wheter or not this spawnpoint has been activated
     * in this game.
     * @param isActivated true if the player has collided with this 
     * spawnpoint during this game.
     */
    public void setActivated(boolean isActivated){
        this.activated = isActivated;
    }
    
    @Override
    public NodeType getNodeType() {
        return NodeType.CHECKPOINT;
    }
    
    public AbstractGameObject getParent(){
        return this.parent;
    }
    
    @Override
    public float getWidth(){
        return this.width;
    }
    
    @Override
    public float getHeight(){
        return this.height;
        
    }
    /**
     * is called when a player collides with the Spawnpoint. Tells progress
     * to update itself if neccesary and sets activated to true
     */
    @Override
    public void Collision(){
        
        this.level.Spawn(amount, type);
        System.out.println("spawnpoint");
        setActivated(true);
    }
    
}
