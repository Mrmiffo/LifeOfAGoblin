/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.jME3.utils;

import com.jme3.app.Application;
import com.jme3.niftygui.NiftyJmeDisplay;
import de.lessvoid.nifty.Nifty;

/**
 *
 * @author Anton
 */
public class NiftyGUIWrapper {
    private static NiftyGUIWrapper instance;
    private Nifty nifty;
    private NiftyGUIWrapper(){
        
    }
    
    public synchronized static NiftyGUIWrapper getInstance(){
        if (instance == null){
            instance = new NiftyGUIWrapper();
        }
        return instance;
    }
    
    public void initialize(Application app){
        NiftyJmeDisplay niftyDisplay = new NiftyJmeDisplay(
                app.getAssetManager(), app.getInputManager(), app.getAudioRenderer(), app.getGuiViewPort());
        this.nifty = niftyDisplay.getNifty();
        app.getGuiViewPort().addProcessor(niftyDisplay);
    }
}
