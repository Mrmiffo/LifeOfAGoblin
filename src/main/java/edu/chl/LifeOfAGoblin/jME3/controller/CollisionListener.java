package edu.chl.LifeOfAGoblin.jME3.controller;

import com.jme3.bullet.collision.PhysicsCollisionEvent;
import com.jme3.bullet.collision.PhysicsCollisionListener;
import com.jme3.scene.Spatial;
import edu.chl.LifeOfAGoblin.model.ICollidable;
import edu.chl.LifeOfAGoblin.model.INode;

/**
 * A class that listens to all occured collisions.
 */
public class CollisionListener implements PhysicsCollisionListener {
    
    /**
     * Runs the collide method if the two objects that collided were ICollidables.
     * @param pce the PhysicsCollisionEvent sent from the physics space
     */
    @Override
    public void collision(PhysicsCollisionEvent pce) { 
        Spatial nodeA = pce.getNodeA();
        Spatial nodeB = pce.getNodeB();
        
        if (nodeA.getControl(ModelControl.class) != null
                && nodeB.getControl(ModelControl.class) != null) {
            
            INode modelA = nodeA.getControl(ModelControl.class).getModel();
            INode modelB = nodeB.getControl(ModelControl.class).getModel();
            
            if (modelA instanceof ICollidable && modelB instanceof ICollidable) {

                ((ICollidable)modelA).collide((ICollidable)modelB);
                ((ICollidable)modelB).collide((ICollidable)modelA);
            }
        }
    }
}
