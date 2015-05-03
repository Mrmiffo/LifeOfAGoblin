/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.controller;

import de.lessvoid.nifty.Nifty;
import de.lessvoid.nifty.screen.Screen;
import de.lessvoid.nifty.screen.ScreenController;
import edu.chl.LifeOfAGoblin.state.GameAppState;
import edu.chl.LifeOfAGoblin.state.MainMenuAppState;
import edu.chl.LifeOfAGoblin.utils.StateManagerWrapper;

/**
 *
 * @author Anton
 */
public class MainMenuController implements ScreenController{
    private MainMenuAppState mainMenu;
    
    public MainMenuController(MainMenuAppState mainMenu){
        this.mainMenu = mainMenu;
    }

    @Override
    public void bind(Nifty nifty, Screen screen) {
        
    }

    @Override
    public void onStartScreen() {
        
    }

    @Override
    public void onEndScreen() {
        
    }
    
    public void startGame(){
        StateManagerWrapper.getInstance().removeState(mainMenu);
        StateManagerWrapper.getInstance().addState(new GameAppState());
        
    }
    
}
