/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.model;

import edu.chl.LifeOfAGoblin.model.character.Minion;
import edu.chl.LifeOfAGoblin.model.character.Player;
import edu.chl.LifeOfAGoblin.model.NodeType;
import edu.chl.LifeOfAGoblin.model.abstractClass.AbstractGameObject;
import edu.chl.LifeOfAGoblin.model.interfaces.ICollidable;
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
public class PlayerTest {
    
    public PlayerTest() {
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
        Player player1 = new Player();
        AbstractGameObject player2 = new Player();
        
        //tests that a player's nodetype is player
        assertTrue(player1.getNodeType().equals(NodeType.PLAYER));
        assertTrue(player2.getNodeType().equals(NodeType.PLAYER));
    }

    @Test
    public void testCollide_ICollidable() {
        //Setup
        Player player1 = new Player();
        Player player2 = new Player();
        int maxHealth = player1.getHealth();
        
        
        //tests that collide works
        player1.collide((ICollidable)new Minion());
        assertTrue(player1.isInvulnerable());
        assertTrue(player1.getHealth()<maxHealth);
        
        //tests that a player does not take damage from nonNPCs
        player2.collide(new Checkpoint(1,1,1.0f));
        assertFalse(player2.isInvulnerable());
        assertFalse(player2.getHealth()<maxHealth);        
        
        
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

}