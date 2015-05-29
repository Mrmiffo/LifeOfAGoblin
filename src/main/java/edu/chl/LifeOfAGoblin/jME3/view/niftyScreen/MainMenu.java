package edu.chl.LifeOfAGoblin.jME3.view.niftyScreen;

import de.lessvoid.nifty.builder.ImageBuilder;
import de.lessvoid.nifty.builder.LayerBuilder;
import de.lessvoid.nifty.builder.PanelBuilder;
import de.lessvoid.nifty.builder.ScreenBuilder;
import de.lessvoid.nifty.builder.TextBuilder;
import de.lessvoid.nifty.controls.button.builder.ButtonBuilder;
import de.lessvoid.nifty.controls.imageselect.builder.ImageSelectBuilder;
import de.lessvoid.nifty.screen.Screen;
import de.lessvoid.nifty.tools.Color;
import edu.chl.LifeOfAGoblin.jME3.controller.nifty.MainMenuController;
import edu.chl.LifeOfAGoblin.utils.NiftyGUIWrapper;
import edu.chl.LifeOfAGoblin.utils.Resources;
import edu.chl.LifeOfAGoblin.jME3.view.niftyScreen.interfaces.INiftyScreen;
import edu.chl.LifeOfAGoblin.utils.LevelManager;

/**
 * The MainMenu is the menu from which the player will select level, start the 
 * game, go to settings, profile and exit the game.
 * @author Anton
 */
public class MainMenu implements INiftyScreen{
    private String mainMenuName;
    private Screen screen;
    private MainMenuController niftyController;

    /**
     * Default constructor for the main menu. Will load all files and build all the interface components.
     * Use the getScreen to load it into nifty.
     */
    public MainMenu() {  
        //Loading default nifty visuals for buttons etc.
        NiftyGUIWrapper.getInstance().loadStyleFile("nifty-default-styles.xml");
        NiftyGUIWrapper.getInstance().loadControlFile("nifty-default-controls.xml");    
        //Decides the name of the nifty screen. Will be used to identify the screen for loading it.
        mainMenuName = "mainMenu";
        //Starts the main menu setup.
        setupMainMenu();
        
        
    }
    
    //Set up the main menu components, register the controller and sets button actions.
    private void setupMainMenu() {     
        //Create a controller for the screen.
        niftyController = new MainMenuController();
        //Create a new nifty screen.
        screen = new ScreenBuilder(mainMenuName) {{
            //Register the controller to the screen. Any actions taken on the screen objects will be resolved in this controller.
            controller(niftyController);
            
            //Create the background layer that covers the whole screen and set a background image.
            layer(new LayerBuilder("background") {{
                childLayoutCenter();
                
                // add image
                image(new ImageBuilder() {{
                    //Set a temporary path for the assetManager. (Nifty built in functionalit will use the asset manager to load the images)
                    Resources.getInstance().setTempPath("images");
                    filename("forest-wallpaper-free-picture.jpg");
                    height("100%");
                    width("100%");
                }});

            }});
            
            //Create a foreground which covers the whole screen which will contain the panels which in turn contain buttons and other objects.
            layer(new LayerBuilder("foreground") {{
                childLayoutVertical();

                //Create the top panel which will contain the game tile text and welcoming message
                panel(new PanelBuilder("panel_top") {{
                    childLayoutVertical();
                    alignCenter();
                    height("20%");
                    width("75%");

                    // add text
                    text(new TextBuilder() {{
                        text("Welcome to");
                        //Set a temporary path for the assetManager. (Nifty built in functionalit will use the asset manager to load the fonts)
                        Resources.getInstance().setTempPath("fonts");
                        font("BradleyHandITC100BOLD.fnt");
                        color(new Color(0f, 0f, 0f, 1f));
                        height("50%");
                        width("100%");
                    }});
                    text(new TextBuilder() {{
                        text("Life of a Goblin");
                        //Set a temporary path for the assetManager. (Nifty built in functionalit will use the asset manager to load the fonts)
                        Resources.getInstance().setTempPath("fonts");
                        font("BradleyHandITC100BOLD.fnt");
                        color(new Color(0f, 0f, 0.f, 1f));
                        height("50%");
                        width("100%");
                    }});
                }}); //Panel top

                //Create the center panel which will contain the level select field. 
                panel(new PanelBuilder("panel_mid") {{
                    childLayoutCenter();
                    alignCenter();
                    height("30%");
                    width("75%");
                    
                    //The level select box.
                    control(new ImageSelectBuilder("levelSelectBox") {{
                        height("100%");
                        width("50%");
                        //Set a temporary path for the assetManager. (Nifty built in functionalit will use the asset manager to load the images)
                        Resources.getInstance().setTempPath("images");
                        //Add all the images for the levels.
                        for (final String name: LevelManager.getInstance().getAllLevelNames()){
                            addImage(name + ".png");
                        }
                        pixels(100);
                    }});

                }});
                
                //Builds the buttom panel which contains the buttons
                panel(new PanelBuilder("panel_bottom") {{
                    childLayoutVertical();
                    alignCenter();
                    height("40%");
                    width("75%");
                    padding("5%");

                    //Creates a panel which contain the start game button
                    panel(new PanelBuilder("panel_bottom_top") {{
                        childLayoutCenter();
                        valignCenter();
                        height("40%");
                        width("100%");
                        padding("5%");

                        // add control
                        control(new ButtonBuilder("StartButton", "Start game") {{
                          alignCenter();
                          valignCenter();
                          height("100%");
                          width("30%");
                          interactOnClick("startGame()");
                        }});

                    }});
                    
                    //A panel for the settings button
                    panel(new PanelBuilder("panel_bottom_middle") {{
                        childLayoutCenter();
                        valignCenter();
                        height("20%");
                        width("100%");
                        padding("5%");

                        
                        // add Button for settings
                        control(new ButtonBuilder("SettingsButton", "Settings") {{
                          alignCenter();
                          valignCenter();
                          height("100%");
                          width("30%");
                          interactOnClick("settings()");
                        }});//Settings button
                    }});


                    //A panel for the profile button
                    panel(new PanelBuilder("panel_bottom_middle") {{
                        childLayoutCenter();
                        valignCenter();
                        height("20%");
                        width("100%");
                        padding("5%");

                        
                        // add Button for profile
                        control(new ButtonBuilder("ProfileButton", "Profiles") {{
                          alignCenter();
                          valignCenter();
                          height("100%");
                          width("30%");
                          interactOnClick("profile()");
                        }});//Profile button
                    }});
                    //A panel for the quit button
                    panel(new PanelBuilder("panel_bottom_bottom") {{
                        childLayoutCenter();
                        valignCenter();
                        height("20%");
                        width("100%");
                        padding("5%");

                        // add quit button
                        control(new ButtonBuilder("QuitButton", "Quit") {{
                          alignCenter();
                          valignCenter();
                          height("100%");
                          width("30%");
                          interactOnClick("quitGame()");
                        }});//Quit button
                    }});//Panel bottom bottom
                }}); // panel bottom
            }}); //forground layer
        }}.build(NiftyGUIWrapper.getInstance().getNifty()); //Build the main menu
         
        
    }
    
    @Override
    public Screen getScreen(){
        return screen;
    }
    
    @Override
    public String getScreenName(){
        return mainMenuName;
    }
}
