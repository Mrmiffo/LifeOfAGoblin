/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.model;

import edu.chl.LifeOfAGoblin.model.profile.Profile;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author fredrik
 */
public class ProfileTest {
    
    public ProfileTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        for(Profile profile: Profile.getProfiles()){
            Profile.removeProfile(profile);
        
    }
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testRename() {
    }

    @Test
    public void testAddCustomBinding() {
    }

    @Test
    public void testResetDefaultBindings() {
    }

    @Test
    public void testGetProfile() {
    }

    @Test
    public void testSetActiveProfile_Profile() {
    }

    @Test
    public void testSetActiveProfile_String() {
    }

    @Test
    public void testSaveProfile() {
    }

    @Test
    public void testAddProfile() {
    }

    @Test
    public void testRemoveProfile() {
    }

    @Test
    public void testGetProfiles() {
    }
}