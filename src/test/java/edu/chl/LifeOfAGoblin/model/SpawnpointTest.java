/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.model;

import edu.chl.LifeOfAGoblin.jME3.controller.SpawnControl;
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
public class SpawnpointTest {
    
    public SpawnpointTest() {
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
    public void testGetNodeType() {
        SpawnControl spawn = new SpawnControl();
        //Spawnpoint sp = new Spawnpoint(spawn, 1,NodeType.BOSS,  1f);
        //assertTrue(sp.getNodeType().equals(NodeType.SPAWNPOINT));
    }

    @Test
    public void testCollide() {
        /*Checkpoint cp = new Checkpoint(1, 1, 1f);
        cp.collide();
        assertTrue(cp.getIsActivated());
        cp.collide();
        assertTrue(cp.getIsActivated());*/
    }
}