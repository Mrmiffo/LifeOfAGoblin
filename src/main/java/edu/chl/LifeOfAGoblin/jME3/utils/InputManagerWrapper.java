/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.jME3.utils;

import com.jme3.input.InputManager;
import com.jme3.input.KeyInput;
import com.jme3.input.RawInputListener;
import com.jme3.input.controls.KeyTrigger;
import com.jme3.input.controls.MouseButtonTrigger;
import com.jme3.input.controls.Trigger;
import edu.chl.LifeOfAGoblin.jME3.controller.interfaces.IKeyListener;
import edu.chl.LifeOfAGoblin.model.Actions;
import edu.chl.LifeOfAGoblin.model.InputDevice;
import static edu.chl.LifeOfAGoblin.model.InputDevice.KEYBOARD;
import static edu.chl.LifeOfAGoblin.model.InputDevice.MOUSE_BUTTON;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * This is a wrapper clas for the inputManager intended to move actionlistener
 * registration out of the LifeOfAGoblin class.
 * @author Anton
 */
public class InputManagerWrapper {
    private static InputManagerWrapper instance;
    private KeyBindings keyBindings;
    private InputManager im;

    
    private InputManagerWrapper(){

    }
    /**
     * Basice singleton getInstance method.
     * @return 
     */
    public static synchronized InputManagerWrapper getInstance(){
        if (instance == null){
            instance = new InputManagerWrapper();
        }
        return instance;
    }
    
    /**
     * Initialized the input manager. This must be done before the singlton can be used. 
     * @param inputManager 
     */
    public void initialize(InputManager inputManager){
        this.im = inputManager;
        keyBindings = new KeyBindings();
        keyBindings.setDefaultKeyBindings(); //Maybe change this
        instance.updateKeybinds();
    }
    
    /**
     * Register an actionlistoner to the input manager. This will cause the input 
     * manager to forward any requested actions. 
     * @param actionListener 
     */
    public void registerListener(IKeyListener actionListener){
        for (Actions keyBind : actionListener.getKeyBinds()){
            im.addListener(actionListener, keyBind.toString());
        }
    }
    
    private void updateKeybinds() {
        for (Actions action : Actions.values()) {
            im.deleteMapping(action.toString());
            im.addMapping(action.toString(), keyBindings.integersToTriggers(action.getKeyCodes()));
        }
    }
    
    public void addRawInputListener(RawInputListener ril){
        im.addRawInputListener(ril);
        
    }
    
    public void removeRawInputListener(RawInputListener ril){
        im.removeRawInputListener(ril);
    }
    
    public Trigger integerToTrigger(int key, InputDevice device) {
        return keyBindings.integerToTrigger(key, device);
    }
    
    public Trigger[] integersToTriggers(Map<Integer, InputDevice> integers) {
        return keyBindings.integersToTriggers(integers);
    }
    
    

    /**
    * The keybindings class contains all the actions that a player can take in the
    * game and the corresponding keys. These are registered to the inputManager.
    * @author kakan
    */
   private class KeyBindings {

        /**
         * Sets all key bindings to their default value.
         */
        public void setDefaultKeyBindings() {

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

        /**
         * Returns a mapping of the current key bindings.
         * Each possible action is mapped to one or more triggers.
         * @return a HashMap with possible Actions as keys and their trigger(s) as value(s).
         */
        public HashMap<Actions, Trigger[]> getCurrentKeyBindings() {
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
        public Integer[] triggersToIntegers(Trigger... triggers) {
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
        public Trigger[] integersToTriggers(Map<Integer, InputDevice> integers) {
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
            return temp.toArray(new Trigger[1]);
        }

         public  Trigger integerToTrigger(int key, InputDevice device){
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

        /**
         * Returns the InputDevice associated with the Trigger.
         * @param trigger the Trigger which to analyze.
         * @return the associated InputDevice of the Trigger.
         */
        public InputDevice getInputDevice(Trigger trigger) {
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
        public void setKeyBinding(Actions action, Trigger...triggers) {
            HashMap<InputDevice, Integer> temp = new HashMap<>();
            for (Trigger trigger: triggers) {
                temp.put(getInputDevice(trigger), triggersToIntegers(trigger)[0]);
            }
            action.setKeyCodes((HashMap<Integer, InputDevice>) temp.clone());
            updateKeybinds();
        }
    }
}
