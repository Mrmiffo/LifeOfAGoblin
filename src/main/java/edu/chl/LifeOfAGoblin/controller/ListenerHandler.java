/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.controller;

import com.jme3.input.InputManager;
import com.jme3.input.controls.KeyTrigger;
import com.jme3.scene.control.AbstractControl;
import edu.chl.LifeOfAGoblin.utils.KeyBind;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author kakan
 */
public class ListenerHandler {
    private static ListenerHandler instance;
    private Map<String, Set<AbstractControl>> controls = new HashMap<>();
    private InputManager inputManager;
    
    private ListenerHandler(){
        inputManager.addListener(new PlayerMoveControl(), "walkRight", "walkLeft", "jump");
        
        
    }

    public static synchronized ListenerHandler getInstance(){
        if (instance == null){
            instance = new ListenerHandler();
        }
        return instance;
    }
    
    public void addControl(String name, AbstractControl control){
        Set<AbstractControl> previousControls = controls.get(name);
        previousControls.add(control);
        controls.put(name, previousControls);
    }
    
    public void removeControl(String name, AbstractControl control){
        Set<AbstractControl> previousControls = controls.get(name);
        previousControls.remove(control);
        controls.put(name, previousControls);
    }
    
    public Set<? extends AbstractControl> getResources(String name){
        return controls.get(name);
    }
    
}
