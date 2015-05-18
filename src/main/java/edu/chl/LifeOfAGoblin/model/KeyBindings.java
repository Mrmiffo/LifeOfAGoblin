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
    
    /**
     * Sets all key bindings to their default value.
     */
    public static void setDefaultKeyBindings() {

        Actions.WALK_LEFT.setKeyCodes(new HashMap<InputDevice, Integer>() {{
            put(InputDevice.KEYBOARD, KeyInput.KEY_A);
        }});
        
        Actions.WALK_RIGHT.setKeyCodes(new HashMap<InputDevice, Integer>() {{
            put(InputDevice.KEYBOARD, KeyInput.KEY_D);
        }});
        
        Actions.JUMP.setKeyCodes(new HashMap<InputDevice, Integer>() {{
            put(InputDevice.KEYBOARD, KeyInput.KEY_W);
            put(InputDevice.KEYBOARD, KeyInput.KEY_SPACE);
        }});
        
        Actions.OPEN_MENU.setKeyCodes(new HashMap<InputDevice, Integer>() {{
            put(InputDevice.KEYBOARD, KeyInput.KEY_P);
            put(InputDevice.KEYBOARD, KeyInput.KEY_ESCAPE);
        }});
    }
    
    /**
     * Returns a mapping of the current key bindings.
     * Each possible action is mapped to one or more triggers.
     * @return a HashMap with possible Actions as keys and their trigger(s) as value(s).
     */
    public static HashMap<Actions, Trigger[]> getCurrentKeyBindings() {
        HashMap<Actions, Trigger[]> temp = new HashMap<>();
        for (Actions action: Actions.values()) {
            temp.put(action, integersToTriggers(action.getKeyCodes()));
        }
        return (HashMap<Actions, Trigger[]>)temp.clone();
    }
    
    /**
     * Returns the corresponing Integer value of one or more triggers.
     * @param triggers one or more Triggers.
     * @return an array with the corresponding integer value(s) of the Trigger(s).
     */
    public static Integer[] triggersToIntegers(Trigger... triggers) {
        ArrayList<Integer> temp = new ArrayList<>();
        for (Trigger trigger: triggers) {
            temp.add(trigger.triggerHashCode());
        }
        return temp.toArray(new Integer[1]);
    }
    
    /**
     * Returns the corresponding Trigger for each Integer/InputDevice pair in the Map.
     * @param integers a Map of Integer/InputDevice pairs.
     * @return an array with the corresponding Trigger(s) of the Map.
     */
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
    
    /**
     * Returns the InputDevice associated with the Trigger.
     * @param trigger the Trigger which to analyze.
     * @return the associated InputDevice of the Trigger.
     */
    public static InputDevice getInputDevice(Trigger trigger) {
        if (trigger.getClass() == KeyTrigger.class) {
            return InputDevice.KEYBOARD;
        } else if (trigger.getClass() == MouseButtonTrigger.class){
            return InputDevice.MOUSE_BUTTON;
        } else {
            throw new IllegalArgumentException("In KeyBindings: getInputDevice(). Unknown input device: " + trigger.getClass());
        }
    }
    
    /**
     * Replaces the Action's current Trigger(s) with one or more Trigger(s).
     * @param action the Action to be altered.
     * @param triggers one or more Trigger(s) which will invoke the Action.
     */
    public static void setKeyBinding(Actions action, Trigger...triggers) {
        HashMap<InputDevice, Integer> temp = new HashMap<>();
        for (Trigger trigger: triggers) {
            temp.put(getInputDevice(trigger), triggersToIntegers(trigger)[0]);
        }
        action.setKeyCodes((HashMap<InputDevice, Integer>) temp.clone());
        //needs to notify InputManagerWrapper in order to work
    }
    
    //relocate class.
}
