/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.jME3.view.niftyScreen;

import de.lessvoid.nifty.builder.ImageBuilder;
import de.lessvoid.nifty.builder.LayerBuilder;
import de.lessvoid.nifty.builder.PanelBuilder;
import de.lessvoid.nifty.builder.ScreenBuilder;
import de.lessvoid.nifty.screen.Screen;
import edu.chl.LifeOfAGoblin.jME3.view.niftyScreen.controller.GameHudController;
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
    GameHudController gameHudController;
    
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
        gameHudController = new GameHudController();
        //Create the hud screen.
        gameHudScreen = new ScreenBuilder(gameHudName) {{
            //attach the controller.
            controller(gameHudController);
            //Add the foreground layer.
            layer(new LayerBuilder("foreground") {{
                childLayoutVertical();
                //Add the panel att the top which is the health bar.
                panel(new PanelBuilder("healthPanel"){{
                    alignLeft();
                    childLayoutHorizontal();
                    height("50px");
                    width("100%");
                /**Adds 20 images slots for the healthbar. The value is a "magic 
                * number" and can be set to anything. The Controller will loop 
                * through these slots and add the correct image depending on the 
                * characters' health and maxhealth.
                */
                for (int i = 0; i < 20;i++){
                    image(new ImageBuilder("flower"+i){{
                        height("50px");
                        width("50px");
                    }});
                }
//                {{
//                    Resources.getInstance().setTempPath("images");
//                    filename("Red-Sticker-Flowers_transparent.png");
//                }});
//                image(new ImageBuilder(){{
//                    Resources.getInstance().setTempPath("images");
//                    filename("Red-Sticker-Flowers_transparent_greyscale.png");
//                }});
            }});

                
            }});
        }}.build(NiftyGUIWrapper.getInstance().getNifty()); //mainMenu
    }

}
