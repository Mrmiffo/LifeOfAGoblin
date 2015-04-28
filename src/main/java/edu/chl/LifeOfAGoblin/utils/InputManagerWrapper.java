/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.utils;

import com.jme3.input.InputManager;
import edu.chl.LifeOfAGoblin.controller.interfaces.IKeyListener;

/**
 * This is a wrapper clas for the inputManager intended to move actionlistener
 * registration out of the LifeOfAGoblin class.
 * @author Anton
 */
public class InputManagerWrapper {
    private static InputManagerWrapper instance;
    private static InputManager im;
    private InputManagerWrapper(){

    }
    
    public static synchronized InputManagerWrapper getInstance(){
        if (instance == null){
            instance = new InputManagerWrapper();
        }
        return instance;
    }
    
    public static void initialize(InputManager inputManager){
        im = inputManager;
    }
    
    public void registerListener(IKeyListener actionListener){
        for (KeyBindings.KeyBind keyBind : actionListener.getKeyBinds()){
            im.addListener(actionListener, keyBind.getKeyText());
        }
    }
}
