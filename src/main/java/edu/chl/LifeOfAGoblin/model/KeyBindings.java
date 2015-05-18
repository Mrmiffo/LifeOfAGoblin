/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.model;

import com.jme3.input.KeyInput;
import com.jme3.input.controls.KeyTrigger;
import com.jme3.input.controls.MouseButtonTrigger;
import com.jme3.input.controls.Trigger;
import static edu.chl.LifeOfAGoblin.model.InputDevice.KEYBOARD;
import static edu.chl.LifeOfAGoblin.model.InputDevice.MOUSE_BUTTON;
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

        Actions.WALK_LEFT.setKeyCodes(new HashMap<InputDevice,Integer>() {{
            put(InputDevice.KEYBOARD, KeyInput.KEY_A);
        }});
        
        Actions.WALK_RIGHT.setKeyCodes(new HashMap<InputDevice,Integer>() {{
            put(InputDevice.KEYBOARD, KeyInput.KEY_D);
        }});
        
        Actions.JUMP.setKeyCodes(new HashMap<InputDevice,Integer>() {{
            put(InputDevice.KEYBOARD, KeyInput.KEY_W);
            put(InputDevice.KEYBOARD, KeyInput.KEY_SPACE);
        }});
        
        Actions.OPEN_MENU.setKeyCodes(new HashMap<InputDevice,Integer>() {{
            put(InputDevice.KEYBOARD, KeyInput.KEY_P);
            put(InputDevice.KEYBOARD, KeyInput.KEY_ESCAPE);
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
        return temp.toArray(new Integer[1]);
    }
    
    public static Trigger[] integersToTriggers(Map<InputDevice, Integer> integers) {
        ArrayList<Trigger> temp = new ArrayList<>();
        for (InputDevice i: integers.keySet()) {
            switch(i) {
                case KEYBOARD:
                    temp.add(new KeyTrigger(integers.get(i)));
                    break;
                case MOUSE_BUTTON:
                    temp.add(new MouseButtonTrigger(integers.get(i)));
            }
        }
        return temp.toArray(new Trigger[1]);
    }
    
    public static Trigger integerToTrigger(int key, InputDevice device){
        Trigger temp = null;
            switch(device) {
                case KEYBOARD:
                    temp = new KeyTrigger(key);
                    break;
                case MOUSE_BUTTON:
                    temp = new MouseButtonTrigger(key);
            }
        return temp;
    }
    
    public static InputDevice getInputDevice(Trigger trigger) {
        if (trigger.getClass() == KeyTrigger.class) {
            return InputDevice.KEYBOARD;
        } else if (trigger.getClass() == MouseButtonTrigger.class){
            return InputDevice.MOUSE_BUTTON;
        } else {
            throw new IllegalArgumentException("In KeyBindings: getInputDevice(). Unknown input device: " + trigger.getClass());
        }
    }
    
    public static void setKeyBinding(Actions action, Trigger...triggers) {
        HashMap<InputDevice, Integer> temp = new HashMap<>();
        for (Trigger trigger: triggers) {
            temp.put(getInputDevice(trigger),triggersToIntegers(trigger)[0]);
        }
        action.setKeyCodes(temp);
        //needs to notify InputManagerWrapper in order to work
    }
    
    //relocate class.
}
