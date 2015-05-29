package edu.chl.LifeOfAGoblin.jME3.view.niftyScreen;

import de.lessvoid.nifty.builder.ImageBuilder;
import de.lessvoid.nifty.builder.LayerBuilder;
import de.lessvoid.nifty.builder.PanelBuilder;
import de.lessvoid.nifty.builder.ScreenBuilder;
import de.lessvoid.nifty.screen.Screen;
import de.lessvoid.nifty.tools.Color;
import edu.chl.LifeOfAGoblin.jME3.controller.nifty.GameHudController;
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
    private GameHudController gameHudController;
    /**noOfHealthDisplayed adds 20 images slots for the healthbar. The value is a "magic 
    * number" and can be set to anything. The Controller will loop 
    * through these slots and add the correct image depending on the 
    * characters' health and maxhealth.
    */
    private final int noOfHealthDisplayed = 20;
    
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

    /**
     * Creates all the components of the game hud.
     */
    private void setupGameHud() {
        gameHudController = new GameHudController();
        //Create the hud screen.
        gameHudScreen = new ScreenBuilder(gameHudName) {{
            //attach the controller.
            controller(gameHudController);
            //Create a background layer (used to flash when player take damage)
            layer(new LayerBuilder("background") {{
                childLayoutVertical();
                panel(new PanelBuilder("backgroundPanel") {{
                    backgroundColor(new Color(0, 0, 0, 0));
                    height("100%");
                    width("100%");
                }});
            }});
            //Add the foreground layer. Will be used to add the healthbar.
            layer(new LayerBuilder("foreground") {{
                childLayoutVertical();
                //Add the panel att the top which is the health bar.
                panel(new PanelBuilder("healthPanel"){{
                    alignLeft();
                    childLayoutHorizontal();
                    height("50px");
                    width("100%");
                    //Create image objects to be loaded with images to display hte health.
                    for (int i = 0; i < noOfHealthDisplayed;i++){
                        image(new ImageBuilder("flower"+i){{
                            height("50px");
                            width("50px");
                    }});
                }
            }});

                
            }});
        }}.build(NiftyGUIWrapper.getInstance().getNifty()); //Builds the screen.
    }

}
