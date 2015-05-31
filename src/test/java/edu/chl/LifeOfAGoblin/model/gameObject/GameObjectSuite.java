/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.model.gameObject;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author Ulrika
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({edu.chl.LifeOfAGoblin.model.gameObject.SpawnPointTest.class, edu.chl.LifeOfAGoblin.model.gameObject.CheckpointTest.class, edu.chl.LifeOfAGoblin.model.gameObject.AbstractInanimateObjectTest.class, edu.chl.LifeOfAGoblin.model.gameObject.LevelTest.class, edu.chl.LifeOfAGoblin.model.gameObject.FinalCheckpointTest.class})
public class GameObjectSuite {


    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}