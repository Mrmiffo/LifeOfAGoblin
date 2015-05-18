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
import edu.chl.LifeOfAGoblin.model.Player;
import edu.chl.LifeOfAGoblin.model.abstractClass.AbstractCollisionObject;
import edu.chl.LifeOfAGoblin.model.abstractClass.AbstractNPC;

/**
 *
 * @author Fredrik
 * A class that represents a control that listens to collisions with a player 
 * and an ICollidable and runs collide in the ICollidable
 * if all requirements are fulfilled.
 */
public class CollisionObjectListener extends AbstractControl implements PhysicsCollisionListener , 
        PhysicsCollisionGroupListener{
    
/**
 * Creates a CollisionObjectListener. 
 */
    public CollisionObjectListener(){
        
    }
/**
 * runs collide in the abstractCollisonobject if the collision was between it
 * and a player and if it has not yet been activated if that is a requirement.
 * @param pce the physicsCollisionEvent
 */
    @Override
    public void collision(PhysicsCollisionEvent pce) {
        if(pce.getNodeB().getUserDataKeys().contains("nodeType")){
            if(collide(pce.getObjectA(), pce.getObjectB())){
                if(pce.getNodeB().getControl(ModelControl.class).getModel() instanceof AbstractCollisionObject)
                if(!((AbstractCollisionObject)pce.getNodeB().getControl(ModelControl.class).getModel()).getIsActivated()){
                        ((AbstractCollisionObject)pce.getNodeB().getControl(ModelControl.class).getModel()).collide();
                    }
                
                if(pce.getNodeB().getControl(ModelControl.class).getModel() instanceof AbstractNPC){
                    ((Player)pce.getNodeA().getControl(ModelControl.class).getModel()).collide((AbstractNPC) pce.getNodeB().getControl(ModelControl.class).getModel());
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
