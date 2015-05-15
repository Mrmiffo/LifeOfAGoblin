/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.jME3.view.niftyScreen;

import de.lessvoid.nifty.builder.ScreenBuilder;
import de.lessvoid.nifty.screen.Screen;
import edu.chl.LifeOfAGoblin.jME3.controller.GameHudController;
import edu.chl.LifeOfAGoblin.jME3.utils.NiftyGUIWrapper;
import edu.chl.LifeOfAGoblin.jME3.view.niftyScreen.interfaces.INiftyScreen;

/**
 * The game hud class specifies how the game hud, which is display above the 
 * actual game during runtime, should look. It is controlled by the GameHudControll class.
 * @author Anton
 */
public class GameHud implements INiftyScreen{

    private String gameHudName;
    private Screen gameHudScreen;
    
    /**
     * Default constructor for the game hud. Will set the name and setup the hud
     * look and feel.
     */
    public GameHud(){
        gameHudName = "GameHud";
        setupGameHud();
    }
    
    @Override
    public Screen getScreen() {
        return gameHudScreen;
    }

    @Override
    public String getScreenName() {
        return gameHudName;
    }

    private void setupGameHud() {
        final GameHudController gameHudController = new GameHudController(this);
        gameHudScreen = new ScreenBuilder(gameHudName) {{
            controller(gameHudController);
            
        }}.build(NiftyGUIWrapper.getInstance().getNifty()); //mainMenu
    }

}
