/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.model;


import edu.chl.LifeOfAGoblin.controller.PlayerAttackControl;
import edu.chl.LifeOfAGoblin.controller.PlayerMoveControl;
import edu.chl.LifeOfAGoblin.model.abstractClass.AbstractCharacter;

/**
 *
 * @author Anton
 */
public class Player extends AbstractCharacter {
    
    public Player(int health, int maxHealth){
        super("Goblin", health, maxHealth);
        character.setUserData("objectType", "Player");
        character.addControl(new PlayerMoveControl());
        character.addControl(new PlayerAttackControl());
        
    }
            
}
