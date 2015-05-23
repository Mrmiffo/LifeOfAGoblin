package edu.chl.LifeOfAGoblin.jME3.view.niftyScreen;

import de.lessvoid.nifty.builder.ImageBuilder;
import de.lessvoid.nifty.builder.LayerBuilder;
import de.lessvoid.nifty.builder.PanelBuilder;
import de.lessvoid.nifty.builder.ScreenBuilder;
import de.lessvoid.nifty.builder.TextBuilder;
import de.lessvoid.nifty.controls.button.builder.ButtonBuilder;
import de.lessvoid.nifty.controls.listbox.builder.ListBoxBuilder;
import de.lessvoid.nifty.screen.Screen;
import de.lessvoid.nifty.tools.Color;
import edu.chl.LifeOfAGoblin.jME3.utils.NiftyGUIWrapper;
import edu.chl.LifeOfAGoblin.jME3.utils.Resources;
import edu.chl.LifeOfAGoblin.jME3.view.niftyScreen.controller.ProfileMenuController;
import edu.chl.LifeOfAGoblin.jME3.view.niftyScreen.interfaces.INiftyScreen;

/**
 * The profile menu is the menu in which the user selects which profile to use.
 * @author Anton
 */
public class ProfileMenu implements INiftyScreen{
    Screen screen;
    String profileMenuName;
    ProfileMenuController niftyController;
    
    /**
     * Constructor for creating the profile menu. Once run the screen is ready to
     * use.
     */
    public ProfileMenu(){
        profileMenuName = "profileMenu";
        niftyController = new ProfileMenuController();
        setupProfileMenu();
    }

    private void setupProfileMenu() {
        //Create a new nifty screen.
        screen = new ScreenBuilder(profileMenuName) {{
            //Register the controller to the screen. Any actions taken on the screen objects will be resolved in this controller.
            controller(niftyController);
            
            //Create the background layer that covers the whole screen and set a background image.
            layer(new LayerBuilder("background") {{
                childLayoutCenter();
                
                // add image
                image(new ImageBuilder() {{
                    //Set a temporary path for the assetManager. Nitfy use built in logic to find the specified file from selected path.
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

                    text(new TextBuilder() {{
                        text("Profile");
                        //Set a temporary path for the assetManager. Nitfy use built in logic to find the specified file from selected path.
                        Resources.getInstance().setTempPath("fonts");
                        font("BradleyHandITC100BOLD.fnt");
                        color(new Color(0f, 0f, 0f, 1f));
                        height("50%");
                        width("100%");
                    }});
                }}); //Panel top

                //Create the center panel which will contain the profile select field. 
                panel(new PanelBuilder("panel_mid") {{
                    childLayoutCenter();
                    alignCenter();
                    height("50%");
                    width("75%");
                    
                    //Create the List box which displays the keybinds
                    control(new ListBoxBuilder("profile_box") {{
                        displayItems(20);
                        selectionModeSingle();
                        hideHorizontalScrollbar();
                        optionalVerticalScrollbar();
                        width("66%");
                        height("100%");
                        childLayoutVertical();
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

                    //Creates a panel which contain the delete button
                    panel(new PanelBuilder("panel_bottom_left") {{
                        childLayoutCenter();
                        alignCenter();
                        valignCenter();
                        height("100%");
                        width("25%");
                        paddingRight("10%");

                        //The button which deletes the selected profile.
                        control(new ButtonBuilder("DeleteButton", "Delete profile") {{
                            alignCenter();
                            valignCenter();
                            height("100%");
                            width("100%");
                            interactOnClick("deleteProfile()");
                        }});//Back button
                    }});
                    
                    //Creates a panel which contain the add profile button
                    panel(new PanelBuilder("panel_bottom_mid_left") {{
                        childLayoutCenter();
                        alignCenter();
                        valignCenter();
                        height("100%");
                        width("25%");
                        paddingRight("10%");

                        //The button which adds another profile.
                        control(new ButtonBuilder("addButton", "Create new profile") {{
                            alignCenter();
                            valignCenter();
                            height("100%");
                            width("100%");
                            interactOnClick("createProfile()");
                        }});//Back button
                    }});

                    //Creates a panel which contain the start game button
                    panel(new PanelBuilder("panel_bottom_mid_right") {{
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
                    
                    //A panel for the select profile button
                    panel(new PanelBuilder("panel_bottom_right") {{
                        childLayoutCenter();
                        valignCenter();
                        height("100%");
                        width("25%");

                        //The select profile buttons which saves the change of profile.
                        control(new ButtonBuilder("selectButton", "Select profile") {{
                            alignCenter();
                            valignCenter();
                            height("100%");
                            width("100%");
                            interactOnClick("save()");
                        }});//Save button
                    }});//Panel bottom right
                }}); // panel bottom
            }});//Layer foreground  
        }}.build(NiftyGUIWrapper.getInstance().getNifty()); //Builds the Profile menu screen
    }//Setup profileview
    

    @Override
    public Screen getScreen() {
        return screen;
    }

    @Override
    public String getScreenName() {
        return profileMenuName;
    }
}
