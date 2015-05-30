/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.jME3.controller;

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
@Suite.SuiteClasses({edu.chl.LifeOfAGoblin.jME3.controller.nifty.NiftySuite.class, edu.chl.LifeOfAGoblin.jME3.controller.character.CharacterSuite.class, edu.chl.LifeOfAGoblin.jME3.controller.CollisionListenerTest.class, edu.chl.LifeOfAGoblin.jME3.controller.ModelControlTest.class, edu.chl.LifeOfAGoblin.jME3.controller.SpawnControlTest.class})
public class ControllerSuite {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}