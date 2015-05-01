/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.utils;

import com.jme3.input.InputManager;
import com.jme3.input.controls.KeyTrigger;
import edu.chl.LifeOfAGoblin.controller.interfaces.IKeyListener;
import edu.chl.LifeOfAGoblin.utils.KeyBindings.KeyBind;
import java.util.List;

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
    
    public static synchronized InputManagerWrapper getInstance(){
        if (instance == null){
            instance = new InputManagerWrapper();
        }
        return instance;
    }
    
    public void initialize(InputManager inputManager){
        this.im = inputManager;
        instance.updateKeybinds();
    }
    
    public void registerListener(IKeyListener actionListener){
        for (KeyBind keyBind : actionListener.getKeyBinds()){
            im.addListener(actionListener, keyBind.getKeyText());
        }
    }
    
    private void updateKeybinds() {
        for (KeyBind action : KeyBind.values()) {
            im.addMapping(action.getKeyText(), action.getTrigger());
        }
    }
}
