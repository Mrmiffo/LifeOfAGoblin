/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.jME3.controller;

import com.jme3.bullet.collision.PhysicsCollisionEvent;
import com.jme3.bullet.collision.PhysicsCollisionListener;
import com.jme3.scene.Spatial;
import edu.chl.LifeOfAGoblin.model.character.AbstractNPC;
import edu.chl.LifeOfAGoblin.model.ICollidable;
import edu.chl.LifeOfAGoblin.model.INode;

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
        Spatial nodeA = pce.getNodeA();
        Spatial nodeB = pce.getNodeB();
        
        if (nodeA.getControl(ModelControl.class) != null
                && nodeB.getControl(ModelControl.class) != null) {
            
            INode modelA = nodeA.getControl(ModelControl.class).getModel();
            INode modelB = nodeB.getControl(ModelControl.class).getModel();
            
            if (modelA instanceof ICollidable && modelB instanceof ICollidable) {
                /*if (modelA instanceof AbstractNPC) {
                    nodeA.getControl(NPCCollisionControl.class).updateCollisionInfo(nodeA, nodeB);
                } else if (modelB instanceof AbstractNPC) {
                    nodeB.getControl(NPCCollisionControl.class).updateCollisionInfo(nodeB, nodeA);
                }*/

                ((ICollidable)modelA).collide((ICollidable)modelB);
                ((ICollidable)modelB).collide((ICollidable)modelA);
            }
        }
    }
}
