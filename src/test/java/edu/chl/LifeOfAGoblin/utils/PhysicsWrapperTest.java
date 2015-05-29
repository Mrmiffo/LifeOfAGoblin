/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.utils;

import com.jme3.bullet.control.GhostControl;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;



/**
 *
 * @author fredrik
 */
public class PhysicsWrapperTest {
        
    public PhysicsWrapperTest() {


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
    public void testGetInstance() {
    }

    @Test
    
    public void testAdd_Control() {

        //tests that method can handle null input
        PhysicsWrapper.getInstance().add((GhostControl)null);
    }


    @Test
    public void testRemove() {

        //tests that method can handle null input
        PhysicsWrapper.getInstance().remove(null);
    }

} 