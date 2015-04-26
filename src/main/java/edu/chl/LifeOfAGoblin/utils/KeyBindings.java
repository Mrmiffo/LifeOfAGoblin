/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.utils;

import com.jme3.input.InputManager;
import com.jme3.input.KeyInput;
import com.jme3.input.controls.KeyTrigger;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author kakan
 */
public class KeyBindings {

    private static void removeJMEDefaultMappings(Map<String, Set<KeyTrigger>> map) {
        //TODO delete unused defaults
    }
    
    private static Map<String, Set<KeyTrigger>> getDefaultKeySettings() {
        Map<String, Set<KeyTrigger>> defaults = new HashMap<>();
        defaults.put("walkRight", makeSet(KeyInput.KEY_D));
        defaults.put("walkLeft", makeSet(KeyInput.KEY_A));
        defaults.put("jump", makeSet(KeyInput.KEY_W, KeyInput.KEY_SPACE));
        return defaults;
    }
    
    private static Set<KeyTrigger> makeSet(int... keys) {
        if (keys.length == 0) {
            return null;
        } else {
            Set<KeyTrigger> temp = new HashSet<>();
            for (int key : keys) {
                temp.add(new KeyTrigger(key));
            }
            return temp;
        }
    }
    
    public static void attachStartUpKeyBinds(InputManager inputManager) {
        Map<String, Set<KeyTrigger>> keySettings = new HashMap<>();
        removeJMEDefaultMappings(keySettings); //Start game with defaults
        keySettings = getDefaultKeySettings();
        
        //TODO replace with data from settings
        
        
        Set<String> actions = keySettings.keySet();
        for (String action : actions) {
            Set<KeyTrigger> triggers = keySettings.get(action);
            for (KeyTrigger trigger : triggers) {
                inputManager.addMapping(action, trigger);
            }
        }
    }
           
}
