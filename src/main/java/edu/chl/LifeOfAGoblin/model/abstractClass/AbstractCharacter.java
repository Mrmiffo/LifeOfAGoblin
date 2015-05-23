/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.model.abstractClass;

import edu.chl.LifeOfAGoblin.jME3.utils.Resources;
import edu.chl.LifeOfAGoblin.model.interfaces.ICollidable;
import edu.chl.LifeOfAGoblin.model.interfaces.IKillable;
import edu.chl.LifeOfAGoblin.model.interfaces.IModeledNode;
import edu.chl.LifeOfAGoblin.archive.ISpawnable;
import edu.chl.LifeOfAGoblin.jME3.controller.AbstractMoveControl;

/**
 * The abstraction of any character. 
 * @author Anton
 */
public abstract class AbstractCharacter extends AbstractGameObject implements IModeledNode, ICollidable, IKillable, ISpawnable{
    
    private AbstractMoveControl amc;
    private int health;
    private int maxHealth;
    private String model;
    private float height;
    private float width;
    private float collisionHeight;
    private float collisionWidth;
    private float weight;
    private float baseDamage;
    private float jumpStrength;
    private boolean isDead = false;
    
    /**
     * Default constructor for the abstract character. To be called by subclasses
     * to populate needed values. Also tells the Resource class to load needed model. 
     * This reduce the need of loading resources from harddrive during gameplay.
     * @param amc the controller of the character's movement.
     * @param collisionGroup which group of collidable object 
     * @param maxHealth the max health of the character.
     * @param model the model texture to load for the character. Must be placed in the assets/model folder.
     * @param height the height of the character.
     * @param width the width (along the X-axis) of the character.
     * @param weight the weight of the character.
     * @param baseDamage the character's unmodified damage.
     * @param jumpStrength the character reaches by jumping.
     */
    protected AbstractCharacter(AbstractMoveControl amc,
            int maxHealth, String model, float height, float width,
            float collisionHeight, float collisionWidth, float weight,
            float baseDamage, float jumpStrength) {
        
        this.amc = amc;
        this.health = maxHealth; //everything has full health when created
        this.maxHealth = maxHealth;
        this.model = model;
        this.height = height;
        this.width = width;
        this.collisionHeight = collisionHeight;
        this.collisionWidth = collisionWidth;
        this.weight = weight;
        this.baseDamage = baseDamage;
        this.jumpStrength = jumpStrength;
        Resources.getInstance().loadResource(model, "models");
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public String getModelName(){
        return model;
    }
    
    /**
     * Returns the controller of the character's movement.
     * @return the controller of the character's movement.
     */
    public AbstractMoveControl getAbstractMoveControl() {
        return amc;
    }
        
     /**
     * Returns the current health of the character.
     * @return the health of the character.
     */
    public int getHealth(){
        return health;
    }
    
    /**
     * Sets the character health. If the newHealth <= 0, the die()-method is invoked.
     * @param newHealth 
     */
    public void setHealth(int newHealth){
        health = newHealth;
        if (health <= 0){
            die();
        }
    }
    
    /**
     * Decreases the character's health with 1. If the health becomes
     * equal to 0 the character dies. 
     */
    public void decreaseHealth() {
        if (health > 0) {
            health -= 1;
        }
        
        if (health == 0) {
            this.die();
        }
    }
    
    /**
     * Decreases the character's health with a specified amount. If the health becomes
     * equal to or below 0 the character dies. 
     * @param change the amount to decrease
     */
    public void decreaseHealth(int change) {
        health -= change;
        if (health <= 0) {
            health = 0;
            this.die();
        }
    }
    
    /**
     * Increases the character's health with 1.
     */
    public void increaseHealth() {
        if (health < maxHealth) {
            health += 1;
        }
    }
    
    /**
     * Increases the character's health with a specified amount.
     * @param change the amount to decrease
     */
    public void increaseHealth(int change) {
        health += change;
        if (health > maxHealth) {
            health = maxHealth;
        }
    }
    
    /**
     * Returns the max health of the character.
     * @return the character max health.
     */
    public int getMaxHealth(){
        return maxHealth;
    }
    
    /**
     * Method to set the max health.
     * @param newMaxHealth The nex max health of the character.
     */
    public void setMaxHealth(int newMaxHealth){
        maxHealth = newMaxHealth;
    }
    
    /**
     * Returns the height of the object's model.
     * @return the height of the model
     */
    public float getHeight() {
        return height;
    }
    
    /**
     * Returns the width of the object's model.
     * @return the width of the model.
     */
    public float getWidth() {
        return width;
    }
    
    /**
     * Returns the weight of the character. Used in the physics engine.
     * @return the weight of the character.
     */
    public float getWeight() {
        return weight;
    }
    
    /**
     * Returns the base damage for the character. Used when calculating the 
     * damage it does to other character.
     * @return the base damage of the character.
     */
    public float getBaseDamage() {
        return baseDamage;
    }
    
    /**
     * Returns the jump strength of the character. Used by the physics engine.
     * @return the jump strength of the character.
     */
    public float getJumpStrength() {
        return jumpStrength;
    }
    
    /**
     * The default behaviour of a character when colliding with something
     */
    @Override
    public void collide(ICollidable collided) {
        //TODO add implementation (if necessary)  
    }

    @Override
    public float getCollisionHeight() {
        return collisionHeight;
    }
    
    @Override
    public float getCollisionWidth() {
        return collisionWidth;
    }
    
    /**
     * The default operation when a character dies.
     */
    @Override
    public void die() {
        this.isDead = true;
        //animator.runDeathAnimation()  this is what these are actually good for
    }
    
    /**
     * {@inheritDoc} 
     */
    @Override
    public void setIsDead(boolean isDead){
        this.isDead = isDead;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isDead(){
        return this.isDead;
    }
}
