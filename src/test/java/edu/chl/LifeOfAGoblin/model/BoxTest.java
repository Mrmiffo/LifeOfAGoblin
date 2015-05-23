/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.model;

import edu.chl.LifeOfAGoblin.model.NodeType;
import edu.chl.LifeOfAGoblin.model.abstractClass.AbstractGameObject;
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
public class BoxTest {
    
    public BoxTest() {
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
        // setup
        Box box1 = new Box("");
        AbstractGameObject box2 = new Box("");
        
        //tests that a Box's nodetype is Box
        assertTrue(box1.getNodeType().equals(NodeType.BOX));
        assertTrue(box2.getNodeType().equals(NodeType.BOX));
    }
}