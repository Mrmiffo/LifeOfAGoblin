/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.utils;

import com.jme3.input.InputManager;
import com.jme3.input.controls.KeyTrigger;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author kakan
 */
public class KeyBind {
    private static KeyBind instance;
    private Map<String, Set<KeyTrigger>> keySettings;
    private InputManager inputManager;  //How get?

    
    private KeyBind(){
        removeDefaultMappings();
        
        Set<String> actions = keySettings.keySet();
        for (String action : actions) {
            Set<KeyTrigger> triggers = keySettings.get(action);
            for (KeyTrigger trigger : triggers) {
                inputManager.addMapping(action, trigger);
            }
        }
    }

    public static synchronized KeyBind getInstance(){
        if (instance == null){
            instance = new KeyBind();
        }
        return instance;
    }

    private void removeDefaultMappings() {
        inputManager.deleteMapping("INPUT_MAPPING_HIDE_STATS");
        inputManager.deleteMapping("INPUT_MAPPING_CAMERA_POS");
        inputManager.deleteMapping("INPUT_MAPPING_MEMORY");
    }
}
