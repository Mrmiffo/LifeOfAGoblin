/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.jME3;

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
@Suite.SuiteClasses({edu.chl.LifeOfAGoblin.jME3.view.ViewSuite.class, edu.chl.LifeOfAGoblin.jME3.controller.ControllerSuite.class, edu.chl.LifeOfAGoblin.jME3.game.GameSuite.class, edu.chl.LifeOfAGoblin.jME3.factory.FactorySuite.class})
public class JME3Suite {

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