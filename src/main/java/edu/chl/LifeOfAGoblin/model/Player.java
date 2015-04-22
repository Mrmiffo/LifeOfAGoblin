/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.model;


import com.jme3.bullet.control.BetterCharacterControl;
import edu.chl.LifeOfAGoblin.controller.PlayerAttackControl;
import edu.chl.LifeOfAGoblin.controller.PlayerListener;
import edu.chl.LifeOfAGoblin.model.abstractClass.AbstractCharacter;

/**
 *
 * @author Anton
 */
public class Player extends AbstractCharacter {
    
    public Player(int health, int maxHealth, PlayerListener pl){
        super("Goblin", health, maxHealth);
        character.setUserData("objectType", "Player");
        character.addControl(pl);
        character.addControl(new BetterCharacterControl(1f,1f,1f));
        character.addControl(new PlayerAttackControl());
        
    }
            
}
