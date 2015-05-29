/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.model.character;

import edu.chl.LifeOfAGoblin.model.NodeType;
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
public class WeaponTest {
    
    public WeaponTest() {
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
        Weapon weapon1 = new RangedWeapon();
        Weapon weapon2 = new MeleeWeapon();
        
        //tests that a Weapon's nodetype is Weapon
        assertTrue(weapon1.getNodeType().equals(NodeType.WEAPON));
        assertTrue(weapon2.getNodeType().equals(NodeType.WEAPON));
    }

    @Test
    public void testCollide() {
    }

}