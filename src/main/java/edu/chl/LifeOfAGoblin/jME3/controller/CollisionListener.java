/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.jME3.controller;

import com.jme3.bullet.collision.PhysicsCollisionEvent;
import com.jme3.bullet.collision.PhysicsCollisionListener;
import com.jme3.scene.Spatial;
import edu.chl.LifeOfAGoblin.model.abstractClass.AbstractNPC;
import edu.chl.LifeOfAGoblin.model.interfaces.ICollidable;
import edu.chl.LifeOfAGoblin.model.interfaces.INode;

/**
 * A class that represents a control that listens to all occured collisions.
 */
public class CollisionListener implements PhysicsCollisionListener {
    
/**
 * runs collide in the abstractCollisonobject if the collision was between it
 * and a player and if it has not yet been activated if that is a requirement.
 * @param pce the physicsCollisionEvent
 */
    @Override
    public void collision(PhysicsCollisionEvent pce) {
        if (pce.getNodeA().getUserDataKeys().contains("nodeType")) {
            doCollision(pce.getNodeA(), pce.getNodeB());
        }
        
        if (pce.getNodeB().getUserDataKeys().contains("nodeType")) {
            doCollision(pce.getNodeB(), pce.getNodeA());
        }
    }
    
    /**
     * Checks that both objects can collide and tells the current object to collide
     * with the colliding object.
     * @param current
     * @param collided 
     */
    
    private void doCollision(Spatial current, Spatial collided) {
        if (collided.getControl(ModelControl.class) == null){
            return;
        }
        INode model = current.getControl(ModelControl.class).getModel();
        INode collidedModel = collided.getControl(ModelControl.class).getModel();
        
        if (model instanceof AbstractNPC) {
            current.getControl(NPCCollisionControl.class).updateCollisionInfo(current, collided);
        }
        
        if (model instanceof ICollidable && collidedModel instanceof ICollidable) {
            ICollidable cModel = (ICollidable)model;
            ICollidable cCollidedModel = (ICollidable)collidedModel;
            cModel.collide(cCollidedModel);
        }
    }     
}
