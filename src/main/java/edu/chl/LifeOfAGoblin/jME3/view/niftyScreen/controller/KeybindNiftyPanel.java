/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.jME3.view.niftyScreen.controller;


import com.jme3.input.KeyNames;
import com.jme3.input.controls.Trigger;
import de.lessvoid.nifty.controls.ListBox;
import de.lessvoid.nifty.elements.Element;
import de.lessvoid.nifty.elements.render.TextRenderer;
import edu.chl.LifeOfAGoblin.jME3.utils.InputManagerWrapper;
import edu.chl.LifeOfAGoblin.model.Actions;

/**
 * The KeyBindNiftyPanel is used by the Keybind list box to translate the KeyBind
 * enum into text to display in the different panels in the list box custom control "row".
 * @author Anton
 */
public class KeybindNiftyPanel implements ListBox.ListBoxViewConverter<Actions> {

    @Override
    public void display(Element listBoxItem, Actions item) {
        //Fetch the triggers for the keybinds
        Trigger[] keyBinds = InputManagerWrapper.getInstance().integersToTriggers(item.getKeyCodes());
        
        //Create a key converter for converting the triggerhascode int to a string
        KeyNames keyNameConverter = new KeyNames();

        //Find the actionText column
        Element actionText = listBoxItem.findElementByName("actionField");
        
        //Set the text
        actionText.getRenderer(TextRenderer.class).setText(item.toString());
        
        //This loop will set the text for both the trigger field 0 and 1. (See custom control "row" in SettingsMenu.class)
        for (int i = 0; i<2; i++){
            Element triggerText = listBoxItem.findElementByName("triggerField"+i);
            String text = "";
            if (keyBinds.length > i){
                if (keyBinds[i].getName().substring(0, 7).equals("KeyCode")){
                    text = keyNameConverter.getName(keyBinds[i].triggerHashCode());
                } else {
                    text = keyBinds[i].getName();
                }

            }
            triggerText.getRenderer(TextRenderer.class).setText(text);
        }
    }

    @Override
    public int getWidth(Element element, Actions item) {
        //Not sure what this thing does so I set it to 40, and it seems to work :)
        //Supposedly this should return the pixle count for the width.
        return 40;
    }


    
}
