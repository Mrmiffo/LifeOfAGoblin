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
import com.jme3.scene.Node;
import com.jme3.scene.control.AbstractControl;
import edu.chl.LifeOfAGoblin.model.Checkpoint;
import edu.chl.LifeOfAGoblin.model.Player;
import edu.chl.LifeOfAGoblin.model.Spawnpoint;
import edu.chl.LifeOfAGoblin.model.abstractClass.AbstractCollisionObject;
import edu.chl.LifeOfAGoblin.model.abstractClass.AbstractNPC;
import edu.chl.LifeOfAGoblin.model.interfaces.ICollidable;
import edu.chl.LifeOfAGoblin.model.interfaces.INode;

/**
 * A class that represents a control that listens to collisions with a player 
 * and an ICollidable and runs collide in the ICollidable
 * if all requirements are fulfilled.
 */
public class CollisionObjectListener extends AbstractControl implements PhysicsCollisionListener , 
        PhysicsCollisionGroupListener {
    
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
        if (pce.getNodeA().getUserDataKeys().contains("nodeType")) {
            if (collide(pce.getObjectA(), pce.getObjectB())) {
                doCollision((Node)pce.getNodeA(), (Node)pce.getNodeB());
            }
        }
        
        if (pce.getNodeB().getUserDataKeys().contains("nodeType")) {
            if (collide(pce.getObjectB(), pce.getObjectA())) {
                doCollision((Node)pce.getNodeB(), (Node)pce.getNodeA());
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
        if (pco.getCollideWithGroups() > 1 || pco1.getCollisionGroup() > 1) {        
            if (pco.getCollideWithGroups() == (pco1.getCollisionGroup()) || pco1.getCollideWithGroups() == (pco.getCollisionGroup())){
                return true;
            }
        }
        return false;
    }
    
    public void doCollision(Node current, Node collided) {
        INode model = current.getControl(ModelControl.class).getModel();
        
        if (model instanceof ICollidable) {
            ICollidable collModel = (ICollidable)model;
            collModel.collide();
        }
                
         if (model instanceof AbstractNPC) {
             INode collidedModel = collided.getControl(ModelControl.class).getModel();
             if (collidedModel.getClass() == Player.class) {
                 Player pCollidedModel = (Player)collidedModel;
                 if (!pCollidedModel.getIsDamaged()) {
                     pCollidedModel.collide((AbstractNPC)model);
                 }
             }
         }
    }

    @Override
    protected void controlUpdate(float f) {
    }

    @Override
    protected void controlRender(RenderManager rm, ViewPort vp) {
    }
     
}
