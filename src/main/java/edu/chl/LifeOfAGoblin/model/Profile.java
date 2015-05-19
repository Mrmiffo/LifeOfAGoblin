/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.model;

import edu.chl.LifeOfAGoblin.utils.SaveLoadManager;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author kakan
 */
public class Profile implements Serializable{
    public static final long serialVersionUID = 1548033666660605155L;
    private String profileName;
    private Progress progress;
    private HashMap<Actions, HashMap<InputDevice, Integer>> customBindings;
    private boolean isActiveProfile;
    private static Profile activeProfile;
    private static List<Profile> listOfProfiles = new ArrayList<>();
    
    public Profile(String profileName) {
        this.profileName = profileName;
        customBindings = new HashMap();
        isActiveProfile = false;
//        listOfProfiles.add(this);
    }
    
    /**
     * Replaces the current name associated with the profile with the new name.
     * @param newName the name with which the profile will be associated with.
     */
    public void rename(String newName) {
        SaveLoadManager.getInstance().deleteFile(null, profileName);
        profileName = newName;
        saveProfile();
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
     * Replaces the current key bindings associated with the profile with new ones.
     * @param customBindings the mapping of new key bindings.
     */
    public void setCustomBindings(HashMap<Actions, HashMap<InputDevice, Integer>> customBindings) {
        this.customBindings = new HashMap<>(customBindings);
        saveProfile();
    }
    
    /**
     * Returns the current key bindings associated with the profile.
     * @return the mapping of the current key bindings.
     */
    public HashMap<Actions, HashMap<InputDevice, Integer>> getCustomBindings() {
        return (HashMap<Actions, HashMap<InputDevice, Integer>>) customBindings.clone();
    }
    
    /**
     * Adds a new key binding to the specified action.
     * @param action the action which to add the key binding to.
     * @param keyCode the key code of the new key binding.
     * @param inputDevice the input device used for the key binding-
     */
    public void addCustomBinding(Actions action, InputDevice inputDevice, Integer keyCode) {
        //Check if the action already exist, if so add the new mapping. Else create a new map for the action.
        if (customBindings.containsKey(action)){
            customBindings.get(action).put(inputDevice, keyCode);
        } else {
            HashMap<InputDevice, Integer> temp = new HashMap<>();
            temp.put(inputDevice, keyCode);
            customBindings.put(action, temp);
        }
        saveProfile();
        
    }
    
    /**
     * Removes an existing key binding from the specified action.
     * @param action the action which to remove the key binding from.
     * @param keyCode the key code of the to-be removed key binding.
     * @param inputDevice the input device used by the to-be removed key binding.
     */
    public void removeCustomBinding(Actions action, InputDevice inputDevice, Integer keyCode) {
        if (customBindings.get(action).get(inputDevice) == keyCode) {
            customBindings.get(action).remove(inputDevice);
        }
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
    public static void setActiveProfile(Profile profile) {
        if (activeProfile != null){
            activeProfile.setIsActiveProfile(false);
        }
        activeProfile = profile;
        activeProfile.setIsActiveProfile(true);
    }
    
    /**
     * Sets the isActiveProfile boolean on the profile instance.
     * @param isActive 
     */
    private void setIsActiveProfile(boolean isActive){
        isActiveProfile = isActive;
        saveProfile();
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
    public static void setActiveProfile(String profileName) {
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
    public void saveProfile(){
        SaveLoadManager.getInstance().saveToFile(this, null, profileName);
    }
    
    public static void addProfile(Profile profile){
        listOfProfiles.add(profile);
    }
    
    public static List<Profile> getProfiles(){
        return listOfProfiles;
    }
}
