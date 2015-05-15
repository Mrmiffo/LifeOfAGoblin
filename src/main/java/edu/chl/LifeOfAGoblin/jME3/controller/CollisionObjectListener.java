/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.jME3.controller;

import com.jme3.bullet.collision.PhysicsCollisionEvent;
import com.jme3.bullet.collision.PhysicsCollisionGroupListener;
import com.jme3.bullet.collision.PhysicsCollisionListener;
import com.jme3.bullet.collision.PhysicsCollisionObject;
import com.jme3.bullet.collision.shapes.BoxCollisionShape;
import com.jme3.bullet.control.GhostControl;
import com.jme3.math.Vector3f;
import com.jme3.renderer.RenderManager;
import com.jme3.renderer.ViewPort;
import com.jme3.scene.Node;
import com.jme3.scene.control.AbstractControl;
import edu.chl.LifeOfAGoblin.model.abstractClass.AbstractCollisionObject;

/**
 *
 * @author Fredrik
 * A class that represents a control that listens to collisions with a player 
 * and itself and notifies the collisionObject associated with the node 
 * this is added on. 
 */
public class CollisionObjectListener extends AbstractControl implements PhysicsCollisionListener , 
        PhysicsCollisionGroupListener{
    private AbstractCollisionObject collisionObject;
    
/**
 * Creates a CollisionObjectListener. 
 * 
 */
    public CollisionObjectListener(){
        
    }

    @Override
    public void collision(PhysicsCollisionEvent pce) {
    if(pce.getNodeB().getUserDataKeys().size() > 0){
        if(collide(pce.getObjectA(), pce.getObjectB())){
            if(pce.getNodeB().getUserData("nodeType").equals("CHECKPOINT") || pce.getNodeB().getUserData("nodeType").equals("SPAWNPOINT")){
                if(!((AbstractCollisionObject)pce.getNodeB().getControl(ModelControl.class).getModel()).getIsActivated()){
                    ((AbstractCollisionObject)pce.getNodeB().getControl(ModelControl.class).getModel()).collide();
                }
            }
         }
      }
//    if(pce.getNodeB().getUserDataKeys().size() > 0){
//        System.out.println(pce.getNodeA().getParent().getUserData("nodeType"));
//        System.out.println(pce.getNodeB().getUserData("nodeType"));
//        System.out.println(this.collisionObject.getNodeType().toString());
//        if(pce.getNodeA().getParent().getUserData("nodeType").equals("PLAYER")
//                && pce.getNodeB().getUserData("nodeType").equals(this.collisionObject.getNodeType().toString())){
//            if(!this.collisionObject.getIsActivated()){
//                this.collisionObject.collide();
         //   }
       // }
    //}
    }

    @Override
    public boolean collide(PhysicsCollisionObject pco, PhysicsCollisionObject pco1) {
        if(pco.getCollideWithGroups() == (pco1.getCollisionGroup()) || pco1.getCollideWithGroups() == (pco.getCollisionGroup())){
            return true;
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
