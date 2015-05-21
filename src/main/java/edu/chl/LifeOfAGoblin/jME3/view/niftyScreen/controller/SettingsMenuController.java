/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.jME3.view.niftyScreen.controller;

import de.lessvoid.nifty.Nifty;
import de.lessvoid.nifty.controls.ListBox;
import de.lessvoid.nifty.screen.Screen;
import de.lessvoid.nifty.screen.ScreenController;
import edu.chl.LifeOfAGoblin.jME3.utils.NiftyGUIWrapper;
import edu.chl.LifeOfAGoblin.model.Actions;
import edu.chl.LifeOfAGoblin.model.Keybind;
import edu.chl.LifeOfAGoblin.model.Profile;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * A controlled for the settings menu. Provides methods for the actions in the 
 * settings menu. Also remember what changes has been made among the keybinds.
 * @author Anton
 */
public class SettingsMenuController implements ScreenController{

    private Map<Actions, Map<Integer, Keybind>> changedKeyBinds;
    
    
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
        emptyKeyBindBox();
    }
    
    private void fillKeyBindBox(){
        keybindBox =  screen.findNiftyControl("keybind_box", ListBox.class);
        keybindBox.addAllItems(Arrays.asList(Actions.values()));
        
    }
    
    public void back(){
        NiftyGUIWrapper.getInstance().goToScreen("mainMenu");
    }
    
    public void save(){
        
        //Loops through all the maps in the changeKeyBinds and sends them to the active profile.
        for (Actions action: changedKeyBinds.keySet()){
            //For each action: create a list of keybinds.
            ArrayList<Keybind> keybinds = new ArrayList<>();
            //Loop through the contained map of fields and add the keybinds to the list.
            for (Integer field: changedKeyBinds.get(action).keySet()){
                keybinds.add(changedKeyBinds.get(action).get(field));
            }
            //Add the keybind to the profile.
            Profile.getActiveProfile().addCustomBinding(action, keybinds);
        }
        //Reset the changedKeyBinds and return to main menu.
        changedKeyBinds = new HashMap<>();
        back();
    }
    
    public void setChangedKeyBind(Actions action, Keybind keybind, int field){
        //Loops through the actions to see if it has been changed before.
        if (changedKeyBinds.containsKey(action)){
            //If the action exists a Map also exists and the new mapping can be added
            changedKeyBinds.get(action).put(field, keybind);
        //Else if the action has not been changed before a new map has to be created and the mapping added.
        } else {
            Map<Integer, Keybind> mapping = new HashMap<>();
            mapping.put(field, keybind);
            changedKeyBinds.put(action, mapping);
        }
    }

    private void emptyKeyBindBox() {
        keybindBox.removeAllItems(keybindBox.getItems());
    }
}
