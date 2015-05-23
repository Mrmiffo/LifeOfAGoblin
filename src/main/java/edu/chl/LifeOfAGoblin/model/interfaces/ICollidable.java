package edu.chl.LifeOfAGoblin.model.interfaces;

/**
 * Interface for Collidable objects, objects implementing this interface 
 * have methods describing what happens when it collides with another 
 * ICollidable
 * @author fredrik
 */
public interface ICollidable extends INode{
    /**
     * is Called when another ICollidable collides with this object. 
     */
    public void collide(ICollidable collided);
}
