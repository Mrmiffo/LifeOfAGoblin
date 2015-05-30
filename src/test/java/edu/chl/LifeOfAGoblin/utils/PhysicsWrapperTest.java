/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.utils;

import com.jme3.bullet.control.GhostControl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;



/**
 *
 * @author fredrik
 */
public class PhysicsWrapperTest {
        
    public PhysicsWrapperTest() {
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

    @Test
    public void testAdd_PhysicsControl() {
    }

    @Test
    public void testAddCollisionListener() {
    }

    @Test
    public void testAdd_PhysicsTickListener() {
    }

} 