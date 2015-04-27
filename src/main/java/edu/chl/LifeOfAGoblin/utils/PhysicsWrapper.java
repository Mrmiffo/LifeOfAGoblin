/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.utils;

import com.jme3.bullet.BulletAppState;
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
        public BulletAppState getBulletAppState(){
            return this.bulletAppState;
        }
    
    
    
}
