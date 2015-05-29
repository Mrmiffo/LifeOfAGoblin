/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.model.abstractClass;

import edu.chl.LifeOfAGoblin.model.character.AbstractCharacter;
import edu.chl.LifeOfAGoblin.model.character.Player;
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
public class AbstractCharacterTest {
    private AbstractCharacter p;
    
    public AbstractCharacterTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        p = new Player();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testSetHealth() {
        //tests that health is set
        p.setHealth(5);
        assertTrue(p.getHealth() ==5);
        
        //tests that player dies if health is set to below 1 and that 
        //method can handle zero input
        p.setHealth(0);
        assertTrue(p.isDead());
        
        //tests that player dies if health is set to below 1 and that 
        //method can handle negative input.
        p.setIsDead(false);
        p.setHealth(-10);
        assertTrue(p.isDead());
    }

    @Test
    public void testDecreaseHealth_0args() {
        //setup
        p.setHealth(5);
        
        //tests that health is decreased with one
        p.decreaseHealth();
        assertTrue(p.getHealth() == 4);
        
        //tests that player dies if health is decreased enough
        p.setHealth(1);
        p.decreaseHealth();
        assertTrue(p.isDead());
        
    }


    @Test
    public void testIncreaseHealth_0args() {
        //setup
        p.setHealth(p.getMaxHealth()-1);
        
        //tests that health is increased
        p.increaseHealth();
        assertTrue(p.getHealth() ==(p.getMaxHealth()));
        
        //tests that a player's health cannot increase more than its maxhealth
        p.increaseHealth();
        assertTrue(p.getHealth() ==(p.getMaxHealth()));
    }




    @Test
    public void testSetMaxHealth() {
        //tests that maxhealth is changed
        p.setMaxHealth(6);
        assertTrue(p.getMaxHealth() == 6);
    }


    @Test
    public void testDie() {
        // tests that player dies
        p.die();
        assertTrue(p.isDead());
    }

    @Test
    public void testSetIsDead() {
        //tests that a player dies
        p.setIsDead(true);
        assertTrue(p.isDead());
        
        //tests that a player lives again
        p.setIsDead(false);
        assertFalse(p.isDead());
        
    }



}