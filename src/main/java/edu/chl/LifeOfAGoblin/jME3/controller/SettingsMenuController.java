/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.jME3.controller;

import com.jme3.input.KeyNames;
import de.lessvoid.nifty.Nifty;
import de.lessvoid.nifty.controls.ListBox;
import de.lessvoid.nifty.screen.Screen;
import de.lessvoid.nifty.screen.ScreenController;
import edu.chl.LifeOfAGoblin.jME3.utils.NiftyGUIWrapper;
import edu.chl.LifeOfAGoblin.model.Actions;
import edu.chl.LifeOfAGoblin.model.InputDevice;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * A controlled for the settings menu. Provides methods for the actions in the 
 * settings menu. Also remember what changes has been made among the keybinds.
 * @author Anton
 */
public class SettingsMenuController implements ScreenController{

    private static Map<String, Map<Integer, Map<InputDevice, Integer>>> changedKeyBinds;
    
    
    private Nifty nifty;
    private Screen screen;
    private ListBox keybindBox;
    
    public SettingsMenuController(){
        changedKeyBinds = new HashMap<>();
    }
    
    @Override
    public void bind(Nifty nifty, Screen screen) {
       this.nifty = nifty;
       this.screen = screen;
       
    }

    @Override
    public void onStartScreen() {
        fillKeyBindBox();
    }

    @Override
    public void onEndScreen() {
        keybindBox.removeAllItems(keybindBox.getItems());
    }
    
    private void fillKeyBindBox(){
        keybindBox =  screen.findNiftyControl("keybind_box", ListBox.class);
        keybindBox.addAllItems(Arrays.asList(Actions.values()));
        
    }
    
    public void back(){
        NiftyGUIWrapper.getInstance().goToScreen("mainMenu");
    }
    
    public void save(){
        KeyNames test = new KeyNames();
        for (String s: changedKeyBinds.keySet()){
            for (int i: changedKeyBinds.get(s).keySet()){
                for (InputDevice device: changedKeyBinds.get(s).get(i).keySet()){
                    System.out.println("Action: "+s+" Field: " + i + "InputDevice: " + device.toString() + "Key: " + test.getName(changedKeyBinds.get(s).get(i).get(device)));
                }
            }
        }
        back();
    }
    
    public static void setChangedKeyBind(String action, InputDevice device, int field, int key){
        Map<Integer, Map<InputDevice, Integer>> fieldAndInput;
        Map<InputDevice, Integer> input = new HashMap<>();
        input.put(device, key);
        if (changedKeyBinds.containsKey(action)){
            fieldAndInput = changedKeyBinds.get(action);
        } else {
            fieldAndInput = new HashMap<>();
        }
        fieldAndInput.put(field, input);
        changedKeyBinds.put(action, fieldAndInput);
    }
}
