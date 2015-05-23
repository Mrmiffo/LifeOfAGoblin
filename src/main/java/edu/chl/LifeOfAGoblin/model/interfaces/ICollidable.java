/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.model.interfaces;

/**
 * Interface for collidable objects. Has methods for colliding and
 * for getting the height and width of the collision area.
 * @author Ulrika Uddeborg
 */
public interface ICollidable extends INode {
    /**
     * Is called when another ICollidable collides with this object. 
     */
    public void collide(ICollidable collided);
    
    /**
     * Returns the height of the implementor's model.
     * @return the height of the model
     */
    public float getCollisionHeight();
    
    /**
     * Returns the width of the implementor's model.
     * @return the width of the model.
     */
    public float getCollisionWidth();
}
