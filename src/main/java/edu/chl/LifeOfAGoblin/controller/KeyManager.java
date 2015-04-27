/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.controller;

import com.jme3.input.controls.InputListener;
import com.jme3.scene.control.AbstractControl;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author kakan
 */
public class KeyManager {
    private static KeyManager instance;
    private Map<InputListener, String[]> mapping = new HashMap<>();
    private Map<String, Map<InputListener, String[]>> keyControls = new HashMap<>();
    
    private KeyManager(){
        
    }

    public static synchronized KeyManager getInstance(){
        if (instance == null){
            instance = new KeyManager();
        }
        return instance;
    }
    
    public void addKeyControl(String name, InputListener listener, String... mappingnames){
        mapping.put(listener, mappingnames);
        keyControls.put(name, mapping);
    }
    
    public Map<InputListener, String[]> getResources(String name){
        return keyControls.get(name);
    }
    
}
