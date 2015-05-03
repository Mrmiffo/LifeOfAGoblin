/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.state;


import com.jme3.app.Application;
import com.jme3.app.SimpleApplication;
import com.jme3.app.state.AbstractAppState;
import com.jme3.app.state.AppStateManager;
import com.jme3.asset.AssetManager;
import com.jme3.asset.plugins.FileLocator;
import com.jme3.niftygui.NiftyJmeDisplay;
import de.lessvoid.nifty.Nifty;
import de.lessvoid.nifty.builder.ImageBuilder;
import de.lessvoid.nifty.builder.LayerBuilder;
import de.lessvoid.nifty.builder.PanelBuilder;
import de.lessvoid.nifty.builder.ScreenBuilder;
import de.lessvoid.nifty.builder.TextBuilder;
import de.lessvoid.nifty.controls.button.builder.ButtonBuilder;
import edu.chl.LifeOfAGoblin.controller.MainMenuController;
import java.io.File;



/**
 *
 * @author Anton
 */
public class MainMenuAppState extends AbstractAppState {
    Nifty nifty;
    String mainMenuName;
    AssetManager assetManager;
    
    public MainMenuAppState(){
    }
    @Override
    public void initialize(AppStateManager stateManager, Application app) {
        super.initialize(stateManager, app);
        assetManager = app.getAssetManager();

        
        NiftyJmeDisplay niftyDisplay = new NiftyJmeDisplay(
                app.getAssetManager(), app.getInputManager(), app.getAudioRenderer(), app.getGuiViewPort());
        nifty = niftyDisplay.getNifty();
        app.getGuiViewPort().addProcessor(niftyDisplay);
        ((SimpleApplication)app).getFlyByCamera().setDragToRotate(true);
        
        nifty.setDebugOptionPanelColors(true);
        nifty.loadStyleFile("nifty-default-styles.xml");
        nifty.loadControlFile("nifty-default-controls.xml");        
        mainMenuName = "mainMenu";
        setupMainMenu(mainMenuName);
        nifty.gotoScreen(mainMenuName);
        
        
    }
    
    @Override
    public void cleanup() {
        //Exits nifty when removed from state. Not good if we intend to use a hud instead... Although only removeing the mainMenu cause nullpointer exeption in the render loop.
        nifty.exit();
    }
    
    @Override
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
    }
    
    @Override
    public void update(float tpf) {
        
    }

    private void setupMainMenu(String mainMenuName) {
        assetManager.registerLocator("src" + File.separator + "main" + File.separator + "java" + File.separator + "edu" + File.separator + "chl" + File.separator + "LifeOfAGoblin" + File.separator + "assets" + File.separator + "textures", FileLocator.class);     
        final MainMenuController niftyController = new MainMenuController(this);
        nifty.addScreen(mainMenuName, new ScreenBuilder(mainMenuName) {{
            controller(niftyController);
            
            layer(new LayerBuilder("background") {{
                childLayoutCenter();
                
                // add image
                image(new ImageBuilder() {{
                    filename("skin.jpg");
                }});

            }});
            
            layer(new LayerBuilder("foreground") {{
                childLayoutVertical();
//                backgroundColor("#0000");
                
                panel(new PanelBuilder("panel_top") {{
                    childLayoutCenter();
                    alignCenter();
                    backgroundColor("#f008");
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
                    backgroundColor("#0f08");
                    height("50%");
                    width("75%");

                }});
                
                panel(new PanelBuilder("panel_bottom") {{
                    childLayoutHorizontal();
                    alignCenter();
                    backgroundColor("#00f8");
                    height("25%");
                    width("75%");

                    panel(new PanelBuilder("panel_bottom_left") {{
                        childLayoutCenter();
                        valignCenter();
                        backgroundColor("#44f8");
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
                        backgroundColor("#88f8");
                        height("50%");
                        width("50%");

                        // add control
                        control(new ButtonBuilder("QuitButton", "Quit") {{
                          alignCenter();
                          valignCenter();
                          height("50%");
                          width("50%");
                        }});//Quit button
                    }});//Panel bottom right
                }}); // panel bottom
            }}); //forground layer
        }}.build(nifty)); //mainMenu
    }
}
