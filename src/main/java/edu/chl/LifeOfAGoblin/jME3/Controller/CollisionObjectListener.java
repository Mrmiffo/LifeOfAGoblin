/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.jME3.controller;

import com.jme3.bullet.collision.PhysicsCollisionEvent;
import com.jme3.bullet.collision.PhysicsCollisionGroupListener;
import com.jme3.bullet.collision.PhysicsCollisionListener;
import com.jme3.bullet.collision.PhysicsCollisionObject;
import com.jme3.renderer.RenderManager;
import com.jme3.renderer.ViewPort;
import com.jme3.scene.control.AbstractControl;
import edu.chl.LifeOfAGoblin.model.abstractClass.AbstractCollisionObject;

/**
 *
 * @author Fredrik
 * A class that represents a control that listens to collisions with a player 
 * and an AbstractcollisionObject and runs collide in the abstractCollisonObject
 * if it has not yet been activated
 */
public class CollisionObjectListener extends AbstractControl implements PhysicsCollisionListener , 
        PhysicsCollisionGroupListener{
    
/**
 * Creates a CollisionObjectListener. 
 */
    public CollisionObjectListener(){
        
    }
/**
 * runs collide in the abstractCollisonobject if the collision wasd between it
 * and a player and if it has not yet been activated.
 * @param pce the physicsCollisionEvent
 */
    @Override
    public void collision(PhysicsCollisionEvent pce) {
    if(pce.getNodeB().getUserDataKeys().size() > 0){
        if(collide(pce.getObjectA(), pce.getObjectB())){
            if(pce.getNodeB().getUserData("nodeType").equals("CHECKPOINT") || pce.getNodeB().getUserData("nodeType").equals("SPAWNPOINT") || pce.getNodeB().getUserData("nodeType").equals("FINALCHECKPOINT")){
                if(!((AbstractCollisionObject)pce.getNodeB().getControl(ModelControl.class).getModel()).getIsActivated()){
                    ((AbstractCollisionObject)pce.getNodeB().getControl(ModelControl.class).getModel()).collide();
                }
            }
         }
      }
    }
/**
 * checks if the two collisionobjects are set to collide with eachother
 * @param pco the first collisionObject
 * @param pco1 the second collisionObject
 * @return true if they are set to collide with eachother, false otherwise.
 */
    @Override
    public boolean collide(PhysicsCollisionObject pco, PhysicsCollisionObject pco1) {
        if(pco.getCollideWithGroups() > 1 || pco1.getCollisionGroup() > 1){        
            if(pco.getCollideWithGroups() == (pco1.getCollisionGroup()) || pco1.getCollideWithGroups() == (pco.getCollisionGroup())){
             //  System.out.println("pco är " + pco.getCollideWithGroups());
               // System.out.println("pco1 är " + pco1.getCollideWithGroups());

                return true;
            }
        }
        return false;
    }

    @Override
    protected void controlUpdate(float f) {
    }

    @Override
    protected void controlRender(RenderManager rm, ViewPort vp) {
    }
     
}
