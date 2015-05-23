package edu.chl.LifeOfAGoblin.jME3.view.niftyScreen.controller;

import de.lessvoid.nifty.controls.ListBox;
import de.lessvoid.nifty.elements.Element;
import de.lessvoid.nifty.elements.render.TextRenderer;
import edu.chl.LifeOfAGoblin.jME3.utils.KeyAndMouseNames;
import edu.chl.LifeOfAGoblin.model.Actions;
import edu.chl.LifeOfAGoblin.model.Keybind;
import java.util.ArrayList;

/**
 * The KeybindRowControlConverter is used by the Keybind list box to translate the Actions
 * enum into text to display in the different panels in the list box custom control "row".
 * @author Anton
 */
public class KeybindRowControlConverter implements ListBox.ListBoxViewConverter<Actions> {

    @Override
    public void display(Element listBoxItem, Actions item) {
        //Get the keybinds for the action
        ArrayList<Keybind> keybinds = item.getKeyCodes();
        
        //Find the actionText column
        Element actionText = listBoxItem.findElementByName("actionField");
        
        //Set the text to the action field.
        actionText.getRenderer(TextRenderer.class).setText(item.toString());
        
        //This loop will set the text for both the trigger field 0 and 1. (See custom control "row" in SettingsMenu.class)
        for (int i = 0; i<2; i++){
            Element triggerText = listBoxItem.findElementByName("triggerField"+i);
            String text = "";
            if (keybinds.size() > i){
                text = KeyAndMouseNames.getInstance().getName(keybinds.get(i));
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
