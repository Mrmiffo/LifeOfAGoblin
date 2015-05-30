/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.jME3.factory;

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
@Suite.SuiteClasses({edu.chl.LifeOfAGoblin.jME3.factory.NodeFactoryTest.class, edu.chl.LifeOfAGoblin.jME3.factory.LevelNodeBuilderTest.class, edu.chl.LifeOfAGoblin.jME3.factory.CollisionObjectPainterTest.class, edu.chl.LifeOfAGoblin.jME3.factory.CharacterFactoryTest.class})
public class FactorySuite {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}