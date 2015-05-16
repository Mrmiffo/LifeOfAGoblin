/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.jME3.utils;

import com.jme3.input.InputManager;
import edu.chl.LifeOfAGoblin.jME3.controller.interfaces.IKeyListener;
import edu.chl.LifeOfAGoblin.model.Actions;
import edu.chl.LifeOfAGoblin.model.KeyBindings;

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
        KeyBindings.setDefaultKeyBindings(); //Maybe change this
        instance.updateKeybinds();
    }
    
    /**
     * Register an actionlistoner to the input manager. This will cause the input 
     * manager to forward any requested actions. 
     * @param actionListener 
     */
    public void registerListener(IKeyListener actionListener){
        for (Actions keyBind : actionListener.getKeyBinds()){
            im.addListener(actionListener, keyBind.getKeyText());
        }
    }
    
    private void updateKeybinds() {
        for (Actions action : Actions.values()) {
            System.out.println(action.getKeyText() + KeyBindings.integersToTriggers(action.getKeyCodes()));
            im.addMapping(action.getKeyText(), KeyBindings.integersToTriggers(action.getKeyCodes()));
        }
    }
}
