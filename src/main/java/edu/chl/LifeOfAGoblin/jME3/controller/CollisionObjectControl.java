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
import edu.chl.LifeOfAGoblin.model.abstractClass.AbstractCollisionObject;

/**
 *
 * @author Fredrik
 * A class that represents a control that listens to collisions with a player 
 * and itself and notifies the collisionObject associated with the node 
 * this is added on. 
 */
public class CollisionObjectControl extends GhostControl implements PhysicsCollisionListener {
    private AbstractCollisionObject collisionObject;
    
/**
 * Creates a CollisionObjectControl. 
 * @param collisionObject the collisionObject object associated with the node this is 
 * added on.
 */
    public CollisionObjectControl(AbstractCollisionObject collisionObject){
        this.collisionObject = collisionObject;
        PhysicsWrapper.getInstance().addCollisonListener(this);
        Vector3f halfExtent = new Vector3f(collisionObject.getWidth(),collisionObject.getHeight(), 1);
        BoxCollisionShape box = new BoxCollisionShape(halfExtent);
        this.setCollisionShape(box);
    }

    @Override
    public void collision(PhysicsCollisionEvent pce) {
//        if(pce.getNodeA().getUserData("NodeType").equals("Player")){ //not working atm
       //     if(!this.collisionObject.getIsActivated()){
         //       this.collisionObject.collide();
          //  }
      //    }
    }
     
}
