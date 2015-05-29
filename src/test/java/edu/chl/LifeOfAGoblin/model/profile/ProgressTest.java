/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.model.profile;

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
public class ProgressTest {
    
    public ProgressTest() {
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
    public void testUpdate() {
        //setup
        Progress progress1 = new Progress();       
        
        //tests that Update updates the fields of progress properly
        progress1.update(1, 1);
        assertTrue(progress1.getLastVisitedCheckpoint()==1);
        assertTrue(progress1.getLastVisitedLevel()==1);
        progress1.update(1, 2);
        assertTrue(progress1.getLastVisitedCheckpoint()==2); 
        
        //tests that longestProgress is updated correctly
        assertTrue(progress1.getLongestProgress()==1);
        progress1.update(2, 1);
        assertTrue(progress1.getLastVisitedLevel()==2); 
        assertTrue(progress1.getLongestProgress()==2);
        progress1.update(1, 3);
        assertTrue(progress1.getLastVisitedLevel()==1); 
        assertTrue(progress1.getLongestProgress()==2);
        
    }

}