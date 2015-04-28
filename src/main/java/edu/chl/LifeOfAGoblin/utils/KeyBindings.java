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
    public enum KeyBind{
        WALK_LEFT ("walkLeft"),
        WALK_RIGHT ("walkRight"),
        JUMP ("jump");
        
        private final String keyBindText;
        
        KeyBind(String keyBindText){
            this.keyBindText = keyBindText;
        }
        public String getKeyText(){
            return keyBindText;
        }
    }

    
    private static Set<KeyTrigger> makeSet(int... keys) {
        if (keys.length == 0) {
            return null;
        } else {
            Set<KeyTrigger> temp = new HashSet<>();
            for (int key : keys) {
                temp.add(new KeyTrigger(key));
            }
            return temp;
        }
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
