/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.model.character;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author Ulrika
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({edu.chl.LifeOfAGoblin.model.character.MinionTest.class, edu.chl.LifeOfAGoblin.model.character.WeaponTest.class, edu.chl.LifeOfAGoblin.model.character.MeleeWeaponTest.class, edu.chl.LifeOfAGoblin.model.character.PlayerTest.class, edu.chl.LifeOfAGoblin.model.character.AbstractNPCTest.class, edu.chl.LifeOfAGoblin.model.character.BossTest.class, edu.chl.LifeOfAGoblin.model.character.RangedWeaponTest.class, edu.chl.LifeOfAGoblin.model.character.AbstractCharacterTest.class})
public class CharacterSuite {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}