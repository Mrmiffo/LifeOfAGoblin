package edu.chl.LifeOfAGoblin.test;

import com.jme3.app.SimpleApplication;
import edu.chl.LifeOfAGoblin.state.GameAppState;
import edu.chl.LifeOfAGoblin.state.MainMenuAppState;
import edu.chl.LifeOfAGoblin.utils.InputManagerWrapper;
import edu.chl.LifeOfAGoblin.utils.StateManagerWrapper;

/**
 * This class is for testing purposes only. It will recreate parts of the application in order to test new functionality.
 * @author Anton
 */
public class MarvinTest extends SimpleApplication{
    //Test character player hierarchy
    
    
    
    public static void main(String[] args){
        MarvinTest app = new MarvinTest();
        app.start();
    }

    @Override
    public void simpleInitApp() {
        //Camera
//        this.flyCam.setEnabled(false);
        InputManagerWrapper.getInstance().initialize(inputManager);
        StateManagerWrapper.getInstance().initialize(stateManager);
        GameAppState playGame = new GameAppState();
        MainMenuAppState mainMenu = new MainMenuAppState();
        stateManager.attach(mainMenu);

    }

}
