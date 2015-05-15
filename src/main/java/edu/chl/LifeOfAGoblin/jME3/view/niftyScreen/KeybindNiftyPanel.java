/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.jME3.view.niftyScreen;


import com.jme3.input.KeyNames;
import com.jme3.input.controls.Trigger;
import de.lessvoid.nifty.controls.ListBox;
import de.lessvoid.nifty.elements.Element;
import de.lessvoid.nifty.elements.render.TextRenderer;
import edu.chl.LifeOfAGoblin.model.KeyBindings;

/**
 *
 * @author Anton
 */
public class KeybindNiftyPanel implements ListBox.ListBoxViewConverter<KeyBindings.KeyBind> {

    @Override
    public void display(Element listBoxItem, KeyBindings.KeyBind item) {

        
        //Fetch the triggers for the keybinds
        Trigger[] keyBinds = item.getTriggers();
        
        //Create a key converter for converting the triggerhascode int to a string
        KeyNames keyNameConverter = new KeyNames();
        


        //Find the actionText column
        Element actionText = listBoxItem.findElementByName("actionField");
        //Set the text
        actionText.getRenderer(TextRenderer.class).setText(item.getKeyText());
        
        //This for loop will set the text for both the trigger field 0 and 1
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
    public int getWidth(Element element, KeyBindings.KeyBind item) {
        return 40;
    }


    
}
