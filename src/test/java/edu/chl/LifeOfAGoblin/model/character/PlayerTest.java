/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.model.character;

import edu.chl.LifeOfAGoblin.model.gameObject.Checkpoint;
import edu.chl.LifeOfAGoblin.model.ICollidable;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author fredrik
 */
public class PlayerTest {
    
    public PlayerTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testCollide_ICollidable() {
        //Setup
        Player player1 = new Player();
        Player player2 = new Player();
        int maxHealth = player1.getHealth();
        
        
        //tests that collide works
        player1.collide((ICollidable)new MeleeWeapon());
        assertTrue(player1.isInvulnerable());
        assertTrue(player1.getHealth()<maxHealth);
        
        //tests that a player does not take damage from nonNPCs
        player2.collide(new Checkpoint(1,1,1.0f));
        assertFalse(player2.isInvulnerable());
        assertFalse(player2.getHealth()<maxHealth); 
        
        //tests that method can handle null input
        player2.collide((ICollidable)null);
        
        
    }

    @Test
    public void testSetInvulnerablility() {
        // setup
        Player player1 = new Player();
        
        //tests that setIsDamaged works
        assertFalse(player1.isInvulnerable());
        player1.setInvulnerablility(true);
        assertTrue(player1.isInvulnerable());
    }

    @Test
    public void testCollide_AbstractNPC() {
    }

    @Test
    public void testIsInvulnerable() {
    }

}