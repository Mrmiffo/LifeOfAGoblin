/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.model;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author Ulrika
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({edu.chl.LifeOfAGoblin.model.gameObject.GameObjectSuite.class, edu.chl.LifeOfAGoblin.model.AbstractGameObjectTest.class, edu.chl.LifeOfAGoblin.model.NodeTypeTest.class, edu.chl.LifeOfAGoblin.model.character.CharacterSuite.class, edu.chl.LifeOfAGoblin.model.profile.ProfileSuite.class})
public class ModelSuite {


    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}