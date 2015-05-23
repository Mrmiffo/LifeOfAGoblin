/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.model;

import edu.chl.LifeOfAGoblin.jME3.factory.NodeType;
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
public class MinionTest {
    
    public MinionTest() {
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
        Minion minion1 = new Minion();
        AbstractGameObject minion2 = new Minion();
        
        //tests that a minion's nodetype is minion
        assertTrue(minion1.getNodeType().equals(NodeType.MINION));
        assertTrue(minion2.getNodeType().equals(NodeType.MINION));
    }

}