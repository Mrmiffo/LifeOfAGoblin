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
public class Physics {
    private static Physics instance;
    private BulletAppState bulletAppState = new BulletAppState();
    
    
    
    private Physics(){
        
    }
    
    public static synchronized Physics getInstance(){
        if (instance == null){
            instance = new Physics();
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
