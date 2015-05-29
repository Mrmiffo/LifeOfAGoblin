package edu.chl.LifeOfAGoblin.model.character;

import edu.chl.LifeOfAGoblin.model.AbstractGameObject;
import edu.chl.LifeOfAGoblin.model.NodeType;
import edu.chl.LifeOfAGoblin.model.ICollidable;


/**
 *
 * @author Ulrika
 */
public abstract class Weapon extends AbstractGameObject implements ICollidable {

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
