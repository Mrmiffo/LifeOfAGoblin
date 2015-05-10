/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.jME3.view.niftyScreen;

import de.lessvoid.nifty.builder.ScreenBuilder;
import de.lessvoid.nifty.screen.Screen;
import edu.chl.LifeOfAGoblin.jME3.controller.GameHudController;
import edu.chl.LifeOfAGoblin.jME3.controller.MainMenuController;
import edu.chl.LifeOfAGoblin.jME3.utils.NiftyGUIWrapper;
import edu.chl.LifeOfAGoblin.jME3.view.niftyScreen.interfaces.INiftyScreen;

/**
 *
 * @author Anton
 */
public class GameHud implements INiftyScreen{

    private String gameHudName;
    private Screen gameHudScreen;
    
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
