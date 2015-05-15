/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.jME3.view.niftyScreen;

import de.lessvoid.nifty.builder.ControlBuilder;
import de.lessvoid.nifty.builder.ControlDefinitionBuilder;
import de.lessvoid.nifty.builder.ImageBuilder;
import de.lessvoid.nifty.builder.LayerBuilder;
import de.lessvoid.nifty.builder.PanelBuilder;
import de.lessvoid.nifty.builder.ScreenBuilder;
import de.lessvoid.nifty.builder.TextBuilder;
import de.lessvoid.nifty.controls.button.builder.ButtonBuilder;
import de.lessvoid.nifty.controls.listbox.builder.ListBoxBuilder;
import de.lessvoid.nifty.screen.Screen;
import edu.chl.LifeOfAGoblin.jME3.controller.SettingsMenuController;
import edu.chl.LifeOfAGoblin.jME3.utils.NiftyGUIWrapper;
import edu.chl.LifeOfAGoblin.jME3.utils.Resources;
import edu.chl.LifeOfAGoblin.jME3.view.niftyScreen.interfaces.INiftyScreen;


/**
 * The settings menu is called from the main menu and displays the keybinds. 
 * May later be renamed if more settings are implemented.
 * @author Anton
 */
public class SettingsMenu implements INiftyScreen{
    private String settingsMenuName;
    private Screen settingsMenu;
    private SettingsMenuController niftyController;

    /**
     * The default constructor for the settings menu. Will set the name of the 
     * menu and create all the nifty componentes needed.
     */
    public SettingsMenu(){ 
        settingsMenuName = "settingsMenu";
        setupSettingsManu();
        
    }

    @Override
    public Screen getScreen() {
        return settingsMenu;
    }

    @Override
    public String getScreenName() {
        return settingsMenuName;
    }

    private void setupSettingsManu() {
        //Create a controller for the screen.
        niftyController = new SettingsMenuController();
        //Create a custom control for the keybind box
        ControlDefinitionBuilder rowControlBuilder = new ControlDefinitionBuilder("row") {{
          panel(new PanelBuilder() {{
            childLayoutHorizontal();
            width("100%");
            alignCenter();
            text(new TextBuilder("actionField") {{
              width("30%");
              style("base-font");
            }});
            text(new TextBuilder("triggerField0") {{
              width("30%");
              style("base-font");
            }});
            text(new TextBuilder("triggerField1") {{
              width("30%");
              style("base-font");
            }});
          }});
        }};
        rowControlBuilder.registerControlDefintion(NiftyGUIWrapper.getInstance().getNifty());
        
        //Create a new nifty screen.
        settingsMenu = new ScreenBuilder(settingsMenuName) {{
            //Register the controller to the screen. Any actions taken on the screen objects will be resolved in this controller.
            controller(niftyController);
            
            //Create the background layer that covers the whole screen and set a background image.
            layer(new LayerBuilder("background") {{
                childLayoutCenter();
                
                // add image
                image(new ImageBuilder() {{
                    Resources.getInstance().setTempPath("images");
                    filename("forest-wallpaper-free-picture.jpg");
                    height("100%");
                    width("100%");
                }});

            }});
            
            //Create a foreground which covers the whole screen which will contain the panels which in turn contain buttons and other objects.
            layer(new LayerBuilder("foreground") {{
                childLayoutVertical();
                
                
                //Create the top panel which will contain the menu title text.
                panel(new PanelBuilder("panel_top") {{
                    childLayoutCenter();
                    alignCenter();
                    height("10%");
                    width("75%");

                    // add title text
//                    text(new TextBuilder() {{
//                        text("Settings");
//                        font("Interface/Fonts/Default.fnt");
//                        height("100%");
//                        width("100%");
//                    }});
                }}); //Panel top

                //Create the center panel which will contain the level select field. 
                panel(new PanelBuilder("panel_mid") {{
                    childLayoutCenter();
                    alignCenter();
                    height("50%");
                    width("75%");
                    
                    //Create the List box which displays the keybinds
                    control(new ListBoxBuilder("keybind_box") {{
                        //Set the list box to use the custom "row" control (see above for the code of the control)
                        control(new ControlBuilder("row"));
                        displayItems(20);
                        selectionModeSingle();
                        hideHorizontalScrollbar();
                        optionalVerticalScrollbar();
                        width("66%");
                        height("100%");
                        childLayoutVertical();
                        //Set the list box to use the custom class KeybindNiftyPanel 
                        //to translate the addItem() call.
                        viewConverterClass(KeybindNiftyPanel.class);
                    }});
                    //TODO add keybinds box
                }});
                
                //Builds the buttom panel which contains the buttons
                panel(new PanelBuilder("panel_bottom") {{
                    childLayoutHorizontal();
                    valignCenter();
                    alignCenter();
                    height("10%");
                    width("100%");
                    paddingLeft("50%");


                    //Creates a panel which contain the start game button
                    panel(new PanelBuilder("panel_bottom_left") {{
                        childLayoutCenter();
                        alignCenter();
                        valignCenter();
                        height("100%");
                        width("25%");
                        paddingRight("10%");

                        //The back button which returns the user to the main menu.
                        control(new ButtonBuilder("backButton", "Back") {{
                            alignCenter();
                            valignCenter();
                            height("100%");
                            width("100%");
                            interactOnClick("back()");
                        }});//Back button

                    }});
                    
                    //A panel for the settings button
                    panel(new PanelBuilder("panel_bottom_right") {{
                        childLayoutCenter();
                        valignCenter();
                        height("100%");
                        width("25%");

                        //The save buttons which saves the changes
                        control(new ButtonBuilder("saveButton", "Save") {{
                            alignCenter();
                            valignCenter();
                            height("100%");
                            width("100%");
                            interactOnClick("save()");
                        }});//Save button
                    }});//Panel bottom right
                }}); // panel bottom
            }});//Layer foreground  
        }}.build(NiftyGUIWrapper.getInstance().getNifty()); //SettingsMenu screen
    }//Setup settings
}
