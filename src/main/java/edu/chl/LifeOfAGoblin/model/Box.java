package edu.chl.LifeOfAGoblin.model;

import edu.chl.LifeOfAGoblin.archive.AbstractMovableObject;
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
