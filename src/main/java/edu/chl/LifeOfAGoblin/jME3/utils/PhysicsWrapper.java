/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.jME3.utils;

import com.jme3.bullet.BulletAppState;
import com.jme3.bullet.PhysicsTickListener;
import com.jme3.bullet.collision.PhysicsCollisionListener;
import com.jme3.bullet.collision.PhysicsCollisionObject;
import com.jme3.scene.control.Control;

/**
 *
 * @author fredrik
 */
public class PhysicsWrapper {
    private static PhysicsWrapper instance;
    private BulletAppState bulletAppState;
    
    private PhysicsWrapper(){
        bulletAppState  = new BulletAppState();
        StateManagerWrapper.getInstance().addState(bulletAppState);
    }
        public static synchronized PhysicsWrapper getInstance(){
        if (instance == null){
            instance = new PhysicsWrapper();
        }
        return instance;
    }
        public void add(Control control){
            this.bulletAppState.getPhysicsSpace().add(control);
        }
        
        public void addCollisonListener(PhysicsCollisionListener listener){
            this.bulletAppState.getPhysicsSpace().addCollisionListener(listener);
        }
        
        public void remove(Object object){
            this.bulletAppState.getPhysicsSpace().remove(object);
        }
        
        public void add(PhysicsTickListener listener){
            this.bulletAppState.getPhysicsSpace().addTickListener(listener);
        }
}