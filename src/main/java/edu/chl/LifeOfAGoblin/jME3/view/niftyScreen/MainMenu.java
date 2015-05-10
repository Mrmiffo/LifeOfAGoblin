/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.jME3.view.niftyScreen;



import de.lessvoid.nifty.builder.ImageBuilder;
import de.lessvoid.nifty.builder.LayerBuilder;
import de.lessvoid.nifty.builder.PanelBuilder;
import de.lessvoid.nifty.builder.ScreenBuilder;
import de.lessvoid.nifty.builder.TextBuilder;
import de.lessvoid.nifty.controls.button.builder.ButtonBuilder;
import de.lessvoid.nifty.screen.Screen;
import edu.chl.LifeOfAGoblin.jME3.controller.MainMenuController;
import edu.chl.LifeOfAGoblin.jME3.utils.NiftyGUIWrapper;
import edu.chl.LifeOfAGoblin.jME3.utils.Resources;
import edu.chl.LifeOfAGoblin.jME3.view.niftyScreen.interfaces.INiftyScreen;





/**
 * Initial basic draft of a main menu, needs major rewriting when we have more time.
 * @author Anton
 */
public class MainMenu implements INiftyScreen{
    private String mainMenuName;
    private Screen screen;

    public MainMenu() {  
//        NiftyGUIWrapper.getInstance().loadStyleFile("nifty-default-styles.xml");
//        NiftyGUIWrapper.getInstance().loadControlFile("nifty-default-controls.xml");     
        mainMenuName = "mainMenu";
        setupMainMenu();
        
        
    }
    //Set up the main menu components, register the controller and sets button actions.
    private void setupMainMenu() {     
        final MainMenuController niftyController = new MainMenuController(this);
        Resources.getInstance().setTempPath("textures");
        screen = new ScreenBuilder(mainMenuName) {{
            controller(niftyController);
            
            layer(new LayerBuilder("background") {{
                childLayoutCenter();
                
                // add image
                image(new ImageBuilder() {{
                    
                    filename("skin.jpg");
                    height("100%");
                    width("100%");
                }});

            }});
            
            layer(new LayerBuilder("foreground") {{
                childLayoutVertical();
//                backgroundColor("#0000");
                
                panel(new PanelBuilder("panel_top") {{
                    childLayoutCenter();
                    alignCenter();
//                    backgroundColor("#f008");
                    height("25%");
                    width("75%");

                    // add text
//                    text(new TextBuilder() {{
//                        text("Welcome to Life of a Goblin");
//                        font("Interface/Fonts/Default.fnt");
//                        height("100%");
//                        width("100%");
//                    }});
                }}); //Panel top

                panel(new PanelBuilder("panel_mid") {{
                    childLayoutCenter();
                    alignCenter();
//                    backgroundColor("#0f08");
                    height("50%");
                    width("75%");

                }});
                
                panel(new PanelBuilder("panel_bottom") {{
                    childLayoutHorizontal();
                    alignCenter();
//                    backgroundColor("#00f8");
                    height("25%");
                    width("75%");

                    panel(new PanelBuilder("panel_bottom_left") {{
                        childLayoutCenter();
                        valignCenter();
//                        backgroundColor("#44f8");
                        height("50%");
                        width("50%");

                        // add control
                        control(new ButtonBuilder("StartButton", "Start game") {{
                          alignCenter();
                          valignCenter();
                          height("50%");
                          width("50%");
                          interactOnClick("startGame()");
                        }});

                    }});

                    panel(new PanelBuilder("panel_bottom_right") {{
                        childLayoutCenter();
                        valignCenter();
//                        backgroundColor("#88f8");
                        height("50%");
                        width("50%");

                        // add control
                        control(new ButtonBuilder("QuitButton", "Quit") {{
                          alignCenter();
                          valignCenter();
                          height("50%");
                          width("50%");
                          interactOnClick("quitGame()");
                        }});//Quit button
                    }});//Panel bottom right
                }}); // panel bottom
            }}); //forground layer
        }}.build(NiftyGUIWrapper.getInstance().getNifty()); //mainMenu
         
        
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
