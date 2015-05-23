package edu.chl.LifeOfAGoblin.model;

import edu.chl.LifeOfAGoblin.jME3.factory.NodeType;
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
    public float getHeight() {
        return this.height;
    }

    @Override
    public float getWidth() {
        return this.width;
    }

    @Override
    public void collide(ICollidable collided) {
        // add stufzz
    }
    
}
