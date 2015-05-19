/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.jME3.view.niftyScreen.controller;

import de.lessvoid.nifty.Nifty;
import de.lessvoid.nifty.elements.Element;
import de.lessvoid.nifty.elements.render.ImageRenderer;
import de.lessvoid.nifty.screen.Screen;
import de.lessvoid.nifty.screen.ScreenController;
import edu.chl.LifeOfAGoblin.jME3.utils.NiftyGUIWrapper;
import edu.chl.LifeOfAGoblin.jME3.utils.Resources;

/**
 *
 * @author Anton
 */
public class GameHudController implements ScreenController{
    private static Nifty nifty;
    private static Screen screen;
    public GameHudController() {
        
    }

    @Override
    public void bind(Nifty nifty, Screen screen) {
        this.nifty = nifty;
        this.screen = screen;
    }

    @Override
    public void onStartScreen() {

    }

    @Override
    public void onEndScreen() {
        
    }
    
    public static void updateHudHealthbar(int currentHealth, int maxHealth){
        //Loop through all the images in the healthbar.
        for (int i = 0; i<screen.findElementByName("healthPanel").getElements().size(); i++){
            //Find the image element
            Element flowerElement = screen.findElementByName("flower"+i);
            //Select which rendertype to use for the element.
            ImageRenderer flowerRenderer = flowerElement.getRenderer(ImageRenderer.class);
            //Set the filepath
            Resources.getInstance().setTempPath("images");
            String imageToAdd = "";
            //Loop through all the images and set the corresponding one depending on health and max health.
            if (i < currentHealth) {
                imageToAdd = "Red-Sticker-Flowers_transparent.png";
                flowerRenderer.setImage(NiftyGUIWrapper.getInstance().getNifty().createImage(imageToAdd, false));
            } else if (i < maxHealth){
                imageToAdd = "Red-Sticker-Flowers_transparent_greyscale.png";
                flowerRenderer.setImage(NiftyGUIWrapper.getInstance().getNifty().createImage(imageToAdd, false));
            } else {
                //If the character have less that 20 HP max, no image will be displayed.
                flowerRenderer.setImage(null);
            }
            
            
        }
    }    
}
