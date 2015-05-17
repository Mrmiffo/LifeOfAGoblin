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
    
    public void rename(String newName) {
        profileName = newName;
    }
    
    public String getProfileName() {
        return profileName;
    }
    
    public Progress getProgress() {
        return progress;
    }
    
    public void setCustomBindings(HashMap<Actions, HashMap<Integer, InputDevice>> customBindings) {
        this.customBindings = new HashMap<>(customBindings);
    }
    
    public HashMap<Actions, HashMap<Integer, InputDevice>> getCustomBindings() {
        return (HashMap<Actions, HashMap<Integer, InputDevice>>) customBindings.clone();
    }
    
    public void addCustomBinding(Actions action, Integer keyCode, InputDevice inputDevice) {
        customBindings.get(action).put(keyCode, inputDevice);
    }
    
    public void removeCustomBinding(Actions action, Integer keyCode, InputDevice inputDevice) {
        if (customBindings.get(action).get(keyCode) == inputDevice) {
            customBindings.get(action).remove(keyCode);
        }
    }
    
    public static Profile getProfile(String profileName) {
        for (Profile p: listOfProfiles) {
            if (p.getProfileName().equals(profileName)) {
                return p;
            }
        }
        return null;
    }
    
    public static Profile getActiveProfile() {
        return activeProfile;
    }
    
    public static void setActiveProfile(Profile profile) {
        activeProfile = profile;
    }
    
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
