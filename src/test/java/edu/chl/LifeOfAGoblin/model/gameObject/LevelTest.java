/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.model.gameObject;

import edu.chl.LifeOfAGoblin.model.AbstractGameObject;
import edu.chl.LifeOfAGoblin.model.NodeType;
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
public class LevelTest {
    
    public LevelTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
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
    public void testGetLevelName() {
        // setup
        Level lvl1 = new Level("Level1", 1,"");
        Level lvl2 = new Level("", 2,"");
        
        //tests that the correct name is returned regardless of graphical 
        //models
        assertTrue(lvl1.getLevelName().equals("Level1"));
        assertTrue(lvl2.getLevelName().equals(""));
        
    }

    @Test
    public void testGetLevelNo() {
    }

    @Test
    public void testGetBackgroundSoundName() {
    }

}