/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.utils;

import com.jme3.input.KeyInput;

/**
 *
 * @author kakan
 */
public class KeyBindings {
    public enum KeyBind{
        WALK_LEFT ("walkLeft", KeyInput.KEY_A),
        WALK_RIGHT ("walkRight", KeyInput.KEY_D),
        JUMP ("jump", KeyInput.KEY_SPACE /*and KEY_W*/);
        
        private final String keyBindText;
        private int trigger;
        
        KeyBind(String keyBindText, int trigger){
            this.keyBindText = keyBindText;
            this.trigger = trigger;
        }
        
        public String getKeyText(){
            return keyBindText;
        }
        
        public int getTrigger() {
            return trigger;
        }
        
        public void setTrigger(int trigger) {
            this.trigger = trigger;
        }
    }
}
