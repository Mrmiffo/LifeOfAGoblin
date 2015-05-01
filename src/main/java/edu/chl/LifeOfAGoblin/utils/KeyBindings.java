/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.utils;

import com.jme3.input.KeyInput;
import com.jme3.input.MouseInput;
import com.jme3.input.controls.KeyTrigger;
import com.jme3.input.controls.MouseButtonTrigger;
import com.jme3.input.controls.Trigger;
import java.io.Serializable;

/**
 *
 * @author kakan
 */
public class KeyBindings implements Serializable {
    public enum KeyBind{
        WALK_LEFT ("walkLeft", new KeyTrigger(KeyInput.KEY_A)),
        WALK_RIGHT ("walkRight", new KeyTrigger(KeyInput.KEY_D)),
        JUMP ("jump", new MouseButtonTrigger(MouseInput.BUTTON_LEFT /*and KEY_W*/));
        
        private final String keyBindText;
        private Trigger trigger;
        
        KeyBind(String keyBindText, Trigger trigger){
            this.keyBindText = keyBindText;
            this.trigger = trigger;
        }
        
        public String getKeyText(){
            return keyBindText;
        }
        
        public Trigger getTrigger() {
            return trigger;
        }
        
        public void setTrigger(Trigger trigger) {
            this.trigger = trigger;
        }

    }
}
