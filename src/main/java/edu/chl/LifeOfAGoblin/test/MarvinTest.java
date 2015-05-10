package edu.chl.LifeOfAGoblin.test;

import com.jme3.app.SimpleApplication;
import edu.chl.LifeOfAGoblin.jME3.view.state.GameAppState;
import edu.chl.LifeOfAGoblin.jME3.view.niftyScreen.MainMenu;
import edu.chl.LifeOfAGoblin.jME3.utils.InputManagerWrapper;
import edu.chl.LifeOfAGoblin.jME3.utils.NiftyGUIWrapper;
import edu.chl.LifeOfAGoblin.jME3.utils.Resources;
import edu.chl.LifeOfAGoblin.jME3.utils.StateManagerWrapper;

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
        NiftyGUIWrapper.getInstance().initialize(this);
        InputManagerWrapper.getInstance().initialize(inputManager);
        StateManagerWrapper.getInstance().initialize(stateManager);
        Resources.getInstance().initialize(assetManager);
        
//        GameAppState playGame = new GameAppState();
        MainMenu mainMenu = new MainMenu();
        NiftyGUIWrapper.getInstance().addScreen(mainMenu.getScreenName(), mainMenu.getScreen());
        NiftyGUIWrapper.getInstance().goToScreen(mainMenu.getScreenName());
        this.getFlyByCamera().setDragToRotate(true);

    }

}
