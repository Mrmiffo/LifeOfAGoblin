/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.model.gameObject;

import edu.chl.LifeOfAGoblin.model.character.Minion;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ulrika
 */
public class SpawnPointTest {
    
    public SpawnPointTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }


    @Test
    public void testCollide() {
    //setup 
    SpawnPoint sp1 = new SpawnPoint(1, Minion.class, 1.0f);
    //tests that method can handle null input
    sp1.collide(null);

    }
    

    @Test
    public void testIsActivated() {
    }

    @Test
    public void testActivate() {
    }

    @Test
    public void testInactivate() {
    }

}