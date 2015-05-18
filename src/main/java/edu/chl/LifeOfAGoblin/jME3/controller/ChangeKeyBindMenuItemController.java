/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.jME3.controller;

import com.jme3.input.KeyNames;
import com.jme3.input.RawInputListener;
import com.jme3.input.controls.Trigger;
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
import edu.chl.LifeOfAGoblin.model.InputDevice;
import edu.chl.LifeOfAGoblin.model.KeyBindings;
import java.util.Properties;

/**
 * The ChangeKeyBindMenuItemController class is a controller added to each of 
 * the textboxes in the Settings menu keybinding listbox. It listens to events 
 * from the textboxes and then to keyboard and mouse events to set the changed 
 * keybindings in the Settings Menu Controller.
 * @author Anton
 */
public class ChangeKeyBindMenuItemController implements Controller, RawInputListener{
    private Element textBox;
    private boolean listenToInput;
    private KeyNames keyNames;
    private String originalValue;
    private SettingsMenuController controller;
    private int fieldNo;
    private Screen screen;
    

    /**
     * Method run when user click on the textbox. Will change the text of the 
     * textbox and start listen to keyboard and mouse inputs.
     */
    public void changeBind(){
        if (!listenToInput){
            textBox.getRenderer(TextRenderer.class).getOriginalText();
            textBox.getRenderer(TextRenderer.class).setText("Select button");
            beginInput();
        }
    }
    
    @Override
    public void bind(Nifty nifty, Screen screen, Element element, Properties parameter, Attributes controlDefinitionAttributes) {
        this.textBox = element;
        fieldNo = Integer.parseInt(textBox.getId().substring(12, 13));
        keyNames = new KeyNames();
        this.screen = screen;
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
        //Get the event key int and translate, via Trigger, to a String.
        int newKey = evt.getButtonIndex();
        System.out.println(newKey);
        Trigger temp = KeyBindings.integerToTrigger(newKey, InputDevice.MOUSE_BUTTON);
        endInput();
        textBox.getRenderer(TextRenderer.class).setText(temp.getName());
        String action = textBox.getParent().findElementByName("actionField").getRenderer(TextRenderer.class).getOriginalText();

        SettingsMenuController.setChangedKeyBind(action, InputDevice.MOUSE_BUTTON, fieldNo, newKey);
    }

    @Override
    public void onKeyEvent(KeyInputEvent evt) {
        //Get the event key int and translate, via KeyNames, to a String.
        int newKey = evt.getKeyCode();
        endInput();
        String action = textBox.getParent().findElementByName("actionField").getRenderer(TextRenderer.class).getOriginalText();
        textBox.getRenderer(TextRenderer.class).setText(keyNames.getName(newKey));
        //Update SettingsMenuController with the data.
        SettingsMenuController.setChangedKeyBind(action, InputDevice.KEYBOARD, fieldNo, newKey);
    }

    @Override
    public void onTouchEvent(TouchEvent evt) {
        
    }
    
}
