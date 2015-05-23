/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.model;

import edu.chl.LifeOfAGoblin.jME3.factory.NodeType;
import edu.chl.LifeOfAGoblin.model.abstractClass.AbstractMovableObject;
import edu.chl.LifeOfAGoblin.model.interfaces.ICollidable;

/**
 *
 * @author fredrik
 */
public class Box extends AbstractMovableObject implements ICollidable{
    private float width;
    private float height;
    
    public Box(String modelName){
        super(modelName);
    }
    
    @Override
    public NodeType getNodeType() {
        return NodeType.BOX;
    }

    @Override
    public void collide(ICollidable collided) {
        // add stufzz
    }

    @Override
    public float getCollisionHeight() {
        return this.height;
    }

    @Override
    public float getCollisionWidth() {
        return this.width;
    }
    
}
