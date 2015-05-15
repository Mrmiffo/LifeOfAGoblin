/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.model;

import com.jme3.input.KeyInput;
import com.jme3.input.MouseInput;
import com.jme3.input.controls.KeyTrigger;
import com.jme3.input.controls.MouseButtonTrigger;
import com.jme3.input.controls.Trigger;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kakan
 */
public class KeyBindings implements Serializable {
    public enum KeyBind{
        WALK_LEFT ("walkLeft", new Trigger[] {new KeyTrigger(KeyInput.KEY_A)}),
        WALK_RIGHT ("walkRight", new Trigger[] { new KeyTrigger(KeyInput.KEY_D) }),
        JUMP ("jump", new Trigger[] {
            new MouseButtonTrigger(MouseInput.BUTTON_LEFT),
            new KeyTrigger(KeyInput.KEY_W),
            new KeyTrigger(KeyInput.KEY_SPACE)
        });
        
        private final String keyBindText;
        private Trigger[] triggers;
        
        KeyBind(String keyBindText, Trigger[] triggers){
            this.keyBindText = keyBindText;
            this.triggers = triggers;
        }
        
        public String getKeyText(){
            return keyBindText;
        }
        
        public Trigger[] getTriggers() {
            return triggers;
        }
        
        public void setTriggers(Trigger[] triggers) {
            this.triggers = triggers;
        }

    }
    public static List<KeyBind> getAllEnums(){
        List<KeyBind> toReturn = new ArrayList<>();
        toReturn.add(KeyBind.WALK_LEFT);
        toReturn.add(KeyBind.WALK_RIGHT);
        toReturn.add(KeyBind.JUMP);
        return toReturn;
        
    }
}
