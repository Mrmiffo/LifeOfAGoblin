/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.jME3.view.niftyScreen.controller;

import de.lessvoid.nifty.Nifty;
import de.lessvoid.nifty.controls.ListBox;
import de.lessvoid.nifty.screen.Screen;
import de.lessvoid.nifty.screen.ScreenController;
import edu.chl.LifeOfAGoblin.jME3.utils.NiftyGUIWrapper;
import edu.chl.LifeOfAGoblin.model.Profile;
import java.util.List;

/**
 *
 * @author Anton
 */
public class ProfileMenuController implements ScreenController{

    Screen screen;
    ListBox profileBox;
    
    @Override
    public void bind(Nifty nifty, Screen screen) {
        this.screen = screen;
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

    private void emptyProfiles() {
        profileBox.removeAllItems(profileBox.getItems());
    }
    
    private void reloadProfiles() {
        emptyProfiles();
        loadProfiles();
    }
    
    public void save(){
        Profile.setActiveProfile((String)profileBox.getSelection().get(0));
        back();
    }
    
    public void back(){
        NiftyGUIWrapper.getInstance().goToScreen("mainMenu");
    }
    
    public void deleteProfile() {
        //Get the selected profile
        List<String> selectedProfile = profileBox.getSelection();
        String profileName = selectedProfile.get(0);
        
        //Remove the profile from model.
        Profile.removeProfile(Profile.getProfile(profileName));

        //Reload the view.
        reloadProfiles();
    }
    
    public void createProfile() {
        //Creates a profile in model. Logic for providing a name is not provided.
        Profile profile = new Profile("Default profile " + Profile.getProfiles().size());
        Profile.addProfile(profile);
        Profile.setActiveProfile(profile);
        profile.saveProfile();
        
        //Reload the view.
        reloadProfiles();
    }
}
