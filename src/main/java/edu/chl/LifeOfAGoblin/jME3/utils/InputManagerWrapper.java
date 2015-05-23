/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.jME3.utils;

import com.jme3.input.InputManager;
import com.jme3.input.RawInputListener;
import com.jme3.input.controls.KeyTrigger;
import com.jme3.input.controls.MouseButtonTrigger;
import com.jme3.input.controls.Trigger;
import edu.chl.LifeOfAGoblin.jME3.controller.interfaces.IKeyListener;
import edu.chl.LifeOfAGoblin.model.Actions;
import edu.chl.LifeOfAGoblin.model.InputDevice;
import static edu.chl.LifeOfAGoblin.model.InputDevice.KEYBOARD;
import static edu.chl.LifeOfAGoblin.model.InputDevice.MOUSE_BUTTON;
import edu.chl.LifeOfAGoblin.model.Keybind;
import java.util.ArrayList;

/**
 * This is a wrapper clas for the inputManager intended to move actionlistener
 * registration out of the LifeOfAGoblin class.
 * @author Anton
 */
public class InputManagerWrapper {
    private static InputManagerWrapper instance;
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
    
    /**
     * A method used to register an action to be available in the inputManager.
     * The action contains the key which the inputManager should listen to and 
     * once the key is pressed the corresponding action will be triggered.
     * @param action 
     */
    public void registerAction(Actions action) {
        im.deleteMapping(action.toString());
        im.addMapping(action.toString(), TriggerConverter.keybindsToTriggers(action.getKeyCodes()));
    }
    
    /**
     * Registers a raw input listener to the input manager. 
     * Used when a class need to listen to any possible key, independent of which 
     * actions are registered.
     * @param ril the raw input listener which want to start listen.
     */
    public void addRawInputListener(RawInputListener ril){
        im.addRawInputListener(ril);
        
    }
    /*
     * Removes the speciified RawInputListener. The input listener will no longer
     * receive triggers.
     */
    public void removeRawInputListener(RawInputListener ril){
        im.removeRawInputListener(ril);
    }
 

    /**
    * The TriggerConverter class converts the model keybind to jME3 trigger.
    * @author kakan
    */
   private static class TriggerConverter {
        /**
         * Returns the corresponing Integer value of one or more triggers.
         * @param triggers one or more Triggers.
         * @return an array with the corresponding integer value(s) of the Trigger(s).
         */
        private static Keybind[] triggersToKeybinds(Trigger... triggers) {
            ArrayList<Keybind> temp = new ArrayList<>();
            for (Trigger trigger: triggers) {
                temp.add(new Keybind(getInputDevice(trigger), trigger.triggerHashCode()));
            }
            return temp.toArray(new Keybind[1]);
        }

        /**
         * Returns the corresponding Trigger for each Integer/InputDevice pair in the Map.
         * @param keybinds a Map of Integer/InputDevice pairs.
         * @return an array with the corresponding Trigger(s) of the Map.
         */
        private static Trigger[] keybindsToTriggers(ArrayList<Keybind> keybinds) {
            ArrayList<Trigger> temp = new ArrayList<>();
            for (Keybind keybind: keybinds) {
                temp.add(keybindToTrigger(keybind));
            }
            return temp.toArray(new Trigger[1]);
        }
        
        /**
         * Returns a jME3 trigger from a Keybind.
         * @param keybind the keybind to convert.
         * @return the corresponding jME3 trigger.
         */
        private static Trigger keybindToTrigger(Keybind keybind){
        Trigger temp = null;
            switch(keybind.getInputDevice()) {
                case KEYBOARD:
                    temp = new KeyTrigger(keybind.getKey());
                    break;
                case MOUSE_BUTTON:
                    temp = new MouseButtonTrigger(keybind.getKey());
            }
        return temp;
     }

        /**
         * Returns the InputDevice associated with the Trigger. Used for 
         * converting a trigger back to a Keybind.
         * @param trigger the Trigger which to analyze.
         * @return the associated InputDevice of the Trigger.
         */
        private static InputDevice getInputDevice(Trigger trigger) {
            if (trigger.getClass() == KeyTrigger.class) {
                return InputDevice.KEYBOARD;
            } else if (trigger.getClass() == MouseButtonTrigger.class){
                return InputDevice.MOUSE_BUTTON;
            } else {
                throw new IllegalArgumentException("In KeyBindings: getInputDevice(). Unknown input device: " + trigger.getClass());
            }
        }
    }
}
