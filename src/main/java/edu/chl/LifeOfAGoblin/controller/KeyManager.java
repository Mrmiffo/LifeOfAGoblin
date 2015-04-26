/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.controller;

import com.jme3.scene.control.AbstractControl;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author kakan
 */
public class KeyManager {
    private static KeyManager instance;
    private Map<String, AbstractControl> keyControls = new HashMap<>();
    
    private KeyManager(){
        
    }

    public static synchronized KeyManager getInstance(){
        if (instance == null){
            instance = new KeyManager();
        }
        return instance;
    }
    
    public void addKeyControl(String name, AbstractControl control){
        keyControls.put(name, control);
    }
    
    public AbstractControl getResources(String name){
        return keyControls.get(name);
    }
    
}
