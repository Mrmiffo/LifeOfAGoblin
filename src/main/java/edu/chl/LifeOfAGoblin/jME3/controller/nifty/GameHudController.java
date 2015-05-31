package edu.chl.LifeOfAGoblin.jME3.controller.nifty;

import de.lessvoid.nifty.Nifty;
import de.lessvoid.nifty.elements.Element;
import de.lessvoid.nifty.elements.render.ImageRenderer;
import de.lessvoid.nifty.elements.render.PanelRenderer;
import de.lessvoid.nifty.screen.Screen;
import de.lessvoid.nifty.screen.ScreenController;
import de.lessvoid.nifty.tools.Color;
import edu.chl.LifeOfAGoblin.utils.NiftyGUIWrapper;
import edu.chl.LifeOfAGoblin.utils.Resources;
import java.util.Timer;
import java.util.TimerTask;

/**
 * The controller class for the game hud. Should only exist in on instance. 
 * Used to update the displayed player health and to flash the screen when the 
 * player take damage.
 * @author Anton
 */
public class GameHudController implements ScreenController{
    private static Screen screen;
    
    public GameHudController() {
        
    }

    @Override
    public void bind(Nifty nifty, Screen screen) {
        this.screen = screen;
    }

    @Override
    public void onStartScreen() {

    }

    @Override
    public void onEndScreen() {
        
    }
    
    /**
     * A method used to change how the health is displayed in the hud. 
     * @param currentHealth How many "health left" icons to display.
     * @param maxHealth  how many "health missing" icons to display.
     */
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
                //If the character have less then noOfHealthDisplayed (see GameHud class) HP max, no image will be displayed.
                flowerRenderer.setImage(null);
            }
        }
    }
    /**
     * A method used to flash the screen when the played take damage.
     */
    public static void flashOnDamage() {
        long timerDelay = 500; //Time in milliseconds
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                turnOpaque();
                this.cancel();
            }
        }, timerDelay);

        screen.findElementByName("backgroundPanel").getRenderer(PanelRenderer.class).setBackgroundColor(new Color(215/255f, 44/255f, 44/255f, 0.4f));
    }
    
    public static void turnGray() {
        screen.findElementByName("backgroundPanel").getRenderer(PanelRenderer.class).setBackgroundColor(new Color(0, 0, 0, 0.6f));
    }
    
    public static void turnOpaque() {
        screen.findElementByName("backgroundPanel").getRenderer(PanelRenderer.class).setBackgroundColor(new Color(0, 0, 0, 0));
    }
}
