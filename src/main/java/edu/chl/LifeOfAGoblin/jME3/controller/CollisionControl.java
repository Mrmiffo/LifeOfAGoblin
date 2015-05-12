/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.jME3.controller;

import com.jme3.bullet.collision.PhysicsCollisionEvent;
import com.jme3.bullet.collision.PhysicsCollisionListener;
import com.jme3.bullet.collision.shapes.BoxCollisionShape;
import com.jme3.bullet.control.GhostControl;
import com.jme3.math.Vector3f;
import edu.chl.LifeOfAGoblin.jME3.utils.PhysicsWrapper;
import edu.chl.LifeOfAGoblin.model.interfaces.ICollidable;

/**
 *
 * @author Fredrik
 * A class that represents a control that listens to collisions with a player 
 * and itself and notifies the collisionObject object associated with the node 
 * this is added on. 
 */
public class CollisionControl extends GhostControl implements PhysicsCollisionListener {
    private ICollidable collisionObject;
    
/**
 * Creates a CollisionControl. 
 * @param collisionObject the collisionObject object associated with the node this is 
 * added on.
 */
    public CollisionControl(ICollidable collisionObject){
        this.collisionObject = collisionObject;
        PhysicsWrapper.getInstance().addCollisonListener(this);
        Vector3f halfExtent = new Vector3f(collisionObject.getWidth()/2,collisionObject.getHeight()/2, 1);
        BoxCollisionShape box = new BoxCollisionShape(halfExtent);
        this.setCollisionShape(box);
    }

    @Override
    public void collision(PhysicsCollisionEvent pce) {
        if(pce.getNodeA().getUserData("NodeType").equals("Player")){ //not working atm
            this.collisionObject.collide();
          }
    }
     
}
