/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.model.gameObject;

import edu.chl.LifeOfAGoblin.model.NodeType;
import edu.chl.LifeOfAGoblin.model.character.Minion;
import edu.chl.LifeOfAGoblin.model.character.Player;
import edu.chl.LifeOfAGoblin.model.profile.Profile;
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
public class SpawnPointTest1 {
    
    public SpawnPointTest1() {
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
    public void testCollide() {
    //setup 
    Profile testProfile = new Profile("testProfile");
    Profile.setActiveProfile(testProfile);
    SpawnPoint sp1 = new SpawnPoint(1, new Minion(), 1.0f);
    SpawnPoint sp2 = new SpawnPoint(2, new Minion(), 1);

    // tests that collide is not run on an activated spawnpoint
    sp1.collide(new Player());
    sp2.activate();
    sp2.collide(new Player());
    assertTrue(Profile.getActiveProfile().getProgress().getLastVisitedCheckpoint()==1);
    assertTrue(Profile.getActiveProfile().getProgress().getLastVisitedLevel()==1);

    // Tests that collide is not run on collisions with something that 
    // is not a player.
    sp2.collide(new Checkpoint(3,3,1.0f));
    assertTrue(Profile.getActiveProfile().getProgress().getLastVisitedCheckpoint()==1);
    assertTrue(Profile.getActiveProfile().getProgress().getLastVisitedLevel()==1);

    // tests that a spawnpoint is activated after a collision
    sp1.inactivate();
    sp1.collide(new Checkpoint(3,3,1.0f));
    assertFalse(sp1.isActivated());
    sp1.collide(new Player());
    assertTrue(sp1.isActivated());

    //tests that method can handle null input
    sp1.collide(null);

    }
}