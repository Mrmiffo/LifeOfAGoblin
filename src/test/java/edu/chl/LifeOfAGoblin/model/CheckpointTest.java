/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.model;

import com.jme3.scene.Node;
import edu.chl.LifeOfAGoblin.jME3.factory.NodeType;
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
public class CheckpointTest {
    
    public CheckpointTest() {
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
        Checkpoint cp = new Checkpoint(1, 1, 1f);
        assertTrue(cp.getNodeType().equals(NodeType.CHECKPOINT));
    }

    @Test
    public void testCollide() {
        Checkpoint cp = new Checkpoint(1, 1, 1f);
        assertFalse(cp.getIsActivated());
        cp.collide();
        assertTrue(cp.getIsActivated());
        cp.collide();
        assertTrue(cp.getIsActivated());
    }

    @Test
    public void testUpdateProgress() {
    }
}