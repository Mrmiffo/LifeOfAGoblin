package edu.chl.LifeOfAGoblin.jME3.controller.nifty;

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
import edu.chl.LifeOfAGoblin.utils.InputManagerWrapper;
import edu.chl.LifeOfAGoblin.utils.KeyAndMouseNames;
import edu.chl.LifeOfAGoblin.model.profile.Actions;
import edu.chl.LifeOfAGoblin.model.profile.InputDevice;
import edu.chl.LifeOfAGoblin.model.profile.Keybind;
import java.util.Properties;

/**
 * The ChangeKeyBindMenuItemController class is a controller added to each of 
 * the textboxes in the Settings menu keybinding listbox. It listens to events 
 * from the textboxes to active a change key bind state and then to keyboard and mouse events to set the changed 
 * keybindings in the Settings Menu Controller.
 * @author Anton
 */
public class ChangeKeyBindMenuItemController implements Controller, RawInputListener{
    private Element textBox;
    private boolean listenToInput;
    private int fieldNo;
    private Screen screen;

    /**
     * Method run when user click on the textbox. Will change the text of the 
     * textbox and start listen to keyboard and mouse inputs. These inputs will be 
     * used to set the new keybind.
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

    /**
     * Sets the field to start listen to input and register the listener to the input manager.
     */
    @Override
    public void beginInput() {
        listenToInput = true;
        InputManagerWrapper.getInstance().addRawInputListener(this);
    }

    /**
     * Sets the field to stop listening to input and removes the listener from the input manager.
     */
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
        //Stop listening to inputs.
        endInput();
        //Get the event key int and translate it to a keybind.
        Keybind keybind = new Keybind(InputDevice.MOUSE_BUTTON, evt.getButtonIndex());
        //Print the key name into the textfield.
        textBox.getRenderer(TextRenderer.class).setText(KeyAndMouseNames.getInstance().getName(keybind));
        //Identify which action was changed.
        Actions action = identifyAction();
        //Register the change in the SettingsMenuController. Changes will be sent to profiel first when user press save.
        ((SettingsMenuController)screen.getScreenController()).setChangedKeyBind(action, keybind, fieldNo);
    }

    @Override
    public void onKeyEvent(KeyInputEvent evt) {
        //Stop listening to input.
        endInput();
        //Get the event key int and translate it to a keybind.
        Keybind keybind = new Keybind(InputDevice.KEYBOARD, evt.getKeyCode());
        //Print the key name into the textfield.
        textBox.getRenderer(TextRenderer.class).setText(KeyAndMouseNames.getInstance().getName(keybind));
        //Identify which action was changed.
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
