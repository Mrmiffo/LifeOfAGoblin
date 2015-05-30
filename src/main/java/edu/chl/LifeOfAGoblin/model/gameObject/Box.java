package edu.chl.LifeOfAGoblin.model.gameObject;

import edu.chl.LifeOfAGoblin.model.ICollidable;

/**
 *
 * @author fredrik
 */
public class Box extends AbstractInanimateObject implements ICollidable{
    private float width;
    private float height;
    
    public Box(String modelName){
        super(modelName);
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
