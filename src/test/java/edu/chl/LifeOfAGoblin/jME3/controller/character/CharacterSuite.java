/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.jME3.controller.character;

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
@Suite.SuiteClasses({edu.chl.LifeOfAGoblin.jME3.controller.character.AbstractMoveControlTest.class, edu.chl.LifeOfAGoblin.jME3.controller.character.PlayerMoveControlTest.class, edu.chl.LifeOfAGoblin.jME3.controller.character.PlayerHealthControlTest.class, edu.chl.LifeOfAGoblin.jME3.controller.character.NPCMoveControlTest.class, edu.chl.LifeOfAGoblin.jME3.controller.character.NPCCollisionControlTest.class, edu.chl.LifeOfAGoblin.jME3.controller.character.PhysicsTickControlTest.class})
public class CharacterSuite {

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