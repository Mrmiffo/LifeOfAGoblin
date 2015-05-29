package edu.chl.LifeOfAGoblin.model.profile;

import com.jme3.input.KeyInput;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * A class which contains all the keybindings. Will be stored in the profile to 
 * provide it with keybindings.
 * @author Anton
 */
public class Keybindings implements Serializable{
    private HashMap<Actions, ArrayList<Keybind>> keybindings;
    private static final long serialVersionUID = -4717637321337813595L;
    
    public Keybindings(){
        setDefaultKeyBindings();
    }
    
     /**
     * Sets all key bindings to their default value.
     */
    public void setDefaultKeyBindings() {
        keybindings = new HashMap<>(); 
        keybindings.put(Actions.WALK_LEFT, new ArrayList<Keybind>() {{
            add(new Keybind(InputDevice.KEYBOARD, KeyInput.KEY_A));
        }});

        keybindings.put(Actions.WALK_RIGHT, new ArrayList<Keybind>() {{
            add(new Keybind(InputDevice.KEYBOARD, KeyInput.KEY_D));
        }});

        keybindings.put(Actions.JUMP, new ArrayList<Keybind>() {{
            add(new Keybind(InputDevice.KEYBOARD, KeyInput.KEY_W));
            add(new Keybind(InputDevice.KEYBOARD, KeyInput.KEY_SPACE));
        }});

        keybindings.put(Actions.OPEN_MENU, new ArrayList<Keybind>() {{
            add(new Keybind(InputDevice.KEYBOARD, KeyInput.KEY_P));
        }});
    }
    
    /**
     * A method to update the Actions enum with the current keybinds.
     * Called automatically when a keybind is set.
     */
    public void updateBindings(){
        for (Actions action: keybindings.keySet()){
            updateBinding(action, keybindings.get(action));
        }
    }
    
    /**
     * A method for updating a single action in the actions enum.
     * @param action the action to update
     * @param bindings the binding to connect to the action.
     */
    private void updateBinding(Actions action, ArrayList<Keybind> bindings){
        action.setKeyCodes(bindings);
    }
    
    /**
     * Sets a keybind to the saved keybinds.
     * @param action
     * @param keybinds 
     */
    public void setKeybind(Actions action, ArrayList<Keybind> keybinds){
        keybindings.put(action, keybinds);
        updateBinding(action, keybinds);
    }
}
