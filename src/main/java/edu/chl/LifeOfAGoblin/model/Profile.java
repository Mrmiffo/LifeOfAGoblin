/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.model;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author kakan
 */
public class Profile implements Serializable{
    private String profileName;
    private Progress progress;
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
    
    public static void setActiveProfile() {
        
    }
}
