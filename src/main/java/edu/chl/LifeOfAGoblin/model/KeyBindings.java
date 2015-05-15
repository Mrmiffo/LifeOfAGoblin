/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.model;

import com.jme3.input.KeyInput;
import com.jme3.input.controls.KeyTrigger;
import com.jme3.input.controls.Trigger;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author kakan
 */
public class KeyBindings implements Serializable {
    public enum KeyBind{
        WALK_LEFT ("walkLeft", new Trigger[] {new KeyTrigger(KeyInput.KEY_A)}),
        WALK_RIGHT ("walkRight", new Trigger[] { new KeyTrigger(KeyInput.KEY_D) }),
        JUMP ("jump", new Trigger[] {
            //new MouseButtonTrigger(MouseInput.BUTTON_LEFT),
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
    
    public static void setDefaultKeyBindings() {
        KeyBind.WALK_LEFT.setTriggers(new Trigger[] {new KeyTrigger(KeyInput.KEY_A)});
        KeyBind.WALK_RIGHT.setTriggers(new Trigger[] { new KeyTrigger(KeyInput.KEY_D)});
        KeyBind.JUMP.setTriggers(new Trigger[] {new KeyTrigger(KeyInput.KEY_W), new KeyTrigger(KeyInput.KEY_SPACE)});  
    }
    
    public static Map<KeyBind, Trigger[]> getCurrentKeyBindings() {
        Map<KeyBind, Trigger[]> temp = new HashMap<>();
        for (KeyBind action: KeyBind.values()) {
            temp.put(action, action.getTriggers());
        }
        return temp;
    }
}
