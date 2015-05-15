/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.jME3.view.niftyScreen.interfaces;

import de.lessvoid.nifty.screen.Screen;

/**
 * An interface used for setting up nifty screens.
 * @author Anton
 */
public interface INiftyScreen {
    /**
     * A method to get the screen from a custom nifty screen. The screen is used
     * to register in nifty for screen switching
     * @return the screen.
     */
    public Screen getScreen();
    /**
     * A method to get the specified name of the screen. Each screen is intended 
     * to be created only once and have a specified name. This name is used when 
     * registering the screen in nifty.
     * @return 
     */
    public String getScreenName();
}
