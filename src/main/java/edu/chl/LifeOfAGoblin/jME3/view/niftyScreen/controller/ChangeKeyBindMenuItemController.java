/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.jME3.view.niftyScreen.controller;

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
import edu.chl.LifeOfAGoblin.jME3.utils.KeyAndMouseNames;
import edu.chl.LifeOfAGoblin.model.Actions;
import edu.chl.LifeOfAGoblin.model.InputDevice;
import edu.chl.LifeOfAGoblin.model.Keybind;
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
        //Get the event key int and translate it to a keybind.
        Keybind keybind = new Keybind(InputDevice.MOUSE_BUTTON, evt.getButtonIndex());
        endInput();
        //Print the key name into the textfield.
        textBox.getRenderer(TextRenderer.class).setText(KeyAndMouseNames.getInstance().getName(keybind));
        Actions action = identifyAction();
        //Register the change in the SettingsMenuController.
        ((SettingsMenuController)screen.getScreenController()).setChangedKeyBind(action, keybind, fieldNo);
    }

    @Override
    public void onKeyEvent(KeyInputEvent evt) {
        //Get the event key int and translate it to a keybind.
        Keybind keybind = new Keybind(InputDevice.KEYBOARD, evt.getKeyCode());
        //Stop listening to keys.
        endInput();
        //Print the key name into the textfield.
        textBox.getRenderer(TextRenderer.class).setText(KeyAndMouseNames.getInstance().getName(keybind));
        Actions action = identifyAction();
        //Update SettingsMenuController with the data.
        
        ((SettingsMenuController)screen.getScreenController()).setChangedKeyBind(action, keybind, fieldNo);
    }

    @Override
    public void onTouchEvent(TouchEvent evt) {
        
    }
    //Identify which action the keybind is related to.
    private Actions identifyAction() {
        String actionString = textBox.getParent().findElementByName("actionField").getRenderer(TextRenderer.class).getOriginalText();
        Actions action = Actions.findActionByName(actionString);
        return action;
    }
    
}
