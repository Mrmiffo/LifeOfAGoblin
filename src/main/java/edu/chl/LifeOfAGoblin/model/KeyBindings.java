/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.model;

import com.jme3.input.KeyInput;
import com.jme3.input.controls.KeyTrigger;
import com.jme3.input.controls.MouseButtonTrigger;
import com.jme3.input.controls.Trigger;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * The keybindings class contains all the actions that a player can take in the
 * game and the corresponding keys. These are registered to the inputManager.
 * @author kakan
 */
public class KeyBindings implements Serializable {
    
    public static void setDefaultKeyBindings() {

        Actions.WALK_LEFT.setKeyCodes(new HashMap<Integer, InputDevice>() {{
            put(KeyInput.KEY_A, InputDevice.KEYBOARD);
        }});
        
        Actions.WALK_RIGHT.setKeyCodes(new HashMap<Integer, InputDevice>() {{
            put(KeyInput.KEY_D, InputDevice.KEYBOARD);
        }});
        
        Actions.JUMP.setKeyCodes(new HashMap<Integer, InputDevice>() {{
            put(KeyInput.KEY_W, InputDevice.KEYBOARD);
            put(KeyInput.KEY_SPACE, InputDevice.KEYBOARD);
        }});
        
        Actions.OPEN_MENU.setKeyCodes(new HashMap<Integer, InputDevice>() {{
            put(KeyInput.KEY_P, InputDevice.KEYBOARD);
            put(KeyInput.KEY_ESCAPE, InputDevice.KEYBOARD);
        }});
    }
    
    public static Map<Actions, Trigger[]> getCurrentKeyBindings() {
        Map<Actions, Trigger[]> temp = new HashMap<>();
        for (Actions action: Actions.values()) {
            temp.put(action, integersToTriggers(action.getKeyCodes()));
        }
        return temp;
    }
    
    public static Integer[] triggersToIntegers(Trigger... triggers) {
        ArrayList<Integer> temp = new ArrayList<>();
        for (Trigger trigger: triggers) {
            temp.add(trigger.triggerHashCode());
        }
        return (Integer[])temp.toArray();
    }
    

    
    public static Trigger[] integersToTriggers(Map<Integer, InputDevice> integers) {
        ArrayList<Trigger> temp = new ArrayList<>();
        for (Integer i: integers.keySet()) {
            switch(integers.get(i)) {
                case KEYBOARD:
                    temp.add(new KeyTrigger(i));
                    break;
                case MOUSE_BUTTON:
                    temp.add(new MouseButtonTrigger(i));
            }
        }
        Trigger[] temp2 = new Trigger[1];
        return temp.toArray(temp2);
    }
}
