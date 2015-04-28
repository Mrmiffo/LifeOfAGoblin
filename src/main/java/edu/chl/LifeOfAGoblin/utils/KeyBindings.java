/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.utils;

import com.jme3.input.KeyInput;
import com.jme3.input.controls.KeyTrigger;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author kakan
 */
public class KeyBindings {

    private static Set<KeyTrigger> makeSet(int... triggers) {
        Set<KeyTrigger> triggerSet = new HashSet<>();
        for (int trigger : triggers) {
            triggerSet.add(new KeyTrigger(trigger));
        }
        return triggerSet;
    }
    
    public static Set<KeyTrigger> getTrigger(String action) {
        switch (action) {
            case "walkRight":                
                return makeSet(KeyInput.KEY_D); //Read from file
            case "walkLeft":
                return makeSet(KeyInput.KEY_A);
            case "jump":
                return makeSet(KeyInput.KEY_W, KeyInput.KEY_SPACE);
            default:
                return null;
        }
    }
}
