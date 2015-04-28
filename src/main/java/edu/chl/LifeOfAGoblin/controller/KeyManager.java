/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.controller;

import com.jme3.input.InputManager;
import com.jme3.input.controls.ActionListener;
import com.jme3.input.controls.KeyTrigger;
import edu.chl.LifeOfAGoblin.utils.KeyBindings;

/**
 *
 * @author kakan
 */
public class KeyManager {
    private InputManager inputManager;
    private static KeyManager instance;
    
    private KeyManager(){
        
    }
        
    public void attachKeyBindings (String... actions) {
        for (String action : actions) {
            //create an array of KeyTriggers of the appropriete size
            KeyTrigger[] mappings = new KeyTrigger[KeyBindings.getTrigger(action).size()];
            //get all mappings associated with the action
            KeyBindings.getTrigger(action).toArray(mappings);
            //add key and mappings to input
            inputManager.addMapping(action, mappings);
        }
    }
    
    public void registerListener (ActionListener actionListener, String... actions) {
        inputManager.addListener(actionListener, actions);
    }

    public static synchronized KeyManager getInstance(){
        if (instance == null){
            instance = new KeyManager();
        }
        return instance;
    }    
}
