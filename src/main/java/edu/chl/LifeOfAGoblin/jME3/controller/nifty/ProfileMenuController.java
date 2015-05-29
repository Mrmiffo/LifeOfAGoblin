package edu.chl.LifeOfAGoblin.jME3.controller.nifty;

import de.lessvoid.nifty.Nifty;
import de.lessvoid.nifty.controls.ListBox;
import de.lessvoid.nifty.screen.Screen;
import de.lessvoid.nifty.screen.ScreenController;
import edu.chl.LifeOfAGoblin.jME3.utils.NiftyGUIWrapper;
import edu.chl.LifeOfAGoblin.model.Profile;
import java.util.List;

/**
 * The ProfilMenuController is the controller for the Profile menu screen.
 * This class will handle the events of the buttons in the screen.
 * @author Anton
 */
public class ProfileMenuController implements ScreenController{

    ListBox profileBox;
    
    @Override
    public void bind(Nifty nifty, Screen screen) {
        profileBox = screen.findNiftyControl("profile_box", ListBox.class);
    }

    @Override
    public void onStartScreen() {
        loadProfiles();
    }

    @Override
    public void onEndScreen() {
        emptyProfiles();
    }

    /**
     * Fetches all the profiles and displays them in the profileBox.
     */
    private void loadProfiles() {
        if (!Profile.getProfiles().isEmpty()) {
            for (Profile profile: Profile.getProfiles()){
                profileBox.addItem(profile.getProfileName());
                if (profile.getIsActiveProfile()){
                    profileBox.selectItem(profile.getProfileName());
                }
            }
            List<String> selectedProfile = profileBox.getSelection();
            if (selectedProfile.isEmpty()) {
                profileBox.selectItemByIndex(0);
            }
        }
    }

    /**
     * WIll empyt the profile box
     */
    private void emptyProfiles() {
        profileBox.removeAllItems(profileBox.getItems());
    }
    
    /**
     * Will empty and load the profile box.
     */
    private void reloadProfiles() {
        emptyProfiles();
        loadProfiles();
    }
    
    /**
     * Action for the save button. Will set the new active profile in the Profile class.
     */
    public void save(){
        Profile.setActiveProfile((String)profileBox.getSelection().get(0));
        back();
    }
    
    /**
     * Return to main menu.
     */
    public void back(){
        NiftyGUIWrapper.getInstance().goToScreen("mainMenu");
    }
    
    /**
     * Delete the profile from disk and the list of profiles.
     */
    public void deleteProfile() {
        //Get the selected profile
        List<String> selectedProfile = profileBox.getSelection();
        String profileName = selectedProfile.get(0);
        
        //Remove the profile from model.
        Profile.removeProfile(Profile.getProfile(profileName));

        //Reload the view.
        reloadProfiles();
    }
    
    /**
     * Create a new profile.
     * TODO: Add ability to change profile name on creation.
     */
    public void createProfile() {
        //Creates a profile in model. Logic for naming a profile is not provided.
        Profile profile = new Profile("Default profile " + Profile.getProfiles().size());
        Profile.addProfile(profile);
        Profile.setActiveProfile(profile);
        profile.saveProfile();
        
        //Reload the view.
        reloadProfiles();
    }
}
