/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.model.profile;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author Ulrika
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({edu.chl.LifeOfAGoblin.model.profile.ProgressTest.class, edu.chl.LifeOfAGoblin.model.profile.ProfileTest.class, edu.chl.LifeOfAGoblin.model.profile.KeybindingsTest.class, edu.chl.LifeOfAGoblin.model.profile.InputDeviceTest.class, edu.chl.LifeOfAGoblin.model.profile.KeybindTest.class, edu.chl.LifeOfAGoblin.model.profile.ActionsTest.class})
public class ProfileSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}