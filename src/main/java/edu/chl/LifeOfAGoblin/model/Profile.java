/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author kakan
 */
public class Profile implements Serializable{
    private String profileName;
    private Progress progress;
    private HashMap<Actions, HashMap<Integer, InputDevice>> customBindings;
    private static Profile activeProfile;
    private static List<Profile> listOfProfiles;
    
    public Profile(String profileName) {
        this.profileName = profileName;
        listOfProfiles.add(this);
    }
    
    /**
     * Replaces the current name associated with the profile with the new name.
     * @param newName the name with which the profile will be associated with.
     */
    public void rename(String newName) {
        profileName = newName;
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
    public void setCustomBindings(HashMap<Actions, HashMap<Integer, InputDevice>> customBindings) {
        this.customBindings = new HashMap<>(customBindings);
    }
    
    /**
     * Returns the current key bindings associated with the profile.
     * @return the mapping of the current key bindings.
     */
    public HashMap<Actions, HashMap<Integer, InputDevice>> getCustomBindings() {
        return (HashMap<Actions, HashMap<Integer, InputDevice>>) customBindings.clone();
    }
    
    /**
     * Adds a new key binding to the specified action.
     * @param action the action which to add the key binding to.
     * @param keyCode the key code of the new key binding.
     * @param inputDevice the input device used for the key binding-
     */
    public void addCustomBinding(Actions action, Integer keyCode, InputDevice inputDevice) {
        customBindings.get(action).put(keyCode, inputDevice);
    }
    
    /**
     * Removes an existing key binding from the specified action.
     * @param action the action which to remove the key binding from.
     * @param keyCode the key code of the to-be removed key binding.
     * @param inputDevice the input device used by the to-be removed key binding.
     */
    public void removeCustomBinding(Actions action, Integer keyCode, InputDevice inputDevice) {
        if (customBindings.get(action).get(keyCode) == inputDevice) {
            customBindings.get(action).remove(keyCode);
        }
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
        activeProfile = profile;
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
}
