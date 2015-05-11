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
    private float height;
    private float width;
    private float weight;
    private float baseDamage;
    private float jumpStrength;
    
    /**
     *
     * @param maxHealth the max health of the character.
     * @param model the model texture to load for the character. Must be placed in the assets/model folder.
     * @param height the height of the character.
     * @param width the width (along the X-axis) of the character.
     * @param weight the weight of the character.
     * @param baseDamage the character's unmodified damage.
     * @param jumpStrength the character reaches by jumping.
     */
    protected AbstractCharacter(int maxHealth, String model, float height,
            float width, float weight, float baseDamage, float jumpStrength) {
        
        this.health = maxHealth; //everything has full health when created
        this.maxHealth = maxHealth;
        this.model = model;
        this.height = height;
        this.width = width;
        this.weight = weight;
        this.baseDamage = baseDamage;
        this.jumpStrength = jumpStrength;
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
    
    public float getBaseDamage() {
        return baseDamage;
    }
    
    public float getJumpStrength() {
        return jumpStrength;
    }
    
    
    /**
     * The default behaviour of a character when colliding with something
     */
    @Override
    public void Collision() {
        //TODO add implementation (if necessary)
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * The default operation when a character dies.
     */
    @Override
    public void die() {
        //TODO add implementation (if necessary)
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
