/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.jME3.game;

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
@Suite.SuiteClasses({edu.chl.LifeOfAGoblin.jME3.game.GameAppStateTest.class, edu.chl.LifeOfAGoblin.jME3.game.MainTest.class, edu.chl.LifeOfAGoblin.jME3.game.MainMenuAppStateTest.class, edu.chl.LifeOfAGoblin.jME3.game.LifeOfAGoblinTest.class})
public class GameSuite {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}