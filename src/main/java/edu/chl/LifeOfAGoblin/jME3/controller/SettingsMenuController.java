/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.jME3.controller;

import de.lessvoid.nifty.Nifty;
import de.lessvoid.nifty.controls.ListBox;
import de.lessvoid.nifty.screen.Screen;
import de.lessvoid.nifty.screen.ScreenController;
import edu.chl.LifeOfAGoblin.jME3.utils.NiftyGUIWrapper;
import edu.chl.LifeOfAGoblin.model.KeyBindings;
import java.util.Arrays;

/**
 *
 * @author Anton
 */
public class SettingsMenuController implements ScreenController{

    private Nifty nifty;
    private Screen screen;
    private ListBox keybindBox;
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
        keybindBox.addAllItems(Arrays.asList(KeyBindings.KeyBind.values()));
        
    }
    
    public void back(){
        NiftyGUIWrapper.getInstance().goToScreen("mainMenu");
    }
    
    public void save(){
        //TODO Add save logic
        back();
    }
}
