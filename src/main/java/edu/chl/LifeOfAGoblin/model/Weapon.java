/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.model;

import edu.chl.LifeOfAGoblin.jME3.factory.NodeType;
import edu.chl.LifeOfAGoblin.model.interfaces.ICollidable;
import edu.chl.LifeOfAGoblin.model.interfaces.INode;

/**
 *
 * @author Ulrika
 */
public abstract class Weapon implements INode, ICollidable {

    private float collisionHeight;
    private float collisionWidth;
    private float range;
    
    public Weapon(float collisionHeight, float collisionWidth, float range) {
        this.collisionHeight = collisionHeight;
        this.collisionWidth = collisionWidth;
        this.range = range; //collsionWidth == range?
    }
    
    @Override
    public NodeType getNodeType() {
        return NodeType.WEAPON;
    }

    @Override
    public void collide(ICollidable collided) {
        //Implement relevant stuff here, if any
    }

    @Override
    public float getCollisionHeight() {
        return collisionHeight;
    }

    @Override
    public float getCollisionWidth() {
        return collisionWidth;
    }
    
}
