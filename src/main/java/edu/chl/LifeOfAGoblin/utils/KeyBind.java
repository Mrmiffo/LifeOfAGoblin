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
public class KeyBind {
    private static KeyBind instance;
    private Map<String, Set<KeyTrigger>> keySettings;
    private InputManager inputManager;
    
    private KeyBind(InputManager inputManager) {
        this.inputManager = inputManager;
        removeDefaultMappings(); //Remove JMonkeys Defaults
        keySettings = getDefaultKeySettings(); //Start game with defaults
        //TODO replace with data from settings
        
        //add keybinding mappings to game
        Set<String> actions = keySettings.keySet();
        for (String action : actions) {
            Set<KeyTrigger> triggers = keySettings.get(action);
            for (KeyTrigger trigger : triggers) {
                inputManager.addMapping(action, trigger);
            }
        }
        
        //add keylisteners to game
        
    }

    public static synchronized KeyBind getInstance(InputManager inputManager){
        if (instance == null){
            instance = new KeyBind(inputManager);
        }
        return instance;
    }

    private void removeDefaultMappings() {
        //TODO delete unused defaults
    }
    
    private Map<String, Set<KeyTrigger>> getDefaultKeySettings() {
        Map<String, Set<KeyTrigger>> defaults = new HashMap<>();
        defaults.put("walkRight", makeSet(KeyInput.KEY_D));
        defaults.put("walkLeft", makeSet(KeyInput.KEY_A));
        defaults.put("jump", makeSet(KeyInput.KEY_W, KeyInput.KEY_SPACE));
        return defaults;
    }
    
    private Set<KeyTrigger> makeSet(int... keys) {
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
}
