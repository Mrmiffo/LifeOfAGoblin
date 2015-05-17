/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.jME3.controller;

import com.jme3.input.KeyInput;
import com.jme3.input.KeyNames;
import com.jme3.input.RawInputListener;
import com.jme3.input.event.JoyAxisEvent;
import com.jme3.input.event.JoyButtonEvent;
import com.jme3.input.event.KeyInputEvent;
import com.jme3.input.event.MouseButtonEvent;
import com.jme3.input.event.MouseMotionEvent;
import com.jme3.input.event.TouchEvent;
import de.lessvoid.nifty.Nifty;
import de.lessvoid.nifty.controls.Controller;
import de.lessvoid.nifty.elements.Element;
import de.lessvoid.nifty.elements.render.TextRenderer;
import de.lessvoid.nifty.input.NiftyInputEvent;
import de.lessvoid.nifty.screen.Screen;
import de.lessvoid.xml.xpp3.Attributes;
import edu.chl.LifeOfAGoblin.jME3.utils.InputManagerWrapper;
import java.util.Properties;

/**
 *
 * @author Anton
 */
public class ChangeKeyBindMenuItemController implements Controller, RawInputListener{
    private Element textBox;
    private boolean listenToInput;
    private KeyNames keyNames;
    private String originalValue;
    
    //Method run when user press the input field
    public void changeBind(){
        if (!listenToInput){
            textBox.getRenderer(TextRenderer.class).getOriginalText();
            beginInput();
        }
    }
    
    @Override
    public void bind(Nifty nifty, Screen screen, Element element, Properties parameter, Attributes controlDefinitionAttributes) {
        this.textBox = element;
        keyNames = new KeyNames();
    }

    @Override
    public void init(Properties parameter, Attributes controlDefinitionAttributes) {
        
    }

    @Override
    public void onStartScreen() {
        
    }

    @Override
    public void onFocus(boolean getFocus) {
        
    }


    @Override
    public boolean inputEvent(NiftyInputEvent inputEvent) {
        return false;
    }

    @Override
    public void beginInput() {
        listenToInput = true;
        InputManagerWrapper.getInstance().addRawInputListener(this);
    }

    @Override
    public void endInput() {
        listenToInput = false;
        InputManagerWrapper.getInstance().removeRawInputListener(this);
    }

    @Override
    public void onJoyAxisEvent(JoyAxisEvent evt) {
        
    }

    @Override
    public void onJoyButtonEvent(JoyButtonEvent evt) {
        
    }

    @Override
    public void onMouseMotionEvent(MouseMotionEvent evt) {
        
    }

    @Override
    public void onMouseButtonEvent(MouseButtonEvent evt) {
        //TODO Implement
    }

    @Override
    public void onKeyEvent(KeyInputEvent evt) {
        int newKey = evt.getKeyCode();
        if (newKey == KeyInput.KEY_RETURN){
            textBox.getParent().findElementByName("#actionField").getRenderer(TextRenderer.class).getOriginalText();
            endInput();
        } else textBox.getRenderer(TextRenderer.class).setText(keyNames.getName(newKey));
        
    }

    @Override
    public void onTouchEvent(TouchEvent evt) {
        
    }
    
}
