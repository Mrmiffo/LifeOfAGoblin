/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.model.abstractClass;

import edu.chl.LifeOfAGoblin.jME3.utils.Resources;
import edu.chl.LifeOfAGoblin.model.interfaces.ICollidable;
import edu.chl.LifeOfAGoblin.model.interfaces.IKillable;
import edu.chl.LifeOfAGoblin.model.interfaces.IModeledNode;
import edu.chl.LifeOfAGoblin.model.interfaces.INode;
import edu.chl.LifeOfAGoblin.model.interfaces.ISpawnable;

/**
 *
 * @author Anton
 */
public abstract class AbstractCharacter implements INode, IModeledNode, ICollidable, IKillable, ISpawnable{
    private int health;
    private int maxHealth;
    private String model;
    private float height; //consider what unit to use
    private float width; //along the x-axis
    private float weight;
    private int id; //Necessary?
    //private float mana/energy etc;
    private float baseDamage;
    private float baseArmour;
    //private boolean rangedUnit; should be a seperate class?

    /** 
     * @param model the model texture to load for the character. Must be placed in the assets/model folder.
     * @param health the current health of the character
     * @param maxHealth the max health of the character
     */

    protected AbstractCharacter(String model, int health, int maxHealth) {
        this.model = model;
        this.health = health;
        this.maxHealth = maxHealth;
        Resources.getInstance().loadResource(model, "models");
        
    }
    
    
    @Override
    public String getModelName(){
        return model;
    }
    
    public int getHealth(){
        return health;
    }
    
    public void setHealth(int newHealth){
        health = newHealth;
        if (health <= 0){
            die();
        }
    }
    
    public int getMaxHealth(){
        return maxHealth;
    }
    
    public void setMaxHealth(int newMaxHealth){
        maxHealth = newMaxHealth;
    }
    
    @Override
    public float getHeight() {
        return height;
    }
    
    @Override
    public float getWidth() {
        return width;
    }
    
    public float getWeight() {
        return weight;
    }
    
    public int getID() {
        return id;
    }
    
    public float getBaseDamage() {
        return baseDamage;
    }
    
    public float getBaseArmour() {
        return baseArmour;
    }
    
    
    @Override
    public void Collision() { //Default behaviour. Necessary?
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void die() { //Default behaviour. Necessary?
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
