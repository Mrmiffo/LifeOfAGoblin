package edu.chl.LifeOfAGoblin.model.profile;

import edu.chl.LifeOfAGoblin.utils.SaveLoadManager;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * The profile class contains all the profile data of the user, such as keybinds 
 * and progress.
 * @author Anton
 */
public class Profile implements Serializable{
    private String profileName;
    private Progress progress;
    private Keybindings keybinds;
    private boolean isActiveProfile;
    private static Profile activeProfile;
    private static List<Profile> listOfProfiles = new ArrayList<>();
    private static final long serialVersionUID = -4203703890649981438L;
    
    /**
     * Creates an instance of Profile with a specified name.
     * @param profileName the name of the profile
     */
    public Profile(String profileName) {
        this.profileName = profileName;
        keybinds = new Keybindings();
        isActiveProfile = false;
        this.progress = new Progress();
    }
    
    /**
     * Replaces the current name associated with the profile with the new name.
     * The string cannot be empty.
     * @param newName the name with which the profile will be associated with.
     */
    public void rename(String newName){
        if (newName != null && !newName.isEmpty()) {
                SaveLoadManager.getInstance().deleteFile(null, profileName);
                profileName = newName;
                saveProfile();
            
        }
    }
    
    /**
     * Returns the name associated with the profile
     * @return the name of the profile.
     */
    public String getProfileName() {
        return profileName;
    }
    
    /**
     * Returns the progress associated with the profile.
     * @return the current progress of the profile.
     */
    public Progress getProgress() {
        return progress;
    }

    /**
     * Adds a new key binding to the specified action.
     * @param action the action which to add the key binding to.
     * ArrayList<Keybind> the new keybinds associated with the action.
     */
    public void addCustomBinding(Actions action, ArrayList<Keybind> newBindings){
        for(int i = 0; i<newBindings.size();i++){
            if(((Keybind)newBindings.get(i)).getKey()>1){
                keybinds.setKeybind(action, newBindings);
                saveProfile();
            }
        }
    }
    
    /**
     * Resets the saved keybindings to the default ones.
     */
    public void resetDefaultBindings(){
        keybinds.setDefaultKeyBindings();
        keybinds.updateBindings();
        saveProfile();
    }
    
    /**
     * Returns the profile associated with the profile name.
     * @param profileName the name of an existing profile.
     * @return the profile associated with the profile name. Returns null if no such profile exists.
     */ 
    public static Profile getProfile(String profileName) {
        for (Profile p: listOfProfiles) {
            if (p.getProfileName().equals(profileName)) {
                return p;
            }
        }
        return null;
    }
    
    /**
     * Returns the active profile.
     * @return the active profile.
     */
    public static Profile getActiveProfile() {
        return activeProfile;
    }
    
    /**
     * Sets the profile as the active profile.
     * @param profile the profile to be active.
     */
    public static void setActiveProfile(Profile profile){
        if(profile!=null){
            if (activeProfile != null){
                activeProfile.setIsActiveProfile(false);
            }
            activeProfile = profile;
            activeProfile.setIsActiveProfile(true);
        }
    }
    
    /**
     * Sets the isActiveProfile boolean on the profile instance.
     * @param isActive 
     */
    private void setIsActiveProfile(boolean isActive){
        isActiveProfile = isActive;
        saveProfile();
        if (isActive && keybinds != null){
            keybinds.updateBindings();
        } else if (isActive){
            throw new NullPointerException("No keybindings to load, most like due to corrupted saved file.");
        } 
    }
    
    /**
     * Returns if the profile is the active profile. Used when loading the profile list on startup.
     * @return if the specific profile is the active profile.
     */
    public boolean getIsActiveProfile(){
        return isActiveProfile;
    }
    
    /**
     * Sets the profile associated with the profile name as the active profile.
     * @param profileName the name of the profile to be active.
     */
    public static void setActiveProfile(String profileName){
        boolean exists = false;
        for (Profile p: listOfProfiles) {
            if (p.getProfileName().equals(profileName)) {
                exists = true;
                setActiveProfile(p);
            }
        }
        if (!exists) {
            throw new IllegalArgumentException("In Profile: setActiveProfile(). No profile with such name.");
        }
    }
    
    /**
     * Used to save the profile to harddrive. is called automatically everytime 
     * the profile itself is modified. Will need t be called manually when an 
     * object contained in the profile (progress) is saved or when the profile 
     * is created. Saves the profile to the default path.
     */
    public void saveProfile() {
        try {
            SaveLoadManager.getInstance().saveToFile(this, null, profileName);
        } catch (IOException ex) {
            //TODO Throw error.
            System.out.println("Life Of a Goblin IO ERROR: Unable to save profile");
        }
    }
    
    /**
     * Adds the new profile to the list of profiles.
     * @param profile 
     */
    public static void addProfile(Profile profile){
        listOfProfiles.add(profile);
    }
    
    /**
     * Removes the profile from the list of profiles.
     * @param profileToRemove 
     */
    public static void removeProfile(Profile profileToRemove){
        listOfProfiles.remove(profileToRemove);
        SaveLoadManager.getInstance().deleteFile(null, profileToRemove.getProfileName());
    }
    
    /**
     * Returns a list of all the profiles.
     * @return a list of all profiles
     */
    public static List<Profile> getProfiles(){
        return listOfProfiles;
    }
}
