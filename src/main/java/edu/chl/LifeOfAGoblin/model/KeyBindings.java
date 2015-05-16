/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.model;

import com.jme3.input.KeyInput;
import com.jme3.input.controls.KeyTrigger;
import com.jme3.input.controls.Trigger;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * The keybindings class contains all the actions that a player can take in the
 * game and the corresponding keys. These are registered to the inputManager.
 * @author kakan
 */
public class KeyBindings implements Serializable {
    
    public static void setDefaultKeyBindings() {
        Actions.WALK_LEFT.setTriggers(new Trigger[] {new KeyTrigger(KeyInput.KEY_A)});
        Actions.WALK_RIGHT.setTriggers(new Trigger[] { new KeyTrigger(KeyInput.KEY_D)});
        Actions.JUMP.setTriggers(new Trigger[] {new KeyTrigger(KeyInput.KEY_W), new KeyTrigger(KeyInput.KEY_SPACE)});  
        Actions.OPEN_MENU.setTriggers(new Trigger[]  {new KeyTrigger(KeyInput.KEY_P), new KeyTrigger(KeyInput.KEY_ESCAPE)});
    }
    
    public static Map<Actions, Trigger[]> getCurrentKeyBindings() {
        Map<Actions, Trigger[]> temp = new HashMap<>();
        for (Actions action: Actions.values()) {
            temp.put(action, action.getTriggers());
        }
        return temp;
    }
}
