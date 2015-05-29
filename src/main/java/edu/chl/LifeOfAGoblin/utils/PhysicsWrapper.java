/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.utils;

import com.jme3.bullet.BulletAppState;
import com.jme3.bullet.PhysicsTickListener;
import com.jme3.bullet.collision.PhysicsCollisionListener;
import com.jme3.bullet.collision.PhysicsCollisionObject;
import com.jme3.bullet.control.CharacterControl;
import com.jme3.bullet.control.GhostControl;
import com.jme3.bullet.control.PhysicsControl;
import com.jme3.bullet.control.RigidBodyControl;
import com.jme3.scene.control.AbstractControl;
import com.jme3.scene.control.Control;

/**
 *
 * @author fredrik
 */
public class PhysicsWrapper {
    private static PhysicsWrapper instance;
    private BulletAppState bulletAppState;
    
    private PhysicsWrapper() {
        bulletAppState = new BulletAppState();
        StateManagerWrapper.getInstance().activateState(bulletAppState);
    }
        public static synchronized PhysicsWrapper getInstance(){
        if (instance == null) {
            instance = new PhysicsWrapper();
        }
        return instance;
    }
        
    public void add(PhysicsControl control){
        //This check is supposed to be done in jME3 as it accepts any type of object, but if the object is missing the collision shape it will throw an error.
        if ((control instanceof GhostControl && ((GhostControl)control).getCollisionShape() != null) ||
                (control instanceof RigidBodyControl && ((RigidBodyControl)control).getCollisionShape() != null) ||
                    (control instanceof CharacterControl && ((CharacterControl)control).getCollisionShape() != null)){
                        this.bulletAppState.getPhysicsSpace().add(control);
        }

    }

    public void addCollisionListener(PhysicsCollisionListener listener){
        this.bulletAppState.getPhysicsSpace().addCollisionListener(listener);
    }

    public void remove(PhysicsCollisionObject object){
        if(object != null){
            this.bulletAppState.getPhysicsSpace().remove(object);
        }
    }

    public void add(PhysicsTickListener listener){
        this.bulletAppState.getPhysicsSpace().addTickListener(listener);
    }
}